package com.testvagrant.ekamexamples.api.clients;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.testvagrant.ekam.reports.annotations.APIStep;
import com.testvagrant.ekamexamples.api.clients.services.ToDosService;
import com.testvagrant.ekamexamples.api.models.response.ToDos;
import retrofit2.Call;

import java.util.List;

public class ToDosClient extends LogClient {

    private final ToDosService service;

    @Inject
    public ToDosClient(@Named("baseUrl") String baseUrl) {
        super(baseUrl);
        service = httpClient.getService(ToDosService.class);
    }

    @APIStep(description = "Get TODOS")
    public List<ToDos> getToDos() {
        Call<List<ToDos>> call = service.getToDos();
        return httpClient.execute(call);
    }
}
