package beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Session Bean implementation class TsusbuyakiBean
 */
public class UserArrayBean implements Serializable {
    
    private ArrayList<String[]> usersArray  = new ArrayList<>();

    public ArrayList<String[]> getUsersArray() {
        return usersArray;
    }

    public void setUsersArray(ArrayList<String[]> usersArray) {
        this.usersArray = usersArray;
    }
    
}
