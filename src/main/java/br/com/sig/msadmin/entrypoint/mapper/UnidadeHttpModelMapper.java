package br.com.sig.msadmin.entrypoint.mapper;

import java.util.Optional;

import br.com.sig.msadmin.core.entity.UnidadeEntity;
import br.com.sig.msadmin.entrypoint.entity.UnidadeHttpModel;

public class UnidadeHttpModelMapper {

	public static UnidadeEntity to(UnidadeHttpModel httpModel) {
		return Optional.ofNullable(httpModel).map(e -> UnidadeEntity.builder()
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
				.idCadastro(e.getIdCadastro())
				.build())
				.orElse(new UnidadeEntity());
	}

	public static UnidadeHttpModel from(UnidadeEntity entity) {
		return Optional.ofNullable(entity).map(e -> UnidadeHttpModel.builder()
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
				.idCadastro(e.getIdCadastro())
				.build())
				.orElse(new UnidadeHttpModel());
	}
}
