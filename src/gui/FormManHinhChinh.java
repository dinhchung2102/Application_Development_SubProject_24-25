package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dao.DAO_Ban;
import entity.Ban;
import entity.NhanVien;

/*
 * 
 * 
 * */

/*
 * 
 * 
 * 
 * */

public class FormManHinhChinh extends JFrame implements ActionListener {

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	private Font fontMenu;
	private Font fontMenuItem;
	private JMenuBar mnuMenuBar;
	private JMenu mnuDatBan;
	private JMenu mnuPhieuDatBan;
	private JMenuItem mniDSPhieuDatBan;
	private JMenuItem mniTimKiemPhieuDatBan;
	private JMenu mnuHoaDon;
	private JMenuItem mniXuatHoaDon;
	private JMenuItem mniDSHoaDon;
	private JMenu mnuKhuyenMai;
	private JMenuItem mniDSKhuyenMai;
	private JMenuItem mniThemKhuyenMai;
	private JMenu mnuKhachHang;
	private JMenuItem mniQuanLiKhachHang;
	private JMenu mnuBan;
	private JMenuItem mniQuanLiBan;
	private JMenu mnuMonAn;
	private JMenuItem mniDSMonAn;
	private JMenuItem mniThemMonAn;
	private JMenu mnuTaiKhoan;
	private JMenuItem mniThongKeDoanhThu;
	private JMenuItem mniThemNhanVien;
	private JMenuItem mniTaoTaiKhoan;
	private JMenuItem mniThongTinTaiKhoan;
	private JMenuItem mniDangXuat;

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */

	private static final long serialVersionUID = 1L;
	private JPanel tablePanel = new JPanel();
	private JButton btnLau1, btnLau2, btnLau3;
	private NhanVien nhanVien;

	private JPanel nvgRoom;

	private JPanel pnlChucNang;

	private JButton btnLocBanTrong;

