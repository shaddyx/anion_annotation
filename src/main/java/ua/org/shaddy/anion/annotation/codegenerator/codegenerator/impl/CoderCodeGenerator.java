package ua.org.shaddy.anion.annotation.codegenerator.codegenerator.impl;

import org.antlr.stringtemplate.StringTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.org.shaddy.anion.annotation.FieldDescriptor;
import ua.org.shaddy.anion.annotation.codegenerator.GeneratorData;
import ua.org.shaddy.anion.annotation.tools.CodeTools;

public class CoderCodeGenerator {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private GeneratorData generatorData;
	
	
	public CoderCodeGenerator(GeneratorData generatorData) {
		this.generatorData = new GeneratorData();
	}
	
	public String generateCoder() {
		StringTemplate tpl = CodeTools.genCodeTemplate(
				"package $package$",
				"public class $className$ implements $coderInterfaceFullClassName$ {",
				"public $className$ decode($bitStreamEncoderClass$ enc){",
				"	$decoder$",
				"}",
				"	$encoder$",
				"}"
		);
		tpl.setAttribute("decoder", generateDecoder(generatorData));
		tpl.setAttribute("encoder", generateEncoder(generatorData));
		CodeTools.addAtributesToTpl(tpl, this.generatorData);
		return tpl.toString();
	}
	
	public String generateDecoder(GeneratorData generatorData) {
		StringBuilder methodsCode = new StringBuilder();
		for (FieldDescriptor field: generatorData.getFieldDescriptors()){
			methodsCode.append(FieldCodeGenerator.generateFieldDecoder(field)).append(CodeTools.NL);
		}
		return methodsCode.toString();
	}

	public static String generateEncoder(GeneratorData generatorData) {
		StringBuilder methodsCode = new StringBuilder();
		for (FieldDescriptor field: generatorData.getFieldDescriptors()){
			methodsCode.append(FieldCodeGenerator.generateFieldEncoder(field)).append(CodeTools.NL);
		}
		return methodsCode.toString();
	}
}
