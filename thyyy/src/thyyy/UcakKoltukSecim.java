package thyyy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UcakKoltukSecim extends JFrame implements ActionListener {
    private JButton[][] seats;
    private JLabel selectedSeatLabel;
    private String selectedSeat;

    private JTextField adTextField, soyadTextField, tarihTextField, kimlikTextField, postaTextField, telefonTextField;
    private JRadioButton bay, bayan, vatandass;
    private ButtonGroup gendergroup;
    private JButton devam;

    public UcakKoltukSecim() {
        setTitle("Uçak Koltuk Seçimi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1550, 820);
        setLayout(new BorderLayout());

        ImageIcon ill = new ImageIcon(ClassLoader.getSystemResource("icon/ucakk.jpeg"));
        Image i22 = ill.getImage().getScaledInstance(420, 779, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel labell = new JLabel(i33);
        labell.setBounds(860, 0, 620, 779);
        
        ImageIcon il1 = new ImageIcon(ClassLoader.getSystemResource("icon/k.jpeg"));
        Image i21 = il1.getImage().getScaledInstance(1550, 800, Image.SCALE_DEFAULT);
        ImageIcon i31 = new ImageIcon(i21);
        JLabel label1 = new JLabel(i31);
        label1.setBounds(100, 200, 850, 450);
        add(label1);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icon/kullanıcı.jpeg"));
        Image i2 = il.getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(-20, 10, 120, 200);
        label1.add(label);
        
        JLabel text = new JLabel("Yolcu bilgileri");
        text.setFont(new Font("Osward", Font.BOLD, 20));
        text.setBounds(65, 90, 400, 40);
        text.setForeground(Color.black);
        label1.add(text);
        
        bay = new JRadioButton("Bay");
        bay.setBounds(50, 150, 90, 40);
        bay.setForeground(Color.GRAY);
        bay.setBackground(Color.WHITE);
        bay.setVerticalAlignment(SwingConstants.TOP);
        label1.add(bay);
        
        bayan = new JRadioButton("Bayan");
        bayan.setBounds(150, 150, 90, 40);
        bayan.setForeground(Color.GRAY);
        bayan.setBackground(Color.WHITE);
        bayan.setVerticalAlignment(SwingConstants.TOP);
        label1.add(bayan);
        
        gendergroup = new ButtonGroup();
        gendergroup.add(bay);
        gendergroup.add(bayan);
        
        JLabel ad = new JLabel("Adı");
        ad.setFont(new Font("Raleway", Font.BOLD, 16));
        ad.setForeground(Color.GRAY);
        ad.setBounds(245, 145, 150, 40);
        label1.add(ad);
        adTextField = new JTextField();
        adTextField.setBounds(280, 150, 220, 30);
        adTextField.setFont(new Font("Arial", Font.BOLD, 14));
        label1.add(adTextField);
        
        JLabel soyad = new JLabel("Soyadı");
        soyad.setFont(new Font("Raleway", Font.BOLD, 16));
        soyad.setForeground(Color.GRAY);
        soyad.setBounds(520, 145, 150, 40);
        label1.add(soyad);
        soyadTextField = new JTextField();
        soyadTextField.setBounds(580, 150, 220, 30);
        soyadTextField.setFont(new Font("Arial", Font.BOLD, 14));
        label1.add(soyadTextField);
        
        JLabel tarih = new JLabel("Doğum tarihi");
        tarih.setFont(new Font("Raleway", Font.BOLD, 16));
        tarih.setForeground(Color.GRAY);
        tarih.setBounds(35, 200, 150, 40);
        label1.add(tarih);
        tarihTextField = new JTextField();
        tarihTextField.setBounds(140, 205, 220, 30);
        tarihTextField.setFont(new Font("Arial", Font.BOLD, 14));
        label1.add(tarihTextField);
        
        vatandass = new JRadioButton("Türk vatandaşı");
        vatandass.setBounds(380, 205, 120, 40);
        vatandass.setForeground(Color.BLACK);
        vatandass.setBackground(Color.WHITE);
        vatandass.setVerticalAlignment(SwingConstants.TOP);
        label1.add(vatandass);
        
        JLabel kimlik = new JLabel("TC Kimlik");
        kimlik.setFont(new Font("Raleway", Font.BOLD, 16));
        kimlik.setForeground(Color.GRAY);
        kimlik.setBounds(520, 200, 150, 40);
        label1.add(kimlik);
        kimlikTextField = new JTextField();
        kimlikTextField.setBounds(600, 205, 200, 30);
        kimlikTextField.setFont(new Font("Arial", Font.BOLD, 14));
        label1.add(kimlikTextField);
        
        ImageIcon illll = new ImageIcon(ClassLoader.getSystemResource("icon/t.jpeg"));
        Image i2222 = illll.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon i3333 = new ImageIcon(i2222);
        JLabel labellll = new JLabel(i3333);
        labellll.setBounds(-20, 170, 120, 200);
        label1.add(labellll);
        
        JLabel iletişim = new JLabel("İletişim bilgileri");
        iletişim.setFont(new Font("Osward", Font.BOLD, 20));
        iletişim.setBounds(75, 250, 400, 40);
        iletişim.setForeground(Color.black);
        label1.add(iletişim);
        
        JLabel posta = new JLabel("E-posta");
        posta.setFont(new Font("Raleway", Font.BOLD, 16));
        posta.setForeground(Color.GRAY);
        posta.setBounds(35, 300, 150, 40);
        label1.add(posta);
        postaTextField = new JTextField();
        postaTextField.setBounds(100, 305, 220, 30);
        postaTextField.setFont(new Font("Arial", Font.BOLD, 14));
        label1.add(postaTextField);
        
        JLabel telefon = new JLabel("Telefon numarası");
        telefon.setFont(new Font("Raleway", Font.BOLD, 16));
        telefon.setForeground(Color.GRAY);
        telefon.setBounds(340, 300, 200, 40);
        label1.add(telefon);
        telefonTextField = new JTextField();
        telefonTextField.setBounds(485, 305, 220, 30);
        telefonTextField.setFont(new Font("Arial", Font.BOLD, 14));
        label1.add(telefonTextField);
        
        devam = new JButton("Devam");
        devam.setBounds(805, 680, 100, 80);
        devam.setBackground(new Color(238, 44, 44));
        devam.setForeground(Color.RED);
        devam.addActionListener(this);
        add(devam);
        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(320, 779));
        layeredPane.add(labell, JLayeredPane.DEFAULT_LAYER);
        
        JPanel seatPanel = new JPanel(new GridBagLayout());
        seatPanel.setOpaque(false); // Make the panel transparent
        seats = new JButton[15][4];
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 4; j++) {
                seats[i][j] = new JButton((i + 1) + "-" + (char) ('A' + j));
                seats[i][j].setBackground(Color.white);
                seats[i][j].addActionListener(this);
                gbc.gridx = j;
                gbc.gridy = i;
                gbc.ipadx = 5; // Set button size
                gbc.ipady = -3;
                
                // Set insets to create spacing between the columns
                if (j == 0) { // Column A
                    gbc.insets = new Insets(15, 5, 5, 2);
                } else if (j == 1) { // Column B
                    gbc.insets = new Insets(15, 2, 5, 30);
                } else if (j == 2) { // Column C
                    gbc.insets = new Insets(15, 30, 5, 2);
                } else if (j == 3) { // Column D
                    gbc.insets = new Insets(15, 2, 5, 5);
                }
                
                seatPanel.add(seats[i][j], gbc);
            }
        }
        
        // Ayarlanan yüksekliği artırarak koltukları aşağı indiriyoruz
        seatPanel.setBounds(886, 50, 610, 779);
        layeredPane.add(seatPanel, JLayeredPane.PALETTE_LAYER);
        
        JPanel controlPanel = new JPanel(new FlowLayout());
        selectedSeatLabel = new JLabel("Seçili Koltuk: -");
        controlPanel.add(selectedSeatLabel);
        
        add(layeredPane, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == devam) {
            savePassengerInfo();
            return;
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 4; j++) {
                if (e.getSource() == seats[i][j]) {
                    selectedSeat = (i + 1) + "-" + (char) ('A' + j);
                    selectedSeatLabel.setText("Seçili Koltuk: " + selectedSeat);
                    seats[i][j].setBackground(Color.red);
                    JOptionPane.showMessageDialog(this, "Koltuk seçildi: " + selectedSeat);
                    return;
                }
            }
        }
    }
    
    private void savePassengerInfo() {
        String ad = adTextField.getText();
        String soyad = soyadTextField.getText();
        String dogumTarihi = tarihTextField.getText();
        String tcKimlik = kimlikTextField.getText();
        String eposta = postaTextField.getText();
        String telefon = telefonTextField.getText();

        if (ad.isEmpty() || soyad.isEmpty() || dogumTarihi.isEmpty() || tcKimlik.isEmpty() || eposta.isEmpty() || telefon.isEmpty() || selectedSeat == null) {
            JOptionPane.showMessageDialog(this, "Lütfen tüm alanları doldurun ve bir koltuk seçin.", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String cinsiyet = bay.isSelected() ? "Bay" : "Bayan";
        String vatandas = vatandass.isSelected() ? "Türk vatandaşı" : "Yabancı";
        
        // Veritabanı bağlantısı ve veri kaydetme işlemi
        String url = "jdbc:mysql://localhost:3306/thy";
        String username = "root";
        String password = "nisa2002";
        
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO yolcular (ad, soyad, dogum_tarihi, tc_kimlik, eposta, telefon, cinsiyet, vatandas, koltuk) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, ad);
            pstmt.setString(2, soyad);
            pstmt.setString(3, dogumTarihi);
            pstmt.setString(4, tcKimlik);
            pstmt.setString(5, eposta);
            pstmt.setString(6, telefon);
            pstmt.setString(7, cinsiyet);
            pstmt.setString(8, vatandas);
            pstmt.setString(9, selectedSeat);
            
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Bilgiler kaydedildi.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Veritabanına kaydedilirken bir hata oluştu.");
        }
    }
    
    public static void main(String[] args) {
        new UcakKoltukSecim();
    }
}

