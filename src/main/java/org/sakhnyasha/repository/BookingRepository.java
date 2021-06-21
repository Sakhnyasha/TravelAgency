package org.sakhnyasha.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.sakhnyasha.entity.Booking;
import org.sakhnyasha.entity.Country;
import org.sakhnyasha.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.List;

@Repository
public class BookingRepository extends AbstractRepository<Booking>{
    public BookingRepository() {
        setClazz(Booking.class);
    }

    public List<Booking> findBookingByUser(Long userId){
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Booking> cq = cb.createQuery(Booking.class);
        Root<Booking> root = cq.from(Booking.class);

        cq.select(root).where(cb.equal(root.get("user"), userId));

        Query<Booking> query = session.createQuery(cq);
        List<Booking> results = query.getResultList();

        return results;
    }

}
