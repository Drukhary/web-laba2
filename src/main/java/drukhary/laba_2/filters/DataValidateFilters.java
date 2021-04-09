package drukhary.laba_2.filters;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;

@MultipartConfig
public class DataValidateFilters implements Filter {
    private FilterConfig filterConfig;

    protected boolean IsParameterExist(Part part) {
        try {
            InputStream inputStream = part.getInputStream();
            InputStreamReader isReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(isReader);
            String string;
            if (reader.ready()) {
                string = reader.readLine();
                if (string != null)
                    return true;
            }
        } catch (IOException | java.lang.NullPointerException e) {
            return false;
        }
        return false;
    }

    public DataValidateFilters() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (((HttpServletRequest) request).getMethod().equals("POST")) {
            if (IsParameterExist(req.getPart("R"))
                    && IsParameterExist(req.getPart("X"))
                    && IsParameterExist(req.getPart("Y")))
                chain.doFilter(request, response);
            else {
                req.setAttribute("message", "Некорректный запрос");
                filterConfig.getServletContext().getRequestDispatcher("/views/result.jsp").forward(request, response);
            }
        } else
            chain.doFilter(request, response);
    }
}
