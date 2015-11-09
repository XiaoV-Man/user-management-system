package cn.dp.service.impl;

import cn.dp.common.Page;
import cn.dp.dao.CustomerDao;
import cn.dp.domain.Customer;
import cn.dp.exception.IdIsNullException;
import cn.dp.service.BussinessService;

import java.util.List;
import java.util.Properties;

public class BussinessServiceImpl implements BussinessService {
    private static String daoClassPath;

    private static CustomerDao cd = null;

    static {
        try {
            Properties props = new Properties();
            props.load(BussinessServiceImpl.class.getClassLoader().getResourceAsStream("daoconfig.properties"));
            daoClassPath = (String) props.get("daoClass");
            cd = (CustomerDao) Class.forName(daoClassPath).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("初始化DAO异常");
        }
    }

    public void addCustomer(Customer customer) {
        cd.save(customer);
    }

    public void deleteCustomer(Integer id) {
        cd.delete(id);
    }

    public void updateCustomer(Customer customer) throws IdIsNullException {
        if (customer.getId() == null) {
            throw new IdIsNullException();
        }
        cd.update(customer);
    }

    public List<Customer> findAllCustomers() {
        return cd.findAll();
    }

    public Customer findCustomerById(Integer id) {
        return cd.findOne(id);
    }

    public Page findPage(String num) {
        Integer pageNum = 1;
        if (num != null && !num.equals("")) {
            pageNum = Integer.parseInt(num);
        }
        Page page = new Page(cd.getTotalRecords(), pageNum);
        page.setRecords(cd.findPageRecords(page.getStartIndex(), page.getPageSize()));
        return page;
    }
}
