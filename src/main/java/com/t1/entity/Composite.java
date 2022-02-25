package com.t1.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Composite implements Serializable{

	private String username; 
	private String pkmName; 
	
}
