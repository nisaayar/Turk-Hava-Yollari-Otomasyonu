package thyyy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.toedter.calendar.JDateChooser;

public class Login extends JFrame implements ActionListener {
	 private String fromProvince;
	    private String toProvince;
    JButton ucuss;
    JButton tarihButton;
    JFrame takvimFrame;
    JComboBox<String> neredenn, nereyee, yolcuu;
    
    public void setFromProvince(String fromProvince) {
        this.fromProvince = fromProvince;
    }
    
    public void setToProvince(String toProvince) {
        this.toProvince = toProvince;
    }

    public String getFromProvince() {
        return fromProvince;
    }

    public String getToProvince() {
        return toProvince;
    }
    
    

    public Login() {
        setTitle("TURKISH AIRLINES");
        setLayout(null);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icon/a.png"));
        Image i2 = il.getImage().getScaledInstance(1550, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(-8, 3, 1550, 200);
        add(label);

        ImageIcon ill = new ImageIcon(ClassLoader.getSystemResource("icon/dag.png"));
        Image i22 = ill.getImage().getScaledInstance(1550, 800, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel labell = new JLabel(i33);
        labell.setBounds(-8, 200, 1550, 450);
        add(labell);

        JLabel text = new JLabel("MERHABA,");
        text.setFont(new Font("Osward", Font.BOLD, 30));
        text.setBounds(280, 30, 400, 40);
        text.setForeground(Color.WHITE);
        labell.add(text);

        JLabel textt = new JLabel("Nereyi keşfetmek istersiniz?");
        textt.setFont(new Font("Osward", Font.BOLD, 36));
        textt.setBounds(280, 60, 800, 50);
        textt.setForeground(Color.WHITE);
        labell.add(textt);

        JButton plan = new JButton("PLANLA&UÇ");
        plan.setBounds(400, 90, 150, 30);
        plan.setBackground(Color.RED);
        plan.setForeground(Color.BLACK);
        label.add(plan);

        JButton seyahat = new JButton("SEYAHAT DENEYİMİ");
        seyahat.setBounds(600, 90, 150, 30);
        seyahat.setBackground(Color.WHITE);
        seyahat.setForeground(Color.BLACK);
        label.add(seyahat);

        JButton kesfet = new JButton("KEŞFET");
        kesfet.setBounds(750, 90, 150, 30);
        kesfet.setBackground(Color.BLACK);
        kesfet.setForeground(Color.BLACK);
        label.add(kesfet);

        JButton miles = new JButton("MILES&SMILES");
        miles.setBounds(900, 90, 150, 30);
        miles.setBackground(Color.BLACK);
        miles.setForeground(Color.BLACK);
        label.add(miles);

        JButton yardım = new JButton("YARDIM");
        yardım.setBounds(1013, 90, 150, 30);
        yardım.setBackground(Color.BLACK);
        yardım.setForeground(Color.BLACK);
        label.add(yardım);

        JButton üye = new JButton("Üye ol");
        üye.setBounds(1190, 90, 150, 30);
        üye.setBackground(Color.BLACK);
        üye.setForeground(Color.BLACK);
        label.add(üye);

        JButton giris = new JButton("GİRİŞ YAP");
        giris.setBounds(1300, 90, 150, 30);
        giris.setBackground(Color.BLACK);
        giris.setForeground(Color.BLACK);
        giris.addActionListener(e -> new GirisPenceresi());
        label.add(giris);

        JButton uçak = new JButton("Uçak bileti");
        uçak.setBounds(280, 150, 150, 30);
        uçak.setBackground(Color.WHITE);
        uçak.setForeground(Color.red);
        labell.add(uçak);

        JRadioButton gidiş = new JRadioButton("Gidiş-Dönüş");
        gidiş.setBounds(280, 180, 120, 40);
        gidiş.setBackground(Color.WHITE);
        gidiş.setVerticalAlignment(SwingConstants.TOP);
        labell.add(gidiş);

        JButton nereden = new JButton("Nereden");
        nereden.setBounds(280, 220, 240, 30);
        nereden.setBackground(Color.WHITE);
        nereden.setForeground(Color.GRAY);
        labell.add(nereden);

        neredenn = new JComboBox<>();
        neredenn.setBounds(280, 250, 240, 50);
        neredenn.setBackground(Color.WHITE);
        labell.add(neredenn);

        JButton nereye = new JButton("Nereye");
        nereye.setBounds(530, 220, 240, 30);
        nereye.setBackground(Color.WHITE);
        nereye.setForeground(Color.GRAY);
        labell.add(nereye);

        nereyee = new JComboBox<>();
        nereyee.setBounds(530, 250, 240, 50);
        nereyee.setBackground(Color.WHITE);
        labell.add(nereyee);

        JButton tarih = new JButton("Tarih");
        tarih.setBounds(780, 220, 110, 30);
        tarih.setBackground(Color.WHITE);
        tarih.setForeground(Color.GRAY);
        labell.add(tarih);

        JButton yolcu = new JButton("Yolcular");
        yolcu.setBounds(900, 220, 120, 30);
        yolcu.setBackground(Color.WHITE);
        yolcu.setForeground(Color.GRAY);
        labell.add(yolcu);
        
        String valYolcu[]= {"...","Yetişkin(12+)","Çocuk(2-11)","Bebek(2 yas altı)","Öğrenci(12-34)"};
		JComboBox yolcuu = new JComboBox(valYolcu);
		yolcuu.setBounds(900,240,120,50);
		yolcuu.setBackground(Color.WHITE);
		labell.add(yolcuu);

        yolcuu = new JComboBox<>();
        yolcuu.setBounds(900, 240, 120, 50);
        yolcuu.setBackground(Color.WHITE);
        labell.add(yolcuu);

        JRadioButton tek = new JRadioButton("Tek yön");
        tek.setBounds(400, 180, 120, 40);
        tek.setBackground(Color.WHITE);
        tek.setVerticalAlignment(SwingConstants.TOP);
        labell.add(tek);

        JRadioButton stopover = new JRadioButton("İstanbul'da Stopover");
        stopover.setBounds(520, 180, 160, 40);
        stopover.setBackground(Color.WHITE);
        stopover.setVerticalAlignment(SwingConstants.TOP);
        labell.add(stopover);

        JRadioButton uçuş = new JRadioButton("Çoklu uçuş");
        uçuş.setBounds(680, 180, 450, 40);
        uçuş.setBackground(Color.WHITE);
        uçuş.setVerticalAlignment(SwingConstants.TOP);
        labell.add(uçuş);
        
        JRadioButton yurtDışıRadioButton = new JRadioButton("Yurt Dışı");
        yurtDışıRadioButton.setBounds(800, 180, 100, 40);
        yurtDışıRadioButton.setBackground(Color.WHITE);
        yurtDışıRadioButton.setVerticalAlignment(SwingConstants.TOP);
        labell.add(yurtDışıRadioButton);
        
       
        

        JButton ucuss = new JButton("Uçuş ara");
        ucuss.setBounds(1030, 220, 100, 80);
        ucuss.setBackground(Color.RED);
        ucuss.setForeground(Color.BLACK);
        ucuss.addActionListener(e -> new UcusAraPenceresi());
        labell.add(ucuss);

        tarihButton = new JButton("Tarih");
        tarihButton.setBounds(780, 220, 110, 30);
        tarihButton.setBackground(Color.WHITE);
        tarihButton.setForeground(Color.GRAY);
        tarihButton.addActionListener(this);
        add(tarihButton);
        
        JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(780,250,110,50);
		labell.add(dateChooser);

        // Diğer bileşenlerin oluşturulması
        createComponents();

        setSize(1550, 820);
        setVisible(true);
        setLocation(5, 5);
        
        


        // Veritabanından şehir verilerini al ve JComboBox'lere ekle
        fetchCityData();
    }

    private void createComponents() {
        // İstenirse bu metodda JComboBox bileşenlerini oluşturabilirsiniz
        // Şu an zaten yukarıda oluşturuyoruz
    }

    private void fetchCityData() {
        try {
            // JDBC bağlantısı kurulması
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thy", "root", "nisa2002");

            // SQL sorgusu oluşturulması
            String sql = "SELECT city_name FROM cities";

            // SQL sorgusunun çalıştırılması
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Şehir verilerinin tutulacağı bir liste oluşturulması
            List<String> cities = new ArrayList<>();

            // ResultSet'ten verilerin çekilerek listeye eklenmesi
            while (resultSet.next()) {
                cities.add(resultSet.getString("city_name"));
            }

            // JComboBox bileşenlerine şehir verilerinin eklenmesi
            for (String city : cities) {
                neredenn.addItem(city);
                nereyee.addItem(city);
            }

            // Bağlantının kapatılması
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private class GirisPenceresi extends JDialog implements ActionListener {
        private JTextField kullaniciTxt;
        private JPasswordField sifreTxt;
        private JButton girisBtn;
        private JLabel hataMesaji;

        public GirisPenceresi() {
            setTitle("Giriş Yap");
            setLayout(new GridBagLayout());
            setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            setModalityType(ModalityType.APPLICATION_MODAL);

            GridBagConstraints constraints = new GridBagConstraints();

            JLabel kullaniciEtiketi = new JLabel("Üyelik Numarası:");
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.insets = new Insets(5, 5, 5, 5);
            add(kullaniciEtiketi, constraints);

            kullaniciTxt = new JTextField(15);
            constraints.gridx = 1;
            constraints.gridy = 0;
            constraints.insets = new Insets(5, 5, 5, 5);
            add(kullaniciTxt, constraints);

            JLabel sifreEtiketi = new JLabel("Şifre:");
            constraints.gridx = 0;
            constraints.gridy = 1;
            constraints.insets = new Insets(5, 5, 5, 5);
            add(sifreEtiketi, constraints);

            sifreTxt = new JPasswordField(15);
            constraints.gridx = 1;
            constraints.gridy = 1;
            constraints.insets = new Insets(5, 5, 5, 5);
            add(sifreTxt, constraints);

            hataMesaji = new JLabel("");
            constraints.gridx = 0;
            constraints.gridy = 2;
            constraints.gridwidth = 2;
            constraints.insets = new Insets(5, 5, 5, 5);
            add(hataMesaji, constraints);

            girisBtn = new JButton("Giriş Yap");
            constraints.gridx = 1;
            constraints.gridy = 3;
            constraints.insets = new Insets(5, 5, 5, 5);
            add(girisBtn, constraints);

            girisBtn.addActionListener(this);

            pack();
            setLocationRelativeTo(null);
            setVisible(true);
        }
        
     

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == girisBtn) {
                String kullanici = kullaniciTxt.getText();
                String sifre = new String(sifreTxt.getPassword());

                if (kullanici.isEmpty() || sifre.isEmpty()) {
                    hataMesaji.setText("Lütfen boş alan bırakmayınız.");
                    return;
                }

                boolean girisBasarili = kontrolEt(kullanici, sifre);

                if (girisBasarili) {
                    dispose(); // GirisPenceresi penceresini kapat
                    JOptionPane.showMessageDialog(null, "Giriş başarılı.");
                } else {
                    hataMesaji.setText("Üyelik numarası veya şifre yanlış.");
                }
            }
            
            // Uçuş RadioButton'u için ActionListener ekle // Sadece "yurt dışı" seferlerini gösteren bir pencere aç
            if (e.getSource() == uçuşRadioButton) {
                if (uçuşRadioButton.isSelected()) {
                    // Uçuş arama penceresini aç
                    new UcusAraPenceresi("Yurt Dışı");
                }
            }
        }


        private boolean kontrolEt(String kullanici, String sifre) {
            boolean girisBasarili = false;
            
            try {
                // Veritabanı bağlantısını oluştur
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thy", "root", "nisa2002");
                
                // SQL sorgusu oluştur
                String sql = "SELECT * FROM kullanici_tablosu WHERE uyelik_numarasi = ? AND sifre = ?";
                
                // SQL sorgusunu hazırla
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, kullanici);
                preparedStatement.setString(2, sifre);
                
                // SQL sorgusunu çalıştır ve sonuçları al
                ResultSet resultSet = preparedStatement.executeQuery();
                
                // Eğer sonuç varsa giriş başarılıdır
                if (resultSet.next()) {
                    girisBasarili = true;
                }
                
                // Bağlantıyı kapat
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            return girisBasarili;
        }	
           
        
    }

    public static void main(String[] args) {
        new Login();
    }
}