package pro1.swingComponents;

import pro1.drawingModel.Cross;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    private final DisplayPanel displayPanel;
    private final OptionsPanel optionsPanel;

    public MainFrame() {
        this.setTitle("PRO1 Drawing - i2500446");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());

        this.optionsPanel = new OptionsPanel(this);
        this.displayPanel = new DisplayPanel(optionsPanel);

        this.add(this.optionsPanel, BorderLayout.WEST);
        this.add(this.displayPanel, BorderLayout.CENTER);

        this.displayPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                createCrossAt(e.getX(), e.getY());
            }
        });
        this.setVisible(true);
    }

    private void createCrossAt(int x, int y) {
        Color color;
        if (optionsPanel.isColorEnabled()) {
            float ratio = (float) (x + y) / (displayPanel.getWidth() + displayPanel.getHeight());
            int r = Math.max(0, Math.min(255, (int)(255 * (1 - ratio))));
            int g = Math.max(0, Math.min(255, (int)(255 * ratio)));
            color = new Color(r, g, 0);
        } else {
            color = Color.GRAY;
        }
        displayPanel.addCross(new Cross(x, y, color));
    }

    public void resetDrawing() {
        displayPanel.clear();
    }
}