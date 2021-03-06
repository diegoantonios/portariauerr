/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appportariasolo.visao;

import br.edu.uerr.appportariasolo.controler.PessoaGeralJpaController;
import br.edu.uerr.appportariasolo.controler.PortariaJpaController;
import br.edu.uerr.appportariasolo.modelo.PessoaGeral;
import br.edu.uerr.appportariasolo.modelo.Portaria;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import sun.swing.UIAction;

/**
 *
 * @author Diego_Note
 */
public class UIPortaria extends javax.swing.JFrame {

    /**
     * Creates new form UIPortaria
     */
    public UIPortaria() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        apportariasoloPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("apportariasoloPU").createEntityManager();
        pessoaGeralQuery = java.beans.Beans.isDesignTime() ? null : apportariasoloPUEntityManager.createQuery("SELECT p FROM PessoaGeral p");
        pessoaGeralList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : pessoaGeralQuery.getResultList();
        portariaQuery = java.beans.Beans.isDesignTime() ? null : apportariasoloPUEntityManager.createQuery("SELECT p FROM Portaria p");
        portariaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : portariaQuery.getResultList();
        funcionarioQuery = java.beans.Beans.isDesignTime() ? null : apportariasoloPUEntityManager.createQuery("SELECT f FROM Funcionario f");
        funcionarioList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : funcionarioQuery.getResultList();
        pessoaGeralQuery1 = java.beans.Beans.isDesignTime() ? null : apportariasoloPUEntityManager.createQuery("SELECT p FROM PessoaGeral p");
        pessoaGeralList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : pessoaGeralQuery1.getResultList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        vDescricao = new javax.swing.JTextArea();
        bvDataHora = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        vDataHora = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        vNomePessoaPortaria = new javax.swing.JTextField();
        vCpfPessoaPortaria = new javax.swing.JTextField();
        jbBuscarPessoa = new javax.swing.JButton();
        jbCadastroPessoaGeral = new javax.swing.JButton();
        jbEnviar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        vBuscaRg = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        vBuscaTipoPessoa = new javax.swing.JTextField();
        vBuscaCpf = new javax.swing.JTextField();
        vBuscaSexo = new javax.swing.JTextField();
        vBuscaCelular = new javax.swing.JTextField();
        vbuscaNome = new javax.swing.JTextField();
        vLimpar = new javax.swing.JButton();

