/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appportariasolo.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego_Note
 */
@Entity
@Table(name = "vizitante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vizitante.findAll", query = "SELECT v FROM Vizitante v")
    , @NamedQuery(name = "Vizitante.findByIdVizitante", query = "SELECT v FROM Vizitante v WHERE v.idVizitante = :idVizitante")})
public class Vizitante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vizitante")
    private Integer idVizitante;
    @JoinColumn(name = "id_instituicao_fk", referencedColumnName = "id_instituicao")
    @ManyToOne
    private Instituicao idInstituicaoFk;
    @JoinColumn(name = "id_pessoa_geral_fk", referencedColumnName = "id_pessoa_geral")
    @ManyToOne
    private PessoaGeral idPessoaGeralFk;

    public Vizitante() {
    }

    public Vizitante(Integer idVizitante) {
        this.idVizitante = idVizitante;
    }

    public Integer getIdVizitante() {
        return idVizitante;
    }

    public void setIdVizitante(Integer idVizitante) {
        this.idVizitante = idVizitante;
    }

    public Instituicao getIdInstituicaoFk() {
        return idInstituicaoFk;
    }

    public void setIdInstituicaoFk(Instituicao idInstituicaoFk) {
        this.idInstituicaoFk = idInstituicaoFk;
    }

    public PessoaGeral getIdPessoaGeralFk() {
        return idPessoaGeralFk;
    }

    public void setIdPessoaGeralFk(PessoaGeral idPessoaGeralFk) {
        this.idPessoaGeralFk = idPessoaGeralFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVizitante != null ? idVizitante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vizitante)) {
            return false;
        }
        Vizitante other = (Vizitante) object;
        if ((this.idVizitante == null && other.idVizitante != null) || (this.idVizitante != null && !this.idVizitante.equals(other.idVizitante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.appportariasolo.controle.Vizitante[ idVizitante=" + idVizitante + " ]";
    }
    
}
