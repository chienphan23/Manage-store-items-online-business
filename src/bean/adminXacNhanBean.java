package bean;

import java.util.Date;

public class adminXacNhanBean {
	private long maHang;
	private long maHoaDon;
	private long maChiTietHoaDon;
	private String hoTenKhachHang;
	private long maKhachHang;
	private String anh;
	private String tenHang;
	private long gia;
	private long soLuongMua;
	private Date ngayMua;
	private String tenSize;
	private long ThanhTien;
	private boolean tinhTrang;

	public adminXacNhanBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getMaHang() {
		return maHang;
	}

	public void setMaHang(long maHang) {
		this.maHang = maHang;
	}

	public adminXacNhanBean(long maHang, long maHoaDon, long maChiTietHoaDon, String hoTenKhachHang, long maKhachHang,
			String anh, String tenHang, long gia, long soLuongMua, Date ngayMua, String tenSize, long thanhTien,
			boolean tinhTrang) {
		super();
		this.maHang = maHang;
		this.maHoaDon = maHoaDon;
		this.maChiTietHoaDon = maChiTietHoaDon;
		this.hoTenKhachHang = hoTenKhachHang;
		this.maKhachHang = maKhachHang;
		this.anh = anh;
		this.tenHang = tenHang;
		this.gia = gia;
		this.soLuongMua = soLuongMua;
		this.ngayMua = ngayMua;
		this.tenSize = tenSize;
		ThanhTien = thanhTien;
		this.tinhTrang = tinhTrang;
	}

	public long getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(long maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public long getMaChiTietHoaDon() {
		return maChiTietHoaDon;
	}

	public void setMaChiTietHoaDon(long maChiTietHoaDon) {
		this.maChiTietHoaDon = maChiTietHoaDon;
	}

	public String getHoTenKhachHang() {
		return hoTenKhachHang;
	}

	public void setHoTenKhachHang(String hoTenKhachHang) {
		this.hoTenKhachHang = hoTenKhachHang;
	}

	public long getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(long maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
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

	public Date getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}

	public String getTenSize() {
		return tenSize;
	}

	public void setTenSize(String tenSize) {
		this.tenSize = tenSize;
	}

	public long getThanhTien() {
		return ThanhTien;
	}

	public void setThanhTien(long thanhTien) {
		ThanhTien = thanhTien;
	}

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

}
