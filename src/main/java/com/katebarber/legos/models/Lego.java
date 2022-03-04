package com.katebarber.legos.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="legos")
public class Lego {

	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotNull
	    @Size(min = 2, max = 100)
	    private String legoName;
		
	    @NotNull
	    @Size(min = 2, max = 200)
	    private String description;
	    
	    @NotNull
	    @Min(0)
	    private Integer numberPieces ;
	    
	    @NotNull
	    @Min(0)
	    private Integer modelNumber ;
	    
	    @NotNull
	    @DecimalMax("99999.00") @DecimalMin("0.0")
	    private Double price ;
	    
		@Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_Id")
	    private User user;
	    
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "rating", 
	        joinColumns = @JoinColumn(name = "lego_id"), 
	        inverseJoinColumns = @JoinColumn(name = "user_id")
	    )     
	    private List<User> users;
	    
	    
	    public Lego() {

	    }
	    
	    public Lego(String legoName) {
	    	this.legoName = legoName;
	    	
	    }
	    
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getLegoName() {
			return legoName;
		}

		public void setLegoName(String legoName) {
			this.legoName = legoName;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}



		public Integer getNumberPieces() {
			return numberPieces;
		}

		public void setNumberPieces(Integer numberPieces) {
			this.numberPieces = numberPieces;
		}

		public Integer getModelNumber() {
			return modelNumber;
		}

		public void setModelNumber(Integer modelNumber) {
			this.modelNumber = modelNumber;
		}

		public List<User> getUsers() {
			return users;
		}

		public void setUsers(List<User> users) {
			this.users = users;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

}