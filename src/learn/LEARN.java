/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package learn;

import dashboard.UI.DashboardUI;
import dashboard.roles.UserRoles;

/**
 *
 * @author Joko
 */
public class LEARN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      DashboardUI dashboard = new DashboardUI(UserRoles.ADMIN);
      dashboard.setVisible(true);
    }
    
}
