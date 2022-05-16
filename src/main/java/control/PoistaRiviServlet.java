package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.KyselyDao;
import database.KyselyJdbcDao;


/*
 * EI TULOSTA MITÄÄN, AINOASTAAN KÄSITTELEE POISTOPYYNNÖT
 * JA REDIRECTAA TAKAISIN SAMALLE SIVULLE
 * 
 */

@WebServlet("/deleterow")
public class PoistaRiviServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		KyselyDao kyselydao = new KyselyJdbcDao();
		String idstr = req.getParameter("id");
		int id = Integer.parseInt(idstr);
		
		String confstr = req.getParameter("conf");
		if (confstr.equals("alkahflwasfamoasnjawo")) {
			if(kyselydao.removeRow(id)) resp.sendRedirect("/topsecretresultspage");
			else {System.out.println("FAILED");}
		}else {
			String viesti = "Not authorized";
			req.setAttribute("viesti", viesti);
			req.getRequestDispatcher("WEB-INF/pwcheck.jsp").forward(req, resp);
		}
		
		
	}
	
}

/*
 * @WebServlet("/deleterow")
public class PoistaRiviServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		KyselyDao kyselydao = new KyselyJdbcDao();
		String idstr = req.getParameter("id");
		int id = Integer.parseInt(idstr);
		
		if(kyselydao.removeRow(id)) resp.sendRedirect("/topsecretresultspage");
		else {System.out.println("FAILED");}
		
	}
	
}
 * 
 * 
 * 
 * @WebServlet("/deletingrowbyid")
public class PoistaRiviServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		KyselyDao kyselydao = new KyselyJdbcDao();
		String idstr = req.getParameter("vastaajaid");
		int id = Integer.parseInt(idstr);
		
		
		if(kyselydao.removeRow(id)) {
			resp.sendRedirect("/");
		}else {
			System.out.println("FAILED");
		}
		
	}
	
}
 */
