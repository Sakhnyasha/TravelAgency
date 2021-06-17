package org.sakhnyasha.repository;

import org.sakhnyasha.entity.Hotel;
import org.sakhnyasha.model.HotelModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HotelRepository extends AbstractRepository<Hotel> {
    public HotelRepository() {
        setClazz(Hotel.class);
    }
}
