package rikkei.academy.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        System.out.println(action);
        switch (action) {
            case "goHome":
                formHome(request, response);
                break;
            case "jv":
                formLotrinh(request, response);
                break;
            case "js":
                formLotrinh2(request, response);
                break;
            case "khoa1":
                formKhoa1(request, response);
                break;
            case "khoa2":
                formKhoa2(request, response);
                break;
            case "khoa3":
                formKhoa3(request, response);
                break;
            case "lotrinh":
                formlotrinh(request, response);
                break;
            case "khoahoc":
                formkhoahoc(request, response);
                break;
            case "baitap":
                formbaitap(request, response);
                break;
            case "caidat":
                formcaidat(request, response);
                break;
            case "doimatkhau":
                formmatkhau(request, response);
                break;
            case "logout":
                formlogout(request, response);
                break;

        }
    }

    //REMOTE
    private void formlogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/navbar/remote/logout.jsp");
        requestDispatcher.forward(request, response);
    }

    private void formmatkhau(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/navbar/remote/doimatkhau.jsp");
        requestDispatcher.forward(request, response);
    }

    private void formcaidat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/navbar/remote/caidat.jsp");
        requestDispatcher.forward(request, response);
    }

    private void formbaitap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/navbar/remote/baitap.jsp");
        requestDispatcher.forward(request, response);
    }

    private void formkhoahoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/navbar/remote/khoahoc.jsp");
        requestDispatcher.forward(request, response);
    }

    private void formlotrinh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/navbar/remote/lotrinh.jsp");
        requestDispatcher.forward(request, response);
    }

    //KHOA HOC
    private void formKhoa3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/navbar/khoahoc/khoa3.jsp");
        requestDispatcher.forward(request, response);
    }

    private void formKhoa2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/navbar/khoahoc/khoa2.jsp");
        requestDispatcher.forward(request, response);
    }

    private void formKhoa1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/navbar/khoahoc/khoa1.jsp");
        requestDispatcher.forward(request, response);
    }

    //HOME
    private void formHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/home/homeAdmin.jsp");
        requestDispatcher.forward(request, response);
    }

    //LO TRINH
    private void formLotrinh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/navbar/lotrinh/jv.jsp");
        requestDispatcher.forward(request, response);
    }

    private void formLotrinh2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/navbar/lotrinh/js.jsp");
        requestDispatcher.forward(request, response);
    }

    //
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
