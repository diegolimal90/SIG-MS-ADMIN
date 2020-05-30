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
	@JoinColumn(name="id_tp_logradouro")
	private TipoLogradouroTable tpLogradouro;
	private String nmLogradouro;
	private String dsNumero;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_bairro")
	private BairroTable bairro;
	private String dsComplemento;
	private String nrCep;
	
	@JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cliente_id")
	private ClienteTable cliente;

	@JsonBackReference
    @ManyToOne
    @JoinColumn(name = "responsavel_id")
	private ResponsavelTable responsavel;
	
	@JsonBackReference
	@OneToMany(mappedBy="endereco")
	private List<ProfissionalTable> profissionais;	
	
}
