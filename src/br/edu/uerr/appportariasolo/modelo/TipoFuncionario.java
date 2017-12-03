/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appportariasolo.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego_Note
 */
@Entity
@Table(name = "tipo_funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoFuncionario.findAll", query = "SELECT t FROM TipoFuncionario t")
    , @NamedQuery(name = "TipoFuncionario.findByIdTipoFuncionario", query = "SELECT t FROM TipoFuncionario t WHERE t.idTipoFuncionario = :idTipoFuncionario")
    , @NamedQuery(name = "TipoFuncionario.findByNome", query = "SELECT t FROM TipoFuncionario t WHERE t.nome = :nome")
    , @NamedQuery(name = "TipoFuncionario.findByDataInfo", query = "SELECT t FROM TipoFuncionario t WHERE t.dataInfo = :dataInfo")})
public class TipoFuncionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_funcionario")
    private Integer idTipoFuncionario;
    @Column(name = "nome")
    private String nome;
    @Column(name = "data_info")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInfo;
    @OneToMany(mappedBy = "idTipoFuncionarioFk")
    private List<Funcionario> funcionarioList;

    public TipoFuncionario() {
    }

    public TipoFuncionario(Integer idTipoFuncionario) {
        this.idTipoFuncionario = idTipoFuncionario;
    }

    public Integer getIdTipoFuncionario() {
        return idTipoFuncionario;
    }

    public void setIdTipoFuncionario(Integer idTipoFuncionario) {
        this.idTipoFuncionario = idTipoFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInfo() {
        return dataInfo;
    }

    public void setDataInfo(Date dataInfo) {
        this.dataInfo = dataInfo;
    }

    @XmlTransient
    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoFuncionario != null ? idTipoFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoFuncionario)) {
            return false;
        }
        TipoFuncionario other = (TipoFuncionario) object;
        if ((this.idTipoFuncionario == null && other.idTipoFuncionario != null) || (this.idTipoFuncionario != null && !this.idTipoFuncionario.equals(other.idTipoFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.appportariasolo.controle.TipoFuncionario[ idTipoFuncionario=" + idTipoFuncionario + " ]";
    }
    
}
