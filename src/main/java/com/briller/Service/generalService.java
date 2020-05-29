package com.briller.Service;

import com.briller.Model.general;
import com.briller.Repository.generalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * sample service class
 */
@Service
public class generalService {

    @Autowired
    generalRepository GeneralRepository;

    /**
     *The controller will not access the repository directly so, services does that,
     * this function saves id, name in the general table
     * @param General
     * @return
     */
    @PostMapping("/adddata")
    public general add(general General)
    {
        GeneralRepository.save(General);
        return  General;
    }

    /**
     * This function returns all the data of general table.
     * @return
     */

    @GetMapping("/getdata")
    public List<general> getdata()
    {
        List<general> s=GeneralRepository.findAll();
        return s;
    }
}
