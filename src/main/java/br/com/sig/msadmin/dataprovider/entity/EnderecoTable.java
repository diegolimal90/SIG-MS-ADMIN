package br.com.sig.msadmin.dataprovider.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="tbl_endereco")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoTable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tp_logradouro_id")
	private TipoLogradouroTable tpLogradouro;
	private String nmLogradouro;
	private String dsNumero;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="bairro_id")
	private BairroTable bairro;
	private String dsComplemento;
	private String nrCep;
	
//	@JsonBackReference
//	@OneToMany(mappedBy="endereco")
//	private List<AlunoTable> alunos;
//	
//	@JsonBackReference
//	@OneToMany(mappedBy="endereco", cascade=CascadeType.ALL)
//	private List<FuncionarioTable> funcionarios;	
	
}
