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

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="tbl_profissional")
public class ProfissionalTable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nmProfissional;
	private String dsMatricula;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="endereco_id")
	private EnderecoTable endereco;
	private String dtNasc;
	private String nrRg;
	private String nrCpf;
	private String tpSanguineo;
	private String nrTelefone;
	private String dsEmail;
	private String dsObs;
}
