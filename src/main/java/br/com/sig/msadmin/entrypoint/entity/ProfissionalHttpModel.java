package br.com.sig.msadmin.entrypoint.entity;

import java.time.LocalDate;

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
	private LocalDate dtNasc;
	@JsonProperty("rg_profissional")
	private Integer nrRg;
	@JsonProperty("cpf_profissional")
	private Integer nrCpf;
	@JsonProperty("tipo_sanguineo")
	private String tpSanguineo;
	@JsonProperty("telefone_profissional")
	private String nrTelefone;
	@JsonProperty("email_profissional")
	private String dsEmail;
	@JsonProperty("observacao_profissioal")
	private String dsObs;
	
	@JsonProperty("tipo_profissional")
	private TipoProfissionalHttpModel tpProfissional;
	private EnderecoHttpModel endereco;
}
