package cn.dp.exception;

/**
 * Created by pu on 2015/11/1 0001.
 */
public class IdIsNullException extends Throwable {
    public IdIsNullException() {
    }

    public IdIsNullException(String message) {
        super(message);
    }

    public IdIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdIsNullException(Throwable cause) {
        super(cause);
    }

    public IdIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
