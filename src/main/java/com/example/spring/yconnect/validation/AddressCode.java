package com.example.spring.yconnect.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

@Target({
		METHOD,
		FIELD,
		ANNOTATION_TYPE,
		CONSTRUCTOR,
		PARAMETER,
		TYPE_USE
})
@Retention(RUNTIME)
@Repeatable(AddressCode.List.class)
@Documented
@Constraint(validatedBy = {})
@Pattern(regexp = "^(\\d{2})(\\d{3})?([a-z]{0,2})$")
public @interface AddressCode {

	String message() default "行政区画コード（2桁もしくは5桁）と1桁もしくは2桁のアルファベットのみ許可をする。";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Target({
			METHOD,
			FIELD,
			ANNOTATION_TYPE,
			CONSTRUCTOR,
			PARAMETER,
			TYPE_USE
	})
	@Retention(RUNTIME)
	@Documented
	@interface List {

		AddressCode[] value();
	}
}
