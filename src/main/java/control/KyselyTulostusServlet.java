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

@WebServlet("/vastaukset-raw")
public class KyselyTulostusServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		KyselyDao vastauksetdao = new KyselyJdbcDao();
		List<Kysely> vastaukset = vastauksetdao.findAll();
		
		request.setAttribute("vastaukset", vastaukset);
		request.getRequestDispatcher("WEB-INF/kyselyntulostus.jsp").forward(request, response);
		
	}
}
