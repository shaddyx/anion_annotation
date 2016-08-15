package ua.org.shaddy.anion.annotation.codegenerator;

import java.util.List;

import ua.org.shaddy.anion.annotation.FieldDescriptor;

public class GeneratorData {
	Class<?> modelClass;
	String className;
	List<FieldDescriptor> fieldDescriptors;
	public Class<?> getModelClass() {
		return modelClass;
	}
	public void setModelClass(Class<?> modelClass) {
		this.modelClass = modelClass;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<FieldDescriptor> getFieldDescriptors() {
		return fieldDescriptors;
	}
	public void setFieldDescriptors(List<FieldDescriptor> fieldDescriptors) {
		this.fieldDescriptors = fieldDescriptors;
	}
	@Override
	public String toString() {
		return "GeneratorData [modelClass=" + modelClass + ", className=" + className + ", fieldDescriptors="
				+ fieldDescriptors + "]";
	}
}
