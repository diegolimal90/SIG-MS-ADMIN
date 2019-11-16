package br.com.sig.msadmin.dataprovider.mapper;

import br.com.sig.msadmin.core.entity.UnidadeEntity;
import br.com.sig.msadmin.dataprovider.entity.UnidadeTable;

public class UnidadeTableMapper {

	public static UnidadeEntity to(UnidadeTable table) {
		return UnidadeEntity.builder()
				.id(table.getId())
				.tipo(table.getTipo())
				.nome(table.getNome())
				.cep(table.getCep())
				.tipoLogradouro(table.getTipoLogradouro())
				.logradouro(table.getLogradouro())
				.numero(table.getNumero())
				.complemento(table.getComplemento())
				.regiao(table.getRegiao())
				.bairro(table.getBairro())
				.cidade(table.getCidade())
				.estado(table.getEstado())
				.referencia(table.getReferencia())
				.build();
	}
	
	public static UnidadeTable from(UnidadeEntity entity) {
		return UnidadeTable.builder()
				.id(entity.getId())
				.tipo(entity.getTipo())
				.nome(entity.getNome())
				.cep(entity.getCep())
				.tipoLogradouro(entity.getTipoLogradouro())
				.logradouro(entity.getLogradouro())
				.numero(entity.getNumero())
				.complemento(entity.getComplemento())
				.regiao(entity.getRegiao())
				.bairro(entity.getBairro())
				.cidade(entity.getCidade())
				.estado(entity.getEstado())
				.referencia(entity.getReferencia())
				.build();
	}
}
