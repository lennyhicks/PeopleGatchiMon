package com.PeopleGatchi.Network;

import com.PeopleGatchi.Models.TestPost;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by lennyhicks on 10/31/16.
 */
public interface ApiService {
    @GET("/posts/{id}")
    Call<TestPost> getPost(@Path("id") Integer id);

    @GET("/posts")
    Call<TestPost[]> getAllPost();

    @POST("/posts")
    Call<TestPost> postPost(@Body TestPost post);



    //Store


    //User info (Statuses, inventory)

    //Bank


}