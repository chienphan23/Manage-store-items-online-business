package bo;

import dao.adminThongKeDao;

public class adminThongKeBo {
	adminThongKeDao adTK = new adminThongKeDao();

	public long ThongKeTheoThang(int thang, int nam) throws Exception {
		return adTK.TongTienTheoThang(thang, nam);
	}

	public long ThongSoLuongTheoThang(int thang, int nam) throws Exception {
		return adTK.TongHangTheoThang(thang, nam);
	}
}
