package com.testvagrant.ekamTemplate.data.clients;

import com.google.inject.Inject;
import com.testvagrant.ekamexamples.workflow.models.UseCase;

public class UseCaseGenerator {
  @Inject private CredentialsDataClient credentialsDataClient;
  @Inject private ProductsDataClient productsDataClient;
  @Inject private AddressDataClient addressDataClient;

  public UseCase happyPathCase() {
    return UseCase.builder()
        .build()
        .addToUseCase(credentialsDataClient.getStandardUser())
        .addToUseCase(productsDataClient.backPack())
        .addToUseCase(addressDataClient.getDeliveryAddress());
  }

  public UseCase emptyLoginCredentialsCase() {
    return UseCase.builder().build().addToUseCase(credentialsDataClient.getEmptyUser());
  }

  public UseCase invalidLoginCredentialsCase() {
    return UseCase.builder().build().addToUseCase(credentialsDataClient.getInvalidPasswordUser());
  }
}
