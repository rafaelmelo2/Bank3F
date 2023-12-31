/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bancopoo;

import dados.BdBanco;
import bancopoo.painelLogin;
import java.awt.Cursor;

import java.awt.Image;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultCaret;
import objetos.Usuario;

/**
 *
 * @author Fael
 */
public class painelPrincipal extends javax.swing.JFrame {
    
    
    private String cpf_logado;
    private Usuario usuario_logado;
    //private Object[] dadosUsuarioLogado;
    
    BdBanco db = new BdBanco();

    public painelPrincipal(String cpf) {
        ImageIcon icon = new ImageIcon("src/img/bank.png"); // Substitua pelo caminho do ícone .ico ou .png
        setIconImage(icon.getImage());
        
        initComponents();
        this.cpf_logado = cpf;
        
        db.conectar();
        this.usuario_logado = db.carregaDadosDB(cpf);
        
        if (this.usuario_logado  == null) {
            JOptionPane.showMessageDialog(this, "Usuário não encontrado no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
        
        
        
        
        ImageIcon iconPerfil = new ImageIcon(usuario_logado.getFoto());
        Image imagemPerfil = iconPerfil.getImage();
        int larguraDesejada = 150;
        int novaAltura = (int) ((double) larguraDesejada / imagemPerfil.getWidth(null) * imagemPerfil.getHeight(null));
        Image imagemRedimensionada = imagemPerfil.getScaledInstance(larguraDesejada, novaAltura, Image.SCALE_SMOOTH);
        ImageIcon iconPerfilRedimensionado = new ImageIcon(imagemRedimensionada);
        
        
        
        
        IconeFoto.setIcon(iconPerfilRedimensionado);
        
        
        db.desconectar();
        //this.labelConta.setText(usuario_logado.getConta());
        this.CampoConta.setText(usuario_logado.getConta());
        
        CampoConta.setOpaque(false);
        CampoConta.setEditable(false);
        //CampoConta.setFocusable(false);
        CampoConta.setBorder(BorderFactory.createEmptyBorder());
        CampoConta.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        this.labelAgencia.setText(usuario_logado.getAgencia());
        this.labelNomeUsuario.setText(usuario_logado.getNome());
        this.labelNomeUsuario2.setText(usuario_logado.getNome() + " " + usuario_logado.getSobrenome());
        this.labelSaldo.setText(String.valueOf(usuario_logado.getSaldo()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipalGeral = new javax.swing.JPanel();
        PanelHeader = new javax.swing.JPanel();
        labelImagemBanco = new javax.swing.JLabel();
        labelOlaUsuario = new javax.swing.JLabel();
        labelNomeUsuario = new javax.swing.JLabel();
        PanelBody = new javax.swing.JPanel();
        botaoSair = new javax.swing.JButton();
        botaoInvestir = new javax.swing.JButton();
        botaoDepositar = new javax.swing.JButton();
        botaoTransferir = new javax.swing.JButton();
        botaoTransacoes = new javax.swing.JButton();
        botaoSacar = new javax.swing.JButton();
        PanelDados = new javax.swing.JPanel();
        IconeFoto = new javax.swing.JLabel();
        PanelDadosDois = new javax.swing.JPanel();
        LabelforNConta = new javax.swing.JLabel();
        LabelforNAgencia = new javax.swing.JLabel();
        labelAgencia = new javax.swing.JLabel();
        LabelforNome = new javax.swing.JLabel();
        labelNomeUsuario2 = new javax.swing.JLabel();
        CampoConta = new javax.swing.JTextField();
        LabelforSaldo = new javax.swing.JLabel();
        labelSaldo = new javax.swing.JLabel();
        botaoEditarInformacoes = new javax.swing.JButton();
        BotaoVisibilidade = new javax.swing.JButton();
        PanelCop = new javax.swing.JPanel();
        LabelCop = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("3F");
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        PanelPrincipalGeral.setBackground(new java.awt.Color(248, 237, 248));
        PanelPrincipalGeral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelPrincipalGeral.setForeground(new java.awt.Color(248, 237, 248));
        PanelPrincipalGeral.setPreferredSize(new java.awt.Dimension(1280, 720));
        PanelPrincipalGeral.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PanelPrincipalGeralFocusGained(evt);
            }
        });
        PanelPrincipalGeral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelPrincipalGeralMouseClicked(evt);
            }
        });

        PanelHeader.setBackground(new java.awt.Color(38, 15, 38));

        labelImagemBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LOGO 3F pequena.png"))); // NOI18N
        labelImagemBanco.setText(" ");
        labelImagemBanco.setToolTipText("3F Internet Banking");
        labelImagemBanco.setPreferredSize(new java.awt.Dimension(100, 100));

        labelOlaUsuario.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        labelOlaUsuario.setForeground(new java.awt.Color(255, 255, 255));
        labelOlaUsuario.setText("Olá, ");

        labelNomeUsuario.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelNomeUsuario.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelHeaderLayout = new javax.swing.GroupLayout(PanelHeader);
        PanelHeader.setLayout(PanelHeaderLayout);
        PanelHeaderLayout.setHorizontalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(labelImagemBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelOlaUsuario)
                    .addComponent(labelNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        PanelHeaderLayout.setVerticalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(labelOlaUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHeaderLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(labelImagemBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        PanelBody.setBackground(new java.awt.Color(248, 237, 248));

        botaoSair.setBackground(new java.awt.Color(227, 38, 54));
        botaoSair.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botaoSair.setForeground(new java.awt.Color(255, 255, 255));
        botaoSair.setText("SAIR");
        botaoSair.setToolTipText("Voltar a tela de login");
        botaoSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        botaoInvestir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botaoInvestir.setForeground(new java.awt.Color(38, 15, 38));
        botaoInvestir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-crescimento-de-estoques-48.png"))); // NOI18N
        botaoInvestir.setText("INVESTIR");
        botaoInvestir.setToolTipText("Realizar investimento");
        botaoInvestir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoInvestir.setPreferredSize(new java.awt.Dimension(106, 23));
        botaoInvestir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoInvestirActionPerformed(evt);
            }
        });

        botaoDepositar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botaoDepositar.setForeground(new java.awt.Color(38, 15, 38));
        botaoDepositar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/deposito (1).png"))); // NOI18N
        botaoDepositar.setText("DEPOSITAR");
        botaoDepositar.setToolTipText("Realizar depósito");
        botaoDepositar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDepositarActionPerformed(evt);
            }
        });

        botaoTransferir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botaoTransferir.setForeground(new java.awt.Color(38, 15, 38));
        botaoTransferir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/transferir-dados.png"))); // NOI18N
        botaoTransferir.setText("TRANSFERIR");
        botaoTransferir.setToolTipText("Realizar tranferência");
        botaoTransferir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTransferirActionPerformed(evt);
            }
        });

        botaoTransacoes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botaoTransacoes.setForeground(new java.awt.Color(38, 15, 38));
        botaoTransacoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-histórico-48.png"))); // NOI18N
        botaoTransacoes.setText("TRANSAÇÕES");
        botaoTransacoes.setToolTipText("Verificar histórico de transferências");
        botaoTransacoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoTransacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTransacoesActionPerformed(evt);
            }
        });

        botaoSacar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botaoSacar.setForeground(new java.awt.Color(38, 15, 38));
        botaoSacar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bolsa_dinheiro.png"))); // NOI18N
        botaoSacar.setText("SACAR");
        botaoSacar.setToolTipText("Realizar saque");
        botaoSacar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoSacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSacarActionPerformed(evt);
            }
        });

        PanelDados.setBackground(new java.awt.Color(255, 255, 255));

        IconeFoto.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        PanelDadosDois.setBackground(new java.awt.Color(38, 15, 38));
        PanelDadosDois.setForeground(new java.awt.Color(255, 255, 255));

        LabelforNConta.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        LabelforNConta.setForeground(new java.awt.Color(255, 255, 255));
        LabelforNConta.setText("N° da Conta: ");

        LabelforNAgencia.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        LabelforNAgencia.setForeground(new java.awt.Color(255, 255, 255));
        LabelforNAgencia.setLabelFor(labelAgencia);
        LabelforNAgencia.setText("N° da Agência: ");

        labelAgencia.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        labelAgencia.setForeground(new java.awt.Color(255, 255, 255));
        labelAgencia.setText(" ");
        labelAgencia.setToolTipText("Número da Agência");
        labelAgencia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        LabelforNome.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        LabelforNome.setForeground(new java.awt.Color(255, 255, 255));
        LabelforNome.setText("Proprietário: ");

        labelNomeUsuario2.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        labelNomeUsuario2.setForeground(new java.awt.Color(81, 223, 132));
        labelNomeUsuario2.setToolTipText("Nome do proprietário");
        labelNomeUsuario2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        CampoConta.setBackground(new java.awt.Color(38, 15, 38));
        CampoConta.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        CampoConta.setForeground(new java.awt.Color(255, 255, 255));
        CampoConta.setToolTipText("N° da Conta");
        CampoConta.setBorder(null);
        CampoConta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CampoContaFocusLost(evt);
            }
        });
        CampoConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CampoContaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CampoContaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelDadosDoisLayout = new javax.swing.GroupLayout(PanelDadosDois);
        PanelDadosDois.setLayout(PanelDadosDoisLayout);
        PanelDadosDoisLayout.setHorizontalGroup(
            PanelDadosDoisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDadosDoisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDadosDoisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelDadosDoisLayout.createSequentialGroup()
                        .addComponent(LabelforNAgencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelDadosDoisLayout.createSequentialGroup()
                        .addComponent(LabelforNConta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CampoConta, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelDadosDoisLayout.createSequentialGroup()
                        .addComponent(LabelforNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNomeUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        PanelDadosDoisLayout.setVerticalGroup(
            PanelDadosDoisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDadosDoisLayout.createSequentialGroup()
                .addGroup(PanelDadosDoisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDadosDoisLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LabelforNome, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDadosDoisLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelNomeUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(PanelDadosDoisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelforNConta, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(CampoConta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelDadosDoisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelforNAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        LabelforSaldo.setBackground(new java.awt.Color(255, 255, 255));
        LabelforSaldo.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        LabelforSaldo.setForeground(new java.awt.Color(81, 223, 132));
        LabelforSaldo.setLabelFor(labelSaldo);
        LabelforSaldo.setText("SALDO:");

        labelSaldo.setFont(new java.awt.Font("Calibri Light", 1, 48)); // NOI18N
        labelSaldo.setForeground(new java.awt.Color(38, 15, 38));
        labelSaldo.setText(" ");
        labelSaldo.setToolTipText("Seu saldo");

        botaoEditarInformacoes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoEditarInformacoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        botaoEditarInformacoes.setText("Editar Perfil");
        botaoEditarInformacoes.setToolTipText("Edição de perfil");
        botaoEditarInformacoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoEditarInformacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarInformacoesActionPerformed(evt);
            }
        });

        BotaoVisibilidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/olhos 20x20.png"))); // NOI18N
        BotaoVisibilidade.setToolTipText("Tornar saldo visível");
        BotaoVisibilidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoVisibilidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoVisibilidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelDadosLayout = new javax.swing.GroupLayout(PanelDados);
        PanelDados.setLayout(PanelDadosLayout);
        PanelDadosLayout.setHorizontalGroup(
            PanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDadosLayout.createSequentialGroup()
                .addGroup(PanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDadosLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(IconeFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(PanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PanelDadosLayout.createSequentialGroup()
                                .addGroup(PanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelforSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelDadosLayout.createSequentialGroup()
                                        .addComponent(botaoEditarInformacoes)
                                        .addGap(50, 50, 50)
                                        .addComponent(BotaoVisibilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(PanelDadosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelDadosDois, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelDadosLayout.setVerticalGroup(
            PanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDadosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(PanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDadosLayout.createSequentialGroup()
                        .addGroup(PanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoEditarInformacoes)
                            .addComponent(BotaoVisibilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelforSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(IconeFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelDadosDois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelBodyLayout = new javax.swing.GroupLayout(PanelBody);
        PanelBody.setLayout(PanelBodyLayout);
        PanelBodyLayout.setHorizontalGroup(
            PanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBodyLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(PanelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128)
                .addGroup(PanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelBodyLayout.createSequentialGroup()
                        .addGroup(PanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(botaoTransferir, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(botaoSacar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoDepositar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addGroup(PanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botaoTransacoes, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(botaoInvestir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(37, 37, 37))
        );
        PanelBodyLayout.setVerticalGroup(
            PanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelBodyLayout.createSequentialGroup()
                        .addGroup(PanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelBodyLayout.createSequentialGroup()
                                .addComponent(botaoDepositar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(botaoSacar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelBodyLayout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(botaoInvestir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(PanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelBodyLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(botaoTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelBodyLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(botaoTransferir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PanelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelCop.setBackground(new java.awt.Color(51, 51, 51));

        LabelCop.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelCop.setForeground(new java.awt.Color(255, 255, 255));
        LabelCop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelCop.setText("© Todos os direitos Reservados - 3F");

        javax.swing.GroupLayout PanelCopLayout = new javax.swing.GroupLayout(PanelCop);
        PanelCop.setLayout(PanelCopLayout);
        PanelCopLayout.setHorizontalGroup(
            PanelCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelCop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelCopLayout.setVerticalGroup(
            PanelCopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCopLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(LabelCop, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout PanelPrincipalGeralLayout = new javax.swing.GroupLayout(PanelPrincipalGeral);
        PanelPrincipalGeral.setLayout(PanelPrincipalGeralLayout);
        PanelPrincipalGeralLayout.setHorizontalGroup(
            PanelPrincipalGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelPrincipalGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(PanelCop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelPrincipalGeralLayout.setVerticalGroup(
            PanelPrincipalGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalGeralLayout.createSequentialGroup()
                .addComponent(PanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelCop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelPrincipalGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 1125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipalGeral, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );

        PanelPrincipalGeral.getAccessibleContext().setAccessibleName("padrao");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
        
    
   
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        db.conectar();
        if(db.estaConectado()){
            this.usuario_logado = db.carregaDadosDB(cpf_logado);
            DecimalFormat formato = new DecimalFormat("0.00");
            labelSaldo.setText("R$ " + String.valueOf(formato.format(usuario_logado.getSaldo())));
            labelNomeUsuario.setText(usuario_logado.getNome() + " " + usuario_logado.getSobrenome());
            labelNomeUsuario2.setText(usuario_logado.getNome() + " " + usuario_logado.getSobrenome());

            
            
            ImageIcon iconPerfil = new ImageIcon(usuario_logado.getFoto());
            Image imagemPerfil = iconPerfil.getImage();
            int larguraDesejada = 150;
            int novaAltura = (int) ((double) larguraDesejada / imagemPerfil.getWidth(null) * imagemPerfil.getHeight(null));
            Image imagemRedimensionada = imagemPerfil.getScaledInstance(larguraDesejada, novaAltura, Image.SCALE_SMOOTH);
            ImageIcon iconPerfilRedimensionado = new ImageIcon(imagemRedimensionada);
            IconeFoto.setIcon(iconPerfilRedimensionado);
        }
        db.desconectar();
    }//GEN-LAST:event_formWindowActivated

    private void botaoTransacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoTransacoesActionPerformed
        painelTransacoes painelTransacoes = new painelTransacoes(this.usuario_logado, botaoTransacoes);
        painelTransacoes.setVisible(true);
        painelTransacoes.setLocationRelativeTo(null);
        botaoTransacoes.setEnabled(false);
    }//GEN-LAST:event_botaoTransacoesActionPerformed

    private void botaoTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoTransferirActionPerformed
        painelTransferir painelTransferir = new painelTransferir(this.usuario_logado, botaoTransferir);
        painelTransferir.setLocationRelativeTo(null);
        painelTransferir.setVisible(true);
        botaoTransferir.setEnabled(false);
    }//GEN-LAST:event_botaoTransferirActionPerformed

    private void botaoSacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSacarActionPerformed
        painelSacar painelsacar = new painelSacar(usuario_logado, botaoSacar);
        painelsacar.setVisible(true);
        painelsacar.setLocationRelativeTo(null);
        botaoSacar.setEnabled(false);

    }//GEN-LAST:event_botaoSacarActionPerformed

    private void botaoDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDepositarActionPerformed
        painelDepositar pdepositar = new painelDepositar(this.usuario_logado, botaoDepositar);
        pdepositar.setLocationRelativeTo(null);
        pdepositar.setVisible(true);
        botaoDepositar.setEnabled(false);
    }//GEN-LAST:event_botaoDepositarActionPerformed

    private void botaoInvestirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoInvestirActionPerformed
        painelInvestimentos investimentos = new painelInvestimentos(this.usuario_logado, botaoInvestir);
        investimentos.setLocationRelativeTo(null);// Torna a tela principal visível
        investimentos.setVisible(true);
        botaoInvestir.setEnabled(false);
    }//GEN-LAST:event_botaoInvestirActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        painelLogin aux = new painelLogin();
        aux.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoSairActionPerformed

    private void botaoEditarInformacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarInformacoesActionPerformed
        painelEditarUsuario painelEditar = new painelEditarUsuario(this.usuario_logado, botaoEditarInformacoes);
        painelEditar.setVisible(true);
        painelEditar.setLocationRelativeTo(null);
        botaoEditarInformacoes.setEnabled(false);
    }//GEN-LAST:event_botaoEditarInformacoesActionPerformed

    private void BotaoVisibilidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoVisibilidadeActionPerformed
        labelSaldo.setVisible(!labelSaldo.isVisible());
    }//GEN-LAST:event_BotaoVisibilidadeActionPerformed

    private void CampoContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CampoContaMouseClicked
        CampoConta.selectAll();
    }//GEN-LAST:event_CampoContaMouseClicked

    private void CampoContaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CampoContaMouseExited
        
    }//GEN-LAST:event_CampoContaMouseExited

    private void PanelPrincipalGeralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelPrincipalGeralMouseClicked
        CampoConta.setCaretPosition(0);
        DefaultCaret caret = (DefaultCaret) CampoConta.getCaret();
        caret.setBlinkRate(0);
        caret.setVisible(false);
       
    }//GEN-LAST:event_PanelPrincipalGeralMouseClicked

    private void CampoContaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CampoContaFocusLost

    }//GEN-LAST:event_CampoContaFocusLost

    private void PanelPrincipalGeralFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PanelPrincipalGeralFocusGained

    }//GEN-LAST:event_PanelPrincipalGeralFocusGained

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoVisibilidade;
    private javax.swing.JTextField CampoConta;
    private javax.swing.JLabel IconeFoto;
    private javax.swing.JLabel LabelCop;
    private javax.swing.JLabel LabelforNAgencia;
    private javax.swing.JLabel LabelforNConta;
    private javax.swing.JLabel LabelforNome;
    private javax.swing.JLabel LabelforSaldo;
    private javax.swing.JPanel PanelBody;
    private javax.swing.JPanel PanelCop;
    private javax.swing.JPanel PanelDados;
    private javax.swing.JPanel PanelDadosDois;
    private javax.swing.JPanel PanelHeader;
    private javax.swing.JPanel PanelPrincipalGeral;
    private javax.swing.JButton botaoDepositar;
    private javax.swing.JButton botaoEditarInformacoes;
    private javax.swing.JButton botaoInvestir;
    private javax.swing.JButton botaoSacar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JButton botaoTransacoes;
    private javax.swing.JButton botaoTransferir;
    private javax.swing.JLabel labelAgencia;
    private javax.swing.JLabel labelImagemBanco;
    private javax.swing.JLabel labelNomeUsuario;
    private javax.swing.JLabel labelNomeUsuario2;
    private javax.swing.JLabel labelOlaUsuario;
    private javax.swing.JLabel labelSaldo;
    // End of variables declaration//GEN-END:variables
}
