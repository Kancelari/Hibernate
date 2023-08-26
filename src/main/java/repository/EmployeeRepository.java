package repository;

import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeRepository implements Repository<Employee>{
    private final Session session;

    public EmployeeRepository(Session session) {
        this.session = session;
    }

    @Override
    public Employee findById(Integer id) {
        try{
            return session.find(Employee.class, id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Employee model) {
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.save(model);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employee model) {
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.update(model);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Employee model) {
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.delete(model);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
