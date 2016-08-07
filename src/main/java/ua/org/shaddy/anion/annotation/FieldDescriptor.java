package ua.org.shaddy.anion.annotation;

import java.lang.reflect.Field;

public class FieldDescriptor implements Comparable<FieldDescriptor>{
	private final ObjectField ofield;
	private final Field field;
	private final String name;
	public FieldDescriptor(ObjectField ofield, Field field, String name) {
		super();
		this.ofield = ofield;
		this.field = field;
		this.name = name;
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
	@Override
	public String toString() {
		return "FieldDescriptor [ofield=" + ofield + ", field=" + field + ", name=" + name + "]";
	}
	@Override
	public int compareTo(FieldDescriptor fd) {
		return this.getOfield().order() - fd.getOfield().order();
	}
	
}
