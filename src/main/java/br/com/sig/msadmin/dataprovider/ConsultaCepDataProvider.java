package br.com.sig.msadmin.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.EnderecoEntity;
import br.com.sig.msadmin.core.gateway.ConsultaCepGateway;
import br.com.sig.msadmin.dataprovider.entity.EnderecoFeign;
import br.com.sig.msadmin.dataprovider.feign.CepFeignClient;
import br.com.sig.msadmin.dataprovider.mapper.EnderecoFeignMapper;
import br.com.sig.msadmin.exception.FeignClientException;

@Component
public class ConsultaCepDataProvider implements ConsultaCepGateway{

	@Autowired
	private CepFeignClient feignClient;
	
	@Override
	public EnderecoEntity consultaViaCep(String cep) {
		try {
			
			EnderecoFeign feign = feignClient.consultaViaCep(cep);
			
			EnderecoEntity entity = EnderecoFeignMapper.from(feign);
			
			return entity;
		} catch(Exception ex) {
			throw new FeignClientException("Erro ao consultar endereço por CEP");
		}
	}

}