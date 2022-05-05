package control;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.KyselyDao;
import database.KyselyJdbcDao;
import model.Kysely;
import model.KyselyMuotoilu;


/*
 * SIVU ON KYSELYN VASTAUKSISTA RAKENNETTAVAN KOOSTEEN JULKAISUSIVU
 * TULOKSET TIIVISTETÄÄN ERILLISELLE KYSELYMUOTOILU OLIOLLE, JOSTA INFORMAATIO ON HELPOMPI
 * TULOSTAA KUVAAJIIN SIVULLE.
 * 
 */

@WebServlet("/vastaukset")
public class VastauksetServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		KyselyDao vastauksetdao = new KyselyJdbcDao();
		List<Kysely> vastaukset = vastauksetdao.findAll();
		
		KyselyMuotoilu muotoiltuvastaus = muotoile(vastaukset);
		
		System.out.println(muotoiltuvastaus);
		//muotoiltu listalla vain yksi olio, koska jsp c:forEach lol:D
		List<KyselyMuotoilu> muotoiltu = new ArrayList();
		muotoiltu.add(muotoiltuvastaus);
		//VALMIST LISTA
		request.setAttribute("muotoiltu", muotoiltu);
		request.getRequestDispatcher("WEB-INF/kyselyvastaukset.jsp").forward(request, response);
		
	}
	
	protected static KyselyMuotoilu muotoile(List<Kysely> vastaukset) {
		DecimalFormat df = new DecimalFormat("0.00");
		//Muuttujaviidakko
		Map favbossMap = new HashMap();
		Map removeclassMap = new HashMap();
		int vastanneetMaara = vastaukset.size();
		
		int mplusSum = 0;
		double avgmplus;
		
		int playedSum = 0; //hoursplayed
		double avgplayed;
		
		int progressNumLfr = 0;
		double avgLfr;
		int playersLfr = 0;
		int progressNumN = 0;
		double avgN;
		int playersN = 0;
		int progressNumHc = 0;
		double avgHc;
		int playersHc = 0;
		int progressNumM = 0;
		double avgM;
		int playersM = 0;
		
		int playpvpno;
		int playpvpyes = 0;
		
		int expachypeyes = 0;
		int expachypeno;
		
		
		//FOR LOOPPI LISTAN LÄPIKÄYNTIIN
		for (Kysely vastaus: vastaukset) {
			mplusSum += vastaus.getMplus();
			playedSum += vastaus.getHoursplayed();
			
			System.out.println();
			if (vastaus.getProgressdiff().equals("LFR")) {
				progressNumLfr += vastaus.getProgressnum();
				playersLfr ++;
			}else if (vastaus.getProgressdiff().equals("N")) {
				progressNumN += vastaus.getProgressnum();
				playersN ++;
			}else if (vastaus.getProgressdiff().equals("HC")) {
				progressNumHc += vastaus.getProgressnum();
				playersHc ++;
			}else if (vastaus.getProgressdiff().equals("M")) {
				progressNumM += vastaus.getProgressnum();
				playersM ++;
			}
			
			if(vastaus.isPlaypvp()) playpvpyes ++;
			if(vastaus.isExpachype()) expachypeyes ++;
			
			//FAVBOSSMAP KÄSITTELY, LUODAAN UUSI AVAIN TAI LISÄTÄÄN VANHAAN 1
			if (favbossMap.get(vastaus.getFavboss()) == null) {
				favbossMap.put(vastaus.getFavboss(),1);
			}else {
				int bossmaara = (int) favbossMap.get(vastaus.getFavboss());
				bossmaara ++;
				favbossMap.put(vastaus.getFavboss(), bossmaara);
			}
			
			//REMOVECLASSMAP KÄSITTELY
			if(removeclassMap.get(vastaus.getRemoveclass()) == null) {
				removeclassMap.put(vastaus.getRemoveclass(), 1);
			}else {
				int classmaara = (int) removeclassMap.get(vastaus.getRemoveclass());
				classmaara ++;
				removeclassMap.put(vastaus.getRemoveclass(), classmaara);
			}
			
		}
		
		
		
		expachypeno = vastanneetMaara - expachypeyes;
		playpvpno = vastanneetMaara - playpvpyes;
		avgLfr = (double)progressNumLfr/playersLfr;
		avgN = (double)progressNumN/playersN;
		avgHc = (double)progressNumHc/playersHc;
		avgM = (double)progressNumM/playersM;
		
		avgplayed = (double)playedSum/vastanneetMaara;
		String avgstr = df.format(avgplayed);
		avgstr = avgstr.replace(",", ".");
		avgplayed = Double.parseDouble(avgstr);
		
		avgmplus = (double)mplusSum/vastanneetMaara;
		String mplusstr = df.format(avgmplus);
		mplusstr = mplusstr.replace(",", ".");
		avgmplus = Double.parseDouble(mplusstr);
		
		
		
		KyselyMuotoilu muotoiltu = new KyselyMuotoilu(avgplayed,favbossMap, avgmplus, playpvpyes, playpvpno,
			expachypeyes, expachypeno, avgLfr, avgN, avgHc,
			avgM, removeclassMap);
		return muotoiltu;
	}
	
}
