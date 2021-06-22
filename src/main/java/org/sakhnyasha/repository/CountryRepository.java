package org.sakhnyasha.repository;

import org.sakhnyasha.entity.Country;
import org.springframework.stereotype.Repository;

@Repository
public class CountryRepository extends AbstractRepository<Country> {
    public CountryRepository() {
        setClazz(Country.class);
    }
}
