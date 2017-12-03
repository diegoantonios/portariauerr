/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appportariasolo.visao;

import br.edu.uerr.appportariasolo.controler.PessoaGeralJpaController;
import br.edu.uerr.appportariasolo.modelo.PessoaGeral;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diego_Note
 */
public class UITeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("apportariasoloPU");
        PessoaGeralJpaController pessoaGeralJpaController = new PessoaGeralJpaController(emf);
        List<PessoaGeral> listaPessoa = new ArrayList<PessoaGeral>();
       PessoaGeral pessoa = new PessoaGeral();
        try {
            
        listaPessoa = pessoaGeralJpaController.listaNomePessoa("Ana Paula","999");        
        for(int i=0;i<=listaPessoa.size();i++)
            System.out.println(listaPessoa.get(i));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        }
                /*try {
            
        listaPessoa = pessoaGeralJpaController.listaUltimoQuatroFun("ana");        
        for(int i=0;i<=listaPessoa.size();i++)
            System.out.println(listaPessoa.get(i));
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        /*
        
        
        
          
        
        
        
        
        //System.out.println(listaPessoa.get(1).getNome());
        /*buscador de cep
        Map<String,String> mapa = new HashMap<>();
        
        
        String json=Cep.buscarCep(JOptionPane.showInputDialog(null,"Digite o Cep:"));

        Matcher matcher = Pattern.compile("\"\\D.*?\": \".*?\"").matcher(json);
        while (matcher.find()) {
            String[] group = matcher.group().split(":");
            mapa.put(group[0].replaceAll("\"", "").trim(), group[1].replaceAll("\"", "").trim());
        }
        */
        
        /*
        pessoa.setIdPessoaGeral(1);
        pessoa.setNome("Rober");
        pessoa.setCpf("123.123.123-79");
        pessoa.setEmail("Rogerio@hotmail.com");
        pessoa.setCep("cep");
        pessoa.setEndereco(("logradouro"));
        pessoa.setBairro(("bairro"));
        pessoa.setCidade(("localidade"));
        //buscador de cep pessoa.setCep(mapa.get("cep"));
        //buscador de cep pessoa.setEndereco(mapa.get("logradouro"));
        //buscador de cep pessoa.setBairro(mapa.get("bairro"));
        pessoa.setNumero("123");
        // buscador de cep pessoa.setCidade(mapa.get("localidade"));
        pessoa.setUf("uf");
        pessoa.setSexo(1);
        
        //novo
        Funcionario funcionario = new Funcionario();
        FuncionarioJpaController funcionarioJpaController = new FuncionarioJpaController(emf);
        funcionario.setIdFuncionario(1);
        funcionario.setIdPessoaGeralFk(pessoa);
        //novo
        
        try {
          pessoaGeralJpaController.create(pessoa); 
          funcionarioJpaController.create(funcionario); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(pessoa.getNome());
        JOptionPane.showMessageDialog(null, pessoa.toString());
        */
        
       
    }
    
}
