package qlttn.entity;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

public class TaiKhoanEntity {
	@NotBlank(message = "Mã tài khoản không được để trống!")
	private String maTaiKhoan;

	@NotBlank(message = "Họ không được để trống!")
	private String ho;

	@NotBlank(message = "Tên không được để trống!")
	private String ten;

	@NotBlank(message = "Email không được để trống!")
	private String email;
                                   
	@NotBlank(message = "Mật khẩu không được để trống!")
	private String matKhau;

	private String loai;

	private List<CauHoiEntity> cauHoi = new ArrayList<>();

	private List<ChiTietThiEntity> chiTietThi = new ArrayList<>();

	public TaiKhoanEntity() {
		super();
	}

	public TaiKhoanEntity(String maTaiKhoan, String ho, String ten, String email, String matKhau, String loai,
			List<CauHoiEntity> cauHoi, List<ChiTietThiEntity> chiTietThi) {
		super();
		this.maTaiKhoan = maTaiKhoan;
		this.ho = ho;
		this.ten = ten;
		this.email = email;
		this.matKhau = matKhau;
		this.loai = loai;
		this.cauHoi = cauHoi;
		this.chiTietThi = chiTietThi;
	}

	public String getMaTaiKhoan() {
		return maTaiKhoan;
	}

	public void setMaTaiKhoan(String maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public List<CauHoiEntity> getCauHoi() {
		return cauHoi;
	}

	public void setCauHoi(List<CauHoiEntity> cauHoi) {
		this.cauHoi = cauHoi;
	}

	public List<ChiTietThiEntity> getChiTietThi() {
		return chiTietThi;
	}

	public void setChiTietThi(List<ChiTietThiEntity> chiTietThi) {
		this.chiTietThi = chiTietThi;
	}
	
	
}
