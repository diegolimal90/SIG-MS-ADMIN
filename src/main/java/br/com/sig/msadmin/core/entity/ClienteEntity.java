package br.com.sig.msadmin.core.entity;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEntity{

    private Long id;
    private Integer tipoCliente;

    private String nome;
    private String nomeSocial;
    private String nomeFantasia;

    private String rg;
    private String cpf;
    private String cnpj;

    private List<EnderecoEntity> enderecos;
    private List<TelefoneEntity> telefones;
    private String email;
    
    private String contrato;
    private ResponsavelEntity responsavelContrato;

    private Date dataNascimento;
    private Date dataFundacao;
     
}