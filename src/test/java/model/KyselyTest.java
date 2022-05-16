package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import database.KyselyDao;
import database.KyselyJdbcDao;

public class KyselyTest {
	
	//Kysely olion testaus 1 -- toString
	@Test
	void kyselyToStringTest() {
		Kysely vastausrivi = new Kysely(12, "testname", 23, "M", 9, "Skolex", 2500,
				false, "hunter", "because", true);
		String vastausToString = vastausrivi.toString();
		
		assertEquals(vastausToString, "Kysely [id=12, nickname=testname, hoursplayed=23, progressdiff=M, progressnum=9, favboss=Skolex, mplus=2500, playpvp=false, removeclass=hunter, whyremove=because, expachype=true]");
	}
	
	//Kysely olion testaus 2 -- getNickname
	@Test
	void kyselyGetNickname() {
		Kysely vastausrivi = new Kysely();
		vastausrivi.setNickname("Testname");
		
		String oletusvastaus = vastausrivi.getNickname();
		assertEquals(oletusvastaus, "Testname");
	}
	
	//KyselyMuotoilu testaus 1 -- hashmap (favboss)
	@Test
	void muotoiluGetfavbossMap() {
		Map favbossMap = new HashMap();
		favbossMap.put("Skolex", 1);
		KyselyMuotoilu muotoiltu = new KyselyMuotoilu();
		muotoiltu.setFavbossMap(favbossMap);
		
		int skolex = (int) muotoiltu.getFavbossMap().get("Skolex");
		
		assertEquals(skolex, 1);
		
	}
	
	//Tietokannan yhteyden muodostus testaus
	@Test
	void kyselyDbYhteys() {
		//Ei viitsi joka testikerralla lisäillä/poistella/muokkailla joten kokeillaan vain hakea tietoa,
		//jos vastaanotetaan lista, tietokannan lisäys onnistuu
		
		KyselyDao kyselydao = new KyselyJdbcDao();
		boolean onnistunut = false;
		
		try {
			List<Kysely> kyselylista = kyselydao.findAll();
			onnistunut = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(onnistunut, true);
	}

}
