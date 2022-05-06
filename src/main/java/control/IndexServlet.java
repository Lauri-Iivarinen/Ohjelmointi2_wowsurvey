package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.KyselyDao;
import database.KyselyJdbcDao;
import model.Kysely;


/*
 * ETUSIVU JOSSA PYYDETÄÄN KYSELYN TULOKSET, KÄSITELLÄÄN NE JA LÄHETETÄÄN TIETOKANTAAN
 * SIVULTA VOI MYÖS MENNÄ SUORAAN KATSOMAAN VASTAUKSET
 * 
 */
@WebServlet("/")
public class IndexServlet extends HttpServlet{

	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException {
		req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
	};
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nickname = req.getParameter("nickname");
		String hoursplayedStr = req.getParameter("hoursplayed");
		int hoursplayed = Integer.parseInt(hoursplayedStr);
		String progressnumStr = req.getParameter("progressnum");
		int progressnum = Integer.parseInt(progressnumStr);
		String progressdiff = req.getParameter("progressdiff");
		String favboss = req.getParameter("favboss");
		String mplusStr = req.getParameter("mplus");
		int mplus = Integer.parseInt(mplusStr);
		boolean expachype = false;
		boolean playpvp = false;
		
		String playpvpStr = req.getParameter("playpvp");
		int playpvpInt = Integer.parseInt(playpvpStr);
		if (playpvpInt == 1) {
			playpvp = true;
		}else {
			playpvp = false;
		}
		
		String removeclass = req.getParameter("removeclass");
		String whyremove = req.getParameter("whyremove");
		
		if (whyremove.length()>= 140) {
			whyremove = "Too long to parse into db";
		}
		
		String expachypeStr = req.getParameter("expachype");
		int expachypeInt = Integer.parseInt(expachypeStr);
		if (expachypeInt == 1) {
			expachype = true;
		}else {
			expachype = false;
		}
		
		KyselyDao kyselydao = new KyselyJdbcDao();
		
		boolean onnistui = kyselydao.insertKysely(nickname, hoursplayed, progressdiff, progressnum, favboss, mplus, playpvp, removeclass, whyremove, expachype);
		
		if (onnistui) {
			resp.sendRedirect("/vastaukset");
		}else {
			System.out.println("FAIL");
		}
	}
		
	
}
