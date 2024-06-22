package bo;

import java.util.ArrayList;

import bean.sizeBean;
import dao.sizeDao;

public class sizeBo {
	sizeDao sDao = new sizeDao();

	public ArrayList<sizeBean> getDSSize() throws Exception {
		return sDao.getDSSize();
	}
}
