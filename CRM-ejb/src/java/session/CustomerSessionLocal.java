package session;

import entity.Customer;
import error.NoResultException;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CustomerSessionLocal {

    public List<Customer> searchCustomers(String name);

    public Customer getCustomer(Long cId) throws NoResultException;

    public void createCustomer(Customer c);

    public void updateCustomer(Customer c) throws NoResultException;

    public void deleteCustomer(Long cId) throws NoResultException;

}
