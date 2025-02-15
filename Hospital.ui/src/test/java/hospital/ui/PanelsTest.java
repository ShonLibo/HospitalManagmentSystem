package hospital.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PanelsTest {

    @Test
    public void testcaseHomePanel() {
        JPanel panel = Panels.createHomePanel();
        assertNotNull(panel);
        Assertions.assertEquals(Color.LIGHT_GRAY, panel.getBackground());
        assertTrue(panel.getComponent(0) instanceof JLabel);
    }

    @Test
    public void testcreatePatientPanel() {
        JPanel panel = Panels.createPatientPanel();
        assertNotNull(panel);
        assertTrue(panel.getComponentCount() > 0);
    }

    @Test
   public void testcreateDoctorPanel() {
        JPanel panel = Panels.createDoctorPanel();
        assertNotNull(panel);
        assertTrue(panel.getComponentCount() > 0);
    }

    @Test
   public void testcreateAppointmentPanel() {
        JPanel panel = Panels.createAppointmentPanel();
        assertNotNull(panel);
        assertTrue(panel.getComponentCount() > 0);
    }

    @Test
    public void testcreateViewPanel() {
        JPanel panel = Panels.createViewPanel();
        assertNotNull(panel);
        assertTrue(panel.getComponentCount() > 0);
    }
}