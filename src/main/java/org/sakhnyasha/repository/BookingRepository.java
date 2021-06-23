package org.sakhnyasha.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.sakhnyasha.entity.Booking;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    public void deleteBookingsForUser(Long userId){
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<Booking> cq = cb.createCriteriaDelete(Booking.class);
        Root<Booking> root = cq.from(Booking.class);

        cq.where(cb.equal(root.get("user"), userId));
        session.createQuery(cq).executeUpdate();

    }


    public void deleteBookingsForRoom(Long roomId){
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<Booking> cq = cb.createCriteriaDelete(Booking.class);
        Root<Booking> root = cq.from(Booking.class);

        cq.where(cb.equal(root.get("room"), roomId));
        session.createQuery(cq).executeUpdate();
    }

}
