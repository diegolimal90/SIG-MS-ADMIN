package br.com.sig.msadmin.core.usecase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.BairroEntity;
import br.com.sig.msadmin.core.entity.CidadeEntity;
import br.com.sig.msadmin.core.entity.EnderecoEntity;
import br.com.sig.msadmin.core.entity.EstadoEntity;
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
		List<EnderecoEntity> enderecosCad = new ArrayList<>();
		
		// Verificar se o endereço esta vazio
		if( entity.getEndereco() != null ) {
			enderecosCad = enderecoGateway.buscarEndereco(entity.getEndereco().getNrCep());
			
			// Verifica se há algum endereço já cadastrado com o CEP digitado pelo usuário
			if( !enderecosCad.isEmpty() ) {
				EnderecoEntity endereco = enderecosCad.get(0);
				
				//criou a entidade endereco que sera salva no banco de dados
                EnderecoEntity enderecoEntity = EnderecoEntity.builder()
                    .nmLogradouro(endereco.getNmLogradouro())
                    .dsNumero(entity.getEndereco().getDsNumero())
                    .dsComplemento(entity.getEndereco().getDsComplemento())
                    .nrCep(endereco.getNrCep())
                    .bairro(BairroEntity.builder()
                            .id(endereco.getId())
                            .nmBairro(endereco.getBairro().getNmBairro())
                            .cidade(CidadeEntity.builder()
                                    .id(endereco.getId())
                                    .nmCidade(endereco.getBairro().getCidade().getNmCidade())
                                    .estado(EstadoEntity.builder()
                                            .id(endereco.getId())
                                            .nmEstado(endereco.getBairro().getCidade().getEstado().getNmEstado())
                                            .build())
                                    .build())
                            .build())
                    .build();
                
                entity.setEndereco(enderecoEntity);
			} else {
				EnderecoEntity endereco = consultaCepGateway.consultaViaCep(entity.getEndereco().getNrCep());
				
				endereco = enderecoGateway.cadastrarEndereco(endereco);
				
				entity.setEndereco(endereco);			
			}
		}
		
		if( !entity.getDtNasc().toString().isEmpty() && !(IdadeUtils.calcularIdade(entity.getDtNasc(), LocalDate.now()) >= 18)){
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
		
		return profissionalGateway.cadastrarProfissional(entity);
	}

}
