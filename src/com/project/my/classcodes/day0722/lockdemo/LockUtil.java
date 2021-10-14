package com.project.my.classcodes.day0722.lockdemo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LockUtil {
	private final static ConcurrentMap<String, ConcurrentMap<MessageEntity, Date>> lockMap = new ConcurrentHashMap<>();

	public static List<Boolean> putAllAndCheck(String source, List<MessageEntity> dests) {
		List<Boolean> result = new ArrayList<>();
//		put(source, "");
		for (MessageEntity dest : dests) {
			result.add(put(source, dest));
		}
		return result;
	}

	private static boolean put(String source, MessageEntity dest) {
		checkAndPutKey(source);
		if (checkLockAndPutValue(source, dest)) {
			return true;
		} else {
			return setNewTime(source, dest);
		}
	}

	private static void checkAndPutKey(String key) {
		if (!lockMap.containsKey(key)) {
			lockMap.put(key, new ConcurrentHashMap<>());
		}
	}

	private static boolean checkLockAndPutValue(String key, MessageEntity value) {
		ConcurrentMap<MessageEntity, Date> destMap = lockMap.get(key);
		if (!destMap.containsKey(value)) {
			destMap.put(value, new Date());
			return true;
		}
		return false;
	}

	private static boolean setNewTime(String key, MessageEntity value) {
		ConcurrentMap<MessageEntity, Date> destMap = lockMap.get(key);
		if (System.currentTimeMillis() - destMap.get(value).getTime() > 40000) {
			destMap.put(value, new Date());
			return true;
		}
		return false;
	}
}
