package com.melelee.test.springboot.demo.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ceshi
 *
 * @author mengll
 * @create 2018-08-07 20:28
 **/
@Slf4j
public class RxJavaDemo {
	public static void main(String[] args) {
		List<String> collected = new ArrayList<>();
		collected.add("alpha");
		collected.add("beta");

		collected = collected.stream().map(new Function<String, String>() {
			@Override
			public String apply(String string) {
				return string.toUpperCase();
			}
		}).collect(Collectors.toList());

		collected = collected.stream().map(string -> string.toUpperCase()).collect(Collectors.toList());

		collected = collected.stream().map(String::toUpperCase).collect(Collectors.toList());



		System.out.println(collected);

		Observable.create(new ObservableOnSubscribe<Integer>() {
			@Override
			public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
				emitter.onNext(1);
				emitter.onNext(2);
				emitter.onNext(3);
				emitter.onComplete();
			}
		}).subscribe(new Observer<Integer>() {
			@Override
			public void onSubscribe(Disposable d) {
				log.info("subscribe");
			}

			@Override
			public void onNext(Integer value) {
				log.info("" + value);
			}

			@Override
			public void onError(Throwable e) {
				log.info("error");
			}

			@Override
			public void onComplete() {
				log.info("complete");
			}
		});
	}
}
