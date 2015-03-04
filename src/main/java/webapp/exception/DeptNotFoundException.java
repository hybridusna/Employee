package webapp.exception;

public class DeptNotFoundException extends RuntimeException{
	
	public DeptNotFoundException() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public DeptNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
	public DeptNotFoundException(String message, Throwable e) {
		// TODO Auto-generated constructor stub
		super(message, e);
	}

}
