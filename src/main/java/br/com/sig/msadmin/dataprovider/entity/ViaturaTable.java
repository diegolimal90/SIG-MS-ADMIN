package br.com.sig.msadmin.dataprovider.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ViaturaTable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cd_ano_viatura")
    private Integer ano;

    @Column(name = "nm_placa_viatura")
    private String placa;
    
    @Column(name = "nm_fabricante_viatura")
    private String fabricante;

    @Column(name = "vl_quilometragem_atual_viatura")
    private Integer quilometragem_atual;

    @Column(name = "vl_quilometragem_inicial_viatura")
    private Integer quilometragem_inicial;

    @Column(name = "dt_cadastro")
    private Date dataCadastro;

    @Column(name = "dt_alteracao")
    private Date dataAlteracao;
    
    @Column(name = "dt_desativacao")
    private Date dataDesativacao;
    
    @Column(name = "cd_cadastro_viatura")
    private Long idCadastro;
    
    @Column(name = "cd_alteracao_viatura")
    private Long idAlteracao;
    
    @Column(name = "cd_desativacao_viatura")
	private Long idDesativacao;

}