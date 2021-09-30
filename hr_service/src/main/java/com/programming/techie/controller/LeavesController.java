package com.programming.techie.controller;


import com.programming.techie.dto.LeaveDto;
import com.programming.techie.model.Leaves;
import com.programming.techie.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/leaves")
public class LeavesController {

    @Autowired
    LeaveService leaveService;


    @PostMapping("/submit")
    public String submit(@RequestBody LeaveDto leaveDto) {



        leaveService.save(leaveDto);
         return "Leave has been submitted !";

    }


    @GetMapping("/accept/{id}")
    public String accept (@PathVariable Long id)
    {
        leaveService.accept( id);
        return "Leave Has been accepted ! " ;

    }

    @GetMapping("/reject/{id}")
    public String reject (@PathVariable Long id)
    {
        leaveService.reject( id);
        return "Leave Has been rejected ! " ;

    }

    @GetMapping("/checkMax/{id}")
    public boolean checkMax(@PathVariable Long id)
    {

        return leaveService.checkMax(id);

    }

}