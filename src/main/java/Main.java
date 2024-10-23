import entity.Prescription;
import service.PrescriptionService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        PrescriptionService prescriptionService = new PrescriptionService();

        try {
            // sample data
            int prescID = 1;
            String firstName = "Dhanusha";
            String lastName = "Perera";
            String address = "123 Main Street, Melbourne";
            float sphere = -3.25f;
            float axis = 90;
            float cylinder = -1.25f;
            String dateStr = "21/10/2024";
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date examDate = dateFormat.parse(dateStr);
            String optometrist = "Dr. Perera";

            Prescription prescription = new Prescription(prescID, firstName, lastName, address, sphere, axis, cylinder, examDate, optometrist);

            // Add prescription data to the file
            if (prescriptionService.addPrescription(prescription)) {
                System.out.println("Prescription successfully added!");
            } else {
                System.out.println("Failed to add prescription. Invalid data.");
            }

            // sample date remarks
            int remarkPrescID = 1;
            String remark = "Great service and helpful consultation, Highly satisfied!";
            String remarkType = "Client";

            // Add the remark to the file
            if (prescriptionService.addRemark(remarkPrescID, remark, remarkType)) {
                System.out.println("Remark successfully added!");
            } else {
                System.out.println("Failed to add remark. Invalid data.");
            }

        } catch (ParseException e) {
            System.out.println("Invalid date format.");
        }
    }
}