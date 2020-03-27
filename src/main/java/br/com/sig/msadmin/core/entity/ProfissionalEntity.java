package br.com.sig.msadmin.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfissionalEntity {
	
	private Long id;
	private String nmProfissional;
	private String dsMatricula;
	
	private EnderecoEntity endereco;
	private String dtNasc;
	private String nrRg;
	private String nrCpf;
	private String tpSanguineo;
	private String nrTelefone;
	private String dsEmail;
	private String dsObs;
	
}
