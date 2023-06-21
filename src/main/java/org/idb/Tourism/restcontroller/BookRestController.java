package org.idb.Tourism.restcontroller;


import org.idb.Tourism.entity.Booking;

import org.idb.Tourism.entity.Location;
import org.idb.Tourism.repository.IBookingRepo;
import org.idb.Tourism.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class BookRestController {



    @Autowired
    LocationService locationService;
    @Autowired
    HotelService hotelService;
    @Autowired
    HotelFacilitiesService hotelFacilitiesService;
    @Autowired
    RoomService roomService;
    @Autowired
    RoomFacilitiesService roomFacilitiesService;

    @Autowired
    RoomtypeService roomtypeService;

    @Autowired
    IBookingRepo iBookingRepo;
    @Autowired
    BookingService bookingService;


    @Autowired
    JavaMailSender javaMailSender;


    public BookRestController(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @PostMapping("/booksave")
    public  void bookSave(@RequestBody Booking b){
        LocalDateTime ldt = LocalDateTime.now();
        b.setBdatetime(ldt);
        bookingService.saveBook(b);
    }

    @GetMapping("/booking/all")
    public List<Booking> allBooking(){
        return bookingService.getAllBooking();
    }

    @PutMapping("/booking/update/{id}")
    public void updateBooking(@RequestBody Booking b ,@PathVariable("id")  Integer id) throws MessagingException {
        Booking book = new Booking();
        book = iBookingRepo.findBybookId(id);
        book.setEmail(b.getEmail());


        //send email to user

        String uEmail = book.getEmail();

        javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
        message.setTo(book.getEmail());

        String html = "<!doctype html>\n" +
                "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\"\n" +
                "      xmlns:th=\"http://www.thymeleaf.org\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\"\n" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>Email</title>\n" +
                "</head>\n" +
                "<body>\n" +

                "<div>Welcome to Booking HOTEL AL-SELIM, <b>"+"</b></div>\n" +
                "\n" +
                "\n" +"Your booking information is:- <br>"+
                "<div>Hotel Name :-<b> "+ book.getHotelname()+" </b></div>\n" +
                "<div>Location :-<b> "+ book.getLocation()+" </b></div>\n" +
                "<div>Hotel Address :-<b> "+ book.getHoteladdress()+" </b></div>\n"+
                "<div>Room Number <b> "+ book.getRoomnumber()+" </b><br></div>\n" +
                "<div>Booking for <b> "+ book.getCheckin() +" to "+ book.getCheckout()+"</b><br></div>\n" +
                "Your booking is confirmed, Thanks for being with us <br> <br>"+
                " Booking Inn " + "</b></div>\n" +
                "<div> Any Information Please Call us<b>" + " +880001222333 " + "</b></div>\n" +
                "</body>\n" +
                "</html>\n";

        message.setSubject("Booking Inn booking confirmation");
        message.setFrom("info@emranhss.com");

        message.setText(html, true);
        javaMailSender.send(mimeMessage);

        // end email


        iBookingRepo.save(book);
    }

    @GetMapping("/booking/maxid")
    public Integer maxBookingId(){
        return iBookingRepo.findMaxBookingId();
    }




}
