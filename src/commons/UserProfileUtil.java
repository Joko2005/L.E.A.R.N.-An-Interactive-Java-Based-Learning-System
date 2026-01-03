/*
 * UserProfileUtil.java
 * Utility class for managing user profile display in the sidebar
 * Handles username, role, profile picture, and welcome message configuration
 */
package commons;

import javax.swing. JLabel;
import javax.swing.ImageIcon;
import java.awt. Font;
import java.awt.Color;
import login_page.User;
import dashboard.roles.UserRoles;

/**
 * Utility class for configuring user profile display components
 * @author Joko
 */
public class UserProfileUtil {
    
    // Font configurations
    private static final Font USERNAME_FONT = new Font("Montserrat", Font.BOLD, 20);
    private static final Font ROLE_FONT = new Font("Montserrat", Font. PLAIN, 15);
    private static final Font TITLE_FONT = new Font("Montserrat", Font.BOLD, 36);
    
    // Color configurations
    private static final Color USERNAME_COLOR = new Color(255, 255, 255);
    private static final Color ROLE_COLOR = new Color(178, 177, 223);
    private static final Color TITLE_COLOR = new Color(255, 255, 255);
    
    /**
     * Sets up the username label with proper styling
     * @param lblUsername The JLabel component for displaying username
     * @param username The username text to display
     */
    public static void setupUsername(JLabel lblUsername, String username) {
        if (lblUsername == null) {
            throw new IllegalArgumentException("Username label cannot be null");
        }
        
        lblUsername.setText(username);
        lblUsername. setFont(USERNAME_FONT);
        lblUsername.setForeground(USERNAME_COLOR);
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    }
    
    /**
     * Sets up the role label with proper styling
     * @param lblRole The JLabel component for displaying user role
     * @param role The role text to display (e.g., "Admin", "User", "Guest")
     */
    public static void setupRole(JLabel lblRole, String role) {
        if (lblRole == null) {
            throw new IllegalArgumentException("Role label cannot be null");
        }
        
        lblRole.setText(role);
        lblRole.setFont(ROLE_FONT);
        lblRole.setForeground(ROLE_COLOR);
        lblRole.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    }
    
    /**
     * Sets up the welcome title with username
     * @param lblTitle The JLabel component for displaying welcome message
     * @param username The username to include in the welcome message
     */
    public static void setupTitle(JLabel lblTitle, String username) {
        if (lblTitle == null) {
            throw new IllegalArgumentException("Title label cannot be null");
        }
        
        String welcomeMessage = "Welcome " + username + "!";
        lblTitle. setText(welcomeMessage);
        lblTitle.setFont(TITLE_FONT);
        lblTitle.setForeground(TITLE_COLOR);
    }
    
    /**
     * Sets up the welcome title with custom message
     * @param lblTitle The JLabel component for displaying welcome message
     * @param message Custom welcome message
     */
    public static void setupTitleCustom(JLabel lblTitle, String message) {
        if (lblTitle == null) {
            throw new IllegalArgumentException("Title label cannot be null");
        }
        
        lblTitle.setText(message);
        lblTitle.setFont(TITLE_FONT);
        lblTitle.setForeground(TITLE_COLOR);
    }
    
    /**
     * Sets up the complete user profile display (username and role)
     * @param lblUsername The JLabel component for displaying username
     * @param lblRole The JLabel component for displaying user role
     * @param username The username text to display
     * @param role The role text to display
     */
    public static void setupUserProfile(JLabel lblUsername, JLabel lblRole, String username, String role) {
        setupUsername(lblUsername, username);
        setupRole(lblRole, role);
    }
    
    /**
     * Sets up the profile picture for a user
     * @param profilePicLabel The JLabel component for displaying profile picture
     * @param imagePath The path to the profile image (e.g., "/dashboard/icons/UserProfile.png")
     * @param x X coordinate position
     * @param y Y coordinate position
     * @param width Width of the profile picture
     * @param height Height of the profile picture
     */
    public static void setupProfilePicture(JLabel profilePicLabel, String imagePath, int x, int y, int width, int height) {
        if (profilePicLabel == null) {
            throw new IllegalArgumentException("Profile picture label cannot be null");
        }
        
        try {
            // Load and set the profile picture
            ImageIcon icon = new ImageIcon(UserProfileUtil.class.getResource(imagePath));
            profilePicLabel.setIcon(icon);
            
            // Set position and size using UIPositionUtil
            
            
        } catch (Exception e) {
            System.err.println("Error loading profile picture: " + imagePath);
            e.printStackTrace();
            // Load default profile picture on error
            loadDefaultProfilePicture(profilePicLabel, x, y, width, height);
        }
    }
    
