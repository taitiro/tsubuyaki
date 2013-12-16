package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.UserBean;
import exception.DatabaseException;

public class UserDAO extends DAOBase {

    public ArrayList<String[]> getAllUsers() throws DatabaseException {
        PreparedStatement prestmt = null;
        ResultSet result = null;
        ArrayList<String[]> userArray = new ArrayList<>();
        open();
        try {
            prestmt = con.prepareStatement("SELECT * FROM userrole");
            result = prestmt.executeQuery();
            while (result.next()) {
                userArray.add(new String[] { result.getString("name"), result.getString("role") });
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        } finally {
            close(prestmt, result);
        }
        return userArray;
    }

    public int addUser(UserBean user) throws DatabaseException {
        int userauthRet = 0;
        int userroleRet = 0;
        int profileRet = 0;
        PreparedStatement authPrestmt = null;
        PreparedStatement rolePrestmt = null;
        PreparedStatement profilePrestmt = null;
        open();
        try {
            authPrestmt = con.prepareStatement("INSERT INTO userauth values( ? , ? ) ");
            authPrestmt.setString(1, user.getName());
            authPrestmt.setString(2, user.getPassword());
            userauthRet = authPrestmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        } finally {
            close(authPrestmt);
        }
        open();
        try {
            rolePrestmt = con.prepareStatement("INSERT INTO userrole values( ? , ? ) ");
            rolePrestmt.setString(1, user.getName());
            rolePrestmt.setString(2, user.getRole());
            userroleRet = rolePrestmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        } finally {
            close(rolePrestmt);
        }
        open();
        try {
            profilePrestmt = con.prepareStatement("INSERT INTO profile ( name, userdesc, icon, address, homepage, realname) "
                    + "values( ? , ? , ? , ? , ? , ? ) ");
            profilePrestmt.setString(1, user.getName());
            profilePrestmt.setString(2, user.getUserdesc());
            profilePrestmt.setString(3, user.getIcon());
            profilePrestmt.setString(4, user.getAddress());
            profilePrestmt.setString(5, user.getHomepage());
            profilePrestmt.setString(6, user.getRealname());
            profileRet = profilePrestmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        } finally {
            close(profilePrestmt);
        }
        if ((userauthRet <= 1) && (userroleRet <= 1) &&  (profileRet <= 1) ) {
            return 1;
        }else if ((userauthRet == 0) && (userroleRet == 0) && (profileRet == 0)){
            return 0;
        }else{
            return -1;
        }
    }
    
    public int editUser(UserBean user) throws DatabaseException {
        int userauthRet = 0;
        int userroleRet = 0;
        int profileRet = 0;
        PreparedStatement authPrestmt = null;
        PreparedStatement rolePrestmt = null;
        PreparedStatement profilePrestmt = null;
        open();
        try {
            authPrestmt = con.prepareStatement("UPDATE userauth SET password = ? WHERE name = ? ");
            authPrestmt.setString(1, user.getPassword());
            authPrestmt.setString(2, user.getName());
            userauthRet = authPrestmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        } finally {
            close(authPrestmt);
        }
        open();
        try {
            rolePrestmt = con.prepareStatement("UPDATE userrole SET role = ? WHERE name = ? ");
            rolePrestmt.setString(1, user.getRole());
            rolePrestmt.setString(2, user.getName());
            userauthRet = rolePrestmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        } finally {
            close(rolePrestmt);
        }
        open();
        try {
            profilePrestmt = con.prepareStatement("UPDATE profile "
                    + "SET userdesc = ? , icon = ? , address = ? , homepage = ? , realname = ? "
                    + "WHERE name = ?");
            profilePrestmt.setString(1, user.getUserdesc());
            profilePrestmt.setString(2, user.getIcon());
            profilePrestmt.setString(3, user.getAddress());
            profilePrestmt.setString(4, user.getHomepage());
            profilePrestmt.setString(5, user.getRealname());
            profilePrestmt.setString(6, user.getName());
            profileRet = profilePrestmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        } finally {
            close(profilePrestmt);
        }
        if ((userauthRet <= 1) && (userroleRet <= 1) &&  (profileRet <= 1) ) {
            return 1;
        }else if ((userauthRet == 0) && (userroleRet == 0) && (profileRet == 0)){
            return 0;
        }else{
            return -1;
        }
    }
    
    public int deleteUser(String deleteUserName) throws DatabaseException {
        int ret = 0;
        PreparedStatement prestmt = null;
        open();
        try {
            prestmt = con.prepareStatement("DELETE userauth, userrole, profile FROM userauth "
                    + "INNER JOIN (userrole INNER JOIN profile ON userrole.name = profile.name) ON userauth.name = userrole.name "
                    + "WHERE userauth.name = ?");
            prestmt.setString(1, deleteUserName);
            ret = prestmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        } finally {
            close(prestmt);
        }
        return ret;
    }
    
    public UserBean getUser(String name) throws DatabaseException{
        PreparedStatement prestmt = null;
        ResultSet result = null;
        UserBean user = new UserBean();
        open();
        try {
            prestmt = con.prepareStatement("SELECT profile.name, userdesc, icon, address, homepage, realname, userrole.role "
                    + "FROM profile INNER JOIN userrole ON profile.name = userrole.name "
                    + "WHERE profile.name = ?");
            prestmt.setString(1, name);
            result = prestmt.executeQuery();
            while (result.next()) {
                user.setName(result.getString("name"));
                user.setRole(result.getString("role"));
                user.setUserdesc(result.getString("userdesc"));
                user.setIcon(result.getString("icon"));
                user.setAddress(result.getString("address"));
                user.setHomepage(result.getString("homepage"));
                user.setRealname(result.getString("realname"));
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        } finally {
            close(prestmt, result);
        }
        return user;
    }
}
