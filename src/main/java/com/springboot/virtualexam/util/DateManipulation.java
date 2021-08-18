package com.springboot.virtualexam.util;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class DateManipulation {
    public static int getAge(LocalDate birthday){
        LocalDate dateNow = LocalDate.now();
        Period dateComparison = Period.between(birthday, dateNow);
        return dateComparison.getYears();
    }

    public static Date timeExpired(Date now, int expirationSecond){
        Long dateToMillisecond = now.getTime();
        int expirationToMillisecond = expirationSecond * 1000;

        return new Date(dateToMillisecond+ expirationToMillisecond);
    }
}
