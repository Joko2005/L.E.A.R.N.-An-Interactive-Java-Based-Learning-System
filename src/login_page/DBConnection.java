/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login_page;

import dashboard.roles.UserRoles;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sirpa
 */
public class DBConnection {
    
    public List<User> Users;
            
    public DBConnection()
    {
        Users = List.of
        (
            new User("Admin", "Admin1234", UserRoles.ADMIN),
            new User("User", "User1234", UserRoles.USER)
        );
    }
    
    
}
