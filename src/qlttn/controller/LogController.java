package qlttn.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import qlttn.api.MonHocAPI;
import qlttn.api.TaiKhoanAPI;
import qlttn.entity.CauHoiEntity;
import qlttn.entity.MonHocEntity;
import qlttn.entity.TaiKhoanEntity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Controller
@RequestMapping("log")
public class LogController {
	public static List<TaiKhoanEntity> DSTaiKhoan = null;
	public static TaiKhoanEntity tKHT = null;
	public static List<MonHocEntity> DSMonHoc = null;

	/*
	 * private static String readUrl(String urlString) throws Exception {
	 * BufferedReader reader = null; try { URL url = new URL(urlString); reader
	 * = new BufferedReader(new InputStreamReader(url.openStream()));
	 * StringBuffer buffer = new StringBuffer(); int read; char[] chars = new
	 * char[1024]; while ((read = reader.read(chars)) != -1)
	 * buffer.append(chars, 0, read);
	 * 
	 * return buffer.toString(); } finally { if (reader != null) reader.close();
	 * } }
	 */
	
	public void layDSMonHoc() {
		MonHocAPI.apiMonHocService.layDSMonHoc().enqueue(new Callback<List<MonHocEntity>>() {

			@Override
			public void onResponse(Call<List<MonHocEntity>> call, Response<List<MonHocEntity>> response) {
				DSMonHoc = response.body();
			}

			@Override
			public void onFailure(Call<List<MonHocEntity>> call, Throwable t) {
				System.out.println("Xảy ra lỗi khi lấy danh sách!");

			}
		});
		return;
	}

	@RequestMapping("welcome")
	public String begin(ModelMap model) {
		model.addAttribute("taikhoan", new TaiKhoanEntity());
		TaiKhoanAPI.apiTaiKhoanService.layDSTaiKhoan().enqueue(new Callback<List<TaiKhoanEntity>>() {

			@Override
			public void onResponse(Call<List<TaiKhoanEntity>> call, Response<List<TaiKhoanEntity>> response) {
				DSTaiKhoan = response.body();
			}

			@Override
			public void onFailure(Call<List<TaiKhoanEntity>> call, Throwable t) {
				System.out.println("Xảy ra lỗi");

			}
		});
		return "index";
	}

	@RequestMapping("login")
	public String login(ModelMap model, @ModelAttribute("taikhoan") TaiKhoanEntity tKKT) throws Exception {
		/*
		 * Gson gson3 = new Gson(); String json3 =
		 * readUrl("https://qlttn.herokuapp.com/api/taikhoan/danhsach");
		 * TaiKhoanEntity[] list = gson3.fromJson(json3,
		 * TaiKhoanEntity[].class);
		 */

		if (DSTaiKhoan != null) {
			for (TaiKhoanEntity tK : DSTaiKhoan) {
				if (tKKT.getMaTaiKhoan().equals(tK.getMaTaiKhoan()) && tKKT.getMatKhau().equals(tK.getMatKhau())) {
					if (tK.getLoai().equals("GV")) {
						model.addAttribute("name", tK.getHo() + " " + tK.getTen());
						tKHT = tK;
						return "giangvien/index";
					} else {
						model.addAttribute("mh", new MonHocEntity());
						layDSMonHoc(); 
						Thread.sleep(1500);
						model.addAttribute("monhoc", DSMonHoc);
						tKHT = tK;
						model.addAttribute("tensinhvien", tKHT.getHo() + " " + tKHT.getTen());
						return "sinhvien/index";
					}
				}
			}
		}

		model.addAttribute("message", "Đăng nhập thất bại, kiểm tra lại tên đăng nhập và mật khẩu!");
		model.addAttribute("taikhoan", new TaiKhoanEntity());
		return "index";
	}

	@RequestMapping("logout")
	public String dangXuat(ModelMap model){
		GiangVienController.dSGiangVien = null;
		GiangVienController.dSSinhVien = null;
		GiangVienController.dSCauHoi = null;
		GiangVienController.dSMonHoc = null;
		GiangVienController.dSCTT = null;
		GiangVienController.tK = null;
		GiangVienController.cH = null; 
		GiangVienController.mH = null; 
		DSTaiKhoan = null;
		tKHT = null;
		model.addAttribute("taikhoan", new TaiKhoanEntity());
		TaiKhoanAPI.apiTaiKhoanService.layDSTaiKhoan().enqueue(new Callback<List<TaiKhoanEntity>>() {

			@Override
			public void onResponse(Call<List<TaiKhoanEntity>> call, Response<List<TaiKhoanEntity>> response) {
				DSTaiKhoan = response.body();
			}

			@Override
			public void onFailure(Call<List<TaiKhoanEntity>> call, Throwable t) {
				System.out.println("Xảy ra lỗi");

			}
		});
		return "index";
		
	}
}
