package beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Session Bean implementation class TsusbuyakiBean
 */
public class TsubuyakiBean implements Serializable {

    private String name;
    private String value;
    private Timestamp timestamp;
    private String realName = "unknown";
    
    /**
     * Default constructor. 
     */
    public TsubuyakiBean(String name, String value) {
         this.name = name;
         this.value = value;
         this.setTimestamp();
     }
    public TsubuyakiBean(String name, String value, Date date) {
        this.name = name;
        this.value = value;
        this.setTimestamp(date);
    }
    public TsubuyakiBean(String name, String value, Date date, String realName) {
        this.name = name;
        this.value = value;
        setRealName(realName);
        this.setTimestamp(date);
    }
    public TsubuyakiBean(String name, String value, String datestr) {
        this.name = name;
        this.value = value;
        this.setTimestamp(datestr);
    }
    public TsubuyakiBean(String name, String value, String datestr, String realName) {
        this.name = name;
        this.value = value;
        setRealName(realName);
        this.setTimestamp(datestr);
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
    
    
    public void setTimestamp() {
        this.timestamp = new Timestamp(new Date().getTime());
    }
    
    public void setTimestamp(Date date) {
        this.timestamp = new Timestamp(date.getTime());
    }
    
    public void setTimestamp(String datestr) {
        try {
            this.timestamp = new Timestamp( DateFormat.getInstance().parse(datestr).getTime());
        } catch (ParseException e) {
            this.timestamp = new Timestamp(new Date().getTime());
        }
    }
    public String getRealName() {
        return realName;
    }
    public void setRealName(String realName) {
        this.realName = realName;
    }

}
