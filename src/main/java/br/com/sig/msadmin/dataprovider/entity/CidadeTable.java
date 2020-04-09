package br.com.sig.msadmin.dataprovider.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="tbl_cidade")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CidadeTable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_estado")
	private EstadoTable estado;
	private String nmCidade;
	
	@JsonBackReference
	@OneToMany(mappedBy="cidade")
	private List<BairroTable> bairros;
	
		
}
