package qlttn.api;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import qlttn.entity.ChiTietThiEntity;
import qlttn.entity.MonHocEntity;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MonHocAPI {
	BaseURL baseUrl = new BaseURL();
	String url = baseUrl.getBaseURL();
	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	MonHocAPI apiMonHocService = new Retrofit.Builder().baseUrl(url)
			.addConverterFactory(GsonConverterFactory.create(gson)).build().create(MonHocAPI.class);
	
	@GET("monhoc")
	Call<List<MonHocEntity>> layDSMonHoc();
	
	@GET("monhoc/{maMonHoc}")
	Call<MonHocEntity> layMonHoc(@Path("maMonHoc") String maMonHoc);
	
	@POST("monhoc")
	Call<MonHocEntity> themMonHoc(@Body MonHocEntity monHocEntity);
	
	@PUT("monhoc")
	Call<MonHocEntity> suaMonHoc(@Body MonHocEntity monHocEntity);
	
	@DELETE("monhoc/{maMonHoc}")
	Call<Void> xoaMonHoc(@Path("maMonHoc") String maMonHoc);
}
