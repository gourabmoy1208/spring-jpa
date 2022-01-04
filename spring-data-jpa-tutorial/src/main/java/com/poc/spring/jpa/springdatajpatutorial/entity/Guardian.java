package com.poc.spring.jpa.springdatajpatutorial.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({
	@AttributeOverride(
				name = "guardianName", 
				column= @Column(name = "guardian_name")
		),
		@AttributeOverride(
				name = "guardianEmail", 
				column= @Column(name = "guardian_email")
		),
		@AttributeOverride(
				name = "guardianMobile", 
				column= @Column(name = "guardian_mobile")
		)
	})
public class Guardian {

	private String guardianName;
	private String guardianEmail;
	private String guardianMobile;
	

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getGuardianEmail() {
		return guardianEmail;
	}

	public void setGuardianEmail(String guardianEmail) {
		this.guardianEmail = guardianEmail;
	}

	public String getGuardianMobile() {
		return guardianMobile;
	}

	public void setGuardianMobile(String guardianMobile) {
		this.guardianMobile = guardianMobile;
	}
}
