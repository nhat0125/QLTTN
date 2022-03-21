package qlttn.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import qlttn.entity.CauHoiEntity;
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

public interface CauHoiAPI {
	BaseURL baseUrl = new BaseURL();
	String url = baseUrl.getBaseURL();
	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	CauHoiAPI apiCauHoiService = new Retrofit.Builder().baseUrl(url)
			.addConverterFactory(GsonConverterFactory.create(gson)).build().create(CauHoiAPI.class);

	@GET("cauhoi")
	Call<List<CauHoiEntity>> layDSCauHoi();

	@GET("cauhoi/danhsach/{maMonHoc}")
	Call<List<CauHoiEntity>> layDSCauHoiTheoMon(@Path("maMonHoc") String maMonHoc, @Query("loai") String loai);

	@GET("cauhoi/{idCH}")
	Call<CauHoiEntity> layCauHoi(@Path("idCH") Integer idCH);

	@POST("cauhoi")
	Call<CauHoiEntity> themCauHoi(@Body CauHoiEntity cauHoiEntity);

	@PUT("cauhoi")
	Call<CauHoiEntity> suaCauHoi(@Body CauHoiEntity cauHoiEntity);

	@DELETE("cauhoi/{idCH}")
	Call<Void> xoaCauHoi(@Path("idCH") Integer idCH);
}
