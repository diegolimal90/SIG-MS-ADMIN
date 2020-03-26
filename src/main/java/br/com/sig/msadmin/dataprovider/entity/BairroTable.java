package br.com.sig.msadmin.dataprovider.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="tbl_bairro")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BairroTable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nmBairro;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="cidade_id")
	private CidadeTable cidade;
	
	@OneToMany(mappedBy="bairro", cascade = CascadeType.ALL)
	private List<EnderecoTable> enderecos;
}
