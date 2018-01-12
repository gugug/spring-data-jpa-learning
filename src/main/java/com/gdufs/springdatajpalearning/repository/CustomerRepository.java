package com.gdufs.springdatajpalearning.repository;

import com.gdufs.springdatajpalearning.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

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
    /**
     * 根据lastName查询结果
     *
     * @param lastName
     * @return
     */
    List<Customer> findByLastName(String lastName);


    /////////////////预定义查询（NamedQueries）/////////////////////

    /**
     * Entity类里@Entity 下注解@NamedQuery
     *
     * @param firstName
     * @return
     */
    Customer findByFirstName(String firstName);


    /////////////////@Query注解（Using @Query）///////////////////////////////

    /**
     * @param firstName
     * @return
     */
    @Query("select c from Customer c where c.firstName=?1")
    Customer findByFirstName2(String firstName);

    @Query("select c from Customer c where c.lastName=?1 order by c.id desc")
    List<Customer> findByLastName2(String lastName);

    /**
     * 一个参数，匹配两个字段
     *
     * @param name
     * @return 这里Param的值和=:后面的参数匹配，但不需要和方法名对应的参数值对应
     */
    @Query("select c from Customer c where c.firstName=:name or c.lastName=:name  order by c.id desc")
    List<Customer> findByName(@Param("name") String name);

    /**
     * 一个参数，匹配两个字段
     *
     * @param name
     */
    @Query("select c from Customer c where c.firstName like ?1%")
    List<Customer> findByName2(@Param("name") String name);

    /**
     * 一个参数，匹配两个字段
     *
     * @param name
     * @return 开启nativeQuery=true，在value里可以用原生SQL语句完成查询
     */
    @Query(nativeQuery = true, value = "select * from customer c where c.first_name like concat('%' ,?1,'%') ")
    List<Customer> findByName3(@Param("name") String name);
}
