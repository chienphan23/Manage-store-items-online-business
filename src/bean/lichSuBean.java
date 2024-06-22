package bean;

import java.util.Date;

public class lichSuBean {
	private long maKhachHang;
	private long maHang;
	private String tenHang;
	private long gia;
	private long soLuongMua;
	private String anh;
	private boolean tinhTrang;
	private Date ngayMua;
	private String tenSize;
	private long thanhTien;

	public lichSuBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public lichSuBean(long maKhachHang, long maHang, String tenHang, long gia, long soLuongMua, String anh,
			boolean tinhTrang, Date ngayMua, String tenSize, long thanhTien) {
		super();
		this.maKhachHang = maKhachHang;
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.gia = gia;
		this.soLuongMua = soLuongMua;
		this.anh = anh;
		this.tinhTrang = tinhTrang;
		this.ngayMua = ngayMua;
		this.tenSize = tenSize;
		this.thanhTien = thanhTien;
	}

	public long getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(long maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public long getMaHang() {
		return maHang;
	}

	public void setMaHang(long maHang) {
		this.maHang = maHang;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public long getSoLuongMua() {
		return soLuongMua;
	}

	public void setSoLuongMua(long soLuongMua) {
		this.soLuongMua = soLuongMua;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public Date getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}

	public long getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(long thanhTien) {
		this.thanhTien = thanhTien;
	}

	public String getTenSize() {
		return tenSize;
	}

	public void setTenSize(String tenSize) {
		this.tenSize = tenSize;
	}

}
