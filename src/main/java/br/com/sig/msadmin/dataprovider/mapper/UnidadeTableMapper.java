package br.com.sig.msadmin.dataprovider.mapper;

import java.util.Optional;

import br.com.sig.msadmin.core.entity.UnidadeEntity;
import br.com.sig.msadmin.dataprovider.entity.UnidadeTable;

public class UnidadeTableMapper {

	public static UnidadeEntity to(UnidadeTable table) {
		return Optional.ofNullable(table).map(e -> UnidadeEntity.builder()
				.id(e.getId())
				.tipo(e.getTipo())
				.nome(e.getNome())
				.cep(e.getCep())
				.tipoLogradouro(e.getTipoLogradouro())
				.logradouro(e.getLogradouro())
				.numero(e.getNumero())
				.complemento(e.getComplemento())
				.regiao(e.getRegiao())
				.bairro(e.getBairro())
				.cidade(e.getCidade())
				.estado(e.getEstado())
				.referencia(e.getReferencia())
				.status(e.getStatus())
				.dataCadastro(e.getDataCadastro())
				.dataAlteracao(e.getDataAlteracao())
				.dataDesativacao(e.getDataDesativacao())
				.idCadastro(e.getIdCadastro())
				.idAlteracao(e.getIdAlteracao())
				.idDesativacao(e.getIdDesativacao())
				.build())
				.orElse(new UnidadeEntity());
	}
	
	public static UnidadeTable from(UnidadeEntity entity) {
		return Optional.ofNullable(entity).map(e -> UnidadeTable.builder()
				.id(e.getId())
				.tipo(e.getTipo())
				.nome(e.getNome())
				.cep(e.getCep())
				.tipoLogradouro(e.getTipoLogradouro())
				.logradouro(e.getLogradouro())
				.numero(e.getNumero())
				.complemento(e.getComplemento())
				.regiao(e.getRegiao())
				.bairro(e.getBairro())
				.cidade(e.getCidade())
				.estado(e.getEstado())
				.referencia(e.getReferencia())
				.status(e.getStatus())
				.dataCadastro(e.getDataCadastro())
				.dataAlteracao(e.getDataAlteracao())
				.dataDesativacao(e.getDataDesativacao())
				.idCadastro(e.getIdCadastro())
				.idAlteracao(e.getIdAlteracao())
				.idDesativacao(e.getIdDesativacao())
				.build())
				.orElse(new UnidadeTable());
	}
}
