package br.com.sig.msadmin.dataprovider.mapper;

import java.util.Optional;

import br.com.sig.msadmin.core.entity.BairroEntity;
import br.com.sig.msadmin.core.entity.CidadeEntity;
import br.com.sig.msadmin.core.entity.EnderecoEntity;
import br.com.sig.msadmin.core.entity.EstadoEntity;
import br.com.sig.msadmin.core.entity.TipoLogradouroEntity;
import br.com.sig.msadmin.dataprovider.entity.EnderecoFeign;

public class EnderecoFeignMapper {

	public static EnderecoEntity from(EnderecoFeign enderecoFeign) {
		return Optional.ofNullable(enderecoFeign).map(feign -> EnderecoEntity.builder()
				.nmLogradouro(feign.getLogradouro())
				.nrCep(feign.getCep())
				.bairro(BairroEntity.builder()
						.nmBairro(feign.getBairro())
						.cidade(CidadeEntity.builder()
								.nmCidade(feign.getLocalidade())
								.estado(EstadoEntity.builder()
										.nmEstado(feign.getUf())
										.build())
								.build())
						.build())
				.tpLogradouro(TipoLogradouroEntity.builder()
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
