package com.briller.Response;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class SampleResponse {

        @JsonProperty("isOk")
        private String isOk;

        @JsonProperty("result")
        private String result = "Success";

        @JsonProperty("message")
        private String message;

        @JsonProperty("data")
        private Object object;

    @JsonProperty("return")
    private long returnCode = 1;

    @JsonCreator
    public SampleResponse(Object object, String message){
        this.message = message;
        this.object = object;
    }

    @JsonCreator
    public SampleResponse(String isOk, String message){
        this.isOk = isOk;
        this.message = message;
    }

    @JsonCreator
    public SampleResponse(String isOk, Object object, String message){
        this.isOk = isOk;
        this.message = message;
        this.object = object;
    }

   @JsonCreator
    public SampleResponse(long returnCode, String result, String message){
        this.returnCode = returnCode;
        this.result = result;
        this.message = message;
    }


    @JsonCreator
    public SampleResponse(String message){
        this.message = message;
    }

}

