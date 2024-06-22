package bean;

public class khachHangBean {
	private long maKhachHang;
	private String hoTen;
	private String taiKhoan;
	private String matKhau;
	private String diaChi;
	private String soDienThoai;
	private String anh;

	public khachHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public khachHangBean(long maKhachHang, String hoTen, String taiKhoan, String matKhau, String diaChi,
			String soDienThoai, String anh) {
		super();
		this.maKhachHang = maKhachHang;
		this.hoTen = hoTen;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.anh = anh;
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

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

}
