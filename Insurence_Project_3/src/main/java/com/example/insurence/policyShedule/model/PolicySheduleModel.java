package com.example.insurence.policyShedule.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "policyschedule")

public class PolicySheduleModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long policyId;
	    private String startDate;
	    private String endDate;
	    private String premium;
		public PolicySheduleModel() {
			super();
			// TODO Auto-generated constructor stub
		}
		public PolicySheduleModel(Long policyId, String startDate, String endDate, String premium) {
			super();
			this.policyId = policyId;
			this.startDate = startDate;
			this.endDate = endDate;
			this.premium = premium;
		}
		public Long getPolicyId() {
			return policyId;
		}
		public void setPolicyId(Long policyId) {
			this.policyId = policyId;
		}
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
		public String getPremium() {
			return premium;
		}
		public void setPremium(String premium) {
			this.premium = premium;
		}
		@Override
		public String toString() {
			return "Policyschedule [policyId=" + policyId + ", startDate=" + startDate + ", endDate=" + endDate
					+ ", premium=" + premium + "]";
		}
	    
	    

	
}
