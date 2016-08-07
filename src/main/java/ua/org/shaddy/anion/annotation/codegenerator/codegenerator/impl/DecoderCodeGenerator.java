package ua.org.shaddy.anion.annotation.codegenerator.codegenerator.impl;

import java.util.List;

import org.antlr.stringtemplate.StringTemplate;

import ua.org.shaddy.anion.annotation.FieldDescriptor;

public class DecoderCodeGenerator {
	
	private static final String NL = "\n";

	public static String generateCoder(String className, List<FieldDescriptor> descriptors) {
		StringBuilder code = new StringBuilder("package $package$");
		code.append(NL);
		code.append("public class $className$ implements $coderInterfaceFullClassName$ {").append(NL);
		code.append("@Override").append(NL);
		code.append("@Override").append(NL);
		code.append("}").append(NL);
		
		StringTemplate tpl = new StringTemplate(code.toString());
		return tpl.toString();
	}

}
