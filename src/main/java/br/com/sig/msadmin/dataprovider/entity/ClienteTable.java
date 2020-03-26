package br.com.sig.msadmin.dataprovider.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ClienteTable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cd_tipo_cliente", nullable=false)
    private Integer tipoCliente;

    @Column(name = "nm_cliente", nullable=false)
    private String nome;
    @Column(name = "nm_social")
    private String nomeSocial;
    @Column(name = "nm_fantasia")
    private String nomeFantasia;

    @Column(name = "cd_cpf")
    private String cpf;
    @Column(name = "cd_cnpj")
    private String cnpj;

    //TODO Alterar para List<EnderecoEntity>
    private String endereco;

    @OneToMany(mappedBy = "cliente")
    private List<TelefoneTable> telefones;
    @Column(name = "ds_email")
    private String email;
    
    @Column(name = "ds_contrato")
    private String contrato;

    @Column(name = "dt_nascimento")
    private Date dataNascimento;
    @Column(name = "dt_fundacao")
    private Date dataFundacao;

}