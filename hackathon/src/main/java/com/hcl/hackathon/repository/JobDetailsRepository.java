package com.hcl.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.hackathon.entity.JobDetails;

@Repository
public interface JobDetailsRepository extends JpaRepository<JobDetails, Long> {
}
