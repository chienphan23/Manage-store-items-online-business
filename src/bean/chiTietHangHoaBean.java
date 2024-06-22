package bean;

public class chiTietHangHoaBean {
	private long maHang;
	private long maSize;
	private String tenSize;

	public chiTietHangHoaBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public chiTietHangHoaBean(long maHang, long maSize, String tenSize) {
		super();
		this.maHang = maHang;
		this.maSize = maSize;
		this.tenSize = tenSize;
	}

	public long getMaHang() {
		return maHang;
	}

	public void setMaHang(long maHang) {
		this.maHang = maHang;
	}

	public long getMaSize() {
		return maSize;
	}

	public void setMaSize(long maSize) {
		this.maSize = maSize;
	}

	public String getTenSize() {
		return tenSize;
	}

	public void setTenSize(String tenSize) {
		this.tenSize = tenSize;
	}

}
