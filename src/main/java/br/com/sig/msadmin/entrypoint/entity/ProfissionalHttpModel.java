package br.com.sig.msadmin.entrypoint.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	@JsonProperty("matricula_profissional")
	private String dsMatricula;
	@JsonProperty("data_nascimento")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dtNasc;
	@JsonProperty("rg_profissional")
	private String nrRg;
	@JsonProperty("cpf_profissional")
	private String nrCpf;
	@JsonProperty("tipo_sanguineo")
	private String tpSanguineo;
	@JsonProperty("telefone_profissional")
	private String nrTelefone;
	@JsonProperty("email_profissional")
	private String dsEmail;
	@JsonProperty("observacao_profissional")
	private String dsObs;
	
	@JsonProperty("tipo_profissional")
	private TipoProfissionalHttpModel tpProfissional;
	private EnderecoHttpModel endereco;
}
