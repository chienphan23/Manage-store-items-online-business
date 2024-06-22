package bo;

import java.util.ArrayList;

import bean.loaibean;
import dao.loaidao;

public class loaibo {
	loaidao ldao = new loaidao();

	public ArrayList<loaibean> getdsLoai() throws Exception {
		return ldao.getdsL();
	}

	public loaibean getLoaiTheoMaLoai(long ml) throws Exception {
		return ldao.getDSLTheoMaLoai(ml);
	}
}
