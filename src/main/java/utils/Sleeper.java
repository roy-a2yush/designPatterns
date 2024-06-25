package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sleeper {
    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
