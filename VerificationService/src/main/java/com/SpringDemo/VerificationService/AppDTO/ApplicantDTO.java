package com.SpringDemo.VerificationService.AppDTO;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown=true)
public class ApplicantDTO implements Serializable {
	
    private String identification_num;
    private String name;
    private int age;
    private List<AdressDTO> address;

}