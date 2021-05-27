package com.testvagrant.ekamTemplate.api.clients;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.testvagrant.ekam.api.retrofit.RetrofitBaseClient;
import com.testvagrant.ekamTemplate.api.clients.services.PostsService;
import com.testvagrant.ekamTemplate.api.models.response.Posts;
import retrofit2.Call;

import java.util.List;

public class PostsClient extends RetrofitBaseClient {
  private final PostsService service;

  @Inject
  public PostsClient(@Named("baseUrl") String baseUrl) {
    super(baseUrl);
    service = httpClient.getService(PostsService.class);
  }

  public List<Posts> getToDos() {
    Call<List<Posts>> call = service.getPosts();
    return httpClient.execute(call);
  }
}
