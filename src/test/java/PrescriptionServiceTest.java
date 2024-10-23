import entity.Prescription;
import service.PrescriptionService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PrescriptionServiceTest {

    private PrescriptionService prescriptionService;
    private Prescription prescription;

    @Before
    public void setUp() {
        prescriptionService = new PrescriptionService();

        prescription = new Prescription(1, "Dhanusha", "Perera",
                "123 Main Street, City, 12345, Country",
                -3.25f, 90, -1.25f,
                new java.util.Date(),
                "Dr. Perera");
    }

    // Test cases - Prescription
    @Test
    public void testAddPrescriptionValidData() {
        assertTrue("Prescription should be added successfully",
                prescriptionService.addPrescription(prescription));
    }

    @Test
    public void testAddPrescriptionInvalidFirstName() {
        prescription.setFirstName("Dan"); // Less than 4 characters
        assertFalse("Prescription should not be added due to first name is less than 4 characters",
                prescriptionService.addPrescription(prescription));
    }

    @Test
    public void testAddPrescriptionInvalidLastName() {
        prescription.setLastName("Per"); // Less than 4 characters
        assertFalse("Prescription should not be added due to last name is less than 4 characters",
                prescriptionService.addPrescription(prescription));
    }

    @Test
    public void testAddPrescriptionInvalidAddress() {
        prescription.setAddress("123 Main St"); // Less than 20 characters
        assertFalse("Prescription should not be added due to address is less than 20 characters",
                prescriptionService.addPrescription(prescription));
    }

    @Test
    public void testAddPrescriptionInvalidSphere() {
        prescription.setSphere(-25.0f); // Out of valid range
        assertFalse("Prescription should not be added due to invalid sphere",
                prescriptionService.addPrescription(prescription));
    }

    @Test
    public void testAddPrescriptionInvalidOptometrist() {
        prescription.setOptometrist("Dr."); // Less than 8 characters
        assertFalse("Prescription should not be added due to optometrist name less than 8 characters",
                prescriptionService.addPrescription(prescription));
    }

    // Test cases - Remarks
    @Test
    public void testAddRemarkValidData() {
        assertTrue("Remark should be added successfully",
                prescriptionService.addRemark(1,
                        "Great service and helpful consultation. Highly Recommended!",
                        "Client"));
    }

    @Test
    public void testAddRemarkInsufficientWords() {
        assertFalse("Remark should not be added due to less than 6 words",
                prescriptionService.addRemark(1,
                        "Short", // Less than 6 words
                        "Client"));
    }

    @Test
    public void testAddRemarkExcessiveWords() {
        assertFalse("Remark should not be added due to more than 20 words",
                prescriptionService.addRemark(1,
                        "This remark contains way too too too too too too many words and should fail because it exceeds the limit of twenty words.",
                        "Client")); // More than 20 words
    }

    @Test
    public void testAddRemarkIncorrectFirstCharacterCase() {
        assertFalse("Remark should not be added due to incorrect first character case",
                prescriptionService.addRemark(1,
                        "this remark does not start with an uppercase letter.",
                        "Client"));
    }

    @Test
    public void testAddRemarkInvalidType() {
        assertFalse("Remark should not be added due to invalid type",
                prescriptionService.addRemark(1,
                        "This is a good remark.",
                        "InvalidType")); // Invalid remark type
    }

    @Test
    public void testAddRemarkExceedingRemarkLimit() {
        // First valid remark adding should pass
        prescriptionService.addRemark(1,
                "First remark.",
                "Client");
        // Second valid remark adding should pass
        prescriptionService.addRemark(1,
                "Second remark.",
                "Optometrist");

        // Try to add 3rd remark and it should be failed
        assertFalse("Remark should not be added due to exceeding remark limit",
                prescriptionService.addRemark(1,
                        "Third remark.",
                        "Client"));
    }
}