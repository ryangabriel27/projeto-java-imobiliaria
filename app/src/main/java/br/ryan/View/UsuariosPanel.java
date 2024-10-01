package br.ryan.View;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.ryan.Connection.UsuariosDAO;
import br.ryan.Controller.UsuarioController;
import br.ryan.Model.Usuario;

public class UsuariosPanel extends JPanel {
    // Componentes
    private JPanel buttonPanel;
    private JButton cadastraUsuario, editaUsuario, apagaUsuario;
    private JTextField inputCpf, inputNome, inputTelefone, inputEmail;
    private DefaultTableModel tableModel;
    private JTable table;
    private List<Usuario> usuarios;
    private int linhaSelecionada = -1;
    private JScrollPane jSPane;
    private UsuarioController control;

    public UsuariosPanel() {
        super();
        usuarios = new ArrayList<>();
       

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Definindo layout do UsuariosPanel

        // --------------------------*
        // Componentes
        cadastraUsuario = new JButton("Cadastrar");
        apagaUsuario = new JButton("Excluir");
        editaUsuario = new JButton("Editar");
        inputCpf = new JTextField(11); // CPF
        inputNome = new JTextField(20); // Nome Completo
        inputTelefone = new JTextField(15); // Telefone
        inputEmail = new JTextField(20); // Email

        // --------------------------*
        JPanel title = new JPanel(new FlowLayout());
        title.add(new JLabel("Cadastro de Usuários"));
        add(title);
        // Adicionar os componentes:
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 2, 2)); // InputPanel
        inputPanel.add(new JLabel("Digite o CPF do usuário:"));
        inputPanel.add(inputCpf);
        inputPanel.add(new JLabel("Digite o nome completo do usuário:"));
        inputPanel.add(inputNome);
        inputPanel.add(new JLabel("Digite o telefone do usuário:"));
        inputPanel.add(inputTelefone);
        inputPanel.add(new JLabel("Digite o email do usuário:"));
        inputPanel.add(inputEmail);
        add(inputPanel);

        // --------------------------*
        buttonPanel = new JPanel(); // Painel de botões
        buttonPanel.add(cadastraUsuario);
        buttonPanel.add(editaUsuario);
        buttonPanel.add(apagaUsuario);
        add(buttonPanel); // Adicionando o painel de botões à Tela Principal

        // --------------------------*
        jSPane = new JScrollPane(); // Criando um scrollPane
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "CPF", "Nome Completo", "Telefone", "Email" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);
        // Cria o banco de dados caso não tenha sido criado
        new UsuariosDAO().criaTabela();
        // Atualiza a tabela
        atualizarTabela();

        // --------------------------*
        // Estilização:
        apagaUsuario.setBackground(new Color(168, 3, 3));
        apagaUsuario.setForeground(new Color(255, 255, 255));
        cadastraUsuario.setBackground(new Color(46, 128, 32));
        cadastraUsuario.setForeground(new Color(255, 255, 255));
        editaUsuario.setBackground(new Color(109, 110, 109));
        editaUsuario.setForeground(new Color(255, 255, 255));
        // --------------------------*

        control = new UsuarioController(usuarios, tableModel, table); // Instanciando o controller


        // Tratamento de eventos:

        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                linhaSelecionada = table.rowAtPoint(e.getPoint());
                if (linhaSelecionada != -1) {
                    inputCpf.setText((String) table.getValueAt(linhaSelecionada, 0));
                    inputNome.setText((String) table.getValueAt(linhaSelecionada, 1));
                    inputTelefone.setText((String) table.getValueAt(linhaSelecionada, 2));
                    inputEmail.setText((String) table.getValueAt(linhaSelecionada, 3));
                }
            }
        });

        // Cadastrar um usuário:
        cadastraUsuario.addActionListener(e -> {
            if (!inputCpf.getText().isEmpty() && !inputNome.getText().isEmpty()
                    && !inputTelefone.getText().isEmpty() && !inputEmail.getText().isEmpty()) {

                control.cadastrarUsuario(inputCpf.getText(), inputNome.getText(), inputTelefone.getText(),
                        inputEmail.getText());
                // Limpa os campos de entrada após a operação de cadastro
                inputCpf.setText("");
                inputNome.setText("");
                inputTelefone.setText("");
                inputEmail.setText("");
            } else {
                JOptionPane.showMessageDialog(inputPanel,
                        "Preencha os campos corretamente para cadastrar um usuário!!", null,
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        // --------------------------*
        // Editar um usuário:
        editaUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "Deseja atualizar as informações deste usuário?",
                        "Editar", JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    control.atualizar(inputCpf.getText(), inputNome.getText(), inputTelefone.getText(),
                            inputEmail.getText());
                }
            }
        });

        // --------------------------*
        // Apagar um usuário:
        apagaUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "Deseja excluir este usuário?",
                        "Excluir", JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    control.apagar(inputCpf.getText());
                    // Limpa os campos de entrada após a operação de exclusão
                    inputCpf.setText("");
                    inputNome.setText("");
                    inputTelefone.setText("");
                    inputEmail.setText("");
                }
            }
        });
    }

    public void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        usuarios = new UsuariosDAO().listarTodos();
        // Obtém os usuários atualizados do banco de dados
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getCpf());
            // Adiciona os dados de cada usuário como uma nova linha na tabela Swing
            tableModel.addRow(
                    new Object[] { usuario.getCpf(), usuario.getNome(), usuario.getTelefone(), usuario.getEmail() });
        }
    }
}
