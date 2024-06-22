package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.CTHDViewBean;
import bean.adminXacNhanHoaDonBean;

public class adminXacNhanHoaDonDao {
	public ArrayList<adminXacNhanHoaDonBean> dsXNHD() throws Exception {
		ArrayList<adminXacNhanHoaDonBean> ds = new ArrayList<adminXacNhanHoaDonBean>();
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select maHoaDon, maKhachHang,hoTen, ngayMua, tinhTrang,sum(thanhTien) as 'TongTien' from VText where tinhTrang = 0 group by maHoaDon, maKhachHang,hoTen, ngayMua, tinhTrang";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long maHoaDon = rs.getLong("maHoaDon");
			long maKhachHang = rs.getLong("maKhachHang");
			String hoTen = rs.getString("hoTen");
			Date ngayMua = rs.getDate("ngayMua");
			boolean tinhTrang = rs.getBoolean("tinhTrang");
			long tongTien = rs.getLong("tongTien");
			ds.add(new adminXacNhanHoaDonBean(maHoaDon, maKhachHang, hoTen, ngayMua, tinhTrang, tongTien));
		}
		cmd.close();
		kn.cn.close();
		return ds;
	}

	public ArrayList<adminXacNhanHoaDonBean> dsHDDXN() throws Exception {
		ArrayList<adminXacNhanHoaDonBean> ds = new ArrayList<adminXacNhanHoaDonBean>();
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select maHoaDon, maKhachHang,hoTen, ngayMua, tinhTrang,sum(thanhTien) as 'TongTien' from VText where tinhTrang = 1 group by maHoaDon, maKhachHang,hoTen, ngayMua, tinhTrang ORDER BY ngayMua desc";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long maHoaDon = rs.getLong("maHoaDon");
			long maKhachHang = rs.getLong("maKhachHang");
			String hoTen = rs.getString("hoTen");
			Date ngayMua = rs.getDate("ngayMua");
			boolean tinhTrang = rs.getBoolean("tinhTrang");
			long tongTien = rs.getLong("tongTien");
			ds.add(new adminXacNhanHoaDonBean(maHoaDon, maKhachHang, hoTen, ngayMua, tinhTrang, tongTien));
		}
		cmd.close();
		kn.cn.close();
		return ds;
	}

	public int setTrueChiTietHoaDon(long maHoaDon) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "update chiTietHoaDon set tinhTrang ='True' where maHoaDon = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maHoaDon);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int setTrueHoaDon(long maHoaDon) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "update hoaDon set tinhTrang ='True' where maHoaDon = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maHoaDon);
		int kq = cmd.executeUpdate();
		setTrueChiTietHoaDon(maHoaDon);
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public ArrayList<CTHDViewBean> getCTHDViewBean(long maHoaDonInput) throws Exception {
		ArrayList<CTHDViewBean> ds = new ArrayList<CTHDViewBean>();
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select * from VXN where maHoaDon = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maHoaDonInput);
		ResultSet rs = cmd.executeQuery();

		while (rs.next()) {
			long maHoaDon = rs.getLong("maHoaDon");
			long maChiTietHoaDon = rs.getLong("maChiTietHoaDon");
			long maHang = rs.getLong("maHang");
			long maKhachHang = rs.getLong("maKhachHang");
			String hoTenKhachHang = rs.getString("hoTen");
			String tenHang = rs.getString("tenHang");
			long gia = rs.getLong("gia");
			long soLuongMua = rs.getLong("soLuongMua");
			String tenSize = rs.getString("tenSize");
			Date ngayMua = rs.getDate("ngayMua");
			boolean tinhTrang = rs.getBoolean("tinhTrang");
			ds.add(new CTHDViewBean(maHoaDon, maChiTietHoaDon, maHang, maKhachHang, hoTenKhachHang, tenHang, gia,
					soLuongMua, tenSize, ngayMua, tinhTrang));
		}

		rs.close();
		kn.cn.close();
		return ds;
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

}
