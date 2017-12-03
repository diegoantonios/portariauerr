/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appportariasolo.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego_Note
 */
@Entity
@Table(name = "portaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Portaria.findAll", query = "SELECT p FROM Portaria p")
    , @NamedQuery(name = "Portaria.findByIdPortaria", query = "SELECT p FROM Portaria p WHERE p.idPortaria = :idPortaria")
    , @NamedQuery(name = "Portaria.findByDescricao", query = "SELECT p FROM Portaria p WHERE p.descricao = :descricao")
    , @NamedQuery(name = "Portaria.findByDataHoraEntrada", query = "SELECT p FROM Portaria p WHERE p.dataHoraEntrada = :dataHoraEntrada")
    , @NamedQuery(name = "Portaria.findByDataHoraSaida", query = "SELECT p FROM Portaria p WHERE p.dataHoraSaida = :dataHoraSaida")})
public class Portaria implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_portaria")
    private Integer idPortaria;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "data_hora_entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraEntrada;
    @Column(name = "data_hora_saida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraSaida;
    @JoinColumn(name = "id_pessoa_geral", referencedColumnName = "id_pessoa_geral")
    @ManyToOne
    private PessoaGeral idPessoaGeral;

    public Portaria() {
    }

    public Portaria(Integer idPortaria) {
        this.idPortaria = idPortaria;
    }

    public Integer getIdPortaria() {
        return idPortaria;
    }

    public void setIdPortaria(Integer idPortaria) {
        Integer oldIdPortaria = this.idPortaria;
        this.idPortaria = idPortaria;
        changeSupport.firePropertyChange("idPortaria", oldIdPortaria, idPortaria);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public Date getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(Date dataHoraEntrada) {
        Date oldDataHoraEntrada = this.dataHoraEntrada;
        this.dataHoraEntrada = dataHoraEntrada;
        changeSupport.firePropertyChange("dataHoraEntrada", oldDataHoraEntrada, dataHoraEntrada);
    }

    public Date getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(Date dataHoraSaida) {
        Date oldDataHoraSaida = this.dataHoraSaida;
        this.dataHoraSaida = dataHoraSaida;
        changeSupport.firePropertyChange("dataHoraSaida", oldDataHoraSaida, dataHoraSaida);
    }

    public PessoaGeral getIdPessoaGeral() {
        return idPessoaGeral;
    }

    public void setIdPessoaGeral(PessoaGeral idPessoaGeral) {
        PessoaGeral oldIdPessoaGeral = this.idPessoaGeral;
        this.idPessoaGeral = idPessoaGeral;
        changeSupport.firePropertyChange("idPessoaGeral", oldIdPessoaGeral, idPessoaGeral);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPortaria != null ? idPortaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Portaria)) {
            return false;
        }
        Portaria other = (Portaria) object;
        if ((this.idPortaria == null && other.idPortaria != null) || (this.idPortaria != null && !this.idPortaria.equals(other.idPortaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.appportariasolo.controle.Portaria[ idPortaria=" + idPortaria + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
