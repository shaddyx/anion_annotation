package ua.org.shaddy.anion.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import ua.org.shaddy.anion.annotation.impl.DefaultFieldCoder;
import ua.org.shaddy.anion.annotation.impl.DefaultFieldCondition;

@Target(value=ElementType.FIELD)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface Field {
	int size() default -1;
	Class<? extends FieldCoder> coder() default DefaultFieldCoder.class;
	Class<? extends FieldCondition> condition() default DefaultFieldCondition.class;
	ByteOrder byteOrder() default ByteOrder.LITTLE_ENDIAN; 
}
