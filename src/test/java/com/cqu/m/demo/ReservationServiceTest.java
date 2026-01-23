//package com.cqu.m.demo;
//
//
//import com.cqu.m.demo.pojo.Reservation;
//import com.cqu.m.demo.service.ReservationService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDateTime;
//
//@SpringBootTest
//public class ReservationServiceTest {
//    @Autowired
//    private ReservationService reservationService;
//    @Test
//    void testInsertReservation() {
//        Reservation reservation = new Reservation(null, "张三", "男", "12345678901", LocalDateTime.now(), "北京", 580);
//        reservationService.insertReservation(reservation);
//    }
//    @Test
//    void testSelectReservationByPhone() {
//        String phone = "12345678901";
//        Reservation reservation = reservationService.selectReservationByPhone(phone);
//        System.out.println(reservation);
//    }
//}
