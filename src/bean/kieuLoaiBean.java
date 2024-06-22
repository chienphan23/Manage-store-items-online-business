package bean;

public class kieuLoaiBean {
	private long maKieuLoai;
	private String tenKieuLoai;
	private long maLoai;

	public kieuLoaiBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public kieuLoaiBean(long maKieuLoai, String tenKieuLoai, long maLoai) {
		super();
		this.maKieuLoai = maKieuLoai;
		this.tenKieuLoai = tenKieuLoai;
		this.maLoai = maLoai;
	}

	public long getMaKieuLoai() {
		return maKieuLoai;
	}

	public void setMaKieuLoai(long maKieuLoai) {
		this.maKieuLoai = maKieuLoai;
	}

	public String getTenKieuLoai() {
		return tenKieuLoai;
	}

	public void setTenKieuLoai(String tenKieuLoai) {
		this.tenKieuLoai = tenKieuLoai;
	}

	public long getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(long maLoai) {
		this.maLoai = maLoai;
	}

}
