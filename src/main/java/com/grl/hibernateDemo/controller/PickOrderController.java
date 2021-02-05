package com.grl.hibernateDemo.controller;

import com.grl.hibernateDemo.dao.PickOrderRepository;
import com.grl.hibernateDemo.model.PickOrder;
import com.grl.hibernateDemo.pickOrderHandler.PickOrderNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PickOrderController {
    private final PickOrderRepository pickOrderRepository;

    public PickOrderController(PickOrderRepository pickOrderRepository) {
        this.pickOrderRepository = pickOrderRepository;
    }

    @GetMapping("/pickorders")
    List<PickOrder> all() {
        return pickOrderRepository.findAll();
    }
    @PostMapping("/pickorders")
    PickOrder newPickOrder(@RequestBody PickOrder newPickOrder) {
        return pickOrderRepository.save(newPickOrder);
    }
    //Single item
    @GetMapping("/pickorders/{id}")
    PickOrder singlePickOrder(@PathVariable Long id){
        return pickOrderRepository.findById(id).orElseThrow(()-> new PickOrderNotFoundException(id));
    }

    @PutMapping("/pickorders/{id}")
    PickOrder replacePickOrder(@RequestBody PickOrder newPickOrder, @PathVariable Long id){
        return pickOrderRepository.findById(id)
                .map(pickOrder -> {
                    pickOrder.setOrderNumber(newPickOrder.getOrderNumber());
                    pickOrder.setFirstName(newPickOrder.getFirstName());
                    pickOrder.setLastName(newPickOrder.getLastName());
                    pickOrder.setCustomerType(newPickOrder.getCustomerType());
                    return pickOrderRepository.save(pickOrder);
                })
                .orElseGet(() ->{
                    newPickOrder.setId(id);
                    return pickOrderRepository.save(newPickOrder);
                });
    }

    @DeleteMapping("/pickorders/{id}")
    void deletePickOrder(@PathVariable Long id){
        pickOrderRepository.deleteById(id);
    }
}