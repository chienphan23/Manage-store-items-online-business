package dao;

import java.sql.DriverManager;

public class ketnoidao {
	public java.sql.Connection cn;

	public void ketnoi() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da xac dinh hqtcsdl");
		String url = "jdbc:sqlserver://LAPTOP\\CHIENSQL:1433;databaseName=QlBanHang;user=sa; password=123";
		cn = DriverManager.getConnection(url);
		System.out.println("Da ket noi");
	}
}
