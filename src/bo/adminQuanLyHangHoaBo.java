package bo;

import dao.adminQuanLyHangHoaDao;

public class adminQuanLyHangHoaBo {
	adminQuanLyHangHoaDao adDao = new adminQuanLyHangHoaDao();

	public int ThemHang(String tenHang, long gia, long soLuong, String anh, long maLoai, long maKieuLoai)
			throws Exception {
		return adDao.ThemHang(tenHang, gia, soLuong, anh, maLoai, maKieuLoai);
	}

	public long GetMaHang() throws Exception {
		return adDao.getMaHang();
	}

	public int ThemChiTietHang(long maHang, long maSize) throws Exception {
		return adDao.ThemChiTietHang(maHang, maSize);
	}

	public int XoaHang(long maHang) throws Exception {
		return adDao.XoaHang(maHang);
	}

	public int XoaChiTietHang(long maHang, long maSize) throws Exception {
		return adDao.XoaChiTietHang(maHang, maSize);
	}

	public int xoaChiTietVoiMaHang(long maHang) throws Exception {
		return adDao.XoaChiTietHangVoiMaHang(maHang);
	}

	public int SuaHang(long maHang, String tenHang, long gia, long soLuong, String anh, long maLoai, long maKieuLoai)
			throws Exception {
		return adDao.SuaHangHoa(maHang, tenHang, gia, soLuong, anh, maLoai, maKieuLoai);
	}
}
