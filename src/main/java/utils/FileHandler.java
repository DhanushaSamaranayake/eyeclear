package utils;

import entity.Prescription;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileHandler {

    public boolean writePrescriptionToFile(Prescription prescription) {
        try (FileWriter writer = new FileWriter("presc.txt", true)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
            String examDate = dateFormat.format(prescription.getExaminationDate());

            writer.write("Prescription ID: " + prescription.getPrescID() + "\n");
            writer.write("Name: " + prescription.getFirstName() + " " + prescription.getLastName() + "\n");
            writer.write("Address: " + prescription.getAddress() + "\n");
            writer.write("Sphere: " + prescription.getSphere() + "\n");
            writer.write("Axis: " + prescription.getAxis() + "\n");
            writer.write("Cylinder: " + prescription.getCylinder() + "\n");
            writer.write("Examination Date: " + examDate + "\n");
            writer.write("Optometrist: " + prescription.getOptometrist() + "\n");
            writer.write("------------------------\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean writeRemarkToFile(int prescID, String remark, String remarkType) {
        try (FileWriter writer = new FileWriter("review.txt", true)) {
            writer.write("Prescription ID: " + prescID + "\n");
            writer.write("Remark: " + remark + "\n");
            writer.write("Remark Type: " + remarkType + "\n");
            writer.write("------------------------\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
