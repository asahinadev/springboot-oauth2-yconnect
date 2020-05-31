package com.example.spring.yconnect.validation;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.mutable.MutableByte;
import org.apache.commons.lang3.mutable.MutableDouble;
import org.apache.commons.lang3.mutable.MutableFloat;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.lang3.mutable.MutableLong;
import org.apache.commons.lang3.mutable.MutableShort;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class FromToValidator implements ConstraintValidator<FromTo, Object> {

	FromTo config;

	@Override
	public void initialize(FromTo constraintAnnotation) {
		this.config = constraintAnnotation;
	}

	@Override
	public boolean isValid(Object target, ConstraintValidatorContext context) {
		BeanWrapper form = new BeanWrapperImpl(target);

		Object fr = form.getPropertyValue(config.from());
		Object to = form.getPropertyValue(config.to());

		// 単一入力であればチェックを行わない
		if (Objects.isNull(fr) || Objects.isNull(to)) {
			return true;
		}

		if (isInstance(fr, to, Byte.class)) {
			return check(fr, to, Byte.class, context);
		} else if (isInstance(fr, to, Short.class)) {
			return check(fr, to, Short.class, context);
		} else if (isInstance(fr, to, Integer.class)) {
			return check(fr, to, Integer.class, context);
		} else if (isInstance(fr, to, Long.class)) {
			return check(fr, to, Long.class, context);
		} else if (isInstance(fr, to, Float.class)) {
			return check(fr, to, Float.class, context);
		} else if (isInstance(fr, to, Double.class)) {
			return check(fr, to, Double.class, context);
		} else if (isInstance(fr, to, BigInteger.class)) {
			return check(fr, to, BigInteger.class, context);
		} else if (isInstance(fr, to, BigDecimal.class)) {
			return check(fr, to, BigDecimal.class, context);
		} else if (isInstance(fr, to, MutableByte.class)) {
			return check(fr, to, MutableByte.class, context);
		} else if (isInstance(fr, to, MutableShort.class)) {
			return check(fr, to, MutableShort.class, context);
		} else if (isInstance(fr, to, MutableInt.class)) {
			return check(fr, to, MutableInt.class, context);
		} else if (isInstance(fr, to, MutableLong.class)) {
			return check(fr, to, MutableLong.class, context);
		} else if (isInstance(fr, to, MutableFloat.class)) {
			return check(fr, to, MutableFloat.class, context);
		} else if (isInstance(fr, to, MutableDouble.class)) {
			return check(fr, to, MutableDouble.class, context);
		} else if (isInstance(fr, to, Date.class)) {
			return check(fr, to, Date.class, context);
		} else if (isInstance(fr, to, Calendar.class)) {
			return check(fr, to, Calendar.class, context);
		} else if (isInstance(fr, to, LocalDateTime.class)) {
			return check(fr, to, LocalDateTime.class, context);
		} else if (isInstance(fr, to, LocalDate.class)) {
			return check(fr, to, LocalDate.class, context);
		} else if (isInstance(fr, to, LocalTime.class)) {
			return check(fr, to, LocalTime.class, context);
		} else if (isInstance(fr, to, ZonedDateTime.class)) {
			return check(fr, to, ZonedDateTime.class, context);
		} else if (isInstance(fr, to, OffsetDateTime.class)) {
			return check(fr, to, OffsetDateTime.class, context);
		} else if (isInstance(fr, to, OffsetTime.class)) {
			return check(fr, to, OffsetTime.class, context);
		} else if (isInstance(fr, to, Year.class)) {
			return check(fr, to, Year.class, context);
		} else if (isInstance(fr, to, YearMonth.class)) {
			return check(fr, to, YearMonth.class, context);
		} else if (isInstance(fr, to, Instant.class)) {
			return check(fr, to, Instant.class, context);
		} else if (isInstance(fr, to, String.class)) {
			return check(fr, to, String.class, context);
		}

		throw new ClassCastException(
				Arrays.asList(
						form.getPropertyType(config.from()),
						form.getPropertyType(config.to())).toString());
	}

	/**
	 * 判定.
	 * 
	 * @param fr      開始
	 * @param to      終了
	 * @param context {@link ConstraintValidatorContext}
	 * @return 判定
	 */
	<E extends Comparable<? super E>> boolean check(E fr, E to, ConstraintValidatorContext context) {
		if (to.compareTo(fr) < 0) {
			return true;
		}
		return setError(context);
	}

	/**
	 * 判定.
	 * 
	 * @param <E>     {@link Comparable}
	 * @param fr      開始
	 * @param to      終了
	 * @param clazz   <E>
	 * @param context
	 * @return 判定
	 */
	<E extends Comparable<? super E>> boolean check(
			Object fr, Object to, Class<E> clazz, ConstraintValidatorContext context) {
		return check(clazz.cast(fr), clazz.cast(to), context);
	}

	/**
	 * 型判定.
	 * 
	 * @param fr    開始
	 * @param to    終了
	 * @param clazz 対象クラス
	 * @return 判定
	 */
	<E> boolean isInstance(Object fr, Object to, Class<E> clazz) {
		return clazz.isInstance(fr) && clazz.isInstance(to);
	}

	/**
	 * エラーメッセージを設定する。( 基本 to ).
	 * 
	 * @param context {@link ConstraintValidatorContext}
	 * @return false 固定
	 */
	boolean setError(ConstraintValidatorContext context) {
		context.buildConstraintViolationWithTemplate(config.message())
				.addPropertyNode(config.to())
				.addConstraintViolation();
		return false;
	}

}
