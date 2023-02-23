package com.example.aop.data;

import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {
    public String retrieveSomething() {
        return "Dao1";
    }

    public int tryMeToGtSomeValue() {
        return 1 / 0;
    }
}
