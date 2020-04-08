package br.com.sig.msadmin.core.entity;

import java.time.LocalDate;

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
	private LocalDate dtNasc;
	private Integer nrRg;
	private Integer nrCpf;
	private String tpSanguineo;
	private String nrTelefone;
	private String dsEmail;
	private String dsObs;
	
	private TipoProfissionalEntity tpProfissional;
	private EnderecoEntity endereco;
}
