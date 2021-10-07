package com.programming.techie.controller;


import com.programming.techie.dto.Financial_approvalResponseDto;
import com.programming.techie.dto.ItemDto;
import com.programming.techie.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {


    @Autowired
    ItemService itemService;

    @GetMapping("/all")
    public List<ItemDto> all() {
        return itemService.all();

    }


}
