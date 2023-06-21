package org.idb.Tourism.service;

import org.idb.Tourism.entity.Payment;
import org.idb.Tourism.repository.IPaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    IPaymentRepo iPaymentRepo;
    public  void savePayment(Payment P){
        iPaymentRepo.save(P);
    }

    public  void deletePayment(int pId){
        iPaymentRepo.deleteById(pId);
    }

    public List<Payment> getAllPayment(){
        return  iPaymentRepo.findAll();

    }

    public Payment findPaymentById(int pId){
        return iPaymentRepo.findById(pId).get();
    }


}

