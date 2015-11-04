package cn.dp.service.impl;

import cn.dp.common.Page;
import cn.dp.dao.CustomerDao;
import cn.dp.dao.impl.CustomerDaoJdbcImpl;
import cn.dp.domain.Customer;
import cn.dp.exception.IdIsNullException;
import cn.dp.service.BussinessService;

import java.util.List;

public class BussinessServiceImpl implements BussinessService {
    private CustomerDao cd = new CustomerDaoJdbcImpl();

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
        Page page = new Page(cd.getTotalRecords(),pageNum);
        page.setRecords(cd.findPageRecords(page.getStartIndex(), page.getPageSize()));
        return page;
    }
}
