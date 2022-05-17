package ch.bzz.flugverwaltung.model;

public class User {
    private String userUUID;
    private String userName;
    private String password;
    private String userRole;

    public User(String userUUID, String userName, String password, String userRole) {
        this.userUUID = userUUID;
        this.userName = userName;
        this.password = password;
        this.userRole = userRole;
    }

    /**
     * bekommt userUUID
     * @return wert der Variable userUUID
     */
    public String getUserUUID() {
        return userUUID;
    }

    /**
     * setzt userUUID
     */
    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    /**
     * bekommt userName
     * @return wert der Variable userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * setzt userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * bekommt password
     * @return wert der Variable password
     */
    public String getPassword() {
        return password;
    }

    /**
     * setzt password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * bekommt userRole
     * @return wert der Variable userRole
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * setzt userRole
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
