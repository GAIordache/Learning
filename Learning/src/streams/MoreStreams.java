package streams;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MoreStreams {

	public static void main(String[] args) {
		int[] values = { 3, 4, 1, 5, 20, 1, 3, 3, 4, 6 };

		System.out.println("The values are ");
		IntStream.of(values).forEach(System.out::print);

		System.out.println(
				"\nThe result of multiplying all values is " + IntStream.of(values).reduce(1, (e1, e2) -> e1 * e2));

		System.out.println("The values are "
				+ IntStream.of(values).mapToObj(e -> e + "").reduce((e1, e2) -> e1 + ", " + e2).get());

		String[] names = { "John", "Peter", "Susan", "Kim", "Jen", "George", "Alan", "Stacy", "Michelle", "john" };

		System.out.print("Total number of characters: ");
		System.out.println(Stream.of(names).reduce((x, y) -> x + y).get().length());

		StringBuilder sb = Stream.of(names).collect(() -> new StringBuilder(), (c, e) -> c.append(e),
				(c1, c2) -> c1.append(c2));
		StringBuilder sb2 = Stream.of(names).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);

		System.out.println("The number of characters for all names: "
				+ Stream.of(names).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).length());

		ArrayList<String> list = Stream.of(names).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println(list);

		list = (ArrayList<String>) Stream.of(names).collect(Collectors.toList());

		Set<String> set = Stream.of(names).collect(Collectors.toSet());
		System.out.println(set);

		Map<String, Integer> map = Stream.of(names).collect(Collectors.toMap(e -> e, e -> e.length()));
		System.out.println(map);

		System.out.println("The total number of characters is "
				+ Stream.of(names).collect(Collectors.summingInt(e -> e.length())));

		java.util.IntSummaryStatistics stats = Stream.of(names).collect(Collectors.summarizingInt(e -> e.length()));
		System.out.println("Max is " + stats.getMax());
		System.out.println("Min is " + stats.getMin());
		System.out.println("Average is " + stats.getAverage());
		
		Map<Character, Long> map2 = Stream.of(names).collect(Collectors.groupingBy(e -> e.charAt(0), Collectors.counting()));
		System.out.println(map2);

	}

}
