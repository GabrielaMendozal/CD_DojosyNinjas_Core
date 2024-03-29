package com.codingdojo.modelos;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table( name="dojos")
public class Dojo {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@OneToMany (mappedBy = "dojo", fetch = FetchType.LAZY)
	private List<Ninja> listaninjas;
	
	// Esto no permitirá que la columna createdAt se actualice después de la creación

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    

    @DateTimeFormat (pattern="yyyy-MM-dd")
    private Date updatedAt;


	public Dojo() {
	}


	public Dojo(Long id, String name, List<Ninja> listaninjas) {
		this.id = id;
		this.name = name;
		this.listaninjas = listaninjas;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Ninja> getListaninjas() {
		return listaninjas;
	}


	public void setListaninjas(List<Ninja> listaninjas) {
		this.listaninjas = listaninjas;
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
    
	//por defaut para fechas
	
		@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
		
		@PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
		
}
