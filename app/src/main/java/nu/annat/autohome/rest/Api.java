package nu.annat.autohome.rest;

import nu.annat.autohome.api.All;
import nu.annat.autohome.api.Registration;
import nu.annat.autohome.api.UnitCommandList;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {

    @GET("all")
    public Call<All> getAll();

    @POST("outlet/{id}/{action}")
    public Call<ResponseBody> setOutlet(@Path("id") String id, @Path("action") String action);

    @POST("dimmer/{id}/{value}")
    public Call<ResponseBody> setDimmer(@Path("id") String id, @Path("value") int value);

    @POST("scene/{id}/{action}")
    public Call<ResponseBody> executeScene(String id);

    @POST("switchOutlet/{id}/{action}")
    public Call<ResponseBody> executeSwitchOutlet(@Path("id") String id, @Path("action") String action);

    @POST("do")
    public Call<ResponseBody> execute(@Body UnitCommandList commandList);

    @POST("/register")
    public Call<ResponseBody> register(@Body Registration registration);
}
