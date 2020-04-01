package br.com.sig.msadmin.entrypoint.entity;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteHttpModel {

    private Long id;
    private Integer tipoCliente;

    private String nome;
    private String nomeSocial;
    private String nomeFantasia;

    private String rg;
    private String cpf;
    private String cnpj;

    private List<EnderecoHttpModel> enderecos;
    private List<TelefoneHttpModel> telefones;
    private String email;
    
    private String contrato;
    //TODO finalizar ResponsavelHttpModel
    //private ResponsavelEntity responsavelContrato;

    private Date dataNascimento;
    private Date dataFundacao;
	
}
