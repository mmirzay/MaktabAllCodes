package com.project.my.classcodes.day0716.ir.javacup.traffic.impl;

import java.util.ArrayList;
import java.util.List;

import com.project.my.classcodes.day0716.ir.javacup.traffic.Observable;
import com.project.my.classcodes.day0716.ir.javacup.traffic.Subscriber;

public class TrafficObservable implements Observable<TrafficInfo> {
	List<Subscriber<TrafficInfo>> subscribers = new ArrayList<>();

	@Override
	public void push(TrafficInfo obj) {
		for (Subscriber<TrafficInfo> s : subscribers)
			s.onNext(obj);
	}

	@Override
	public void subscribe(Subscriber<TrafficInfo> subscriber) {
		subscribers.add(subscriber);
	}

}
