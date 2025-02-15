package hospital.ui;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;

class MenuPanelTest {

    @org.junit.jupiter.api.Test
    void createMenuPanel() {
        UIComponents mockApp = new UIComponents() {};
        JPanel menuPanel = MenuPanel.createMenuPanel(mockApp);
        assertNotNull(menuPanel);
        assertEquals(new Color(59, 25, 25), menuPanel.getBackground());
        assertTrue(menuPanel.getComponent(0) instanceof JMenuBar);
    }
}