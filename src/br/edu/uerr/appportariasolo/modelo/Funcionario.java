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
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")
    , @NamedQuery(name = "Funcionario.findByIdFuncionario", query = "SELECT f FROM Funcionario f WHERE f.idFuncionario = :idFuncionario")
    , @NamedQuery(name = "Funcionario.findByConta", query = "SELECT f FROM Funcionario f WHERE f.conta = :conta")
    , @NamedQuery(name = "Funcionario.findBySenha", query = "SELECT f FROM Funcionario f WHERE f.senha = :senha")
    , @NamedQuery(name = "Funcionario.findByMatricula", query = "SELECT f FROM Funcionario f WHERE f.matricula = :matricula")
    , @NamedQuery(name = "Funcionario.findByStatus", query = "SELECT f FROM Funcionario f WHERE f.status = :status")
    , @NamedQuery(name = "Funcionario.findByDataIn", query = "SELECT f FROM Funcionario f WHERE f.dataIn = :dataIn")
    , @NamedQuery(name = "Funcionario.findByDataOut", query = "SELECT f FROM Funcionario f WHERE f.dataOut = :dataOut")
    , @NamedQuery(name = "Funcionario.findByDataInfo", query = "SELECT f FROM Funcionario f WHERE f.dataInfo = :dataInfo")
    , @NamedQuery(name = "Funcionario.findByHistorico", query = "SELECT f FROM Funcionario f WHERE f.historico = :historico")})
public class Funcionario implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_funcionario")
    private Integer idFuncionario;
    @Column(name = "conta")
    private String conta;
    @Column(name = "senha")
    private String senha;
    @Column(name = "matricula")
    private String matricula;
    @Column(name = "status")
    private Integer status;
    @Column(name = "data_in")
    @Temporal(TemporalType.DATE)
    private Date dataIn;
    @Column(name = "data_out")
    @Temporal(TemporalType.DATE)
    private Date dataOut;
    @Column(name = "data_info")
    @Temporal(TemporalType.DATE)
    private Date dataInfo;
    @Column(name = "historico")
    private String historico;
    @JoinColumn(name = "id_pessoa_geral_fk", referencedColumnName = "id_pessoa_geral")
    @ManyToOne
    private PessoaGeral idPessoaGeralFk;
    @JoinColumn(name = "id_setor_fk", referencedColumnName = "id_setor")
    @ManyToOne
    private Setor idSetorFk;
    @JoinColumn(name = "id_tipo_funcionario_fk", referencedColumnName = "id_tipo_funcionario")
    @ManyToOne
    private TipoFuncionario idTipoFuncionarioFk;

    public Funcionario() {
        super();
    }

    public Funcionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        Integer oldIdFuncionario = this.idFuncionario;
        this.idFuncionario = idFuncionario;
        changeSupport.firePropertyChange("idFuncionario", oldIdFuncionario, idFuncionario);
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        String oldConta = this.conta;
        this.conta = conta;
        changeSupport.firePropertyChange("conta", oldConta, conta);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        String oldSenha = this.senha;
        this.senha = senha;
        changeSupport.firePropertyChange("senha", oldSenha, senha);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        String oldMatricula = this.matricula;
        this.matricula = matricula;
        changeSupport.firePropertyChange("matricula", oldMatricula, matricula);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        Integer oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public Date getDataIn() {
        return dataIn;
    }

    public void setDataIn(Date dataIn) {
        Date oldDataIn = this.dataIn;
        this.dataIn = dataIn;
        changeSupport.firePropertyChange("dataIn", oldDataIn, dataIn);
    }

    public Date getDataOut() {
        return dataOut;
    }

    public void setDataOut(Date dataOut) {
        Date oldDataOut = this.dataOut;
        this.dataOut = dataOut;
        changeSupport.firePropertyChange("dataOut", oldDataOut, dataOut);
    }

    public Date getDataInfo() {
        return dataInfo;
    }

    public void setDataInfo(Date dataInfo) {
        Date oldDataInfo = this.dataInfo;
        this.dataInfo = dataInfo;
        changeSupport.firePropertyChange("dataInfo", oldDataInfo, dataInfo);
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        String oldHistorico = this.historico;
        this.historico = historico;
        changeSupport.firePropertyChange("historico", oldHistorico, historico);
    }

    public PessoaGeral getIdPessoaGeralFk() {
        return idPessoaGeralFk;
    }

    public void setIdPessoaGeralFk(PessoaGeral idPessoaGeralFk) {
        PessoaGeral oldIdPessoaGeralFk = this.idPessoaGeralFk;
        this.idPessoaGeralFk = idPessoaGeralFk;
        changeSupport.firePropertyChange("idPessoaGeralFk", oldIdPessoaGeralFk, idPessoaGeralFk);
    }

    public Setor getIdSetorFk() {
        return idSetorFk;
    }

    public void setIdSetorFk(Setor idSetorFk) {
        Setor oldIdSetorFk = this.idSetorFk;
        this.idSetorFk = idSetorFk;
        changeSupport.firePropertyChange("idSetorFk", oldIdSetorFk, idSetorFk);
    }

    public TipoFuncionario getIdTipoFuncionarioFk() {
        return idTipoFuncionarioFk;
    }

    public void setIdTipoFuncionarioFk(TipoFuncionario idTipoFuncionarioFk) {
        TipoFuncionario oldIdTipoFuncionarioFk = this.idTipoFuncionarioFk;
        this.idTipoFuncionarioFk = idTipoFuncionarioFk;
        changeSupport.firePropertyChange("idTipoFuncionarioFk", oldIdTipoFuncionarioFk, idTipoFuncionarioFk);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncionario != null ? idFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.idFuncionario == null && other.idFuncionario != null) || (this.idFuncionario != null && !this.idFuncionario.equals(other.idFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.appportariasolo.controle.Funcionario[ idFuncionario=" + idFuncionario + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    
}