	public FormManHinhChinh(NhanVien nhanVien) {
		setTitle("Quản lý đặt bàn");
		setExtendedState(JFrame.MAXIMIZED_BOTH); // Full màn hình
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		/***
		 * 
		 * 
		 * 
		 * FORM MENU CREATED BY PHAM VAN
		 * KHANG/////////////////////////////////////////////////////////////
		 * T//////////////////////////////////////////////////////////////////////////////////////////////
		 * 
		 */
		// tạo font cho JMenu
		fontMenu = new Font(Font.SERIF, Font.BOLD, 25);
		// tạo font cho JMenuItem
		fontMenuItem = new Font(Font.SERIF, Font.PLAIN, 25);

		// Tạo menubar
		mnuMenuBar = new JMenuBar();
		mnuMenuBar.setBackground(Color.white);
		this.setJMenuBar(mnuMenuBar);

		// Tạo menu đặt bàn
		mnuDatBan = new JMenu("     Đặt bàn     ");
		mnuDatBan.setFont(fontMenu);
		mnuDatBan.setOpaque(true);
		mnuDatBan.setBackground(Color.GREEN);
		mnuDatBan.setBorder(new LineBorder(Color.white, 1));

		mnuDatBan.addActionListener(this);

		// Tạo menu phiếu đặt bàn
		mnuPhieuDatBan = new JMenu("   Phiếu đặt bàn   ");
		mnuPhieuDatBan.setFont(fontMenu);
		mniDSPhieuDatBan = new JMenuItem("Danh sách phiếu đặt");
		mniDSPhieuDatBan.setFont(fontMenuItem);
		mniTimKiemPhieuDatBan = new JMenuItem("Tìm kiếm phiếu đặt");
		mniTimKiemPhieuDatBan.setFont(fontMenuItem);
		mnuPhieuDatBan.add(mniDSPhieuDatBan);
		mnuPhieuDatBan.addSeparator();
		mnuPhieuDatBan.add(mniTimKiemPhieuDatBan);

		mniDSPhieuDatBan.addActionListener(this);
		mniTimKiemPhieuDatBan.addActionListener(this);

		// Tạo menu hóa đơn
		mnuHoaDon = new JMenu("   Hóa đơn   ");
		mnuHoaDon.setFont(fontMenu);
		mniXuatHoaDon = new JMenuItem("Xuất hóa đơn");
		mniXuatHoaDon.setFont(fontMenuItem);
		mniDSHoaDon = new JMenuItem("Danh sách hóa đơn");
		mniDSHoaDon.setFont(fontMenuItem);
		mnuHoaDon.add(mniXuatHoaDon);
		mnuHoaDon.addSeparator();
		mnuHoaDon.add(mniDSHoaDon);

		mniXuatHoaDon.addActionListener(this);
		mniDSHoaDon.addActionListener(this);

		// Tạo menu khuyến mãi
		mnuKhuyenMai = new JMenu("   Khuyến mãi   ");
		mnuKhuyenMai.setFont(fontMenu);
		mniDSKhuyenMai = new JMenuItem("Danh sách khuyến mãi");
		mniDSKhuyenMai.setFont(fontMenuItem);
		mniThemKhuyenMai = new JMenuItem("Thêm khuyến mãi");
		mniThemKhuyenMai.setFont(fontMenuItem);
		mnuKhuyenMai.add(mniDSKhuyenMai);
		mnuKhuyenMai.addSeparator();
		mnuKhuyenMai.add(mniThemKhuyenMai);

		mniDSKhuyenMai.addActionListener(this);
		mniThemKhuyenMai.addActionListener(this);

		// Tạo menu khách hàng
		mnuKhachHang = new JMenu("   Khách hàng   ");
		mnuKhachHang.setFont(fontMenu);
		mniQuanLiKhachHang = new JMenuItem("Quản lí khách hàng");
		mniQuanLiKhachHang.setFont(fontMenuItem);
		mnuKhachHang.add(mniQuanLiKhachHang);

		mniQuanLiKhachHang.addActionListener(this);

		// Tạo menu bàn
		mnuBan = new JMenu("   Bàn   ");
		mnuBan.setFont(fontMenu);
		mniQuanLiBan = new JMenuItem("Quản lí bàn");
		mniQuanLiBan.setFont(fontMenuItem);
		mnuBan.add(mniQuanLiBan);

		mniQuanLiBan.addActionListener(this);

		// Tạo menu món ăn
		mnuMonAn = new JMenu("   Món ăn   ");
		mnuMonAn.setFont(fontMenu);
		mniDSMonAn = new JMenuItem("Danh sách món ăn");
		mniDSMonAn.setFont(fontMenuItem);
		mniThemMonAn = new JMenuItem("Thêm món ăn");
		mniThemMonAn.setFont(fontMenuItem);
		mnuMonAn.add(mniDSMonAn);
		mnuMonAn.addSeparator();
		mnuMonAn.add(mniThemMonAn);

		mniDSMonAn.addActionListener(this);
		mniThemMonAn.addActionListener(this);

		// Tạo menu tài khoản
		mnuTaiKhoan = new JMenu();
		ImageIcon iconTaiKhoan = new ImageIcon("image//userIcon.png");
		iconTaiKhoan.setImage(iconTaiKhoan.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
		mnuTaiKhoan.setFont(new Font(Font.SERIF, Font.ITALIC, 25));
		mnuTaiKhoan.setIcon(iconTaiKhoan);
		mniThongKeDoanhThu = new JMenuItem("Thống kê doanh thu");
		mniThongKeDoanhThu.setFont(fontMenuItem);
		mniThemNhanVien = new JMenuItem("Thêm nhân viên");
		mniThemNhanVien.setFont(fontMenuItem);
		mniTaoTaiKhoan = new JMenuItem("Tạo tài khoản");
		mniTaoTaiKhoan.setFont(fontMenuItem);
		mniThongTinTaiKhoan = new JMenuItem("Thông tin tài khoản");
		mniThongTinTaiKhoan.setFont(fontMenuItem);
		mniDangXuat = new JMenuItem("Đăng xuất");
		mniDangXuat.setFont(fontMenuItem);
		mnuTaiKhoan.add(mniThongKeDoanhThu);
		mnuTaiKhoan.addSeparator();
		mnuTaiKhoan.add(mniThemNhanVien);
		mnuTaiKhoan.addSeparator();
		mnuTaiKhoan.add(mniTaoTaiKhoan);
		mnuTaiKhoan.addSeparator();
		mnuTaiKhoan.add(mniThongTinTaiKhoan);
		mnuTaiKhoan.addSeparator();
		mnuTaiKhoan.add(mniDangXuat);

		mniThongKeDoanhThu.addActionListener(this);
		mniThongTinTaiKhoan.addActionListener(this);
		mniDangXuat.addActionListener(this);

		mnuMenuBar.add(mnuDatBan);
		mnuMenuBar.add(mnuPhieuDatBan);
		mnuMenuBar.add(mnuHoaDon);
		mnuMenuBar.add(mnuKhuyenMai);
		mnuMenuBar.add(mnuKhachHang);
		mnuMenuBar.add(mnuBan);
		mnuMenuBar.add(mnuMonAn);
		mnuMenuBar.add(mnuTaiKhoan);
		/***
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		
		/***
		 * 
		 * CODE MÀN HÌNH CHÍNH =====================/==================================/=================================
		 * VÕ ĐÌNH CHUNG////////////////////////////==================================/==================================
		 * 
		 * 
		 * */

		this.nhanVien = nhanVien;
		mnuTaiKhoan.setText(nhanVien.getTenNV());
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

		// Panel ChucNang
		pnlChucNang = new JPanel();
		pnlChucNang.setLayout(new BoxLayout(pnlChucNang, BoxLayout.Y_AXIS));
		pnlChucNang.setBackground(backgroundColor);

		pnlChucNang.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 10));

