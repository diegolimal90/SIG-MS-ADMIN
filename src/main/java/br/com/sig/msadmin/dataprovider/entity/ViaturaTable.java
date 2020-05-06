package br.com.sig.msadmin.dataprovider.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
    @Column(name = "id_viatura", nullable=false)
    private Long id;
    
    @Column(name = "dt_cadastro_viatura", nullable=false)
    private Date dataCadastro;
    
    @Column(name = "cd_identificacao", nullable=false)
    private String identificacao;
    
    @Column(name = "cd_placa_viatura", nullable=false)
    private String placa;

    @Column(name = "ano_viatura", nullable=false)
    private Integer ano;
   
    @Column(name = "ds_fabricante", nullable=false)
    private String fabricante;

    @Column(name = "dt_km_inicial", nullable=false)
    private Date dataQuilometragemInicial;
    
    @Column(name = "nr_km_inicial", nullable=false)
    private Integer quilometragemInicial;
    
    @Column(name = "dt_km_final", nullable=false)
    private Date dataQuilometragemFinal;
    
    @Column(name = "nr_km_final", nullable=false)
    private Integer quilometragemFinal;
    
    @Column(name = "ds_viatura", nullable=false)
    private String dsViatura;
    
    @Column(name = "ds_observacao", nullable=false)
    private String dsObservacao;
    
  //  @ManyToOne
   // @JoinColumn(name = "id_usuario_gravacao", nullable = false)
  //  private SegUsuarioTable usuarioGravacao;
    
   
    @Column(name = "dt_gravacao_viatura", nullable=false)
    private Date dataGravacao;
    
    @Column(name = "dt_alt_viatura", nullable=false)
    private Date dataAlteracao;
    
    //  @ManyToOne
    // @JoinColumn(name = "seg_id_usuario", nullable = false)
   //  private SegUsuarioTable usuario;
    
   /* @Column(name = "dataDesativacao", nullable=false)
    private Date dataDesativacao;
    
    @Column(name = "idCadastro", nullable=false)
    private Long idCadastro;
    
    @Column(name = "idAlteracao", nullable=false)
    private Long idAlteracao;
    
    @Column(name = "idDesaticavao", nullable=false)
    private  Long idDesativacao;
    
    */ 
   
}