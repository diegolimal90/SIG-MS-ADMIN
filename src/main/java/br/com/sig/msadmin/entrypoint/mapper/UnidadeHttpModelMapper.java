package br.com.sig.msadmin.entrypoint.mapper;

import br.com.sig.msadmin.core.entity.UnidadeEntity;
import br.com.sig.msadmin.entrypoint.entity.UnidadeHttpModel;

public class UnidadeHttpModelMapper {

	public static UnidadeEntity to(UnidadeHttpModel httpModel) {
		return UnidadeEntity.builder()
				.id(httpModel.getId())
				.tipo(httpModel.getTipo())
				.nome(httpModel.getNome())
				.cep(httpModel.getCep())
				.tipoLogradouro(httpModel.getTipoLogradouro())
				.logradouro(httpModel.getLogradouro())
				.numero(httpModel.getNumero())
				.complemento(httpModel.getComplemento())
				.regiao(httpModel.getRegiao())
				.bairro(httpModel.getBairro())
				.cidade(httpModel.getCidade())
				.estado(httpModel.getEstado())
				.referencia(httpModel.getReferencia())
				.status(httpModel.getStatus())
				.build();
	}

	public static UnidadeHttpModel from(UnidadeEntity entity) {
		return UnidadeHttpModel.builder()
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
				.status(entity.getStatus())
				.build();
	}
}
