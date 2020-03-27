package br.com.sig.msadmin.entrypoint.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.sig.msadmin.core.entity.ClienteEntity;
import br.com.sig.msadmin.core.entity.TelefoneEntity;
import br.com.sig.msadmin.entrypoint.entity.ClienteHttpModel;
import br.com.sig.msadmin.entrypoint.entity.TelefoneHttpModel;

public class ClienteHttpModelMapper{

    public static ClienteEntity to(ClienteHttpModel HttpModel){
        return Optional.ofNullable(HttpModel).map(e -> ClienteEntity.builder()
                .id(e.getId())
                .tipoCliente(e.getTipoCliente())
                .nome(e.getNome())
                .nomeSocial(e.getNomeSocial())
                .nomeFantasia(e.getNomeFantasia())
                .rg(e.getRg())
                .cpf(e.getCpf())
                .cnpj(e.getCnpj())
                //.endereco(e.getEndereco())
                .telefones(toTelefone(e))
                .email(e.getEmail())
                .contrato(e.getContrato())
                //.responsavelContrato(e.getResponsavelContrato())
                .dataNascimento(e.getDataNascimento())
                .dataFundacao(e.getDataFundacao())
                .build())
                .orElse(new ClienteEntity());
    }

    //TODO Fazer conversão responsavelContrato

    private static List<TelefoneEntity> toTelefone(ClienteHttpModel HttpModel){
        List<TelefoneEntity> telefones = new ArrayList<>();

        for(TelefoneHttpModel telefone: HttpModel.getTelefones() ){
            telefones.add(
                TelefoneEntity.builder().id(telefone.getId()).telefone(telefone.getTelefone()).build()
            );
        }
        
        return telefones;
    }

    private static List<TelefoneHttpModel> fromTelefone(ClienteEntity entity){
        List<TelefoneHttpModel> telefones = new ArrayList<>();

        for(TelefoneEntity telefone: entity.getTelefones() ){
            telefones.add(
                TelefoneHttpModel.builder().id(telefone.getId()).telefone(telefone.getTelefone()).build()
            );
        }

        return telefones;
    }


    public static ClienteHttpModel from(ClienteEntity entity){
        return Optional.ofNullable(entity).map(e -> ClienteHttpModel.builder()
                .id(e.getId())
                .tipoCliente(e.getTipoCliente())
                .nome(e.getNome())
                .nomeSocial(e.getNomeSocial())
                .nomeFantasia(e.getNomeFantasia())
                .rg(e.getRg())
                .cpf(e.getCpf())
                .cnpj(e.getCnpj())
                //.endereco(e.getEndereco())
                .telefones(fromTelefone(e))
                .email(e.getEmail())
                .contrato(e.getContrato())
                //.responsavelContrato(e.getResponsavelContrato())
                .dataNascimento(e.getDataNascimento())
                .dataFundacao(e.getDataFundacao())
                .build())
                .orElse(new ClienteHttpModel());
    }
}