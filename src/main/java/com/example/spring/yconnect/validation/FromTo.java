package com.example.spring.yconnect.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ReportAsSingleViolation;

import com.nimbusds.jose.Payload;

@Documented
@Constraint(validatedBy = {
		FromToValidator.class
})
@Target({
		ElementType.TYPE,
		ElementType.ANNOTATION_TYPE
})
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
public @interface FromTo {

	String message() default "invalid value";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String from();

	String to();

	@Target({
			ElementType.TYPE,
			ElementType.ANNOTATION_TYPE
	})
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	public @interface List {
		FromTo[] value();
	}
}
