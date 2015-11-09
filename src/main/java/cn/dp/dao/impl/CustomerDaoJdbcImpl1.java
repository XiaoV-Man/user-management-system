package cn.dp.dao.impl;

import cn.dp.dao.CustomerDao;
import cn.dp.domain.Customer;
import cn.dp.utils.DBCPUtil;
import cn.dp.utils.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoJdbcImpl1 implements CustomerDao {

    public void save(Customer customer) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("INSERT INTO customers (name,gender,birthday,cellphone,email,hobby,type,description) VALUES (?,?,?,?,?,?,?,?)");
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
        }

    }

    public void delete(Integer id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("DELETE FROM customers WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            JdbcUtil.release(conn, ps, rs);
        }
    }

    public Customer findOne(Integer id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("SELECT *FROM customers WHERE id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setGender(rs.getString("gender"));
                c.setCellphone(rs.getString("cellphone"));
                c.setEmail(rs.getString("email"));
                c.setHobby(rs.getString("hobby"));
                c.setType(rs.getString("type"));
                c.setDescription(rs.getString("description"));
                c.setBirthday(rs.getDate("birthday"));
                return c;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            JdbcUtil.release(conn, ps, rs);
        }
    }

    public List<Customer> findAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("SELECT * FROM customers");
            rs = ps.executeQuery();
            List<Customer> list = new ArrayList<Customer>();
            while (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getInt("id"));
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
    }

    public void update(Customer customer) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("UPDATE customers SET name=?,gender=?,birthday=?,cellphone=?,email=?,hobby=?,type=?,description=? WHERE id=?");
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getGender());
            ps.setDate(3, new Date(customer.getBirthday().getTime()));
            ps.setString(4, customer.getCellphone());
            ps.setString(5, customer.getEmail());
            ps.setString(6, customer.getHobby());
            ps.setString(7, customer.getType());
            ps.setString(8, customer.getDescription());
            ps.setInt(9, customer.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            JdbcUtil.release(conn, ps, rs);
        }
    }

    public int getTotalRecords() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("SELECT COUNT(*) FROM customers");
            rs = ps.executeQuery();
            if (rs.next())
                return rs.getInt(1);
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            JdbcUtil.release(conn, ps, rs);
        }
    }

    public List findPageRecords(int startIndex, int pageSize) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("SELECT * FROM customers LIMIT ?,?");
            ps.setInt(1, startIndex);
            ps.setInt(2, pageSize);
            rs = ps.executeQuery();
            List<Customer> list = new ArrayList<Customer>();

            while (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getInt("id"));
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
    }
}
