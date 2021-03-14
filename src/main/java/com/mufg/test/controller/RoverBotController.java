package com.mufg.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mufg.test.bean.InputPosition;
import com.mufg.test.bean.OutputPosition;
import com.mufg.test.service.CalculateFinalPosition;

@RestController
public class RoverBotController {
	
	@Autowired
	CalculateFinalPosition calculateFinalPosition;
	
	@GetMapping("/final-position")
	public OutputPosition findFinalPosition(@RequestBody InputPosition input)
	{
		return calculateFinalPosition.getFinalPosition(input);
	}

}
