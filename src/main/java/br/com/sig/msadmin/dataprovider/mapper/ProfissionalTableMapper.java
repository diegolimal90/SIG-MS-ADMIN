package br.com.sig.msadmin.dataprovider.mapper;

import java.util.Optional;

import br.com.sig.msadmin.core.entity.ProfissionalEntity;
import br.com.sig.msadmin.dataprovider.entity.BairroTable;
import br.com.sig.msadmin.dataprovider.entity.CidadeTable;
import br.com.sig.msadmin.dataprovider.entity.EnderecoTable;
import br.com.sig.msadmin.dataprovider.entity.EstadoTable;
import br.com.sig.msadmin.dataprovider.entity.ProfissionalTable;
import br.com.sig.msadmin.dataprovider.entity.TipoLogradouroTable;

public class ProfissionalTableMapper {

	public static ProfissionalTable from(ProfissionalEntity entity) {
		return Optional.ofNullable(entity).map(e -> ProfissionalTable.builder()
				.id(e.getId())
				.nmProfissional(e.getNmProfissional())
				.tpLogradouro(e.getTpLogradouro())
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
						.nmTpLogradouro(e.getTpLogradouro())
						.build())
				.nrCep(e.getNrCep())
				.dsComplemento(e.getDsComplemento())
				.nmLogradouro(e.getDsEndereço())
				.dsNumero(e.getDsNumero())
				.bairro(BairroTable.builder()
						.nmBairro(e.getNmBairro())
						.cidade(CidadeTable.builder()
								.nmCidade(e.getNmCidade())
								.estado(EstadoTable.builder()
										.nmEstado(e.getNmEstado())
										.build())
								.build())
						.build())
				.build())
		        .orElse(EnderecoTable.builder()
		        		.tpLogradouro(new TipoLogradouroTable())
		        		.bairro(BairroTable.builder()
		        				.cidade(CidadeTable.builder()
										.estado(new EstadoTable())
										.build())
								.build())
		        		.build());
	}
	
	public static ProfissionalEntity to(ProfissionalTable table) {
		return Optional.ofNullable(table).map(e -> ProfissionalEntity.builder()
				.id(e.getId())
				.nmProfissional(e.getNmProfissional())
				.tpLogradouro(e.getEndereco().getTpLogradouro().getNmTpLogradouro())
				.dsEndereço(e.getEndereco().getNmLogradouro())
				.dsNumero(e.getEndereco().getDsNumero())
				.dsComplemento(e.getEndereco().getDsComplemento())
				.nrCep(e.getEndereco().getNrCep())
				.nmBairro(e.getEndereco().getBairro().getNmBairro())
				.nmEstado(e.getEndereco().getBairro().getCidade().getEstado().getNmEstado())
				.nmCidade(e.getEndereco().getBairro().getCidade().getNmCidade())
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
