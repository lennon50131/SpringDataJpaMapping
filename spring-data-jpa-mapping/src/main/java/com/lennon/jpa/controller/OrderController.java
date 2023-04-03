package com.lennon.jpa.controller;

import com.lennon.jpa.dto.OrderCombine;
import com.lennon.jpa.dto.OrderRequest;
import com.lennon.jpa.entity.Customer;
import com.lennon.jpa.repository.CustomerRepository;
import com.lennon.jpa.repository.ProductRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class OrderController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request){
        return customerRepository.save(request.getCustomer());
    }

    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
        return customerRepository.findAll();
    }

    @GetMapping("/getInfo")
    public List<OrderCombine> getOrderCombine(){
        return customerRepository.getOrderList();
    }

    @GetMapping("/findByIds/{id}")
    public Customer findById(@PathVariable int id) {

        Optional<Customer> obj = customerRepository.findById(id);
        Customer c = null;
        if (obj.isPresent()) {
            c = (Customer) obj.get();
        }
        return c;
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable("id")Integer id) {
        customerRepository.deleteById(id);
    }

    @PutMapping("/updateCustomer/{Id}")
    public @ResponseBody String updateUser(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return "Updated"; }

}
