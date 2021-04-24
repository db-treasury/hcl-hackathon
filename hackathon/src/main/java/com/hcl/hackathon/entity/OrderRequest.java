package com.hcl.hackathon.entity;

import javax.validation.constraints.NotBlank;

public class OrderRequest {
	@NotBlank
	private String username;

	@NotBlank
	private String startDate;

	@NotBlank
	private String endDate;

	@NotBlank
	private String outputFormat;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getOutputFormat() {
		return outputFormat;
	}

	public void setOutputFormat(String outputFormat) {
		this.outputFormat = outputFormat;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
