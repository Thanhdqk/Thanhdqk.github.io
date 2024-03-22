
package component;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;


public class CustomShell extends JButton {

    public CustomShell() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(3,3,3,3));
        setFocusPainted(false);
    }
}
