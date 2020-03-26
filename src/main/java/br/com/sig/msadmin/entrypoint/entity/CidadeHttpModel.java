package br.com.sig.msadmin.entrypoint.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CidadeHttpModel {
	

	private Long id;
	
	private EstadoHttpModel estado;
	private String nmCidade;
	
	private List<BairroHttpModel> bairros;
	
		
}
