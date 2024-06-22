package bo;

import java.util.ArrayList;

import bean.CTHDViewBean;
import bean.adminXacNhanHoaDonBean;
import dao.adminXacNhanHoaDonDao;

public class adminXacNhanHoaDonBo {
	adminXacNhanHoaDonDao adXNHDDao = new adminXacNhanHoaDonDao();
	public ArrayList<adminXacNhanHoaDonBean> dsXNHD = new ArrayList<adminXacNhanHoaDonBean>();
	public ArrayList<adminXacNhanHoaDonBean> dsDXN = new ArrayList<adminXacNhanHoaDonBean>();

	public ArrayList<adminXacNhanHoaDonBean> getDSXNHD() throws Exception {
		dsXNHD = adXNHDDao.dsXNHD();
		return dsXNHD;
	}

	public ArrayList<adminXacNhanHoaDonBean> getDSDaXacNhan() throws Exception {
		dsDXN = adXNHDDao.dsHDDXN();
		return dsDXN;
	}

	public int XacNhanHoaDon(long mahd) throws Exception {
		return adXNHDDao.setTrueHoaDon(mahd);
	}

	public ArrayList<CTHDViewBean> getChiTietHoaDon(long mahd) throws Exception {
		return adXNHDDao.getCTHDViewBean(mahd);
	}

	public int updateSoLuongKhiXacNhan(long soLuongMua, long maHang) throws Exception {
		return adXNHDDao.setSoLuongTon(soLuongMua, maHang);
	}
}
