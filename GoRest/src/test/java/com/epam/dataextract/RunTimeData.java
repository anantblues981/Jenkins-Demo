package com.epam.dataextract;

import com.epam.service.PostsService;

public class RunTimeData {
    PostsService postsService;
    public RunTimeData(){
        postsService = new PostsService();
    }

    public Object[][] extractOddRecord(){
        return postsService
                .getOddRecord(postsService
                        .getPostsBody
                                (postsService.getAllPosts("/public/v2/posts")));
    }
    public Object[][] extractOddRecordWithExpected(){
        String[] expectedBody = {"321213",
                "223321",
                "321213",
                "321213",
                "321213"
        };
        return postsService
                .getOddRecordWithExpected(
                        postsService
                                .getPostsBody(postsService.getAllPosts
                                                ("/public/v2/posts")),expectedBody);
    }
}
