package com.model;

import javax.persistence.*;

import lombok.Data;
@Data
@Entity
public class ServiceRating {
	enum Rating { Worst, Poor, Good, Great }
	@Id
	@GeneratedValue
	private int serviceRatingId;
	@OneToOne
	@JoinColumn(name="fk_request_id")
	private Request request;
	private Rating rating;
	
	
}
