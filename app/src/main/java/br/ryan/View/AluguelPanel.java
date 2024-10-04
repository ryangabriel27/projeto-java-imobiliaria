package br.ryan.View;

import java.awt.FlowLayout;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.ryan.Connection.AluguelDAO;
import br.ryan.Model.Aluguel;

public class AluguelPanel extends JPanel {
    private JPanel buttonPanel;
    private JButton realizaVenda, cancelaVenda;
    private JTextField inputProduto, inputQuantidade, inputTotal, inputCliente, inputData;
    private DefaultTableModel tableModel;
    private JTable table;
    private List<Aluguel> alugueis;
    private int linhaSelecionada = -1;
    private JScrollPane jSPane;

    public AluguelPanel() {
        super();
        alugueis = new ArrayList<>();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        realizaVenda = new JButton("Realizar Venda");
        cancelaVenda = new JButton("Cancelar Venda");
        inputProduto = new JTextField(10);
        inputQuantidade = new JTextField(10);
        inputTotal = new JTextField(10);
        inputCliente = new JTextField(10);
        inputData = new JTextField(10);

        JPanel title = new JPanel(new FlowLayout());
        title.add(new JLabel("Registro de Alugueis"));
        add(title);

        jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "#", "Imovél", "Cliente", "Data inicio", "Data fim" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        new AluguelDAO().criaTabela();
        atualizarTabela();
    }

    public void atualizarTabela() {
        tableModel.setRowCount(0);
        alugueis = new AluguelDAO().listarTodos();
        for (Aluguel aluguel : alugueis) {
            tableModel.addRow(new Object[] {
                    (alugueis.indexOf(aluguel)+1),
                    aluguel.getImovel().getCodigo_id(),
                    aluguel.getUsuario().getNome(),
                    aluguel.getData_inicio(),
                    aluguel.getData_fim()
            });
        }
    }

}
