package ua.org.shaddy.anion.annotation.tools;

import java.lang.reflect.Field;

public class FieldTools {

	public static String getter(Field field) {
		if (
			field.getType().isAssignableFrom(boolean.class) ||
			field.getType().isAssignableFrom(Boolean.class)
		){
			return "is" + StringUtil.toTitle(field.getName());
		}
		return "get" + StringUtil.toTitle(field.getName());
	}
	
	public static String setter(Field field) {
		return "set" + StringUtil.toTitle(field.getName());
	}
}
