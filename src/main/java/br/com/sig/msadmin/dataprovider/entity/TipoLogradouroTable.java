package br.com.sig.msadmin.dataprovider.entity;

import java.util.List;

import javax.persistence.CascadeType;
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

@Entity(name="tbl_tp_logradouro")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoLogradouroTable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nmTpLogradouro;
	
	@JsonBackReference
	@OneToMany(mappedBy="tpLogradouro", cascade = CascadeType.ALL)
	private List<EnderecoTable> enderecos;
}
