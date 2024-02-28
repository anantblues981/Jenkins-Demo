package com.epam.service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public abstract class Resource {
    public Resource(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
    }
    public Response getResource(String basePath){
        return given().get(basePath)
                .then().log()
                .all()
                .extract().response();
    }
    public Response getResourceById(String basePath,String id){
        return given().get(basePath+ id)
                .then()
                .log().all()
                .extract().response();
    }

    public Response postResource(String basePath,String body){
        return given().contentType(ContentType.JSON)
                .body(body)
                .post(basePath)
                .then()
                .log().all()
                .extract().response();
    }
    public Response putResource(String basePath,String id,String body){
        return given().contentType(ContentType.JSON)
                .body(body)
                .put(basePath+ id)
                .then()
                .log().all()
                .extract().response();
    }
    public Response deleteResource(String basePath,String id){
        return given().delete(basePath + id)
                .then().log().all()
                .extract().response();
    }
}
