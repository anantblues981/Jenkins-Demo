package com.epam.data;

import com.epam.datagenrator.CommentsDataGenerator;
import com.epam.pojo.Comments;
import org.testng.annotations.DataProvider;

public class CommentsDataProvider {

    @DataProvider(name = "commentsIdData")
    public Object[][] commentsIdData(){
        return new CommentsDataGenerator().generateCommentsId();
    }
    @DataProvider(name = "commentsIdBodyData")
    public Object[][] commentsIdBodyData(){
        return new CommentsDataGenerator().generateCommentsIdBody();
    }

    @DataProvider(name = "putCommentsData")
    public Object[][] putCommentsData(){
        return new Object[][]{
                {"/comments/","1", new Comments(1,1,"Anant",".com","Hello")},
                {"/comments/","2", new Comments(1,2,"Anant Gupta",".com","Hello World")},
        };
    }
    @DataProvider(name = "postCommentsData")
    public Object[][] postCommentsData(){
        return new Object[][]{
                {"/comments/", new Comments(1,501,"Anant",".com","Hello")},
                {"/comments/", new Comments(1,5011,"Anant Gupta",".com","Hello World")},
        };
    }

    @DataProvider(name = "commentsIdDeleteData")
    public Object[][] commentsIdDeleteData(){
        return new CommentsDataGenerator().generateCommentsDeleteData();
    }

}
