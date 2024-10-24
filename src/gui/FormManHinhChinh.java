package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dao.DAO_Ban;
import entity.Ban;
import entity.NhanVien;




public class FormManHinhChinh extends FormMenu implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JPanel tablePanel = new JPanel();
    private JButton btnLau1, btnLau2, btnLau3;
    private NhanVien nhanVien;

	private JPanel nvgRoom;

	private JPanel pnlChucNang;

	private JButton btnLocBanTrong;
	
    public FormManHinhChinh(NhanVien nhanVien) {
    	this.nhanVien = nhanVien;
    	Color backgroundColor = Color.white;
    	
        // ==================== PANEL TẠO SƠ ĐỒ BÀN ===================
        tablePanel.setLayout(new GridLayout(2, 4));
        tablePanel.setBorder(new EmptyBorder(20, 20, 10, 20));

        // ================= PANEL ĐIỀU HƯỚNG KHU VỰC ==================
        nvgRoom = new JPanel();
        nvgRoom.setLayout(new BoxLayout(nvgRoom, BoxLayout.X_AXIS));
        nvgRoom.setBackground(getForeground());
        nvgRoom.setBackground(backgroundColor);
        btnLau1 = new JButton("LẦU 1");
        btnLau2 = new JButton("LẦU 2");
        btnLau3 = new JButton("LẦU 3");
       

        nvgRoom.add(Box.createRigidArea(new Dimension(20, 0)));
        nvgRoom.add(btnLau1);
        nvgRoom.add(Box.createRigidArea(new Dimension(10, 0)));
        nvgRoom.add(btnLau2);
        nvgRoom.add(Box.createRigidArea(new Dimension(10, 0)));
        nvgRoom.add(btnLau3);
        
//        
        nvgRoom.add(Box.createVerticalStrut(100));
        

        btnLau1.setForeground(Color.WHITE);
        btnLau2.setForeground(Color.WHITE);
        btnLau3.setForeground(Color.WHITE);
        nvgButton(btnLau1, btnLau2, btnLau3, "Lầu 1");

        // Thêm ActionListener 
        btnLau1.addActionListener(this);
        btnLau2.addActionListener(this);
        btnLau3.addActionListener(this);
        
        
        //Panel ChucNang
        pnlChucNang = new JPanel();
        pnlChucNang.setLayout(new BoxLayout(pnlChucNang, BoxLayout.Y_AXIS));
        pnlChucNang.setBackground(backgroundColor);
      
        pnlChucNang.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 10));
        
        
        
        
        btnLocBanTrong =  new JButton("LỌC BÀN TRỐNG");
        
       
        pnlChucNang.add(btnLocBanTrong);
        pnlChucNang.setBackground(backgroundColor);

        // ===================== ADD CÁC PANEL VÀO JFRAME ========================
        getContentPane().add(tablePanel, BorderLayout.CENTER);
        getContentPane().add(pnlChucNang, BorderLayout.EAST);
        getContentPane().add(nvgRoom, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(btnLau1)) {
            nvgButton(btnLau1, btnLau2, btnLau3, "Lầu 1");
        } else if (source.equals(btnLau2)) {
            nvgButton(btnLau2, btnLau1, btnLau3, "Lầu 2");
        } else if (source.equals(btnLau3)) {
            nvgButton(btnLau3, btnLau1, btnLau2, "Lầu 3");
        }
    }

    private void nvgButton(JButton btnSelect, JButton btn2, JButton btn3, String khuVuc) {
        // ===================== Set color for selectedButton =========================
        Color selectedColor = new Color(0, 255, 0);
        Color unselectedColor = new Color(128, 128, 128);
        btnSelect.setBackground(selectedColor);
        btn2.setBackground(unselectedColor);
        btn3.setBackground(unselectedColor);

        // =================== Vẽ lại PanelTable =====================================
        tablePanel.removeAll();
        tablePanel.setBackground(Color.white);

        DAO_Ban daoBan = new DAO_Ban();
        List<Ban> bans = daoBan.getBansByKhuVuc(khuVuc);
        for (Ban ban : bans) {
            JButton table = createTablePanel(ban.getLoaiBan(), ban.getSoGheNgoi(), ban.getMaBan());
            table.setBackground(Color.white);
            table.setBorder(new LineBorder(Color.white, 4)); 
            tablePanel.add(table);
            table.addActionListener(e -> {
            	dispose();
                FormDatBan newFrmDatBan = new FormDatBan(ban.getMaBan(), khuVuc, nhanVien);
                newFrmDatBan.setVisible(true);
            });
        }
        tablePanel.revalidate();
        tablePanel.repaint();
    }

    private JButton createTablePanel(String tableName, Integer soGheNgoi, Integer id) {
        Color bgColor = new Color(255, 255, 255);
        JButton btnTable = new JButton();
        btnTable.setBackground(bgColor);
        
        DAO_Ban dao_Ban = new DAO_Ban();
        Ban ban = dao_Ban.getBanById(id);
        
       

        JPanel tablePanel = new JPanel();
        
        tablePanel.setPreferredSize(new Dimension(500, 500));
        tablePanel.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 0), 10));
        
        if(!ban.isTrangThai()) {
        	tablePanel.setBackground(Color.LIGHT_GRAY);
        }
        else {
			tablePanel.setBackground(Color.GREEN);
		}

        JLabel lblID = new JLabel("Bàn: " + id);
        lblID.setFont(new Font("Montserrat", Font.BOLD, 50));
        JLabel label = new JLabel(tableName.toUpperCase());
        label.setFont(new Font("Montserrat", Font.BOLD, 20));
        label.setForeground(Color.WHITE);
        JLabel lblSoGhe = new JLabel("SỐ GHẾ: " + soGheNgoi);
        lblSoGhe.setFont(new Font("Montserrat", Font.BOLD, 30));

        tablePanel.add(lblID);
        tablePanel.add(Box.createRigidArea(new Dimension(30, 40)));
        tablePanel.add(label);
        tablePanel.add(lblSoGhe);

        btnTable.add(tablePanel);
        return btnTable;
    }
    
}
