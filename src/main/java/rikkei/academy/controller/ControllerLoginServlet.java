package rikkei.academy.controller;

import rikkei.academy.model.User;
import rikkei.academy.service.IUserService;
import rikkei.academy.service.UserServiceIMPL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = {"/","/loginServlet"})
public class ControllerLoginServlet extends HttpServlet {
    IUserService userService = new UserServiceIMPL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
        response.sendRedirect("/view/login/login.jsp");
=======
        String action= request.getParameter("action");
        if (action == null){
            action = "";
        }
        System.out.println(action);
        switch (action){
            case "dangky":
                fromDangKy(request,response);
                break;
        }

        response.sendRedirect("view/login/login.jsp");
>>>>>>> 71f8b1cb78d1ab1995f33bc2d23cdafd2b514928
    }

    private void fromDangKy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/register/dangky.jsp");
        requestDispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action= request.getParameter("action");
        if (action == null){
            action = "";
        }
        System.out.println(action);
        switch (action){
            case "dangky":
                actionDangky(request,response);
                break;
            case "register":
                actionRegister(request,response);
                break;
        }






    }

    private void actionRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    private void actionDangky(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameUser = request.getParameter("user");
        String password = request.getParameter("password");
        userService.addUser(nameUser,password);
        request.setAttribute("message", "Create success!");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/login/login.jsp");
        requestDispatcher.forward(request,response);

    }
}
