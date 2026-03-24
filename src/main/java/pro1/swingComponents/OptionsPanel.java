package pro1.swingComponents;

import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel {
    private final JCheckBox colorEnabled;
    private final JSlider sizeSlider;

    public OptionsPanel(MainFrame mainFrame) {
        // Šířka panelu musí být mezi 150 a 450 px
        this.setPreferredSize(new Dimension(250, 0));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Checkbox pro zapnutí/vypnutí barev
        colorEnabled = new JCheckBox("Barevné křížky", true);
        this.add(colorEnabled);

        // Slider pro společnou velikost všech křížků
        this.add(new JLabel("Velikost křížků:"));
        sizeSlider = new JSlider(10, 100, 30);
        this.add(sizeSlider);

        // Tlačítko reset pro vymazání plochy
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(_ -> mainFrame.resetDrawing());
        this.add(resetButton);

        // Překreslení při pohybu sliderem
        sizeSlider.addChangeListener(_ -> mainFrame.repaint());
    }

    public boolean isColorEnabled() { return colorEnabled.isSelected(); }
    public int getCrossSize() { return sizeSlider.getValue(); }
}