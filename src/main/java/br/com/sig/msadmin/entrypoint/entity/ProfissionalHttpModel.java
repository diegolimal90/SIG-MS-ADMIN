package br.com.sig.msadmin.entrypoint.entity;

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
	private String nmProfissional;
	private String tpLogradouro;
	private String dsEndereço;
	private String dsNumero;
	private String dsComplemento;
	private String nrCep;
	private String nmBairro;
	private String nmEstado;
	private String nmCidade;
	private String nmPais;
	private String dtNasc;
	private String nrRg;
	private String nrCpf;
	private String tpSanguineo;
	private String nrTelefone;
	private String dsEmail;
	private String dsObs;
}
