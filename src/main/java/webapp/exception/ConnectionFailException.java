package webapp.exception;

public class ConnectionFailException extends RuntimeException{
	
	public ConnectionFailException() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public ConnectionFailException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
	public ConnectionFailException(String message, Throwable e) {
		// TODO Auto-generated constructor stub
		super(message, e);
	}

}
