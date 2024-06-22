package bo;

import java.util.ArrayList;

import bean.lichSuBean;
import dao.lichSuDao;

public class lichSuBo {
	lichSuDao lsDao = new lichSuDao();

	public ArrayList<lichSuBean> dsls(long makh, boolean tinhTrang) throws Exception {
		return lsDao.getLichSu(makh, tinhTrang);
	}
}
