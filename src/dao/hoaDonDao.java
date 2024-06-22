package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class hoaDonDao {
	public int ThemHoaDon(long maKhachHang, Date ngayMua, boolean tinhTrang) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "insert into hoaDon(maKhachHang, ngayMua, tinhTrang) values (?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maKhachHang);
		java.sql.Date ngaySQL = new java.sql.Date(ngayMua.getTime());
		cmd.setDate(2, ngaySQL);
		cmd.setBoolean(3, tinhTrang);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public long getMaHoaDon() throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select max(maHoaDon) as hdln from hoadon";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		long max = 0;
		while (rs.next()) {
			max = rs.getLong("hdln");
		}
		cmd.close();
		kn.cn.close();
		return max;
	}
}
