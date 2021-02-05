package com.grl.hibernateDemo.model;


import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@ToString
@Setter
@Getter
@Data
@Entity(name = "PickOrder")
public class PickOrder {
    public PickOrder() {
    }

    public PickOrder(String firstName, String lastName, int orderNumber, String customerType) {
        this.firstName = firstName;
        this.LastName = lastName;
        this.orderNumber = orderNumber;
        this.customerType = customerType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String LastName;
    private int orderNumber;
    private String customerType;


}
