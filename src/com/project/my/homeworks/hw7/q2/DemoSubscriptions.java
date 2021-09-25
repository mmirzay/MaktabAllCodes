package com.project.my.homeworks.hw7.q2;

public class DemoSubscriptions {
	public static void main(String[] args) {
		NewspaperSubscription physicalNewspaperSubscription1 = new PhysicalNewspaperSubscription("test1");
		physicalNewspaperSubscription1.setAddress("mohsenmirza%$#@#");
		System.out.println(physicalNewspaperSubscription1.toString());
		NewspaperSubscription physicalNewspaperSubscription2 = new PhysicalNewspaperSubscription("test2");
		physicalNewspaperSubscription2.setAddress("mohsen899mirza%$#@#");
		System.out.println(physicalNewspaperSubscription2.toString());

		NewspaperSubscription onlineNewspaperSubscription1 = new OnlineNewspaperSubscription("test3");
		onlineNewspaperSubscription1.setAddress("12127yrejkj0sd4$");
		System.out.println(onlineNewspaperSubscription1.toString());
		NewspaperSubscription onlineNewspaperSubscription2 = new OnlineNewspaperSubscription("test4");
		onlineNewspaperSubscription2.setAddress("mohsen899mirza%$#@#");
		System.out.println(onlineNewspaperSubscription2.toString());
	}
}
