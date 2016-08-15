package ua.org.shaddy.anion.annotation.codegenerator;

import ua.org.shaddy.anion.annotation.Coder;
import ua.org.shaddy.anion.annotation.codegenerator.codegenerator.impl.CoderCodeGenerator;
import ua.org.shaddy.anion.annotation.tools.CodeTools;

public class CoderFactory {

	public Coder makeCoder(Class<?> modelClass){
		CoderCodeGenerator codeGenerator = new CoderCodeGenerator(CodeTools.getGeneratorData(modelClass));
		return JavaSourceCompiler.compileAndInstantiate(
			CodeTools.getCoderSimpleClassName(modelClass),
			codeGenerator.generateCoder(), 
			Coder.class
		);
	}
}
