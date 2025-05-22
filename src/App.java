import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class App {
    private JFrame frame;
    private JTextArea textArea;
    private ArrayList<Produto> listaProdutos;

    public App() {
        listaProdutos = new ArrayList<>();
        frame = new JFrame("Sistema de gerenciamento de estoque");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 5));

        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnEditar = new JButton("Editar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnVisualizar = new JButton("Visualizar");
        JButton btnSair = new JButton("Sair");

        panel.add(btnCadastrar);
        panel.add(btnEditar);
        panel.add(btnExcluir);
        panel.add(btnVisualizar);
        panel.add(btnSair);

        frame.add(panel, BorderLayout.SOUTH);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarProduto();
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarProduto();
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirProduto();
            }
        });

        btnVisualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizarProdutos();
            }
        });

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }

    private void cadastrarProduto() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
            String nome = JOptionPane.showInputDialog("Nome: ");
            String descricao = JOptionPane.showInputDialog("Descrição: ");
            double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço: "));
            int qntEstoque = Integer.parseInt(JOptionPane.showInputDialog("Estoque: "));
            String categoria = JOptionPane.showInputDialog("Categoria: ");

            listaProdutos.add(new Produto(id, nome, descricao, preco, qntEstoque, categoria));
            JOptionPane.showMessageDialog(frame, "Produto cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    private void editarProduto() {
        try {
            int idBusca = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do item:"));
            Produto produtoParaEditar = null;

            for (Produto produto : listaProdutos) {
                if (produto.getId() == idBusca) {
                    produtoParaEditar = produto;
                    break;
                }
            }

            if (produtoParaEditar == null) {
                JOptionPane.showMessageDialog(frame, "Produto com ID " + idBusca + " não encontrado!");
                return;
            }

            String novoNome = JOptionPane.showInputDialog("Novo Nome: ", produtoParaEditar.getNome());
            String novaDescricao = JOptionPane.showInputDialog("Nova Descrição: ", produtoParaEditar.getDescricao());
            double novoPreco = Double.parseDouble(JOptionPane.showInputDialog("Novo Preço: ", produtoParaEditar.getPreco()));
            int novaQntEstoque = Integer.parseInt(JOptionPane.showInputDialog("Novo Estoque: ", produtoParaEditar.getQuantidadeEstoque()));
            String novaCategoria = JOptionPane.showInputDialog("Nova Categoria: ", produtoParaEditar.getCategoria());

            produtoParaEditar.setNome(novoNome);
            produtoParaEditar.setDescricao(novaDescricao);
            produtoParaEditar.setPreco(novoPreco);
            produtoParaEditar.setQuantidadeEstoque(novaQntEstoque);
            produtoParaEditar.setCategoria(novaCategoria);

            JOptionPane.showMessageDialog(frame, "Produto atualizado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Erro ao editar produto: " + e.getMessage());
        }
    }

    private void excluirProduto() {
        try {
            int idBusca = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do item:"));
            Produto produtoParaExcluir = null;

            for (Produto produto : listaProdutos) {
                if (produto.getId() == idBusca) {
                    produtoParaExcluir = produto;
                    break;
                }
            }

            if (produtoParaExcluir == null) {
                JOptionPane.showMessageDialog(frame, "Produto com ID " + idBusca + " não encontrado!");
                return;
            }

            listaProdutos.remove(produtoParaExcluir);
            JOptionPane.showMessageDialog(frame, "Produto removido com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Erro ao excluir produto: " + e.getMessage());
        }
    }

    private void visualizarProdutos() {
        StringBuilder sb = new StringBuilder();
        for (Produto produto : listaProdutos) {
            sb.append(produto.toString()).append("\n");
        }
        textArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        new App();
    }
}
