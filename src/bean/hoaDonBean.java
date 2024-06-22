package bean;

import java.util.Date;

public class hoaDonBean {
	private long maHoaDon;
	private long maKhachHang;
	private Date ngayMua;
	private boolean tinhTrang;

	public hoaDonBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public hoaDonBean(long maHoaDon, long maKhachHang, Date ngayMua, boolean tinhTrang) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKhachHang = maKhachHang;
		this.ngayMua = ngayMua;
		this.tinhTrang = tinhTrang;
	}

	public long getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(long maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public long getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(long maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public Date getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

}
