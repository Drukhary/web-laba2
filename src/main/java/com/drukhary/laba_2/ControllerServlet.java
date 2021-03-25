package com.drukhary.laba_2;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
@MultipartConfig
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("R") != null && req.getParameter("X") != null && req.getParameter("Y") != null) {
            resp.setCharacterEncoding("UTF-8");
            getServletContext().getRequestDispatcher("/AreaCheck").forward(req, resp);
        } else {
            req.setAttribute("message", "Неверные данные(не отчисляйте, пожалуйста)");
            getServletContext().getRequestDispatcher("/result.jsp").forward(req, resp);
        }
    }
}