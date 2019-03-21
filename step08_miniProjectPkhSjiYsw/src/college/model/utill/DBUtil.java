package college.model.utill;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import college.view.EndView;

public class DBUtil {
	static Properties p = new Properties();
	static{ 
		try {
			p.load( new FileInputStream("db.properties") );
			Class.forName(p.getProperty("jdbc.driver"));
		} catch (Exception e) {
			EndView.ShowError("DB 드라이버 로딩 실패");
		}
	}

	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(p.getProperty("jdbc.url") ,
										   p.getProperty("jdbc.id"), 
										   p.getProperty("jdbc.pw"));
	}

	// DML용
	public static void close(Connection con, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException s) {
			EndView.ShowError("자원반환 오류");
		}
	}

	// SELECT용
	public static void close(Connection con, Statement stmt, ResultSet rst) {
		try {
			if (rst != null) {
				rst.close();
				rst = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException s) {
			EndView.ShowError("자원반환 오류");
		}
	}
	
}
