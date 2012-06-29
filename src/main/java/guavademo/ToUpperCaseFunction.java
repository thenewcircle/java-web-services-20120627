package guavademo;

import com.google.common.base.Function;

public class ToUpperCaseFunction implements Function<String, String> {
	public String apply(String input) {
		return input.toUpperCase();
	}
}
