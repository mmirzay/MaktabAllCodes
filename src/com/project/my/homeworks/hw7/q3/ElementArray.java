package com.project.my.homeworks.hw7.q3;

import java.util.Random;

public class ElementArray {
	static String[][] names = new String[2][5];
	static String[][] symbols = new String[2][5];
	static int[][] atomicNumbers = new int[2][5];
	static double[][] atomicWeight = new double[2][5];
	static {
		names[0][0] = "Sodium";
		symbols[0][0] = "Na";
		atomicNumbers[0][0] = 11;
		atomicWeight[0][0] = 22.98977;

		names[0][1] = "Copper";
		symbols[0][1] = "Cu";
		atomicNumbers[0][1] = 29;
		atomicWeight[0][1] = 63.546;

		names[0][2] = "Potassium";
		symbols[0][2] = "K";
		atomicNumbers[0][2] = 19;
		atomicWeight[0][2] = 39.0983;

		names[0][3] = "Aluminum";
		symbols[0][3] = "Al";
		atomicNumbers[0][3] = 13;
		atomicWeight[0][3] = 26.98154;

		names[0][4] = "Mercury";
		symbols[0][4] = "Hg";
		atomicNumbers[0][4] = 80;
		atomicWeight[0][4] = 200.59;
	}

	static {
		names[1][0] = "Sulfur";
		symbols[1][0] = "S";
		atomicNumbers[1][0] = 16;
		atomicWeight[1][0] = 32.06;

		names[1][1] = "Carbon";
		symbols[1][1] = "C";
		atomicNumbers[1][1] = 6;
		atomicWeight[1][1] = 12.011;

		names[1][2] = "Phosphorus";
		symbols[1][2] = "P";
		atomicNumbers[1][2] = 15;
		atomicWeight[1][2] = 30.97376;

		names[1][3] = "Argon";
		symbols[1][3] = "Ar";
		atomicNumbers[1][3] = 18;
		atomicWeight[1][3] = 39.948;

		names[1][4] = "Neon";
		symbols[1][4] = "Ne";
		atomicNumbers[1][4] = 10;
		atomicWeight[1][4] = 20.179;
	}

	public static void main(String[] args) {
		Element[] elements = new Element[5];
		int metals = 0;
		int nonmetals = 0;
		Random random = new Random();
		for (int i = 0; i < 5; i++)
			elements[i] = random.nextInt(10) % 2 == 0
					? new MetalElement(names[0][metals], symbols[0][metals], atomicNumbers[0][metals],
							atomicWeight[0][metals++])
					: new NonMetalElement(names[1][nonmetals], symbols[1][nonmetals], atomicNumbers[1][nonmetals],
							atomicWeight[1][nonmetals++]);
		int row = 1;
		for (Element element : elements) {
			System.out.print("#" + row++ + "- ");
			element.describeElement();
			System.out.println("-".repeat(85));
		}
	}
}
