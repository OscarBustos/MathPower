package com.bustos.oscar.mathpower.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.bustos.oscar.mathpower.common.services.pythagoras.Pythagoras;

@Service
public class PythagorasService implements IPythagorasService {

	private static final double MINIMUM = 10;
	private static final double MAXIMUM = 1000;

	@Override
	public Pythagoras generateRandomPythagoras() {
		Random random = new Random();

		double catheti1 = (random.nextDouble() * (MAXIMUM - MINIMUM));

		double catheti2 = (random.nextDouble() * (MAXIMUM - MINIMUM));

		double hypotenuse = Math.sqrt(Math.pow(catheti1, 2) + Math.pow(catheti2, 2));
		Pythagoras pythagoras = new Pythagoras.Builder().catheti1(catheti1).catheti2(catheti2).hypotenuse(hypotenuse)
				.build();
		return pythagoras;
	}

}
