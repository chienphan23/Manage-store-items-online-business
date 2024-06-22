package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class adminThongKeDao {
	public long TongTienTheoThang(int thang, int nam) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select sum(thanhTien) as 'tongTien' from VThongke where MONTH(ngayMua) = ? and YEAR(ngayMua) = ? and tinhTrang = 1";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, thang);
		cmd.setInt(2, nam);
		ResultSet rs = cmd.executeQuery();
		long kq = 0;
		if (rs.next()) {
			kq = rs.getLong("tongTien");
		}
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public long TongHangTheoThang(int thang, int nam) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select SUM(soLuongMua) as 'soLuong' from VThongke where MONTH(ngayMua) = ? and YEAR(ngayMua) = ? and tinhTrang = 1";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setInt(1, thang);
		cmd.setInt(2, nam);
		ResultSet rs = cmd.executeQuery();
		long kq = 0;
		if (rs.next()) {
			kq = rs.getLong("soLuong");
		}
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
