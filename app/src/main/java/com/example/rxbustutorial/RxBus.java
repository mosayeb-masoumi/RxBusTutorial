package com.example.rxbustutorial;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;

public class RxBus {

        //this how to create our bus
        private static final BehaviorSubject<Object> behaviorSubject = BehaviorSubject.create();

        public static Disposable subscribeModel(@NonNull Consumer<Object> action) {
            return behaviorSubject.subscribe(action);
        }

        public static void publishModel(@NonNull Object message) {
            behaviorSubject.onNext(message);
        }
}
