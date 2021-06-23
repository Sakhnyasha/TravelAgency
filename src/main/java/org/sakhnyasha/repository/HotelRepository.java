package org.sakhnyasha.repository;

import org.sakhnyasha.entity.Hotel;
import org.springframework.stereotype.Repository;

@Repository
public class HotelRepository extends AbstractRepository<Hotel> {
    public HotelRepository() {
        setClazz(Hotel.class);
    }
}

