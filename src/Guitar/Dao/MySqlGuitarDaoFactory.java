package Guitar.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Guitar.Model.Guitar;
import Guitar.Util.MySqlDBUtil;

public class MySqlGuitarDaoFactory implements IGuitarDaoFactory{

	@Override
	public void addGuitar(Guitar guitar){
		Connection Conn = MySqlDBUtil.open();
		String sql = "insert into guitar(ID,price,builder,type,Wood) values(?,?,?,?,?)";
		try
		{
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1, guitar.getID());
			pstmt.setString(2, guitar.getPrice());
			pstmt.setString(3, guitar.getSpec().getBuilder());
			pstmt.setString(4, guitar.getSpec().getType());
			pstmt.setString(5, guitar.getSpec().getWood());

			pstmt.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			MySqlDBUtil.close(Conn);
		}
	}

	
	@Override
	public List<Guitar> searchGuitar(String type){
		Connection Conn = MySqlDBUtil.open();
		String sql = "select * from guitar where type= ? ";
		List<Guitar> listguitar = new ArrayList<Guitar>();

		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1,type);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Guitar guitar=new Guitar();
				guitar.setID(rs.getString(1));
				guitar.setPrice(rs.getString(2));
				guitar.setBuilder(rs.getString(3));
				guitar.setType(type);
				guitar.setWood(rs.getString(5));
				listguitar.add(guitar);
			}
			return listguitar;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			MySqlDBUtil.close(Conn);
		}
	return null;
	}

	
	@Override
	public void delGuitar(String ID){
		Connection Conn = MySqlDBUtil.open();
		String sql = "delete from guitar where ID = ?";
		try{
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			pstmt.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			MySqlDBUtil.close(Conn);
		}
	}

	
	@Override
	public List<Guitar> searchallGuitar(){
		Connection Conn = MySqlDBUtil.open();
		String sql = "select * from Guitar";
		List<Guitar> listallguitar = new ArrayList<Guitar>();

		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Guitar guitar=new Guitar();
				guitar.setID(rs.getString(1));
				guitar.setPrice(rs.getString(2));
				guitar.setBuilder(rs.getString(3));
				guitar.setType(rs.getString(4));
				guitar.setWood(rs.getString(5));
				listallguitar.add(guitar);
			}
			return listallguitar;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			MySqlDBUtil.close(Conn);
		}
	return null;
	}
	
}
