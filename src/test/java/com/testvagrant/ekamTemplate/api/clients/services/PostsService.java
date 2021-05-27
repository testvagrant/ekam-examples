package com.testvagrant.ekamTemplate.api.clients.services;

import com.testvagrant.ekamTemplate.api.models.response.Posts;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface PostsService {

    @GET("/posts")
    Call<List<Posts>> getPosts();
}
