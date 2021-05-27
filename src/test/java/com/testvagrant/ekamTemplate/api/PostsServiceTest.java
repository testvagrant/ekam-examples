package com.testvagrant.ekamTemplate.api;

import com.google.inject.Inject;
import com.testvagrant.ekam.api.modules.PropertyModule;
import com.testvagrant.ekam.commons.LayoutInitiator;
import com.testvagrant.ekam.commons.modules.InterceptorModule;
import com.testvagrant.ekamTemplate.api.clients.PostsClient;
import com.testvagrant.ekamTemplate.api.models.response.Posts;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.util.List;

import static com.testvagrant.ekam.commons.LayoutInitiator.*;

@Test(groups = "api")
@Guice(modules = {PropertyModule.class, InterceptorModule.class})
public class PostsServiceTest {

  public void getPostsShouldReturnAValue() {
    PostsClient postsClient = Client(PostsClient.class);
    List<Posts> posts = postsClient.getPosts(); //REST API
    Assert.assertTrue(posts.size() > 1);

    Response<List<Posts>> postResponse = postsClient.getPost("1");
    Assert.assertEquals(postResponse.code(), 200);
    Assert.assertEquals(postResponse.body().size(), 1);
    Posts body = postResponse.body().get(0);
    System.out.println(body);
  }
}
