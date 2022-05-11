package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.KyselyDao;
import database.KyselyJdbcDao;
import model.Kysely;


/*
 * RAAKA DATAN TULOSTAVA SIVU, SIVULLA ON LINKKI, MISTÄ KYSEISEN DATARIVIN VOI MYÖS POISTAA TARVITTAESSA
 * PIDETTÄVÄ TAVALLISEN KÄYTTÄJÄN ULOTTUMATTOMISSA JOS MAHDOLLISTA
 * 
 */

@WebServlet("/topsecretresultspage")
public class KyselyTulostusServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viesti = "";
		request.setAttribute("viesti", viesti);
		request.getRequestDispatcher("WEB-INF/pwcheck.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String password = req.getParameter("password");
		
		if(hashPw(password)) {
			//Näyttää uuden jsp sivun
			KyselyDao vastauksetdao = new KyselyJdbcDao();
			List<Kysely> vastaukset = vastauksetdao.findAll();
			
			int vastaajaMaara = vastaukset.size();
			
			req.setAttribute("vastaajaMaara", vastaajaMaara);
			req.setAttribute("vastaukset", vastaukset);
			req.getRequestDispatcher("WEB-INF/kyselyntulostus.jsp").forward(req, resp);
			
		}else {
			String viesti = "WRONG >:(";
			req.setAttribute("viesti", viesti);
			req.getRequestDispatcher("WEB-INF/pwcheck.jsp").forward(req, resp);
		}
		
	}
	
	
	//Pieni hash, ei todellakaan tietoturvallinen
	protected static boolean hashPw(String pw) {
		boolean salasana = false;
		//FillerPw98
		pw = pw.replace('r', 'l');
		pw = pw.replace('l', 'L');
		pw = pw.replace('i', '5');
		pw = pw.replace('e', 'F');
		pw = pw.replace("w9", "l7p");
		pw = pw.replace("LF", "ys");
		if (pw.equals("F5LysLPl7p8")) salasana = true;
		
		return salasana;
	}
	
	
	
	
}
