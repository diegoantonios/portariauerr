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
@Table(name = "pessoa_geral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PessoaGeral.findAll", query = "SELECT p FROM PessoaGeral p")
    , @NamedQuery(name = "PessoaGeral.findByIdPessoaGeral", query = "SELECT p FROM PessoaGeral p WHERE p.idPessoaGeral = :idPessoaGeral")
    , @NamedQuery(name = "PessoaGeral.findByBairro", query = "SELECT p FROM PessoaGeral p WHERE p.bairro = :bairro")
    , @NamedQuery(name = "PessoaGeral.findByCelular", query = "SELECT p FROM PessoaGeral p WHERE p.celular = :celular")
    , @NamedQuery(name = "PessoaGeral.findByCep", query = "SELECT p FROM PessoaGeral p WHERE p.cep = :cep")
    , @NamedQuery(name = "PessoaGeral.findByCidade", query = "SELECT p FROM PessoaGeral p WHERE p.cidade = :cidade")
    , @NamedQuery(name = "PessoaGeral.findByCpf", query = "SELECT p FROM PessoaGeral p WHERE p.cpf = :cpf")
    , @NamedQuery(name = "PessoaGeral.findByDatadenascimento", query = "SELECT p FROM PessoaGeral p WHERE p.datadenascimento = :datadenascimento")
    , @NamedQuery(name = "PessoaGeral.findByEmail", query = "SELECT p FROM PessoaGeral p WHERE p.email = :email")
    , @NamedQuery(name = "PessoaGeral.findByEndereco", query = "SELECT p FROM PessoaGeral p WHERE p.endereco = :endereco")
    , @NamedQuery(name = "PessoaGeral.findByNome", query = "SELECT p FROM PessoaGeral p WHERE p.nome = :nome")
    , @NamedQuery(name = "PessoaGeral.findByNumero", query = "SELECT p FROM PessoaGeral p WHERE p.numero = :numero")
    , @NamedQuery(name = "PessoaGeral.findByRg", query = "SELECT p FROM PessoaGeral p WHERE p.rg = :rg")
    , @NamedQuery(name = "PessoaGeral.findBySexo", query = "SELECT p FROM PessoaGeral p WHERE p.sexo = :sexo")
    , @NamedQuery(name = "PessoaGeral.findByTelefone", query = "SELECT p FROM PessoaGeral p WHERE p.telefone = :telefone")
    , @NamedQuery(name = "PessoaGeral.findByUf", query = "SELECT p FROM PessoaGeral p WHERE p.uf = :uf")})
public class PessoaGeral implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pessoa_geral")
    private Integer idPessoaGeral;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "celular")
    private String celular;
    @Column(name = "cep")
    private String cep;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "datadenascimento")
    @Temporal(TemporalType.DATE)
    private Date datadenascimento;
    @Column(name = "email")
    private String email;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "nome")
    private String nome;
    @Column(name = "numero")
    private String numero;
    @Column(name = "rg")
    private String rg;
    @Column(name = "sexo")
    private Integer sexo;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "uf")
    private String uf;

    public PessoaGeral() {
    }

    public PessoaGeral(Integer idPessoaGeral) {
        this.idPessoaGeral = idPessoaGeral;
    }

    public Integer getIdPessoaGeral() {
        return idPessoaGeral;
    }

    public void setIdPessoaGeral(Integer idPessoaGeral) {
        Integer oldIdPessoaGeral = this.idPessoaGeral;
        this.idPessoaGeral = idPessoaGeral;
        changeSupport.firePropertyChange("idPessoaGeral", oldIdPessoaGeral, idPessoaGeral);
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        String oldBairro = this.bairro;
        this.bairro = bairro;
        changeSupport.firePropertyChange("bairro", oldBairro, bairro);
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        String oldCelular = this.celular;
        this.celular = celular;
        changeSupport.firePropertyChange("celular", oldCelular, celular);
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        String oldCep = this.cep;
        this.cep = cep;
        changeSupport.firePropertyChange("cep", oldCep, cep);
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        String oldCidade = this.cidade;
        this.cidade = cidade;
        changeSupport.firePropertyChange("cidade", oldCidade, cidade);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        changeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }

    public Date getDatadenascimento() {
        return datadenascimento;
    }

    public void setDatadenascimento(Date datadenascimento) {
        Date oldDatadenascimento = this.datadenascimento;
        this.datadenascimento = datadenascimento;
        changeSupport.firePropertyChange("datadenascimento", oldDatadenascimento, datadenascimento);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        String oldEndereco = this.endereco;
        this.endereco = endereco;
        changeSupport.firePropertyChange("endereco", oldEndereco, endereco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        String oldNumero = this.numero;
        this.numero = numero;
        changeSupport.firePropertyChange("numero", oldNumero, numero);
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        String oldRg = this.rg;
        this.rg = rg;
        changeSupport.firePropertyChange("rg", oldRg, rg);
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        Integer oldSexo = this.sexo;
        this.sexo = sexo;
        changeSupport.firePropertyChange("sexo", oldSexo, sexo);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        String oldTelefone = this.telefone;
        this.telefone = telefone;
        changeSupport.firePropertyChange("telefone", oldTelefone, telefone);
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        String oldUf = this.uf;
        this.uf = uf;
        changeSupport.firePropertyChange("uf", oldUf, uf);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPessoaGeral != null ? idPessoaGeral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaGeral)) {
            return false;
        }
        PessoaGeral other = (PessoaGeral) object;
        if ((this.idPessoaGeral == null && other.idPessoaGeral != null) || (this.idPessoaGeral != null && !this.idPessoaGeral.equals(other.idPessoaGeral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
