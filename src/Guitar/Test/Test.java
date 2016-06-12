package Guitar.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Guitar.Dao.DaoFactory;
import Guitar.Dao.IGuitarDaoFactory;
import Guitar.Util.MySqlDBUtil;
import Guitar.Util.SqliteDBUtil;


public class Test {

	public static void main(String[] args)
	{
		Connection conn = SqliteDBUtil.open();
		System.out.println(conn);

		Connection conn2 = MySqlDBUtil.open();
		System.out.println(conn2);

		IGuitarDaoFactory test = DaoFactory.createGuitarDao();
		PreparedStatement pstmt = null;
		String sql1 = "insert into Guitar(ID,price,builder,type,Wood) VALUES (?,?,?,?,?)";
		try
		{
			pstmt = conn2.prepareStatement(sql1);
			pstmt.setString(1, "008");
			pstmt.setString(2, "500");
			pstmt.setString(3, "挑战琴行");
			pstmt.setString(4, "古典吉他");
			pstmt.setString(5, "胡新桃木");
			if (pstmt.executeUpdate() > 0)
			{
				System.out.print("sql1 success");
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}
