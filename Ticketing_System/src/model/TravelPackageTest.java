package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class TravelPackageTest {

	TravelPackage pack;
	
	@Test 
	void activatePackageTest1() {
		pack = new TravelPackage();
		assertEquals(true, pack.activatePackage(77, 2));
	}

	@Test
	void activatePackageTest2() {
		pack = new TravelPackage();
		assertEquals(false, pack.activatePackage(1, 2));
	}
	
	@Test
	void getPackagesTest() {
		pack = new TravelPackage();
		List<TravelPackage> list = pack.getPackages();
		assertEquals(0, list.size());
	}
	
	@Test
	void getPackagesTest2() {
		pack = new TravelPackage();
		List<TravelPackage> list = pack.getPackages();
		assertEquals(2, list.size());
	}
}