    /**
     * Loads a default profile picture when custom one fails
     */
    private static void loadDefaultProfilePicture(JLabel profilePicLabel, int x, int y, int width, int height) {
        try {
            String defaultPath = "/dashboard/icons/UserProfile.png";
            ImageIcon icon = new ImageIcon(UserProfileUtil.class.getResource(defaultPath));
            profilePicLabel.setIcon(icon);
            UIPositionUtil.setupCard(profilePicLabel, defaultPath, x, y, width, height);
        } catch (Exception ex) {
            System.err. println("Error loading default profile picture");
        }
    }
    
    /**
     * Sets up the complete user profile including picture, username, role, and title
     * @param profilePicLabel The JLabel for profile picture
     * @param lblUsername The JLabel for username
     * @param lblRole The JLabel for role
     * @param lblTitle The JLabel for welcome title
     * @param username The username text
     * @param role The role text
     * @param imagePath Path to profile image
     * @param picX Profile picture X position
     * @param picY Profile picture Y position
     * @param picWidth Profile picture width
     * @param picHeight Profile picture height
     */
    public static void setupCompleteProfile(
            JLabel profilePicLabel, 
            JLabel lblUsername, 
            JLabel lblRole,
            JLabel lblTitle,
            String username, 
            String role, 
            String imagePath,
            int picX, 
            int picY, 
            int picWidth, 
            int picHeight) {
        
        setupProfilePicture(profilePicLabel, imagePath, picX, picY, picWidth, picHeight);
        setupUserProfile(lblUsername, lblRole, username, role);
        setupTitle(lblTitle, username);
    }
    
    /**
     * Sets up the complete user profile using User object
     * UPDATED: Now uses individual user profile pictures
     * @param profilePicLabel The JLabel for profile picture
     * @param lblUsername The JLabel for username
     * @param lblRole The JLabel for role
     * @param lblTitle The JLabel for welcome title
     * @param user The User object containing username, role, and profile picture
     */
    public static void setupCompleteProfileFromUser(
            JLabel profilePicLabel,
            JLabel lblUsername,
            JLabel lblRole,
            JLabel lblTitle,
            User user) {
        
        if (user == null) {
            throw new IllegalArgumentException("User object cannot be null");
        }
        
        String username = user.getName();
        UserRoles userRole = user.getRole();
        String roleText = getRoleDisplayText(userRole);
        
        // UPDATED: Get profile picture from user object instead of role
        String imagePath = user.getProfilePicturePath();
        
        // Get dimensions based on role (you can also make this user-specific if needed)
        int x, y, width, height;
        switch (userRole) {
            case ADMIN:
                x = ProfileDimensions.ADMIN_X;
                y = ProfileDimensions.ADMIN_Y;
                width = ProfileDimensions. ADMIN_WIDTH;
                height = ProfileDimensions.ADMIN_HEIGHT;
                break;
            case USER:
                x = ProfileDimensions.USER_X;
                y = ProfileDimensions.USER_Y;
                width = ProfileDimensions.USER_WIDTH;
                height = ProfileDimensions.USER_HEIGHT;
                break;
            default:
                x = ProfileDimensions. GUEST_X;
                y = ProfileDimensions.GUEST_Y;
                width = ProfileDimensions.GUEST_WIDTH;
                height = ProfileDimensions.GUEST_HEIGHT;
                break;
        }
        
        setupCompleteProfile(profilePicLabel, lblUsername, lblRole, lblTitle, 
                           username, roleText, imagePath, x, y, width, height);
    }
    
    /**
     * Sets up user profile with custom dimensions
     * Useful when different users need different profile picture sizes
     * @param profilePicLabel The JLabel for profile picture
     * @param lblUsername The JLabel for username
     * @param lblRole The JLabel for role
     * @param lblTitle The JLabel for welcome title
     * @param user The User object
     * @param x Custom X position
     * @param y Custom Y position
     * @param width Custom width
     * @param height Custom height
     */
    public static void setupCompleteProfileFromUser(
            JLabel profilePicLabel,
            JLabel lblUsername,
            JLabel lblRole,
            JLabel lblTitle,
            User user,
            int x,
            int y,
            int width,
            int height) {
        
        if (user == null) {
            throw new IllegalArgumentException("User object cannot be null");
        }
        
        String username = user.getName();
        UserRoles userRole = user.getRole();
        String roleText = getRoleDisplayText(userRole);
        String imagePath = user.getProfilePicturePath();
        
        setupProfilePicture(profilePicLabel, imagePath, 0, 0, 0, 0); // x,y,width,height not used
        setupUsername(lblUsername, username);
        setupRole(lblRole, roleText);
        setupTitle(lblTitle, username);
    }
    
    /**
     * Gets display text for user role
     * @param role The UserRoles enum
     * @return Display text for the role
     */
    private static String getRoleDisplayText(UserRoles role) {
        switch (role) {
            case ADMIN:
                return "Admin";
            case USER:
                return "User";
            default:
                return "Guest";
        }
    }
    
