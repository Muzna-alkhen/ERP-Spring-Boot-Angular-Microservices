package com.programming.techie.controller;


import com.programming.techie.WorkflowEngineCamunda;
import com.programming.techie.dto.LeaveRequestDto;
import com.programming.techie.dto.LeavesFullDto;
import com.programming.techie.dto.LeavesResponseDto;
import com.programming.techie.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/leaves")
public class LeavesController {

    @Autowired
    LeaveService leaveService;


    @WorkflowEngineCamunda (key = "Leave Request")
    @PostMapping("/submit")
    public String submit(@RequestBody LeaveRequestDto leaveRequestDto) {



        return  leaveService.save(leaveRequestDto);


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

    @PostMapping("/setApproval")
    public void setApproval(@RequestBody String name , @RequestBody Long id)
    {

         leaveService.setApproval(name , id);

    }

    @GetMapping("/all")
    public List<LeavesResponseDto> all() {
        return leaveService.all();

    }

    @GetMapping("/get/{id}")
    public LeavesFullDto get(@PathVariable Long id) {
        return leaveService.get(id);

    }
}