package app.dao.daoimpl;

import app.dao.BasicDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;

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
}
