package br.com.sig.msadmin.dataprovider.mapper;

import java.util.Optional;

import br.com.sig.msadmin.core.entity.BairroEntity;
import br.com.sig.msadmin.core.entity.CidadeEntity;
import br.com.sig.msadmin.core.entity.EnderecoEntity;
import br.com.sig.msadmin.core.entity.EstadoEntity;
import br.com.sig.msadmin.core.entity.PaisEntity;
import br.com.sig.msadmin.core.entity.ProfissionalEntity;
import br.com.sig.msadmin.core.entity.TipoLogradouroEntity;
import br.com.sig.msadmin.dataprovider.entity.BairroTable;
import br.com.sig.msadmin.dataprovider.entity.CidadeTable;
import br.com.sig.msadmin.dataprovider.entity.EnderecoTable;
import br.com.sig.msadmin.dataprovider.entity.EstadoTable;
import br.com.sig.msadmin.dataprovider.entity.PaisTable;
import br.com.sig.msadmin.dataprovider.entity.ProfissionalTable;
import br.com.sig.msadmin.dataprovider.entity.TipoLogradouroTable;

public class ProfissionalTableMapper {

	public static ProfissionalTable from(ProfissionalEntity entity) {
		return Optional.ofNullable(entity).map(e -> ProfissionalTable.builder()
				.id(e.getId())
				.nmProfissional(e.getNmProfissional())
				.dsMatricula(e.getDsMatricula())
				.endereco(fromEndereco(e))
				.dtNasc(e.getDtNasc())
				.nrRg(e.getNrRg())
				.nrCpf(e.getNrCpf())
				.tpSanguineo(e.getTpSanguineo())
				.nrTelefone(e.getNrTelefone())
				.dsEmail(e.getDsEmail())
				.dsObs(e.getDsObs())
		        .build())
		        .orElse(new ProfissionalTable());
	}

	private static EnderecoTable fromEndereco(ProfissionalEntity entity) {
		return Optional.ofNullable(entity).map(e -> EnderecoTable.builder()
				.tpLogradouro(TipoLogradouroTable.builder()
						.nmTpLogradouro(e.getEndereco()
								.getTpLogradouro()
								.getNmTpLogradouro())
						.build())
				.nrCep(e.getEndereco().getNrCep())
				.dsComplemento(e.getEndereco().getDsComplemento())
				.nmLogradouro(e.getEndereco().getNmLogradouro())
				.dsNumero(e.getEndereco().getDsNumero())
				.bairro(BairroTable.builder()
						.nmBairro(e.getEndereco()
								.getBairro()
								.getNmBairro())
						.cidade(CidadeTable.builder()
								.nmCidade(e.getEndereco()
										.getBairro()
										.getCidade()
										.getNmCidade())
								.estado(EstadoTable.builder()
										.nmEstado(e.getEndereco()
												.getBairro()
												.getCidade()
												.getEstado()
												.getNmEstado())
										.sgEstado(e.getEndereco()
												.getBairro()
												.getCidade()
												.getEstado()
												.getSgEstado())
										.pais(PaisTable.builder()
												.nmPais(e.getEndereco()
												.getBairro()
												.getCidade()
												.getEstado()
												.getPais()
												.getNmPais())
											.build())
										.build())
								.build())
						.build())
				.build())
		        .orElse(EnderecoTable.builder()
		        		.tpLogradouro(new TipoLogradouroTable())
		        		.bairro(BairroTable.builder()
		        				.cidade(CidadeTable.builder()
										.estado(EstadoTable.builder()
												.pais(new PaisTable())
												.build())
										.build())
								.build())
		        		.build());
	}
	
	private static EnderecoEntity fromEndereco(ProfissionalTable table) {
		return Optional.ofNullable(table).map(e -> EnderecoEntity.builder()
				.tpLogradouro(TipoLogradouroEntity.builder()
						.nmTpLogradouro(e.getEndereco()
								.getTpLogradouro()
								.getNmTpLogradouro())
						.build())
				.nrCep(e.getEndereco().getNrCep())
				.dsComplemento(e.getEndereco().getDsComplemento())
				.nmLogradouro(e.getEndereco().getNmLogradouro())
				.dsNumero(e.getEndereco().getDsNumero())
				.bairro(BairroEntity.builder()
						.nmBairro(e.getEndereco()
								.getBairro()
								.getNmBairro())
						.cidade(CidadeEntity.builder()
								.nmCidade(e.getEndereco()
										.getBairro()
										.getCidade()
										.getNmCidade())
								.estado(EstadoEntity.builder()
										.nmEstado(e.getEndereco()
												.getBairro()
												.getCidade()
												.getEstado()
												.getNmEstado())
										.sgEstado(e.getEndereco()
												.getBairro()
												.getCidade()
												.getEstado()
												.getSgEstado())
										.pais(PaisEntity.builder()
												.nmPais(e.getEndereco()
												.getBairro()
												.getCidade()
												.getEstado()
												.getPais()
												.getNmPais())
											.build())
										.build())
								.build())
						.build())
				.build())
		        .orElse(EnderecoEntity.builder()
		        		.tpLogradouro(new TipoLogradouroEntity())
		        		.bairro(BairroEntity.builder()
		        				.cidade(CidadeEntity.builder()
										.estado(EstadoEntity.builder()
												.pais(new PaisEntity())
												.build())
										.build())
								.build())
		        		.build());
	}
	
	public static ProfissionalEntity to(ProfissionalTable table) {
		return Optional.ofNullable(table).map(e -> ProfissionalEntity.builder()
				.id(e.getId())
				.nmProfissional(e.getNmProfissional())
				.dsMatricula(e.getDsMatricula())
				.endereco(fromEndereco(e))
				.dtNasc(e.getDtNasc())
				.nrRg(e.getNrRg())
				.nrCpf(e.getNrCpf())
				.tpSanguineo(e.getTpSanguineo())
				.nrTelefone(e.getNrTelefone())
				.dsEmail(e.getDsEmail())
				.dsObs(e.getDsObs())
		        .build())
		        .orElse(new ProfissionalEntity());
	}
	
}