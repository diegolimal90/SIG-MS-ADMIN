package br.com.sig.msadmin.entrypoint.mapper;

import java.util.Optional;

import br.com.sig.msadmin.core.entity.BairroEntity;
import br.com.sig.msadmin.core.entity.CidadeEntity;
import br.com.sig.msadmin.core.entity.EnderecoEntity;
import br.com.sig.msadmin.core.entity.EstadoEntity;
import br.com.sig.msadmin.core.entity.TipoLogradouroEntity;
import br.com.sig.msadmin.entrypoint.entity.EnderecoHttpModel;

public class EnderecoHttpModelMapper {

	public static EnderecoHttpModel to(EnderecoEntity entity) {
		return Optional.ofNullable(entity).map(endereco -> EnderecoHttpModel.builder()
				.tpLogradouro(endereco.getTpLogradouro().getNmTpLogradouro())
				.nmLogradouro(endereco.getNmLogradouro())
				.dsComplemento(endereco.getDsComplemento())
				.nrCep(endereco.getNrCep())
				.bairro(endereco.getBairro().getNmBairro())
				.cidade(endereco.getBairro().getCidade().getNmCidade())
				.estado(endereco.getBairro().getCidade().getEstado().getNmEstado())
				.build())
				.orElse(EnderecoHttpModel.builder().build());
	}
	
	public static EnderecoEntity from(EnderecoHttpModel httpModel) {
		return Optional.ofNullable(httpModel).map(e -> EnderecoEntity.builder()
				.tpLogradouro(TipoLogradouroEntity.builder()
						.nmTpLogradouro(e
								.getTpLogradouro())
						.build())
				.nrCep(e.getNrCep())
				.dsComplemento(e.getDsComplemento())
				.nmLogradouro(e.getNmLogradouro())
				.dsNumero(e.getDsNumero())
				.bairro(BairroEntity.builder()
						.nmBairro(e
								.getBairro())
						.cidade(CidadeEntity.builder()
								.nmCidade(e
										.getCidade())
								.estado(EstadoEntity.builder()
										.nmEstado(e
												.getEstado())
										.build())
								.build())
						.build())
				.build())
		        .orElse(EnderecoEntity.builder()
		        		.tpLogradouro(TipoLogradouroEntity.builder()
		        				.build())
		        		.bairro(BairroEntity.builder()
		        				.cidade(CidadeEntity.builder()
										.estado(EstadoEntity.builder()
										.build())
								.build())
						.build())
        		.build());
	}
}
