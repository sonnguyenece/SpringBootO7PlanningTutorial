package com.example.multipledb.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.example.multipledb.config.Constants;
import com.example.multipledb.entity2.Advertiser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdvertiserDAO {

    @Autowired
    @PersistenceContext(unitName = Constants.JPA_UNIT_NAME_2)
    private EntityManager entityManager;

    public List<Advertiser> listAdvertisers() {
        String sql = "Select e from " + Advertiser.class.getName() + " e ";
        Query query = entityManager.createQuery(sql, Advertiser.class);
        return query.getResultList();
    }

    public Advertiser findById(Long id) {
        return this.entityManager.find(Advertiser.class, id);
    }

}