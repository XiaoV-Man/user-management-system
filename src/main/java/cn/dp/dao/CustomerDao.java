package cn.dp.dao;

import cn.dp.domain.Customer;

import java.util.List;

/**
 * Created by pu on 2015/11/1 0001.
 */
public interface CustomerDao {
    void save(Customer customer);

    void delete(Integer id);

    Customer findOne(Integer id);

    List<Customer> findAll();

    void update(Customer customer);
}
