package br.com.sig.msadmin.core.usecase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.ClienteEntity;
import br.com.sig.msadmin.core.entity.EnderecoEntity;
import br.com.sig.msadmin.core.entity.TelefoneEntity;
import br.com.sig.msadmin.core.gateway.ClienteGateway;
import br.com.sig.msadmin.core.gateway.ConsultaCepGateway;
import br.com.sig.msadmin.core.gateway.TelefoneGateway;
import br.com.sig.msadmin.core.utils.CpfCnpjUtils;
import br.com.sig.msadmin.core.utils.EmailUtils;
import br.com.sig.msadmin.core.utils.IdadeUtils;
import br.com.sig.msadmin.core.utils.RgUtils;
import br.com.sig.msadmin.core.utils.TelefoneUtils;
import br.com.sig.msadmin.exception.DataBaseException;

@Component
public class CadastrarClienteUseCase {

    @Autowired
	private ClienteGateway gateway;

	@Autowired
	private TelefoneGateway telefoneGateway;

	@Autowired
	private ConsultaCepGateway consultaCepGateway;

	public ClienteEntity cadastrarCliente(ClienteEntity entity){
		/**
		 * 1 = Pessoa Física
		 */
		if(entity.getTipoCliente() == 1){
			validarIdade(entity);
			validarRg(entity);
		}

		validarCpfCnpj(entity);
		validarEmail(entity);
		validarTelefone(entity);
		validarContrato(entity);
		validarEndereco(entity);

		entity = gateway.cadastrarCliente(entity);
		this.cadastrarTelefones(entity);

		return entity;
	}

	private static void validarIdade(ClienteEntity entity){		
		if( IdadeUtils.isMaior( entity.getDataNascimento() ) ){
			throw new DataBaseException("O cliente não é maior de idade...");
		}
	}
	
	private static void validarCpfCnpj(ClienteEntity entity){
		if( entity.getCpf().equals("") && entity.getCnpj().equals("") ){
			throw new DataBaseException("O CPF/CNPJ está vazia...");
		}

		if( !( CpfCnpjUtils.isValid( entity.getCnpj() ) || CpfCnpjUtils.isValid( entity.getCpf() ) ) ){
			throw new DataBaseException("O CPF/CNPJ está inválido...");
		}
	}

	private static void validarEmail(ClienteEntity entity){
		if( !( EmailUtils.isValid(entity.getEmail()) ) ){
			throw new DataBaseException("O email do cliente está inválido...");
		}
	}

	private static void validarTelefone(ClienteEntity entity){
		entity.getTelefones().forEach(numero -> {
			if( !( TelefoneUtils.isValid( numero.getTelefone() ) ) ){
				throw new DataBaseException("Telefone está inválido...");
			}
		});
	}

	private void cadastrarTelefones(ClienteEntity entity){
		List<TelefoneEntity> listaTelefone = new ArrayList<>();
		
		entity.getTelefones().forEach(numero -> {
			TelefoneEntity novoTelefone = new TelefoneEntity();

			novoTelefone = telefoneGateway.cadastrarTelefone(numero);

			listaTelefone.add(novoTelefone);
		});

		entity.setTelefones(listaTelefone);
	}

	private static void validarRg(ClienteEntity entity){
		if( !( RgUtils.isValid( entity.getRg() ) ) ){
			throw new DataBaseException("RG está inválido...");
		}
	}

	private static void validarContrato(ClienteEntity entity){
		if( !( entity.getContrato().equals("") ) ){
			//TODO inserir lógica sobre o PDF do contrato (tamanho e tipo de arquivo)
		}
	}

	private static void validarEndereco(ClienteEntity entity){
		// EnderecoEntity endereco = consultaCepGateway.consultaViaCep();
	}
}