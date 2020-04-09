package br.com.sig.msadmin.dataprovider.mapper;

import java.util.Optional;

import br.com.sig.msadmin.core.entity.BairroEntity;
import br.com.sig.msadmin.core.entity.CidadeEntity;
import br.com.sig.msadmin.core.entity.EnderecoEntity;
import br.com.sig.msadmin.core.entity.EstadoEntity;
import br.com.sig.msadmin.core.entity.TipoLogradouroEntity;
import br.com.sig.msadmin.dataprovider.entity.BairroTable;
import br.com.sig.msadmin.dataprovider.entity.CidadeTable;
import br.com.sig.msadmin.dataprovider.entity.EnderecoTable;
import br.com.sig.msadmin.dataprovider.entity.EstadoTable;
import br.com.sig.msadmin.dataprovider.entity.TipoLogradouroTable;

public class EnderecoTableMapper {

	public static EnderecoTable to(EnderecoEntity entity) {
		return Optional.ofNullable(entity).map(endereco -> EnderecoTable.builder()
				.tpLogradouro(TipoLogradouroTable.builder()
						.nmTpLogradouro(endereco
								.getTpLogradouro()
								.getNmTpLogradouro())
						.build())
				.nrCep(endereco.getNrCep())
				.dsComplemento(endereco.getDsComplemento())
				.nmLogradouro(endereco.getNmLogradouro())
				.dsNumero(endereco.getDsNumero())
				.bairro(BairroTable.builder()
						.nmBairro(endereco.getBairro()
								.getNmBairro())
						.cidade(CidadeTable.builder()
								.nmCidade(endereco.getBairro()
										.getCidade()
										.getNmCidade())
								.estado(EstadoTable.builder()
										.nmEstado(endereco.getBairro()
												.getCidade()
												.getEstado()
												.getNmEstado())
										.sgEstado(endereco.getBairro()
												.getCidade()
												.getEstado()
												.getSgEstado())
										.build())
								.build())
						.build())
				.build())
		        .orElse(EnderecoTable.builder()
		        		.tpLogradouro(TipoLogradouroTable.builder()
		        				.build())
		        		.bairro(BairroTable.builder()
		        				.cidade(CidadeTable.builder()
										.estado(EstadoTable.builder()
										.build())
								.build())
						.build())
        		.build());
	}
	
	public static EnderecoEntity from(EnderecoTable table) {
		return Optional.ofNullable(table).map(endereco -> EnderecoEntity.builder()
				.tpLogradouro(TipoLogradouroEntity.builder()
						.nmTpLogradouro(endereco.getTpLogradouro()
								.getNmTpLogradouro())
						.build())
				.nrCep(endereco.getNrCep())
				.dsComplemento(endereco.getDsComplemento())
				.nmLogradouro(endereco.getNmLogradouro())
				.dsNumero(endereco.getDsNumero())
				.bairro(BairroEntity.builder()
						.nmBairro(endereco.getBairro()
								.getNmBairro())
						.cidade(CidadeEntity.builder()
								.nmCidade(endereco.getBairro()
										.getCidade()
										.getNmCidade())
								.estado(EstadoEntity.builder()
										.nmEstado(endereco.getBairro()
												.getCidade()
												.getEstado()
												.getNmEstado())
										.sgEstado(endereco.getBairro()
												.getCidade()
												.getEstado()
												.getSgEstado())
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
