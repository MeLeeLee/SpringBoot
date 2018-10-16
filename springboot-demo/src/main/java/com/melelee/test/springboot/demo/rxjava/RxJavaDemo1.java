package com.melelee.test.springboot.demo.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

/**
 * ceshi
 *
 * @author mengll
 * @create 2018-08-07 20:28
 **/
@Slf4j
public class RxJavaDemo1 {
	public static void main(String[] args) {
		Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
			@Override
			public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
				emitter.onNext(1);
				emitter.onNext(2);
				emitter.onNext(3);
				emitter.onComplete();
			}
		});
		
		//创建一个下游 Observer
		Observer<Integer> observer = new Observer<Integer>() {
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
		};
		//建立连接
		observable.subscribe(observer);
	}
}
