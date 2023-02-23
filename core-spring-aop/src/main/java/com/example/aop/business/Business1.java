package com.example.aop.business;

import com.example.aop.custom.TrackTime;
import com.example.aop.data.Dao1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business1 {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Dao1 dao1;

    @TrackTime
    public String calculateSomething() {
        String value = dao1.retrieveSomething();
        logger.info("*** In Business - {}", value);
        return value;
    }

    @TrackTime
    public void calculateSomeOtherThing() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @TrackTime
    public int calculateJustOtherThing() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return 2;
    }

    public int getSomeValueHopefully() {
        return dao1.tryMeToGtSomeValue();
    }
}
