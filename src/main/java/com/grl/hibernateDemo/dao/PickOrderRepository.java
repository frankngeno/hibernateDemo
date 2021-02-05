package com.grl.hibernateDemo.dao;

import com.grl.hibernateDemo.model.PickOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PickOrderRepository extends JpaRepository <PickOrder, Long> {

}