        jButton5.setText("jButton5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Portaria Academica");
        jLabel1.setToolTipText("");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Data e Hora de Entrada");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Descrição e Motivo de Entrada");

        vDescricao.setColumns(20);
        vDescricao.setRows(5);
        jScrollPane1.setViewportView(vDescricao);

        bvDataHora.setText("Data e Hora Atual");
        bvDataHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bvDataHoraActionPerformed(evt);
            }
        });

        jLabel2.setText("Data/Hora");

        vDataHora.setText("dd/mm/aaaa hh/mm");
        vDataHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vDataHoraActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Pessoa");

        jLabel11.setText("Nome:");

        jLabel12.setText("CPF:");

        jbBuscarPessoa.setText("Buscar Pessoa");
        jbBuscarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarPessoaActionPerformed(evt);
            }
        });

        jbCadastroPessoaGeral.setText("Cadastrar Aluno");
        jbCadastroPessoaGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastroPessoaGeralActionPerformed(evt);
            }
        });

        jbEnviar.setText("Enviar Portaria");
        jbEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEnviarActionPerformed(evt);
            }
        });

        jLabel13.setText("Busca:");

        jButton4.setText("Buscar Portaria");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setText("Cadastrar Funcionario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton6.setText("Cadastrar Vizitante");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel7.setText("Nome:");

        jLabel8.setText("CPF:");

        jLabel14.setText("Rg:");

        jLabel15.setText("Sexo:");

        jLabel16.setText("Celular:");

        jLabel17.setText("Tipo da Pessoa");

        vBuscaTipoPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vBuscaTipoPessoaActionPerformed(evt);
            }
        });

        vbuscaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vbuscaNomeActionPerformed(evt);
            }
        });

        vLimpar.setText("Limpar");
        vLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(vCpfPessoaPortaria)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jbBuscarPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(vNomePessoaPortaria)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bvDataHora)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel9))
                                        .addGap(62, 62, 62))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(vbuscaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(115, 115, 115)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(vDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(vBuscaTipoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(30, 30, 30)
                                        .addComponent(vBuscaRg, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addComponent(vBuscaSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(vBuscaCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(vBuscaCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jbCadastroPessoaGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(vLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(vNomePessoaPortaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(vCpfPessoaPortaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarPessoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbCadastroPessoaGeral)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(vbuscaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(vBuscaCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(vBuscaRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(vBuscaSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(vBuscaCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(vBuscaTipoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bvDataHora)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(vDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEnviar)
                    .addComponent(vLimpar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vDataHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vDataHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vDataHoraActionPerformed

    private void jbCadastroPessoaGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastroPessoaGeralActionPerformed
        // TODO add your handling code here:
        UICadastroAluno al = new UICadastroAluno();
        UIPortaria po = new UIPortaria();
        al.setLocationRelativeTo(null);
        al.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        al.setResizable(false);
        al.setVisible(true);
        po.setVisible(false);
    }//GEN-LAST:event_jbCadastroPessoaGeralActionPerformed

    private void jbBuscarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarPessoaActionPerformed
        // TODO add your handling code here:
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("apportariasoloPU");
        PessoaGeralJpaController pessoaGeralJpaController = new PessoaGeralJpaController(emf);
        List<PessoaGeral> listaPessoa = new ArrayList<PessoaGeral>();
        PessoaGeral pessoa = new PessoaGeral();
        String nomePBusca = String.valueOf(vNomePessoaPortaria.getText());
        String cpfPBusca = (String) vCpfPessoaPortaria.getText();
        String nomeDbuscado = null;
        int sexoDBuscado = 0;
        try {

            listaPessoa = pessoaGeralJpaController.listaNomePessoa(nomePBusca, cpfPBusca);
            for (int i = 0; i <= listaPessoa.size(); i++) {
                nomeDbuscado = String.valueOf(listaPessoa.get(i));
                vbuscaNome.setText(nomeDbuscado);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {

            listaPessoa = pessoaGeralJpaController.listaCpfPessoa(nomePBusca, cpfPBusca);
            for (int i = 0; i <= listaPessoa.size(); i++) {
                nomeDbuscado = String.valueOf(listaPessoa.get(i));
                vBuscaCpf.setText(nomeDbuscado);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {

            listaPessoa = pessoaGeralJpaController.listaRgPessoa(nomePBusca, cpfPBusca);
            for (int i = 0; i <= listaPessoa.size(); i++) {
                nomeDbuscado = String.valueOf(listaPessoa.get(i));
                vBuscaRg.setText(nomeDbuscado);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {

            listaPessoa = pessoaGeralJpaController.listaSexoPessoa(nomePBusca, cpfPBusca);
            for (int i = 0; i <= listaPessoa.size(); i++) {
                nomeDbuscado = String.valueOf(listaPessoa.get(i));
                sexoDBuscado = Integer.valueOf(nomeDbuscado);
                if (sexoDBuscado == 1) {
                    vBuscaSexo.setText("Masculino");
                } else {
                    vBuscaSexo.setText("Feminino");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {

            listaPessoa = pessoaGeralJpaController.listaCelularPessoa(nomePBusca, cpfPBusca);
            for (int i = 0; i <= listaPessoa.size(); i++) {
                nomeDbuscado = String.valueOf(listaPessoa.get(i));
                vBuscaCelular.setText(nomeDbuscado);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {

            listaPessoa = pessoaGeralJpaController.listaTipoPessoaFunc(nomePBusca, cpfPBusca);
            for (int i = 0; i <= listaPessoa.size(); i++) {
                nomeDbuscado = String.valueOf(listaPessoa.get(i));
                if (Objects.equals(nomeDbuscado, nomePBusca)) {
                    vBuscaTipoPessoa.setText("Funcionario");
                } else {
                    vBuscaTipoPessoa.setText(nomePBusca);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {

            listaPessoa = pessoaGeralJpaController.listaTipoPessoaAlun(nomePBusca, cpfPBusca);
            for (int i = 0; i <= listaPessoa.size(); i++) {
                nomeDbuscado = String.valueOf(listaPessoa.get(i));
                if (Objects.equals(nomeDbuscado, nomePBusca)) {
                    vBuscaTipoPessoa.setText("Aluno");
                } else {
                    vBuscaTipoPessoa.setText(nomePBusca);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {

            listaPessoa = pessoaGeralJpaController.listaTipoPessoaVis(nomePBusca, cpfPBusca);
            for (int i = 0; i <= listaPessoa.size(); i++) {
                nomeDbuscado = String.valueOf(listaPessoa.get(i));
                if (Objects.equals(nomeDbuscado, nomePBusca)) {
                    vBuscaTipoPessoa.setText("Vizitante");
                } else {
                    vBuscaTipoPessoa.setText(nomePBusca);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }//GEN-LAST:event_jbBuscarPessoaActionPerformed


    private void vBuscaTipoPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vBuscaTipoPessoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vBuscaTipoPessoaActionPerformed

    private void vbuscaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vbuscaNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vbuscaNomeActionPerformed

    private void jbEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEnviarActionPerformed
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("apportariasoloPU");
        PessoaGeralJpaController pessoaGeralJpaController = new PessoaGeralJpaController(emf);
        PortariaJpaController portariaJpaController = new PortariaJpaController(emf);
        List<PessoaGeral> listaPessoa = new ArrayList<PessoaGeral>();
        PessoaGeral pessoa = new PessoaGeral();
        String nomePBusca = String.valueOf(vbuscaNome.getText());
        String cpfPBusca = (String) vBuscaCpf.getText();
        String nomeDbuscado = null;
        int sexoDBuscado = 0;
        System.out.println("");
        String idPessoaPego;
        int idPessoa = 0;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Portaria portaria = new Portaria();
        //idPessoa = pessoa.getIdPessoaGeral();
        //portaria.setIdPessoaGeral(idPessoa);
        try {

            listaPessoa = pessoaGeralJpaController.listaIdPessoa(nomePBusca, cpfPBusca);
            for (int i = 0; i <= listaPessoa.size(); i++) {
                idPessoaPego = String.valueOf(listaPessoa.get(i));
                idPessoa = Integer.valueOf(idPessoaPego);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        portaria.setIdPessoaGeral(new PessoaGeral());
        pessoa = pessoaGeralJpaController.findPessoaGeral(idPessoa);
        portaria.setIdPessoaGeral(pessoa);;

        portaria.setDescricao(vDescricao.getText());
        try {
            if (!vDataHora.getText().isEmpty()) {
                portaria.setDataHoraEntrada((Date) dateFormat.parse(vDataHora.getText()));
            }
            portariaJpaController.create(portaria);
            JOptionPane.showMessageDialog(null, "Portaria Cadastrada Com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jbEnviarActionPerformed

    private void bvDataHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bvDataHoraActionPerformed
        Date data = new Date();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dataAgora = String.valueOf(date.format(data));
        System.out.println(date.format(data));
        vDataHora.setText(dataAgora);

    }//GEN-LAST:event_bvDataHoraActionPerformed

    private void vLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vLimparActionPerformed
        vBuscaCelular.setText("");
        vBuscaCpf.setText("");
        vBuscaRg.setText("");
        vBuscaSexo.setText("");
        vBuscaTipoPessoa.setText("");
        vCpfPessoaPortaria.setText("");
        vDataHora.setText("");
        vDescricao.setText("");
        vNomePessoaPortaria.setText("");
        vbuscaNome.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_vLimparActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UICadastroFuncionario fun = new UICadastroFuncionario();
        UIPortaria po = new UIPortaria();
        fun.setLocationRelativeTo(null);
        fun.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        fun.setResizable(false);
        fun.setVisible(true);
        po.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    UICadastroVisitante vis = new UICadastroVisitante();
    UIPortaria po = new UIPortaria();
    vis.setLocationRelativeTo(null);
    vis.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
    vis.setResizable(false);
    vis.setVisible(true);
    po.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    UISelecaoPortaria por = new UISelecaoPortaria();
    UIPortaria po = new UIPortaria();
    por.setLocationRelativeTo(null);
    por.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
    por.setResizable(false);
    por.setVisible(true);
    po.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UIPortaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIPortaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIPortaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIPortaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIPortaria().setVisible(true);
            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager apportariasoloPUEntityManager;
    private javax.swing.JButton bvDataHora;
    private java.util.List<br.edu.uerr.appportariasolo.modelo.Funcionario> funcionarioList;
    private javax.persistence.Query funcionarioQuery;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbBuscarPessoa;
    private javax.swing.JButton jbCadastroPessoaGeral;
    private javax.swing.JButton jbEnviar;
    private java.util.List<br.edu.uerr.appportariasolo.modelo.PessoaGeral> pessoaGeralList;
    private java.util.List<br.edu.uerr.appportariasolo.modelo.PessoaGeral> pessoaGeralList1;
    private javax.persistence.Query pessoaGeralQuery;
    private javax.persistence.Query pessoaGeralQuery1;
    private java.util.List<br.edu.uerr.appportariasolo.modelo.Portaria> portariaList;
    private javax.persistence.Query portariaQuery;
    private javax.swing.JTextField vBuscaCelular;
    private javax.swing.JTextField vBuscaCpf;
    private javax.swing.JTextField vBuscaRg;
    private javax.swing.JTextField vBuscaSexo;
    private javax.swing.JTextField vBuscaTipoPessoa;
    private javax.swing.JTextField vCpfPessoaPortaria;
    private javax.swing.JTextField vDataHora;
    private javax.swing.JTextArea vDescricao;
    private javax.swing.JButton vLimpar;
    private javax.swing.JTextField vNomePessoaPortaria;
    private javax.swing.JTextField vbuscaNome;
    // End of variables declaration//GEN-END:variables
}
