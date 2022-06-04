package qlttn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import qlttn.api.CauHoiAPI;
import qlttn.api.ChiTietThiAPI;
import qlttn.api.MonHocAPI;
import qlttn.api.TaiKhoanAPI;
import qlttn.entity.CauHoiEntity;
import qlttn.entity.ChiTietThiEntity;
import qlttn.entity.MonHocEntity;
import qlttn.entity.TaiKhoanEntity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Controller
@RequestMapping("giangvien")
public class GiangVienController {
	public static List<TaiKhoanEntity> dSGiangVien = null;
	public static List<TaiKhoanEntity> dSSinhVien = null;
	public static List<CauHoiEntity> dSCauHoi = null;
	public static List<MonHocEntity> dSMonHoc = null;
	public static List<ChiTietThiEntity> dSCTT = null;
	public static TaiKhoanEntity tK = null; // lấy tài khoản cần sửa
	public static CauHoiEntity cH = null; // câu hỏi cần sửa
	public static MonHocEntity mH = null; // môn học cần sửa
	public static String success;
	public static String error;

	public void layDSGiangVien() {
		TaiKhoanAPI.apiTaiKhoanService.layDSTheoLoai("GV", "#").enqueue(new Callback<List<TaiKhoanEntity>>() {
			@Override
			public void onResponse(Call<List<TaiKhoanEntity>> call, Response<List<TaiKhoanEntity>> response) {
				dSGiangVien = response.body();
			}

			@Override
			public void onFailure(Call<List<TaiKhoanEntity>> call, Throwable t) {
				error = "Lấy danh sách không thành công!";

			}
		});
		return;
	}

	public void layDSSinhVien() {
		TaiKhoanAPI.apiTaiKhoanService.layDSTheoLoai("SV", "#").enqueue(new Callback<List<TaiKhoanEntity>>() {

			@Override
			public void onResponse(Call<List<TaiKhoanEntity>> call, Response<List<TaiKhoanEntity>> response) {
				dSSinhVien = response.body();
			}

			@Override
			public void onFailure(Call<List<TaiKhoanEntity>> call, Throwable t) {
				error = "Lấy danh sách không thành công!";

			}
		});
		return;
	}

	public void layDSCauHoi() {
		CauHoiAPI.apiCauHoiService.layDSCauHoi().enqueue(new Callback<List<CauHoiEntity>>() {

			@Override
			public void onResponse(Call<List<CauHoiEntity>> call, Response<List<CauHoiEntity>> response) {
				dSCauHoi = response.body();

			}

			@Override
			public void onFailure(Call<List<CauHoiEntity>> call, Throwable t) {
				error = "Lấy danh sách không thành công!";

			}
		});
	}

	public void themTaiKhoan(TaiKhoanEntity taiKhoan) {
		Call<TaiKhoanEntity> call = TaiKhoanAPI.apiTaiKhoanService.themTaiKhoan(taiKhoan);
		call.enqueue(new Callback<TaiKhoanEntity>() {

			@Override
			public void onResponse(Call<TaiKhoanEntity> call, Response<TaiKhoanEntity> response) {
				if (response.isSuccessful()) {
					success = "Thêm tài khoản thành công!";
					return;
				}

			}

			@Override
			public void onFailure(Call<TaiKhoanEntity> call, Throwable t) {
				error = "Thêm tài khoản không thành công!";
				System.out.print("Thêm thất bại");
			}
		});
	}

	public void themCauHoi(CauHoiEntity cauHoi) {
		Call<CauHoiEntity> call = CauHoiAPI.apiCauHoiService.themCauHoi(cauHoi);
		call.enqueue(new Callback<CauHoiEntity>() {

			@Override
			public void onResponse(Call<CauHoiEntity> call, Response<CauHoiEntity> response) {
				if (response.isSuccessful()) {
					success = "Thêm câu hỏi thành công!";
					return;
				}

			}

			@Override
			public void onFailure(Call<CauHoiEntity> call, Throwable t) {
				error = "Thêm câu hỏi không thành công!";

			}
		});
	}

