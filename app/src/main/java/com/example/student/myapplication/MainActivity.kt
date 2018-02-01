package com.example.student.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log
import android.widget.Toast
import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

import retrofit2.http.GET
import retrofit2.http.Url
import se.ansman.kotshi.JsonSerializable
import java.util.concurrent.TimeUnit

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

open class MainActivity : AppCompatActivity() {
    var activity = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        findViewById(R.id.button).setOnClickListener {
            Toast.makeText(activity, "test", Toast.LENGTH_LONG)

            val interceptor = HttpLoggingInterceptor({ message ->
                Log.w("OkHttp", message)

            })
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            var okHttpClient = OkHttpClient.Builder().apply {
                addInterceptor(interceptor)
                connectTimeout(20, TimeUnit.SECONDS)
                readTimeout(20, TimeUnit.SECONDS)
                writeTimeout(20, TimeUnit.SECONDS)
            }.build()

//            var moshi = Moshi.Builder()
//                    .add(ApplicationJsonAdapterFactory.INSTANCE)
//                    .build()

            var moshi = Moshi.Builder()
                    .build()

            val retrofit = Retrofit.Builder()
                    .client(okHttpClient)
                    .addConverterFactory(
                            MoshiConverterFactory
                                    .create(moshi)
                                    .asLenient()
                    )
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                    .baseUrl("https://raw.githubusercontent.com/android10/Sample-Data/master/Android-CleanArchitecture/")
                    .build()

            var api = retrofit.create(ApiService::class.java)
            api.getUsers("users.json")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeBy(
                            onSuccess = { users ->
                                users.forEach {
                                    Log.w("OkHttp", "user" + it.toString())
                                }
                            },
                            onError = { t ->
                                Log.w("OkHttp", t.message)
                            }
                    )

        }
    }

    interface ApiService {
        @GET
        fun getUsers(@Url url: String): Single<List<User>>
    }

    @JsonSerializable
    data class User(
            @Json(
                    name = "id"
            )
            val id: Int,
            @Json(
                    name = "full_name"
            )
            val fullName: String,
            @Json(
                    name = "followers"
            )
            val followers: String
    )
}
