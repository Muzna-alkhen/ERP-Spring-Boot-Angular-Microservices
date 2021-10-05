package com.programming.techie.service;


import com.programming.techie.dto.Financial_approvalResponseDto;
import com.programming.techie.dto.ItemDto;
import com.programming.techie.model.Financial_approval;
import com.programming.techie.model.Item;
import com.programming.techie.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {


    @Autowired
    ItemRepository itemRepository;


    public List<ItemDto> all() {
        List<Item> itemList = itemRepository.findAll();
        List<ItemDto> list = new ArrayList();
        for (Item item :
                itemList) {
            ItemDto dto = new ItemDto();
            dto.setId(item.getId());
            dto.setName(item.getName());
            dto.setPrice(item.getPrice());

            list.add(dto);


        }
        return list;
    }
}