package org.ceva.products.repository;

import org.ceva.products.model.PaymentProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentProduct, Long>{

	
}
