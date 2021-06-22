package org.sakhnyasha.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.sakhnyasha.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository

public class UserRepository extends AbstractRepository<User> {

    public UserRepository() {
        setClazz(User.class);
    }

    public User findByEmail(String email){
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);

        cq.select(root).where(cb.equal(root.get("email"), email));

        Query<User> query = session.createQuery(cq);
        List<User> results = query.getResultList();

        return results.get(0);
    }


}
