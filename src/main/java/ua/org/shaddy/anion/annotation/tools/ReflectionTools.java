package ua.org.shaddy.anion.annotation.tools;

import java.lang.reflect.Method;

public class ReflectionTools {
	public static boolean isMethodExists(Class<?> clazz, String method, Class<?>...parameterTypes) {
		return getMethod(clazz, method, parameterTypes) != null;
	}
	
	public static Method getMethod(Class<?> clazz, String method, Class<?>...parameterTypes) {
		try {
			return clazz.getDeclaredMethod(method, parameterTypes);
		} catch (NoSuchMethodException | SecurityException e) {
			return null;
		}
	}

}
