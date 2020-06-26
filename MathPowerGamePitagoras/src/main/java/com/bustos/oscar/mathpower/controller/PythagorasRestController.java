package com.bustos.oscar.mathpower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bustos.oscar.mathpower.common.services.pythagoras.Pythagoras;
import com.bustos.oscar.mathpower.service.IPythagorasService;

@RestController
public class PythagorasRestController {

	@Autowired
	IPythagorasService pythagorasService;

	@GetMapping(path = "/random/pitagoras")
	public ResponseEntity<Pythagoras> generarPythagorasRandom() {
		Pythagoras pythagoras = pythagorasService.generateRandomPythagoras();
		return new ResponseEntity<Pythagoras>(pythagoras, HttpStatus.OK);
	}
}
