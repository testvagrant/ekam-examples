package com.testvagrant.ekamexamples.api.tests.grpc;

import com.endpoints.examples.bookstore.BookResponse;
import com.testvagrant.ekamexamples.api.clients.grpc.BookClient;
import com.testvagrant.ekamexamples.api.exception.AuthorNotFoundException;
import com.testvagrant.ekamexamples.api.exception.BookNotFoundException;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = "grpc")
public class BookTests extends BaseTests {
    private BookClient bookClient;

    public BookTests() {
        bookClient = new BookClient("http://localhost:50055");
    }

    @Test
    public void getBookTests() throws BookNotFoundException {
        BookResponse bookResponse = bookClient.getBookByISBN(1);
        Assert.assertEquals(bookResponse.getResponseCode(), "200");
    }

    @Test
    public void getBookViaAuthor() throws AuthorNotFoundException {
        BookResponse bookResponse = bookClient.getBookByAuthor("Bob");
        Assert.assertEquals(bookResponse.getResponseCode(), "200");
    }
}
