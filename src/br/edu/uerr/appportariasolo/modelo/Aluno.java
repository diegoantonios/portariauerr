/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appportariasolo.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego_Note
 */
@Entity
@Table(name = "aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a")
    , @NamedQuery(name = "Aluno.findByIdAluno", query = "SELECT a FROM Aluno a WHERE a.idAluno = :idAluno")
    , @NamedQuery(name = "Aluno.findByMatricula", query = "SELECT a FROM Aluno a WHERE a.matricula = :matricula")})
public class Aluno implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aluno")
    private Integer idAluno;
    @Column(name = "matricula")
    private String matricula;
    @JoinColumn(name = "id_curso_fk", referencedColumnName = "id_curso")
    @ManyToOne
    private Curso idCursoFk;
    @JoinColumn(name = "id_pessoa_geral_fk", referencedColumnName = "id_pessoa_geral")
    @ManyToOne
    private PessoaGeral idPessoaGeralFk;
    @JoinColumn(name = "id_setor_fk", referencedColumnName = "id_setor")
    @ManyToOne
    private Setor idSetorFk;

    public Aluno() {
    }

    public Aluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        Integer oldIdAluno = this.idAluno;
        this.idAluno = idAluno;
        changeSupport.firePropertyChange("idAluno", oldIdAluno, idAluno);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        String oldMatricula = this.matricula;
        this.matricula = matricula;
        changeSupport.firePropertyChange("matricula", oldMatricula, matricula);
    }

    public Curso getIdCursoFk() {
        return idCursoFk;
    }

    public void setIdCursoFk(Curso idCursoFk) {
        Curso oldIdCursoFk = this.idCursoFk;
        this.idCursoFk = idCursoFk;
        changeSupport.firePropertyChange("idCursoFk", oldIdCursoFk, idCursoFk);
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAluno != null ? idAluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.idAluno == null && other.idAluno != null) || (this.idAluno != null && !this.idAluno.equals(other.idAluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.appportariasolo.controle.Aluno[ idAluno=" + idAluno + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
