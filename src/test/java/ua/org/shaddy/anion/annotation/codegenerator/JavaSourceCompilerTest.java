package ua.org.shaddy.anion.annotation.codegenerator;

import org.junit.Test;

public class JavaSourceCompilerTest {

	@Test
	public void test() {
		String className = "mypackage.MyClass";
		String javaCode = "package mypackage;\n" +
		                  "public class MyClass implements Runnable {\n" +
		                  "    public void run() {\n" +
		                  "        System.out.println(\"Hello World\");\n" +
		                  "    }\n" +
		                  "}\n";
		
		Runnable runner = (Runnable) JavaSourceCompiler.compileAndInstantiate(className, javaCode);
		runner.run();
	}

}
