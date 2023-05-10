package manager;

import entity.Customer;
import error.NoResultException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import session.CustomerSessionLocal;

public class CustomerManager {

    private CustomerSessionLocal customerSessionLocal;

    public CustomerManager() {
    }

    public CustomerManager(CustomerSessionLocal customerSessionLocal) {
        this.customerSessionLocal = customerSessionLocal;
    }

    public Customer getCustomer(Long cId) throws Exception {
        return customerSessionLocal.getCustomer(cId);
    }

    public void updateCustomer(Long cId, String name, byte gender, String dob) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Date dob1 = df.parse(dob);

        Customer c = new Customer();
        c.setId(cId);
        c.setName(name);
        c.setGender(gender);
        c.setDob(dob1);
        c.setCreated(new Date());

        customerSessionLocal.updateCustomer(c);
    }

    public void createCustomer(String name, byte gender, String dob) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Date dob1 = df.parse(dob);

        Customer c = new Customer();
        c.setName(name);
        c.setGender(gender);
        c.setDob(dob1);
        c.setCreated(new Date());

        customerSessionLocal.createCustomer(c);
    }

    public List<Customer> searchCustomer(String name) {
        return customerSessionLocal.searchCustomers(name);
    }

    public void deleteCustomer(Long cId) throws NoResultException {
        customerSessionLocal.deleteCustomer(cId);
    }

}
