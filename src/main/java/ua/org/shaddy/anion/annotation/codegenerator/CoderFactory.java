package ua.org.shaddy.anion.annotation.codegenerator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ua.org.shaddy.anion.annotation.Coder;
import ua.org.shaddy.anion.annotation.FieldDescriptor;
import ua.org.shaddy.anion.annotation.ObjectField;
import ua.org.shaddy.anion.annotation.codegenerator.codegenerator.impl.CoderCodeGenerator;
import ua.org.shaddy.anion.annotation.tools.CodeTools;

public class CoderFactory {
	
	private Coder buildCoder(Class<?> clazz, List<FieldDescriptor> descriptors){
		CoderCodeGenerator codeGenerator = new CoderCodeGenerator(clazz, CodeTools.getCoderSimpleClassName(clazz), descriptors);
		return JavaSourceCompiler.compileAndInstantiate(
				CodeTools.getCoderSimpleClassName(clazz),
				codeGenerator.generateCoder(), 
				Coder.class);
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
		return buildCoder(clazz, fieldList);
	}
}
