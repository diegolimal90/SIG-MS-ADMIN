package br.com.sig.msadmin.entrypoint.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BairroHttpModel {

	private Long id;
	
	private String nmBairro;
	private CidadeHttpModel cidade;
}
