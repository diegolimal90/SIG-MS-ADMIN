package br.com.sig.msadmin.dataprovider.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="tbl_estado")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadoTable implements Serializable{
	private static final long serialVersionUID = 8641420559747293848L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nmEstado;
	private String sgEstado;
	
	@JsonBackReference
	@OneToMany(mappedBy="estado")
	private List<CidadeTable> cidades;
	
}
