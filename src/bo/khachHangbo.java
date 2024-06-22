package bo;

import bean.khachHangBean;
import dao.khachHangDao;

public class khachHangbo {
	khachHangDao khdao = new khachHangDao();

	public khachHangBean ktDangNhap(String taiKhoan, String matKhau) throws Exception {
		return khdao.kiemTraDangNhap(taiKhoan, matKhau);
	}

	public int doimk(long makh, String mkc, String mkm) throws Exception {
		return khdao.doiMatKhau(makh, mkc, mkm);
	}

	public int doiAnhBo(long makh, String anh) throws Exception {
		return khdao.doiAnh(makh, anh);
	}

	public int dangKyBo(String hoTen, String taiKhoan, String matKhau, String diaChi, String soDienThoai, String anh)
			throws Exception {
		return khdao.dangKy(hoTen, taiKhoan, matKhau, diaChi, soDienThoai, anh);
	}

	public int doiThongTinBo(long makh, String hoTen, String diaChi, String sdt) throws Exception {
		return khdao.doiThongTin(makh, hoTen, diaChi, sdt);
	}
}
