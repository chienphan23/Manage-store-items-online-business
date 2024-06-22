package bo;

import java.util.ArrayList;

import bean.adminXacNhanBean;
import dao.adminXacNhanDao;

public class adminXacNhanBo {
	adminXacNhanDao adDao = new adminXacNhanDao();
	public ArrayList<adminXacNhanBean> dsXN = new ArrayList<adminXacNhanBean>();
	public ArrayList<adminXacNhanBean> dsDXN = new ArrayList<adminXacNhanBean>();

	public ArrayList<adminXacNhanBean> getDSXN() throws Exception {
		dsXN = adDao.getDSXN();
		return dsXN;
	}

	public int xacNhanChiTietHoaDon(long mact, long mahd, long soLuongMua, long maHang) throws Exception {
		return adDao.XacNhanCTHD(mact, mahd, soLuongMua, maHang);
	}

	public ArrayList<adminXacNhanBean> getDSDaXacNhan() throws Exception {
		dsDXN = adDao.getDSDaXacNhan();
		return dsDXN;
	}
}
