package br.com.sig.msadmin.core.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoProfissionalEntity {
	private Long id;
	
	private String nmProfissao;
	private String nrDocumento;
	private LocalDate dtValidadeDocumento;
	private String dsCategoriaCnh;
	private String dsCursoObrigatorio;
	private LocalDate dtValidadeCurso;
	private EspecialidadeProfissionalEntity dsEspecialidade;

}