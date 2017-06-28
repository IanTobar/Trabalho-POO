/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limite;

import controle.ControlePrincipal;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Corretor;
import modelo.Venda;

/**
 *
 * @author Bruno
 */
public class RelatorioPagamento extends javax.swing.JFrame {
    //controlador
    ControlePrincipal ctrPrincipal;    
    
    /**
     * Creates new form LimitePagamento
     */
    public RelatorioPagamento(ControlePrincipal ctrPrincipal) {
        this.ctrPrincipal = ctrPrincipal;
        //inicia os componentes
        initComponents();
        
        //pega a lista de corretores contratados, que está no ControleCorretor
        //adiciona os corretores no cbSelecionaCorretor (comboBox)
        for( Corretor cor : ctrPrincipal.ctrCorretor.getListaCorretor() ){//abre for 01
            cbSelecionaCorretor.addItem(cor.getaNome());//adiciona item no comboBox
        }//fecha for 01
        
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);        
        
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
        lbMes = new javax.swing.JLabel();
        lbAno = new javax.swing.JLabel();
        tfMesPesquisa = new javax.swing.JTextField();
        tfAnoPesquisa = new javax.swing.JTextField();
        cbSelecionaCorretor = new javax.swing.JComboBox();
        lbCorretor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taResultado = new javax.swing.JTextArea();
        lbResultado = new javax.swing.JLabel();
        btSubmit = new javax.swing.JToggleButton();
        btCancelar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbMes.setText("Digite o Mês:");

        lbAno.setText("Digite o Ano:");

        lbCorretor.setText("Selecione o Corretor:");

        taResultado.setColumns(20);
        taResultado.setRows(5);
        jScrollPane1.setViewportView(taResultado);

        lbResultado.setText("Resultado:");

        btSubmit.setText("OK");
        btSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSubmitActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbSelecionaCorretor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSubmit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCorretor)
                            .addComponent(lbResultado)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfMesPesquisa))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbAno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfAnoPesquisa))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCancelar, btSubmit});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbMes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfMesPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbAno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfAnoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCorretor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbSelecionaCorretor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbResultado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSubmit)
                    .addComponent(btCancelar))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSubmitActionPerformed
        //declaração de variaveis
        int pMes = Integer.parseInt(tfMesPesquisa.getText());
        int pAno = Integer.parseInt(tfAnoPesquisa.getText());
        double vendas = 0.0;
        String output = "";
        
        //verifica se o campo ano e mês estão em branco
        if( tfAnoPesquisa.getText().equals("") || tfMesPesquisa.getText().equals("") ){//abre if 01
            JOptionPane.showMessageDialog(null, "Mês e ano obrigatórios!!!");
        }//fecha if 01
        else{//abre else do if 02
            
            //for para percorrer o ArrayList de vendas
            for(Venda v :ctrPrincipal.ctrVenda.getListaVendas()){//abre for 01
                //se o mês digitado existir no ArrayList de vendas
                if( (v.getDataVenda().get(Calendar.MONTH) == pMes) && 
                    (v.getDataVenda().get(Calendar.YEAR) == pAno ) &&
                    (v.getCorretorResponsavel().equals(String.valueOf(cbSelecionaCorretor.getSelectedItem()) ))
                ){//abre for 02
                    vendas += v.getValorNegociado();
                    
                }//fecha for 02
                
            }//fecha for 01
            
        }//fecha else do if 02
        
        taResultado.setText(output);
        
    }//GEN-LAST:event_btSubmitActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        //fecha tela
        this.dispose();
       
    }//GEN-LAST:event_btCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btCancelar;
    private javax.swing.JToggleButton btSubmit;
    private javax.swing.JComboBox cbSelecionaCorretor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAno;
    private javax.swing.JLabel lbCorretor;
    private javax.swing.JLabel lbMes;
    private javax.swing.JLabel lbResultado;
    private javax.swing.JTextArea taResultado;
    private javax.swing.JTextField tfAnoPesquisa;
    private javax.swing.JTextField tfMesPesquisa;
    // End of variables declaration//GEN-END:variables
}