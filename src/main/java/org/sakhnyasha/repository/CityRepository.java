package org.sakhnyasha.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.sakhnyasha.entity.City;
import org.sakhnyasha.entity.Country;
import org.sakhnyasha.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CityRepository extends AbstractRepository<City> {
    public CityRepository() {
        setClazz(City.class);
    }

    public List<City> findCitiesByCountryId(Long countryId){
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<City> cq = cb.createQuery(City.class);
        Root<City> root = cq.from(City.class);

        cq.select(root).where(cb.equal(root.get("country"), countryId));

        Query<City> query = session.createQuery(cq);
        List<City> results = query.getResultList();

        return results;
    }

}


