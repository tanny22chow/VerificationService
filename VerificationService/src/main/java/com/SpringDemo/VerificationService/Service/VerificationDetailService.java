package com.SpringDemo.VerificationService.Service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.SpringDemo.VerificationService.AppDTO.ApplicantDTO;
import com.SpringDemo.VerificationService.AppDTO.VerificationServiceResponseDTO;
import com.SpringDemo.VerificationService.Domain.QVerificationDetails;
import com.SpringDemo.VerificationService.Domain.VerificationDetails;
import com.SpringDemo.VerificationService.Repository.VerificationDetailsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.models.Response;

@Service
public class VerificationDetailService {

	@Autowired
	VerificationDetailsRepository verificationDetailsRepository;

	@Autowired
	KafkaTemplate<Long, Object> kafkaTemplate;

	public void addVerification(Long id) {
		VerificationDetails detail=verificationDetailsRepository.findById(id).get();
		detail.setStatus("verified");
		verificationDetailsRepository.save(detail);
	}

	@Scheduled(cron = "0/59 * * * * *")
	public void updateApplicationDetailService() {
		List<VerificationDetails> verificationDetailsList = (List<VerificationDetails>) verificationDetailsRepository
				.findAll(QVerificationDetails.verificationDetails.status.eq("verified"));
		verificationDetailsList.forEach(detail -> {
			ObjectMapper mapper = new ObjectMapper();
			try {
				ApplicantDTO applicant = mapper.readValue(detail.getApplicantDetails(), ApplicantDTO.class);
				VerificationServiceResponseDTO respone=new VerificationServiceResponseDTO();
				respone.setIdentification_num(applicant.getIdentification_num());
				respone.setStatus(detail.getStatus());
				kafkaTemplate.send("Verify_Acknowlegdement", respone);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

		});
	}
}
