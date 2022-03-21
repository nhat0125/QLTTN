package qlttn.api;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import qlttn.entity.ChiTietThiEntity;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ChiTietThiAPI {
	BaseURL baseUrl = new BaseURL();
	String url = baseUrl.getBaseURL();
	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	ChiTietThiAPI apiChiTietThiService = new Retrofit.Builder().baseUrl(url)
			.addConverterFactory(GsonConverterFactory.create(gson)).build().create(ChiTietThiAPI.class);
	
	@GET("chitietthi")
	Call<List<ChiTietThiEntity>> layDSChiTietThi();
	
	@GET("chitietthi/{maMonHoc}")
	Call<List<ChiTietThiEntity>> layDSChiTietThiTheoMon(@Path("maMonHoc") String maMonHoc);
	
	@POST("chitietthi")
	Call<ChiTietThiEntity> themChiTietThi(@Body ChiTietThiEntity chiTietThiEntity);
}
