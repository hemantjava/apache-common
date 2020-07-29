package com.hemant.apachecommon.controller;

import com.hemant.apachecommon.entity.Person;
import com.hemant.apachecommon.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class CSVFileDownloadController {

    @Autowired
    private PersonRepository repository;

   // localhost:9000//downloadCSV
    @RequestMapping(value = "/downloadCSV")
    public void downloadCSV(HttpServletResponse response) throws IOException {

        String csvFileName = "idCard.csv";

        response.setContentType("text/csv");

        // creates mock data
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                csvFileName);
        response.setHeader(headerKey, headerValue);


        List<Person> personList = repository.findAll();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);

        String[] header = {"id", "firstName", "lastName", "email", "gender", "age"};

        csvWriter.writeHeader(header);

        for (Person person : personList) {
            csvWriter.write(person, header);
        }

        csvWriter.close();
    }
}