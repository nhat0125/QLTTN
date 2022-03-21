package qlttn.entity;

import javax.validation.constraints.NotBlank;

public class CauHoiEntity {
	private int idCH;

	@NotBlank(message = "Nội dung không được để trống!")
	private String noiDung;

	@NotBlank(message = "Lựa chọn A không được để trống!")
	private String a;

	@NotBlank(message = "Lựa chọn B không được để trống!")
	private String b;

	@NotBlank(message = "Lựa chọn C không được để trống!")
	private String c;

	@NotBlank(message = "Lựa chọn D không được để trống!")
	private String d;

	@NotBlank(message = "Đáp án không được để trống!")
	private String dapAn;

	private String luaChon;

	private String maTaiKhoan;

	private String maMonHoc;

	public CauHoiEntity(int idCH, String noiDung, String a, String b, String c, String d, String dapAn, String luaChon,
			String maTaiKhoan, String maMonHoc) {
		super();
		this.idCH = idCH;
		this.noiDung = noiDung;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.dapAn = dapAn;
		this.luaChon = luaChon;
		this.maTaiKhoan = maTaiKhoan;
		this.maMonHoc = maMonHoc;
	}
	
	public CauHoiEntity(){
		super();
	}

	public int getIdCH() {
		return idCH;
	}

	public void setIdCH(int idCH) {
		this.idCH = idCH;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getDapAn() {
		return dapAn;
	}

	public void setDapAn(String dapAn) {
		this.dapAn = dapAn;
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
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

}
