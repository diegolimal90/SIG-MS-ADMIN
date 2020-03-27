package br.com.sig.msadmin.dataprovider.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class ResponsavelTable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @ManyToOne(fetch=FetchType.EAGER)
    // @JoinColumn(name="cliente_id")
    // private ClienteTable cliente;

    @Column(name = "nm_cliente")
    private String nome;
    
    @Column(name = "cd_cpf")
    private String cpf;
    @Column(name = "cd_rg")
    private String rg;

    //TODO Alterar para List<EnderecoEntity>
    // private List<EnderecoTable> endereco;
    @OneToMany(mappedBy = "responsavel", cascade = CascadeType.ALL)
    private List<TelefoneTable> telefones;
    @Column(name = "ds_email")
    private String email;

    @Column(name = "dt_nascimento")
    private Date dataNascimento;

}