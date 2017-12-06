/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

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

/**
 *
 * @author DevSilva
 */
public class TelaBuscarPortaria extends javax.swing.JFrame {

    /**
     * Creates new form TelaBuscarPortaria
     */
    public TelaBuscarPortaria() {
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

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jCpf = new javax.swing.JLabel();
        vNomePessoaPesquisada = new javax.swing.JTextField();
        jSeparator24 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jGen = new javax.swing.JLabel();
        jNome = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        vCampoAlunoOut = new javax.swing.JCheckBox();
        vCampoAlunoMasc = new javax.swing.JCheckBox();
        vCampoAlunoFem = new javax.swing.JCheckBox();
        jSeparator10 = new javax.swing.JSeparator();
        jLfechar1 = new javax.swing.JLabel();
        jLfechar = new javax.swing.JLabel();
        jGen1 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        vCpfPesquisada = new javax.swing.JTextField();
        jNome1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jCpf1 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        bPesquisaPortaria = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        vNomePessoaBusca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        vDescricaoPesquisada = new javax.swing.JTextArea();
        jDt = new javax.swing.JLabel();
        vDataEntradaBusca = new javax.swing.JFormattedTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jDt1 = new javax.swing.JLabel();
        jDt2 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        vCpfPessoaBusca = new javax.swing.JTextField();
        vDataHoraEntradaPesquisada = new javax.swing.JTextField();
        vTipoPesquisada = new javax.swing.JTextField();
        vDataHoraSaidaPesquisada = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 500, 10));

        jCpf.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jCpf.setForeground(new java.awt.Color(0, 51, 102));
        jCpf.setText("CPF:");
        jPanel1.add(jCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 50, -1));

        vNomePessoaPesquisada.setBackground(new java.awt.Color(204, 204, 204));
        vNomePessoaPesquisada.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        vNomePessoaPesquisada.setForeground(new java.awt.Color(153, 153, 153));
        vNomePessoaPesquisada.setBorder(null);
        vNomePessoaPesquisada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vNomePessoaPesquisadaMouseClicked(evt);
            }
        });
        jPanel1.add(vNomePessoaPesquisada, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 500, -1));
        jPanel1.add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 150, 10));

        jPanel3.setBackground(new java.awt.Color(0, 51, 102));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("FECHAR PORTARIA");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 0, -1, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, 150, 30));

        jGen.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jGen.setForeground(new java.awt.Color(0, 51, 102));
        jGen.setText("Género:");
        jPanel1.add(jGen, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 70, -1));

        jNome.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jNome.setForeground(new java.awt.Color(0, 51, 102));
        jNome.setText("Nome:");
        jPanel1.add(jNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 50, -1));
        jPanel1.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 140, 10));

        vCampoAlunoOut.setBackground(new java.awt.Color(204, 204, 204));
        vCampoAlunoOut.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        vCampoAlunoOut.setForeground(new java.awt.Color(153, 153, 153));
        vCampoAlunoOut.setText("Outro");
        vCampoAlunoOut.setBorder(null);
        vCampoAlunoOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vCampoAlunoOutActionPerformed(evt);
            }
        });
        jPanel1.add(vCampoAlunoOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, -1, -1));

        vCampoAlunoMasc.setBackground(new java.awt.Color(204, 204, 204));
        vCampoAlunoMasc.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        vCampoAlunoMasc.setForeground(new java.awt.Color(153, 153, 153));
        vCampoAlunoMasc.setText("Masculino");
        vCampoAlunoMasc.setBorder(null);
        vCampoAlunoMasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vCampoAlunoMascActionPerformed(evt);
            }
        });
        jPanel1.add(vCampoAlunoMasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, -1, -1));

        vCampoAlunoFem.setBackground(new java.awt.Color(204, 204, 204));
        vCampoAlunoFem.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        vCampoAlunoFem.setForeground(new java.awt.Color(153, 153, 153));
        vCampoAlunoFem.setText("Feminino");
        vCampoAlunoFem.setBorder(null);
        vCampoAlunoFem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vCampoAlunoFemActionPerformed(evt);
            }
        });
        jPanel1.add(vCampoAlunoFem, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, -1, -1));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 290, 10));

        jLfechar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Img_fexar.png"))); // NOI18N
        jLfechar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLfechar1MouseClicked(evt);
            }
        });
        jPanel1.add(jLfechar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, 30));

        jLfechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Img_home.png"))); // NOI18N
        jLfechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLfecharMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLfecharMousePressed(evt);
            }
        });
        jPanel1.add(jLfechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, 30));

        jGen1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jGen1.setForeground(new java.awt.Color(0, 51, 102));
        jGen1.setText("Tipo:");
        jPanel1.add(jGen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 40, -1));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 680, -1));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 102));
        jLabel16.setText("BUSCAR UMA PORTARIA ");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, 40));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 290, 10));

        vCpfPesquisada.setBackground(new java.awt.Color(204, 204, 204));
        vCpfPesquisada.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        vCpfPesquisada.setForeground(new java.awt.Color(153, 153, 153));
        vCpfPesquisada.setBorder(null);
        jPanel1.add(vCpfPesquisada, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 130, -1));

        jNome1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jNome1.setForeground(new java.awt.Color(0, 51, 102));
        jNome1.setText("Nome:");
        jPanel1.add(jNome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 50, 20));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 51, 102));
        jLabel18.setText("DADOS DA PORTARIA");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 220, 40));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 680, -1));

        jCpf1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jCpf1.setForeground(new java.awt.Color(0, 51, 102));
        jCpf1.setText("CPF:");
        jPanel1.add(jCpf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 50, -1));
        jPanel1.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 130, 10));

        bPesquisaPortaria.setBackground(new java.awt.Color(0, 51, 102));
        bPesquisaPortaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bPesquisaPortariaMouseClicked(evt);
            }
        });
        bPesquisaPortaria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("PESQUISAR");
        bPesquisaPortaria.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 30));

        jPanel1.add(bPesquisaPortaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 120, 110, -1));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 680, -1));

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 51, 102));
        jLabel23.setText("DESCRIÇÃO");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 110, 40));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 130, 10));

        vNomePessoaBusca.setBackground(new java.awt.Color(204, 204, 204));
        vNomePessoaBusca.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        vNomePessoaBusca.setForeground(new java.awt.Color(153, 153, 153));
        vNomePessoaBusca.setText("Digite o nome comleto");
        vNomePessoaBusca.setBorder(null);
        vNomePessoaBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vNomePessoaBuscaMouseClicked(evt);
            }
        });
        jPanel1.add(vNomePessoaBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 290, 20));

        vDescricaoPesquisada.setBackground(new java.awt.Color(204, 204, 204));
        vDescricaoPesquisada.setColumns(20);
        vDescricaoPesquisada.setRows(5);
        vDescricaoPesquisada.setBorder(null);
        jScrollPane1.setViewportView(vDescricaoPesquisada);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 620, 90));

        jDt.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jDt.setForeground(new java.awt.Color(0, 51, 102));
        jDt.setText("Data de Entrada:");
        jPanel1.add(jDt, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 120, -1));

        vDataEntradaBusca.setBackground(new java.awt.Color(204, 204, 204));
        vDataEntradaBusca.setBorder(null);
        vDataEntradaBusca.setForeground(new java.awt.Color(153, 153, 153));
        try {
            vDataEntradaBusca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        vDataEntradaBusca.setText("00/00/0000");
        vDataEntradaBusca.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        vDataEntradaBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vDataEntradaBuscaMouseClicked(evt);
            }
        });
        jPanel1.add(vDataEntradaBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 80, -1));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 80, 10));

        jDt1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jDt1.setForeground(new java.awt.Color(0, 51, 102));
        jDt1.setText("Data Ent:");
        jPanel1.add(jDt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 60, -1));

        jDt2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jDt2.setForeground(new java.awt.Color(0, 51, 102));
        jDt2.setText("Data Sai:");
        jPanel1.add(jDt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, -1, -1));
        jPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 140, 10));
        jPanel1.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 150, 10));

        vCpfPessoaBusca.setBackground(new java.awt.Color(204, 204, 204));
        vCpfPessoaBusca.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        vCpfPessoaBusca.setForeground(new java.awt.Color(153, 153, 153));
        vCpfPessoaBusca.setText("Somente números");
        vCpfPessoaBusca.setBorder(null);
        vCpfPessoaBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vCpfPessoaBuscaMouseClicked(evt);
            }
        });
        jPanel1.add(vCpfPessoaBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 130, -1));

        vDataHoraEntradaPesquisada.setBackground(new java.awt.Color(204, 204, 204));
        vDataHoraEntradaPesquisada.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        vDataHoraEntradaPesquisada.setForeground(new java.awt.Color(153, 153, 153));
        vDataHoraEntradaPesquisada.setBorder(null);
        jPanel1.add(vDataHoraEntradaPesquisada, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 140, -1));

        vTipoPesquisada.setBackground(new java.awt.Color(204, 204, 204));
        vTipoPesquisada.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        vTipoPesquisada.setForeground(new java.awt.Color(153, 153, 153));
        vTipoPesquisada.setBorder(null);
        jPanel1.add(vTipoPesquisada, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 130, -1));

        vDataHoraSaidaPesquisada.setBackground(new java.awt.Color(204, 204, 204));
        vDataHoraSaidaPesquisada.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        vDataHoraSaidaPesquisada.setForeground(new java.awt.Color(153, 153, 153));
        vDataHoraSaidaPesquisada.setBorder(null);
        jPanel1.add(vDataHoraSaidaPesquisada, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 140, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void vDataEntradaBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vDataEntradaBuscaMouseClicked
        vDataEntradaBusca.setText("");
    }//GEN-LAST:event_vDataEntradaBuscaMouseClicked

    private void vNomePessoaBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vNomePessoaBuscaMouseClicked
        // TODO add your handling code here:
        vNomePessoaBusca.setText("");
    }//GEN-LAST:event_vNomePessoaBuscaMouseClicked

    private void bPesquisaPortariaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPesquisaPortariaMouseClicked
        // TODO add your handling code here:
        vCampoAlunoOut.setSelected(false);
        vCampoAlunoMasc.setSelected(false);
        vCampoAlunoFem.setSelected(false);
        vDataHoraEntradaPesquisada.setText("");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("apportariasoloPU");
        PortariaJpaController portariaJpaController = new PortariaJpaController(emf);
        PessoaGeralJpaController pessoaGeralJpaController = new PessoaGeralJpaController(emf);
        List<Portaria> listaPortaria = new ArrayList<Portaria>();
        List<PessoaGeral> listaPessoa = new ArrayList<PessoaGeral>();
        PessoaGeral pessoa = new PessoaGeral();
        String nomePBusca = String.valueOf(vNomePessoaBusca.getText());
        String cpfPBusca = (String) vCpfPessoaBusca.getText();
        String dataDeEntrada = (String) vDataEntradaBusca.getText();
        String dataDeEntradaAT;
        String aux = null;
        int auxx = 0;
        String idPessoaPego;
        int idPessoa = 0;
        int sexoDBuscado = 0;
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date data = new Date();

        Portaria portaria = new Portaria();

        //Data e Hora Entreda
        try {

            listaPortaria = portariaJpaController.listaDataEntrada(nomePBusca, cpfPBusca, dataDeEntrada);
            for (int i = 0; i <= listaPortaria.size(); i++) {
                //aux = String.valueOf(listaPortaria.get(i));
                //auxx= Integer.valueOf(aux);
                //vDataHoraEntradaPesquisada.setText((Date) date.parse(aux));
                vDataHoraEntradaPesquisada.setText(String.valueOf(date.format(listaPortaria.get(i))));
                //String dataAgora = String.valueOf(date.format(data));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        dataDeEntradaAT = (String) vDataHoraEntradaPesquisada.getText();

        //Data e Hora Saida
        try {

            listaPortaria = portariaJpaController.listaDataSaida(nomePBusca, cpfPBusca, dataDeEntradaAT);
            for (int i = 0; i <= listaPortaria.size(); i++) {
                //aux = String.valueOf(listaPortaria.get(i));
                vDataHoraSaidaPesquisada.setText(String.valueOf(date.format(listaPortaria.get(i))));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Nome da Pessoa
        try {

            listaPortaria = portariaJpaController.listaNome(nomePBusca, cpfPBusca, dataDeEntrada);
            for (int i = 0; i <= listaPortaria.size(); i++) {
                aux = String.valueOf(listaPortaria.get(i));
                vNomePessoaPesquisada.setText(aux);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Cpf da Pessoa
        try {

            listaPortaria = portariaJpaController.listaCpf(nomePBusca, cpfPBusca, dataDeEntrada);
            for (int i = 0; i <= listaPortaria.size(); i++) {
                aux = String.valueOf(listaPortaria.get(i));
                vCpfPesquisada.setText(aux);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Sexo da Pessoa
        try {

            listaPessoa = pessoaGeralJpaController.listaSexoPessoa(nomePBusca, cpfPBusca);
            for (int i = 0; i <= listaPessoa.size(); i++) {
                aux = String.valueOf(listaPessoa.get(i));
                sexoDBuscado = Integer.valueOf(aux);
                /*
                if (sexoDBuscado == 1) {
                    vSexoPesquisado.setText("Masculino");
                } else {
                    vSexoPesquisado.setText("Feminino");
                }
                */
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (sexoDBuscado == 1) {
            vCampoAlunoMasc.setSelected(true);
        }
        if (sexoDBuscado == 2) {
            vCampoAlunoFem.setSelected(true);
        }
        if (sexoDBuscado == 3) {
            vCampoAlunoOut.setSelected(true);
        }
        //Tipo da Pessoa
        try {

            listaPessoa = pessoaGeralJpaController.listaTipoPessoaFunc(nomePBusca, cpfPBusca);
            for (int i = 0; i <= listaPessoa.size(); i++) {
                aux = String.valueOf(listaPessoa.get(i));
                if (Objects.equals(aux, nomePBusca)) {
                    vTipoPesquisada.setText("Funcionario");
                } else {
                    vTipoPesquisada.setText(nomePBusca);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {

            listaPessoa = pessoaGeralJpaController.listaTipoPessoaAlun(nomePBusca, cpfPBusca);
            for (int i = 0; i <= listaPessoa.size(); i++) {
                aux = String.valueOf(listaPessoa.get(i));
                if (Objects.equals(aux, nomePBusca)) {
                    vTipoPesquisada.setText("Aluno");
                } else {
                    vTipoPesquisada.setText(nomePBusca);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {

            listaPessoa = pessoaGeralJpaController.listaTipoPessoaVis(nomePBusca, cpfPBusca);
            for (int i = 0; i <= listaPessoa.size(); i++) {
                aux = String.valueOf(listaPessoa.get(i));
                if (Objects.equals(aux, nomePBusca)) {
                    vTipoPesquisada.setText("Vizitante");
                } else {
                    vTipoPesquisada.setText(nomePBusca);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Descricao da Portaria
        try {

            listaPortaria = portariaJpaController.listaDescricao(nomePBusca, cpfPBusca, dataDeEntrada);
            for (int i = 0; i <= listaPortaria.size(); i++) {
                aux = String.valueOf(listaPortaria.get(i));
                vDescricaoPesquisada.setText(aux);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //

        // TODO add your handling code here:
    }//GEN-LAST:event_bPesquisaPortariaMouseClicked

    private void jLfecharMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLfecharMousePressed
        // TODO add your handling code here:
        new TelaMenu().show();
    }//GEN-LAST:event_jLfecharMousePressed

    private void jLfecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLfecharMouseClicked
        this.dispose();
    }//GEN-LAST:event_jLfecharMouseClicked

    private void vCampoAlunoFemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vCampoAlunoFemActionPerformed
        if (vCampoAlunoMasc.isSelected() || vCampoAlunoOut.isSelected()) {
            vCampoAlunoMasc.setSelected(false);
            vCampoAlunoOut.setSelected(false);

        }
    }//GEN-LAST:event_vCampoAlunoFemActionPerformed

    private void vCampoAlunoMascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vCampoAlunoMascActionPerformed
        if (vCampoAlunoOut.isSelected() || vCampoAlunoFem.isSelected()) {
            vCampoAlunoOut.setSelected(false);
            vCampoAlunoFem.setSelected(false);

        }
    }//GEN-LAST:event_vCampoAlunoMascActionPerformed

    private void vCampoAlunoOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vCampoAlunoOutActionPerformed
        if (vCampoAlunoMasc.isSelected() || vCampoAlunoFem.isSelected()) {
            vCampoAlunoMasc.setSelected(false);
            vCampoAlunoFem.setSelected(false);

        }
    }//GEN-LAST:event_vCampoAlunoOutActionPerformed

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("apportariasoloPU");
        PessoaGeralJpaController pessoaGeralJpaController = new PessoaGeralJpaController(emf);
        PortariaJpaController portariaJpaController = new PortariaJpaController(emf);
        List<Portaria> listaPortaria = new ArrayList<Portaria>();
        List<PessoaGeral> listaPessoa = new ArrayList<PessoaGeral>();
        PessoaGeral pessoa = new PessoaGeral();
        String nomePBusca = String.valueOf(vNomePessoaPesquisada.getText());
        String cpfPBusca = (String) vCpfPesquisada.getText();
        String dataDeEntrada = (String) vDataEntradaBusca.getText();
        Portaria portaria = new Portaria();
        Date data = new Date();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataAgora = String.valueOf(date.format(data));
        System.out.println(date.format(data));
        vDataHoraSaidaPesquisada.setText(dataAgora);
        String idPortariaPego;
        int idPortaria = 0;
        String idPessoaPego;
        int idPessoa = 0;

        try {

            listaPortaria = portariaJpaController.listaIdPortaria(nomePBusca, cpfPBusca, dataDeEntrada);
            for (int i = 0; i <= listaPortaria.size(); i++) {
                idPortariaPego = String.valueOf(listaPortaria.get(i));
                idPortaria = Integer.valueOf(idPortariaPego);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //portaria.setDataHoraSaida(vDataHoraSaidaPesquisada.getText());
        portaria.setIdPortaria(idPortaria);
        portaria.setDescricao(vDescricaoPesquisada.getText());

        //IDPESSOAGERALFK portaria
        try {

            listaPortaria = portariaJpaController.listaIdPessoaGeralPortaria(nomePBusca, cpfPBusca, dataDeEntrada);
            for (int i = 0; i <= listaPortaria.size(); i++) {
                idPortariaPego = String.valueOf(listaPortaria.get(i));
                idPortaria = Integer.valueOf(idPortariaPego);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        portaria.setIdPessoaGeral(new PessoaGeral());
        pessoa = pessoaGeralJpaController.findPessoaGeral(idPortaria);
        portaria.setIdPessoaGeral(pessoa);

        /*
        //setar id fk
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
        portaria.setIdPessoaGeral(pessoa);
        */
        try {
            if (!vDataHoraEntradaPesquisada.getText().isEmpty()) {
                portaria.setDataHoraEntrada((Date) date.parse(vDataHoraEntradaPesquisada.getText()));
            }
            if (!vDataHoraSaidaPesquisada.getText().isEmpty()) {
                portaria.setDataHoraSaida((Date) date.parse(vDataHoraSaidaPesquisada.getText()));
            }
            portariaJpaController.edit(portaria);
            JOptionPane.showMessageDialog(null, "Portaria Fechada Com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jPanel3MouseClicked

    private void vNomePessoaPesquisadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vNomePessoaPesquisadaMouseClicked
        vNomePessoaPesquisada.setText("");
    }//GEN-LAST:event_vNomePessoaPesquisadaMouseClicked

    private void jLfechar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLfechar1MouseClicked
        // TODO add your handling code here:
         this.dispose();
    }//GEN-LAST:event_jLfechar1MouseClicked

    private void vCpfPessoaBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vCpfPessoaBuscaMouseClicked
        // TODO add your handling code here:
        vCpfPessoaBusca.setText("");
        
    }//GEN-LAST:event_vCpfPessoaBuscaMouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        //int x = evt.getXOnScreen();
        //int y = evt.getYOnScreen();
        //this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel1MouseDragged
        //int xx,xy;
    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        //xx = evt.getX();
        //xy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

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
            java.util.logging.Logger.getLogger(TelaBuscarPortaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBuscarPortaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBuscarPortaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBuscarPortaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaBuscarPortaria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bPesquisaPortaria;
    private javax.swing.JLabel jCpf;
    private javax.swing.JLabel jCpf1;
    private javax.swing.JLabel jDt;
    private javax.swing.JLabel jDt1;
    private javax.swing.JLabel jDt2;
    private javax.swing.JLabel jGen;
    private javax.swing.JLabel jGen1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLfechar;
    private javax.swing.JLabel jLfechar1;
    private javax.swing.JLabel jNome;
    private javax.swing.JLabel jNome1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JCheckBox vCampoAlunoFem;
    private javax.swing.JCheckBox vCampoAlunoMasc;
    private javax.swing.JCheckBox vCampoAlunoOut;
    private javax.swing.JTextField vCpfPesquisada;
    private javax.swing.JTextField vCpfPessoaBusca;
    private javax.swing.JFormattedTextField vDataEntradaBusca;
    private javax.swing.JTextField vDataHoraEntradaPesquisada;
    private javax.swing.JTextField vDataHoraSaidaPesquisada;
    private javax.swing.JTextArea vDescricaoPesquisada;
    private javax.swing.JTextField vNomePessoaBusca;
    private javax.swing.JTextField vNomePessoaPesquisada;
    private javax.swing.JTextField vTipoPesquisada;
    // End of variables declaration//GEN-END:variables
}
