package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import dao.TaiKhoan_DAO;
import entity.TaiKhoan;

public class DangNhap_GUI extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnlDangNhap;
	private JPanel pnlForm;
	private JPanel pnlTaiKhoan;
	private JLabel lblTaiKhoan;
	private JTextField txtTaiKhoan;
	private JPanel pnlMatKhau;
	private JLabel lblMatKhau;
	private JPasswordField txtMatKhau;
	private JPanel pnlButton;
	private JButton btnDangNhap;
	
	private TaiKhoan_DAO taiKhoan_DAO = new TaiKhoan_DAO();
	
	public DangNhap_GUI() {
		setVisible(true);
		setSize(1600, 900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setTitle("CHƯƠNG TRÌNH QUẢN LÍ ĐẶT BÀN TRONG NHÀ HÀNG");
		
		
		pnlDangNhap = new JPanel(new GridBagLayout()){
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private Image backgroundImage = new ImageIcon("image/background.jpg").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        // Tạo form đăng nhập và thêm vào vùng CENTER
        pnlForm = new JPanel();
        pnlForm.setLayout(new BoxLayout(pnlForm, BoxLayout.Y_AXIS));
        Border borderForm = BorderFactory.createLineBorder(Color.CYAN, 2);
        pnlForm.setBorder(borderForm);

        pnlTaiKhoan = new JPanel();
        lblTaiKhoan = new JLabel("Tài khoản:");
        txtTaiKhoan = new JTextField(20);
        pnlTaiKhoan.add(lblTaiKhoan);
        pnlTaiKhoan.add(txtTaiKhoan);
        
        pnlMatKhau = new JPanel();
        lblMatKhau = new JLabel("Mật khẩu:");
        txtMatKhau = new JPasswordField(20);
        pnlMatKhau.add(lblMatKhau);
        pnlMatKhau.add(txtMatKhau);
        
        pnlButton = new JPanel();
        btnDangNhap = new JButton("Đăng Nhập");
        pnlButton.add(btnDangNhap);
        
        pnlForm.add(pnlTaiKhoan);
        pnlForm.add(pnlMatKhau);
        pnlForm.add(pnlButton);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;  // Phân phối không gian theo chiều dọc
        gbc.anchor = GridBagConstraints.CENTER; // Căn giữa trục dọc
        pnlDangNhap.add(pnlForm, gbc);
        
//        pnlDangNhap.add(pnlForm, BorderLayout.CENTER);
        
		add(pnlDangNhap);
		btnDangNhap.addActionListener((ActionListener) this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnDangNhap)) {
			String username = txtTaiKhoan.getText();
			String password = txtMatKhau.getText();
			
			TaiKhoan tk = taiKhoan_DAO.dangNhap(username, password);
			if (tk!=null) {
				this.dispose();
				FormMenu formMenu = new FormMenu(tk);
				formMenu.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "Sai tên tài khoản hoặc mật khẩu!!!");
			}
		
		}
		
	}
}