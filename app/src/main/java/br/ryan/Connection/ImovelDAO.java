package br.ryan.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ryan.Model.Imovel;

public class ImovelDAO {
    private Connection connection;

    public ImovelDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS imoveis (id SERIAL PRIMARY KEY, cidade VARCHAR(255), estado VARCHAR(255), endereco VARCHAR(255), valor_aluguel DECIMAL(10, 2), descricao VARCHAR(255), status VARCHAR(50))";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela de imóveis criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela de imóveis: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    public List<Imovel> listarTodos() {
        List<Imovel> imoveis = new ArrayList<>();
        String sql = "SELECT * FROM imoveis";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Imovel imovel = new Imovel();
                imovel.setCidade(rs.getString("cidade"));
                imovel.setEstado(rs.getString("estado"));
                imovel.setEndereco(rs.getString("endereco"));
                imovel.setValor_aluguel(rs.getDouble("valor_aluguel"));
                imovel.setDescricao(rs.getString("descricao"));
                imovel.setStatus(rs.getString("status"));
                imoveis.add(imovel);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
        return imoveis;
    }

    public void cadastrar(Imovel imovel) {
        String sql = "INSERT INTO imoveis(cidade, estado, endereco, valor_aluguel, descricao, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, imovel.getCidade());
            stmt.setString(2, imovel.getEstado());
            stmt.setString(3, imovel.getEndereco());
            stmt.setDouble(4, imovel.getValor_aluguel());
            stmt.setString(5, imovel.getDescricao());
            stmt.setString(6, imovel.getStatus());
            stmt.executeUpdate();
            System.out.println("Imóvel cadastrado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar imóvel no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    public void atualizar(Imovel imovel, int id) {
        String sql = "UPDATE imoveis SET cidade = ?, estado = ?, endereco = ?, valor_aluguel = ?, descricao = ?, status = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, imovel.getCidade());
            stmt.setString(2, imovel.getEstado());
            stmt.setString(3, imovel.getEndereco());
            stmt.setDouble(4, imovel.getValor_aluguel());
            stmt.setString(5, imovel.getDescricao());
            stmt.setString(6, imovel.getStatus());
            stmt.setInt(7, id);
            stmt.executeUpdate();
            System.out.println("Imóvel atualizado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar imóvel no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    public void apagar(int id) {
        String sql = "DELETE FROM imoveis WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Imóvel excluído com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir imóvel do banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }
}
