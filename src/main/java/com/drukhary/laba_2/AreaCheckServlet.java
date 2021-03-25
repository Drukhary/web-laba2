package com.drukhary.laba_2;

import com.drukhary.laba_2.AreaChecking.AreaCheckingExeption.OutOfRangeException;
import com.drukhary.laba_2.AreaChecking.AreaCheckingExeption.WrongDataException;
import com.drukhary.laba_2.AreaChecking.ElementInfo;
import com.drukhary.laba_2.AreaChecking.PointChecker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/AreaCheck")
public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        if (getServletContext().getAttribute("table") == null) {
            getServletContext().setAttribute("table", new ArrayList<ElementInfo>());
        }
        try {
            ElementInfo elementInfo = PointChecker.CheckPoint(
                    req.getParameter("X").replace(",", "."),
                    req.getParameter("Y").replace(",", "."),
                    req.getParameter("R").replace(",", ".")
            );
            Object object = getServletContext().getAttribute("table");
            ArrayList<ElementInfo> arrayList;
            if (object != null) {
                arrayList = (ArrayList<ElementInfo>) object;
                arrayList.add(elementInfo);
                req.setAttribute("message", (elementInfo.isResult() ? "Точка входит в область" : "Точка не входит в область"));
            }
        } catch (OutOfRangeException | WrongDataException e) {
            req.setAttribute("message", e.getMessage());
        } catch (NumberFormatException e) {
            req.setAttribute("message", "Неверный формат данных(не отчисляйте, пожалуста)");
        }
        getServletContext().getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}
