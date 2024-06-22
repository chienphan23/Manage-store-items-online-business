package bean;

public class adminBean {
	private String taiKhoan;
	private String matKhau;
	private String hoTenAdmin;
	private String soDienThoai;
	private String soTaiKhoan;
	private String diaChi;
	private String email;

	public adminBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public adminBean(String taiKhoan, String matKhau, String hoTenAdmin, String soDienThoai, String soTaiKhoan,
			String diaChi, String email) {
		super();
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.hoTenAdmin = hoTenAdmin;
		this.soDienThoai = soDienThoai;
		this.soTaiKhoan = soTaiKhoan;
		this.diaChi = diaChi;
		this.email = email;
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

	public String getHoTenAdmin() {
		return hoTenAdmin;
	}

	public void setHoTenAdmin(String hoTenAdmin) {
		this.hoTenAdmin = hoTenAdmin;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getSoTaiKhoan() {
		return soTaiKhoan;
	}

	public void setSoTaiKhoan(String soTaiKhoan) {
		this.soTaiKhoan = soTaiKhoan;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
