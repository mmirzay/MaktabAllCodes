package com.project.my.classcodes.day0716.ir.javacup.traffic.impl;

import java.util.Base64;

import com.project.my.classcodes.day0716.ir.javacup.traffic.Transformer;

public class TrafficInfoTransformer implements Transformer<TrafficInfo, String> {

	@Override
	public TrafficInfo transform(String input) {
		byte[] decode = null;

		try {
			decode = Base64.getDecoder().decode(input);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("decoding is not valid", e);
		}

		String strInfo = new String(decode);
		if (strInfo.contains(",") == false)
			throw new IllegalArgumentException("no virgol");

		String[] trafficInfoString = strInfo.split(",");
		if (trafficInfoString.length != 2) // traffic info has only two informations.
			throw new IllegalArgumentException("not valid info");

		String locationCode = trafficInfoString[0].trim();

		int trafficLevel = 0;
		try {
			trafficLevel = Integer.parseInt(trafficInfoString[1]);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("traffic level is not valid");
		}

		TrafficInfo trafficInfo = new TrafficInfo();
		trafficInfo.setLocationCode(locationCode);
		trafficInfo.setTrafficLevel(trafficLevel);
		return trafficInfo;

	}

}
