package com.murphy.springmvc.exception;

/**
 *
 * @author Wujun
 * @date 2019/12/18 16:52
 * @version 1.0
 */
public class LoginException extends RuntimeException {

	public LoginException() {
		super();
	}

	/** Constructs a new runtime exception with the specified detail message.
	 * The cause is not initialized, and may subsequently be initialized by a
	 * call to {@link #initCause}.
	 *
	 * @param   message   the detail message. The detail message is saved for
	 *          later retrieval by the {@link #getMessage()} method.
	 */
	public LoginException(String message) {
		super(message);
	}

	/**
	 * Constructs a new runtime exception with the specified detail message and
	 * cause.  <p>Note that the detail message associated with
	 * {@code cause} is <i>not</i> automatically incorporated in
	 * this runtime exception's detail message.
	 *
	 * @param  message the detail message (which is saved for later retrieval
	 *         by the {@link #getMessage()} method).
	 * @param  cause the cause (which is saved for later retrieval by the
	 *         {@link #getCause()} method).  (A <tt>null</tt> value is
	 *         permitted, and indicates that the cause is nonexistent or
	 *         unknown.)
	 * @since  1.4
	 */
	public LoginException(String message, Throwable cause) {
		super(message, cause);
	}
}
