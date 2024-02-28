    package com.epam.pojo;

    public record Comments(long postId,long id,String name,String email,String body){
        @Override
        public String toString() {
            return "{" +
                    "\"postId\": " + postId + ", " +
                    "\"id\": " + id + ", " +
                    "\"name\": \"" + name + "\", " +
                    "\"email\": \"" + email + "\", " +
                    "\"body\": \"" + body+ "\"" +
                    "}";
        }


    }