		btnLocBanTrong = new JButton("LỌC BÀN TRỐNG");

		pnlChucNang.add(btnLocBanTrong);
		pnlChucNang.setBackground(backgroundColor);

		// ===================== ADD CÁC PANEL VÀO JFRAME ======================== 
		getContentPane().add(tablePanel, BorderLayout.CENTER);
		getContentPane().add(pnlChucNang, BorderLayout.EAST);
		getContentPane().add(nvgRoom, BorderLayout.SOUTH);
	}
	/*
	 * 
	 * 
	 *
	 * 
	 * */
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLau1)) {
			nvgButton(btnLau1, btnLau2, btnLau3, "Lầu 1");
		} else if (o.equals(btnLau2)) {
			nvgButton(btnLau2, btnLau1, btnLau3, "Lầu 2");
		} else if (o.equals(btnLau3)) {
			nvgButton(btnLau3, btnLau1, btnLau2, "Lầu 3");
		} else if (o.equals(mnuDatBan)) {
			FormManHinhChinh newFrmManHinhChinh = new FormManHinhChinh(nhanVien);
			newFrmManHinhChinh.setVisible(true);
		}

		else if (o.equals(mniDSPhieuDatBan)) {

		} else if (o.equals(mniTimKiemPhieuDatBan)) {

		} else if (o.equals(mniXuatHoaDon)) {

		} else if (o.equals(mniDSHoaDon)) {

		} else if (o.equals(mniXuatHoaDon)) {

		} else if (o.equals(mniDSHoaDon)) {

		} else if (o.equals(mniDSKhuyenMai)) {
			this.dispose();
			KhuyenMaiGUI khuyenMaiGUI = new KhuyenMaiGUI(nhanVien);
			khuyenMaiGUI.setVisible(true);
		} else if (o.equals(mniThemKhuyenMai)) {

		} else if (o.equals(mnuKhachHang)) {
			KhachHangGUI newKhachHangGUI = new KhachHangGUI(nhanVien);
			newKhachHangGUI.setVisible(true);
		} else if (o.equals(mnuBan)) {
			

		} else if (o.equals(mniDSMonAn)) {
			dispose();
			MonAnGUI monAnGUI = new MonAnGUI(nhanVien);
			monAnGUI.setVisible(true);

		} else if (o.equals(mniThemMonAn)) {

		} else if (o.equals(mniQuanLiKhachHang)) {
			this.dispose();
			KhachHangGUI khachHang = new KhachHangGUI(nhanVien);
			khachHang.setVisible(true);
		} else if (o.equals(mniThongKeDoanhThu)) {

		} else if (o.equals(mniThongTinTaiKhoan)) {
			// ThongTinTaiKhoan_GUI thongTinTaiKhoan_GUI = new
			// ThongTinTaiKhoan_GUI(taiKhoan);
			// thongTinTaiKhoan_GUI.setVisible(true);
		} else if (o.equals(mniDangXuat)) {
			int response = JOptionPane.showConfirmDialog(this, 
		            "Bạn có chắc chắn muốn đăng xuất?", 
		            "Xác nhận đăng xuất", 
		            JOptionPane.YES_NO_OPTION);

		        if (response == JOptionPane.YES_OPTION) {
		            this.dispose();
		            DangNhap_GUI dangNhap_GUI = new DangNhap_GUI();
		            dangNhap_GUI.setVisible(true);
		        }
		}
	}
	/*
	 * 
	 * 
	 * 
	 * 
	 * */

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

		if (!ban.isTrangThai()) {
			tablePanel.setBackground(Color.LIGHT_GRAY);
		} else {
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
