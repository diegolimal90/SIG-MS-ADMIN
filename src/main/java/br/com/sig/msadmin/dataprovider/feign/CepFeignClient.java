package br.com.sig.msadmin.dataprovider.feign;

import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(url = "${feign.viacep}", name = "viacep")
public interface CepFeignClient {

	// TODO Desenvolver a Classe EnderecoFeign 
	//	@GetMapping("{cep}/json")
	//	EnderecoFeign buscaEnderecoPor(@PathVariable("cep") String cep);
}
