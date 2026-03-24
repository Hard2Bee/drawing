package pro1.drawingModel;

import java.awt.*;

public class Cross implements Drawable {
    private final int x, y;
    private final Color color;

    public Cross(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    // Povinná metoda z rozhraní Drawable
    @Override
    public void draw(Graphics2D g) {
        // Ponecháme prázdné nebo nevyužité
    }

    // Metoda pro dynamické vykreslování se společnou velikostí
    public void draw(Graphics2D g, int currentSize) {
        g.setColor(color);
        g.setStroke(new BasicStroke(2));
        int halfSize = currentSize / 2;
        g.drawLine(x - halfSize, y - halfSize, x + halfSize, y + halfSize);
        g.drawLine(x + halfSize, y - halfSize, x - halfSize, y + halfSize);
    }
}