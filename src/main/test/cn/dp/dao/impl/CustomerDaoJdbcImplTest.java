package cn.dp.dao.impl;

import cn.dp.domain.Customer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class CustomerDaoJdbcImplTest {
    Customer c = null;
    CustomerDaoJdbcImpl cdji = new CustomerDaoJdbcImpl();
    @Before
    public void setUp() throws Exception {
        c = new Customer();
        c.setID(1);
        c.setName("fuckubitch");
        c.setDescription("caoniam");
        c.setType("nidie");
        c.setHobby("caonima");
        c.setEmail("caonidie@nima.com");
        c.setBirthday(new Date());
        c.setCellphone("138383838");
        c.setGender("renyao");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSave() throws Exception {
        cdji.save(c);
    }

    @Test
    public void testDelete() throws Exception {
        cdji.delete(1);
    }

    @Test
    public void testFindOne() throws Exception {
        Customer cu = cdji.findOne(1);
        Assert.assertEquals(c.getEmail(),cu.getEmail());
    }

    @Test
    public void testFindAll() throws Exception {
        List list = cdji.findAll();
        System.out.println(list);
    }

    @Test
    public void testUpdate() throws Exception {
        cdji.update(c);
    }
}