package SIS.SIS2.Login;
import java.util.HashMap;

public class IDandPasswords {

	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	IDandPasswords(){
		
		logininfo.put("Rustem","Amirkhanuly");
		logininfo.put("Someone","123");
		logininfo.put("Nurmukhan","Kaster");
	}
	
	public HashMap getLoginInfo(){
		return logininfo;
	}
}