package com.hcl.hackathon.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "s3_job_details", uniqueConstraints = { @UniqueConstraint(columnNames = "job_id") })
public class JobDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long job_id;

	@NotBlank
	@Size(max = 50)
	private String username;

	private Date start_date;

	private Date end_date;

	@NotBlank
	@Size(max = 50)
	private String output_format;

	@NotBlank
	@Size(max = 50)
	private String job_status;

	public JobDetails() {
	}

	public Long getJob_id() {
		return job_id;
	}

	public void setJob_id(Long job_id) {
		this.job_id = job_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getOutput_format() {
		return output_format;
	}

	public void setOutput_format(String output_format) {
		this.output_format = output_format;
	}

	public String getJob_status() {
		return job_status;
	}

	public void setJob_status(String job_status) {
		this.job_status = job_status;
	}

}