	public void themMonHoc(MonHocEntity monHoc) {
		Call<MonHocEntity> call = MonHocAPI.apiMonHocService.themMonHoc(monHoc);
		call.enqueue(new Callback<MonHocEntity>() {

			@Override
			public void onResponse(Call<MonHocEntity> call, Response<MonHocEntity> response) {
				if (response.isSuccessful()) {
					success = "Thêm môn học thành công!";
					return;
				}

			}

			@Override
			public void onFailure(Call<MonHocEntity> call, Throwable t) {
				error = "Thêm môn học không thành công!";

			}
		});
	}

	public void layTaiKhoan(String maTaiKhoan) {
		Call<TaiKhoanEntity> call = TaiKhoanAPI.apiTaiKhoanService.layTaiKhoan(maTaiKhoan);
		call.enqueue(new Callback<TaiKhoanEntity>() {

			@Override
			public void onResponse(Call<TaiKhoanEntity> call, Response<TaiKhoanEntity> response) {
				tK = response.body();

			}

			@Override
			public void onFailure(Call<TaiKhoanEntity> call, Throwable t) {
				// TODO Auto-generated method stub

			}
		});
		return;
	}

	public void layCauHoi(Integer idCH) {
		Call<CauHoiEntity> call = CauHoiAPI.apiCauHoiService.layCauHoi(idCH);
		call.enqueue(new Callback<CauHoiEntity>() {

			@Override
			public void onResponse(Call<CauHoiEntity> call, Response<CauHoiEntity> response) {
				cH = response.body();

			}

			@Override
			public void onFailure(Call<CauHoiEntity> call, Throwable t) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void layMonHoc(String maMonHoc) {
		Call<MonHocEntity> call = MonHocAPI.apiMonHocService.layMonHoc(maMonHoc);
		call.enqueue(new Callback<MonHocEntity>() {

			@Override
			public void onResponse(Call<MonHocEntity> call, Response<MonHocEntity> response) {
				mH = response.body();

			}

			@Override
			public void onFailure(Call<MonHocEntity> call, Throwable t) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void layDSCTT(String maMonHoc) {
		ChiTietThiAPI.apiChiTietThiService.layDSChiTietThiTheoMon(maMonHoc)
				.enqueue(new Callback<List<ChiTietThiEntity>>() {

					@Override
					public void onResponse(Call<List<ChiTietThiEntity>> call,
							Response<List<ChiTietThiEntity>> response) {
						dSCTT = response.body();

					}

					@Override
					public void onFailure(Call<List<ChiTietThiEntity>> call, Throwable t) {
						error =  "Lấy danh sách không thành công!";

					}
				});
	}

	public void suaTaiKhoan(TaiKhoanEntity taiKhoan) {
		Call<TaiKhoanEntity> call = TaiKhoanAPI.apiTaiKhoanService.suaTaiKhoan(taiKhoan);
		call.enqueue(new Callback<TaiKhoanEntity>() {

			@Override
			public void onResponse(Call<TaiKhoanEntity> call, Response<TaiKhoanEntity> response) {
				if (response.isSuccessful()) {
					success = "Sửa tài khoản thành công!";
					return;
				}

			}

			@Override
			public void onFailure(Call<TaiKhoanEntity> call, Throwable t) {
				error = "Sửa tài khoản không thành công!";
			}
		});
	}

	public void suaCauHoi(CauHoiEntity cauHoi) {
		Call<CauHoiEntity> call = CauHoiAPI.apiCauHoiService.suaCauHoi(cauHoi);
		call.enqueue(new Callback<CauHoiEntity>() {

			@Override
			public void onResponse(Call<CauHoiEntity> call, Response<CauHoiEntity> response) {
				if (response.isSuccessful()) {
					success = "Sửa câu hỏi thành công!";
					return;
				}

			}

			@Override
			public void onFailure(Call<CauHoiEntity> call, Throwable t) {
				error = "Sửa câu hỏi không thành công!";

			}
		});
	}

	public void suaMonHoc(MonHocEntity monHoc) {
		Call<MonHocEntity> call = MonHocAPI.apiMonHocService.suaMonHoc(monHoc);
		call.enqueue(new Callback<MonHocEntity>() {

			@Override
			public void onResponse(Call<MonHocEntity> call, Response<MonHocEntity> response) {
				if (response.isSuccessful()) {
					success = "Sửa môn học thành công!";
					return;
				}

			}

			@Override
			public void onFailure(Call<MonHocEntity> call, Throwable t) {
				error = "Sửa môn học không thành công!";

			}
		});
	}

	public void xoaTaiKhoan(String maTaiKhoan) {
		Call<Void> call = TaiKhoanAPI.apiTaiKhoanService.xoaTaiKhoan(maTaiKhoan);
		call.enqueue(new Callback<Void>() {

			@Override
			public void onResponse(Call<Void> call, Response<Void> response) {
				if (response.isSuccessful()) {
					success = "Xóa tài khoản thành công!";
					return;
				}

			}

			@Override
			public void onFailure(Call<Void> call, Throwable t) {
				error = "Xoá tài khoản không thành công!";
			}
		});
	}

	public void xoaCauHoi(Integer idCH) {
		Call<Void> call = CauHoiAPI.apiCauHoiService.xoaCauHoi(idCH);
		call.enqueue(new Callback<Void>() {

			@Override
			public void onResponse(Call<Void> call, Response<Void> response) {
				if (response.isSuccessful()) {
					success = "Xóa câu hỏi thành công!";
					return;
				}

			}

			@Override
			public void onFailure(Call<Void> call, Throwable t) {
				error = "Xoá câu hỏi không thành công!";

			}
		});
	}

	public void xoaMonHoc(String maMonHoc) {
		Call<Void> call = MonHocAPI.apiMonHocService.xoaMonHoc(maMonHoc);
		call.enqueue(new Callback<Void>() {

			@Override
			public void onResponse(Call<Void> call, Response<Void> response) {
				if (response.isSuccessful()) {
					success = "Xóa môn học thành công!";
					return;
				}

			}

			@Override
			public void onFailure(Call<Void> call, Throwable t) {
				error = "Xoá môn học không thành công!";

			}
		});
	}

	public void layDSMonHoc() {
		MonHocAPI.apiMonHocService.layDSMonHoc().enqueue(new Callback<List<MonHocEntity>>() {

			@Override
			public void onResponse(Call<List<MonHocEntity>> call, Response<List<MonHocEntity>> response) {
				dSMonHoc = response.body();
			}

			@Override
			public void onFailure(Call<List<MonHocEntity>> call, Throwable t) {
				error = "Lấy danh sách không thành công!";

			}
		});
		return;
	}
	
	public void resetMessage(){
		success = "";
		error = "";
	}

	// ---------TAI KHOAN GIANG VIEN-----------------------------
	@RequestMapping("dsgiangvien")
	public String layDSGiangVien(ModelMap model) throws Exception {
		resetMessage();
		layDSGiangVien();
		Thread.sleep(1000);
		model.addAttribute("giangvien", new TaiKhoanEntity());
		model.addAttribute("dsgiangvien", dSGiangVien);
		model.addAttribute("btnTrangThai", "btnAdd");
		model.addAttribute("error", error);
		return "giangvien/giangvien";
	}

	@RequestMapping(value = "tsxgv", params = "btnAdd")
	public String themGiangVien(ModelMap model, @Validated @ModelAttribute("giangvien") TaiKhoanEntity giangVien,
			BindingResult errors) throws Exception {
		resetMessage();
		giangVien.setLoai("GV");
		themTaiKhoan(giangVien);
		Thread.sleep(1000);
		model.addAttribute("success", success);
		model.addAttribute("error", error);
		layDSGiangVien();
		Thread.sleep(1000);
		model.addAttribute("giangvien", new TaiKhoanEntity());
		model.addAttribute("dsgiangvien", dSGiangVien);
		model.addAttribute("btnTrangThai", "btnAdd");
		return "giangvien/giangvien";
	}

	@RequestMapping(value = "/{maTaiKhoan}.htm", params = "linkEdit")
	public String suaGiangVien(ModelMap model, @PathVariable("maTaiKhoan") String maTaiKhoan) throws Exception {
		layTaiKhoan(maTaiKhoan);
		Thread.sleep(1000);
		model.addAttribute("giangvien", tK);
		model.addAttribute("dsgiangvien", dSGiangVien);
		model.addAttribute("btnTrangThai", "btnEdit");
		return "giangvien/giangvien";
	}

	@RequestMapping(value = "tsxgv", params = "btnEdit")
	public String suaGiangVien(ModelMap model, @Validated @ModelAttribute("giangvien") TaiKhoanEntity giangVien,
			BindingResult errors) throws Exception {
		resetMessage();
		giangVien.setLoai("GV");
		suaTaiKhoan(giangVien);
		Thread.sleep(1000);
		model.addAttribute("success", success);
		model.addAttribute("error", error);
		layDSGiangVien();
		Thread.sleep(1000);
		model.addAttribute("giangvien", new TaiKhoanEntity());
		model.addAttribute("dsgiangvien", dSGiangVien);
		model.addAttribute("btnTrangThai", "btnAdd");
		return "giangvien/giangvien";
	}

	@RequestMapping(value = "/{maTaiKhoan}.htm", params = "linkDelete")
	public String xoaGiangVien(ModelMap model, @PathVariable("maTaiKhoan") String maTaiKhoan) throws Exception {
		resetMessage();
		xoaTaiKhoan(maTaiKhoan);
		Thread.sleep(1000);
		model.addAttribute("success", success);
		model.addAttribute("error", error);
		layDSGiangVien();
		Thread.sleep(1000);
		model.addAttribute("giangvien", new TaiKhoanEntity());
		model.addAttribute("dsgiangvien", dSGiangVien);
		return "giangvien/giangvien";
	}

	// -------TAI KHOAN SINH  VIEN-----------------------------
	@RequestMapping("dssinhvien")
	public String qLSinhVien(ModelMap model) throws Exception {
		resetMessage();
		layDSSinhVien();
		Thread.sleep(1000);
		model.addAttribute("sinhvien", new TaiKhoanEntity());
		model.addAttribute("dssinhvien", dSSinhVien);
		model.addAttribute("btnTrangThai", "btnAdd");
		model.addAttribute("error", error);
		return "giangvien/sinhvien";
	}

	@RequestMapping(value = "tsxsv", params = "btnAdd")
	public String themSinhVien(ModelMap model, @Validated @ModelAttribute("sinhvien") TaiKhoanEntity sinhVien,
			BindingResult errors) throws Exception {
		resetMessage();
		sinhVien.setLoai("SV");
		themTaiKhoan(sinhVien);
		Thread.sleep(1000);
		model.addAttribute("success", success);
		model.addAttribute("error", error);
		layDSSinhVien();
		Thread.sleep(1000);
		model.addAttribute("sinhvien", new TaiKhoanEntity());
		model.addAttribute("dssinhvien", dSSinhVien);
		model.addAttribute("btnTrangThai", "btnAdd");
		return "giangvien/sinhvien";
	}

	@RequestMapping(value = "/{maTaiKhoan}.htm", params = "linkEdit2")
	public String suaSinhVien(ModelMap model, @PathVariable("maTaiKhoan") String maTaiKhoan) throws Exception {
		layTaiKhoan(maTaiKhoan);
		Thread.sleep(1000);
		model.addAttribute("sinhvien", tK);
		model.addAttribute("dssinhvien", dSSinhVien);
		model.addAttribute("btnTrangThai", "btnEdit");
		return "giangvien/sinhvien";
	}

	@RequestMapping(value = "tsxsv", params = "btnEdit")
	public String suaSinhVien(ModelMap model, @Validated @ModelAttribute("sinhvien") TaiKhoanEntity sinhVien,
			BindingResult errors) throws Exception {
		resetMessage();
		sinhVien.setLoai("SV");
		suaTaiKhoan(sinhVien);
		Thread.sleep(1000);
		model.addAttribute("success", success);
		model.addAttribute("error", error);
		layDSSinhVien();
		Thread.sleep(1000);
		model.addAttribute("sinhvien", new TaiKhoanEntity());
		model.addAttribute("dssinhvien", dSSinhVien);
		model.addAttribute("btnTrangThai", "btnAdd");
		return "giangvien/sinhvien";
	}

	@RequestMapping(value = "/{maTaiKhoan}.htm", params = "linkDelete2")
	public String xoaSinhVien(ModelMap model, @PathVariable("maTaiKhoan") String maTaiKhoan) throws Exception {
		resetMessage();
		xoaTaiKhoan(maTaiKhoan);
		Thread.sleep(1000);
		model.addAttribute("success", success);
		model.addAttribute("error", error);
		layDSSinhVien();
		Thread.sleep(1000);
		model.addAttribute("sinhvien", new TaiKhoanEntity());
		model.addAttribute("dssinhvien", dSSinhVien);
		return "giangvien/sinhvien";
	}

	// ------------------CAU HOI-----------------------------

	@ModelAttribute("dapAn")
	public List<String> dapan() {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		return list;
	}

	@RequestMapping("dscauhoi")
	public String qLCauHoi(ModelMap model) throws Exception {
		layDSCauHoi();
		layDSMonHoc();
		Thread.sleep(2000);
		model.addAttribute("cauhoi", new CauHoiEntity());
		model.addAttribute("dscauhoi", dSCauHoi);
		model.addAttribute("btnTrangThai", "btnAdd");
		model.addAttribute("monHoc", dSMonHoc);
		return "giangvien/cauhoi";
	}

	@RequestMapping(value = "tsxch", params = "btnAdd")
	public String themCauHoi(ModelMap model, @Validated @ModelAttribute("cauhoi") CauHoiEntity cauHoi,
			BindingResult errors) throws Exception {
		resetMessage();
		cauHoi.setMaTaiKhoan(LogController.tKHT.getMaTaiKhoan());
		themCauHoi(cauHoi);
		Thread.sleep(1000);
		model.addAttribute("success", success);
		model.addAttribute("error", error);
		layDSCauHoi();
		layDSMonHoc();
		Thread.sleep(2000);
		model.addAttribute("cauhoi", new CauHoiEntity());
		model.addAttribute("dscauhoi", dSCauHoi);
		model.addAttribute("btnTrangThai", "btnAdd");
		model.addAttribute("monHoc", dSMonHoc);
		return "giangvien/cauhoi";
	}

	@RequestMapping(value = "/{idCH}.htm", params = "linkEdit3")
	public String suaCauHoi(ModelMap model, @PathVariable("idCH") Integer idCH) throws Exception {
		layCauHoi(idCH);
		Thread.sleep(1000);
		model.addAttribute("cauhoi", cH);
		model.addAttribute("dscauhoi", dSCauHoi);
		model.addAttribute("btnTrangThai", "btnEdit");
		model.addAttribute("monHoc", dSMonHoc);
		return "giangvien/cauhoi";
	}

	@RequestMapping(value = "tsxch", params = "btnEdit")
	public String suaCauHoi(ModelMap model, @Validated @ModelAttribute("cauhoi") CauHoiEntity cauHoi,
			BindingResult errors) throws Exception {
		resetMessage();
		cauHoi.setMaTaiKhoan(LogController.tKHT.getMaTaiKhoan());
		cauHoi.setIdCH(cH.getIdCH());
		suaCauHoi(cauHoi);
		Thread.sleep(1000);
		model.addAttribute("success", success);
		model.addAttribute("error", error);
		layDSCauHoi();
		layDSMonHoc();
		Thread.sleep(2000);
		model.addAttribute("cauhoi", new CauHoiEntity());
		model.addAttribute("dscauhoi", dSCauHoi);
		model.addAttribute("btnTrangThai", "btnAdd");
		model.addAttribute("monHoc", dSMonHoc);
		return "giangvien/cauhoi";
	}

	@RequestMapping(value = "/{idCH}.htm", params = "linkDelete3")
	public String xoaCauHoi(ModelMap model, @PathVariable("idCH") Integer idCH) throws Exception {
		resetMessage();
		xoaCauHoi(idCH);
		Thread.sleep(1000);
		model.addAttribute("success", success);
		model.addAttribute("error", error);
		layDSCauHoi();
		layDSMonHoc();
		Thread.sleep(2000);
		model.addAttribute("cauhoi", new CauHoiEntity());
		model.addAttribute("dscauhoi", dSCauHoi);
		model.addAttribute("btnTrangThai", "btnAdd");
		model.addAttribute("monHoc", dSMonHoc);
		return "giangvien/cauhoi";
	}

	// ---MON HOC------------------------------
	@RequestMapping("dsmonhoc")
	public String qLMonHoc(ModelMap model) throws Exception {
		layDSMonHoc();
		Thread.sleep(1000);
		model.addAttribute("monhoc", new MonHocEntity());
		model.addAttribute("dsmonhoc", dSMonHoc);
		model.addAttribute("btnTrangThai", "btnAdd");
		return "giangvien/monhoc";
	}

	@RequestMapping(value = "tsxmh", params = "btnAdd")
	public String themMonHoc(ModelMap model, @Validated @ModelAttribute("monhoc") MonHocEntity monHoc,
			BindingResult errors) throws Exception {
		resetMessage();
		themMonHoc(monHoc);
		Thread.sleep(1000);
		model.addAttribute("success", success);
		model.addAttribute("error", error);
		layDSMonHoc();
		Thread.sleep(1000);
		model.addAttribute("monhoc", new MonHocEntity());
		model.addAttribute("btnTrangThai", "btnAdd");
		model.addAttribute("monHoc", dSMonHoc);
		return "giangvien/monhoc";
	}

	@RequestMapping(value = "/{maMonHoc}.htm", params = "linkEdit4")
	public String suaMonHoc(ModelMap model, @PathVariable("maMonHoc") String maMonHoc) throws Exception {
		layMonHoc(maMonHoc);
		Thread.sleep(1000);
		layDSMonHoc();
		Thread.sleep(1000);
		model.addAttribute("monhoc", mH);
		model.addAttribute("btnTrangThai", "btnEdit");
		model.addAttribute("monHoc", dSMonHoc);
		return "giangvien/monhoc";
	}

	@RequestMapping(value = "tsxmh", params = "btnEdit")
	public String suaMonHoc(ModelMap model, @Validated @ModelAttribute("monhoc") MonHocEntity monHoc,
			BindingResult errors) throws Exception {
		resetMessage();
		suaMonHoc(monHoc);
		Thread.sleep(1000);
		model.addAttribute("success", success);
		model.addAttribute("error", error);
		layDSMonHoc();
		Thread.sleep(1000);
		model.addAttribute("monhoc", new MonHocEntity());
		model.addAttribute("btnTrangThai", "btnAdd");
		model.addAttribute("monHoc", dSMonHoc);
		return "giangvien/monhoc";
	}

	@RequestMapping(value = "/{maMonHoc}.htm", params = "linkDelete4")
	public String xoaMonHoc(ModelMap model, @PathVariable("maMonHoc") String maMonHoc) throws Exception {
		resetMessage();
		xoaMonHoc(maMonHoc);
		Thread.sleep(1000);
		model.addAttribute("success", success);
		model.addAttribute("error", error);
		layDSMonHoc();
		Thread.sleep(1000);
		model.addAttribute("monhoc", new MonHocEntity());
		model.addAttribute("dsmonhoc", dSMonHoc);
		model.addAttribute("btnTrangThai", "btnAdd");
		return "giangvien/monhoc";
	}

	// ----CHI TIẾT THI----------------------
	@RequestMapping("chitietthi")
	public String chiTietThi(ModelMap model) throws Exception {
		layDSMonHoc();
		Thread.sleep(2000);
		model.addAttribute("monhoc", dSMonHoc);
		model.addAttribute("MHOC", new MonHocEntity());
		return "giangvien/chitietthi";
	}

	@RequestMapping("chitietthi2")
	public String chiTietThi2(ModelMap model, @ModelAttribute("MHOC") MonHocEntity mh) throws Exception {
		resetMessage();
		layDSCTT(mh.getMaMonHoc());
		Thread.sleep(2000);
		if (mh.getMaMonHoc() == null) {
			return "giangvien/chitietthi";
		} else {
			if (dSCTT.size() <= 0) {
				model.addAttribute("message", "Chưa có sinh viên nào thi môn học này!");
				layDSMonHoc();
				Thread.sleep(2000);
				model.addAttribute("monhoc", dSMonHoc);
				model.addAttribute("MHOC", new MonHocEntity());
				return "giangvien/chitietthi";
			} else {
				model.addAttribute("dsctt", dSCTT);
				model.addAttribute("error", error);
				return "giangvien/chitietthi2";
			}
		}

	}
	
	
}
