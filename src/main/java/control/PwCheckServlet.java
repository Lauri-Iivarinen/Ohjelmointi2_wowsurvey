package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * SIVULLA PYYDETÄÄN SALASANAA, JOTTEI JOKAINEN KÄYTTÄJÄ PÄÄSE KÄSIKSI RAAKAAN DATAAN JA SEN POISTOON
 * SALASANA KÄYTETÄÄN PIRKKA HASHIN LÄPI
 * RAAKA DATA SIVULLE PÄÄSEE SILTI URL:n KAUTTA NORMAALISTI
 * 
 */
@WebServlet("/pwcheck")
public class PwCheckServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/pwcheck.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String password = req.getParameter("password");
		
		if(hashPw(password)) resp.sendRedirect("/vastaukset-raw");
		
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
