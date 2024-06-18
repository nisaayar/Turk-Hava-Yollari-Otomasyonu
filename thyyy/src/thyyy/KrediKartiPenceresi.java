package thyyy;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KrediKartiPenceresi extends JFrame implements ActionListener {
    private JTextField kartNoTextField;
    private JPasswordField cvvField;
    private JComboBox<String> ayComboBox, yilComboBox;
    private JButton odemeButton;

    public KrediKartiPenceresi() {
        setTitle("Kredi Kartı Bilgileri");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1550, 820);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        
        ImageIcon ill = new ImageIcon(ClassLoader.getSystemResource("icon/ödeme.png"));
        Image img = ill.getImage();
        Image scaledImg = img.getScaledInstance(618, 208, Image.SCALE_SMOOTH); 
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel labell = new JLabel(scaledIcon);
        labell.setBounds(850, 50, 618, 208); 
        add(labell);
       
        ImageIcon il1 = new ImageIcon(ClassLoader.getSystemResource("icon/k.jpeg"));
        Image i21 = il1.getImage().getScaledInstance(1550, 800, Image.SCALE_DEFAULT);
        ImageIcon i31 = new ImageIcon(i21);
        JLabel label1 = new JLabel(i31);
        label1.setBounds(100,200,850,450);
        add(label1);
        
        JPanel overlayPanel = new JPanel();
        overlayPanel.setLayout(null);
        overlayPanel.setOpaque(false);
        overlayPanel.setBounds(400, 0, 620, 779);
        
        JLabel kartNoLabel = new JLabel("Kart Numarası:");
        kartNoLabel.setFont(new Font("Raleway", Font.BOLD, 16)); 
        kartNoLabel.setForeground(Color.GRAY); 
        kartNoLabel.setBounds(120, 145, 150, 40); 
        label1.add(kartNoLabel);

        kartNoTextField = new JTextField();
        kartNoTextField.setBounds(280, 150, 220, 30);
        kartNoTextField.setFont(new Font("Arial", Font.BOLD, 14));
        label1.add(kartNoTextField);

        JLabel cvvLabel = new JLabel("CVV:");
        cvvLabel.setFont(new Font("Raleway", Font.BOLD, 16)); 
        cvvLabel.setForeground(Color.GRAY); 
        cvvLabel.setBounds(120, 195, 150, 40); 
        label1.add(cvvLabel);

        cvvField = new JPasswordField();
        cvvField.setBounds(280, 200, 220, 30);
        cvvField.setFont(new Font("Arial", Font.BOLD, 14));
        label1.add(cvvField);

        JLabel ayLabel = new JLabel("Son Kullanma Ayı:");
        ayLabel.setFont(new Font("Raleway", Font.BOLD, 16)); 
        ayLabel.setForeground(Color.GRAY); 
        ayLabel.setBounds(100, 245, 150, 40); 
        label1.add(ayLabel);

        String[] aylar = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        ayComboBox = new JComboBox<>(aylar);
        ayComboBox.setBounds(280, 250, 100, 30);
        ayComboBox.setFont(new Font("Arial", Font.BOLD, 14));
        label1.add(ayComboBox);

        JLabel yilLabel = new JLabel("Son Kullanma Yılı:");
        yilLabel.setFont(new Font("Raleway", Font.BOLD, 16)); 
        yilLabel.setForeground(Color.GRAY); 
        yilLabel.setBounds(370, 245, 150, 40);
        label1.add(yilLabel);

        String[] yillar = {"2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033"};
        yilComboBox = new JComboBox<>(yillar);
        yilComboBox.setBounds(520, 250, 100, 30);
        yilComboBox.setFont(new Font("Arial", Font.BOLD, 14));
        label1.add(yilComboBox);

        odemeButton = new JButton("Ödeme Yap");
        odemeButton.addActionListener(this);
        odemeButton.setBounds(280, 300, 150, 40); 
        odemeButton.setFont(new Font("Arial", Font.BOLD, 14));
        label1.add(odemeButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == odemeButton) {
            String kartNo = kartNoTextField.getText();
            String cvv = new String(cvvField.getPassword());
            String ay = (String) ayComboBox.getSelectedItem();
            String yil = (String) yilComboBox.getSelectedItem();

            // Validate fields
            if (kartNo.isEmpty() || cvv.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Kart numarası ve CVV alanları boş bırakılamaz!", "Hata", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Database connection and insertion
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thy", "root", "nisa2002")) {
                String sql = "INSERT INTO KrediKartiBilgileri (kart_numarasi, cvv, son_kullanma_ayi, son_kullanma_yili) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, kartNo);
                pstmt.setString(2, cvv);
                pstmt.setString(3, ay);
                pstmt.setString(4, yil);
                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(this, "Ödeme işlemi başarıyla tamamlandı!");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Ödeme işlemi sırasında bir hata oluştu.", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new KrediKartiPenceresi();
    }
}
