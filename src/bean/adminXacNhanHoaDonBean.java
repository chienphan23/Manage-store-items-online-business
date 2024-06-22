package bean;

import java.util.Date;

public class adminXacNhanHoaDonBean {
	private long maHoaDon;
	private long maKhachHang;
	private String hoTen;
	private Date ngayMua;
	private boolean tinhTrang;
	private long tongTien;

	public adminXacNhanHoaDonBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public adminXacNhanHoaDonBean(long maHoaDon, long maKhachHang, String hoTen, Date ngayMua, boolean tinhTrang,
			long tongTien) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKhachHang = maKhachHang;
		this.hoTen = hoTen;
		this.ngayMua = ngayMua;
		this.tinhTrang = tinhTrang;
		this.tongTien = tongTien;
	}

	public long getTongTien() {
		return tongTien;
	}

	public void setTongTien(long tongTien) {
		this.tongTien = tongTien;
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

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
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
