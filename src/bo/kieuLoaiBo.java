package bo;

import java.util.ArrayList;

import bean.kieuLoaiBean;
import dao.kieuLoaiDao;

public class kieuLoaiBo {
	kieuLoaiDao klDao = new kieuLoaiDao();

	public ArrayList<kieuLoaiBean> dsKieuLoai() throws Exception {
		return klDao.getdsL();
	}

	public ArrayList<kieuLoaiBean> dsKieuLoaiTheoMaLoai(long ml) throws Exception {
		return klDao.getdsLTheoMaLoai(ml);
	}

}
