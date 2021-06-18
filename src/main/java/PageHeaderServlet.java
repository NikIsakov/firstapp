import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/page_header")
public class PageHeaderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Hello from servlet!!!</h1>");
        for (int i = 0; i<10; i++) {
            resp.getWriter().println(new Product((i+10), "Товар " + (i+1), (i*75+150)));
        }
    }
}
