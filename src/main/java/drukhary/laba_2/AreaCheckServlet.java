package drukhary.laba_2;

import drukhary.laba_2.AreaCheckingModel.AreaCheckingExeption.OutOfRangeException;
import drukhary.laba_2.AreaCheckingModel.AreaCheckingExeption.WrongDataException;
import drukhary.laba_2.AreaCheckingModel.Beans.ElementInfo;
import drukhary.laba_2.AreaCheckingModel.PointChecker;
import drukhary.laba_2.AreaCheckingModel.Beans.Table;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        getServletContext().getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        synchronized (getServletContext().getAttribute("table")) {
            if (getServletContext().getAttribute("table") == null) {
                getServletContext().setAttribute("table", new Table());
            }
        }
        try {
            ElementInfo elementInfo = PointChecker.CheckPoint(
                    req.getParameter("X").replace(",", "."),
                    req.getParameter("Y").replace(",", "."),
                    req.getParameter("R").replace(",", ".")
            );
            synchronized (getServletContext().getAttribute("table")) {
                ((Table) getServletContext().getAttribute("table")).getData().add(elementInfo);

                req.setAttribute("message",
                        (elementInfo.isResult() ? "Точка входит в область" : "Точка не входит в область"));
            }
        } catch (OutOfRangeException | WrongDataException e) {
            req.setAttribute("message", e.getMessage());
        } catch (NumberFormatException e) {
            req.setAttribute("message", "Неверный формат данных(примите лабу, пожалуйста)");
        }
        getServletContext().getRequestDispatcher("/views/result.jsp").forward(req, resp);
    }
}
