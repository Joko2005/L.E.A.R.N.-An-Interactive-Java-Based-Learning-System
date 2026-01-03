/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login_page;

import dashboard.roles.UserRoles;
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
            // Admin with custom profile
            new User("Admin", "Admin1234", UserRoles.ADMIN, "/dashboard/icons/ProfileBoy.png"),
            
            // Users with individual profiles
            new User("User", "User1234", UserRoles.USER, "/dashboard/icons/ProfileGirl.png"),
            new User("Patrick", "Patrick1234", UserRoles.USER, "/dashboard/icons/ProfilePat.png"),
            new User("Joko", "Joko1234", UserRoles.USER, "/dashboard/icons/ProfileJoko.png"),
            new User("Adie", "Adie1234", UserRoles.USER, "/dashboard/icons/ProfileAddie.png"),
            new User("Yanni", "Yanni1234", UserRoles.USER, "/dashboard/icons/ProfileYanni.png"),
            new User("Nigga", "Nigga1234", UserRoles.USER, "/dashboard/icons/ProfileWincel.png")
            
            // Or use default role-based profiles (just pass 3 parameters):
            // new User("Admin", "Admin1234", UserRoles.ADMIN),
            // new User("User", "User1234", UserRoles.USER),
            // etc.
        );
    }
}
