package org.idb.Tourism.controller;


import org.idb.Tourism.entity.Hotel;
import org.idb.Tourism.entity.Payment;
import org.idb.Tourism.service.PaymentService;
import org.idb.Tourism.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PaymentController {

    @Autowired
   BookingService bookingService;
    @Autowired
    UserService userService;
    @Autowired
    PaymentService paymentService;


    @RequestMapping("/p-form")
    public String paymentForm(Model m){
        m.addAttribute("payment", new Payment());
        m.addAttribute("paymentList", paymentService.getAllPayment());
        m.addAttribute("bookingList", bookingService.getAllBooking());
        m.addAttribute("userList", userService.getAllUser());
        return "payment-form";
    }


    @RequestMapping("/payment_list")
    public  String paymentList(Model m){
        m.addAttribute("bookingList", bookingService.getAllBooking());
        m.addAttribute("userList", userService.getAllUser());
       m.addAttribute("paymentList",paymentService.getAllPayment());

        m.addAttribute("payment", new Payment());
        return "paymentlist";
    }

    @RequestMapping(value = "/payment_save", method = RequestMethod.POST)
    public  String paymentSave(@ModelAttribute("payment") Payment p, Model m){
        paymentService.savePayment(p);
        m.addAttribute("title", "Add Payment");
        m.addAttribute("message","Payment add successful");
        return "redirect:/payment_list";
    }
    @RequestMapping("/delete_payment/{pid}")
    public String deletePayment(@PathVariable("pid") Integer pid){
       paymentService.deletePayment(pid);
        return "redirect:/payment_list";
    }

    @RequestMapping("/update_payment/{pid}")
    public String updatePayment(@PathVariable("pid") Integer pid, Model m){
        Payment p = paymentService.findPaymentById(pid);
        m.addAttribute("payment", p);
        m.addAttribute("bookingList", bookingService.getAllBooking());
        m.addAttribute("userList", userService.getAllUser());
        return "paymentlist";
    }






}
