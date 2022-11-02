package serialization;

import java.io.*;
import java.util.Date;

public class SerialEmployee {
    // create a new employee
    // and write it to a file
    // then read it back in

    public static void main(String[] args) {
        // create a new employee
        Employee harry = new Employee("Harry Hacker", 50000, 2001, 6, 22);

        // save the employee to a file
        try {
            // use a file output stream to write to a file
            FileOutputStream fileOut = new FileOutputStream("./Serialization/employee.dat");
            // use an object output stream to write objects to a stream
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            // write the object to the stream
            out.writeObject(harry);
            // close the stream
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }

        // read the employee from a file
        try {
            // use a file input stream to read from a file
            FileInputStream fileIn = new FileInputStream("./Serialization/employee.dat");
            // use an object input stream to read objects from a stream
            ObjectInputStream in = new ObjectInputStream(fileIn);
            // read the object from the stream
            Employee newHarry = (Employee) in.readObject();
            // close the stream
            in.close();
            fileIn.close();
            // print the object
            System.out.println(newHarry);
            // print details of the object
            System.out.println("Employee name: " + newHarry.getName());
            System.out.println("Employee salary: " + newHarry.getSalary());
            System.out.println("Employee hire day: " + newHarry.getHireDay());

            // Calculate how long the employee has been working
            // get the current date
            Date today = new Date();
            // get the hire day
            Date hireDay = newHarry.getHireDay();
            // calculate the difference in milliseconds
            long difference = today.getTime() - hireDay.getTime();
            // convert the difference to years
            long years = difference / 1000 / 60 / 60 / 24 / 365;
            // print the number of years
            System.out.println("Employee has worked for " + years + " years");
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }
    }
}