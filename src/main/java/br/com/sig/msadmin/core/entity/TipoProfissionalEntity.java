package br.com.sig.msadmin.core.entity;

import java.util.Date;

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
	
	private Integer nrCrm;
	private Date dtValidadeCrm;
	
	private String nrCoren;
	private Date dtValidadeCoren;
}