package br.com.sig.msadmin.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.BairroEntity;
import br.com.sig.msadmin.core.entity.CidadeEntity;
import br.com.sig.msadmin.core.entity.EnderecoEntity;
import br.com.sig.msadmin.core.entity.EstadoEntity;
import br.com.sig.msadmin.core.entity.TipoLogradouroEntity;
import br.com.sig.msadmin.core.gateway.ConsultaCepGateway;
import br.com.sig.msadmin.dataprovider.entity.EnderecoFeign;
import br.com.sig.msadmin.dataprovider.feign.CepFeignClient;

@Component
public class ConsultaCepDataProvider implements ConsultaCepGateway{

	@Autowired
	private CepFeignClient feignClient;
	
	@Override
	public EnderecoEntity consultaViaCep(String cep) {
		try {
			EnderecoFeign feign = feignClient.consultaViaCep(cep);
			
			EnderecoEntity entity = EnderecoEntity.builder()
					.nmLogradouro(feign.getLogradouro())
					.nrCep(feign.getCep())
					.bairro(BairroEntity.builder()
							.nmBairro(feign.getBairro())
							.cidade(CidadeEntity.builder()
									.nmCidade(feign.getLocalidade())
									.estado(EstadoEntity.builder()
											.build())
									.build())
							.build())
					.tpLogradouro(TipoLogradouroEntity.builder()
							.build())
					.build();
			
			return entity;
		} catch(Exception ex) {
			throw new RuntimeException("Erro ao consultar endereço por CEP");
		}
	}

}