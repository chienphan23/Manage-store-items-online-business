package bean;

import java.util.Date;

public class hangHoaBean {
	private long maHang;
	private String tenHang;
	private long gia;
	private long soLuong;
	private String anh;
	private Date ngayNhap;
	private long maLoai;
	private long maKieu;

	public hangHoaBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public hangHoaBean(long maHang, String tenHang, long gia, long soLuong, String anh, Date ngayNhap, long maLoai,
			long maKieu) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.gia = gia;
		this.soLuong = soLuong;
		this.anh = anh;
		this.ngayNhap = ngayNhap;
		this.maLoai = maLoai;
		this.maKieu = maKieu;
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

	public long getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(long soLuong) {
		this.soLuong = soLuong;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public long getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(long maLoai) {
		this.maLoai = maLoai;
	}

	public long getMaKieu() {
		return maKieu;
	}

	public void setMaKieu(long maKieu) {
		this.maKieu = maKieu;
	}

}
