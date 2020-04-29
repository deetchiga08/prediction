package com.nvz.Controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api("API for test Controller")
public class testController {

    @RequestMapping(value = "/sample", method= RequestMethod.GET)
    @ApiOperation("GET API for getting all company")
    public String gettest()
    {
        String s="deetchiga";
        System.out.println("sample test controlller for swagger");
	System.out.println("test");
	System.out.println("branch test");
        return s;
    }
}

