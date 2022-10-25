/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/* import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; */

/**
 *
 * @author geeti
 */
public class DayTest {

    private Day testday;
    
    public DayTest() {
    }
    
    @Before
    public void setUp() {
        testday = new Day(1);
    }
    
    @After
    public void tearDown() {
    }

    /* @Test
    public void testFindSpace() {
        System.out.println("findSpace");
        Appointment appointment = null;
        Day instance = null;
        int expResult = 0;
        int result = instance.findSpace(appointment);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } */

    @Test
    public void testSuccessfulMakeAppointment() {
        testday = new Day(1);
        System.out.println("makeAppointment");
        int time = 9;
        Appointment appointment = new Appointment("Class", 1);
        boolean expResult = true;
        boolean result = testday.makeAppointment(time, appointment);
        assertEquals(expResult, result);
    }

    @Test
    public void testInvalidTimeMakeAppointment() {
        System.out.println("makeAppointment");
        int time = 2;
        Appointment appointment = new Appointment("Class", 1);
        boolean expResult = false;
        boolean result = testday.makeAppointment(time, appointment);
        assertEquals(expResult, result);
    }

    @Test
    public void testAlreadyBookedMakeAppointment() {
        System.out.println("makeAppointment");
        int time = 9;
        Appointment appointment = new Appointment("Class", 1);
        testday.makeAppointment(time, appointment);
        Appointment appointment2 = new Appointment("Class", 1);
        boolean expResult = false;
        boolean result = testday.makeAppointment(time, appointment2);
        assertEquals(expResult, result);
    }

    @Test
    public void testMultipleHourMakeAppointment() {
        System.out.println("makeAppointment");
        int time = 9;
        Appointment appointment = new Appointment("Class", 2);
        boolean expResult = true;
        boolean result = testday.makeAppointment(time, appointment);
        assertEquals(expResult, result);
    }

    @Test
    public void testMultipleHourFailMakeAppointment() {
        System.out.println("makeAppointment");
        int time = 9;
        Appointment appointment = new Appointment("Class", 2);
        testday.makeAppointment(time, appointment);
        Appointment appointment2 = new Appointment("Class", 1);
        boolean expResult = false;
        boolean result = testday.makeAppointment(time, appointment2);
        assertEquals(expResult, result);
    }

    @Test
    //Successfully find an open 2 hour block for findSpace(), where some appointments are already made
    public void testFindSpace() {
        System.out.println("findSpace");
        Appointment appointment = new Appointment("Class", 2);
        testday.makeAppointment(9, new Appointment("Class", 1));
        testday.makeAppointment(11, new Appointment("Class", 1));
        testday.makeAppointment(14, new Appointment("Class", 1));
        int expResult = 12;
        int result = testday.findSpace(appointment);
        assertEquals(expResult, result);
    }

    @Test
    //Successfully fail to find an open 2 hour block for findSpace(), where some appointments are already made
    public void testFailFindSpace() {
        System.out.println("findSpace");
        Appointment appointment = new Appointment("Class", 2);
        testday.makeAppointment(9, new Appointment("Class", 1));
        testday.makeAppointment(10, new Appointment("Class", 1));
        testday.makeAppointment(11, new Appointment("Class", 1));
        testday.makeAppointment(12, new Appointment("Class", 1));
        testday.makeAppointment(13, new Appointment("Class", 1));
        testday.makeAppointment(14, new Appointment("Class", 1));
        testday.makeAppointment(15, new Appointment("Class", 1));
        testday.makeAppointment(16, new Appointment("Class", 1));
        //testday.makeAppointment(17, new Appointment("Class", 1));
        int expResult = -1;
        int result = testday.findSpace(appointment);
        assertEquals(expResult, result);
    }

}