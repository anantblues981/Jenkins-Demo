package com.epam.test;

import com.epam.jsonenum.StatusCode;
import com.epam.data.CommentsDataProvider;
import com.epam.pojo.Comments;
import com.epam.service.CommentsService;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CommentsTest {
    CommentsService commentsService;
    @BeforeTest
    public void setUp(){
        commentsService = new CommentsService();
    }

    @Test
    public void verifyCommentsCount(){
        assertThat(commentsService
                .getAllComments("/comments").length,equalTo(500));
    }

    @Test(dataProviderClass = CommentsDataProvider.class,dataProvider = "commentsIdData")
    public void verifyGetCommentsByIdStatusCode(String basePath,String id){
        Assert.assertEquals(commentsService.getResourceById(basePath,id).getStatusCode(), StatusCode.OK.getCode());
    }

    @Test(dataProviderClass = CommentsDataProvider.class,dataProvider = "commentsIdBodyData")
    public void verifyGetCommentsByIdBody(String basePath,String id,Comments expectedComment){
        Assert.assertEquals(commentsService.compareComments(commentsService.getCommentsById(commentsService.getResourceById(basePath,id)),expectedComment),"Matched");
    }
    @Test(dataProviderClass = CommentsDataProvider.class,dataProvider = "putCommentsData")
    public void verifyPutCommentsByIdStatusCode(String basePath,String id,Comments expectedComment){
        Assert.assertEquals(commentsService.putResource(basePath,id,expectedComment.toString()).getStatusCode(),StatusCode.OK.getCode());
    }
    @Test(dataProviderClass = CommentsDataProvider.class,dataProvider = "putCommentsData")
    public void verifyPutCommentsByIdBody(String basePath,String id,Comments expectedComment){
        Assert.assertEquals(commentsService.compareComments(commentsService.getCommentsById(commentsService.putResource(basePath,id,expectedComment.toString())),expectedComment),"Matched");
    }
    @Test(dataProviderClass = CommentsDataProvider.class,dataProvider = "postCommentsData")
    public void verifyPostCommentsByIdStatusCode(String basePath,Comments expectedComment){
        Assert.assertEquals(commentsService.postResource(basePath,expectedComment.toString()).getStatusCode(),StatusCode.OK.getCode());
    }
    @Test(dataProviderClass = CommentsDataProvider.class,dataProvider = "postCommentsData")
    public void verifyPostCommentsByIdBody(String basePath,Comments expectedComment){
        Assert.assertEquals(commentsService.compareComments(commentsService.getCommentsById(commentsService.postResource(basePath,expectedComment.toString())),expectedComment),"Matched");
    }

    @Test(dataProviderClass = CommentsDataProvider.class,dataProvider = "commentsIdDeleteData")
    public void verifyDeleteCommentsByIdStatusCode(String basePath,String id){
        Assert.assertEquals(commentsService.deleteResource(basePath,id).getStatusCode(),StatusCode.OK.getCode());
    }
    @Test(dataProviderClass = CommentsDataProvider.class,dataProvider = "commentsIdDeleteData")
    public void verifyDeleteCommentsByIdBody(String basePath,String id){
        Assert.assertEquals(commentsService.deleteResource(basePath,id).getBody().asString(),"{}");
    }
    @AfterTest
    public void tearDown(){
        commentsService = null;
    }
}
