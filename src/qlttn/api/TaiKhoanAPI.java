package qlttn.api;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

import qlttn.entity.TaiKhoanEntity;

public interface TaiKhoanAPI {
	BaseURL baseUrl = new BaseURL();
	String url = baseUrl.getBaseURL();
	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	TaiKhoanAPI apiTaiKhoanService = new Retrofit.Builder().baseUrl(url)
			.addConverterFactory(GsonConverterFactory.create(gson)).build().create(TaiKhoanAPI.class);
	
	@GET("taikhoan")
	Call<List<TaiKhoanEntity>> layDSTheoLoai(@Query("loai") String loai, @Query("ten") String ten);
	
	@GET("taikhoan/danhsach")
	Call<List<TaiKhoanEntity>> layDSTaiKhoan();
	
	@GET("taikhoan/{maTaiKhoan}")
	Call<TaiKhoanEntity> layTaiKhoan(@Path("maTaiKhoan") String maTaiKhoan);
	
	@POST("taikhoan")
	Call<TaiKhoanEntity> themTaiKhoan(@Body TaiKhoanEntity taiKhoanEntity);
	
	@PUT("taikhoan")
	Call<TaiKhoanEntity> suaTaiKhoan(@Body TaiKhoanEntity taiKhoanEntity);
	
	@DELETE("taikhoan/{maTaiKhoan}")
	Call<Void> xoaTaiKhoan(@Path("maTaiKhoan") String maTaiKhoan);
}
