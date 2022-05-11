package database;

import java.net.URISyntaxException;
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
			//System.out.println("sending sql query");
			sqlLause = dbyhteys.prepareStatement("SELECT * FROM vastauksetwow;");
			tulostus = sqlLause.executeQuery();
			lista = createListFromRows(tulostus);
		} catch (SQLException e) {
			System.out.println("query failed");
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
		//List<Kysely>
		return lista;
	}
	
	
	//Poistetaan tietokannasta 1 rivi idn perusteella
	public boolean removeRow(int id) {
		
		Connection dbyhteys = null;
		PreparedStatement sqlLause = null;
		boolean onnistunutPoisto = false;
		
		dbyhteys = Database.getDBConnection();
		try {
			sqlLause = dbyhteys.prepareStatement("DELETE FROM vastauksetwow WHERE id=?");
			
			sqlLause.setInt(1, id);
			
			if(sqlLause.executeUpdate()==1) {
				onnistunutPoisto = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Database.closeDBConnection(sqlLause, dbyhteys);
		}
		return onnistunutPoisto;
	}
	
	
	//-----------------------------------------------
	
	//UPDATEROW
	
	//-----------------------------------------------
	
	
	
	public boolean updateRow(String idstr,String setname, String valuestr) {
		
		System.out.println("Values: " + idstr + " " + setname + " " + valuestr);
		String setColumnName = "";
		
		//db jutut
		Connection dbyhteys = null;
		PreparedStatement sqlLause = null;
		boolean onnistunutUpdate = false;
		
		//valintarakenne ekaan ? konkatenointi huono, mutta vain hyväksytyt inputit kelpaavat, muuten palauttaa false
		if (setname.equals("nickname") || setname.equals("hoursplayed") || setname.equals("favboss") || setname.equals("progressnum") || setname.equals("progressdiff") || setname.equals("mplus") || setname.equals("playpvp") || setname.equals("removeclass") || setname.equals("whyremove") || setname.equals("expachype")) {
			System.out.println("valintarakenne ONNISTUI");
			setColumnName = setname;
		}else {
			System.out.println("valintarakenne epäonnistuu");
			return false;
		}
		
		
		
		dbyhteys = Database.getDBConnection();
		try {
			sqlLause = dbyhteys.prepareStatement("UPDATE vastauksetwow SET "+setColumnName+"=? WHERE(id=?);");
			
			//metodiin lähtettyn datan käsittely (str)----------
			
			
			int id = Integer.parseInt(idstr);
			int value = 0;
			boolean changeBoolean;
			
			//arvo on int, jos:
			if (setname.equals("hoursplayed") || setname.equals("mplus") || setname.equals("progressnum")) {
				System.out.println("arvo on int");
				value = Integer.parseInt(valuestr);
				sqlLause.setInt(1, value);
				
			}else if(setname.equals("playpvp") || setname.equals("expachype")){
				
				if(valuestr.equals("true")) {
					changeBoolean = true;
				}else {
					changeBoolean = false;
				}
				sqlLause.setBoolean(1, changeBoolean);
			}else {
				sqlLause.setString(1, valuestr);
			}
			
			sqlLause.setInt(2, id);
			//----------
			//lähetetään query, onnistunut = 1
			if(sqlLause.executeUpdate()==1) {
				onnistunutUpdate = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Database.closeDBConnection(sqlLause, dbyhteys);
		}
		return onnistunutUpdate;
	}
	
	
	//Lähettää lomakkeelle annetut kyselyn vastaukset tietokantaan ja palauttaa onnistumisen
	public boolean insertKysely(String nickname, int hoursplayed, String progressdiff, int progressnum, String favboss, int mplus,
			boolean playpvp, String removeclass, String whyremove, boolean expachype) {
		
		Connection dbyhteys = null;
		PreparedStatement sqlLause = null;
		boolean onnistunutLisays = false;
		
		dbyhteys = Database.getDBConnection();
		try {
			sqlLause = dbyhteys.prepareStatement("INSERT INTO vastauksetwow(nickname,hoursplayed,progressdiff,progressnum,"
					+ "favboss,mplus,playpvp,removeclass,whyremove,expachype) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?);");
			
			sqlLause.setString(1, nickname);
			sqlLause.setInt(2, hoursplayed);
			sqlLause.setString(3, progressdiff);
			sqlLause.setInt(4, progressnum);
			sqlLause.setString(5, favboss);
			sqlLause.setInt(6, mplus);
			sqlLause.setBoolean(7, playpvp);
			sqlLause.setString(8, removeclass);
			sqlLause.setString(9, whyremove);	
			sqlLause.setBoolean(10, expachype);
			
			int rivimaara = sqlLause.executeUpdate();
			if (rivimaara == 1) onnistunutLisays = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Database.closeDBConnection(sqlLause, dbyhteys);
		}
		
		return onnistunutLisays;
	}
	
	
}
