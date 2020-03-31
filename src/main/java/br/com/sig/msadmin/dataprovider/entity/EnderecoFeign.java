package br.com.sig.msadmin.dataprovider.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoFeign {
	
	private Long id;
	private String cep;
	private String logradouro;
	private String bairro;
	private String localidade;
	
}