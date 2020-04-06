package br.com.sig.msadmin.dataprovider.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.sig.msadmin.dataprovider.entity.EnderecoFeign;


@FeignClient(url = "${feign.viacep}", name = "viacep")
public interface CepFeignClient {
 
	@GetMapping("/{cep}/json")
	EnderecoFeign consultaViaCep(@PathVariable("cep") String cep);
}