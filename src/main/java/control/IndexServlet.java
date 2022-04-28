package control;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/")
public class IndexServlet extends HttpServlet{

	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException {
		req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
	};
		
	
}
