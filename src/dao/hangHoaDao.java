package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.chiTietHangHoaBean;
import bean.hangHoaBean;

public class hangHoaDao {

	public ArrayList<hangHoaBean> getAllHangHoa() throws Exception {
		ArrayList<hangHoaBean> dshh = new ArrayList<hangHoaBean>();
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select * from hangHoa ORDER BY ngayNhap desc";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			long maHang = rs.getLong("maHang");
			String tenHang = rs.getString("tenHang");
			long gia = rs.getLong("gia");
			long soLuong = rs.getLong("soLuong");
			String anh = rs.getString("anh");
			Date ngayNhap = rs.getDate("ngayNhap");
			long maLoai = rs.getLong("maLoai");
			long maKieu = rs.getLong("maKieuLoai");

			dshh.add(new hangHoaBean(maHang, tenHang, gia, soLuong, anh, ngayNhap, maLoai, maKieu));
		}

		rs.close();
		kn.cn.close();
		return dshh;
	}

	public hangHoaBean getOneHangHoa(long maHangInput) throws Exception {
		hangHoaBean hh = null;
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select * from hangHoa where maHang = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maHangInput);
		ResultSet rs = cmd.executeQuery();

		if (rs.next()) {
			long maHang = rs.getLong("maHang");
			String tenHang = rs.getString("tenHang");
			long gia = rs.getLong("gia");
			long soLuong = rs.getLong("soLuong");
			String anh = rs.getString("anh");
			Date ngayNhap = rs.getDate("ngayNhap");
			long maLoai = rs.getLong("maLoai");
			long maKieu = rs.getLong("maKieuLoai");

			hh = new hangHoaBean(maHang, tenHang, gia, soLuong, anh, ngayNhap, maLoai, maKieu);
		}

		rs.close();
		kn.cn.close();
		return hh;
	}

	public ArrayList<chiTietHangHoaBean> getChiTietHangHoa(long maHangInput) throws Exception {
		ArrayList<chiTietHangHoaBean> ds = new ArrayList<chiTietHangHoaBean>();
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select * from VChiTietHangHoa where maHang = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maHangInput);
		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			long maHang = rs.getLong("maHang");
			long maSize = rs.getLong("maSize");
			String tenSize = rs.getString("tenSize");

			ds.add(new chiTietHangHoaBean(maHang, maSize, tenSize));
		}

		rs.close();
		kn.cn.close();
		return ds;
	}

}
