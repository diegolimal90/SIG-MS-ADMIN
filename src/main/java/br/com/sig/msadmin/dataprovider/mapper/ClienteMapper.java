package br.com.sig.msadmin.dataprovider.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.sig.msadmin.core.entity.ClienteEntity;
import br.com.sig.msadmin.core.entity.TelefoneEntity;
import br.com.sig.msadmin.dataprovider.entity.ClienteTable;
import br.com.sig.msadmin.dataprovider.entity.TelefoneTable;

public class ClienteMapper{

    public static ClienteEntity to(ClienteTable table){
        return Optional.ofNullable(table).map(e -> ClienteEntity.builder()
                .id(e.getId())
                .tipoCliente(e.getTipoCliente())
                .nome(e.getNome())
                .nomeSocial(e.getNomeSocial())
                .nomeFantasia(e.getNomeFantasia())
                .rg(e.getRg())
                .cpf(e.getCpf())
                .cnpj(e.getCnpj())
                .endereco(e.getEndereco())
                .telefones(toTelefone(e))
                .email(e.getEmail())
                .contrato(e.getContrato())
                .responsavelContrato(e.getResponsavelContrato())
                .dataNascimento(e.getDataNascimento())
                .dataFundacao(e.getDataFundacao())
                .build())
                .orElse(new ClienteEntity());
    }

    private static List<TelefoneEntity> toTelefone(ClienteTable table){
        List<TelefoneEntity> telefones = new ArrayList<>();

        for(TelefoneTable telefone: table.getTelefones() ){
            telefones.add(
                TelefoneEntity.builder().id(telefone.getId()).telefone(telefone.getTelefone()).build()
            );
        }
        
        return telefones;
    }

    private static List<TelefoneTable> fromTelefone(ClienteEntity entity){
        List<TelefoneTable> telefones = new ArrayList<>();

        for(TelefoneEntity telefone: entity.getTelefones() ){
            telefones.add(
                TelefoneTable.builder().id(telefone.getId()).telefone(telefone.getTelefone()).build()
            );
        }

        return telefones;
    }


    public static ClienteTable from(ClienteEntity entity){
        return Optional.ofNullable(entity).map(e -> ClienteTable.builder()
                .id(e.getId())
                .tipoCliente(e.getTipoCliente())
                .nome(e.getNome())
                .nomeSocial(e.getNomeSocial())
                .nomeFantasia(e.getNomeFantasia())
                .rg(e.getRg())
                .cpf(e.getCpf())
                .cnpj(e.getCnpj())
                .endereco(e.getEndereco())
                .telefones(fromTelefone(e))
                .email(e.getEmail())
                .contrato(e.getContrato())
                .responsavelContrato(e.getResponsavelContrato())
                .dataNascimento(e.getDataNascimento())
                .dataFundacao(e.getDataFundacao())
                .build())
                .orElse(new ClienteTable());
    }
}