package br.com.sig.msadmin.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.sig.msadmin.core.entity.UnidadeEntity;
import br.com.sig.msadmin.core.gateway.UnidadeGateway;

@Configuration
@Profile("test")
public class TestConfiguration {
	
	@Autowired
	private UnidadeGateway gateway;
	
	@Bean
	public boolean instantiateDatabase() {
			
			UnidadeEntity unidade = new UnidadeEntity();
			try {
				unidade = new UnidadeEntity(null,1,"SAMU","11700190","Rua","Espirito Santo",390,null,"Baixada Santista","Canto do Forte","Praia Grande","SP");	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			gateway.salvarUnidade(unidade);		
		return true;
	}
}

