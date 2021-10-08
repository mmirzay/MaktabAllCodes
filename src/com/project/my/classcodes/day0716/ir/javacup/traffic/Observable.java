package com.project.my.classcodes.day0716.ir.javacup.traffic;

public interface Observable<T> {

	void push(T obj);

	void subscribe(Subscriber<T> subscriber);

}
