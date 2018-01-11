package com.gdufs.springdatajpalearning.repository;

import com.gdufs.springdatajpalearning.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * public interface JpaRepository<T,ID extends Serializable> extends PagingAndSortingRepository<T,ID>, QueryByExampleExecutor<T>
 * <p>
 * Methods inherited from interface org.springframework.data.repository.PagingAndSortingRepository
 * findAll
 * <p>
 * Methods inherited from interface org.springframework.data.repository.CrudRepository
 * count, delete, delete, delete, deleteAll, exists, findOne, save
 * <p>
 * Methods inherited from interface org.springframework.data.repository.query.QueryByExampleExecutor
 * count, exists, findAll, findOne
 * <p>
 * Created by gucailiang on 2018/1/11.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
