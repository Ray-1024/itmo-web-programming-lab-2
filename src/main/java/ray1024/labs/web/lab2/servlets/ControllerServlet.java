package ray1024.labs.web.lab2.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ray1024.labs.web.lab2.DITA.DITARequestApplier;

import java.io.IOException;

public class ControllerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().setMaxInactiveInterval(-1);
        if (DITARequestApplier.applyRequest(request))
            getServletContext().getRequestDispatcher("/area-check-servlet").forward(request, response);
        else getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}