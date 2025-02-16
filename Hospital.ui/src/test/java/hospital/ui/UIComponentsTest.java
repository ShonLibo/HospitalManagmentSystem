package hospital.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;
import java.awt.*;

class UIComponentsTest {
    private UIComponents uiComponents;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    @BeforeEach
    void setUp() {
        uiComponents = new UIComponents();
        cardLayout = (CardLayout) getPrivateField(uiComponents, "cardLayout");
        cardPanel = (JPanel) getPrivateField(uiComponents, "cardPanel");
    }

    @Test
    void testSwitchPanel() {
        uiComponents.switchPanel("Patient");
        assertEquals("Patient", getCurrentCardName(cardPanel, cardLayout));
    }
    private Object getPrivateField(Object obj, String fieldName) {
        try {
            var field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
}
    private String getCurrentCardName(JPanel panel, CardLayout layout) {
        for (Component comp : panel.getComponents()) {
            if (comp.isVisible()) {
                return panel.getComponentZOrder(comp) == 1 ? "Patient" : "Home";
            }
        }
        return "";
    }
}