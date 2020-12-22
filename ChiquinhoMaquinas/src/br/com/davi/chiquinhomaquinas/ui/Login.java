package br.com.davi.chiquinhomaquinas.ui;

import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.entidade.Usuario;
import br.com.davi.chiquinhomaquinas.negocio.UsuarioControle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        labelLogo = new javax.swing.JLabel();
        tfLogin = new javax.swing.JTextField();
        pfSenha = new javax.swing.JPasswordField();
        botaoEntrar = new javax.swing.JButton();
        labelLogin = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        labelAsterisco1 = new javax.swing.JLabel();
        labelAsterisco2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/logo.png")).getImage());
        setPreferredSize(new java.awt.Dimension(440, 370));
        setResizable(false);

        painel.setBackground(new java.awt.Color(255, 255, 255));
        painel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        painel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/logo.png"))); // NOI18N
        painel.add(labelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 340, 170));

        tfLogin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfLogin.setCaretColor(new java.awt.Color(255, 153, 51));
        tfLogin.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        tfLogin.setPreferredSize(new java.awt.Dimension(6, 30));
        tfLogin.setSelectionColor(new java.awt.Color(255, 153, 51));
        painel.add(tfLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 330, -1));

        pfSenha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        pfSenha.setCaretColor(new java.awt.Color(255, 153, 51));
        pfSenha.setDisabledTextColor(new java.awt.Color(255, 153, 51));
        pfSenha.setPreferredSize(new java.awt.Dimension(6, 30));
        pfSenha.setSelectionColor(new java.awt.Color(255, 153, 51));
        painel.add(pfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 330, -1));

        botaoEntrar.setBackground(new java.awt.Color(255, 255, 255));
        botaoEntrar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botaoEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/davi/chiquinhomaquinas/imagens/arrow_right.png"))); // NOI18N
        botaoEntrar.setText("Entrar");
        botaoEntrar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        botaoEntrar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botaoEntrar.setPreferredSize(new java.awt.Dimension(65, 30));
        botaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEntrarActionPerformed(evt);
            }
        });
        painel.add(botaoEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 90, 30));

        labelLogin.setBackground(new java.awt.Color(255, 255, 255));
        labelLogin.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelLogin.setText("Login");
        painel.add(labelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        labelSenha.setBackground(new java.awt.Color(255, 255, 255));
        labelSenha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelSenha.setText("Senha");
        painel.add(labelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        labelAsterisco1.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco1.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco1.setText("*");
        painel.add(labelAsterisco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 10, -1));

        labelAsterisco2.setBackground(new java.awt.Color(255, 255, 255));
        labelAsterisco2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelAsterisco2.setForeground(new java.awt.Color(255, 0, 0));
        labelAsterisco2.setText("*");
        painel.add(labelAsterisco2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 10, -1));

        getContentPane().add(painel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarActionPerformed
        if (tfLogin.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O Campo [Login] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (pfSenha.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "O Campo [Senha] é obrigatório! Por favor, preencha-o.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        UsuarioControle uControle = new UsuarioControle();

        try {
            String strPass = new String(pfSenha.getPassword()).trim();
            Usuario usuario = uControle.login(tfLogin.getText(), strPass);

            if (usuario != null) {
                TelaPrincipal tp = new TelaPrincipal(tfLogin.getText());
                tp.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Os Campos [Login/Senha] são inválidos! Por favor, corrija-os.", "Aviso", JOptionPane.ERROR_MESSAGE);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_botaoEntrarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEntrar;
    private javax.swing.JLabel labelAsterisco1;
    private javax.swing.JLabel labelAsterisco2;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JPanel painel;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JTextField tfLogin;
    // End of variables declaration//GEN-END:variables
}
