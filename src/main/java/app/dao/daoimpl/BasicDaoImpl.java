package app.dao.daoimpl;

import app.dao.BasicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.OptimisticLockException;

@Component
public class BasicDaoImpl<T> implements BasicDao<T> {


    // Вместо   session в новом хибернейте используем ентити читай мануалы к нему
    @Autowired
    EntityManagerFactory entityManagerFactory;

    private Class<T> type;


    public BasicDaoImpl(Class<T> type) {
        this.type = type;
    }

    public BasicDaoImpl() {
    }


    @Override
    public T getById(long id) {
        return entityManagerFactory.createEntityManager().find(type, id);
    }

    @Transactional
    @Override
    public T create(T object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();

        return object;
    }

    @Transactional
    @Override
    public boolean delete(T object) {
        boolean flag = false;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.remove(object);
            entityManager.getTransaction().commit();
            flag = true;
        }catch (OptimisticLockException e){
            e.printStackTrace();
        }
        finally {
            return flag;
        }
    }

    @Transactional
    @Override
    public boolean update(T object) {
        boolean flag = false;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(object);
            entityManager.getTransaction().commit();
            flag = true;
        }catch (OptimisticLockException e){
            e.printStackTrace();
        }
        finally {
            return flag;
        }
    }


}
