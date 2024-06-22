package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.khachHangBean;

public class khachHangDao {
	public khachHangBean kiemTraDangNhap(String taiKhoanInput, String matKhauInput) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select * from khachHang where taikhoan = ? and matKhau = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, taiKhoanInput);
		cmd.setString(2, matKhauInput);
		ResultSet rs = cmd.executeQuery();
		khachHangBean kh = null;
		if (rs.next()) {
			long maKhachHang = rs.getLong("maKhachHang");
			String hoTen = rs.getString("hoTen");
			String taiKhoan = rs.getString("taiKhoan");
			String matKhau = rs.getString("matKhau");
			String diaChi = rs.getString("diaChi");
			String soDienThoai = rs.getString("soDienThoai");
			String anh = rs.getString("anh");
			kh = new khachHangBean(maKhachHang, hoTen, taiKhoan, matKhau, diaChi, soDienThoai, anh);
		}
		rs.close();
		cmd.close();
		kn.cn.close();
		return kh;
	}

	public int doiMatKhau(long makh, String mkc, String mkm) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "update khachHang set matKhau = ? where maKhachHang = ? and matKhau = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, mkm);
		cmd.setLong(2, makh);
		cmd.setString(3, mkc);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int doiAnh(long makh, String anh) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "update khachHang set anh = ? where maKhachHang = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, anh);
		cmd.setLong(2, makh);

		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int dangKy(String hoTen, String taiKhoan, String matKhau, String diaChi, String soDienThoai, String anh)
			throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql1 = "select * from khachHang where taiKhoan = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql1);
		cmd.setString(1, taiKhoan);
		ResultSet rs = cmd.executeQuery();
		if (rs.next()) {
			return 0;
		}

		String sql = "insert into khachHang(hoTen, taiKhoan, matKhau, diaChi, soDienThoai, anh) values(?,?,?,?,?,?)";
		cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, hoTen);
		cmd.setString(2, taiKhoan);
		cmd.setString(3, matKhau);
		cmd.setString(4, diaChi);
		cmd.setString(5, soDienThoai);
		cmd.setString(6, anh);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int doiThongTin(long makh, String hoTen, String diaChi, String sdt) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "update khachHang set hoTen = ? , diaChi = ? , soDienThoai = ? where maKhachHang = ? ";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, hoTen);
		cmd.setString(2, diaChi);
		cmd.setString(3, sdt);
		cmd.setLong(4, makh);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
