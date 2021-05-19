package com.testvagrant.ekamTemplate.api.endpoints;

import com.testvagrant.ekam.api.retrofit.RetrofitBaseClient;
import com.testvagrant.ekam.api.retrofit.RetrofitClient;
import com.testvagrant.ekamTemplate.api.models.CatFacts;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;

public class AnimalFactsClientWithoutBaseUrl extends RetrofitBaseClient {

  private final AnimalFactsService animalFactsService;

  public AnimalFactsClientWithoutBaseUrl(RetrofitClient retrofitClient) {
    super(retrofitClient);
    animalFactsService = httpClient.getService(AnimalFactsService.class);
  }

  public Response<List<CatFacts>> getCatFacts() {
    Call<List<CatFacts>> responseCall = animalFactsService.catFacts();
    return httpClient.executeAsResponse(responseCall);
  }
}
