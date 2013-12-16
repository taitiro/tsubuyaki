package beans;

import java.io.Serializable;

/**
 * Session Bean implementation class TsusbuyakiBean
 */
public class UserBean implements Serializable {
    
    private String name;
    private String password;
    private String role;
    private String userdesc = "";
    private String icon = "";
    private String address = "";
    private String homepage = "";
    private String realname = "";
    
    public UserBean(String name, String password, String role){
        setName(name);
        setPassword(password);
        setRole(role);
    }
    

    public UserBean(String name, String password, String role, String userdesc, String icon, String address, String homepage, String realname ){
        setName(name);
        setPassword(password);
        setRole(role);
        setUserdesc(userdesc);
        setIcon(icon);
        setAddress(address);
        setHomepage(homepage);
        setRealname(realname);
    }
    
    public UserBean() {
        super();
    }


    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public String getUserdesc() {
        return userdesc;
    }

    public void setUserdesc(String userdesc) {
        this.userdesc = userdesc;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }
    
}
