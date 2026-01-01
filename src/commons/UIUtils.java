/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commons;

import javax.swing.*;
import java.awt.*;

public class UIUtils {

    private UIUtils() {
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
}

