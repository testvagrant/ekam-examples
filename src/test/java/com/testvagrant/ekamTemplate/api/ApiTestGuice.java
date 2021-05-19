package com.testvagrant.ekamTemplate.api;

import com.google.inject.Inject;
import com.testvagrant.ekam.api.modules.GrpcModule;
import com.testvagrant.ekam.api.modules.PropertyModule;
import com.testvagrant.ekam.api.retrofit.RetrofitClient;
import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekam.commons.modules.InterceptorModule;
import com.testvagrant.ekamTemplate.EkamTest;
import com.testvagrant.ekamTemplate.api.endpoints.AnimalFactsClient;
import com.testvagrant.ekamTemplate.api.endpoints.AnimalFactsClientGuice;
import com.testvagrant.ekamTemplate.api.endpoints.AnimalFactsClientWithoutBaseUrl;
import com.testvagrant.ekamTemplate.api.models.CatFacts;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.util.List;

@Guice(modules = {PropertyModule.class, InterceptorModule.class})
public class ApiTestGuice extends EkamTest {

    @Inject private AnimalFactsClientGuice animalFactsClient;

    @Inject private AnimalFactsAssertions animalFactsAssertionsGuice;

    @Test(groups = "api")
    public void getAnimalFacts() {
        Response<List<CatFacts>> catFacts =
                animalFactsClient.getCatFacts();
        animalFactsAssertionsGuice.assertThatCatFactsAreAvailable(catFacts);
    }
}
