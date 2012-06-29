package guavademo;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class GuavaDemo {

	public static void main(String[] args) {
		List<String> foo = ImmutableList.copyOf(args);
		List<String> bar = Lists.transform(foo, new ToUpperCaseFunction());
		List<Integer> baz = Lists.transform(bar, new LengthFunction());
		System.out.println(bar);
		System.out.println(baz);
	}

}
