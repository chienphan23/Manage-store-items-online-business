package bean;

public class loaibean {
	private long maLoai;
	private String tenloai;

	public loaibean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public loaibean(long maLoai, String tenloai) {
		super();
		this.maLoai = maLoai;
		this.tenloai = tenloai;
	}

	public long getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(long maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenloai() {
		return tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}

}
