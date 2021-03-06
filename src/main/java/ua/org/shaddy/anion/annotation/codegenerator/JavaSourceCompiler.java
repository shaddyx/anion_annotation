package ua.org.shaddy.anion.annotation.codegenerator;

import net.openhft.compiler.CompilerUtils;

public class JavaSourceCompiler {
	public static <T> Class<T> compile(String className, String code, Class<T> clazz){
		return (Class<T>) compile(className, code);
	}
	
	public static Class<?> compile(String className, String code){
		try {
			return CompilerUtils.CACHED_COMPILER.loadFromJava(className, code);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Error creating class", e);
		}
	}
	
	public static <T> T compileAndInstantiate(String className, String code, Class<T> clazz){
		return (T) compileAndInstantiate(className, code);
	}
	
	public static Object compileAndInstantiate(String className, String code){
		Class<?> cls = compile(className, code); 
		try {
			return cls.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException("Error instantiating class", e);
		}
	}
}
