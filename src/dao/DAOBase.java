package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exception.DatabaseException;
import parameter.DAOParameters;

public class DAOBase {

  Connection con;

  protected void open() throws DatabaseException {
    try {
      Class.forName(DAOParameters.DRIVER_NAME);
      con = DriverManager.getConnection(DAOParameters.CONNECT_STRING,
          DAOParameters.USERID, DAOParameters.PASSWORD);
    } catch (SQLException | ClassNotFoundException e) {
      throw new DatabaseException(e);
    }
  }
  
  protected void close() throws DatabaseException {
      try {
        if (con != null) {
          con.close();
        }
      } catch (SQLException e) {
        throw new DatabaseException(e);
      }
    }
  protected void close(PreparedStatement stmt) throws DatabaseException {
    try {
      if (stmt != null) {
        stmt.close();
      }
      if (con != null) {
        con.close();
      }
    } catch (SQLException e) {
      throw new DatabaseException(e);
    }
  }
  protected void close(PreparedStatement stmt,ResultSet result) throws DatabaseException {
      try {
        if (stmt != null) {
          stmt.close();
        }
        if (con != null) {
          con.close();
        }
        if (result != null) {
            result.close();
          }
      } catch (SQLException e) {
        throw new DatabaseException(e);
      }
    }

}
