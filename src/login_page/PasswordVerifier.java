/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login_page;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author sirpa
 */
public class PasswordVerifier extends InputVerifier {

    @Override
    public boolean shouldYieldFocus(JComponent input)
    {
        return true;
    }
    
    @Override
    public boolean verify(JComponent input) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
        
        String password = ((JTextField) input).getText();
        
         return   password.matches(regex);
    }

}
