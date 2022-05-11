package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.KyselyDao;
import database.KyselyJdbcDao;


@WebServlet("/updaterow")
public class UpdateRowServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//vastaanota id, näytä sivu
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//db käsittely dao
		//System.out.println("updaterow post onnistui");
		KyselyDao kyselydao = new KyselyJdbcDao();
		//selaimesta saadut attribuutit
		String idstr = req.getParameter("id");
		String setname = req.getParameter("setname");
		String valuestr = req.getParameter("setvalue");
		if(kyselydao.updateRow(idstr, setname, valuestr)) {
			System.out.println("lol");
			req.getRequestDispatcher("WEB-INF/kyselyntulostus.jsp").forward(req, resp);
		}else {
			System.out.println("kyselydao palautti FALSE");
		}
	}
	
}
