package com.startup.data.remote.helpers;

import com.startup.data.remote.services.BeerService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    private static final String BASE_URl = "https://api.punkapi.com/v2/";

    //instance okHttp
    private static OkHttpClient getOkHttpClientInstance(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

        //Показ тела запроса/ответа
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    //instance retrofit
    public static Retrofit getRetrofitClient(){
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URl)
                .client(getOkHttpClientInstance())
                .build();
    }

    public static BeerService getBeerService(){
        return getRetrofitClient().create(BeerService.class);
    }
}
