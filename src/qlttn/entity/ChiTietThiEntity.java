package qlttn.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChiTietThiEntity { 
	private int idCTT;
	
    private String ngayThi;

    private double diem;

    private String maTaiKhoan;

    private String maMonHoc;
    
    private String hoTen;
    
    private String tenMonHoc;

	public ChiTietThiEntity() {
		super();
	}

	public ChiTietThiEntity(int idCTT, String ngayThi, double diem, String maTaiKhoan, String maMonHoc, String hoTen,
			String tenMonHoc) {
		super();
		this.idCTT = idCTT;
		this.ngayThi = ngayThi;
		this.diem = diem;
		this.maTaiKhoan = maTaiKhoan;
		this.maMonHoc = maMonHoc;
		this.hoTen = hoTen;
		this.tenMonHoc = tenMonHoc;
	}

	public int getIdCTT() {
		return idCTT;
	}

	public void setIdCTT(int idCTT) {
		this.idCTT = idCTT;
	}

	public String getNgayThi() {
		return ngayThi;
	}

	public void setNgayThi(String ngayThi) {
		this.ngayThi = ngayThi;
	}

	public double getDiem() {
		return diem;
	}

	public void setDiem(double diem) {
		this.diem = diem;
	}

	public String getMaTaiKhoan() {
		return maTaiKhoan;
	}

	public void setMaTaiKhoan(String maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}

	public String getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}
    
    
}
