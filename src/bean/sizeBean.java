package bean;

public class sizeBean {
	private long maSize;
	private String tenSize;

	public sizeBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public sizeBean(long maSize, String tenSize) {
		super();
		this.maSize = maSize;
		this.tenSize = tenSize;
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
