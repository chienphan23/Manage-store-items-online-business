package bo;

import bean.adminBean;
import dao.adminDao;

public class adminBo {
	adminDao admin = new adminDao();

	public adminBean dangNhap(String tk, String mk) throws Exception {
		return admin.dangNhap(tk, mk);
	}

	public int SuaThongTin(String tk, String hoTenAdmin, String soDienThoai, String soTaiKhoan, String diaChi,
			String email) throws Exception {
		return admin.SuaThongTin(tk, hoTenAdmin, soDienThoai, soTaiKhoan, diaChi, email);
	}
}
