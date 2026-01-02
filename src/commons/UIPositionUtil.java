/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commons;

/**
 *
 * @author Joko
 */

import java.awt.Image;
import java.awt.Rectangle;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.JLabel;

public class UIPositionUtil {

    // ===============================
    // POSITIONING
    // ===============================
    public static void move(JComponent comp, int x, int y) {
        comp.setBounds(x, y, comp.getWidth(), comp.getHeight());
    }

    public static void setBounds(
            JComponent comp,
            int x,
            int y,
            int width,
            int height
    ) {
        comp.setBounds(x, y, width, height);
    }

    public static void apply(JComponent comp, Rectangle r) {
        comp.setBounds(r);
    }

    public static void showAt(
            JComponent comp,
            int x,
            int y,
            int width,
            int height
    ) {
        comp.setVisible(true);
        comp.setBounds(x, y, width, height);
        
//        // Ensure the component is brought to the front
//        comp.getParent().setComponentZOrder(comp, 0); 

        // Force the component to refresh its internal graphics
        comp.revalidate();
        comp.repaint();
    }

    public static void hide(JComponent comp) {
        comp.setVisible(false);
    }

    // ===============================
    // ICON MANAGEMENT (FOR CARD LABELS)
    // ===============================

    /**
     * Set and auto-scale icon to label size
     * @param label Target JLabel
     * @param resourcePath Path inside resources (e.g. "/dashboard/icons/take_quiz.png")
     */
    public static void setCardIcon(JLabel label, String resourcePath, int width, int height) {
        URL location = UIPositionUtil.class.getResource(resourcePath);

        if (location == null) {
            System.err.println("Image not found: " + resourcePath);
            return;
        }

        ImageIcon icon = new ImageIcon(location);

        // FIX: Use the passed width/height instead of label.getWidth()
        Image scaled = icon.getImage().getScaledInstance(
                width,
                height,
                Image.SCALE_SMOOTH
        );

        label.setIcon(new ImageIcon(scaled));
    }
    
    public static void setupCard(JLabel label, String path, int x, int y, int w, int h) {
        label.setIcon(null);        
        showAt(label, x, y, w, h);        // Set the label's position and size
        setCardIcon(label, path, w, h);   // Scale the image to that exact size
    }

}

