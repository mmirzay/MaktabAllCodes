package com.project.my.homeworks.hw14.forfun.lambdautil;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public class LambdaUtil {

	/**
	 * Returns {@link Supplier} that always supply "Hello"
	 *
	 * @return a string supplier
	 */
	public static Supplier<String> helloSupplier() {
		return () -> "Hello";
	}

	/**
	 * Returns a {@link Predicate} of string that checks if string is empty
	 *
	 * @return a string predicate
	 */
	public static Predicate<String> isEmptyPredicate() {
		return s -> s.isEmpty();
	}

	/**
	 * Return a {@link Function} that accepts {@link String} and returns that string
	 * repeated n time, where n is passed as function argument
	 *
	 * @return function that repeats Strings
	 */
	public static BiFunction<String, Integer, String> stringMultiplier() {
		return (s, n) -> s.repeat(n);
	}

	/**
	 * Returns a {@link Function} that converts a {@link BigDecimal} number into a
	 * {@link String} that start with a dollar sign and then gets a value
	 *
	 * @return function that converts adds dollar sign
	 */
	public static Function<BigDecimal, String> toDollarStringFunction() {
		return b -> "$" + b.toString();
	}

	/**
	 * Receives two parameter that represent a range and returns a
	 * {@link Predicate<String>} that verifies if string length is in the specified
	 * range. E.g. min <= length < max
	 *
	 * @param min min length
	 * @param max max length
	 * @return a string predicate
	 */
	public static Predicate<String> lengthInRangePredicate(int min, int max) {
		return s -> s.length() >= min && s.length() < max;
	}

	/**
	 * Returns a {@link Supplier} of random integers
	 *
	 * @return int supplier
	 */
	public static IntSupplier randomIntSupplier() {
		return () -> new Random().nextInt();
	}

	/**
	 * Returns an {@link IntUnaryOperator} that receives an int as a bound
	 * parameter, and returns a random int
	 *
	 * @return int operation
	 */
	public static IntUnaryOperator boundedRandomIntSupplier() {
		return i -> new Random().nextInt(i);
	}

	/**
	 * Returns {@link IntUnaryOperator} that calculates an integer square
	 *
	 * @return square operation
	 */
	public static IntUnaryOperator intSquareOperation() {
		return i -> i * i;
	}

	/**
	 * Returns a {@link LongBinaryOperator} sum operation.
	 *
	 * @return binary sum operation
	 */
	public static LongBinaryOperator longSumOperation() {
		// todo
		return (l, r) -> l + r;
	}

	/**
	 * Returns a {@link ToIntFunction<String>} that converts string to integer.
	 *
	 * @return string to int converter
	 */
	public static ToIntFunction<String> stringToIntConverter() {
		return s -> Integer.parseInt(s);
	}

	/**
	 * Receives int parameter n, and returns a {@link Supplier} that supplies
	 * {@link IntUnaryOperator} that is a function f(x) = n * x
	 *
	 * @param n a multiplier
	 * @return a function supplier
	 */
	public static Supplier<IntUnaryOperator> nMultiplyFunctionSupplier(int n) {
		return () -> i -> i * n;
	}

	/**
	 * Returns {@link Supplier} of {@link Supplier} of {@link Supplier} of
	 * {@link String} "WELL DONE".
	 *
	 * @return a supplier instance
	 */
	public static Supplier<Supplier<Supplier<String>>> trickyWellDoneSupplier() {
		return () -> () -> () -> "WELL DONE";
	}

	/**
	 * Returns a {@link UnaryOperator} that accepts str to str function and returns
	 * the same function composed with trim
	 *
	 * @return function that composes functions with trim() function
	 */
	public static UnaryOperator<Function<String, String>> composeWithTrimFunction() {
		return f -> f.andThen(s -> s.trim());
	}

	/**
	 * Returns a {@link BiFunction} that has two parameters. First is
	 * {@link IntUnaryOperator} which is some integer function. Second is
	 * {@link IntPredicate} which is some integer condition. And the third is
	 * {@link IntUnaryOperator} which is a new composed function that uses provided
	 * predicate (second parameter of binary function) to verify its input
	 * parameter. If predicate returns {@code true} it applies a provided integer
	 * function (first parameter of binary function) and returns a result value,
	 * otherwise it returns an element itself.
	 *
	 * @return a binary function that receiver predicate and function and compose
	 *         them to create a new function
	 */
	public static BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator> functionToConditionalFunction() {
		return (t, u) -> i -> u.test(i) ? t.applyAsInt(i) : i;
	}

	/**
	 * Returns a {@link BiFunction} which first parameter is a {@link Map} where key
	 * is a function name, and value is some {@link IntUnaryOperator}, and second
	 * parameter is a {@link String} which is a function name. If the map contains a
	 * function by a given name then it is returned by high order function otherwise
	 * an identity() is returned.
	 *
	 * @return a high-order function that fetches a function from a function map by
	 *         a given name or returns identity()
	 */
	public static BiFunction<Map<String, IntUnaryOperator>, String, IntUnaryOperator> functionLoader() {
		return (m, s) -> Optional.ofNullable(m.get(s)).orElse(IntUnaryOperator.identity());
	}
}
