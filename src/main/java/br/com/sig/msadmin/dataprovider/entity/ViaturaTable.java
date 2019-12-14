package br.com.sig.msadmin.dataprovider.entity;

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
    private long id;

    @Column(name = "cd_ano_viatura")
    private int ano;

    @Column(name = "nm_placa_viatura")
    private String placa;
    
    @Column(name = "nm_fabricante_viatura")
    private String fabricante;

    @Column(name = "cd_quilometragem_atual_viatura")
    private int quilometragem_atual;

    @Column(name = "cd_quilometragem_inicial_viatura")
    private int quilometragem_inicial;

    //TODO Adicionar dt_criacao, dt_alteracao, nm_de_alteracao na table

}