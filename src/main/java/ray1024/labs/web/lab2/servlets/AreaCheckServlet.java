package ray1024.labs.web.lab2.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ray1024.labs.web.lab2.DITA.result.IDITAResult;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

@WebServlet(name = "areaCheckServlet", value = "/area-check-servlet")
public class AreaCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<table>");
        if (request.getSession().getAttribute("collection") != null) {
            LinkedList<IDITAResult> collection = (LinkedList<IDITAResult>) request.getSession().getAttribute("collection");
            if (!collection.isEmpty()) {
                writer.println("<tr><td>X</td><td>");
                writer.println(collection.getLast().getXyr().getX());
                writer.println("</td></tr><tr><td>Y</td><td>");
                writer.println(collection.getLast().getXyr().getY());
                writer.println("</td></tr><tr><td>R</td><td>");
                writer.println(collection.getLast().getXyr().getR());
                writer.println("</td></tr><tr><td>Result</td><td>");
                writer.println(collection.getLast().getResult() ? "YES" : "NO");
                writer.println("</td></tr>");
            }
        }
        writer.println("</table>");
        writer.println("<a href=\"index.jsp\">Go to main page</a>");
        writer.close();
    }
}
