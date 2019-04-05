package com.zuehlke.testing.testdata.examples;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import jdk.jfr.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.zuehlke.testing.testdata.PrimeFactor;

class PrimeFactorTest {

	@ParameterizedTest
	@MethodSource("argumentsProvider")
	void primeFactors(int product, List<Integer> factors) {
		// act
		List<Integer> result = PrimeFactor.factorsOf(product);
		// arrange
		assertThat(result, is(equalTo(factors)));
	}

	@DisplayName("Test primes 🧮")
	@ParameterizedTest
	@ValueSource(ints = {3, 5, 7, 13, 17})
	void testIsPrime_valueSource(int n) {
		boolean result = PrimeFactor.isPrime(n);
		assertThat(result, is(true));
	}

	@DisplayName("Testing lots of ints for prime 🤓")
	@ParameterizedTest(name = "Is {arguments} prime❓👀")
	@MethodSource("intProvider")
	void testIsPrime_methodSource(int n) {
		boolean result = PrimeFactor.isPrime(n);
		assertThat(result, is(true));
	}

	static IntStream intProvider() {
		return IntStream.range(3, 20)
				.filter(n -> n % 2 == 1);
	}



	static Stream<Arguments> argumentsProvider() {
		return Stream.of(
				arguments( 1, Arrays.asList() ), //
				arguments( 2, Arrays.asList(2) ), //
				arguments( 3, Arrays.asList(3) ), //
				arguments( 4, Arrays.asList(2, 2) ), //
				arguments( 5, Arrays.asList(5) ), //
				arguments( 6, Arrays.asList(2, 3) ), //
				arguments( 7, Arrays.asList(7) ), //
				arguments( 8, Arrays.asList(2, 2, 2) ), //
				arguments( 9, Arrays.asList(3, 3) ), //
				arguments( 10, Arrays.asList(2, 5) ), //
				arguments( 12, Arrays.asList(2, 2, 3) ), //
				arguments( 16, Arrays.asList(2, 2, 2, 2) ), //
				arguments( 18, Arrays.asList(2, 3, 3) ), //
				arguments( 26, Arrays.asList(2, 13) ), //
				arguments( 99, Arrays.asList(3, 3, 11) ), //
				arguments( 101, Arrays.asList(101) ) //
		);
	}

}
