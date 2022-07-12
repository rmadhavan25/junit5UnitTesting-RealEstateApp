package com.realestateapp;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.math.BigDecimal;

import org.junit.jupiter.api.RepeatedTest;

public class RandomApartmentGeneratorTest {
	
	@RepeatedTest(5)
	void should_GenerateCorrectApartment_When_DefaultMinAreaMinPrice() {
		//given
		
		//when

		//then
		assertInstanceOf(Apartment.class, new RandomApartmentGenerator().generate());
	}
	
	@RepeatedTest(5)
	void should_GenerateCorrectApartment_When_CustomMinAreaMinPrice() {
		//given
		double minArea = 50.0;
		BigDecimal minPricePerSquareMeter = new BigDecimal(7000.0);
		
		//when
		
		//then
		assertInstanceOf(Apartment.class, new RandomApartmentGenerator(minArea, minPricePerSquareMeter).generate());
	}
}
