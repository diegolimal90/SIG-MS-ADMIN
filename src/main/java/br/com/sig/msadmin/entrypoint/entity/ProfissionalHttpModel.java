package br.com.sig.msadmin.entrypoint.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfissionalHttpModel {

	private Long id;
	private String nmProfissional;
	private String dsMatricula;	
	private String dtNasc;
	private String nrRg;
	private String nrCpf;
	private String tpSanguineo;
	private String nrTelefone;
	private String dsEmail;
	private String dsObs;
	private EnderecoHttpModel endereco;
}
