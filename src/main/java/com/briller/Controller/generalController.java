package com.briller.Controller;

import com.briller.Model.general;
import com.briller.Service.generalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * a example controller with the post and get api's.
 */
@RestController
@RequestMapping("/test")
@Description("Testing with a sample api ")
public class generalController {

    @Autowired
    generalService GeneralService;

    /**
     * This api saves the data such as id and name using post
     * @param General
     * @return
     */
    @PostMapping("/adddata")
    public general add(@RequestBody general General)
    {
        return GeneralService.add(General);
    }

    /**
     * This api returns the data in the general table as a list
     * @return
     */
    @GetMapping("/getdata")
    public List<general> getdata()
    {
        return GeneralService.getdata();
    }

    @GetMapping("/test")
    public String retdata(){
        return "sss";
    }
}
