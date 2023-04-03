package com.lennon.jpa.repository;

import com.lennon.jpa.dto.OrderCombine;
import com.lennon.jpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

//        @Query("SELECT new com.lennon.jpa.dto.OrderCombine(c.name , p.productName) FROM Customer c JOIN c.product p")
//        public List<OrderCombine> getOrderList();

    @Query("SELECT new com.lennon.jpa.dto.OrderCombine(c.name, p.productName ) FROM Customer c JOIN p.product p")
    public default List<OrderCombine> getOrderList() {
        return null;
    }


}
