package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import exception.DatabaseException;
import beans.TsubuyakiArrayBean;
import beans.TsubuyakiBean;

public class TsubuyakiDAO extends DAOBase {

    public int addTsubuyaki(TsubuyakiBean tsubuyaki) throws DatabaseException {
        int ret = 0;
        PreparedStatement prestmt = null;
        open();
        try {
            prestmt = con.prepareStatement("INSERT INTO tsubuyaki values( ? , ? , ? ) ");
            prestmt.setString(1, tsubuyaki.getName());
            prestmt.setString(2, tsubuyaki.getValue());
            prestmt.setTimestamp(3, tsubuyaki.getTimestamp());
            ret = prestmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        } finally {
            close(prestmt);
        }
        return ret;
    }

    public TsubuyakiArrayBean getAllTsubuyaki() throws DatabaseException {
        PreparedStatement prestmt = null;
        ResultSet result = null;
        ArrayList<TsubuyakiBean> tsubuyakiArray = new ArrayList<TsubuyakiBean>();
        open();
        try {
            prestmt = con.prepareStatement("SELECT tsubuyaki.name, value, date, realname, icon "
                    + "FROM tsubuyaki INNER JOIN profile ON profile.name = tsubuyaki.name "
                    + "ORDER BY date DESC ");
            result = prestmt.executeQuery();
            while (result.next()) {
                tsubuyakiArray.add(new TsubuyakiBean(result.getString("tsubuyaki.name"), result.getString("value"),
                        result.getTimestamp("date"), result.getString("realname"), result.getString("icon")));
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        } finally {
            close(prestmt, result);
        }
        return new TsubuyakiArrayBean("All", tsubuyakiArray);
    }

    public TsubuyakiArrayBean getTsubuyakiByName(String name) throws DatabaseException {
        PreparedStatement prestmt = null;
        ResultSet result = null;
        ArrayList<TsubuyakiBean> tsubuyakiArray = new ArrayList<TsubuyakiBean>();
        open();
        try {
            prestmt = con.prepareStatement("SELECT tsubuyaki.name, value, date, realname, icon "
                    + "FROM tsubuyaki INNER JOIN profile ON (profile.name = tsubuyaki.name) AND (profile.name = ? ) "
                    + "ORDER BY date DESC ");
            prestmt.setString(1, name);
            result = prestmt.executeQuery();
            while (result.next()) {
                tsubuyakiArray.add(new TsubuyakiBean(result.getString("tsubuyaki.name"), result.getString("value"),
                        result
                                .getTimestamp("date"), result.getString("realname"), result.getString("icon")));
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        } finally {
            close(prestmt, result);
        }
        return new TsubuyakiArrayBean(name, tsubuyakiArray);
    }

    public int deleteTsubuyakiByName(String name) throws DatabaseException {
        PreparedStatement prestmt = null;
        int ret = 0;
        open();
        try {
            prestmt = con.prepareStatement("DELETE FROM tsubuyaki WHERE name = ? ");
            prestmt.setString(1, name);
            ret = prestmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        } finally {
            close(prestmt);
        }
        return ret;
    }
}
