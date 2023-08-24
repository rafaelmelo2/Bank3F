/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dados;


import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import javax.swing.Icon;
import objetos.Investimentos;
import objetos.Usuario;


/**
 *
 * @author Fael
 */
public class BdBanco {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultset = null;
    
    public void conectar(){
        
        
        
        //BANCO DE DADOS LOCAL
        String servidor = "jdbc:mysql://localhost:3306/banco";
        String usuario = "root";
        String senha = "";
        
        
        try{
            this.connection = DriverManager.getConnection(servidor, usuario, senha);
            this.statement = this.connection.createStatement();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de dados( função CONECTAR ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro( função CONECTAR ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean estaConectado(){
        if(this.connection != null){
            return true;
        }else{
            return false;
        }
    }
    
    public void inserirUsuarioDB(String cpf, String senha, String nome, String sobrenome, String email, String nascimento, String sexo, String celular, String rua, String bairro, int numero, String cidade, String estado, String cep, String foto, String recuperacao, String conta, String agencia){
        try{
            
            String novaFoto = foto.replace("\\", "/");
            
            if(foto.isEmpty() || foto == null || foto == ""){
                String query = "INSERT INTO usuarios (cpf, senha, nome, sobrenome, email,nascimento, sexo, celular ,rua, bairro, numero, cidade, estado, cep, recuperacao, conta, agencia) VALUES ('" + cpf + "', '" + senha + "', '" + nome + "', '" + sobrenome + "', '" + email + "','" + nascimento + "','" + sexo + "','" + celular + "','" + rua + "', '" + bairro + "', '" + numero + "', '" + cidade + "', '" + estado + "','" + cep + "','" + recuperacao + "', '" + conta + "', '" + agencia + "')";
                this.statement.executeUpdate(query);
                
                inserirInvestimento(cpf);
                
            }else{
                String query = "INSERT INTO usuarios (cpf, senha, nome, sobrenome, email,nascimento, sexo, celular ,rua, bairro, numero, cidade, estado, cep, foto, recuperacao, conta, agencia) VALUES ('" + cpf + "', '" + senha + "', '" + nome + "', '" + sobrenome + "', '" + email + "','" + nascimento + "','" + sexo + "','" + celular + "','" + rua + "', '" + bairro + "', '" + numero + "', '" + cidade + "', '" + estado + "','" + cep + "', '" + novaFoto + "', '" + recuperacao + "', '" + conta + "', '" + agencia + "')";
                this.statement.executeUpdate(query);
                
                inserirInvestimento(cpf);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de dados( função inserirUsuarioDB ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro( função inserirUsuarioDB ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void editarUsuarioDB(String cpf, String dadoASerEditado, String novoValor) {
        try {
            if(dadoASerEditado == "foto"){
                String replace1 = novoValor.replace("\\", "/");
                String replace2 = replace1.replace("\"", "");
                String query = "UPDATE usuarios SET " + dadoASerEditado + " = ? WHERE cpf = ?";
                PreparedStatement preparedStatement = this.connection.prepareStatement(query);
                preparedStatement.setString(1, replace2);
                preparedStatement.setString(2, cpf);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }else{
                String query = "UPDATE usuarios SET " + dadoASerEditado + " = ? WHERE cpf = ?";
                PreparedStatement preparedStatement = this.connection.prepareStatement(query);
                preparedStatement.setString(1, novoValor);
                preparedStatement.setString(2, cpf);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de dados (função editarUsuarioDB):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro (função editarUsuarioDB):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void editarSenhaDB(String cpf, String senha){
        try{
            String query = "UPDATE usuarios SET senha = '" + senha + "' WHERE cpf = '"+cpf+"';";
            this.statement.executeUpdate(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de dados( função editarSenhaDB ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro( função editarSenhaDB ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    public void setSaldo(String cpf, double novoSaldo) {
        try {
            String updateQuery = "UPDATE usuarios SET saldo = ? WHERE cpf = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setDouble(1, novoSaldo);
            preparedStatement.setString(2, cpf);
            int linhasAfetadas = preparedStatement.executeUpdate();

            if (linhasAfetadas == 0) {
                JOptionPane.showMessageDialog(null, "CPF NÃO ENCONTRADO", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Saldo atualizado com sucesso para o CPF: " + cpf);
            }

            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de dados (função setSaldo):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro (função setSaldo):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    
    public boolean transferir(String conta, String contaDestinatario, Double valor) {
        double saldoCpf = 0.0;
        double saldoCpfDestinatario = 0.0;
        double novoSaldoCpf = 0.0;
        double novoSaldoCpfDestinatario = 0.0;

        try {
            String query1 = "SELECT saldo FROM usuarios WHERE conta = ?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
            preparedStatement1.setString(1, conta);
            ResultSet resultSet1 = preparedStatement1.executeQuery();

            if (resultSet1.next()) {
                saldoCpf = resultSet1.getDouble("saldo");
            } else {
                JOptionPane.showMessageDialog(null, "CONTA NÃO ENCONTRADA", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            preparedStatement1.close();

            String query2 = "SELECT saldo FROM usuarios WHERE conta = ?";
            PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
            preparedStatement2.setString(1, contaDestinatario);
            ResultSet resultSet2 = preparedStatement2.executeQuery();

            if (resultSet2.next()) {
                saldoCpfDestinatario = resultSet2.getDouble("saldo");
            } else {
                JOptionPane.showMessageDialog(null, "CONTA DESTINATÁRIA NÃO ENCONTRADA", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            preparedStatement2.close();

            if (valor > saldoCpf) {
                Icon icon = new javax.swing.ImageIcon(getClass().getResource("/img/sem-saldo.png")); 
                JOptionPane.showMessageDialog(null, "Seu saldo é insuficiente para a transferëncia", "SALDO INSUFICIENTE", JOptionPane.INFORMATION_MESSAGE, icon);
                return false;
            } else {
                novoSaldoCpf = saldoCpf - valor;

                String query3 = "UPDATE usuarios SET saldo = ? WHERE conta = ?";
                PreparedStatement preparedStatement3 = connection.prepareStatement(query3);
                preparedStatement3.setDouble(1, novoSaldoCpf);
                preparedStatement3.setString(2, conta);
                int rowsUpdated1 = preparedStatement3.executeUpdate();
                preparedStatement3.close();

                if (rowsUpdated1 > 0) {
                    System.out.println("Saldo atualizado com sucesso para a CONTA: " + conta);
                } else {
                    System.out.println("Nenhum registro atualizado para a CONTA: " + contaDestinatario);
                }

                novoSaldoCpfDestinatario = saldoCpfDestinatario + valor;

                String query4 = "UPDATE usuarios SET saldo = ? WHERE conta = ?";
                PreparedStatement preparedStatement4 = connection.prepareStatement(query4);
                preparedStatement4.setDouble(1, novoSaldoCpfDestinatario);
                preparedStatement4.setString(2, contaDestinatario);
                int rowsUpdated2 = preparedStatement4.executeUpdate();
                preparedStatement4.close();

                if (rowsUpdated2 > 0) {
                    System.out.println("Saldo atualizado com sucesso para a CONTA: " + contaDestinatario);
                } else {
                    System.out.println("Nenhum registro atualizado para a CONTA: " + contaDestinatario);
                }
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de dados (função transferir):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro (função transferir):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    
    
    
    
    public void apagarUsuarioDB(String cpf){
        try{
            String query = "DELETE FROM usuarios WHERE cpf = "+ cpf + ";";
            this.statement.executeUpdate(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de dados( função apagarUsuarioDB ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro( função apagarUsuarioDB ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void desconectar(){
        try{
            this.connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de dados( função desconectar ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro( função desconectar ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    public Usuario carregaDadosDB(String cpf_logado) {
        try {
            String query = "SELECT * FROM usuarios WHERE cpf = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cpf_logado);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));                  //0
                String cpf = resultSet.getString("cpf");                //1
                String senha = resultSet.getString("senha");            //2
                String nome = resultSet.getString("nome");              //3
                String sobrenome = resultSet.getString("sobrenome");    //4
                String email = resultSet.getString("email");
                String nascimento = resultSet.getString("nascimento");  //5
                String sexo = resultSet.getString("sexo");              //6
                String celular = resultSet.getString("celular");        //7
                String rua = resultSet.getString("rua");                //8
                String bairro = resultSet.getString("bairro");          //9
                int numero = Integer.parseInt(resultSet.getString("numero"));          //10
                String cidade = resultSet.getString("cidade");          //11
                String estado = resultSet.getString("estado");          //12
                String cep = resultSet.getString("cep");                //13
                double saldo = Double.parseDouble(resultSet.getString("saldo"));            //14
                String foto = resultSet.getString("foto");              //15
                String cargo = resultSet.getString("cargo");            //16
                String recuperacao = resultSet.getString("recuperacao");//17
                String conta = resultSet.getString("conta");            //18
                String agencia = resultSet.getString("agencia");        //19

                Usuario usuarioData = new Usuario(id, cpf, senha, nome, sobrenome, email, nascimento, sexo, celular, rua, bairro, numero, cidade, estado, cep, saldo, foto, cargo, recuperacao, conta, agencia);
                //Object[] usuarioData = new Object[]{id, cpf, senha, nome, sobrenome, nascimento, sexo, celular, rua, bairro, numero, cidade, estado, cep, saldo, foto, cargo, recuperacao, conta, agencia};
                return usuarioData;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de dados( função atualizarTabela ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro( função atualizarTabela ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public boolean verificaUsuario(String cpf, String senha){
        try {
            String query = "SELECT * FROM usuarios WHERE cpf = ? AND senha = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cpf);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            
            return resultSet.next();       
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de dados( função verificaUsuario ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro( função verificaUsuario ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    
    public boolean verificaEsqueceuSenha(String cpf, String recuperacao){
        try {
            String query = "SELECT * FROM usuarios WHERE cpf = ? AND recuperacao = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cpf);
            preparedStatement.setString(2, recuperacao);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            
            return resultSet.next();       
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de dados( função verificaEsqueceuSenha ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro( função verificaEsqueceuSenha ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public boolean verificaCpfRepetido(String cpf) {
        try {
            String query = "SELECT COUNT(*) FROM usuarios WHERE cpf = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cpf);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // Retorna true se o CPF já estiver cadastrado no banco de dados
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de dados (função verificaCpfRepetido):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro (função verificaCpfRepetido):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    
    public boolean verificaRecuperacaoRepetido(String recuperacao) {
        try {
            String query = "SELECT COUNT(*) FROM usuarios WHERE recuperacao = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, recuperacao);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // Retorna true se o CPF já estiver cadastrado no banco de dados
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de dados (função verificaRecuperacaoRepetido):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro (função verificaRecuperacaoRepetido):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    
    public boolean verificaContaRepetido(String conta) {
        try {
            String query = "SELECT COUNT(*) FROM usuarios WHERE conta = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, conta);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // Retorna true se o CPF já estiver cadastrado no banco de dados
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de dados (função verificaContaRepetido):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro (função verificaContaRepetido):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    
    public void atualizarTabelaTransacoes(String cpf, JTable tabela){
        try {
            String query = "SELECT * FROM transacoes WHERE cpf = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cpf);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            model.setRowCount(0); // Limpa a tabela antes de adicionar os novos dados
            

            while (resultSet.next()) {
                int idTransacao = Integer.parseInt(resultSet.getString("id"));                  //1
                String cpfTransacao = resultSet.getString("cpf");                //2
                String descricaoTransacao = resultSet.getString("descricao");
                Double valorTransacao = Double.parseDouble(resultSet.getString("valor"));
                Double saldoTransacao = Double.parseDouble(resultSet.getString("saldo"));
                String dataTransacao = resultSet.getString("dataTransacao");

                
                model.addRow(new Object[]{idTransacao, cpfTransacao, descricaoTransacao, valorTransacao, saldoTransacao, dataTransacao});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de dados( função atualizarTabelaTransacoes ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro( função atualizarTabelaTransacoes ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void inserirTransacao(String cpf, String descricao, Double valor, Double saldo){
        try{
            LocalDateTime horaExata = LocalDateTime.now();
            String query = "INSERT INTO transacoes (cpf, descricao, valor, saldo, dataTransacao) VALUES ('" + cpf + "', '" + descricao + "','" + valor + "','" + saldo + "', '" + horaExata + "')";
            this.statement.executeUpdate(query);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de dados( função inserirTransacao ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro( função inserirTransacao ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    

    
    
    public String getDado(String cpf, String dado) {
        try {
            String query = "SELECT " + dado + " FROM usuarios WHERE cpf = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cpf);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString(dado);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de dados (função getDado):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro (função getDado):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return null; // Caso não encontre nenhum dado para o CPF
    }
    
    
    public Investimentos getInvestimentos(String cpf){
        try {
            String query = "SELECT * FROM investimentos WHERE cpf = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cpf);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));                  
                String cpf2 = resultSet.getString("cpf");
                Double bitcoin = Double.parseDouble(resultSet.getString("bitcoin"));
                Double valorbitcoinComprado = Double.parseDouble(resultSet.getString("valorbitcoinComprado"));
                Double ethereum = Double.parseDouble(resultSet.getString("ethereum"));
                Double valorethereumComprado = Double.parseDouble(resultSet.getString("valorethereumComprado"));
                Double dolar = Double.parseDouble(resultSet.getString("dolar"));
                Double valordolarComprado = Double.parseDouble(resultSet.getString("valordolarComprado"));
                
                
                
                Investimentos usuarioInvestimentos = new Investimentos(id, cpf2, bitcoin, valorbitcoinComprado, ethereum, valorethereumComprado, dolar, valordolarComprado);
                return usuarioInvestimentos;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de dados( função getInvestimentos ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro( função getInvestimentos ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public void inserirInvestimento(String cpf){
        try{
            
            String query = "INSERT INTO investimentos (cpf) VALUES ('" + cpf + "')";
            
            int linhasAfetadas = statement.executeUpdate(query);
            if (linhasAfetadas > 0) {
                System.out.println("Atualização bem-sucedida.");
            } else {
                System.out.println("Nenhuma linha foi atualizada.");
            } 

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de dados( função inserirTransacao(cpf) ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro( função inserirTransacao(cpf) ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean inserirInvestimento(String cpf, String investimento, Double valor, Double valorComprado){
        try {
            String query = "UPDATE investimentos SET "+investimento+" = "+valor+", valor"+investimento+"Comprado = "+valorComprado+" WHERE cpf = "+cpf+"";
            int linhasAfetadas = statement.executeUpdate(query);

            if (linhasAfetadas > 0) {
                System.out.println("Atualização bem-sucedida.");
            } else {
                System.out.println("Nenhuma linha foi atualizada.");
            }  
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de dados( função inserirInvestimento ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro( função inserirInvestimento ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public Usuario carregaDadosDestinatarioDB(String conta2) {
        try {
            String query = "SELECT * FROM usuarios WHERE conta = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, conta2);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));                  //0
                String cpf = resultSet.getString("cpf");                //1
                String senha = resultSet.getString("senha");            //2
                String nome = resultSet.getString("nome");              //3
                String sobrenome = resultSet.getString("sobrenome");    //4
                String email = resultSet.getString("email");
                String nascimento = resultSet.getString("nascimento");  //5
                String sexo = resultSet.getString("sexo");              //6
                String celular = resultSet.getString("celular");        //7
                String rua = resultSet.getString("rua");                //8
                String bairro = resultSet.getString("bairro");          //9
                int numero = Integer.parseInt(resultSet.getString("numero"));          //10
                String cidade = resultSet.getString("cidade");          //11
                String estado = resultSet.getString("estado");          //12
                String cep = resultSet.getString("cep");                //13
                double saldo = Double.parseDouble(resultSet.getString("saldo"));            //14
                String foto = resultSet.getString("foto");              //15
                String cargo = resultSet.getString("cargo");            //16
                String recuperacao = resultSet.getString("recuperacao");//17
                String conta = resultSet.getString("conta");            //18
                String agencia = resultSet.getString("agencia");        //19

                Usuario usuarioData = new Usuario(id, cpf, senha, nome, sobrenome, email, nascimento, sexo, celular, rua, bairro, numero, cidade, estado, cep, saldo, foto, cargo, recuperacao, conta, agencia);
                //Object[] usuarioData = new Object[]{id, cpf, senha, nome, sobrenome, nascimento, sexo, celular, rua, bairro, numero, cidade, estado, cep, saldo, foto, cargo, recuperacao, conta, agencia};
                return usuarioData;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no banco de dados( função carregaDadosDestinatarioDB ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro( função carregaDadosDestinatarioDB ):\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    
}
