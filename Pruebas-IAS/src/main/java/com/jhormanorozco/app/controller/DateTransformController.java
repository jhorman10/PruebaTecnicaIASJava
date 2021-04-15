package com.jhormanorozco.app.controller;

import org.springframework.stereotype.Controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DateTransformController {
    protected static Date convertDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.parse(date);
    }
}
