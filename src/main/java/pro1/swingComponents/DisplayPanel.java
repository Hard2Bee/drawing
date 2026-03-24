package pro1.swingComponents;

import pro1.drawingModel.Cross;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DisplayPanel extends JPanel {
    private final List<Cross> crosses = new ArrayList<>(); // Paměť pro křížky
    private final OptionsPanel optionsPanel;

    public DisplayPanel(OptionsPanel optionsPanel) {
        this.optionsPanel = optionsPanel;
        this.setBackground(Color.WHITE); // Bílé pozadí
    }

    public void addCross(Cross cross) {
        this.crosses.add(cross);
        this.repaint();
    }

    public void clear() {
        this.crosses.clear();
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int currentSize = optionsPanel.getCrossSize(); // Společná velikost ze slideru
        for (Cross c : crosses) {
            c.draw(g2d, currentSize);
        }
    }
}