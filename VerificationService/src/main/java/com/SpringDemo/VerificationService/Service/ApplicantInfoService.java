package com.SpringDemo.VerificationService.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.SpringDemo.VerificationService.AppDTO.ApplicantDTO;


@Service
public class ApplicantInfoService {
	
	@KafkaListener(topics="application_verification",containerFactory="ApplicantInfoDTOcontainer")
	public void storeapplicantInfo(ApplicantDTO applicant) {
		System.out.println(applicant.toString());
	}

}
