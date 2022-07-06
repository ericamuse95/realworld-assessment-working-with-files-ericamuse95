package com.kenzie.app;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    public void testReadCSVFromFile() throws IOException {
        String filename = "austin_weather_test.csv";
        String fileContents = Main.readCSVLines(filename);
        String expectedFileContents;
        if (System.getProperty("os.name").contains("Windows")) {
            expectedFileContents = "Date,DayOfWeek,TempHighF,TempAvgF,TempLowF\r\n"
                    + "2013-12-22,Sunday,56,48,39\r\n"
                    + "2013-12-23,Monday,58,45,32\r\n"
                    + "2013-12-24,Tuesday,61,46,31\r\n"
                    + "2013-12-25,Wednesday,58,50,41\r\n"
                    + "2013-12-26,Thursday,57,48,39\r\n"
                    + "2013-12-27,Friday,60,53,45\r\n"
                    + "2013-12-28,Saturday,62,51,40";
        } else {
            expectedFileContents = "Date,DayOfWeek,TempHighF,TempAvgF,TempLowF\n"
                    + "2013-12-22,Sunday,56,48,39\n"
                    + "2013-12-23,Monday,58,45,32\n"
                    + "2013-12-24,Tuesday,61,46,31\n"
                    + "2013-12-25,Wednesday,58,50,41\n"
                    + "2013-12-26,Thursday,57,48,39\n"
                    + "2013-12-27,Friday,60,53,45\n"
                    + "2013-12-28,Saturday,62,51,40";
        }
        assertEquals(expectedFileContents, fileContents);
    }

    @Test
    public void testCreateMultidimensionalArray() {
        int numRows = 1;
        int numColumns = 7;
        String fileContents;

        if (System.getProperty("os.name").contains("Windows")) {
            fileContents = "Date,DayOfWeek,TempHighF,TempAvgF,TempLowF\r\n"
                    + "2013-12-22,Sunday,56,48,39\r\n"
                    + "2013-12-23,Monday,58,45,32\r\n"
                    + "2013-12-24,Tuesday,61,46,31\r\n"
                    + "2013-12-25,Wednesday,58,50,41\r\n"
                    + "2013-12-26,Thursday,57,48,39\r\n"
                    + "2013-12-27,Friday,60,53,45\r\n"
                    + "2013-12-28,Saturday,62,51,40";
        } else {
            fileContents = "Date,DayOfWeek,TempHighF,TempAvgF,TempLowF\n" +
                    "2013-12-22,Sunday,56,48,39\n" +
                    "2013-12-23,Monday,58,45,32\n" +
                    "2013-12-24,Tuesday,61,46,31\n" +
                    "2013-12-25,Wednesday,58,50,41\n" +
                    "2013-12-26,Thursday,57,48,39\n" +
                    "2013-12-27,Friday,60,53,45\n" +
                    "2013-12-28,Saturday,62,51,40";
        }
        String[][] contentArray = Main.saveToMultidimensionalArray(fileContents, numRows, numColumns);
        String[] expectedArray = Main.removeCSVHeader(fileContents.split("\n"));
        for (int i = 0; i < 7; i++) {
            assertEquals(expectedArray[i], contentArray[0][i]);
        }
    }
}
