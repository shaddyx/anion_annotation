package ua.org.shaddy.anion.annotation;

import java.lang.reflect.Field;

import ua.org.shaddy.anion.annotation.codegenerator.GeneratorData;

public class FieldDescriptor implements Comparable<FieldDescriptor>{
	private final ObjectField ofield;
	private final Field field;
	private final String name;
	private final GeneratorData generatorData;
	
	public FieldDescriptor(ObjectField ofield, GeneratorData generatorData, Field field, String name) {
		super();
		this.ofield = ofield;
		this.field = field;
		this.name = name;
		this.generatorData = generatorData;
	}
	public ObjectField getOfield() {
		return ofield;
	}
	public Field getField() {
		return field;
	}
	public String getName() {
		return name;
	}
	public GeneratorData getGeneratorData() {
		return generatorData;
	}
	@Override
	public String toString() {
		return "FieldDescriptor [ofield=" + ofield + ", field=" + field + ", name=" + name + "]";
	}
	@Override
	public int compareTo(FieldDescriptor fd) {
		return this.getOfield().order() - fd.getOfield().order();
	}
	
}