    /**
     * Predefined profile picture paths for different user roles
     * These are fallback defaults
     */
    public static class ProfilePaths {
        public static final String ADMIN_PROFILE = "/dashboard/icons/AdminUserProfile.png";
        public static final String USER_PROFILE = "/dashboard/icons/UserProfile. png";
        public static final String GUEST_PROFILE = "/dashboard/icons/GuestProfile.png";
        
        /**
         * Get profile picture path based on role string
         * @param role The user role (ADMIN, USER, GUEST)
         * @return The corresponding profile picture path
         */
        public static String getProfilePath(String role) {
            if (role == null) {
                return GUEST_PROFILE;
            }
            
            switch (role. toUpperCase()) {
                case "ADMIN":
                    return ADMIN_PROFILE;
                case "USER":
                    return USER_PROFILE;
                case "GUEST":
                default:
                    return GUEST_PROFILE;
            }
        }
        
        /**
         * Get profile picture path based on UserRoles enum
         * @param role The UserRoles enum
         * @return The corresponding profile picture path
         */
        public static String getProfilePath(UserRoles role) {
            if (role == null) {
                return GUEST_PROFILE;
            }
            
            switch (role) {
                case ADMIN:
                    return ADMIN_PROFILE;
                case USER:
                    return USER_PROFILE;
                default:
                    return GUEST_PROFILE;
            }
        }
    }
    
    /**
     * Predefined profile picture dimensions for different user roles
     */
    public static class ProfileDimensions {
        // Admin profile dimensions
        public static final int ADMIN_X = 86;
        public static final int ADMIN_Y = 50;
        public static final int ADMIN_WIDTH = 106;
        public static final int ADMIN_HEIGHT = 91;
        
        // User profile dimensions
        public static final int USER_X = 86;
        public static final int USER_Y = 50;
        public static final int USER_WIDTH = 91;
        public static final int USER_HEIGHT = 91;
        
        // Guest profile dimensions
        public static final int GUEST_X = 86;
        public static final int GUEST_Y = 50;
        public static final int GUEST_WIDTH = 91;
        public static final int GUEST_HEIGHT = 91;
    }
    
    /**
     * Setup profile picture with role-based defaults using UserRoles enum
     * @param profilePicLabel The JLabel for profile picture
     * @param role The UserRoles enum
     */
    public static void setupProfilePictureByRole(JLabel profilePicLabel, UserRoles role) {
        String imagePath = ProfilePaths.getProfilePath(role);
        int x, y, width, height;
        
        switch (role) {
            case ADMIN:
                x = ProfileDimensions.ADMIN_X;
                y = ProfileDimensions.ADMIN_Y;
                width = ProfileDimensions.ADMIN_WIDTH;
                height = ProfileDimensions. ADMIN_HEIGHT;
                break;
            case USER:
                x = ProfileDimensions.USER_X;
                y = ProfileDimensions.USER_Y;
                width = ProfileDimensions.USER_WIDTH;
                height = ProfileDimensions.USER_HEIGHT;
                break;
            default:
                x = ProfileDimensions.GUEST_X;
                y = ProfileDimensions.GUEST_Y;
                width = ProfileDimensions. GUEST_WIDTH;
                height = ProfileDimensions.GUEST_HEIGHT;
                break;
        }
        
        setupProfilePicture(profilePicLabel, imagePath, x, y, width, height);
    }
    
    /**
     * Custom font configuration for username
     */
    public static void setUsernameFont(JLabel lblUsername, String fontName, int style, int size) {
        if (lblUsername != null) {
            lblUsername. setFont(new Font(fontName, style, size));
        }
    }
    
    /**
     * Custom font configuration for role
     */
    public static void setRoleFont(JLabel lblRole, String fontName, int style, int size) {
        if (lblRole != null) {
            lblRole.setFont(new Font(fontName, style, size));
        }
    }
    
    /**
     * Custom font configuration for title
     */
    public static void setTitleFont(JLabel lblTitle, String fontName, int style, int size) {
        if (lblTitle != null) {
            lblTitle.setFont(new Font(fontName, style, size));
        }
    }
    
    /**
     * Custom color configuration for username
     */
    public static void setUsernameColor(JLabel lblUsername, Color color) {
        if (lblUsername != null) {
            lblUsername.setForeground(color);
        }
    }
    
    /**
     * Custom color configuration for role
     */
    public static void setRoleColor(JLabel lblRole, Color color) {
        if (lblRole != null) {
            lblRole. setForeground(color);
        }
    }
    
    /**
     * Custom color configuration for title
     */
    public static void setTitleColor(JLabel lblTitle, Color color) {
        if (lblTitle != null) {
            lblTitle.setForeground(color);
        }
    }
}