package com.tae.dagger2sharedpreferences;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BbcInter
{
    String BASE_URL = "https://newsapi.org/v2/";

    @GET("top-headlines")
    Observable<PojoNews> getBbcData(@Query("sources")String site, @Query("apiKey") String name);
}