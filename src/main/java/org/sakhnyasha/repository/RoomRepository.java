package org.sakhnyasha.repository;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.sakhnyasha.entity.Room;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Date;
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


    public List<Room> findAvailableBookings(Long cityId, Date checkIn, Date checkOut, Integer capacity){
        Session session = getCurrentSession();
        String query = "select r.id, r.name, r.capacity, r.price, r.hotel_id from rooms as r " +
                "left join bookings " +
                "on (bookings.room_id = r.id " +
                "and " +
                "not (" +
                    "(bookings.check_in < :checkIn and bookings.check_out < :checkOut) " +
                    "or (bookings.check_in > :checkIn and bookings.check_out > :checkOut) " +
                ")) " +
                "left join hotels as h " +
                "on h.id=r.hotel_id "+
                "where bookings.room_id IS NULL " +
                "and h.city_id = :cityId " +
                "AND r.capacity >= :capacity " +
                ";";

        NativeQuery<Room> sqlQuery = session.createSQLQuery(query);
        sqlQuery.setParameter("checkIn", checkIn);
        sqlQuery.setParameter("checkOut", checkOut);
        sqlQuery.setParameter("cityId", cityId);
        sqlQuery.setParameter("capacity", capacity);
        sqlQuery.addEntity(Room.class);

        return sqlQuery.list();
    }
}
