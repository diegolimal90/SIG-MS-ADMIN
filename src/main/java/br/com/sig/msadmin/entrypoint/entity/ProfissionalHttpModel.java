package br.com.sig.msadmin.entrypoint.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	
	@JsonProperty("nome_profissional")
	private String nmProfissional;
	@JsonProperty("matricula")
	private String dsMatricula;
	@JsonProperty("data_nascimento")
	private String dtNasc;
	@JsonProperty("rg_profissional")
	private String nrRg;
	@JsonProperty("cpf_profissional")
	private String nrCpf;
	@JsonProperty("tipo_sanguineo")
	private String tpSanguineo;
	@JsonProperty("telefone")
	private String nrTelefone;
	@JsonProperty("email")
	private String dsEmail;
	@JsonProperty("observacao")
	private String dsObs;
	
	private EnderecoHttpModel endereco;
}
