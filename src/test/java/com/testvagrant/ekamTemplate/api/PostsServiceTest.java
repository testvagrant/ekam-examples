package com.testvagrant.ekamTemplate.api;

import com.google.gson.JsonObject;
import com.testvagrant.ekam.testBases.testng.APITest;
import com.testvagrant.ekamTemplate.api.clients.PostsClient;
import com.testvagrant.ekamTemplate.api.models.response.Posts;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.util.List;

import static com.testvagrant.ekam.commons.LayoutInitiator.Client;
import static org.assertj.core.api.Assertions.assertThat;

@Test(groups = "api")
public class PostsServiceTest extends APITest {

    public void getPostsShouldReturnAValue() {
        PostsClient postsClient = Client(PostsClient.class);
        List<Posts> posts = postsClient.getPosts();
        Assert.assertTrue(posts.size() > 1);
    }

    public void createANewPost() {
        Posts postToCreate = Posts.builder().build().createDefaultPost();
        PostsClient postsClient = Client(PostsClient.class);
        Posts createdPost = postsClient.createPost(postToCreate);
        postToCreate.assertThatPostIsCreated(createdPost);
    }

    public void deletePost() {
        Posts posts = createAPost();
        Response<JsonObject> createdPost = Client(PostsClient.class).deletePost(posts.getId());
        assertThat(createdPost.code()).isEqualTo(200);
        assertThat(createdPost.body().toString()).isEqualTo("{}");
    }

    private Posts createAPost() {
        Posts postToCreate = Posts.builder().build().createDefaultPost();
        PostsClient postsClient = Client(PostsClient.class);
        Posts createdPost = postsClient.createPost(postToCreate);
        return createdPost;
    }
}
