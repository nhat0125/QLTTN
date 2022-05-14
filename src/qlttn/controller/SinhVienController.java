package qlttn.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping("sinhvien")
public class SinhVienController {
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static MonHocEntity mH = null;
	public static List<CauHoiEntity> DS = null;
	int demCau = -1;
	int soluong = 10;
	double diem = 0;

	long millis=System.currentTimeMillis();
	
	public void layDSCauHoi(String maMonHoc) {
		CauHoiAPI.apiCauHoiService.layDSCauHoiTheoMon(maMonHoc, "a").enqueue(new Callback<List<CauHoiEntity>>() {
			
			@Override
			public void onResponse(Call<List<CauHoiEntity>> call, Response<List<CauHoiEntity>> response) {
				DS = response.body();
				
			}
			
			@Override
			public void onFailure(Call<List<CauHoiEntity>> call, Throwable t) {
				System.out.println("Xảy ra lỗi khi lấy danh sách!");
				
			}
		});
	}
	
	public void themCTT(ChiTietThiEntity ctt) {
		Call<ChiTietThiEntity> call = ChiTietThiAPI.apiChiTietThiService.themChiTietThi(ctt);
		call.enqueue(new Callback<ChiTietThiEntity>() {

			@Override
			public void onResponse(Call<ChiTietThiEntity> call, Response<ChiTietThiEntity> response) {
				if (response.isSuccessful()) {
					System.out.println("Thêm chi tiét thi thành công!");
					return;
				}

			}

			@Override
			public void onFailure(Call<ChiTietThiEntity> call, Throwable t) {
				System.out.println("Xảy ra lỗi khi thêm chi tiết thi!");

			}
		});
	}
	
	public double getDiem() {
		int d = 0;
		for (int i = 0; i < soluong; i++) {
			if (DS.get(i).getLuaChon().equals("")) {
				DS.get(i).setLuaChon("H");
			} else if (DS.get(i).getLuaChon().equals(DS.get(i).getDapAn()))
				d++;
		}
		return d;
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
	
	
	@RequestMapping("thi")
	public String thi(ModelMap model, @ModelAttribute("mh") MonHocEntity mh,
			@ModelAttribute("cauHoi") CauHoiEntity ch) throws Exception {
		if (demCau < 0) {
			DS = new ArrayList();
//			MH = getMonHoc(mh).get(0);
//			getCauHoi(MH);
			layMonHoc(mh.getMaMonHoc());
			Thread.sleep(1500);
			layDSCauHoi(mH.getMaMonHoc());
			Thread.sleep(1500);
			if (DS.size() < 10) {
				model.addAttribute("message", "Môn học này chưa nhập đủ câu hỏi để thi!");
				System.out.println(LogController.tKHT.getTen());
				model.addAttribute("tensinhvien", LogController.tKHT.getHo() + " " + LogController.tKHT.getTen() + "!");
				model.addAttribute("monhoc", LogController.DSMonHoc);
				DS = new ArrayList<>();
				return "sinhvien/index";
			} 
			demCau = 0;
		}

		if (demCau >= 0 && demCau < soluong) {
			if (demCau > 0) {
				DS.get(demCau - 1).setLuaChon(ch.getLuaChon());
			}
			model.addAttribute("tenmonhoc", mH.getTenMonHoc());
			model.addAttribute("tt", demCau + 1);
			model.addAttribute("cauHoi", DS.get(demCau));
			demCau++;
			return "sinhvien/thi";
		} else {
			DS.get(demCau - 1).setLuaChon(ch.getLuaChon());
			diem = getDiem();
			ChiTietThiEntity ctt = new ChiTietThiEntity();
			Date ngayThi = new java.util.Date(millis);
			ctt.setNgayThi(String.valueOf(dateFormat.format(ngayThi)));
			ctt.setDiem(diem);
			ctt.setHoTen(LogController.tKHT.getHo() + " " + LogController.tKHT.getTen());
			ctt.setMaMonHoc(mH.getMaMonHoc());
			ctt.setTenMonHoc(mH.getTenMonHoc());
			ctt.setMaTaiKhoan(LogController.tKHT.getMaTaiKhoan()); 
			//---------
			System.out.println("********************************");
			System.out.println(ctt.getNgayThi() );
			System.out.println(ctt.getDiem() );
			System.out.println(ctt.getHoTen() );
			System.out.println(ctt.getMaMonHoc());
			System.out.println(ctt.getTenMonHoc() );
			System.out.println(ctt.getMaTaiKhoan() );
			System.out.println("********************************");
			//---------
			themCTT(ctt);
			Thread.sleep(1500);
			model.addAttribute("diem", diem);

			for (int i = 0; i < soluong; i++) {
				model.addAttribute("nd" + i, DS.get(i).getNoiDung());

				if (!DS.get(i).getLuaChon().equals(DS.get(i).getDapAn()) && DS.get(i).getLuaChon().equals("A")) {
					model.addAttribute("a" + i + "s", DS.get(i).getA());
				} else if (DS.get(i).getDapAn().equals("A")) {
					model.addAttribute("a" + i + "d", DS.get(i).getA());
				} else
					model.addAttribute("a" + i, DS.get(i).getA());

				if (!DS.get(i).getLuaChon().equals(DS.get(i).getDapAn()) && DS.get(i).getLuaChon().equals("B")) {
					model.addAttribute("b" + i + "s", DS.get(i).getB());
				} else if (DS.get(i).getDapAn().equals("B")) {
					model.addAttribute("b" + i + "d", DS.get(i).getB());
				} else
					model.addAttribute("b" + i, DS.get(i).getB());

				if (!DS.get(i).getLuaChon().equals(DS.get(i).getDapAn()) && DS.get(i).getLuaChon().equals("C")) {
					model.addAttribute("c" + i + "s", DS.get(i).getC());
				} else if (DS.get(i).getDapAn().equals("C")) {
					model.addAttribute("c" + i + "d", DS.get(i).getC());
				} else
					model.addAttribute("c" + i, DS.get(i).getC());

				if (!DS.get(i).getLuaChon().equals(DS.get(i).getDapAn()) && DS.get(i).getLuaChon().equals("D")) {
					model.addAttribute("d" + i + "s", DS.get(i).getD());
				} else if (DS.get(i).getDapAn().equals("D")) {
					model.addAttribute("d" + i + "d", DS.get(i).getD());
				} else
					model.addAttribute("d" + i, DS.get(i).getD());
			}
			return "sinhvien/ketqua";
		}
	}
	
	@RequestMapping("thilai")
	public String thiLai(ModelMap model){
		DS = null;
		mH =  null;
		demCau = -1;
		diem = 0;
		model.addAttribute("mh", new MonHocEntity());
		model.addAttribute("monhoc", LogController.DSMonHoc);
		model.addAttribute("tensinhvien", LogController.tKHT.getHo() + " " + LogController.tKHT.getTen());
		return "sinhvien/index";
	}

}
