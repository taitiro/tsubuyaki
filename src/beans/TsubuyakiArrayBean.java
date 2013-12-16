package beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Session Bean implementation class TsusbuyakiBean
 */
public class TsubuyakiArrayBean implements Serializable {
    
    private String name;
    ArrayList<TsubuyakiBean> tsubuyakiArray  = new ArrayList<TsubuyakiBean>();
    
    public TsubuyakiArrayBean(){
        super();
    }
    
    public TsubuyakiArrayBean(String name, ArrayList<TsubuyakiBean> tsubuyakiArray){
        setName(name);
        setTsubuyakiArray(tsubuyakiArray);
    }
    
    public ArrayList<TsubuyakiBean> getTsubuyakiArray(){
        return tsubuyakiArray;
    }
    
    public void setTsubuyakiArray(ArrayList<TsubuyakiBean> tsubuyakiArray) {
        this.tsubuyakiArray = tsubuyakiArray;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
