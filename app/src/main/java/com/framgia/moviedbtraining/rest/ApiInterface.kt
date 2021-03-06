package com.framgia.moviedbtraining.rest

import com.framgia.moviedbtraining.model.MoviesResponse
import com.framgia.moviedbtraining.model.ServiceResponse
import com.framgia.moviedbtraining.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

  @GET("movie/now_playing")
  fun getNowPlaying(@Query("api_key") apiKey: String,
      @Query("page") page: Int): Call<MoviesResponse>

  @GET("authentication/token/new")
  fun getToken(@Query("api_key") apiKey: String): Call<ServiceResponse>

  @GET("authentication/session/new")
  fun getSessionId(@Query("api_key") apiKey: String,
      @Query("request_token") token: String): Call<ServiceResponse>

  @GET("authentication/token/validate_with_login")
  fun authWithLogin(@Query("api_key") apiKey: String, @Query("username") username: String,
      @Query("password") password: String,
      @Query("request_token") token: String): Call<ServiceResponse>

  @GET("account")
  fun getAccount(@Query("api_key") apiKey: String, @Query("session_id") sessionId: String): Call<User>

}