/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appportariasolo.modelo;

/**
 *
 * @author Diego_Note
 */
public class StatusPessoa {
    private String NOME;
    private String CPF;
    private String TIPO;
    private String SETOR;

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    public String getSETOR() {
        return SETOR;
    }

    public void setSETOR(String SETOR) {
        this.SETOR = SETOR;
    }
    
    
    
}
