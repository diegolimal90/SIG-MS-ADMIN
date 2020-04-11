package br.com.sig.msadmin.entrypoint.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.sig.msadmin.core.entity.ClienteEntity;
import br.com.sig.msadmin.core.entity.EnderecoEntity;
import br.com.sig.msadmin.core.entity.TelefoneEntity;
import br.com.sig.msadmin.entrypoint.entity.ClienteHttpModel;
import br.com.sig.msadmin.entrypoint.entity.EnderecoHttpModel;
import br.com.sig.msadmin.entrypoint.entity.TelefoneHttpModel;

public class ClienteHttpModelMapper{
    //TODO Ativar Endereço e ResponsavelContrato
    public static ClienteEntity to(ClienteHttpModel HttpModel){
        return Optional.ofNullable(HttpModel).map(httpModelCliente -> ClienteEntity.builder()
                .id(httpModelCliente.getId())
                .tipoCliente(httpModelCliente.getTipoCliente())
                .nome(httpModelCliente.getNome())
                .nomeSocial(httpModelCliente.getNomeSocial())
                .nomeFantasia(httpModelCliente.getNomeFantasia())
                .rg(httpModelCliente.getRg())
                .cpf(httpModelCliente.getCpf())
                .cnpj(httpModelCliente.getCnpj())
                .enderecos(toEndereco(httpModelCliente.getEnderecos()))
                .telefones(toTelefone(httpModelCliente))
                .email(httpModelCliente.getEmail())
                .contrato(httpModelCliente.getContrato())
                //.responsavelContrato(httpModelCliente.getResponsavelContrato())
                .dataNascimento(httpModelCliente.getDataNascimento())
                .dataFundacao(httpModelCliente.getDataFundacao())
                .build())
                .orElse(new ClienteEntity());
    }

    //TODO Fazer conversão responsavelContrato

    private static List<TelefoneEntity> toTelefone(ClienteHttpModel httpModel){
        List<TelefoneEntity> telefones = new ArrayList<>();

        for(TelefoneHttpModel telefone: httpModel.getTelefones() ){
            telefones.add(TelefoneHttpModelMapper.from(telefone));
        }
        
        return telefones;
    }
	
	private static List<EnderecoEntity> toEndereco(List<EnderecoHttpModel> httpModel) {
		List<EnderecoEntity> enderecos = new ArrayList<>();

        for(EnderecoHttpModel endereco: httpModel){
            enderecos.add(EnderecoHttpModelMapper.from(endereco));
        }
                
        return enderecos;
    }
    
    /*

        From...

    */

    private static List<TelefoneHttpModel> fromTelefone(ClienteEntity entity){
        List<TelefoneHttpModel> telefones = new ArrayList<>();

        for(TelefoneEntity telefone: entity.getTelefones()){
            telefones.add(TelefoneHttpModelMapper.to(telefone));
        }

        return telefones;
    }

    private static List<EnderecoHttpModel> fromEndereco(List<EnderecoEntity> entity) {
        List<EnderecoHttpModel> enderecos = new ArrayList<>();

        for(EnderecoEntity endereco: entity){
            enderecos.add(EnderecoHttpModelMapper.to(endereco));
        }
                
        return enderecos;
	}


    public static ClienteHttpModel from(ClienteEntity entity){
        return Optional.ofNullable(entity).map(clienteEntity -> ClienteHttpModel.builder()
                .id(clienteEntity.getId())
                .tipoCliente(clienteEntity.getTipoCliente())
                .nome(clienteEntity.getNome())
                .nomeSocial(clienteEntity.getNomeSocial())
                .nomeFantasia(clienteEntity.getNomeFantasia())
                .rg(clienteEntity.getRg())
                .cpf(clienteEntity.getCpf())
                .cnpj(clienteEntity.getCnpj())
                .enderecos(fromEndereco(clienteEntity.getEnderecos()))
                .telefones(fromTelefone(clienteEntity))
                .email(clienteEntity.getEmail())
                .contrato(clienteEntity.getContrato())
                //.responsavelContrato(clienteEntity.getResponsavelContrato())
                .dataNascimento(clienteEntity.getDataNascimento())
                .dataFundacao(clienteEntity.getDataFundacao())
                .build())
                .orElse(new ClienteHttpModel());
    }
}