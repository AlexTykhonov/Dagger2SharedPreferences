package com.tae.dagger2sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tae.dagger2sharedpreferences.Component.DaggerMyComponent;
import com.tae.dagger2sharedpreferences.Component.MyComponent;
import com.tae.dagger2sharedpreferences.Modules.SharedPrefModule;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.tae.dagger2sharedpreferences.BbcInter.BASE_URL;

public class MainActivity extends AppCompatActivity {

    MyComponent myComponent;

    Retrofit retrofit;
    RecyclerView recyclerView;
    PostsAdapter recyclerViewAdapter;

    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    BbcInter bbcInter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myComponent = DaggerMyComponent.builder().sharedPrefModule(new SharedPrefModule(this)).build();
        myComponent.inject(this);


    recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerViewAdapter = new PostsAdapter(this);
        recyclerView.setAdapter(recyclerViewAdapter);


//    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

//    retrofit = new Retrofit.Builder()
//            .baseUrl(BASE_URL)
//                .client(client)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .build();


  //  BbcInter bbcInter = retrofit.create(BbcInter.class);

        bbcInter.getBbcData("bbc-news","1ab09308782244538982ed1870f37d82")
                .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResults, this::handleError);

}
    public void handleResults(PojoNews bbcNews)
    {
        if (bbcNews != null ) {
            recyclerViewAdapter.setData(bbcNews);

        } else {
            Toast.makeText(this, "NO RESULTS FOUND",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void handleError(Throwable t){
        System.out.println(t+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }


}
