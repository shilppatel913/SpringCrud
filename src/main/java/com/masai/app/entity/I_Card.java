package com.masai.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="I_Card")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class I_Card {

	@Id
	private int idCardNo;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "icard")
	@JsonIgnore
	private Student student;
}
