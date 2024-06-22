package dao;

import java.sql.PreparedStatement;

public class chiTietHoaDonDao {
	public int ThemChiTiet(long maHang, long soLuongMua, long maHoaDon, String tenSize, boolean tinhTrang)
			throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "insert into chiTietHoaDon(maHang, soLuongMua, maHoaDon, tenSize,tinhTrang) values(?,?,?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maHang);
		cmd.setLong(2, soLuongMua);
		cmd.setLong(3, maHoaDon);
		cmd.setString(4, tenSize);
		cmd.setBoolean(5, tinhTrang);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
