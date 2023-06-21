package org.idb.Tourism.repository;

import org.idb.Tourism.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPaymentRepo extends JpaRepository<Payment,Integer> {


}
