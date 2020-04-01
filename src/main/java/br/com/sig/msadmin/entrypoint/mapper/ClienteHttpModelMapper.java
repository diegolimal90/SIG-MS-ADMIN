package br.com.sig.msadmin.entrypoint.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.sig.msadmin.core.entity.BairroEntity;
import br.com.sig.msadmin.core.entity.CidadeEntity;
import br.com.sig.msadmin.core.entity.ClienteEntity;
import br.com.sig.msadmin.core.entity.EnderecoEntity;
import br.com.sig.msadmin.core.entity.EstadoEntity;
import br.com.sig.msadmin.core.entity.TelefoneEntity;
import br.com.sig.msadmin.core.entity.TipoLogradouroEntity;
import br.com.sig.msadmin.entrypoint.entity.ClienteHttpModel;
import br.com.sig.msadmin.entrypoint.entity.EnderecoHttpModel;
import br.com.sig.msadmin.entrypoint.entity.TelefoneHttpModel;

public class ClienteHttpModelMapper{
    //TODO Ativar Endereço e ResponsavelContrato
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
                .enderecos(toEndereco(e))
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

    private static List<TelefoneEntity> toTelefone(ClienteHttpModel httpModel){
        List<TelefoneEntity> telefones = new ArrayList<>();

        for(TelefoneHttpModel telefone: httpModel.getTelefones() ){
            telefones.add(
                TelefoneEntity.builder().id(telefone.getId()).telefone(telefone.getTelefone()).build()
            );
        }
        
        return telefones;
    }
	
	private static List<EnderecoEntity> toEndereco(ClienteHttpModel httpModel) {
		List<EnderecoEntity> enderecos = new ArrayList<>();

        for(EnderecoHttpModel endereco: httpModel.getEnderecos()){
            enderecos.add(
                EnderecoEntity.builder()
                    .tpLogradouro(TipoLogradouroEntity.builder()
                                    .nmTpLogradouro(endereco.getTpLogradouro())
                                    .build())
                    .nmLogradouro(endereco.getNmLogradouro())
                    .dsComplemento(endereco.getDsComplemento())
                    .nrCep(endereco.getNrCep())
                    .bairro(BairroEntity.builder()
                            .nmBairro(endereco.getBairro())
                    .cidade(CidadeEntity.builder()
                            .nmCidade(endereco.getCidade())
                            .estado(EstadoEntity.builder()
                                    .nmEstado(endereco.getEstado())
                                    .build())
                            .build())
                    .build())
                .build()
            );
        }
                
        return enderecos;
    }
    
    /*

        From...

    */

    private static List<TelefoneHttpModel> fromTelefone(ClienteEntity entity){
        List<TelefoneHttpModel> telefones = new ArrayList<>();

        for(TelefoneEntity telefone: entity.getTelefones()){
            telefones.add(
                TelefoneHttpModel.builder().id(telefone.getId()).telefone(telefone.getTelefone()).build()
            );
        }

        return telefones;
    }

    //FIXME Corrigir o fromEndereco
    private static List<EnderecoHttpModel> fromEndereco(ClienteEntity entity) {
        List<EnderecoHttpModel> enderecos = new ArrayList<>();

        for(EnderecoEntity endereco: entity.getEnderecos()){
            enderecos.add(
                EnderecoHttpModel.builder()
                    .tpLogradouro(endereco.getTpLogradouro().getNmTpLogradouro())
                    .nmLogradouro(endereco.getNmLogradouro())
                    .dsComplemento(endereco.getDsComplemento())
                    .nrCep(endereco.getNrCep())
                    .bairro(endereco.getBairro().getNmBairro())
                    .cidade(endereco.getBairro().getCidade().getNmCidade())
                    .estado(endereco.getBairro().getCidade().getEstado().getNmEstado())
                .build()
            );
        }
                
        return enderecos;
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
                .enderecos(fromEndereco(e))
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