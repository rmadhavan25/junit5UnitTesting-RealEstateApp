package com.realestateapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ApartmentRaterTest {

	@ParameterizedTest(name= "apartmentArea={0}, apartmentPrice={1}, expectedRating={2}")
	@CsvSource(value = {"30.0,3000.0,0","30.0,200000.0,1","30.0,300000.0,2"})
	void should_ReturnCorrectRating_When_CorrectApartment(Double apartmentArea,BigDecimal apartmentPrice,int expectedRating){
		//given
		double area = apartmentArea;
		BigDecimal price = apartmentPrice;
		
		//when
		int acctualRating = ApartmentRater.rateApartment(new Apartment(area, price));
		
		//then
		assertEquals(acctualRating, expectedRating);
	}
	
	@Test
	void should_ReturnErrorValue_When_IncorrectApartment() {
		
		//given
		double area = 0.0;
		BigDecimal price = new BigDecimal(3000.0);
		
		//when
		int apartmentRate = ApartmentRater.rateApartment(new Apartment(area, price));
		
		//then
		assertEquals(apartmentRate, -1);
		
	}
	
	@Test
	void should_CalculateAverageRating_When_CorrectApartmentList() {
		//given
		List<Apartment> apartments = new ArrayList<Apartment>();
		apartments.add(new Apartment(30.0,new BigDecimal(3000.0)));
		apartments.add(new Apartment(30.0,new BigDecimal(300000.0)));
		apartments.add(new Apartment(30.0,new BigDecimal(205678.0)));
		apartments.add(new Apartment(30.0,new BigDecimal(300001.0)));
		
		double expectedAverageRating = 1.25;
		
		//when
		double actualAverageRating = ApartmentRater.calculateAverageRating(apartments);
		
		//then
		assertEquals(actualAverageRating,expectedAverageRating);
	}
	
	@Test
	void should_ThrowExceptionInCalculateAverageRating_When_EmptyApartmentList(){
		//given
		List<Apartment> apartments = new ArrayList<Apartment>();
		
		//when
		Executable executable = () -> ApartmentRater.calculateAverageRating(apartments);
		
		//then
		assertThrows(RuntimeException.class, executable);
	}
}
