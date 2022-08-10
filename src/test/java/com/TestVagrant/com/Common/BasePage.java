package com.TestVagrant.com.Common;

import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.WebDriver;
import java.util.logging.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;
import java.util.logging.Logger;

public class BasePage {
    public static WebDriver driver;
    public static String browser = System.setProperty("webdriver.chrome.driver","C:\\Automation Learning\\drivers\\chromedriver.exe");
    //    public static final Logger logger = (Logger) LoggerFactory.getLogger(BasePage.class);
    public static final ThreadLocal<Number> threadLocalRandomNumber = new ThreadLocal<>();

    public BasePage() {

    }

    public static int getRandomNumber() {;
        return (Integer)((Number)threadLocalRandomNumber.get());
    }

    public static void setRandomNumber(int min, int max) {
        int number = (int)(Math.random() * (double)(min - max + 1)) + min;
        threadLocalRandomNumber.set(number);
    }

    public static WebDriverWait wait(int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds((long)timeout));
        return wait;
    }
}
