package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconn {
	//String dbClassName="com.mysql.cj.jdbc.Driver";
	String dbClassName="com.mysql.cj.jdbc.Driver";
	String dbUrl="jdbc:mysql://127.0.0.1:3306/elms?server&Timezone=Asia/Shangha";
	String dbUse="root";
	String dbPaw="209017li";
	Connection conn;
	Statement sm;
	public DBconn()  {
		try {
			Class.forName(dbClassName).newInstance();
			try {
				conn=DriverManager.getConnection(dbUrl,dbUse,dbPaw);
				sm=conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Connection getConn() {
		return conn;
	}
	public Statement getSm() {
		return sm;
	}
	public void closeConn() {
	
			try {
				if(sm!=null)
				sm.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	

}
