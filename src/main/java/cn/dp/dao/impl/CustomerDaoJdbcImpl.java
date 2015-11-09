package cn.dp.dao.impl;

import cn.dp.dao.CustomerDao;
import cn.dp.dbassist.BaseTypeHandler;
import cn.dp.dbassist.BeanHandler;
import cn.dp.dbassist.BeanListHandler;
import cn.dp.dbassist.DBAssist;
import cn.dp.domain.Customer;
import cn.dp.utils.DBCPUtil;

import java.util.List;

/**
 * 使用DBCPAssist重构
 */
public class CustomerDaoJdbcImpl implements CustomerDao {
    DBAssist dba = new DBAssist(DBCPUtil.getDataSource());

    public void save(Customer customer) {
        dba.update("INSERT INTO customers (name,gender,birthday,cellphone,email,hobby,type,description) VALUES (?,?,?,?,?,?,?,?)",
                customer.getName(),
                customer.getGender(),
                customer.getBirthday(),
                customer.getCellphone(),
                customer.getEmail(),
                customer.getHobby(),
                customer.getType(),
                customer.getDescription());
    }

    public void delete(Integer id) {
        dba.update("DELETE FROM customers WHERE id=?", id);
    }

    public Customer findOne(Integer id) {
        return (Customer) dba.query("SELECT *FROM customers WHERE id=?", new BeanHandler(Customer.class), id);
    }

    public List<Customer> findAll() {
        return (List<Customer>) dba.query("SELECT * FROM customers", new BeanListHandler(Customer.class));
    }

    public void update(Customer customer) {
        dba.update("UPDATE customers SET name=?,gender=?,birthday=?,cellphone=?,email=?,hobby=?,type=?,description=? WHERE id=?",
                customer.getName(),
                customer.getGender(),
                customer.getBirthday(),
                customer.getCellphone(),
                customer.getEmail(),
                customer.getHobby(),
                customer.getType(),
                customer.getDescription(),
                customer.getId());

    }

    public int getTotalRecords() {
        return Integer.parseInt(dba.query("SELECT COUNT(*) FROM customers", new BaseTypeHandler()).toString());
    }

    public List findPageRecords(int startIndex, int pageSize) {
        return (List) dba.query("SELECT * FROM customers LIMIT ?,?", new BeanListHandler(Customer.class), startIndex, pageSize);
    }
}
