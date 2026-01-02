/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commons;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public final class NavigationUtil {

    private NavigationUtil() {
        // Prevent instantiation
    }

    
    // Switch frames without flicker.
    // Shows next frame first, then disposes current.
     
    public static void switchFrame(JFrame current, JFrame next) {
        SwingUtilities.invokeLater(() -> {
            next.setVisible(true);
            next.setLocationRelativeTo(current); // optional
            next.setLocation(current.getLocation());
            next.setSize(current.getSize());
            
            current.dispose();
        });
    }

    
     // Show frame without closing current (optional helper)
     
    public static void showFrame(JFrame frame) {
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }

    
     // Close frame safely
     
    public static void closeFrame(JFrame frame) {
        SwingUtilities.invokeLater(frame::dispose);
    }
}
