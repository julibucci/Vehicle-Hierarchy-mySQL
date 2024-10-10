package org.example.Interfaces;
import java.util.Optional;
import java.util.List;
public interface IGenericDAO<T, ID>
{
    Optional<T> findById(ID id);
    List<T> findAll();
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    void deleteById(ID id);
}
