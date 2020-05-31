package com.example.spring.yconnect.converter;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class StringJoiner implements Collector<Object, StringBuilder, StringBuilder> {

	String joinString;

	public StringJoiner() {
		this(",");
	}

	public StringJoiner(String joinString) {
		this.joinString = joinString;
	}

	@Override
	public Supplier<StringBuilder> supplier() {
		return StringBuilder::new;
	}

	@Override
	public BiConsumer<StringBuilder, Object> accumulator() {
		return StringBuilder::append;
	}

	@Override
	public BinaryOperator<StringBuilder> combiner() {
		return (a, b) -> {
			if (b.length() > 0) {
				if (a.length() > 0) {
					a.append(joinString);
				}
				a.append(b);
			}
			return a;
		};
	}

	@Override
	public Function<StringBuilder, StringBuilder> finisher() {
		return null;
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.unmodifiableSet(EnumSet.of(
				Collector.Characteristics.UNORDERED,
				Collector.Characteristics.IDENTITY_FINISH));
	}

}
