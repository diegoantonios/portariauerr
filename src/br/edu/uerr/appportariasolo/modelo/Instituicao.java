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
@Table(name = "instituicao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instituicao.findAll", query = "SELECT i FROM Instituicao i")
    , @NamedQuery(name = "Instituicao.findByIdInstituicao", query = "SELECT i FROM Instituicao i WHERE i.idInstituicao = :idInstituicao")
    , @NamedQuery(name = "Instituicao.findByNomeInstituicao", query = "SELECT i FROM Instituicao i WHERE i.nomeInstituicao = :nomeInstituicao")
    , @NamedQuery(name = "Instituicao.findBySigla", query = "SELECT i FROM Instituicao i WHERE i.sigla = :sigla")
    , @NamedQuery(name = "Instituicao.findByCnpj", query = "SELECT i FROM Instituicao i WHERE i.cnpj = :cnpj")
    , @NamedQuery(name = "Instituicao.findByCep", query = "SELECT i FROM Instituicao i WHERE i.cep = :cep")
    , @NamedQuery(name = "Instituicao.findByLogradouro", query = "SELECT i FROM Instituicao i WHERE i.logradouro = :logradouro")
    , @NamedQuery(name = "Instituicao.findByNumero", query = "SELECT i FROM Instituicao i WHERE i.numero = :numero")
    , @NamedQuery(name = "Instituicao.findByBairro", query = "SELECT i FROM Instituicao i WHERE i.bairro = :bairro")
    , @NamedQuery(name = "Instituicao.findByLocalidade", query = "SELECT i FROM Instituicao i WHERE i.localidade = :localidade")
    , @NamedQuery(name = "Instituicao.findByUf", query = "SELECT i FROM Instituicao i WHERE i.uf = :uf")
    , @NamedQuery(name = "Instituicao.findByTelefone", query = "SELECT i FROM Instituicao i WHERE i.telefone = :telefone")
    , @NamedQuery(name = "Instituicao.findByCelular", query = "SELECT i FROM Instituicao i WHERE i.celular = :celular")
    , @NamedQuery(name = "Instituicao.findByDataInfo", query = "SELECT i FROM Instituicao i WHERE i.dataInfo = :dataInfo")
    , @NamedQuery(name = "Instituicao.findByEmail", query = "SELECT i FROM Instituicao i WHERE i.email = :email")
    , @NamedQuery(name = "Instituicao.findByResponsavel", query = "SELECT i FROM Instituicao i WHERE i.responsavel = :responsavel")})
public class Instituicao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_instituicao")
    private Integer idInstituicao;
    @Column(name = "nome_instituicao")
    private String nomeInstituicao;
    @Column(name = "sigla")
    private String sigla;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "cep")
    private String cep;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "numero")
    private String numero;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "localidade")
    private String localidade;
    @Column(name = "uf")
    private String uf;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "celular")
    private String celular;
    @Column(name = "data_info")
    @Temporal(TemporalType.DATE)
    private Date dataInfo;
    @Column(name = "email")
    private String email;
    @Column(name = "responsavel")
    private String responsavel;
    @OneToMany(mappedBy = "idInstituicaoFk")
    private List<Setor> setorList;
    @OneToMany(mappedBy = "idInstituicaoFk")
    private List<Vizitante> vizitanteList;

    public Instituicao() {
    }

    public Instituicao(Integer idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    public Integer getIdInstituicao() {
        return idInstituicao;
    }

    public void setIdInstituicao(Integer idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getDataInfo() {
        return dataInfo;
    }

    public void setDataInfo(Date dataInfo) {
        this.dataInfo = dataInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    @XmlTransient
    public List<Setor> getSetorList() {
        return setorList;
    }

    public void setSetorList(List<Setor> setorList) {
        this.setorList = setorList;
    }

    @XmlTransient
    public List<Vizitante> getVizitanteList() {
        return vizitanteList;
    }

    public void setVizitanteList(List<Vizitante> vizitanteList) {
        this.vizitanteList = vizitanteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstituicao != null ? idInstituicao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instituicao)) {
            return false;
        }
        Instituicao other = (Instituicao) object;
        if ((this.idInstituicao == null && other.idInstituicao != null) || (this.idInstituicao != null && !this.idInstituicao.equals(other.idInstituicao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.appportariasolo.controle.Instituicao[ idInstituicao=" + idInstituicao + " ]";
    }
    
}
