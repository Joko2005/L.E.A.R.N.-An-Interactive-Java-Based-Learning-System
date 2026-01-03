/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login_page;

import dashboard.roles.UserRoles;

public class User {
    public String name;
    public String password;
    public UserRoles role;
    public String profilePicturePath;  // NEW: Individual profile picture path
    
    // Constructor with profile picture
    public User(String name, String password, UserRoles role, String profilePicturePath) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.profilePicturePath = profilePicturePath;
    }
    
    // Constructor without profile picture (uses default based on role)
    public User(String name, String password, UserRoles role) {
        this.name = name;
        this. password = password;
        this. role = role;
        this.profilePicturePath = getDefaultProfilePicture(role);
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public String getUsername() {
        return name;
    }
    
    public String getPassword() {
        return password;
    }
    
    public UserRoles getRole() {
        return role;
    }
    
    public String getProfilePicturePath() {
        return profilePicturePath;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setRole(UserRoles role) {
        this.role = role;
    }
    
    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }
    
    // Helper method to get default profile picture based on role
    private String getDefaultProfilePicture(UserRoles role) {
        switch (role) {
            case ADMIN:
                return "/dashboard/icons/ProfileBoy.png";
            case USER:
                return "/dashboard/icons/ProfileGirl.png";
            default:
                return "/dashboard/icons/ProfileBoy.png";
        }
    }
}
