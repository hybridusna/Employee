package webapp.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) throws IOException {//예외는 테스트이기 때문에 그냥 던짐 원래는 다 잡아야된다

		Properties dbprop = new Properties();
		
		//FileInputStream inStream = new FileInputStream("db.properties");
		
		InputStream inStream = PropertiesTest.class.getResourceAsStream("/webapp/spring/db.properties");
		
		dbprop.load(inStream);
		
		String ClassName = dbprop.getProperty("oracle.ClassName");
		String url = dbprop.getProperty("oracle.url");
		String user = dbprop.getProperty("oracle.user");
		String password = dbprop.getProperty("oracle.password");
		
		System.out.println("classname = " + ClassName);
		System.out.println("url = "+ url);
		System.out.println("user = " + user);
		System.out.println("password = "+ password);

	}

}
