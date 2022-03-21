package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import qlttn.api.CauHoiAPI;
import qlttn.api.TaiKhoanAPI;
import qlttn.entity.CauHoiEntity;
import qlttn.entity.TaiKhoanEntity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Test {
	private static String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);

			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}

	public static List<TaiKhoanEntity> listCauHoi;

	// public static <T> ArrayList<T> listToArrayList(List<T> list) {
	// ArrayList<T> a = new ArrayList<T>();
	// a.addAll(list);
	// return a;
	// }

	/*
	 * public static void getAllList() {
	 * TaiKhoanAPI.apiTaiKhoanService.layDSTaiKhoan().enqueue(new
	 * Callback<List<TaiKhoanEntity>>() {
	 * 
	 * @Override public void onResponse(Call<List<TaiKhoanEntity>> call,
	 * Response<List<TaiKhoanEntity>> response) { listCauHoi = response.body();
	 * for (TaiKhoanEntity i : listCauHoi) {
	 * System.out.println(i.getMaTaiKhoan()); }
	 * 
	 * }
	 * 
	 * @Override public void onFailure(Call<List<TaiKhoanEntity>> call,
	 * Throwable t) { // TODO Auto-generated method stub
	 * 
	 * } });
	 * 
	 * }
	 */

	public static void showDS() throws Exception {
		Gson gson3 = new Gson();
		String json3 = readUrl("https://qlttn.herokuapp.com/api/cauhoi");
		CauHoiEntity[] mhlist = gson3.fromJson(json3, CauHoiEntity[].class);
		for (CauHoiEntity mh : mhlist) {
			System.out.println(mh.getNoiDung());
		}
	}

	public static void main(String[] args) throws Exception {
		showDS();
		// getAllList();
	}
}
