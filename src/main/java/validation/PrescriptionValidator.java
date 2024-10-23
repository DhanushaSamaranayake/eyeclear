package validation;

import entity.Prescription;

public class PrescriptionValidator {

    public boolean validatePrescription(Prescription prescription) {
        if (prescription.getFirstName().length() < 4 || prescription.getFirstName().length() > 15 ||
                prescription.getLastName().length() < 4 || prescription.getLastName().length() > 15) {
            return false;
        }

        if (prescription.getAddress().length() < 20) {
            return false;
        }

        if (prescription.getSphere() < -20.00 || prescription.getSphere() > 20.00) {
            return false;
        }

        if (prescription.getOptometrist().length() < 8 || prescription.getOptometrist().length() > 25) {
            return false;
        }

        return true;
    }

    public boolean validateRemark(String remark, String remarkType) {
        String[] words = remark.split(" ");
        if (words.length < 6 || words.length > 20 || !Character.isUpperCase(remark.charAt(0))) {
            return false;
        }

        if (!remarkType.equalsIgnoreCase("Client") && !remarkType.equalsIgnoreCase("Optometrist")) {
            return false;
        }

        return true;
    }
}