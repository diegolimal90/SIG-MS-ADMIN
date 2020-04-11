package br.com.sig.msadmin.core.usecase;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.ClienteEntity;
import br.com.sig.msadmin.core.entity.EnderecoEntity;
import br.com.sig.msadmin.core.gateway.ClienteGateway;
import br.com.sig.msadmin.core.gateway.ConsultaCepGateway;
import br.com.sig.msadmin.exception.DataBaseException;

@Component
public class CadastrarClienteUseCase {

   @Autowired
	private ClienteGateway gateway;

	@Autowired
	private ConsultaCepGateway consultaCepGateway;

	public ClienteEntity cadastrarCliente(ClienteEntity entity){	
		LocalDate hoje = LocalDate.now();
		//TODO Fazer as validações necessarias.

		// EnderecoEntity endereco = consultaCepGateway.consultaViaCep();

		if(entity.getTipoCliente() == 1){
			if( calcularIdade(entity.getDataNascimento(), hoje) >= 18 ){
				return gateway.cadastrarCliente(entity);
			}else{
				throw new DataBaseException("O cliente não é maior de idade...");
			}
		}
		
		return gateway.cadastrarCliente(entity);
	}

	private static int calcularIdade(LocalDate dataNascimento, LocalDate dataAtual) {
        if ((dataNascimento != null) && (dataAtual != null)) {
            return Period.between(dataNascimento, dataAtual).getYears();
        } else {
            return 0;
        }
    }
}