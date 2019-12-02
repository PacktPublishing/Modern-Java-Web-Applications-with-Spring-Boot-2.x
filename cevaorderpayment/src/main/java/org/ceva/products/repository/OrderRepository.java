package org.ceva.products.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.ceva.products.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<OrderProduct, Long> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update order_product set status = ?1 where order_id = ?2", nativeQuery = true)
	public void updateStatusByOrderId(String newStatus, Long orderId);
	
	@Query("select o from OrderProduct o where o.orderId = ?1 and o.status = ?2")
	public List<OrderProduct> findByOrderIdAndStatus(Long orderId, String status);
}
