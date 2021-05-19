package com.testvagrant.ekamTemplate.api.endpoints;

import com.google.inject.Inject;
import com.testvagrant.ekam.api.retrofit.RetrofitBaseClient;
import com.testvagrant.ekam.commons.annotations.APIStep;
import com.testvagrant.ekamTemplate.api.models.CatFacts;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Named;
import java.util.List;

public class AnimalFactsClientGuice extends RetrofitBaseClient {

  private final AnimalFactsService animalFactsService;

  @Inject
  public AnimalFactsClientGuice(@Named("catFactsHost") String baseUrl) {
    super(baseUrl);
    animalFactsService = httpClient.getService(AnimalFactsService.class);
  }

  @APIStep(description = "Get cat Facts")
  public Response<List<CatFacts>> getCatFacts() {
    Call<List<CatFacts>> responseCall = animalFactsService.catFacts();
    return httpClient.executeAsResponse(responseCall);
  }
}
