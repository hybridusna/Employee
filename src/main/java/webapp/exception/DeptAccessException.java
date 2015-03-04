package webapp.exception;

public class DeptAccessException extends RuntimeException{
	
	public DeptAccessException() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public DeptAccessException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
	
	public DeptAccessException(Throwable e){
		super(e);
	}
	
	public DeptAccessException(String message, Throwable e) {
		// TODO Auto-generated constructor stub
		super(message, e);
	}

}
