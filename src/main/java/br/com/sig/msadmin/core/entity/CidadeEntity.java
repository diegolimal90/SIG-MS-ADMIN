package br.com.sig.msadmin.core.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CidadeEntity {
	

	private Long id;
	
	private String nmCidade;
	private EstadoEntity estado;
	
	private List<BairroEntity> bairros;
	
		
}
