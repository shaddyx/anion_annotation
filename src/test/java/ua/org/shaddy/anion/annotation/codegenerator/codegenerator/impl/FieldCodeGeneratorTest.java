package ua.org.shaddy.anion.annotation.codegenerator.codegenerator.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.org.shaddy.anion.annotation.FieldDescriptor;
import ua.org.shaddy.anion.annotation.ObjectField;
import ua.org.shaddy.anion.annotation.codegenerator.GeneratorData;
import ua.org.shaddy.anion.annotation.tools.CodeTools;

public class FieldCodeGeneratorTest {
	protected class TestClass{
		@ObjectField
		private String a;
		@ObjectField
		private int b;
		public String getA() {
			return a;
		}
		public void setA(String a) {
			this.a = a;
		}
		public int getB() {
			return b;
		}
		public void setB(int b) {
			this.b = b;
		}
		
	}
	
	@Test
	public void testGenerateGetterAndSetter() {
		GeneratorData genData = CodeTools.getGeneratorData(TestClass.class);
		CodeTools.fillFieldsList(genData);
		for (FieldDescriptor f: genData.getFieldDescriptors()){
			String getSet = FieldCodeGenerator.generateGetterAndSetter(f);
			System.out.println(getSet);
		}
		
	}
}
