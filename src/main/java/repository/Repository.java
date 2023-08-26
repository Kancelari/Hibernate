package repository;

public interface Repository <T>{
    T findById(Integer id);
    void save(T model);
    void update(T model);
    void delete (T model);
}
