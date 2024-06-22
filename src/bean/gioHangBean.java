package bean;

public class gioHangBean {
	private long maHang;
	private String tenHang;
	private long gia;
	private long soLuongMua;
	private String anh;
	private long size;
	private long thanhTien;

	public gioHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public gioHangBean(long maHang, String tenHang, long gia, long soLuongMua, String anh, long size) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.gia = gia;
		this.soLuongMua = soLuongMua;
		this.anh = anh;
		this.size = size;
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

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public long getThanhTien() {
		return soLuongMua * gia;
	}
}
