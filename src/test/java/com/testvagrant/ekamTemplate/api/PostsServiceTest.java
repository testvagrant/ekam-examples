package com.testvagrant.ekamTemplate.api;

import com.google.inject.Inject;
import com.testvagrant.ekam.api.modules.PropertyModule;
import com.testvagrant.ekam.commons.modules.InterceptorModule;
import com.testvagrant.ekamTemplate.api.clients.PostsClient;
import com.testvagrant.ekamTemplate.api.models.response.Posts;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import java.util.List;

@Test(groups = "api")
@Guice(modules = {PropertyModule.class, InterceptorModule.class})
public class PostsServiceTest {

  @Inject private PostsClient postsClient;

  public void getPostsShouldReturnAValue() {
    List<Posts> posts = postsClient.getPosts();
    Assert.assertTrue(posts.size() > 1);
  }
}
