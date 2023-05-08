package com.callor.classes;

import java.util.ArrayList;
import java.util.List;

import com.callor.models.AnimalDto;

public class ExecE {
	public static void main(String[] args) {
		List<AnimalDto> animalList = new ArrayList<>();
		AnimalDto animal = new AnimalDto("럭키", "허스키", 5);
		animalList.add(animal);
		animal = new AnimalDto("나비", "버밀라", 3);
		animalList.add(animal);
		animal = new AnimalDto("몽", "스피츠", 7);
		animalList.add(animal);
		
		System.out.println(animalList);
	}
}
