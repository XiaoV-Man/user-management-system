package cn.dp.dao.impl;

import cn.dp.dao.CustomerDao;
import cn.dp.domain.Customer;
import cn.dp.utils.DBCPUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/*
 * 使用DBUtils重构
 */
public class CustomerDaoDBUtilsImpl implements CustomerDao {
    QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());

    public void save(Customer customer) {
        try {
            qr.update("INSERT INTO customers (name,gender,birthday,cellphone,email,hobby,type,description) VALUES (?,?,?,?,?,?,?,?)",
                    customer.getName(),
                    customer.getGender(),
                    customer.getBirthday(),
                    customer.getCellphone(),
                    customer.getEmail(),
                    customer.getHobby(),
                    customer.getType(),
                    customer.getDescription());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Integer id) {
        try {
            qr.update("DELETE FROM customers WHERE id=?", id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Customer findOne(Integer id) {
        try {
            return  qr.query("SELECT *FROM customers WHERE id=?", new BeanHandler<Customer>(Customer.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> findAll() {
        try {
            return  qr.query("SELECT * FROM customers", new BeanListHandler<Customer>(Customer.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Customer customer) {
        try {
            qr.update("UPDATE customers SET name=?,gender=?,birthday=?,cellphone=?,email=?,hobby=?,type=?,description=? WHERE id=?",
                    customer.getName(),
                    customer.getGender(),
                    customer.getBirthday(),
                    customer.getCellphone(),
                    customer.getEmail(),
                    customer.getHobby(),
                    customer.getType(),
                    customer.getDescription(),
                    customer.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int getTotalRecords() {
        try {
            return qr.query("SELECT COUNT(*) FROM customers", new ScalarHandler<Long>(1)).intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List findPageRecords(int startIndex, int pageSize) {
        try {
            return qr.query("SELECT * FROM customers LIMIT ?,?", new BeanListHandler<Customer>(Customer.class), startIndex, pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
