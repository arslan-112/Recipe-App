import javax.swing.*;
import java.awt.*;

public class RoundedButton extends JButton {
    private static final long serialVersionUID = 1L;

    private Color borderColor;
    private int width;
    private int height;

    public RoundedButton(String text) {
        super(text);
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setForeground(Color.BLACK);
        setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.borderColor = Color.BLACK; // Default border color
        this.width = 120; // Default width
        this.height = 40; // Default height
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2d.setColor(borderColor); // Custom border color
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        g2d.dispose();
        super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    public void setBorderColor(Color color) {
        this.borderColor = color;
        repaint();
    }

    public void setButtonSize(int width, int height) {
        this.width = width;
        this.height = height;
        revalidate();
        repaint();
    }
}