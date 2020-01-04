package util;

public class Util {
  public static boolean isEmpty(String s) {
	  if(s==null||"".equals(s.trim()))
		  return true;
		 return false;
	  }
  public static boolean isEmpty(Object o ) {
	  if(o==null||"".equals(o.toString())) {
		  return true;
		 
	  } return false;
  }
	  
}
