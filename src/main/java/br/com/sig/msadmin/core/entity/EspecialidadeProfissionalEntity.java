package br.com.sig.msadmin.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EspecialidadeProfissionalEntity {
	
	private Long id;
	
	private String nomeEspecialidade; 
}