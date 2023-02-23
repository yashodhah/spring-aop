package com.example.aop;

import com.example.aop.business.Business1;
import com.example.aop.business.Business2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessAopSpringBootTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Business1 business1;

    @Autowired
    private Business2 business2;

    // TODO; Configure spring test with jupiter ?
    @Test
    public void invokeAOPStuff() {
        logger.info(business1.calculateSomething());
        logger.info("justOtherThing " + business1.calculateJustOtherThing());
        business1.calculateSomeOtherThing();

        logger.info(business2.calculateSomething());

        try {
            business1.getSomeValueHopefully();
        } catch (Exception e) {
            logger.error("Error in invoke test");
        }
    }

}
