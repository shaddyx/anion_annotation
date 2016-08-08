package ua.org.shaddy.anion.annotation.tools;

public class StringUtil {
	public static String toTitle (String s) {
      String s1 = s.substring(0,1).toUpperCase();
      String sTitle = s1 + s.substring(1);
      return sTitle;
    }
}
