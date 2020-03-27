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
public class ResponsavelEntity{

    private Long id;

    private String nome;

    private String cpf;
    private String rg;

    private List<EnderecoEntity> enderecos;
    private List<TelefoneEntity> telefones;
    private String email;

    private Date dataNascimento;
     
}