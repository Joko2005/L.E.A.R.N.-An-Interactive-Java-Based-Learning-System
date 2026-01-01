/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commons;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class GradientButton extends JButton {

    /* =======================
       EDITABLE PROPERTIES
       ======================= */
    private Color color1 = Color.decode("#0099F7");
    private Color color2 = Color.decode("#F11712");

    private Color hoverColor1 = Color.decode("#F7971E");
    private Color hoverColor2 = Color.decode("#FFD200");

    private float sizeSpeed = 1f;

    /* =======================
       INTERNAL STATE
       ======================= */
    private float alpha = 0.3f;
    private boolean mouseOver;
    private boolean pressed;
    private Point pressedLocation;
    private float pressedSize;
    private float alphaPressed = 0.5f;

    private final Timer timer;
    private final Timer timerPressed;

    /* =======================
       CONSTRUCTOR
       ======================= */
    public GradientButton() {
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBorder(new EmptyBorder(10, 20, 10, 20));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseOver = true;
                timer.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseOver = false;
                timer.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                pressedSize = 0;
                alphaPressed = 0.5f;
                pressed = true;
                pressedLocation = e.getPoint();
                timerPressed.setDelay(0);
                timerPressed.start();
            }
        });

        // Hover animation timer
        timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mouseOver) {
                    if (alpha < 0.6f) {
                        alpha += 0.05f;
                    } else {
                        alpha = 0.6f;
                        timer.stop();
                    }
                } else {
                    if (alpha > 0.3f) {
                        alpha -= 0.05f;
                    } else {
                        alpha = 0.3f;
                        timer.stop();
                    }
                }
                repaint();
            }
        });

        // Press ripple timer
        timerPressed = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedSize += sizeSpeed;
                if (alphaPressed <= 0) {
                    pressed = false;
                    timerPressed.stop();
                } else {
                    repaint();
                }
            }
        });
    }

    /* =======================
       PAINTING
       ======================= */
    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Base gradient
        GradientPaint base = new GradientPaint(0, 0, color1, width, 0, color2);
        g2.setPaint(base);
        g2.fillRoundRect(0, 0, width, height, height, height);

        // Hover gradient blend
        if (alpha > 0.3f) {
            g2.setComposite(AlphaComposite.getInstance(
                    AlphaComposite.SRC_ATOP, alpha - 0.3f));
            GradientPaint hover = new GradientPaint(
                    0, 0, hoverColor1, width, 0, hoverColor2);
            g2.setPaint(hover);
            g2.fillRoundRect(0, 0, width, height, height, height);
        }

        // Press ripple
        if (pressed) {
            paintPressed(g2);
        }

        g2.dispose();
        g.drawImage(img, 0, 0, null);
        super.paintComponent(g);
    }

    private void paintPressed(Graphics2D g2) {
        if (pressedLocation == null) return;

        if (pressedLocation.x - (pressedSize / 2) < 0
                && pressedLocation.x + (pressedSize / 2) > getWidth()) {
            timerPressed.setDelay(20);
            alphaPressed -= 0.05f;
            if (alphaPressed < 0) {
                alphaPressed = 0;
            }
        }

        g2.setColor(Color.WHITE);
        g2.setComposite(
                AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alphaPressed));

        float x = pressedLocation.x - (pressedSize / 2);
        float y = pressedLocation.y - (pressedSize / 2);
        g2.fillOval((int) x, (int) y, (int) pressedSize, (int) pressedSize);
    }

    /* =======================
       GETTERS & SETTERS
       ======================= */
    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public Color getHoverColor1() {
        return hoverColor1;
    }

    public void setHoverColor1(Color hoverColor1) {
        this.hoverColor1 = hoverColor1;
    }

    public Color getHoverColor2() {
        return hoverColor2;
    }

    public void setHoverColor2(Color hoverColor2) {
        this.hoverColor2 = hoverColor2;
    }

    public float getSizeSpeed() {
        return sizeSpeed;
    }

    public void setSizeSpeed(float sizeSpeed) {
        this.sizeSpeed = sizeSpeed;
    }
}


