package com.kenzie.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionTest {
// TODO: Uncomment these tests ONLY after you have created the custom exceptions InvalidWeekException and InvalidDayOfWeekException

   @Test
   public void testInvalidWeekException(){
       String message = "You need to enter a number between 1 and 10 for the week!";
       IllegalArgumentException illegalException = new IllegalArgumentException();
       assertThrows(InvalidWeekException.class, () -> {
           throw new InvalidWeekException("You need to enter a number between 1 and 10 for the week!", new IllegalArgumentException());
       });
       InvalidDayOfWeekException invalidDayOfWeekException = new InvalidDayOfWeekException(message, illegalException);
       assertEquals(message, invalidDayOfWeekException.getMessage());
   }

   @Test
   public void testInvalidDayOfWeekException(){
       String message = "You need to enter a number between 1 and 7 for the day!";
       IllegalArgumentException illegalException = new IllegalArgumentException();
       assertThrows(InvalidDayOfWeekException.class, () -> {
           throw new InvalidDayOfWeekException(message, illegalException);
       });
       InvalidDayOfWeekException invalidDayOfWeekException = new InvalidDayOfWeekException(message, illegalException);
       assertEquals(message, invalidDayOfWeekException.getMessage());
   }
}
