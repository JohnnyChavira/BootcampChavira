package org.example;

import java.io.*;
import java.time.format.DateTimeFormatter;

public class SandwichOrderFileManager {
    public static void writeOrderToFile(Order order) {
        //This will create a 'receipts' file
        File directory = new File("receipts");
        if (!directory.exists()) {
            directory.mkdirs();//creates folder if not there
        }

        //Creates file name with timestamp
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String timeStamp = order.getCreationDateTime().format(formatter);
        String fileName = "receipts/Order_" + timeStamp + ".txt";

        //Writes summary of order to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(order.toString());
            System.out.println("Order saved to file: " + fileName);
        } catch (IOException ex) {
            //Takes care of an error
            System.out.println("Error writing order to file: " + ex.getMessage());

        }
    }
}
