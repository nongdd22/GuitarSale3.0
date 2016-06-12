package Guitar.Dao;

import java.util.List;

import Guitar.Model.Guitar;

public interface IGuitarDaoFactory {
	
	public List<Guitar> searchGuitar(String type);
	public void addGuitar(Guitar guitar);
	public void delGuitar(String ID);
	public List<Guitar> searchallGuitar();
	
	
}
