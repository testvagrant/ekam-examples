package com.testvagrant.ekamTemplate.api;

import com.testvagrant.ekam.testBases.testng.APITest;
import com.testvagrant.ekamTemplate.api.clients.PostsClient;
import com.testvagrant.ekamTemplate.api.models.response.Posts;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.testvagrant.ekam.commons.LayoutInitiator.Client;

@Test(groups = "api")
public class PostsServiceTest extends APITest {

  public void getPostsShouldReturnAValue() {
    PostsClient postsClient = Client(PostsClient.class);
    List<Posts> posts = postsClient.getPosts();
    Assert.assertTrue(posts.size() > 1);
  }
}
