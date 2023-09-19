package com.example.cruditems.service;

import com.example.cruditems.entity.Item;
import com.example.cruditems.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public void save (Item i) {
        itemRepository.save(i);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById (int id) {
        return itemRepository.findById(id).get();
    }

    public void deleteById (int id) {
        itemRepository.deleteById(id);
    }

}
