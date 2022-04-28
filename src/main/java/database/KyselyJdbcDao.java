package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Kysely;

public class KyselyJdbcDao implements KyselyDao{

	
	//Muodostaa yhteyden tietokantaan valmiiden luokkien avulla ja hakee resultset tyyppisen vastauksen sql lauseella
	public List<Kysely> findAll(){
		Connection dbyhteys = null;
		PreparedStatement sqlLause = null;
		ResultSet tulostus = null;
		List<Kysely> lista = new ArrayList<Kysely>();
		
		dbyhteys = Database.getDBConnection();
		try {
			sqlLause = dbyhteys.prepareStatement("SELECT * FROM vastauksetwow;");
			tulostus = sqlLause.executeQuery();
			lista = createListFromRows(tulostus);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Database.closeDBConnection(tulostus, sqlLause, dbyhteys);
		}
		
		return lista;
	}
	
	
	//Muodostetaan ResultSet luokan oliosta lista Kysely luokan olioita
	public static List<Kysely> createListFromRows(ResultSet rs){
		List<Kysely> lista = new ArrayList<Kysely>();
		try {
			while(rs.next()) {
				lista.add(new Kysely(rs.getInt("id"), rs.getString("nickname"), rs.getInt("hoursplayed"), rs.getString("progressdiff"), 
						rs.getInt("progressnum"),rs.getString("favboss"), rs.getInt("mplus"), 
						rs.getBoolean("playpvp"), rs.getString("removeclass"),
						rs.getString("whyremove"), rs.getBoolean("expachype")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	
	
	public boolean removeRow(int id) {
		return false;
	}
	
	
	
}
