package com.SpringDemo.VerificationService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.SpringDemo.VerificationService.Domain.VerificationDetails;
import com.SpringDemo.VerificationService.Repository.VerificationDetailsRepository;


@Service
public class ApplicantInfoService {
	
	@Autowired
	VerificationDetailsRepository verificationDetailsRepository;
	
	@KafkaListener(topics="application_verification",containerFactory="ApplicantInfoDTOcontainer")
	public void storeapplicantInfo(String applicantDetails)  {
		System.out.println(applicantDetails);
		VerificationDetails verificationDetails=new VerificationDetails();
		verificationDetails.setApplicantDetails(applicantDetails);
		verificationDetailsRepository.save(verificationDetails);
		
	}

}
