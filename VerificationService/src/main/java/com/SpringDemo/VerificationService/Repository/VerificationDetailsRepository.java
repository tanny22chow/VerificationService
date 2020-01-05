package com.SpringDemo.VerificationService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.SpringDemo.VerificationService.Domain.VerificationDetails;

@Repository
public interface VerificationDetailsRepository extends JpaRepository<VerificationDetails, Long>,QuerydslPredicateExecutor<VerificationDetails> {

}
