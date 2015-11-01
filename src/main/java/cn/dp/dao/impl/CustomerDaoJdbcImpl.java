package cn.dp.dao.impl;

import cn.dp.dao.CustomerDao;
import cn.dp.domain.Customer;
import cn.dp.utils.JdbcUtil;

import java.sql.*;
import java.util.List;

/**
 * Created by pu on 2015/11/1 0001.
 */
public class CustomerDaoJdbcImpl implements CustomerDao {

    public void save(Customer customer) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs=null;

        try {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("");
        } catch (SQLException e) {
            throw new RuntimeException();
        }finally {
            JdbcUtil.release(conn,ps,rs);
        }

    }

    public void delete(Integer id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs=null;

        try {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("");
        } catch (SQLException e) {
            throw new RuntimeException();
        }finally {
            JdbcUtil.release(conn,ps,rs);
        }
    }

    public Customer findOne(Integer id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs=null;

        try {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("");
        } catch (SQLException e) {
            throw new RuntimeException();
        }finally {
            JdbcUtil.release(conn,ps,rs);
        }
        return null;
    }

    public List<Customer> findAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs=null;

        try {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("");
        } catch (SQLException e) {
            throw new RuntimeException();
        }finally {
            JdbcUtil.release(conn,ps,rs);
        }
        return null;
    }

    public void update(Customer customer) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs=null;

        try {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("");
        } catch (SQLException e) {
            throw new RuntimeException();
        }finally {
            JdbcUtil.release(conn,ps,rs);
        }
    }
}
