package com.epam.service;

import com.epam.pojo.Posts;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.ArrayList;

public class PostsService {
    public PostsService(){
        RestAssured.baseURI = "https://gorest.co.in";
    }

    public Response getAllPosts(String basePath){
        return RestAssured.given()
                .get(basePath)
                .then()
                .log().ifError()
                .extract()
                .response();
    }
    public Response getPostsById(String basePath,String id){
        return RestAssured.given()
                .get(basePath+"/"+id)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Posts[] getPostsBody(Response response){
        return response.getBody().as(Posts[].class);
    }
    public  Posts getPostsBodyById(Response response){
        return  response.getBody().as(Posts.class);
    }

    public Object[][] getOddRecord(Posts[] posts){
        ArrayList<Object[]> oddRecords = new ArrayList<>();
        int len = posts.length;
        for(int i = 0 ;i <len;i++){
            if((i + 1) % 2 != 0){
                oddRecords.add(new Object[]{posts[i].id()});
            }
        }
        return oddRecords.toArray(new Object[oddRecords.size()][]);
    }
    public Object[][] getOddRecordWithExpected(Posts[] posts,String[] expected){
        ArrayList<Object[]> oddRecords = new ArrayList<>();
        int len = posts.length;
        int j = 0;
        for(int i = 0 ;i <len;i++){
            if((i + 1) % 2 != 0){
                oddRecords.add(new Object[]{posts[i].id(),expected[j]});
                j++;
            }
        }
        return oddRecords.toArray(new Object[oddRecords.size()][]);
    }

}
