package ua.org.shaddy.anion.annotation.codegenerator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ua.org.shaddy.anion.annotation.Coder;
import ua.org.shaddy.anion.annotation.FieldDescriptor;
import ua.org.shaddy.anion.annotation.ObjectField;
import ua.org.shaddy.anion.annotation.codegenerator.codegenerator.impl.DecoderCodeGenerator;

public class CoderFactory {
	
	private Coder buildCoder(String className, List<FieldDescriptor> descriptors){
		return JavaSourceCompiler.compileAndInstantiate(className, DecoderCodeGenerator.generateCoder(className, descriptors), Coder.class);
	}
	
	private String getCoderPackageName(Class<?> clazz){
		return this.getClass().getPackage().toString();
	}
	
	private String getCoderSimpleClassName(Class<?> clazz){
		return clazz.getName().replace(".", "_") + "_Coder";
	}
	
	private String getCoderFullClassName(Class<?> clazz){
		return getCoderPackageName(clazz) + "." + getCoderSimpleClassName(clazz);
	}
	
	public Coder makeCoder(Class<?> clazz){
		Field[] fields = clazz.getDeclaredFields();
		List<FieldDescriptor> fieldList = new ArrayList<>();
		for (Field field: fields){
			if (field.isAnnotationPresent(ObjectField.class)){
				fieldList.add(new FieldDescriptor(field.getAnnotation(ObjectField.class), field, field.getName()));
			}
		}
		Collections.sort(fieldList);
		return buildCoder(getCoderFullClassName(clazz), fieldList);
	}
}
