package program;

import java.util.List;

import database.KyselyDao;
import database.KyselyJdbcDao;
import model.Kysely;

public class KyselyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Teen Google Formsia muistuttavan kyselyn jostain aiheesta ja vastaukset tallennetaan tietokantaan.\nVastauksen antamisen jälkeen vastaaja näkee yhteenvedon kyselyn tuloksista.\nKyselyn aihe vielä mietinnässä");
		KyselyDao vastauksetdao = new KyselyJdbcDao();
		List<Kysely> vastaukset = vastauksetdao.findAll();
		
		for (Kysely kysely: vastaukset) {
			System.out.println(kysely.toString());
		}
	}

}
