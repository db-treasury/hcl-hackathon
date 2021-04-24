package com.hcl.hackathon.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.hackathon.entity.JobDetails;
import com.hcl.hackathon.entity.Order;
import com.hcl.hackathon.entity.OrderRequest;
import com.hcl.hackathon.repository.JobDetailsRepository;
import com.hcl.hackathon.repository.OrderRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	JobDetailsRepository jobDetailsRepository;

	@Autowired
	OrderRepository orderRepository;

	@PostMapping("/create")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> startOrder(@Valid @RequestBody OrderRequest orderRequest) throws Exception {

		String username = orderRequest.getUsername();
		String startDate = orderRequest.getStartDate();
		String endDate = orderRequest.getEndDate();
		String outputFormat = orderRequest.getOutputFormat();

		Date startDateParsed = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
		Date endDateParsed = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);

		JobDetails jobDetails = new JobDetails();

		jobDetails.setEnd_date(endDateParsed);
		jobDetails.setJob_status("In Progress");
		jobDetails.setOutput_format(outputFormat);
		jobDetails.setStart_date(startDateParsed);
		jobDetails.setUsername(username);

		jobDetails = jobDetailsRepository.save(jobDetails);

		return ResponseEntity.ok(jobDetails);

	}

	@GetMapping("/status/{jobId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> checkJobStatus(@PathVariable(value = "jobId") long jobId) throws Exception {

		Optional<JobDetails> jobDetails = jobDetailsRepository.findById(jobId);
		return ResponseEntity.ok(jobDetails);

	}

	@GetMapping("/data/{jobId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getOrderData(@PathVariable(value = "jobId") long jobId) throws Exception {

		Optional<Order> orderData = orderRepository.findById(jobId);
		return ResponseEntity.ok(orderData);

	}
}
