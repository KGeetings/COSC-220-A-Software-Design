/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author geeti
 */
public class DayTest {

    private Day testday;
    
    public DayTest() {
    }
    
    @BeforeEach
    public void setUp() {
        testday = new Day(1);
    }
    
    @AfterEach
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
        System.out.println("makeAppointment");
        int time = 9;
        Appointment appointment = new Appointment("Class", 1);
        boolean expResult = true;
        boolean result = testday.makeAppointment(time, appointment);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testInvalidTimeMakeAppointment() {
        System.out.println("makeAppointment");
        int time = 2;
        Appointment appointment = new Appointment("Class", 1);
        boolean expResult = false;
        boolean result = testday.makeAppointment(time, appointment);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
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
        //fail("The test case is a prototype.");
    }

    @Test
    public void testMultipleHourMakeAppointment() {
        System.out.println("makeAppointment");
        int time = 9;
        Appointment appointment = new Appointment("Class", 2);
        boolean expResult = true;
        boolean result = testday.makeAppointment(time, appointment);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
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
        //fail("The test case is a prototype.");
    }

    /* @Test
    public void testGetAppointment() {
        System.out.println("getAppointment");
        int time = 0;
        Day instance = null;
        Appointment expResult = null;
        Appointment result = instance.getAppointment(time);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testShowAppointments() {
        System.out.println("showAppointments");
        Day instance = null;
        instance.showAppointments();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDayNumber() {
        System.out.println("getDayNumber");
        Day instance = null;
        int expResult = 0;
        int result = instance.getDayNumber();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidTime() {
        System.out.println("validTime");
        int time = 0;
        Day instance = null;
        boolean expResult = false;
        boolean result = instance.validTime(time);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    } */
    
}
