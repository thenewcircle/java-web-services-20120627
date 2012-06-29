package guavademo;

import com.google.common.base.Function;

public class LengthFunction implements Function<String, Integer> {
	public Integer apply(String input) {
		return input.length();
	}
}
