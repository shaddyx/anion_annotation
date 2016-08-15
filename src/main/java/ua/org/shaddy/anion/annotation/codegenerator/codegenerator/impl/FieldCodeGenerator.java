package ua.org.shaddy.anion.annotation.codegenerator.codegenerator.impl;

import org.antlr.stringtemplate.StringTemplate;

import ua.org.shaddy.anion.annotation.FieldDescriptor;
import ua.org.shaddy.anion.annotation.codegenerator.GeneratorData;
import ua.org.shaddy.anion.annotation.tools.CodeTools;
import ua.org.shaddy.anion.annotation.tools.FieldTools;

public class FieldCodeGenerator {

	public static StringTemplate generateFieldDecoder(FieldDescriptor field) {
		return CodeTools.addAtributesToTpl(
				CodeTools.genCodeTemplate(
					""
				), 
		field);
		
	}

	public static StringTemplate generateFieldEncoder(FieldDescriptor field) {
		return CodeTools.addAtributesToTpl(
				CodeTools.genCodeTemplate(
					""
				), 
		field);
	}

//	public static String generateDecoder(FieldDescriptor field) {
////		"@Override",
////		"public $className$ decode($bitStreamEncoderClass$ enc){",
////		
////		"}",
////		"@Override",
////		"public void encode(",
////		"	$encoder$",
////		
//		CodeTools.checkGetterSetter(field);
//		StringTemplate tpl = CodeTools.genCodeTemplate(
//			"//public void $setterName$($fieldType$ $fieldName$)",
//			"//public $fieldType$ $getterName$()",
//			"obj.$"
//		);
//		CodeTools.addAtributesToTpl(tpl, field);
//		
//		return tpl.toString();
//	}

	
}
