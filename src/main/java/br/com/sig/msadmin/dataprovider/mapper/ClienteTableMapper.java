package br.com.sig.msadmin.dataprovider.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.sig.msadmin.core.entity.ClienteEntity;
import br.com.sig.msadmin.core.entity.EnderecoEntity;
import br.com.sig.msadmin.core.entity.TelefoneEntity;
import br.com.sig.msadmin.dataprovider.entity.ClienteTable;
import br.com.sig.msadmin.dataprovider.entity.EnderecoTable;
import br.com.sig.msadmin.dataprovider.entity.TelefoneTable;

public class ClienteTableMapper{
    //TODO Ativar ResponsavelContrato
    public static ClienteEntity to(ClienteTable table){
        return Optional.ofNullable(table).map(clienteTable -> ClienteEntity.builder()
                .id(clienteTable.getId())
                .tipoCliente(clienteTable.getTipoCliente())
                .nome(clienteTable.getNome())
                .nomeSocial(clienteTable.getNomeSocial())
                .nomeFantasia(clienteTable.getNomeFantasia())
                .rg(clienteTable.getRg())
                .cpf(clienteTable.getCpf())
                .cnpj(clienteTable.getCnpj())
                .enderecos(toEnderecos(clienteTable.getEnderecos()))
                .telefones(toTelefone(clienteTable.getTelefones()))
                .email(clienteTable.getEmail())
                .contrato(clienteTable.getContrato())
                //.responsavelContrato(clienteTable.getResponsavelContrato())
                .dataNascimento(clienteTable.getDataNascimento())
                .dataFundacao(clienteTable.getDataFundacao())
                .build())
                .orElse(ClienteEntity.builder().build());
    }

    //TODO Fazer conversão responsavelContrato
    private static List<EnderecoEntity> toEnderecos(List<EnderecoTable> enderecos){
        List<EnderecoEntity> listaEnderecos = new ArrayList<>();

        for(EnderecoTable endereco : enderecos){
            listaEnderecos.add(EnderecoTableMapper.from(endereco));
        }

        return listaEnderecos;
    }

    private static List<TelefoneEntity> toTelefone(List<TelefoneTable> table){
        List<TelefoneEntity> telefones = new ArrayList<>();

        for(TelefoneTable telefone: table){
            telefones.add(TelefoneTableMapper.from(telefone));
        }
        
        return telefones;
    }

    private static List<EnderecoTable> fromEnderecos(List<EnderecoEntity> enderecos){
        List<EnderecoTable> listaEnderecos = new ArrayList<>();

        for(EnderecoEntity endereco : enderecos){
            listaEnderecos.add(EnderecoTableMapper.to(endereco));
        }

        return listaEnderecos;
    }

    private static List<TelefoneTable> fromTelefone(List<TelefoneEntity> entity){
        List<TelefoneTable> telefones = new ArrayList<>();

        for(TelefoneEntity telefone : entity){
            telefones.add(TelefoneTableMapper.to(telefone));
        }

        return telefones;
    }

    public static ClienteTable from(ClienteEntity entity){
        return Optional.ofNullable(entity).map(clienteEntity -> ClienteTable.builder()
                .id(clienteEntity.getId())
                .tipoCliente(clienteEntity.getTipoCliente())
                .nome(clienteEntity.getNome())
                .nomeSocial(clienteEntity.getNomeSocial())
                .nomeFantasia(clienteEntity.getNomeFantasia())
                .rg(clienteEntity.getRg())
                .cpf(clienteEntity.getCpf())
                .cnpj(clienteEntity.getCnpj())
                .enderecos(fromEnderecos(clienteEntity.getEnderecos()))
                .telefones(fromTelefone(clienteEntity.getTelefones()))
                .email(clienteEntity.getEmail())
                .contrato(clienteEntity.getContrato())
                //.responsavelContrato(clienteEntity.getResponsavelContrato())
                .dataNascimento(clienteEntity.getDataNascimento())
                .dataFundacao(clienteEntity.getDataFundacao())
                .build())
                .orElse(new ClienteTable());
    }
}