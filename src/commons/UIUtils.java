/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commons;

import javax.swing.*;
import java.awt.*;

public class UIUtils {

    public UIUtils() {
        // Prevent instantiation
    }

    /**
     * Show a message dialog
     */
    public static void showMessage(Component parent, String msg, String title, int icon) {
        JOptionPane optionPane = new JOptionPane(
                msg,
                icon
        );

        JDialog dialog = optionPane.createDialog(parent, title);
        dialog.setModal(true);
        dialog.setVisible(true);
    }

    /**
     * Show confirmation dialog (YES / NO)
     * @return true if YES is selected
     */
    public static boolean confirm(Component parent, String msg, String title) {
        int result = JOptionPane.showConfirmDialog(
                parent,
                msg,
                title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        return result == JOptionPane.YES_OPTION;
    }
    
    public static void minimizeFrame(JFrame frame){
        frame.setState(JFrame.ICONIFIED);
    }
    
    public static void closeFrame(JFrame frame, String msg, String title, int icon){
        int result = JOptionPane.showConfirmDialog(
                null,
                msg,
                title,
                JOptionPane.YES_NO_OPTION,
                icon
        );
        
        if(result == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
    
    public static void goBack(JFrame frame){
        // bumalik sa dashboard
    }
}

