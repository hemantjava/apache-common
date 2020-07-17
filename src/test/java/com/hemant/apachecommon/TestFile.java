package com.hemant.apachecommon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TestFile {
    public static void main(String[] args) throws IOException {
        DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate ld = LocalDate.parse("20170313", DATEFORMATTER);
        LocalDateTime ldt = LocalDateTime.of(ld,LocalDateTime.now().toLocalTime());
        System.out.println(ldt);
        List list = new LinkedList();

         File file = null;
         FileInputStream fi = new FileInputStream(file.getName());
        fi.read();
    }
}

