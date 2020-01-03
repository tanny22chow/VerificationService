package com.SpringDemo.VerificationService.Domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import com.SpringDemo.VerificationService.AppDTO.ApplicantDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class VerificationDetails implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "verification_id")
	private Long verification_id;
	@ColumnDefault("null")
	private String verifier_name;
	@CreatedDate
	private LocalDate verifyDate;
	@Lob
	private String applicantDetails;
	@ColumnDefault("verification pending")
	private String status;

}
