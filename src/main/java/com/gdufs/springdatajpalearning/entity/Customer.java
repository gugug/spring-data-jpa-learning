package com.gdufs.springdatajpalearning.entity;

import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 在@Entity下增加@NamedQuery定义，需要注意，这里的sql表达式里的表名要和当前的Entity一致，d大小写一致 否则会找不到，报错！！！
 * 查询参数也要和实体进行对应起来，是firstName而不是first_name,切记！！
 */
@Entity
@NamedQuery(name = "Customer.findByFirstName", query = "select c from Customer c where c.firstName = ?1")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    protected Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}
