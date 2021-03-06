import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "BasicServlet", urlPatterns = "/basic_servlet")
public class FirstServlet implements Servlet {
    private static final Logger logger = LoggerFactory.getLogger(FirstServlet.class);

    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.info("FirstServlet is initialized");
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        logger.info("New request to FirstServlet");

        req.setAttribute("pageHeader", "Привет от сервлета!!!");
        config.getServletContext().getRequestDispatcher("/page_header").forward(req, res);

        res.getWriter().println("<h1>Hello from servlet!!!</h1>");
    }

    @Override
    public String getServletInfo() {
        return "BasicServlet";
    }

    @Override
    public void destroy() {

    }
}
