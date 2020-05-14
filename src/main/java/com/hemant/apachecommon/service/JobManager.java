package com.hemant.apachecommon.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Log4j2
@Service
public class JobManager {

    private static final String SAMPLE_CSV_FILE = "./output/person.csv";

    File file = new File(SAMPLE_CSV_FILE);

    @Autowired
    private CSVWriterService csvWriterService;

    @Autowired
    private CSVReaderService csvReaderService;

    public void startJob(){
        try {
            if(file.exists()) {
                boolean delete = file.delete();
                log.info("Existing csv lie deleted..."+delete);

            }
            csvWriterService.writeCSVFile();
            csvReaderService.readCSVFile();
            log.info("Job task has been completed...");
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
