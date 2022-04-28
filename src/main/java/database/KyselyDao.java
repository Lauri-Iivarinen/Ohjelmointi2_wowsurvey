package database;

import java.util.List;
import model.Kysely;

public interface KyselyDao {
	
	public List<Kysely> findAll();
	public boolean removeRow(int id);

}
