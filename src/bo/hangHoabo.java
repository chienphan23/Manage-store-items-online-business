package bo;

import java.util.ArrayList;

import bean.chiTietHangHoaBean;
import bean.hangHoaBean;
import dao.hangHoaDao;

public class hangHoabo {
	hangHoaDao hdao = new hangHoaDao();
	ArrayList<hangHoaBean> ds;

	public ArrayList<hangHoaBean> getAllHangHoabo() throws Exception {
		ds = hdao.getAllHangHoa();
		return hdao.getAllHangHoa();
	}

	public ArrayList<hangHoaBean> search(String tenHang) throws Exception {
		ds = hdao.getAllHangHoa();
		ArrayList<hangHoaBean> tam = new ArrayList<hangHoaBean>();
		for (hangHoaBean h : ds) {
			if (h.getTenHang().toLowerCase().contains(tenHang.toLowerCase())) {
				tam.add(h);
			}
		}
		return tam;
	}

	public hangHoaBean getOneHangHoaBo(long maHang) throws Exception {
		hangHoaBean hh = hdao.getOneHangHoa(maHang);
		return hh;
	}

	public ArrayList<chiTietHangHoaBean> getChiTietHangHoaBo(long maHang) throws Exception {

		return hdao.getChiTietHangHoa(maHang);
	}

	public ArrayList<hangHoaBean> dsFilter(long maLoai) throws Exception {
		ArrayList<hangHoaBean> tam = new ArrayList<hangHoaBean>();
		for (hangHoaBean h : ds) {
			if (h.getMaLoai() == maLoai) {
				tam.add(h);
			}
		}
		return tam;
	}

	public ArrayList<hangHoaBean> dsKieuLoaiFilter(long maKieuLoai) throws Exception {
		ArrayList<hangHoaBean> tam = new ArrayList<hangHoaBean>();
		for (hangHoaBean h : ds) {
			if (h.getMaKieu() == maKieuLoai) {
				tam.add(h);
			}
		}
		return tam;
	}

	public ArrayList<hangHoaBean> dsGiaFilter(long gia) throws Exception {
		ArrayList<hangHoaBean> tam = new ArrayList<hangHoaBean>();
		for (hangHoaBean h : ds) {
			if (h.getGia() < gia) {
				tam.add(h);
			}
		}
		return tam;
	}

}
