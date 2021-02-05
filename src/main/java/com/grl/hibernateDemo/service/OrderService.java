package com.grl.hibernateDemo.service;

import com.grl.hibernateDemo.dao.PickOrderRepository;
import com.grl.hibernateDemo.model.PickOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private PickOrderRepository pickOrderRepository;

    public List<PickOrder> list(){
        return pickOrderRepository.findAll();
    }
}
