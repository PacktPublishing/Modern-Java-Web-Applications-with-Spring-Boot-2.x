package org.packt.springboot22.vid03.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.packt.springboot22.vid03.model.Harvest;
import org.packt.springboot22.vid03.model.QHarvest;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;

@Repository
public class HarvestCustomDslSupportImpl implements HarvestCustomDslSupport{
	@PersistenceContext
	private EntityManager entityManager;
	
    public List<Harvest> findByName(String name) {
    	QHarvest qHarvest = QHarvest.harvest;
    	JPAQuery<QHarvest> query = new JPAQuery<>(entityManager);
    	query.from(qHarvest).where(qHarvest.name.eq(name)).fetch();
    	return query.createQuery().getResultList();
  
    }


	@Override
	public List<QHarvest> getAllHarvest(long id) {
		QHarvest qHarvest = QHarvest.harvest;
    	JPAQuery<QHarvest> query = new JPAQuery<>(entityManager);
    	query.from(qHarvest).where(qHarvest.id.eq(id)).fetch();
		return query.createQuery().getResultList();
	}

}