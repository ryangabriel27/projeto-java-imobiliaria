package br.ryan.View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.ryan.Connection.ImovelDAO;
import br.ryan.Connection.UsuariosDAO;
import br.ryan.Controller.ImovelController;
import br.ryan.Model.Imovel;
import br.ryan.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ImovelPanel extends JPanel {
    private JButton cadastraImovel, editaImovel, apagaImovel;
    private JTextField inputCidade, inputEstado, inputEndereco, inputValorAluguel, inputDescricao;
    private DefaultTableModel tableModel;
    private JTable table;
    private List<Imovel> imoveis = new ArrayList<>();
    private int linhaSelecionada = -1;
    private JScrollPane jSPane;
    private JComboBox<String> inputStatus;

    public ImovelPanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Componentes
        cadastraImovel = new JButton("Cadastrar");
        apagaImovel = new JButton("Excluir");
        editaImovel = new JButton("Editar");
        inputCidade = new JTextField(20);
        inputEstado = new JTextField(20);
        inputEndereco = new JTextField(20);
        inputValorAluguel = new JTextField(10);
        inputDescricao = new JTextField(30);
        inputStatus = new JComboBox<>(new String[] { "DISPONIVEL", "ALUGADO" });

        // Estilização
        cadastraImovel.setBackground(new Color(50, 32, 120));
        cadastraImovel.setForeground(Color.white);
        apagaImovel.setBackground(new Color(126, 26, 26));
        apagaImovel.setForeground(Color.white);
        editaImovel.setBackground(new Color(50, 32, 120));
        editaImovel.setForeground(Color.white);

        // Título
        JPanel title = new JPanel(new FlowLayout());
        title.add(new JLabel("Cadastro de Imóveis"));
        add(title);

        // Painel de Entrada
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 2, 2));
        inputPanel.add(new JLabel("Cidade:"));
        inputPanel.add(inputCidade);
        inputPanel.add(new JLabel("Estado:"));
        inputPanel.add(inputEstado);
        inputPanel.add(new JLabel("Endereço:"));
        inputPanel.add(inputEndereco);
        inputPanel.add(new JLabel("Valor do Aluguel:"));
        inputPanel.add(inputValorAluguel);
        inputPanel.add(new JLabel("Descrição:"));
        inputPanel.add(inputDescricao);
        inputPanel.add(new JLabel("Status:"));
        inputPanel.add(inputStatus);
        add(inputPanel);

        // Botões
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(cadastraImovel);
        buttonPanel.add(editaImovel);
        buttonPanel.add(apagaImovel);
        add(buttonPanel);

        // Tabela de Imóveis
        tableModel = new DefaultTableModel(
                new String[] { "#", "Cidade", "Estado", "Endereço", "Valor do Aluguel", "Descrição", "Status" }, 0);
        table = new JTable(tableModel);
        jSPane = new JScrollPane(table);
        add(jSPane);
        // Cria o banco de dados caso não tenha sido criado
        new ImovelDAO().criaTabela();
        atualizarTabela();
        // -------------------
        ImovelController control = new ImovelController(imoveis, tableModel, table);

        // Ações dos Botões
        cadastraImovel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String cidade = inputCidade.getText();
                    String estado = inputEstado.getText();
                    String endereco = inputEndereco.getText();
                    double valorAluguel = Double.parseDouble(inputValorAluguel.getText());
                    String descricao = inputDescricao.getText();
                    String status = String.valueOf(inputStatus.getSelectedItem());
                    control.cadastrarImovel(cidade, estado, endereco, valorAluguel,
                            descricao, status);
                    clearInputs();
                } catch (Exception err) {
                    // TODO: handle exception
                    System.out.println(err.getMessage());
                    JOptionPane.showMessageDialog(null, "Preencha os campos corretamente e tente mais uma vez..",
                            "ERRO", JOptionPane.ERROR_MESSAGE);

                }

            }
        });

        editaImovel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                linhaSelecionada = table.getSelectedRow();
                if (linhaSelecionada >= 0) {
                    String cidade = inputCidade.getText();
                    String estado = inputEstado.getText();
                    String endereco = inputEndereco.getText();
                    double valorAluguel = Double.parseDouble(inputValorAluguel.getText());
                    String descricao = inputDescricao.getText();
                    String status = String.valueOf(inputStatus.getSelectedItem());
                    Imovel imovel = new Imovel();
                    imovel.setCidade(cidade);
                    imovel.setEstado(estado);
                    imovel.setEndereco(endereco);
                    imovel.setValor_aluguel(valorAluguel);
                    imovel.setDescricao(descricao);
                    imovel.setStatus(status);
                    String codigo_id = String.valueOf(tableModel.getValueAt(linhaSelecionada, 0));
                    control.atualizarImovel(imovel, codigo_id);
                    clearInputs();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um imóvel para editar.");
                }
            }
        });

        apagaImovel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                linhaSelecionada = table.getSelectedRow();
                if (linhaSelecionada >= 0) {
                    String codigo_id = String.valueOf(tableModel.getValueAt(linhaSelecionada, 0)); // Aqui você deve ter
                                                                                                   // o ID do imóvel.
                    control.apagarImovel(codigo_id);
                    clearInputs();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um imóvel para excluir.");
                }
            }
        });

        // Listener para seleção de linha
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                linhaSelecionada = table.getSelectedRow();
                if (linhaSelecionada >= 0) {
                    inputCidade.setText((String) tableModel.getValueAt(linhaSelecionada, 1));
                    inputEstado.setText((String) tableModel.getValueAt(linhaSelecionada, 2));
                    inputEndereco.setText((String) tableModel.getValueAt(linhaSelecionada, 3));
                    inputValorAluguel.setText(String.valueOf(tableModel.getValueAt(linhaSelecionada, 4)));
                    inputDescricao.setText((String) tableModel.getValueAt(linhaSelecionada, 5));
                    inputStatus.setSelectedItem(tableModel.getValueAt(linhaSelecionada, 6));
                }
            }
        });
    }

    private void clearInputs() {
        inputCidade.setText("");
        inputEstado.setText("");
        inputEndereco.setText("");
        inputValorAluguel.setText("");
        inputDescricao.setText("");
        inputStatus.setSelectedIndex(0);
        linhaSelecionada = -1;
    }

    public void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        imoveis = new ImovelDAO().listarTodos();
        // Obtém os usuários atualizados do banco de dados
        for (Imovel imovel : imoveis) {
            // Adiciona os dados de cada usuário como uma nova linha na tabela Swing
            tableModel.addRow(
                    new Object[] { imovel.getCodigo_id(), imovel.getCidade(), imovel.getEstado(), imovel.getEndereco(),
                            imovel.getValor_aluguel(), imovel.getDescricao(), imovel.getStatus() });
        }
    }
}
