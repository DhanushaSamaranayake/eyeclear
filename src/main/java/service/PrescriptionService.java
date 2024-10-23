package service;

import entity.Prescription;
import utils.FileHandler;
import validation.PrescriptionValidator;

public class PrescriptionService {

    private FileHandler fileHandler;
    private PrescriptionValidator validator;

    public PrescriptionService() {
        this.fileHandler = new FileHandler();
        this.validator = new PrescriptionValidator();
    }

    public boolean addPrescription(Prescription prescription) {
        if (validator.validatePrescription(prescription)) {
            return fileHandler.writePrescriptionToFile(prescription);
        }
        return false;
    }

    public boolean addRemark(int prescID, String remark, String remarkType) {
        if (validator.validateRemark(remark, remarkType)) {
            return fileHandler.writeRemarkToFile(prescID, remark, remarkType);
        }
        return false;
    }
}
