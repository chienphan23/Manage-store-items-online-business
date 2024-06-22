package bo;

import java.util.ArrayList;

import bean.gioHangBean;

public class gioHangBo {

	public ArrayList<gioHangBean> dsgio = new ArrayList<gioHangBean>();

	public void ThemHang(long maHang, String tenHang, long gia, long soLuongMua, String anh, long size)
			throws Exception {
		int n = dsgio.size();
		for (int i = 0; i < n; i++) {
			if (dsgio.get(i).getMaHang() == maHang) {
				dsgio.get(i).setSoLuongMua(dsgio.get(i).getSoLuongMua() + 1);
				return;
			}
		}

		dsgio.add(new gioHangBean(maHang, tenHang, gia, soLuongMua, anh, size));

	}

	public void Sua(long maHang, long soLuong) throws Exception {
		int n = dsgio.size();
		for (int i = 0; i < n; i++) {
			if (dsgio.get(i).getMaHang() == maHang) {
				dsgio.get(i).setSoLuongMua(soLuong);
				;
				return;
			}
		}
	}

	public void Xoa(long maHang) throws Exception {
		int n = dsgio.size();
		for (int i = 0; i < n; i++) {
			if (dsgio.get(i).getMaHang() == maHang) {
				dsgio.remove(i);
				return;
			}
		}
	}

	public void xoaAll() throws Exception {
		dsgio.clear();
		return;
	}
}
