package com.epam.service;

import com.epam.pojo.Comments;
import com.epam.utility.PojoComparator;
import io.restassured.response.Response;


public class CommentsService extends Resource{
    public Comments[] getAllComments(String basePath){
        return this.getResource(basePath).as(Comments[].class);
    }
    public Comments getCommentsById(Response response){
        return response.as(Comments.class);
    }
    public String compareComments(Comments comment1,Comments comment2){
        PojoComparator<Comments> comparator = new PojoComparator<>(Comments.class);
        return  comparator.compare(comment1,comment2);
    }
}
