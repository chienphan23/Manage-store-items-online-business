package bean;

public class chiTietHoaDonBean {
	private long maChiTietHoaDon;
	private long maHang;
	private long soLuongMua;
	private long maHoaDon;
	private String tenSize;
	private boolean tinhTrang;

	public chiTietHoaDonBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public chiTietHoaDonBean(long maChiTietHoaDon, long maHang, long soLuongMua, long maHoaDon, String tenSize,
			boolean tinhTrang) {
		super();
		this.maChiTietHoaDon = maChiTietHoaDon;
		this.maHang = maHang;
		this.soLuongMua = soLuongMua;
		this.maHoaDon = maHoaDon;
		this.tenSize = tenSize;
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

	public long getSoLuongMua() {
		return soLuongMua;
	}

	public void setSoLuongMua(long soLuongMua) {
		this.soLuongMua = soLuongMua;
	}

	public long getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(long maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getTenSize() {
		return tenSize;
	}

	public void setTenSize(String tenSize) {
		this.tenSize = tenSize;
	}

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

}
