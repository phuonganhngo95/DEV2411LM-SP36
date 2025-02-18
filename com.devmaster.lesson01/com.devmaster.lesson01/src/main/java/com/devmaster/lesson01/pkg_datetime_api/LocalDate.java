package com.devmaster.lesson01.pkg_datetime_api;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDate {
    public static void main(String[] args) {
//        Ngày giờ hiện tại
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println("Ngày và giờ hiện tại: " + now1);

//        Định dạng ngày giờ
        LocalDateTime now2 = LocalDateTime.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = now2.format(formatter1);
        System.out.println("\nNgày và giờ định dạng: " + formattedDateTime);

//        Đổi chuỗi thành ngày giờ
        String dateTimeString = "2023-12-18 10:30:00";
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter2);
        System.out.println("\nNgay và giờ sau chuyển đổi: " + dateTime);

//        Phép tính với ngày giờ
        LocalDateTime now3 = LocalDateTime.now();
        LocalDateTime future = now3.plus(Duration.ofDays(7));
        System.out.println("\nNgày và giờ trong 7 ngày sau: " + future);
    }
}
