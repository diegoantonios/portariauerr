/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appportariasolo.visao;

import br.edu.uerr.appportariasolo.controler.AlunoJpaController;
import br.edu.uerr.appportariasolo.controler.CursoJpaController;
import br.edu.uerr.appportariasolo.controler.PessoaGeralJpaController;
import br.edu.uerr.appportariasolo.controler.SetorJpaController;
import br.edu.uerr.appportariasolo.modelo.Aluno;
import br.edu.uerr.appportariasolo.modelo.Curso;
import br.edu.uerr.appportariasolo.modelo.PessoaGeral;
import br.edu.uerr.appportariasolo.modelo.Setor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego_Note
 */
public class UICadastroAluno extends javax.swing.JFrame {

    /**
     * Creates new form UICadastroAluno
     */
    public UICadastroAluno() {
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

        vEmail = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        vCep = new javax.swing.JTextField();
        vBairro = new javax.swing.JTextField();
        vRua = new javax.swing.JTextField();
        vNumero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        vCidade = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jbCadastrar = new javax.swing.JButton();
        vNome = new javax.swing.JTextField();
        jbLimpar = new javax.swing.JButton();
        vRg = new javax.swing.JTextField();
        vSexo = new javax.swing.JComboBox<>();
        vUf = new javax.swing.JTextField();
        vCpf = new javax.swing.JTextField();
        vDataDeNascimento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        vTelefone = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        vCelular = new javax.swing.JTextField();
        vCurso = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        vMatricula = new javax.swing.JTextField();
        vSetor = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel14.setText("CEP:");

        jLabel15.setText("Rua:");

        jLabel16.setText("Bairro:");

        jLabel17.setText("Numero:");

        jLabel18.setText("Cidade:");

        jLabel9.setText("Sexo:");

        jLabel10.setText("UF:");

        jbCadastrar.setText("Cadastrar");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        vNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vNomeActionPerformed(evt);
            }
        });

        jbLimpar.setText("Limpar");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        vRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vRgActionPerformed(evt);
            }
        });

        vSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));
        vSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vSexoActionPerformed(evt);
            }
        });

        vUf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vUfActionPerformed(evt);
            }
        });

        vCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vCpfActionPerformed(evt);
            }
        });

        vDataDeNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vDataDeNascimentoActionPerformed(evt);
            }
        });

        jLabel11.setText("Email:");

        jLabel12.setText("Telefone:");

        jLabel13.setText("Celular:");

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Cadastro Aluno");
        jLabel1.setToolTipText("");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Endereço");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Geral");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Contato");

        jLabel5.setText("Nome:");

        jLabel6.setText("CPF:");

        jLabel7.setText("RG:");

        jLabel8.setText("Data de Nascimento:");

        jLabel20.setText("Setor:");

        jLabel21.setText("Curso:");

        vCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum Curso", "Administração", "Agronomia", "Ciências Biológicas", "Ciências da Computação", "Ciências da Natureza", "Ciências da Contábeis", "Comércio Exterior", "Direito", "Educação Física", "Enfermagem", "Engenharia Florestal", "Filosofia", "Física", "Geografica", "Historia", "Letras", "Matemática", "Pedagogia", "Química", "Segunrança Pública", "Serviço Social", "Sociologia", "Turismo", "Gestão e Docência do Ensino Superior", "Enfermagem Obstétrica", "Educação do Campo e suas Metodologias", "História da Amazônia", "Língua Portuguesa e Literatura", "Mestrado Profissional em Ensino de Ciências", "Mestrado Acadêmico em Biologia da Água Doce e Pesca Interior", "Mestrado Acadêmico em Agroecologia", "Mestrado Acadêmico em Educação", "Doutorado em Biologia da Água Doce e Pesca Interior", "Doutorado em Educação em Ciência e Matemática", "Doutorado Interinstitucional em Geografica", "Doutorado Interinstitucional em Letras e Linguística" }));

        jLabel19.setText("Matricula:");

        vSetor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum Setor", "Multiteca", "Registro Acadêmico", "Almoxarifado", "Asessoria de Cominicação", "Asessoria de Comunicação", "Auditorio", "Comissão de Ética", "Controle Interno", "Conuni", "Convênio", "Copa", "CPL e Seção de Compras", "Comussão Permanente de Concurso e Vestibular", "Departamento de Desenvolvimento Pessoal", "Departamento de Logística", "Departamento de Planejamento Estratégico", "Departamento de Pós-graduação", "Divisão de Cadastro de Pessoal", "Telemática", "Dvisão de Transporte", "Guarita", "Labtema", "Núcleo de Prátca Jurídica", "Projur", "Protocolo", "Recepção Gabinete" }));
        vSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vSetorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vDataDeNascimento))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(vSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(17, 17, 17)
                                .addComponent(vRg, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vCep)
                                    .addComponent(vRua)
                                    .addComponent(vCidade))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(vNumero, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vBairro)
                                    .addComponent(vUf)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vMatricula)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(vCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 9, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(vSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jbLimpar)
                                    .addGap(291, 291, 291)
                                    .addComponent(jbCadastrar))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(175, 175, 175)
                                                .addComponent(jLabel6)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(vNome, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(251, 251, 251))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel11))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(vTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(vCelular))
                                            .addComponent(vEmail)))))
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(vNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(vRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(vCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(vSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(vMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(vDataDeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(vCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(vCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(vBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(vRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(vNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(vCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(vUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(vEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(vTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastrar)
                    .addComponent(jbLimpar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        // TODO add your handling code here:
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("apportariasoloPU");
        PessoaGeralJpaController pessoaJpaController = new PessoaGeralJpaController(emf);
        AlunoJpaController alunoJpaController = new AlunoJpaController(emf);
        SetorJpaController setorJpaController = new SetorJpaController(emf);
        CursoJpaController cursoJpaController = new CursoJpaController(emf);
        List<PessoaGeral> listaPessoa = new ArrayList<>();
        List<Curso> listaCursos = new ArrayList<>();
        //listaPessoa = pessoaJpaController.listaUltimouatro();
        System.out.println("");
        Curso curso = new Curso();
        Setor setor = new Setor();
        List<Setor> listaSetor = new ArrayList<>();
        int idSetor = 0;
        String idSetorPego = null;
        String idCursoPego = null;
        // for (PessoaGeral pessoa : listaPessoa) {
        // System.out.println(pessoa.toString());
        //}
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //criando o objeto, importara dados do modelo pessoa
        String msg = "";
        int erro = 0;
        int idCurso=0;
        String sexo = (String) vSexo.getSelectedItem();
        //Integer fkpg=0;
        //DefaultTableModel TempTabela = new DefaultTableModel(colunas,0);
        PessoaGeral pessoa = new PessoaGeral();
        //fkpg=pessoa.getIdPessoaGeral();
        pessoa.setNome(vNome.getText());
        pessoa.setCpf(vCpf.getText());
        pessoa.setEmail(vEmail.getText());
        pessoa.setCelular(vCelular.getText());
        pessoa.setBairro(vBairro.getText());
        pessoa.setNumero(vNumero.getText());
        pessoa.setRg(vRg.getText());
        pessoa.setTelefone(vTelefone.getText());
        pessoa.setCep(vCep.getText());
        pessoa.setEndereco(vRua.getText());
        pessoa.setCidade(vCidade.getText());
        pessoa.setUf(vUf.getText());
        String setorN = (String) vSetor.getSelectedItem();
        String cursoN = (String) vCurso.getSelectedItem();
        //pessoa.setSexo(vSexo.setSelectedItem(ABORT));

        Aluno aluno = new Aluno();
        aluno.setMatricula(vMatricula.getText());

        if (pessoa.getNome().isEmpty()) {
            msg = msg + "\n Nome é obrigatorio";
            erro++;
        }
        if (pessoa.getCpf().isEmpty()) {
            msg = msg + "\n CPF é obrigatorio";
            erro++;
        }
        if (sexo == "Masculino") {
            pessoa.setSexo(1);
        } else {
            pessoa.setSexo(2);
        }

        try {

            listaSetor = setorJpaController.listaSetor(setorN);
            for (int i = 0; i <= listaPessoa.size(); i++) {
                idSetorPego = String.valueOf(listaSetor.get(i));
                idSetor = Integer.valueOf(idSetorPego);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        aluno.setIdSetorFk(new Setor());
        setor = setorJpaController.findSetor(idSetor);
        aluno.setIdSetorFk(setor);

        try {

            listaCursos = cursoJpaController.listaCursos(cursoN);
            for (int i = 0; i <= listaCursos.size(); i++) {
                idCursoPego = String.valueOf(listaCursos.get(i));
                idCurso = Integer.valueOf(idCursoPego);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        aluno.setIdCursoFk(new Curso());
        curso = cursoJpaController.findCurso(idCurso);
        aluno.setIdCursoFk(curso);

        if (erro > 0) {
            JOptionPane.showMessageDialog(null, msg);
        } else {
            try {
                JOptionPane.showMessageDialog(null, msg);
                if (!vDataDeNascimento.getText().isEmpty()) {
                    pessoa.setDatadenascimento((Date) dateFormat.parse(vDataDeNascimento.getText()));
                }

                pessoaJpaController.create(pessoa);
                aluno.setIdPessoaGeralFk(pessoa);
                alunoJpaController.create(aluno);
                JOptionPane.showMessageDialog(null, "Aluno Cadastrado Com Sucesso");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void vNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vNomeActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        // TODO add your handling code here:
        vNome.setText("");
        vBairro.setText("");
        vCelular.setText("");
        vCep.setText("");
        vCidade.setText("");
        vCpf.setText("");
        vDataDeNascimento.setText("");
        vEmail.setText("");
        vMatricula.setText("");
        vNome.setText("");
        vNumero.setText("");
        vRg.setText("");
        vRua.setText("");
        vTelefone.setText("");
        vUf.setText("");
    }//GEN-LAST:event_jbLimparActionPerformed

    private void vRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vRgActionPerformed

    private void vSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vSexoActionPerformed

    private void vUfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vUfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vUfActionPerformed

    private void vCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vCpfActionPerformed

    private void vDataDeNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vDataDeNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vDataDeNascimentoActionPerformed

    private void vSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vSetorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vSetorActionPerformed

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
            java.util.logging.Logger.getLogger(UICadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UICadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UICadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UICadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UICadastroAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JTextField vBairro;
    private javax.swing.JTextField vCelular;
    private javax.swing.JTextField vCep;
    private javax.swing.JTextField vCidade;
    private javax.swing.JTextField vCpf;
    private javax.swing.JComboBox<String> vCurso;
    private javax.swing.JTextField vDataDeNascimento;
    private javax.swing.JTextField vEmail;
    private javax.swing.JTextField vMatricula;
    private javax.swing.JTextField vNome;
    private javax.swing.JTextField vNumero;
    private javax.swing.JTextField vRg;
    private javax.swing.JTextField vRua;
    private javax.swing.JComboBox<String> vSetor;
    private javax.swing.JComboBox<String> vSexo;
    private javax.swing.JTextField vTelefone;
    private javax.swing.JTextField vUf;
    // End of variables declaration//GEN-END:variables
}