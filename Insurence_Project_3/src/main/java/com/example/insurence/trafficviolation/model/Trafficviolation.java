package com.example.insurence.trafficviolation.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Table(name= "trafficviolation")
public class Trafficviolation {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int traffic_id;
	    
	    @Override
	public String toString() {
		return "trafficviolation [traffic_id=" + traffic_id + ", violationtype=" + violationtype + ", vehicleNumber="
				+ vehicleNumber + ", driverName=" + driverName + ", date=" + date + ", fineAmount=" + fineAmount + "]";
	}
		private String violationtype;
	    private String vehicleNumber;
	    private String driverName;
	    private String date;
	    private int fineAmount;

		public int getTraffic_id() {
			return traffic_id;
		}
		public void setTraffic_id(int traffic_id) {
			this.traffic_id = traffic_id;
		}
		public String getViolationtype() {
			return violationtype;
		}
		public void setViolationtype(String violationtype) {
			this.violationtype = violationtype;
		}
		public String getVehicleNumber() {
			return vehicleNumber;
		}
		public void setVehicleNumber(String vehicleNumber) {
			this.vehicleNumber = vehicleNumber;
		}
		public String getDriverName() {
			return driverName;
		}
		public void setDriverName(String driverName) {
			this.driverName = driverName;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public int getFineAmount() {
			return fineAmount;
		}
		public void setFineAmount(int fineAmount) {
			this.fineAmount = fineAmount;
		}
	    
}
