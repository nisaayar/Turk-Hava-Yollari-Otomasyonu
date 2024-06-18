package thyyy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UcusAraPenceresi {
    
    private String fromProvince;
    private String toProvince;

    private JFrame frame;
    private JPanel panel;
    private JScrollPane scrollPane;
    
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
    
    public UcusAraPenceresi() {
        frame = new JFrame("Uçuş Ara");
        frame.setSize(1550, 820);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 3)); // 3 sütunlu bir grid layout

        // Uçuş verilerini almak için bağlantı oluştur
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thy", "root", "nisa2002");
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM ucuslar");
            ResultSet resultSet = statement.executeQuery();

            // Her uçuş seferi için bir satır oluştur
            while (resultSet.next()) {
                String kalkisYeri = resultSet.getString("kalkis_yeri");
                String varisYeri = resultSet.getString("varis_yeri");
                double biletFiyati = resultSet.getDouble("bilet_fiyati");

                JLabel label = new JLabel(kalkisYeri + " - " + varisYeri + " | " + biletFiyati + " TL");
                JButton satinAlButton = new JButton("Satın Al");
                satinAlButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Satın al butonunun tıklanma işlemleri buraya gelecek
                        frame.dispose(); // UcusAraPenceresi penceresini kapat
                        new UcakKoltukSecim(); // UcakKoltukSecim penceresini aç
                    }
                });

                panel.add(label);
                panel.add(new JLabel()); // Boş bir alan ekleyerek butonun alt alta olmasını sağla
                panel.add(satinAlButton);
            }

            scrollPane = new JScrollPane(panel);
            frame.add(scrollPane, BorderLayout.CENTER);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        new UcusAraPenceresi();
    }
}

    	
    	
	      


    	
    	
	      

