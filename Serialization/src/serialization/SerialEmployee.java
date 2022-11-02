package serialization;

import java.io.*;

public class SerialEmployee {
    // create a new employee
    // and write it to a file
    // then read it back in

    public static void main(String[] args) {
        // create a new employee
        Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);

        // save the employee to a file
        try {
            // use a file output stream to write to a file
            FileOutputStream fileOut = new FileOutputStream("/Serialization/employee.dat");
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
            FileInputStream fileIn = new FileInputStream("/Serialization/employee.dat");
            // use an object input stream to read objects from a stream
            ObjectInputStream in = new ObjectInputStream(fileIn);
            // read the object from the stream
            Employee newHarry = (Employee) in.readObject();
            // close the stream
            in.close();
            fileIn.close();
            // print the object
            System.out.println(newHarry);
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }
    }
}