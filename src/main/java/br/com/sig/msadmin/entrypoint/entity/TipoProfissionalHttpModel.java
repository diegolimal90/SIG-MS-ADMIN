package br.com.sig.msadmin.entrypoint.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoProfissionalHttpModel {
	private Long id;
	
	@JsonProperty("nome_profissao")
	private String nmProfissao;
	@JsonProperty("doc_profissao")
	private String nrDocumento;
	@JsonProperty("data_validade_doc")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dtValidadeDocumento;
	@JsonProperty("categoria_cnh")
	private String dsCategoriaCnh;
	@JsonProperty("curso_profissional")
	private String dsCursoObrigatorio;
	@JsonProperty("data_validade_curso")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dtValidadeCurso;
	@JsonProperty("nome_especialidade")
	private String dsEspecialidade;
}
