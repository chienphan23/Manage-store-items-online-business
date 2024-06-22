package bo;

import dao.chiTietHoaDonDao;

public class chiTietHoaDonBo {
	chiTietHoaDonDao ctDao = new chiTietHoaDonDao();

	public int ThemCTHD(long maHang, long soLuongMua, long maHoaDon, String tenSize, boolean tinhTrang)
			throws Exception {
		return ctDao.ThemChiTiet(maHang, soLuongMua, maHoaDon, tenSize, tinhTrang);
	}
}
