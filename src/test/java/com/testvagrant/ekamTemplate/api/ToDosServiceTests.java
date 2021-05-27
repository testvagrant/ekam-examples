package com.testvagrant.ekamTemplate.api;

import com.google.inject.Inject;
import com.testvagrant.ekam.api.modules.PropertyModule;
import com.testvagrant.ekam.commons.modules.InterceptorModule;
import com.testvagrant.ekamTemplate.EkamTest;
import com.testvagrant.ekamTemplate.api.clients.ToDosClient;
import com.testvagrant.ekamTemplate.api.models.response.ToDos;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import java.util.List;

@Test(groups = "api")
@Guice(modules = {PropertyModule.class, InterceptorModule.class})
public class ToDosServiceTests extends EkamTest {

  @Inject private ToDosClient toDosClient;

  public void getToDosShouldReturnAValue() {
    List<ToDos> toDos = toDosClient.getToDos();
    Assert.assertTrue(toDos.size() > 1);
  }
}
