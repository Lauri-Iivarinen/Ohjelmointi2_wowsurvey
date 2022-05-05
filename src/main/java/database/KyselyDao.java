package database;

import java.util.List;
import model.Kysely;

public interface KyselyDao {
	
	public List<Kysely> findAll();
	public boolean insertKysely(String nickname, int hoursplayed, String progressdiff, int progressnum, String favboss, int mplus,
			boolean playpvp, String removeclass, String whyremove, boolean expachype);
	public boolean removeRow(int id);

}
