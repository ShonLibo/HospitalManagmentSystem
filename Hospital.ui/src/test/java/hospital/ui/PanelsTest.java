package hospital.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;

class PanelsTest {

    @Test
    public void testcaseHomePanel() {
        JPanel panel = Panels.createHomePanel();
        Assertions.assertNotNull(panel);
        Assertions.assertEquals(Color.LIGHT_GRAY, panel.getBackground());
        Assertions.assertTrue(panel.getComponent(0) instanceof JLabel);
    }

    @Test
    void createPatientPanel() {
    }

    @Test
    void createDoctorPanel() {
    }

    @Test
    void createAppointmentPanel() {
    }

    @Test
    void createViewPanel() {
    }
}