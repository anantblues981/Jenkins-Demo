package com.epam.data;

import com.epam.dataextract.RunTimeData;
import org.testng.annotations.DataProvider;

public class GoRestDataProvider {
    @DataProvider(name = "getPostsData")
    public Object[][] getPostsData(){
        return new Object[][] {
                {"/public/v2/posts"}
        };
    }
    @DataProvider(name = "getPostsByIdData")
    public Object[][] getPostsByIdData(){
        return new Object[][] {
                {"/public/v2/posts","102605"}
        };
    }
    @DataProvider(name = "oddRecordsData")
    public Object[][] oddRecordsData(){
        return new RunTimeData().extractOddRecord();
        }
    @DataProvider(name = "oddRecordsExpectedBodyData")
    public Object[][] oddRecordsExpectedBodyData(){
        return new RunTimeData().extractOddRecordWithExpected();
       }
}
