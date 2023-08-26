package repository;

import model.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DepartmentRepository implements Repository<Department> {
    private final Session session;

    public DepartmentRepository(Session session) {
        this.session = session;
    }

    @Override
    public Department findById(Integer id) {
        try{
            return session.find(Department.class, id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Department model) {
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
    public void update(Department model) {
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
    public void delete(Department model) {
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
