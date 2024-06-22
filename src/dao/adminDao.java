package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.adminBean;

public class adminDao {
	public adminBean dangNhap(String tk, String mk) throws Exception {
		ketnoidao kn = new ketnoidao();
		adminBean admin = null;
		kn.ketnoi();
		String sql = "select * from admin where taiKhoan = ? and matKhau = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tk);
		cmd.setString(2, mk);
		ResultSet rs = cmd.executeQuery();
		if (rs.next()) {
			String taiKhoan = rs.getString("taiKhoan");
			String matKhau = rs.getString("matKhau");
			String hoTenAdmin = rs.getString("hoTenAdmin");
			String soDienThoai = rs.getString("soDienThoai");
			String soTaiKhoan = rs.getString("SoTaiKhoan");
			String diaChi = rs.getString("diaChi");
			String email = rs.getString("email");
			String tenShop = rs.getString("tenShop");
			admin = new adminBean(taiKhoan, matKhau, hoTenAdmin, soDienThoai, soTaiKhoan, diaChi, email);
		}
		cmd.close();
		kn.cn.close();
		return admin;
	}

	public int SuaThongTin(String tk, String hoTenAdmin, String soDienThoai, String soTaiKhoan, String diaChi,
			String email) throws Exception {
		ketnoidao kn = new ketnoidao();
		adminBean admin = null;
		kn.ketnoi();
		String sql = "update admin set hoTenAdmin=? , soDienThoai = ?, soTaiKhoan = ?, diaChi = ?, email = ? where taiKhoan = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, hoTenAdmin);
		cmd.setString(2, soDienThoai);
		cmd.setString(3, soTaiKhoan);
		cmd.setString(4, diaChi);
		cmd.setString(5, email);
		cmd.setString(6, tk);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

}
