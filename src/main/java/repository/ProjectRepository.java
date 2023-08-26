package repository;

import model.Project;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProjectRepository implements Repository<Project>{
    private final Session session;

    public ProjectRepository(Session session) {
        this.session = session;
    }

    @Override
    public Project findById(Integer id) {
        try{
            return session.find(Project.class, id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Project model) {
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
    public void update(Project model) {
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
    public void delete(Project model) {
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
