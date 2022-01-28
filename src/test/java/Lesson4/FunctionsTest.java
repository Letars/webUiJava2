package Lesson4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class FunctionsTest {
 private static org.junit.platform.commons.logging.Logger Logger = LoggerFactory.getLogger(FunctionsTest.class);

    @BeforeEach
    static void Logging() {
        Logger.error("Log error");
        Logger.info("Info");
    }


    @BeforeEach
    void beforeEach() {
        System.out.println("Я так и не смогла сделать тесты :(. Я и джава слишком далеки от понимания друг друга");
    }


}
