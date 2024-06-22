package bean;

import java.util.Date;

public class CTHDViewBean {
	private long maHoaDon;
	private long maChiTietHoaDon;
	private long maHang;
	private long maKhachHang;
	private String hoTenKhachHang;
	private String tenHang;
	private long gia;
	private long soLuongMua;
	private String tenSize;
	private Date ngayMua;
	private boolean tinhTrang;

	public CTHDViewBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CTHDViewBean(long maHoaDon, long maChiTietHoaDon, long maHang, long maKhachHang, String hoTenKhachHang,
			String tenHang, long gia, long soLuongMua, String tenSize, Date ngayMua, boolean tinhTrang) {
		super();
		this.maHoaDon = maHoaDon;
		this.maChiTietHoaDon = maChiTietHoaDon;
		this.maHang = maHang;
		this.maKhachHang = maKhachHang;
		this.hoTenKhachHang = hoTenKhachHang;
		this.tenHang = tenHang;
		this.gia = gia;
		this.soLuongMua = soLuongMua;
		this.tenSize = tenSize;
		this.ngayMua = ngayMua;
		this.tinhTrang = tinhTrang;
	}

	public long getMaChiTietHoaDon() {
		return maChiTietHoaDon;
	}

	public void setMaChiTietHoaDon(long maChiTietHoaDon) {
		this.maChiTietHoaDon = maChiTietHoaDon;
	}

	public long getMaHang() {
		return maHang;
	}

	public void setMaHang(long maHang) {
		this.maHang = maHang;
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

	public String getHoTenKhachHang() {
		return hoTenKhachHang;
	}

	public void setHoTenKhachHang(String hoTenKhachHang) {
		this.hoTenKhachHang = hoTenKhachHang;
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

	public String getTenSize() {
		return tenSize;
	}

	public void setTenSize(String tenSize) {
		this.tenSize = tenSize;
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
