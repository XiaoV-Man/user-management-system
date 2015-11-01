package cn.dp.service;

import cn.dp.domain.Customer;
import cn.dp.exception.IdIsNullException;

import java.util.List;

/**
 * Created by pu on 2015/11/1 0001.
 */
public interface BussinessService {
    /**
     * 增加一个客户信息
     * @param customer
     */
    void addCustomer(Customer customer);

    /**
     * 根据主键删除客户信息
     * @param id
     */
    void deleteCustomer(Integer id);

    /**
     * 修改客户信息
     * @param customer
     */
    void updateCustomer(Customer customer) throws IdIsNullException;

    /**
     * 获得所有客户信息
     * @return  客户信息列表
     */
    List<Customer> findAllCustomers();

    /**
     * 根据主键获得客户信息
     * @param id
     * @return
     */
    Customer findCustomerById(Integer id);
}
