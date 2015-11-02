package cn.dp.dao.impl;

import cn.dp.dao.CustomerDao;
import cn.dp.domain.Customer;
import cn.dp.utils.JdbcUtil;

import java.sql.*;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
import java.util.List;

/**
 * Created by pu on 2015/11/1 0001.
 */
>>>>>>> origin/master
public class CustomerDaoJdbcImpl implements CustomerDao {

    public void save(Customer customer) {
        Connection conn = null;
        PreparedStatement ps = null;
<<<<<<< HEAD
        ResultSet rs = null;

        try {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("INSERT into customers (name,gender,birthday,cellphone,email,hobby,type,description) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getGender());
            ps.setDate(3, new Date(customer.getBirthday().getTime()));
            ps.setString(4, customer.getCellphone());
            ps.setString(5, customer.getEmail());
            ps.setString(6, customer.getHobby());
            ps.setString(7, customer.getType());
            ps.setString(8, customer.getDescription());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            JdbcUtil.release(conn, ps, rs);
=======
        ResultSet rs=null;

        try {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("");
        } catch (SQLException e) {
            throw new RuntimeException();
        }finally {
            JdbcUtil.release(conn,ps,rs);
>>>>>>> origin/master
        }

    }

    public void delete(Integer id) {
        Connection conn = null;
        PreparedStatement ps = null;
<<<<<<< HEAD
        ResultSet rs = null;

        try {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("DELETE from customers WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            JdbcUtil.release(conn, ps, rs);
=======
        ResultSet rs=null;

        try {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("");
        } catch (SQLException e) {
            throw new RuntimeException();
        }finally {
            JdbcUtil.release(conn,ps,rs);
>>>>>>> origin/master
        }
    }

    public Customer findOne(Integer id) {
        Connection conn = null;
        PreparedStatement ps = null;
<<<<<<< HEAD
        ResultSet rs = null;

        try {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("SELECT *FROM customers where id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Customer c = new Customer();
                c.setID(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setGender(rs.getString("gender"));
                c.setCellphone(rs.getString("cellphone"));
                c.setEmail(rs.getString("email"));
                c.setHobby(rs.getString("hobby"));
                c.setType(rs.getString("type"));
                c.setDescription(rs.getString("description"));
                c.setBirthday(rs.getDate("birthday"));
                return c;
            }else{
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            JdbcUtil.release(conn, ps, rs);
        }
=======
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
>>>>>>> origin/master
    }

    public List<Customer> findAll() {
        Connection conn = null;
        PreparedStatement ps = null;
<<<<<<< HEAD
        ResultSet rs = null;

        try {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("SELECT * FROM customers");
            rs = ps.executeQuery();
            List<Customer> list = new ArrayList<Customer>();
            while (rs.next()) {
                Customer c = new Customer();
                c.setID(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setGender(rs.getString("gender"));
                c.setCellphone(rs.getString("cellphone"));
                c.setEmail(rs.getString("email"));
                c.setHobby(rs.getString("hobby"));
                c.setType(rs.getString("type"));
                c.setDescription(rs.getString("description"));
                c.setBirthday(rs.getDate("birthday"));
                list.add(c);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            JdbcUtil.release(conn, ps, rs);
        }
=======
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
>>>>>>> origin/master
    }

    public void update(Customer customer) {
        Connection conn = null;
        PreparedStatement ps = null;
<<<<<<< HEAD
        ResultSet rs = null;

        try {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("UPDATE customers SET name=?,gender=?,birthday=?,cellphone=?,email=?,hobby=?,type=?,description=? WHERE id=?");
            ps.setString(1,customer.getName());
            ps.setString(2,customer.getGender());
            ps.setDate(3,new Date(customer.getBirthday().getTime()));
            ps.setString(4,customer.getCellphone());
            ps.setString(5,customer.getEmail());
            ps.setString(6,customer.getHobby());
            ps.setString(7,customer.getType());
            ps.setString(8,customer.getDescription());
            ps.setInt(9,customer.getID());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            JdbcUtil.release(conn, ps, rs);
=======
        ResultSet rs=null;

        try {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("");
        } catch (SQLException e) {
            throw new RuntimeException();
        }finally {
            JdbcUtil.release(conn,ps,rs);
>>>>>>> origin/master
        }
    }
}
