package ua.org.shaddy.anion.annotation.tools;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.stringtemplate.StringTemplate;

import ua.org.shaddy.anion.annotation.Coder;
import ua.org.shaddy.anion.annotation.FieldDescriptor;
import ua.org.shaddy.anion.annotation.ObjectField;
import ua.org.shaddy.anion.annotation.codegenerator.GeneratorData;
import ua.org.shaddy.anion.streamtools.codec.BitStreamDecoder;
import ua.org.shaddy.anion.streamtools.codec.BitStreamEncoder;

public class CodeTools {
	public static final String NL = "\n";
	public static StringTemplate genCodeTemplate(String... lines){
		return new StringTemplate(genCode(lines).toString());
	}
	
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
	
	public static void addAtributesToTpl(StringTemplate tpl, GeneratorData generatorData) {
		tpl.setAttribute("coderInterfaceFullClassName", Coder.class.getName());
		tpl.setAttribute("package", CodeTools.getCoderPackageName(generatorData.getModelClass()));
		tpl.setAttribute("className", generatorData.getClassName());
		tpl.setAttribute("bitStreamEncoderClass", BitStreamEncoder.class);
		tpl.setAttribute("bitStreamDecoderClass", BitStreamDecoder.class);
	}

	public static StringTemplate addAtributesToTpl(StringTemplate tpl, FieldDescriptor field) {
		addAtributesToTpl(tpl, field.getGeneratorData());
		tpl.setAttribute("fieldName", field.getName());
		tpl.setAttribute("fieldType", field.getField().getType().getName());
		tpl.setAttribute("getterName", FieldTools.getter(field.getField()));
		tpl.setAttribute("setterName", FieldTools.setter(field.getField()));
		return tpl;
	}
	
	public static void checkGetterSetter(FieldDescriptor field) {
		 String getter = FieldTools.getter(field.getField());
		 String setter = FieldTools.setter(field.getField());
		 if (!ReflectionTools.isMethodExists(field.getGeneratorData().getModelClass(), getter)){
			 throw new CoderGeneratorException(String.format("Error, no getter for field:%s.%s", field.getGeneratorData().getModelClass().getName(), field.getName()));
		 }
		 if (!ReflectionTools.isMethodExists(field.getGeneratorData().getModelClass(), setter, field.getField().getType())){
			 throw new CoderGeneratorException(String.format("Error, no setter for field:%s.%s", field.getGeneratorData().getModelClass().getName(), field.getName()));
		 }
	}
	
	public static GeneratorData getGeneratorData(Class<?> modelClass) {
		GeneratorData generatorData = new GeneratorData();
		List<FieldDescriptor> descriptors = new ArrayList<>();
		generatorData.setClassName(CodeTools.getCoderSimpleClassName(modelClass));
		generatorData.setFieldDescriptors(descriptors);
		generatorData.setModelClass(modelClass);
		fillFieldsList(generatorData);		
		return generatorData;
	}

	public static void fillFieldsList(GeneratorData generatorData) {
		Field[] fields = generatorData.getModelClass().getDeclaredFields();
		List<FieldDescriptor> fieldList = new ArrayList<>();
		for (Field field: fields){
			if (field.isAnnotationPresent(ObjectField.class)){
				fieldList.add(new FieldDescriptor(field.getAnnotation(ObjectField.class), generatorData,  field, field.getName()));
			}
		}
		generatorData.setFieldDescriptors(fieldList);
		Collections.sort(fieldList);
	}
}
