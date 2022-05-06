package database;

public class DBAccounts {
	
	
	
	// DBURL = JDBC_URL
	//
	
	
	//	testidb
	// 	url		jdbc:postgresql://localhost/kysely1
	//	user	postgres
	//	pw		FillerPw98
	
	/*
	 * 	Host			ec2-52-212-228-71.eu-west-1.compute.amazonaws.com
		Database		d6krn175rg2l7b
		User			hpclcfndpvtdri
		Port			5432
		Password		c55ab0033d41aeb2ae497fb4410ee76fb81120d11b06175d3f8e57a5b0535559
		URI				postgres://hpclcfndpvtdri:c55ab0033d41aeb2ae497fb4410ee76fb81120d11b06175d3f8e57a5b0535559@ec2-52-212-228-71.eu-west-1.compute.amazonaws.com:5432/d6krn175rg2l7b
		Heroku CLI		heroku pg:psql postgresql-lively-53233 --app wowquery-plswork
	 * 
	 * 
	 * 
	 * 
	 */
	
	// URL SYNTAX: jdbc:postgresql://<host>:<port>/<dbname>?sslmode=require&user=<username>&password=<password>
	
	
	
	
	
	
	public static final String DATABASE_URL = "jdbc:postgresql://ec2-52-212-228-71.eu-west-1.compute.amazonaws.com:5432/d6krn175rg2l7b?sslmode=require&user=hpclcfndpvtdri&password=c55ab0033d41aeb2ae497fb4410ee76fb81120d11b06175d3f8e57a5b0535559";
	public static final String DBUSERNAME = "";  // sqlite-testitietokannassa ei käytössä tunnuksia
	public static final String DBPASSWORD = "";
	

}
