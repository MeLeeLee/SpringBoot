package com.melelee.test.springboot.demo.stream;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试
 *
 * @author mengll
 * @create 2018-08-15 19:34
 **/
public class StreamTest {
	public static void main(String[] args) {
		List<Integer> integers = Lists.newArrayList(1,2,3,4,5,7,4);
		System.out.println(integers.stream().filter(i->i<5).count());
		integers.stream().forEach(integer -> System.out.print(integer));
		System.out.println();
		integers.stream().distinct().forEach(integer -> System.out.print(integer));
		System.out.println();
		integers.stream().map(var -> { var ++; var += 2; return var; }).forEach(System.out::print);
		System.out.println();

		integers.stream().map(integer -> integer+100).forEach(integer -> System.out.print(integer));
		System.out.println();

		List<Integer> a= Arrays.asList(1,2);
		List<Integer> b=Arrays.asList(3,4);
		Stream.of(a,b).flatMap(u->u.stream()).forEach(System.out::println);
	}
}
