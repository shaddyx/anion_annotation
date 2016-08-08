package ua.org.shaddy.anion.annotation.codegenerator.codegenerator.impl;

import java.util.List;

import org.antlr.stringtemplate.StringTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.org.shaddy.anion.annotation.Coder;
import ua.org.shaddy.anion.annotation.FieldDescriptor;
import ua.org.shaddy.anion.annotation.tools.CodeTools;

public class CoderCodeGenerator {
	final Logger logger = LoggerFactory.getLogger(getClass());
	final Class<?> clazz;
	final String className;
	final List<FieldDescriptor> descriptors;
	final FieldCodeGenerator fieldCodeGenerator;
	
	public CoderCodeGenerator(Class<?> clazz, String className, List<FieldDescriptor> descriptors) {
		super();
		this.clazz = clazz;
		this.className = className;
		this.descriptors = descriptors;
		fieldCodeGenerator = new FieldCodeGenerator(clazz);
	}
	
	public String generateCoder() {
		StringBuilder code = CodeTools.genCode(
				"package $package$",
				"public class $className$ implements $coderInterfaceFullClassName$ {",
				"$methods$",
				"}"
		);
		//public Object decode(BitInputStream bis);
		//public void encode(BitOutputStream bos, Object obj);
		StringTemplate tpl = new StringTemplate(code.toString());
		tpl.setAttribute("coderInterfaceFullClassName", Coder.class.getName());
		tpl.setAttribute("package", CodeTools.getCoderPackageName(clazz));
		tpl.setAttribute("className", className);
		tpl.setAttribute("methods", generateMethods());
		return tpl.toString();
	}
	private StringBuilder generateMethods() {
		StringBuilder methodsCode = new StringBuilder(); 
		for (FieldDescriptor field: descriptors){
			methodsCode.append(fieldCodeGenerator.generate(field)).append(CodeTools.NL);
		}
		return methodsCode;
	}
}
