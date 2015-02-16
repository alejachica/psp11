package edu.uniandes.ecos.psp11.vista;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import edu.uniandes.ecos.psp11.controlador.Controlador;

/**
 * Clase que muestra el resultado del conteo de LOCs en un servidor web.
 */
public class App extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getRequestURI().endsWith("/db")) {
            showDatabase(req, resp);
        } else {
            showHome(req, resp);
        }
    }

    private void showHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        pw.write("<html>");
        pw.println("<h2>PSP1.1 Program!</h2>");
        pw.println("Ingrese la cadena de datos de prueba separanda por comas.");
        pw.println("Los decimales se separan con punto.");

        pw.println("<h3>Cadenas de ejemplo:</h3>");
        pw.println("<h3>Test 1: </h3>");
        pw.println("6.0000,6.0000,8.3333,10.3333,12.3333,16.4000,20.5000,21.7500,22.2500,23.0000,28.3333,29.0000,55.8000");

        pw.println("<h3>Test 2: </h3>");
        pw.println("7,12,10,12,10,12,12,12,12,8,8,8,20,14,18,12");

        pw.write("<form action=\"calc\" method=\"post\"> \n"
                + "    Cadena de valores: <input type=\"text\" name=\"calc\">\n"
                + "    <input type=\"submit\" value=\"Calc\">\n"
                + "</form> ");
        pw.write("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String calc = req.getParameter("calc");

        Controlador c = new Controlador();
        String resultado = c.realizarCalculos((LinkedList<Double>) splitParametros(calc));

        resp.getWriter().print("Entrega PSP1 - Alejandra Chica\n" + resultado);
    }

    private void showDatabase(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        try {
            connection = getConnection();

            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
            stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
            ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

            String out = "Hello!\n";
            while (rs.next()) {
                out += "Read from DB: " + rs.getTimestamp("tick") + "\n";
            }

            resp.getWriter().print(out);
        } catch (Exception e) {
            resp.getWriter().print("There was an error: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    private Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        int port = dbUri.getPort();

        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ":" + port + dbUri.getPath();

        return DriverManager.getConnection(dbUrl, username, password);
    }

    private List<Double> splitParametros(String parametros) {

        List<Double> listaDeNumeros = new LinkedList<Double>();

        String[] pares = parametros.split(",");

        for (String valor : pares) {
        	
            listaDeNumeros.add(Double.valueOf(valor));
        }

        return listaDeNumeros;
    }

    public static void main(String[] args) throws Exception {

 //       Server server = new Server(8081);
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new App()), "/*");
        server.start();
        server.join();
    }
}
