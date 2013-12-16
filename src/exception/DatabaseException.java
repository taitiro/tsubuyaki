package exception;

import javax.servlet.ServletException;

public class DatabaseException extends ServletException {
  private static final long serialVersionUID = 1L;

  public DatabaseException() {
    super();
  }

  public DatabaseException(String message, Throwable cause) {
    super(message, cause);
  }

  public DatabaseException(String message) {
    super(message);
  }

  public DatabaseException(Throwable cause) {
    super(cause);
  }

}
