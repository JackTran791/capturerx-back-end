package com.capturerx.utils;

import org.springframework.stereotype.Component;

@Component
public class sleepTime {

    public long generateRandomSleepTime(int max, int min) {
        return (long) (Math.random() * (max - min + 1) + min);
    }
}
