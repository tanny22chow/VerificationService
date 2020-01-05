package com.SpringDemo.VerificationService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.SpringDemo.VerificationService.Service.VerificationDetailService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/verificationdetailcontroller")
public class VerificationDetailController {

	@Autowired
	VerificationDetailService verificationDetailService;

	@ApiOperation(value = "Verifies existing application details", consumes = "application/json")
	@GetMapping(path = "/verify", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> verifyapplicantDetails(@RequestParam Long verificationid) {
		try {
			verificationDetailService.addVerification(verificationid);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
