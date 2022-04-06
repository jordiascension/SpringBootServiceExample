package com.capgemini.demo.controller;

import javax.validation.constraints.Max;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("pension-plan")
@RestController
@Validated
public class PensionPlanController {

	@PostMapping("/deduct")
	public double deduct(
			@RequestParam("personPensionPlan") @Max(1500) double personPensionPlan,
			@RequestParam("companyPensionPlan") @Max(8500) double companyPensionPlan,
			double taxBase) {
		double deduction = 0;
		double totalPensionPlan = personPensionPlan + companyPensionPlan;

		if (taxBase >= 12450 && taxBase < 20200) {
			deduction = totalPensionPlan * 24 / 100;
		} else if (taxBase >= 20200 && taxBase < 35200) {
			deduction = totalPensionPlan * 30 / 100;
		} else if (taxBase >= 35200 && taxBase < 60000) {
			deduction = totalPensionPlan * 37 / 100;
		} else if (taxBase >= 60000 && taxBase < 300000) {
			deduction = totalPensionPlan * 45 / 100;
		} else if (taxBase > 300000) {
			deduction = totalPensionPlan * 47 / 100;
		} else {
			deduction = 0;
		}

		return deduction;
	}

}
