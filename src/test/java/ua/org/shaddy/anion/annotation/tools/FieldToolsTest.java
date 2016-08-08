package ua.org.shaddy.anion.annotation.tools;

import static org.junit.Assert.*;

import org.junit.Test;

public class FieldToolsTest {
	class TestFields{
		private int a;
		private boolean b;
	}
	
	
	@Test
	public void testGetter() throws NoSuchFieldException, SecurityException {
		assertEquals("getA", FieldTools.getter(TestFields.class.getDeclaredField("a")));
		assertEquals("isB", FieldTools.getter(TestFields.class.getDeclaredField("b")));
	}

	@Test
	public void testSetter() throws NoSuchFieldException, SecurityException {
		assertEquals("setA", FieldTools.setter(TestFields.class.getDeclaredField("a")));
		assertEquals("setB", FieldTools.setter(TestFields.class.getDeclaredField("b")));
	}

}
