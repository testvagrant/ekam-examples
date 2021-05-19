package com.testvagrant.ekamTemplate.api.endpoints;

import com.testvagrant.ekam.api.retrofit.RetrofitBaseClient;
import com.testvagrant.ekam.commons.annotations.APIStep;
import com.testvagrant.ekamTemplate.api.models.CatFacts;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;

public class AnimalFactsClient extends RetrofitBaseClient {

  private final AnimalFactsService animalFactsService;

  public AnimalFactsClient(String baseUrl) {
    super(baseUrl);
    animalFactsService = httpClient.getService(AnimalFactsService.class);
  }

  @APIStep(description = "Get cat Facts")
  public Response<List<CatFacts>> getCatFacts() {
    Call<List<CatFacts>> responseCall = animalFactsService.catFacts();
    return httpClient.executeAsResponse(responseCall);
  }
}
