package rikkei.academy.controller;

import com.sun.corba.se.spi.protocol.RequestDispatcherRegistry;
import rikkei.academy.model.User;
import rikkei.academy.service.IUserService;
import rikkei.academy.service.UserServiceIMPL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = {"/", "/loginServlet"})
public class ControllerLoginServlet extends HttpServlet {
    IUserService userService = new UserServiceIMPL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("view/login/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameUser = request.getParameter("user");
        String password = request.getParameter("password");
        User user = userService.findByUserNameAndPass(nameUser, password);
        if (user == null) {
            request.setAttribute("message", "login Fail!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/login/login.jsp");
            requestDispatcher.forward(request, response);
        } else if (user.getRole().equalsIgnoreCase("admin")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/home/homeAdmin.jsp");
            requestDispatcher.forward(request,response);
        }
        else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/home/homeUser.jsp");
            requestDispatcher.forward(request,response);
        }


    }
}
