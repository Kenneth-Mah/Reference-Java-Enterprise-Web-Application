package session;

import entity.Customer;
import error.NoResultException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CustomerSession implements CustomerSessionLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Customer> searchCustomers(String name) {
        Query q;
        if (name != null) {
            q = em.createQuery("SELECT c FROM Customer c WHERE "
                    + "LOWER(c.name) LIKE :name");
            q.setParameter("name", "%" + name.toLowerCase() + "%");
        } else {
            q = em.createQuery("SELECT c FROM Customer c");
        }

        return q.getResultList();
    } //end searchCustomers

    @Override
    public Customer getCustomer(Long cId) throws NoResultException {
        Customer cust = em.find(Customer.class, cId);

        if (cust != null) {
            return cust;
        } else {
            throw new NoResultException("Not found");
        }
    } //end getCustomer

    @Override
    public void createCustomer(Customer c) {
        em.persist(c);
    } //end createCustomer

    @Override
    public void updateCustomer(Customer c) throws NoResultException {
        Customer oldC = em.find(Customer.class, c.getId());

        if (oldC != null) {
            oldC.setDob(c.getDob());
            oldC.setGender(c.getGender());
            oldC.setName(c.getName());
        } else {
            throw new NoResultException("Not found");
        }
    } //end updateCustomer

    @Override
    public void deleteCustomer(Long cId) throws NoResultException {
        Customer cust = em.find(Customer.class, cId);

        if (cust == null) {
            throw new NoResultException("Not found");
        }

        em.remove(cust);
    } //end deleteCustomer

}
