package rikkei.academy.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "JavaServlet", value = "/JavaServlet")
public class JavaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action");
        if (action == null){
            action = "";
        }
        System.out.println(action);
        switch (action){
            case "jv6":
                fromJv6(request,response);
                break;
            case "jv7":
                fromJv7(request,response);
                break;
            case "jv8":
                fromJv8(request,response);
                break;

        }
    }

    private void fromJv8(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/java/jv08.jsp");
        requestDispatcher.forward(request,response);
    }

    private void fromJv7(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/java/jv07.jsp");
        requestDispatcher.forward(request,response);
    }

    private void fromJv6(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/java/jv06.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
