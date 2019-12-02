package org.packt.springboot22.vid06.repository;

import org.packt.springboot22.vid06.model.Harvest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class HarvestCustomRepositoryImpl implements HarvestCustomRepository{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void updateQtyPrice(Long id, float newPrice, int newQty) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		Update update = new Update();
		update.set("price", newPrice);
		update.set("qty", newQty);
		mongoTemplate.findAndModify(query, update, Harvest.class);
	}

	

}
