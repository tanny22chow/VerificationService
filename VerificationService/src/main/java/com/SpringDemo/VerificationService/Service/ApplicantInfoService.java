package com.SpringDemo.VerificationService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.SpringDemo.VerificationService.AppDTO.ApplicantDTO;
import com.SpringDemo.VerificationService.Domain.VerificationDetails;
import com.SpringDemo.VerificationService.Repository.VerificationDetailsRepository;


@Service
public class ApplicantInfoService {
	
	
	private VerificationDetails verificationDetails;
	@Autowired
	VerificationDetailsRepository verificationDetailsRepository;
	
	@KafkaListener(topics="application_verification",containerFactory="ApplicantInfoDTOcontainer")
	public void storeapplicantInfo(ApplicantDTO applicant) {
		System.out.println(applicant.toString());
		verificationDetails.setApplicantDetails(applicant.toString());
		verificationDetailsRepository.save(verificationDetails);
		
	}

}
