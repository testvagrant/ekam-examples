package com.testvagrant.ekamTemplate.api.endpoints;

import com.testvagrant.ekamTemplate.api.models.CatFacts;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface AnimalFactsService {

  @GET("/facts")
  Call<List<CatFacts>> catFacts();
}
