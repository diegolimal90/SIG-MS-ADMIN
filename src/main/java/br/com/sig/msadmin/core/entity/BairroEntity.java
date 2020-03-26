package br.com.sig.msadmin.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BairroEntity {

	private Long id;
	
	private String nmBairro;
	private CidadeEntity cidade;
}
