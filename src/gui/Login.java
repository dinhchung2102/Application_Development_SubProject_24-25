package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import dao.DAO_DangNhap;
import dao.TaiKhoan_DAO;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Login() {
		setTitle("Quản lý đặt bàn nhà hàng Ba Thanh Niên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); // Full màn hình
        
        setLocationRelativeTo(null);
        

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(1600, 900));

		// Tạo hình nền
		ImageIcon imgBg = new ImageIcon("image/background.jpg");
		JLabel lblImage = new JLabel(imgBg);
		lblImage.setBounds(0, 0, 1600, 900);
		layeredPane.add(lblImage, Integer.valueOf(0));

		JPanel dangNhapPanel = new JPanel();
		dangNhapPanel.setLayout(new BoxLayout(dangNhapPanel, BoxLayout.Y_AXIS));
		dangNhapPanel.setOpaque(false);

		// Tiêu đề Đăng Nhập
		JLabel lblDangNhap = new JLabel("ĐĂNG NHẬP");
		lblDangNhap.setFont(new Font("Arial", Font.BOLD, 40));
		lblDangNhap.setForeground(Color.WHITE);
		lblDangNhap.setAlignmentX(CENTER_ALIGNMENT);

		// Panel tên đăng nhập:
		JPanel pnlTenDangNhap = new JPanel();
		pnlTenDangNhap.setLayout(new BoxLayout(pnlTenDangNhap, BoxLayout.X_AXIS));
		JLabel lblTenDangNhap = new JLabel("TÊN ĐĂNG NHẬP: ");
		lblTenDangNhap.setPreferredSize(new Dimension(145, 10));
		lblTenDangNhap.setFont(new Font("Arial", Font.BOLD, 15));
		lblTenDangNhap.setForeground(Color.BLACK);
		lblTenDangNhap.setAlignmentX(CENTER_ALIGNMENT);
		JTextField txtField = new JTextField(15);
		txtField.setFont(new Font("Arial", Font.BOLD, 20));

		pnlTenDangNhap.add(lblTenDangNhap);
		pnlTenDangNhap.add(txtField);
		pnlTenDangNhap.setBounds(450, 280, 480, 40);

		// Panel Mật khẩu
		JPanel pnlMatKhau = new JPanel();
		pnlMatKhau.setLayout(new BoxLayout(pnlMatKhau, BoxLayout.X_AXIS));
		JLabel lblMatKhau = new JLabel("MẬT KHẨU: ");
		lblMatKhau.setFont(new Font("Arial", Font.BOLD, 15));
		lblMatKhau.setForeground(Color.BLACK);
		lblMatKhau.setAlignmentX(CENTER_ALIGNMENT);
		lblMatKhau.setPreferredSize(new Dimension(145, 10));
		JPasswordField pwdField = new JPasswordField();
		pwdField.setFont(new Font("Arial", Font.BOLD, 20));

		pnlMatKhau.add(lblMatKhau);
		pnlMatKhau.add(pwdField);
		pnlMatKhau.setBounds(450, 350, 480, 40);

		// Panel Button
		JPanel pnlButton = new JPanel();
		pnlButton.setLayout(new BoxLayout(pnlButton, BoxLayout.X_AXIS));
		JButton btnDangNhap = new JButton("ĐĂNG NHẬP");
		btnDangNhap.setFont(new Font("Arial", Font.BOLD, 20));
		btnDangNhap.setForeground(new Color(0, 0, 0));
		btnDangNhap.setBackground(new Color(51, 255, 51));
		btnDangNhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String username = txtField.getText();
				String password = new String(pwdField.getPassword());
				DAO_DangNhap dangNhapDAO = new DAO_DangNhap();
				
				if (dangNhapDAO.validate(username, password)) {
					// JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");

					FormManHinhChinh newFrmManHinhChinh = new FormManHinhChinh();
					dispose();
					newFrmManHinhChinh.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không đúng.");
				}
			}
		});

		JButton btnDangKy = new JButton("GUEST");
		btnDangKy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FormManHinhChinh newFrm = new FormManHinhChinh();
				dispose();
				newFrm.setVisible(true);
				
			}
		});
		btnDangKy.setFont(new Font("Arial", Font.BOLD, 20));
		btnDangKy.setForeground(new Color(0, 0, 0));
		btnDangKy.setBackground(new Color(0, 255, 255));

		btnDangNhap.setBounds(450, 430, 200, 50);
		btnDangKy.setBounds(730, 430, 200, 50);

		// Thêm thành phần vào dangNhapPanel
		dangNhapPanel.add(lblDangNhap);
		dangNhapPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		dangNhapPanel.setBounds(400, 200, 600, 400);
		layeredPane.add(dangNhapPanel, Integer.valueOf(1));
		layeredPane.add(pnlTenDangNhap, Integer.valueOf(2));
		layeredPane.add(pnlMatKhau, Integer.valueOf(3));
		layeredPane.add(btnDangNhap, Integer.valueOf(4));
		layeredPane.add(btnDangKy, Integer.valueOf(5));

		getContentPane().add(layeredPane);

		setVisible(true);
	}

}
