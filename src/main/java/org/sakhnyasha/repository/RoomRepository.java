package org.sakhnyasha.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.sakhnyasha.entity.Room;
import org.sakhnyasha.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

@Repository
public class RoomRepository extends AbstractRepository<Room>{

    public RoomRepository() {
        setClazz(Room.class);
    }

    public List<Room> findRoomsByHotelId(Long hotelId){
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Room> cq = cb.createQuery(Room.class);
        Root<Room> root = cq.from(Room.class);

        cq.select(root).where(cb.equal(root.get("hotel"), hotelId));

        Query<Room> query = session.createQuery(cq);

        return query.getResultList();
    }

    public void deleteRoomsByHotelId(Long hotelId){
        findRoomsByHotelId(hotelId).stream().filter(Objects::nonNull).forEach(this::delete);
    }
}
