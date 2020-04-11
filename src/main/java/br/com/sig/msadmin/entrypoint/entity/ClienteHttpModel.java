package br.com.sig.msadmin.entrypoint.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    @JsonProperty("tipo_cliente")
    private Integer tipoCliente;

    @JsonAlias({"nome_cliente"})
    private String nome;

    @JsonProperty("nome_social")
    private String nomeSocial;

    @JsonProperty("nome_fantasia")
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

    @JsonProperty("data_nascimento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @JsonProperty("data_fundacao")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataFundacao;
	
}
