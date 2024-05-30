package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "premium_detail")
public class PremiumDetail {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column(name = "premiumType")
	    private String premiumType;
	    
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "user_id")
	    private User user;

		public PremiumDetail() {
			super();
			// TODO Auto-generated constructor stub
		}

		public PremiumDetail(Long id, String premiumType, User user) {
			super();
			this.id = id;
			this.premiumType = premiumType;
			this.user = user;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getPremiumType() {
			return premiumType;
		}

		public void setPremiumType(String premiumType) {
			this.premiumType = premiumType;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		@Override
		public String toString() {
			return "PremiumDetail [id=" + id + ", premiumType=" + premiumType + ", user=" + user + "]";
		}
	    
	    

}
