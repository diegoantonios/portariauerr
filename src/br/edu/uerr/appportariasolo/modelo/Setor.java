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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "setor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Setor.findAll", query = "SELECT s FROM Setor s")
    , @NamedQuery(name = "Setor.findByIdSetor", query = "SELECT s FROM Setor s WHERE s.idSetor = :idSetor")
    , @NamedQuery(name = "Setor.findByNomeSetor", query = "SELECT s FROM Setor s WHERE s.nomeSetor = :nomeSetor")
    , @NamedQuery(name = "Setor.findBySigla", query = "SELECT s FROM Setor s WHERE s.sigla = :sigla")
    , @NamedQuery(name = "Setor.findByRamal", query = "SELECT s FROM Setor s WHERE s.ramal = :ramal")
    , @NamedQuery(name = "Setor.findByEmail", query = "SELECT s FROM Setor s WHERE s.email = :email")
    , @NamedQuery(name = "Setor.findByDataInfo", query = "SELECT s FROM Setor s WHERE s.dataInfo = :dataInfo")})
public class Setor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_setor")
    private Integer idSetor;
    @Column(name = "nome_setor")
    private String nomeSetor;
    @Column(name = "sigla")
    private String sigla;
    @Column(name = "ramal")
    private String ramal;
    @Column(name = "email")
    private String email;
    @Column(name = "data_info")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInfo;
    @JoinColumn(name = "id_instituicao_fk", referencedColumnName = "id_instituicao")
    @ManyToOne
    private Instituicao idInstituicaoFk;
    @OneToMany(mappedBy = "idSetorFk")
    private List<Aluno> alunoList;
    @OneToMany(mappedBy = "idSetorFk")
    private List<Funcionario> funcionarioList;

    public Setor() {
    }

    public Setor(Integer idSetor) {
        this.idSetor = idSetor;
    }

    public Integer getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Integer idSetor) {
        this.idSetor = idSetor;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataInfo() {
        return dataInfo;
    }

    public void setDataInfo(Date dataInfo) {
        this.dataInfo = dataInfo;
    }

    public Instituicao getIdInstituicaoFk() {
        return idInstituicaoFk;
    }

    public void setIdInstituicaoFk(Instituicao idInstituicaoFk) {
        this.idInstituicaoFk = idInstituicaoFk;
    }

    @XmlTransient
    public List<Aluno> getAlunoList() {
        return alunoList;
    }

    public void setAlunoList(List<Aluno> alunoList) {
        this.alunoList = alunoList;
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
        hash += (idSetor != null ? idSetor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Setor)) {
            return false;
        }
        Setor other = (Setor) object;
        if ((this.idSetor == null && other.idSetor != null) || (this.idSetor != null && !this.idSetor.equals(other.idSetor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.appportariasolo.controle.Setor[ idSetor=" + idSetor + " ]";
    }
    
}
