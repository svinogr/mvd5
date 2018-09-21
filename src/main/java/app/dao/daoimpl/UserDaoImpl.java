package app.dao.daoimpl;

import app.dao.BasicDao;
import app.dao.UserDao;
import app.entity.users.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class UserDaoImpl extends BasicDaoImpl<User> implements UserDao<User> {



    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User getByLogin(String login) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery  = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("login"),login));
        List<User> users = entityManager.createQuery(criteriaQuery).getResultList();

        return users.get(0);



    }
}
