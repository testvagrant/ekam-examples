package com.testvagrant.ekamexamples.api.clients.services;

import com.testvagrant.ekamexamples.api.models.response.ToDos;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ToDosService {

  @GET("/todos")
  Call<List<ToDos>> getToDos();
}
