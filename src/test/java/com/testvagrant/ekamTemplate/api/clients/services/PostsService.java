package com.testvagrant.ekamTemplate.api.clients.services;

import com.testvagrant.ekamTemplate.api.models.response.Posts;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

public interface PostsService {

    @GET("/posts")
    Call<List<Posts>> getPosts();


    @GET("/posts")
    Call<List<Posts>> getPost(@Query ("id") String id);
}
