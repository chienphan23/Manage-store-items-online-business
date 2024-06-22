package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class adminQuanLyHangHoaDao {
	public int ThemHang(String tenHang, long gia, long soLuong, String anh, long maLoai, long maKieuLoai)
			throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		Date a = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
		String ns = f.format(a);
		Date ngayMua = f.parse(ns);
		String sql = "insert into hangHoa(tenHang, gia, soLuong, anh, ngayNhap, maLoai, maKieuLoai) values (?,?,?,?,?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tenHang);
		cmd.setLong(2, gia);
		cmd.setLong(3, soLuong);
		cmd.setString(4, anh);
		java.sql.Date ngaySql = new java.sql.Date(ngayMua.getTime());
		cmd.setDate(5, ngaySql);
		cmd.setLong(6, maLoai);
		cmd.setLong(7, maKieuLoai);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public long getMaHang() throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select MAX(maHang) as 'max' from hangHoa";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		long max = 0;
		if (rs.next()) {
			max = rs.getLong("max");
		}
		cmd.close();
		kn.cn.close();
		return max;
	}

	public int ThemChiTietHang(long maHang, long maSize) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "insert into chiTietHangHoa(maHang, maSize) values(?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maHang);
		cmd.setLong(2, maSize);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int XoaHang(long maHang) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "delete from chiTietHangHoa where maHang = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maHang);
		int kq = cmd.executeUpdate();
		sql = "delete from hangHoa where maHang = ?";
		cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maHang);
		kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int XoaChiTietHang(long maHang, long maSize) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "delete from chiTietHangHoa where maHang = ? and maSize = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maHang);
		cmd.setLong(2, maSize);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int XoaChiTietHangVoiMaHang(long maHang) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "delete from chiTietHangHoa where maHang = ? ";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, maHang);

		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int SuaHangHoa(long maHang, String tenHang, long gia, long soLuong, String anh, long maLoai, long maKieuLoai)
			throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		Date a = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
		String ns = f.format(a);
		Date ngayMua = f.parse(ns);
		String sql = "update hangHoa set tenHang = ?, gia = ?, soLuong = ?, anh = ?, maLoai = ?, maKieuLoai = ? where maHang = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tenHang);
		cmd.setLong(2, gia);
		cmd.setLong(3, soLuong);
		cmd.setString(4, anh);
		cmd.setLong(5, maLoai);
		cmd.setLong(6, maKieuLoai);
		cmd.setLong(7, maHang);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
