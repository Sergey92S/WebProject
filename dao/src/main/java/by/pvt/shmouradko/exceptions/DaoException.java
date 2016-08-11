package by.pvt.shmouradko.exceptions;

/**
 * Created by test on 13.05.2016.
 */
public class DaoException extends Exception {
    private Exception exception;

    public DaoException(Exception exception) {
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
