package ua.org.shaddy.anion.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import ua.org.shaddy.anion.annotation.impl.DefaultFieldCoder;
import ua.org.shaddy.anion.annotation.impl.DefaultFieldCondition;

@Target(value=ElementType.FIELD)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface ObjectField {
	int size() default -1;
	int order() default -1;
	Class<? extends ObjectFieldCoder> coder() default DefaultFieldCoder.class;
	Class<? extends ObjectFieldCondition> condition() default DefaultFieldCondition.class;
	ByteOrder byteOrder() default ByteOrder.LITTLE_ENDIAN; 
}
