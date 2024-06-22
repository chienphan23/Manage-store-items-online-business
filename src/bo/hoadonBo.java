package bo;

import java.util.Date;

import dao.hoaDonDao;

public class hoadonBo {
	hoaDonDao hdDao = new hoaDonDao();

	public int ThemHD(long maKhachHang, Date ngayMua, boolean tinhTrang) throws Exception {
		return hdDao.ThemHoaDon(maKhachHang, ngayMua, tinhTrang);
	}

	public long getMaHoaDon() throws Exception {
		return hdDao.getMaHoaDon();
	}
}
