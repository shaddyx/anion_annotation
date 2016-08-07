package ua.org.shaddy.anion.annotation.codegenerator;

import org.junit.Test;

public class JavaSourceCompilerTest {

	@Test
	public void test() {
		String className = "ua.org.shaddy.MyClass";
		String javaCode = "package ua.org.shaddy;\n" +
		                  "public class MyClass implements Runnable {\n" +
		                  "    public void run() {\n" +
		                  "        System.out.println(\"Hello World\");\n" +
		                  "    }\n" +
		                  "}\n";
		
		Runnable runner = JavaSourceCompiler.compileAndInstantiate(className, javaCode, Runnable.class);
		System.out.println(runner.getClass().getName());
		runner.run();
	}

}
