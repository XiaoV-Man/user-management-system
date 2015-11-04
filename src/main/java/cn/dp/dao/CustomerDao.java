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

    @Deprecated
    List<Customer> findAll();

    void update(Customer customer);

    /**
     * 获得总记录条数
     *
     * @return
     */
    int getTotalRecords();

    /**
     * 查询分页记录
     *
     * @param startIndex
     * @param pageSize
     * @return
     */
    List findPageRecords(int startIndex, int pageSize);
}
