package com.gdufs.springdatajpalearning.controller;

import com.gdufs.springdatajpalearning.entity.Customer;
import com.gdufs.springdatajpalearning.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by gucailiang on 2018/1/11.
 */
@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    /**
     * 初始化数据
     */
    @GetMapping("save")
    public void save() {
        customerRepository.save(new Customer("Jack", "Bauer"));
        customerRepository.save(new Customer("Chloe", "O'Brian"));
        customerRepository.save(new Customer("Kim", "Bauer"));
        customerRepository.save(new Customer("David", "Palmer"));
        customerRepository.save(new Customer("Michelle", "Dessler"));
        customerRepository.save(new Customer("Bauer", "Dessler"));
    }

    /**
     * 查询所有
     */
    @GetMapping("findAll")
    public void findAll() {
        List<Customer> result = customerRepository.findAll();
        for (Customer customer : result) {
            System.out.println(customer.toString());
        }
    }

    /**
     * 查询ID为1的数据
     */
    @GetMapping("findOne")
    public void findOne() {
        Customer result = customerRepository.findOne(1L);
        if (result != null) {
            System.out.println(result.toString());
        }
    }

    /**
     * 查询ID为1的数据
     */
    @RequestMapping("/delete")
    public void delete() {

        System.out.println("删除前数据：");
        List<Customer> customers = customerRepository.findAll();
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }

        System.out.println("删除ID=3数据：");
        customerRepository.delete(3L);

        System.out.println("删除后数据：");
        customers = customerRepository.findAll();
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
        System.out.println("-------------------------------------------");
    }

    /**
     * 查询lastName为指定用户昵称
     */
    @RequestMapping("/findByLastName")
    public void findByLastName(){
        List<Customer> result = customerRepository.findByLastName("Bauer");
        for (Customer customer:result){
            System.out.println(customer.toString());
        }
        System.out.println("-------------------------------------------");
    }

    /**
     * 查询FirstName为指定用户昵称
     */
    @RequestMapping("/findByFirstName")
    public void findByFirstName(){
        Customer customer = customerRepository.findByFirstName("Bauer");
        if(customer!=null){
            System.out.println(customer.toString());
        }
        System.out.println("-------------------------------------------");
    }
}
