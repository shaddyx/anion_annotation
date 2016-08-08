package ua.org.shaddy.anion.annotation.codegenerator.codegenerator.impl;

import ua.org.shaddy.anion.annotation.FieldDescriptor;
import ua.org.shaddy.anion.annotation.tools.FieldTools;
import ua.org.shaddy.anion.annotation.tools.ReflectionTools;

public class FieldCodeGenerator {

	private final Class<?> clazz;

	public FieldCodeGenerator(Class<?> clazz) {
		this.clazz = clazz;
	}

	public String generate(FieldDescriptor field) {
		Class<?> type = field.getField().getType();
		checkGetterSetter(field);
	}
	private void checkGetterSetter(FieldDescriptor field) {
		 String getter = FieldTools.getter(field.getField());
		 ReflectionTools.isMethodExists(clazz, getter);
		 
	}

}
