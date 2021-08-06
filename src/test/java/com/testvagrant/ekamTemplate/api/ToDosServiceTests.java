package com.testvagrant.ekamTemplate.api;

import com.testvagrant.ekam.testBases.testng.APITest;
import com.testvagrant.ekamTemplate.api.clients.ToDosClient;
import com.testvagrant.ekamTemplate.api.models.response.ToDos;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.testvagrant.ekam.commons.LayoutInitiator.Client;

@Test(groups = "api")
public class ToDosServiceTests extends APITest {

  public void getToDosShouldReturnAValue() {
    List<ToDos> toDos = Client(ToDosClient.class).getToDos();
    Assert.assertTrue(toDos.size() > 1);
  }
}
