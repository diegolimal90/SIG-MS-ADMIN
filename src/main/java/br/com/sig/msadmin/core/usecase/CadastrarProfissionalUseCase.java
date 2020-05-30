package br.com.sig.msadmin.core.usecase;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.EnderecoEntity;
import br.com.sig.msadmin.core.entity.ProfissionalEntity;
import br.com.sig.msadmin.core.gateway.ConsultaCepGateway;
import br.com.sig.msadmin.core.gateway.EnderecoGateway;
import br.com.sig.msadmin.core.gateway.ProfissionalGateway;
import br.com.sig.msadmin.core.utils.CpfCnpjUtils;
import br.com.sig.msadmin.core.utils.EmailUtils;
import br.com.sig.msadmin.core.utils.IdadeUtils;
import br.com.sig.msadmin.core.utils.RgUtils;
import br.com.sig.msadmin.core.utils.TelefoneUtils;

@Component
public class CadastrarProfissionalUseCase {
	
	@Autowired
	private ProfissionalGateway profissionalGateway;
	@Autowired
	private EnderecoGateway enderecoGateway;
	@Autowired
	private ConsultaCepGateway consultaCepGateway;

	public ProfissionalEntity cadastrarProfissional(ProfissionalEntity entity) {
		
		// TODO lógica da regra de negócio 
		
		if( !entity.getDtNasc().toString().isEmpty() && IdadeUtils.isMaior( entity.getDtNasc() ) ){
			throw new RuntimeException("O Profissional não é maior de 18 anos");
		} 
		else if( !entity.getDsEmail().isEmpty() && !EmailUtils.isValid(entity.getDsEmail()) ) {
			throw new RuntimeException("E-mail inválido, por favor preencha novamente");
		}
		else if( !entity.getNrRg().isEmpty() && !RgUtils.isValid(entity.getNrRg()) ){
			throw new RuntimeException("RG inválido, por favor preencha novamente");
		}
		else if( !entity.getNrTelefone().isEmpty() && !TelefoneUtils.isValid(entity.getNrTelefone()) ) {
			throw new RuntimeException("Telefone inválido, por favor preencha novamente");
		}
		else if( !entity.getNrCpf().isEmpty() && !CpfCnpjUtils.isValid(entity.getNrCpf()) ) {
			throw new RuntimeException("CPF inválido! verifique novamente");
		}
		
		EnderecoEntity endereco = consultaCepGateway.consultaViaCep(entity.getEndereco().getNrCep());
		
		endereco = enderecoGateway.cadastrarEndereco(endereco);
		
		entity.setEndereco(endereco);
		
		return profissionalGateway.cadastrarProfissional(entity);
	}

}
