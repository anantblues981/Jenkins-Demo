package com.epam.test;

import com.epam.data.GoRestDataProvider;
import com.epam.service.PostsService;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class PostsTest {
    PostsService postsService;
    @BeforeTest(alwaysRun = true)
    public void setUp(){
        postsService = new PostsService();
    }

    @Test(dataProviderClass = GoRestDataProvider.class,dataProvider = "getPostsData")
    public void verifyGetPostsStatusCode(String basePath){
        Assert.assertEquals(postsService
                .getAllPosts(basePath)
                .getStatusCode(),200);
    }

    @Test(dataProviderClass = GoRestDataProvider.class,dataProvider = "getPostsByIdData")
    public void verifyGetPostsByIdStatusCode(String basePath,String id){
        Assert.assertEquals(postsService
                .getPostsById(basePath,id)
                .getStatusCode(),200);
    }

    @Test(dataProviderClass = GoRestDataProvider.class,dataProvider = "getPostsData")
    public void verifyRecordsCount(String basePath){
        Assert.assertEquals(
                postsService.getPostsBody(
                postsService
                .getAllPosts(basePath))
                .length,9);
    }
    @Test(dataProviderClass = GoRestDataProvider.class,dataProvider = "getPostsData")
    public void verifyCountGreaterThan3(String basePath){
        assertThat(
                postsService.getPostsBody(
                        postsService
                                .getAllPosts(basePath))
                        .length,greaterThan(4));
    }


    @Test(dataProviderClass = GoRestDataProvider.class,dataProvider = "oddRecordsData",groups = {"oddRecords"})
    public void verifyOddRecordsStatusCode(long id){
        Assert.assertEquals(postsService
                .getPostsById("/public/v2/posts",String.valueOf(id))
                .getStatusCode(),200);
    }
    @Test(dataProviderClass = GoRestDataProvider.class,dataProvider = "oddRecordsData",groups = {"oddRecords"})
    public void verifyOddRecordsStatusLine(long id){
        Assert.assertEquals(postsService
                .getPostsById("/public/v2/posts",String.valueOf(id))
                .getStatusLine(),"HTTP/1.1 200 OK");
    }
    @Test(dataProviderClass = GoRestDataProvider.class,dataProvider = "oddRecordsExpectedBodyData",groups = {"oddRecords"})
    public void verifyOddRecordsBody(long id,String ExpectedBody){
        Assert.assertEquals(
                postsService
                        .getPostsById("/public/v2/posts",String.valueOf(id)).body().asString()
        ,ExpectedBody);
    }
    @AfterTest
    public void tearDown(){
        postsService = null;
    }
}
