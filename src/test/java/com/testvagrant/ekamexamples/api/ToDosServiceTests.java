package com.testvagrant.ekamexamples.api;

import com.testvagrant.ekam.testBases.testng.APITest;
import com.testvagrant.ekamexamples.api.clients.PostsClient;
import com.testvagrant.ekamexamples.api.clients.ToDosClient;
import com.testvagrant.ekamexamples.api.models.response.Posts;
import com.testvagrant.ekamexamples.api.models.response.ToDos;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.testvagrant.ekam.commons.LayoutInitiator.Client;

@Test(groups = "api")
public class ToDosServiceTests extends APITest {

  public void getToDosShouldReturnAValue() {
    List<ToDos> toDos = Client(ToDosClient.class).getToDos();
    Assert.assertTrue(toDos.size() > 1);

    PostsClient postsClient = Client(PostsClient.class);
    List<Posts> posts = postsClient.getPosts();
    Assert.assertTrue(posts.size() > 1);
  }
}
