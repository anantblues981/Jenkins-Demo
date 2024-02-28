package com.epam.datagenrator;

import com.epam.pojo.Comments;
import com.epam.service.CommentsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CommentsDataGenerator {

    CommentsService commentsService;

    public CommentsDataGenerator() {
        commentsService = new CommentsService();
    }

    public Object[][] generateCommentsId() {
        ArrayList<Object[]> commentsId = new ArrayList<>();
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/CommentsIdTestData.csv"));
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                commentsId.add(new Object[]{"/comments/", nextRecord[0]});
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return commentsId.toArray(new Object[commentsId.size()][]);
    }

    public Object[][] generateCommentsIdBody() {
        ArrayList<Object[]> commentsId = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Comments[] comments = objectMapper.readValue(new File("src/test/resources/CommentsExpected.json"), Comments[].class);
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/CommentsIdTestData.csv"));
            String[] nextRecord;
            int i = 0;
            while ((nextRecord = csvReader.readNext()) != null) {
                commentsId.add(new Object[]{"/comments/", nextRecord[0], comments[i++]});
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return commentsId.toArray(new Object[commentsId.size()][]);
    }

    public Object[][] generateCommentsDeleteData(){
        ArrayList<Object[]> commentsId = new ArrayList<>();
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/CommentsIdTestData.csv"));
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                commentsId.add(new Object[]{"/comments/", nextRecord[0]});
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return commentsId.toArray(new Object[commentsId.size()][]);
    }
}
