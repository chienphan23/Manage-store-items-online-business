package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.lichSuBean;

public class lichSuDao {
	public ArrayList<lichSuBean> getLichSu(long makh, boolean tinhTrangInput) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select * from VChiTiet where maKhachHang = ? and tinhTrang = ? order by ngayMua desc";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, makh);
		cmd.setBoolean(2, tinhTrangInput);
		ResultSet rs = cmd.executeQuery();
		ArrayList<lichSuBean> ds = new ArrayList<lichSuBean>();
		while (rs.next()) {
			long maKhachHang = rs.getLong("maKhachHang");
			long maHang = rs.getLong("maHang");
			String tenHang = rs.getString("tenHang");
			long gia = rs.getLong("gia");
			long soLuongMua = rs.getLong("soLuongMua");
			String anh = rs.getString("anh");
			boolean tinhTrang = rs.getBoolean("tinhTrang");
			Date ngayMua = rs.getDate("ngayMua");
			String tenSize = rs.getString("tenSize");
			long thanhTien = rs.getLong("thanhTien");
			ds.add(new lichSuBean(maKhachHang, maHang, tenHang, gia, soLuongMua, anh, tinhTrang, ngayMua, tenSize,
					thanhTien));
		}
		cmd.close();
		kn.cn.close();
		return ds;
	}
}
