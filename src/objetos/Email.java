package objetos;

import java.io.File;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JTable;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Fael
 */
public class Email {
    public boolean enviaEmailSemAnexo(String destinatario, String assunto, String texto) {
        String from = "3f.bank1@gmail.com";
        String password = "yishuykvunrmmzyv";
        String to = destinatario;

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            // Criar a mensagem de e-mail
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(assunto);

            // Criar o corpo do e-mail e anexos
            Multipart multipart = new MimeMultipart();

            // Texto do e-mail
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(texto);
            multipart.addBodyPart(messageBodyPart);


            // Definir o conteúdo do e-mail como o corpo multipart
            message.setContent(multipart);

            // Enviar o e-mail
            Transport.send(message);
            
            System.out.println("E-mail com anexo enviado com sucesso!");
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Erro ao enviar o e-mail: " + e.getMessage());
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    public boolean enviaEmailComAnexo(String destinatario, String assunto, String texto) {
        String from = "3f.bank1@gmail.com";
        String password = "yishuykvunrmmzyv";
        String to = destinatario;

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            // Criar a mensagem de e-mail
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(assunto);

            // Criar o corpo do e-mail e anexos
            Multipart multipart = new MimeMultipart();

            // Texto do e-mail
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(texto);
            multipart.addBodyPart(messageBodyPart);

            // Anexo
            MimeBodyPart attachmentPart = new MimeBodyPart();
            String filePath = "src/arquivos/transacoes.xls"; // Substitua pelo caminho do seu arquivo
            attachmentPart.attachFile(filePath);
            multipart.addBodyPart(attachmentPart);

            // Definir o conteúdo do e-mail como o corpo multipart
            message.setContent(multipart);

            // Enviar o e-mail
            Transport.send(message);
            
            System.out.println("E-mail com anexo enviado com sucesso!");
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Erro ao enviar o e-mail: " + e.getMessage());
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    
    public static void criaExcelAPartirDaTabela(JTable table) {
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(new File("src/arquivos/transacoes.xls"));
            WritableSheet sheet = workbook.createSheet("Transacoes", 0);

            // Cabeçalho
            for (int col = 0; col < table.getColumnCount(); col++) {
                jxl.write.Label label = new jxl.write.Label(col, 0, table.getColumnName(col));
                sheet.addCell(label);
            }

            // Dados
            for (int row = 0; row < table.getRowCount(); row++) {
                for (int col = 0; col < table.getColumnCount(); col++) {
                    jxl.write.Label label = new jxl.write.Label(col, row + 1, table.getValueAt(row, col).toString());
                    sheet.addCell(label);
                }
            }

            workbook.write();
            workbook.close();

            System.out.println("Arquivo Excel gerado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao gerar o arquivo Excel: " + e.getMessage());
        }
    
    }
}
