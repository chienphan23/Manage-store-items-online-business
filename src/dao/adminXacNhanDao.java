package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.adminXacNhanBean;

public class adminXacNhanDao {
	public ArrayList<adminXacNhanBean> getDSXN() throws Exception {
		ArrayList<adminXacNhanBean> ds = new ArrayList<adminXacNhanBean>();
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select * from VXacNhanCTHoaDon where tinhTrang = 'false'";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long maHang = rs.getLong("maHang");
			long maHoaDon = rs.getLong("maHoaDon");
			long maChiTietHoaDon = rs.getLong("maChiTietHoaDon");
			String hoTenKhachHang = rs.getString("hoTen");
			long maKhachHang = rs.getLong("maKhachHang");
			String anh = rs.getString("anh");
			String tenHang = rs.getString("tenHang");
			long gia = rs.getLong("gia");
			long soLuongMua = rs.getLong("soLuongMua");
			Date ngayMua = rs.getDate("ngayMua");
			String tenSize = rs.getString("tenSize");
			long thanhTien = rs.getLong("thanhTien");
			boolean tinhTrang = rs.getBoolean("tinhTrang");
			ds.add(new adminXacNhanBean(maHang, maHoaDon, maChiTietHoaDon, hoTenKhachHang, maKhachHang, anh, tenHang,
					gia, soLuongMua, ngayMua, tenSize, thanhTien, tinhTrang));
		}
		cmd.close();
		rs.close();
		kn.cn.close();
		return ds;
	}

	public ArrayList<adminXacNhanBean> getDSDaXacNhan() throws Exception {
		ArrayList<adminXacNhanBean> ds = new ArrayList<adminXacNhanBean>();
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select * from VXacNhanCTHoaDon where tinhTrang = 'true'";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long maHang = rs.getLong("maHang");
			long maHoaDon = rs.getLong("maHoaDon");
			long maChiTietHoaDon = rs.getLong("maChiTietHoaDon");
			String hoTenKhachHang = rs.getString("hoTen");
			long maKhachHang = rs.getLong("maKhachHang");
			String anh = rs.getString("anh");
			String tenHang = rs.getString("tenHang");
			long gia = rs.getLong("gia");
			long soLuongMua = rs.getLong("soLuongMua");
			Date ngayMua = rs.getDate("ngayMua");
			String tenSize = rs.getString("tenSize");
			long thanhTien = rs.getLong("thanhTien");
			boolean tinhTrang = rs.getBoolean("tinhTrang");
			ds.add(new adminXacNhanBean(maHang, maHoaDon, maChiTietHoaDon, hoTenKhachHang, maKhachHang, anh, tenHang,
					gia, soLuongMua, ngayMua, tenSize, thanhTien, tinhTrang));
		}
		cmd.close();
		rs.close();
		kn.cn.close();
		return ds;
	}

	public int kiemTraChiTietFullTrue(long maHoaDon) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select COUNT(maChiTietHoaDon) as soLuongChiTiet from chiTietHoaDon where maHoaDon = ? and tinhTrang = 0 ";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maHoaDon);
		ResultSet rs = cmd.executeQuery();
		int n = 2;
		if (rs.next()) {
			n = rs.getInt("soLuongChiTiet");
		}

		cmd.close();
		kn.cn.close();
		return n;
	}

	public int SetHoaDonTrue(long maHoaDon) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "update hoaDon set tinhTrang = 'true' where maHoaDon = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maHoaDon);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int setSoLuongTon(long soLuongMua, long maHang) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "update hangHoa set soLuong = soLuong - ? where maHang = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, soLuongMua);
		cmd.setLong(2, maHang);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int XacNhanCTHD(long maChiTietHoaDon, long maHoaDonInput, long soLuongMua, long maHang) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "update chiTietHoaDon set tinhTrang = 'true' where maChiTietHoaDon = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maChiTietHoaDon);
		int kq = cmd.executeUpdate();
		setSoLuongTon(soLuongMua, maHang);
		int a = kiemTraChiTietFullTrue(maHoaDonInput);
		if (a == 0) {
			int alo = SetHoaDonTrue(maHoaDonInput);
		}
		cmd.close();
		kn.cn.close();
		return kq;
	}

}
