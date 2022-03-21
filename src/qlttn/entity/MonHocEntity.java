package qlttn.entity;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

public class MonHocEntity {
	@NotBlank(message = "Mã môn học không được để trống!")
	private String maMonHoc;

	@NotBlank(message = "Tên môn học không được để trống!")
	private String tenMonHoc;

	private List<CauHoiEntity> cauHoi = new ArrayList<>();

	private List<ChiTietThiEntity> chiTietThi = new ArrayList<>();

	public MonHocEntity(String maMonHoc, String tenMonHoc, List<CauHoiEntity> cauHoi,
			List<ChiTietThiEntity> chiTietThi) {
		super();
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.cauHoi = cauHoi;
		this.chiTietThi = chiTietThi;
	}
	
	public MonHocEntity(){
		
	}

	public String getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
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
