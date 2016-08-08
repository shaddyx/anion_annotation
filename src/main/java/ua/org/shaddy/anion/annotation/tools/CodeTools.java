package ua.org.shaddy.anion.annotation.tools;

public class CodeTools {
	public static final String NL = "\n";
	public static StringBuilder genCode(String... lines){
		StringBuilder sb = new StringBuilder();
		for (String line: lines){
			sb.append(line).append(NL);
		}
		return sb;
	}
	
	public static String getCoderPackageName(Class<?> clazz){
		return clazz.getPackage().toString();
	}
	
	public static String getCoderSimpleClassName(Class<?> clazz){
		return clazz.getName().replace(".", "_") + "_Coder";
	}
	
	public static String getCoderFullClassName(Class<?> clazz){
		return getCoderPackageName(clazz) + "." + getCoderSimpleClassName(clazz);
	}
}
