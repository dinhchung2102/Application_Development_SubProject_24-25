package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

import dao.ChiTietPhieuDatBan_DAO;
import dao.DAO_Ban;
import dao.DAO_KhachHang;
import dao.DAO_KhuVuc;
import dao.MonAnDAO;
import dao.PhieuDatBan_DAO;
import entity.Ban;
import entity.ChiTietPhieuDatBan;
import entity.KhachHang;
import entity.KhuVuc;
import entity.MonAn;
import entity.NhanVien;
import entity.PhieuDatBan;

public class FormDatBan extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NhanVien nhanVien;
	private Color backgroundColor = Color.cyan;
	Color whiteColor = new Color(255, 255, 255);
	Color whiteLight = new Color(250, 250, 250);
	Font txtFieldFont = new Font("Montserrat", Font.BOLD, 16);
	private JPanel pnlHeader;
	private JLabel lblHeader;
	private JPanel pnlInfor;
	private JPanel pnlTTKhachHang;
	private JPanel pnlSDT;
	private JLabel lblSDT;
	private JTextField txtSDT;
	private JButton btnTimSDT;
	private JPanel pnlLoaiKhachHang;
	private JLabel lblLoaiKH;
	private JRadioButton radioBtnKHMoi;
	private JRadioButton radioBtnKHVangLai;
	private ButtonGroup groupRadioBtnLoaiKH;
	private JPanel pnlTenKH;
	private JLabel lblTenKH;
	private JTextField txtTenKH;
	private JPanel pnlEmail;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JPanel pnlDiaChi;
	private JLabel lblDiaChi;
	private JTextField txtDiaChi;
	private JPanel pnlTTDatBan;
	private JPanel pnlNhanVien;
	private JTextField txtNhanVien;
	private JPanel pnlSDDatBan;
	private JRadioButton radioBtnSuDungNgay;
	private JRadioButton radioBtnDungSau;
	private ButtonGroup groupRadioBtnSuDung;
	private JPanel pnlMaDatBan;
	private JLabel lblMaDatBan;
	private JTextField txtMaDatBan;
	private JPanel pnlViTriBan;
	private JLabel lblKhuVuc;
	private JComboBox<String> comboBoxKhuVuc;
	private JLabel lblBan;
	private JComboBox<Integer> comboBoxBan;
	private JLabel lblSoKhach;
	private JComboBox<Integer> comboBoxSLKhach;
	private JPanel pnlGioDen;
	private JLabel lblGioDen;
	private JComboBox<Integer> comboBoxGio;
	private JComboBox<Integer> comboBoxPhut;
	private JLabel lblNgayDen;
	private JDateChooser dateChooserNgayDen;
	private JLabel hh;
	private JLabel mm;
	private JPanel pnlTienCoc;
	private JLabel lblTienCoc;
	private JTextField txtTienCoc;
	private JPanel pnlGoiMon;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel pnlListMon;
	private DefaultTableModel modelTinhTien;
	private JTable tableTinhTien;
	private JScrollPane scrollPaneTinhTien;
	private JPanel pnlThongTinPhieu;
	private JPanel pnlYYY;
	private JPanel pnlButton;
	private JButton btnDatBan;
	private JButton btnDatIn;
	private JButton btnBack;
	private JButton btnLamMoi;
	private JPanel panelDatBan;
	private JPanel pnlSearchMonAn;
	private JTextField txtTimMon;
	private JButton btnTimMon;
	private JPanel pnlButtonDatMon;
	private JButton btnThemMon;

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
	private JButton btnKhaiVi;
	private JButton btnAll;
	private JButton btnNuoc;
	private JButton btnMonChinh;

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */

	public FormDatBan(Integer maBan, String khuVuc, NhanVien nhanVien) {
		setTitle("Quản lý đặt bàn");
		setExtendedState(JFrame.MAXIMIZED_BOTH); // Full màn hình
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		this.nhanVien = nhanVien;
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
		mnuDatBan.setBackground(Color.green);
		mnuDatBan.setBorder(new LineBorder(Color.white, 1));

		// mnuDatBan.addActionListener(this);

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

//		mniDSPhieuDatBan.addActionListener(this);
//		mniTimKiemPhieuDatBan.addActionListener(this);

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

//		mniXuatHoaDon.addActionListener(this);
//		mniDSHoaDon.addActionListener(this);

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

//		mniDSKhuyenMai.addActionListener(this);
//		mniThemKhuyenMai.addActionListener(this);

		// Tạo menu khách hàng
		mnuKhachHang = new JMenu("   Khách hàng   ");
		mnuKhachHang.setFont(fontMenu);
		mniQuanLiKhachHang = new JMenuItem("Quản lí khách hàng");
		mniQuanLiKhachHang.setFont(fontMenuItem);
		mnuKhachHang.add(mniQuanLiKhachHang);

		mniQuanLiKhachHang.addActionListener(e -> {
			KhachHangGUI khachHangGUI = new KhachHangGUI();
			khachHangGUI.setVisible(true);
		});

		// Tạo menu bàn
		mnuBan = new JMenu("   Bàn   ");
		mnuBan.setFont(fontMenu);
		mniQuanLiBan = new JMenuItem("Quản lí bàn");
		mniQuanLiBan.setFont(fontMenuItem);
		mnuBan.add(mniQuanLiBan);

//		mniQuanLiBan.addActionListener(this);

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

//		mniDSMonAn.addActionListener(this);
//		mniThemMonAn.addActionListener(this);

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
		mnuTaiKhoan.setText(nhanVien.getTenNV());

//		mniThongKeDoanhThu.addActionListener(this);
//		mniThongTinTaiKhoan.addActionListener(this);
		mniDangXuat.addActionListener(e -> {
			int response = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đăng xuất?", "Xác nhận đăng xuất",
					JOptionPane.YES_NO_OPTION);

			if (response == JOptionPane.YES_OPTION) {
				this.dispose();
				DangNhap_GUI dangNhap_GUI = new DangNhap_GUI();
				dangNhap_GUI.setVisible(true);
			}
		});

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

		pnlHeader = new JPanel();
		pnlHeader.setBackground(backgroundColor);
		lblHeader = new JLabel("THÊM MỚI ĐẶT BÀN");
		lblHeader.setFont(new Font("Montserrat", Font.BOLD, 40));
		pnlHeader.add(lblHeader);

		// Panel chứa thông tin thêm đặt bàn mới//
		pnlInfor = new JPanel();
		pnlInfor.setLayout(new BoxLayout(pnlInfor, BoxLayout.X_AXIS));
		pnlInfor.setBackground(backgroundColor);

		/*
		 * Panel thông tin Khách hàng + Nhân viên : Boxlayout Y : << Box X>><<Box>>
		 */

		/*
		 * Panel thông tin khách hàng
		 */

		pnlTTKhachHang = new JPanel();
		pnlTTKhachHang.setLayout(new BoxLayout(pnlTTKhachHang, BoxLayout.Y_AXIS));
		pnlTTKhachHang.setPreferredSize(new Dimension(150, 300));
		pnlTTKhachHang.setBackground(backgroundColor);

		// =====================TÌM SDT KHÁCH HÀNG==========================
		pnlSDT = new JPanel();
		pnlSDT.setBackground(backgroundColor);
		pnlSDT.setLayout(new BoxLayout(pnlSDT, BoxLayout.X_AXIS));
		lblSDT = new JLabel("ĐIỆN THOẠI: ");
		lblSDT.setFont(txtFieldFont);
		txtSDT = new JTextField();
		txtSDT.setFont(txtFieldFont);
		btnTimSDT = new JButton("TÌM");
		btnTimSDT.setPreferredSize(new Dimension(80, 10));
		btnTimSDT.setBackground(whiteColor);
		btnTimSDT.setFont(new Font("Montserrat", Font.BOLD, 20));

		pnlSDT.add(lblSDT);
		pnlSDT.add(Box.createHorizontalStrut(44));
		pnlSDT.add(txtSDT);
		pnlSDT.add(btnTimSDT);
		// =======================LOẠI KHÁCH HÀNG================================
		pnlLoaiKhachHang = new JPanel();
		pnlLoaiKhachHang.setLayout(new BoxLayout(pnlLoaiKhachHang, BoxLayout.X_AXIS));
		pnlLoaiKhachHang.setBackground(backgroundColor);

		lblLoaiKH = new JLabel("KHÁCH HÀNG: ");
		lblLoaiKH.setFont(txtFieldFont);

		radioBtnKHMoi = new JRadioButton("MỚI");
		radioBtnKHMoi.setFont(txtFieldFont);
		radioBtnKHMoi.setSelected(true);
		radioBtnKHMoi.setBackground(backgroundColor);

		radioBtnKHVangLai = new JRadioButton("VÃNG LAI");
		radioBtnKHVangLai.setFont(txtFieldFont);
		radioBtnKHVangLai.setBackground(backgroundColor);

		groupRadioBtnLoaiKH = new ButtonGroup();
		groupRadioBtnLoaiKH.add(radioBtnKHMoi);
		groupRadioBtnLoaiKH.add(radioBtnKHVangLai);

		pnlLoaiKhachHang.add(lblLoaiKH);
		pnlLoaiKhachHang.add(Box.createHorizontalStrut(25));
		pnlLoaiKhachHang.add(radioBtnKHMoi);
		pnlLoaiKhachHang.add(Box.createHorizontalStrut(50));
		pnlLoaiKhachHang.add(radioBtnKHVangLai);
		pnlLoaiKhachHang.add(Box.createHorizontalStrut(135));

		radioBtnKHVangLai.addActionListener(e -> {
			DAO_KhachHang dao_KhachHang = new DAO_KhachHang();
			KhachHang khachVangLai = new KhachHang();
			khachVangLai = dao_KhachHang.getKhachHangBySDT("0000000000");

			txtSDT.setText(khachVangLai.getSoDT());
			txtTenKH.setText(khachVangLai.getTenKH());
			txtTenKH.setEditable(false);
			txtDiaChi.setText("");
			txtDiaChi.setEditable(false);
			txtEmail.setText("");
			txtEmail.setEditable(false);

		});

		// =====================MÃ KHÁCH HÀNG================================
//		JPanel pnlMaKH = new JPanel();
//		pnlMaKH.setLayout(new BoxLayout(pnlMaKH, BoxLayout.X_AXIS));
//
//		JLabel lblMaKH = new JLabel("MÃ KHÁCH HÀNG: ");
//		lblMaKH.setFont(txtFieldFont);
//		JTextField txtMaKH = new JTextField();
//		txtMaKH.setFont(txtFieldFont);
//		txtMaKH.setEditable(false);
//		txtMaKH.setBackground(whiteColor);
//
//		pnlMaKH.add(lblMaKH);
//		
//		pnlMaKH.add(txtMaKH);

		// =====================HỌ TÊN KHÁCH HÀNG============================

		pnlTenKH = new JPanel();
		pnlTenKH.setLayout(new BoxLayout(pnlTenKH, BoxLayout.X_AXIS));
		pnlTenKH.setBackground(backgroundColor);

		lblTenKH = new JLabel("HỌ TÊN: ");
		lblTenKH.setFont(txtFieldFont);
		txtTenKH = new JTextField();
		txtTenKH.setFont(txtFieldFont);
		txtTenKH.setBackground(whiteColor);

		pnlTenKH.add(lblTenKH);
		pnlTenKH.add(Box.createHorizontalStrut(73));
		pnlTenKH.add(txtTenKH);
		// =======================EMAIL========================================

		pnlEmail = new JPanel();
		pnlEmail.setLayout(new BoxLayout(pnlEmail, BoxLayout.X_AXIS));
		pnlEmail.setBackground(backgroundColor);

		lblEmail = new JLabel("EMAIL: ");
		lblEmail.setFont(txtFieldFont);
		txtEmail = new JTextField();
		txtEmail.setFont(txtFieldFont);
		pnlEmail.add(lblEmail);
		pnlEmail.add(Box.createHorizontalStrut(84));
		pnlEmail.add(txtEmail);

		// =======================ĐỊA CHỈ KHÁCH HÀNG==========================

		pnlDiaChi = new JPanel();
		pnlDiaChi.setLayout(new BoxLayout(pnlDiaChi, BoxLayout.X_AXIS));
		pnlDiaChi.setBackground(backgroundColor);

		lblDiaChi = new JLabel("ĐỊA CHỈ: ");
		lblDiaChi.setFont(txtFieldFont);
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(txtFieldFont);
		pnlDiaChi.add(lblDiaChi);
		pnlDiaChi.add(Box.createHorizontalStrut(76));
		pnlDiaChi.add(txtDiaChi);
		// =====================ACTION PANEL THÔNG TIN KHÁCH HÀNG============
		btnTimSDT.addActionListener(e -> {

			DAO_KhachHang dao_KhachHang = new DAO_KhachHang();
			KhachHang khachHang = dao_KhachHang.getKhachHangBySDT(txtSDT.getText());

			if (khachHang == null) {
				JOptionPane.showMessageDialog(null, "SỐ ĐIỆN THOẠI KHÔNG TỒN TẠI", "Nhà hàng hiện lên và nói",
						JOptionPane.WARNING_MESSAGE);

			} else {
				groupRadioBtnLoaiKH.clearSelection();
				// txtMaKH.setText(String.valueOf(khachHang.getMaKH()));

				txtTenKH.setEditable(false);
				txtTenKH.setBackground(whiteLight);
				txtTenKH.setText(khachHang.getTenKH());

				txtDiaChi.setEditable(false);
				txtDiaChi.setBackground(whiteLight);
				txtDiaChi.setText(khachHang.getDiaChi());

				txtEmail.setEditable(false);
				txtEmail.setBackground(whiteLight);
				txtEmail.setText(khachHang.getEmail());
			}
		});
		radioBtnKHMoi.addActionListener(e -> {
			txtSDT.setText("");

			txtTenKH.setEditable(true);
			txtTenKH.setBackground(whiteColor);
			txtTenKH.setText("");

			txtDiaChi.setEditable(true);
			txtDiaChi.setBackground(whiteColor);
			txtDiaChi.setText("");

			txtEmail.setEditable(true);
			txtEmail.setBackground(whiteColor);
			txtEmail.setText("");
		});
		// ====================ADD CÁC PANEL VÀO pnlTTKhachHang
		pnlTTKhachHang.add(Box.createVerticalStrut(10));
		// pnlTTKhachHang.add(pnlMaKH);
		pnlTTKhachHang.add(pnlLoaiKhachHang);
		pnlTTKhachHang.add(Box.createVerticalStrut(10));
		pnlTTKhachHang.add(pnlSDT);
		pnlTTKhachHang.add(Box.createVerticalStrut(10));
		pnlTTKhachHang.add(pnlTenKH);
		pnlTTKhachHang.add(Box.createVerticalStrut(10));
		pnlTTKhachHang.add(pnlDiaChi);
		pnlTTKhachHang.add(Box.createVerticalStrut(10));
		pnlTTKhachHang.add(pnlEmail);

		/*
		 * PANEL THÔNG TIN ĐẶT BÀN==============================================
		 * =======================================================================
		 * =============================================================================
		 * ==
		 * 
		 */
		pnlTTDatBan = new JPanel();
		pnlTTDatBan.setLayout(new BoxLayout(pnlTTDatBan, BoxLayout.Y_AXIS));
		pnlTTDatBan.setPreferredSize(new Dimension(150, 300));
		pnlTTDatBan.setBackground(backgroundColor);
		// ======================THÔNG TIN NHÂN VIÊN===========================
		pnlNhanVien = new JPanel();
		pnlNhanVien.setLayout(new BoxLayout(pnlNhanVien, BoxLayout.X_AXIS));
		pnlNhanVien.setBackground(backgroundColor);
		JLabel lblNhanVien = new JLabel("NHÂN VIÊN: ");
		lblNhanVien.setFont(txtFieldFont);

//		JComboBox<String> comboBoxNhanVien = new JComboBox<String>();
//		comboBoxNhanVien.setFont(txtFieldFont);
//		comboBoxNhanVien.setBackground(whiteColor);
//		
//		ArrayList<NhanVien> nVienList = new ArrayList<NhanVien>();
//		nVienList = new NhanVien_DAO().getAllNhanVien();
//		
//		for(NhanVien nVien: nVienList) {
//			comboBoxNhanVien.addItem(nVien.getTenNV());
//		}
//		

		txtNhanVien = new JTextField();
		txtNhanVien.setText(nhanVien.getTenNV());
		txtNhanVien.setFont(txtFieldFont);
		txtNhanVien.setBackground(whiteLight);
		txtNhanVien.setEditable(false);
		txtNhanVien.setBackground(new Color(255, 255, 255));
		pnlNhanVien.add(lblNhanVien);
		pnlNhanVien.add(Box.createHorizontalStrut(14));
		pnlNhanVien.add(txtNhanVien);
		// pnlNhanVien.add(txtNhanVien);
		// ===========================SỬ DỤNG ĐẶT BÀN===============================
		pnlSDDatBan = new JPanel();
		pnlSDDatBan.setLayout(new BoxLayout(pnlSDDatBan, BoxLayout.X_AXIS));
		pnlSDDatBan.setBackground(backgroundColor);
		radioBtnSuDungNgay = new JRadioButton("SỬ DỤNG NGAY");
		radioBtnSuDungNgay.setFont(txtFieldFont);
		radioBtnSuDungNgay.setSelected(true);
		radioBtnSuDungNgay.setBackground(backgroundColor);

		radioBtnDungSau = new JRadioButton("DÙNG SAU");
		radioBtnDungSau.setFont(txtFieldFont);
		radioBtnDungSau.setBackground(backgroundColor);

		groupRadioBtnSuDung = new ButtonGroup();
		groupRadioBtnSuDung.add(radioBtnSuDungNgay);
		groupRadioBtnSuDung.add(radioBtnDungSau);

		pnlSDDatBan.add(Box.createHorizontalStrut(70));
		pnlSDDatBan.add(radioBtnSuDungNgay);
		pnlSDDatBan.add(Box.createHorizontalStrut(70));
		pnlSDDatBan.add(radioBtnDungSau);

		// ========================MÃ ĐẶT BÀN======================================
		pnlMaDatBan = new JPanel();
		pnlMaDatBan.setLayout(new BoxLayout(pnlMaDatBan, BoxLayout.X_AXIS));
		pnlMaDatBan.setBackground(backgroundColor);
		lblMaDatBan = new JLabel("MÃ ĐẶT BÀN: ");
		lblMaDatBan.setFont(txtFieldFont);
		txtMaDatBan = new JTextField();
		txtMaDatBan.setFont(txtFieldFont);
		txtMaDatBan.setEditable(false);
		txtMaDatBan.setBackground(whiteColor);
		pnlMaDatBan.add(lblMaDatBan);
		pnlMaDatBan.add(txtMaDatBan);
		// ==============================VỊ TRÍ BÀN ĐẶT ============================
		pnlViTriBan = new JPanel();
		pnlViTriBan.setLayout(new BoxLayout(pnlViTriBan, BoxLayout.X_AXIS));
		pnlViTriBan.setBackground(backgroundColor);
		lblKhuVuc = new JLabel("KHU VỰC: ");
		lblKhuVuc.setFont(txtFieldFont);
		comboBoxKhuVuc = new JComboBox<String>();
		comboBoxKhuVuc.setBackground(whiteColor);
		comboBoxKhuVuc.setFont(txtFieldFont);

		lblBan = new JLabel("BÀN: ");
		lblBan.setFont(txtFieldFont);
		comboBoxBan = new JComboBox<Integer>();
		comboBoxBan.setBackground(whiteColor);
		comboBoxBan.setFont(txtFieldFont);

		pnlViTriBan.add(lblKhuVuc);
		pnlViTriBan.add(Box.createHorizontalStrut(25));
		pnlViTriBan.add(comboBoxKhuVuc);
		pnlViTriBan.add(lblBan);
		pnlViTriBan.add(comboBoxBan);

		lblSoKhach = new JLabel("SỐ LƯỢNG: ");
		lblSoKhach.setFont(txtFieldFont);
		comboBoxSLKhach = new JComboBox<Integer>();
		comboBoxSLKhach.setPreferredSize(new Dimension(60, 30));
		comboBoxSLKhach.setBackground(backgroundColor);
		comboBoxSLKhach.setBackground(whiteColor);
		comboBoxSLKhach.setFont(txtFieldFont);
		getDataToComboBox(comboBoxKhuVuc, comboBoxBan, comboBoxSLKhach, khuVuc, maBan);

		pnlViTriBan.add(lblSoKhach);
		pnlViTriBan.add(comboBoxSLKhach);
		pnlViTriBan.setBackground(backgroundColor);

		// =======================GIỜ ĐẾN ===============================

		pnlGioDen = new JPanel();
		pnlGioDen.setLayout(new BoxLayout(pnlGioDen, BoxLayout.X_AXIS));
		pnlGioDen.setBackground(backgroundColor);

		lblGioDen = new JLabel("GIỜ ĐẾN: ");
		lblGioDen.setFont(txtFieldFont);

		comboBoxGio = new JComboBox<Integer>();
		comboBoxGio.setFont(txtFieldFont);
		comboBoxGio.setBackground(backgroundColor);
		for (int i = 7; i <= 21; i++) {
			comboBoxGio.addItem(i);
		}

		comboBoxPhut = new JComboBox<Integer>();
		comboBoxPhut.setFont(txtFieldFont);
		comboBoxPhut.setBackground(backgroundColor);
		for (int i = 0; i <= 59; i++) {
			comboBoxPhut.addItem(i);
		}
		comboBoxGio.setEnabled(false);
		comboBoxPhut.setEnabled(false);

		comboBoxGio.setBackground(whiteLight);
		comboBoxPhut.setBackground(whiteLight);

		lblNgayDen = new JLabel("NGÀY: ");
		lblNgayDen.setFont(txtFieldFont);

		dateChooserNgayDen = new JDateChooser();
		dateChooserNgayDen.setFont(txtFieldFont);
		dateChooserNgayDen.setBackground(whiteLight);
		dateChooserNgayDen.setEnabled(false);
		dateChooserNgayDen.setMinSelectableDate(new Date());

		radioBtnSuDungNgay.addActionListener(e -> {
			comboBoxGio.setBackground(whiteLight);
			comboBoxPhut.setBackground(whiteLight);
			comboBoxGio.setEnabled(false);
			comboBoxPhut.setEnabled(false);
			dateChooserNgayDen.setEnabled(false);

		});

		radioBtnDungSau.addActionListener(e -> {

			comboBoxGio.setBackground(whiteColor);
			comboBoxPhut.setBackground(whiteColor);
			comboBoxGio.setEnabled(true);
			comboBoxPhut.setEnabled(true);
			dateChooserNgayDen.setBackground(whiteColor);
			dateChooserNgayDen.setEnabled(true);
		});
		hh = new JLabel("giờ");
		hh.setFont(txtFieldFont);
		mm = new JLabel("phút");
		mm.setFont(txtFieldFont);

		pnlGioDen.add(lblGioDen);
		pnlGioDen.add(Box.createHorizontalStrut(30));
		pnlGioDen.add(comboBoxGio);
		pnlGioDen.add(hh);
		pnlGioDen.add(Box.createHorizontalStrut(10));
		pnlGioDen.add(comboBoxPhut);
		pnlGioDen.add(mm);
		pnlGioDen.add(Box.createHorizontalStrut(30));
		pnlGioDen.add(lblNgayDen);

		pnlGioDen.add(dateChooserNgayDen);

		// ======================SỐ LƯỢNG KHÁCH===================
		// =================================TIỀN CỌC
		// ====================================
		pnlTienCoc = new JPanel();
		pnlTienCoc.setLayout(new BoxLayout(pnlTienCoc, BoxLayout.X_AXIS));
		pnlTienCoc.setBackground(backgroundColor);
		lblTienCoc = new JLabel("TIỀN CỌC: ");
		lblTienCoc.setFont(txtFieldFont);
		txtTienCoc = new JTextField();
		txtTienCoc.setFont(txtFieldFont);
		updateTienCoc();

		// ==============================ACTION LISTENER/[[[[]]]]PANEL TT DAT
		// BAN========================
		comboBoxKhuVuc.addActionListener(e -> {
			List<Ban> bans = new ArrayList<Ban>();
			bans = new DAO_Ban().getBansByKhuVuc((String) comboBoxKhuVuc.getSelectedItem());
			comboBoxBan.removeAllItems();
			for (Ban ban : bans) {
				comboBoxBan.addItem(ban.getMaBan());
			}

			comboBoxSLKhach.removeAllItems();
			int soGhe = new DAO_Ban().getSoGheByMaBan((Integer) comboBoxBan.getSelectedItem());

			for (int i = 1; i <= soGhe; i++) {
				comboBoxSLKhach.addItem(i);
			}

			updateTienCoc();
		});

		comboBoxBan.addActionListener(e -> {

			comboBoxSLKhach.removeAllItems();
			if (comboBoxBan.getItemCount() > 0) {
				int soGhe2 = new DAO_Ban().getSoGheByMaBan((Integer) comboBoxBan.getSelectedItem());

				for (int i = 1; i <= soGhe2; i++) {
					comboBoxSLKhach.addItem(i);
				}
			}
			updateTienCoc();
		});
		// OK combobox SL Khách
		comboBoxSLKhach.addActionListener(e -> {
			updateTienCoc();
		});

		pnlTienCoc.add(lblTienCoc);
		pnlTienCoc.add(Box.createHorizontalStrut(22));
		pnlTienCoc.add(txtTienCoc);
		// =================================================
		pnlTTDatBan.add(Box.createVerticalStrut(10));
		pnlTTDatBan.add(pnlSDDatBan);

		pnlTTDatBan.add(Box.createVerticalStrut(10));
		pnlTTDatBan.add(pnlNhanVien);
		pnlTTDatBan.add(Box.createVerticalStrut(10));
		pnlTTDatBan.add(pnlViTriBan);
		pnlTTDatBan.add(Box.createVerticalStrut(10));
		pnlTTDatBan.add(pnlGioDen);
		pnlTTDatBan.add(Box.createVerticalStrut(10));
		pnlTTDatBan.add(pnlTienCoc);

		/*
		 * Panel Gọi món
		 */
		pnlGoiMon = new JPanel();
		pnlGoiMon.setLayout(new BoxLayout(pnlGoiMon, BoxLayout.Y_AXIS));
		pnlGoiMon.setBackground(backgroundColor);
		pnlGoiMon.setPreferredSize(new Dimension(30, 500));

		pnlSearchMonAn = new JPanel();
		pnlSearchMonAn.setBackground(backgroundColor);
		pnlSearchMonAn.setLayout(new BoxLayout(pnlSearchMonAn, BoxLayout.X_AXIS));
		pnlSearchMonAn.setPreferredSize(new Dimension(100, 10));

		txtTimMon = new JTextField();
		txtTimMon.setFont(txtFieldFont);
		btnTimMon = new JButton("TÌM MÓN");
		btnTimMon.setBackground(Color.green);
		pnlSearchMonAn.add(txtTimMon);
		pnlSearchMonAn.add(btnTimMon);

		String[] columnNames = { "STT", "Tên", "Đơn giá", "Hình ảnh" };
		MonAnDAO monAnDAO = new MonAnDAO();
		List<MonAn> listMonAns = monAnDAO.getAllMonAn();
		Object[][] data = new Object[listMonAns.size()][columnNames.length];

		for (int i = 0; i < listMonAns.size(); i++) {
			MonAn monAn = listMonAns.get(i);
			data[i][0] = monAn.getMaMon(); // STT
			data[i][1] = monAn.getTenMon(); // Tên
			data[i][2] = monAn.getGiaTien(); // Đơn giá
			data[i][3] = "X"; // Nút đặt sẽ được thêm sau
		}

		// Tạo model cho bảng
		model = new DefaultTableModel(data, columnNames);
		table = new JTable(model);
		// Đặt màu nền cho toàn bộ bảng
		table.setBackground(Color.white);
		table.setForeground(Color.red); // Màu chữ
		table.setFont(txtFieldFont);
		table.setRowHeight(30);

		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Montserrat", Font.BOLD, 16)); // Font cho tiêu đề
		header.setBackground(Color.LIGHT_GRAY); // Màu nền cho tiêu đề

		table.getColumnModel().getColumn(0).setPreferredWidth(1);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);

		// Thêm bảng vào cuộn
		scrollPane = new JScrollPane(table);
		scrollPane.setBackground(Color.white);
		scrollPane.setPreferredSize(new Dimension(800, 500));

		pnlButtonDatMon = new JPanel();
		pnlButtonDatMon.setLayout(new BoxLayout(pnlButtonDatMon, BoxLayout.X_AXIS));
		pnlButtonDatMon.setBackground(backgroundColor);

		btnThemMon = new JButton("THÊM");
		btnThemMon.setBackground(Color.GREEN);

		btnKhaiVi = new JButton("KHAI VỊ");
		btnKhaiVi.setBackground(Color.white);
		btnAll = new JButton("TẤT CẢ");
		btnAll.setBackground(Color.BLUE);
		btnNuoc = new JButton("NƯỚC");
		btnNuoc.setBackground(Color.white);
		btnMonChinh = new JButton("MÓN CHÍNH");
		btnMonChinh.setBackground(Color.white);

		pnlButtonDatMon.add(btnAll);
		pnlButtonDatMon.add(btnKhaiVi);
		pnlButtonDatMon.add(btnNuoc);
		pnlButtonDatMon.add(btnMonChinh);
		pnlButtonDatMon.add(Box.createHorizontalStrut(105));
		pnlButtonDatMon.add(btnThemMon);

		pnlGoiMon.add(Box.createVerticalStrut(10));
		pnlGoiMon.add(pnlSearchMonAn);
		pnlGoiMon.add(Box.createVerticalStrut(10));
		pnlGoiMon.add(scrollPane);
		pnlGoiMon.add(Box.createVerticalStrut(20));
		pnlGoiMon.add(pnlButtonDatMon);
		pnlGoiMon.add(Box.createVerticalStrut(20));

		/*
		 * PANEL MÓN ĂN: LIST CÁC MÓN ĂN KHÁCH HÀNG ORDER KHI ĐẶT BÀN
		 * //=======================
		 * 
		 **/
		pnlListMon = new JPanel();
		pnlListMon.setLayout(new BorderLayout());
		// JButton btnThemMon = new JButton("THÊM");
		pnlListMon.setPreferredSize(new Dimension(500, 800));
		pnlListMon.setBackground(new Color(0, 200, 200));
		// pnlListMon.add(btnThemMon);
		pnlListMon.setBorder(BorderFactory.createLineBorder(Color.white));

		pnlListMon.setBorder(new TitledBorder("MÓN ĐÃ ĐẶT"));

		// ===============Table để load dữ liệu món ăn đã đặt của khách hàng
		// =======================
		String[] columnNamesTinhTien = { "STT","Mã Món", "Tên", "Đơn giá", "Số lượng", "Thành tiền" };
		Object[][] dataTinhTien = {

		};

		// Tạo model cho bảng
		modelTinhTien = new DefaultTableModel(dataTinhTien, columnNamesTinhTien);
		tableTinhTien = new JTable(modelTinhTien);
		tableTinhTien.setBackground(Color.white);
		tableTinhTien.setForeground(Color.blue); // Màu chữ
		tableTinhTien.setFont(txtFieldFont);
		tableTinhTien.setRowHeight(30);

		tableTinhTien.getColumnModel().getColumn(0).setPreferredWidth(5);
		tableTinhTien.getColumnModel().getColumn(1).setPreferredWidth(5);
		tableTinhTien.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableTinhTien.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableTinhTien.getColumnModel().getColumn(4).setPreferredWidth(50);
		tableTinhTien.getColumnModel().getColumn(5).setPreferredWidth(50);

		// Thêm bảng vào cuộn
		scrollPaneTinhTien = new JScrollPane(tableTinhTien);
		pnlListMon.add(scrollPaneTinhTien, BorderLayout.CENTER);

		// ============================ADD 2 PANEL TT KHÁCH HÀNG + TT ĐẶT BÀN VÀO PANEL
		// CENTER=======================
		pnlThongTinPhieu = new JPanel();
		pnlThongTinPhieu.setLayout(new BoxLayout(pnlThongTinPhieu, BoxLayout.X_AXIS));
		pnlThongTinPhieu.setBackground(backgroundColor);
		pnlThongTinPhieu.add(pnlTTKhachHang);
		pnlThongTinPhieu.add(Box.createHorizontalStrut(20));
		pnlThongTinPhieu.add(pnlTTDatBan);

		pnlYYY = new JPanel();
		pnlYYY.setLayout(new BoxLayout(pnlYYY, BoxLayout.Y_AXIS));
		pnlYYY.setBackground(backgroundColor);

		pnlYYY.add(pnlThongTinPhieu);
		pnlYYY.add(Box.createVerticalStrut(20));
		pnlYYY.add(pnlListMon);
		pnlYYY.add(Box.createVerticalStrut(20));

		pnlInfor.add(Box.createHorizontalStrut(10));
		pnlInfor.add(pnlYYY);
		pnlInfor.add(Box.createHorizontalStrut(20));
		pnlInfor.add(pnlGoiMon);
		pnlInfor.add(Box.createHorizontalStrut(10));

		// ===============================================
		pnlButton = new JPanel();
		pnlButton.setLayout(new BoxLayout(pnlButton, BoxLayout.X_AXIS));
		pnlButton.setBackground(backgroundColor);
		btnDatBan = new JButton("ĐẶT BÀN");
		btnDatBan.setBackground(new Color(0, 255, 0));
		btnDatBan.setMaximumSize(new Dimension(200, 100));

		btnDatIn = new JButton("ĐẶT & IN PHIẾU");
		btnDatIn.setBackground(new Color(0, 255, 0));
		btnDatIn.setMaximumSize(new Dimension(200, 100));

		btnBack = new JButton("TRỞ LẠI");
		btnBack.setMaximumSize(new Dimension(200, 100));
		btnBack.setBackground(new Color(255, 0, 0));

		btnLamMoi = new JButton("LÀM MỚI");
		btnLamMoi.setMaximumSize(new Dimension(200, 100));
		btnLamMoi.setBackground(new Color(0, 255, 0));
		btnLamMoi.addActionListener(e -> {
			txtSDT.setText("");
			txtSDT.setEditable(true);
			txtSDT.setBackground(whiteColor);

			txtTenKH.setText("");
			txtTenKH.setEditable(true);
			txtTenKH.setBackground(whiteColor);

			txtDiaChi.setText("");
			txtDiaChi.setEditable(true);
			txtDiaChi.setBackground(whiteColor);

			txtEmail.setText("");
			txtEmail.setEditable(true);
			txtEmail.setBackground(whiteColor);
		});

		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.addActionListener(e -> {
			this.dispose();
			FormManHinhChinh newFrManHinhChinh = new FormManHinhChinh(nhanVien);
			newFrManHinhChinh.setVisible(true);

		});
		btnThemMon.addActionListener(e -> {
			int selectedRow = table.getSelectedRow();
			if (selectedRow != -1) {
				// Lấy thông tin món ăn đã chọn
				Object maMon = model.getValueAt(selectedRow, 0); // STT
				Object tenMon = model.getValueAt(selectedRow, 1); // Tên
				Object giaTien = model.getValueAt(selectedRow, 2); // Đơn giá

				// Để số lượng mặc định là 1 (hoặc có thể thêm hộp thoại cho phép nhập số lượng)
				int soLuong = 1;
				float tienCoc = Float.parseFloat(txtTienCoc.getText());
				float thanhTien = (float) giaTien * soLuong;

				// Thêm vào bảng món đã đặt
				
				modelTinhTien.addRow(new Object[] { modelTinhTien.getRowCount() + 1,maMon, tenMon, giaTien, soLuong, thanhTien });

				// Có thể cập nhật tổng tiền nếu cần
				// Cập nhật lại tổng tiền ở đây nếu bạn có một ô để hiển thị tổng tiền
			} else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn món ăn để thêm!");
			}
		});

		btnDatBan.addActionListener(e -> {
			// Kiểm tra số điện thoại và tên không được để trống
			if (!isValidString(txtSDT.getText()) || !isValidString(txtTenKH.getText())) {
				JOptionPane.showMessageDialog(this, "Số điện thoại và tên không được để trống");
			} else if (!isValidPhoneNumber(txtSDT.getText())) {
				// Kiểm tra định dạng số điện thoại
				JOptionPane.showMessageDialog(this, "Số điện thoại sai định dạng");
			} else if (!isValidFullName(txtTenKH.getText())) {
				// Kiểm tra định dạng tên
				JOptionPane.showMessageDialog(this, "Tên sai định dạng");
			} else if (!txtEmail.getText().isEmpty() && !isValidEmail(txtEmail.getText())) {
				// Nếu email không rỗng thì kiểm tra định dạng
				JOptionPane.showMessageDialog(this, "Email sai định dạng");
			} else {
				// Nếu tất cả đều hợp lệ
				if (radioBtnDungSau.isSelected()) {

					if (radioBtnKHMoi.isSelected()) {
						// Khách hàng mới đặt bàn:

						if (kiemTraNgayDat(dateChooserNgayDen)) {
							if (themKhachHang(txtTenKH.getText(), txtSDT.getText(), txtEmail.getText(),
									txtDiaChi.getText())) {
								int maPhieu = themPhieuDatBan(comboBoxGio, comboBoxPhut, txtSDT.getText(),
										(int) comboBoxBan.getSelectedItem(), nhanVien, false);
								// Thêm chi tiết phiếu nữa là OK
								for (int i = 0; i < modelTinhTien.getRowCount(); i++) {
								    int maMon = (int) modelTinhTien.getValueAt(i, 1); // Mã món
								    float donGia = (float) modelTinhTien.getValueAt(i, 3);
								    int soLuong = (int) modelTinhTien.getValueAt(i, 4); // Số lượng
								    float thanhTien = (float) modelTinhTien.getValueAt(i, 5); // Thành tiền
								    Float tienCoc = Float.parseFloat(txtTienCoc.getText());
								    
								    ChiTietPhieuDatBan_DAO chiTietPhieuDatBan_DAO = new ChiTietPhieuDatBan_DAO();
								    ChiTietPhieuDatBan chiTietPhieuDatBan = new ChiTietPhieuDatBan(donGia, soLuong, tienCoc, thanhTien, new MonAnDAO().getMonAnTheoMa(maMon), new PhieuDatBan_DAO().getPhieuDatBanTheoMa(maPhieu));
								    
								    chiTietPhieuDatBan_DAO.themChiTietPhieuDatBan(chiTietPhieuDatBan);  
								}
								JOptionPane.showMessageDialog(this, "THÊM KHÁCH HÀNG & ĐẶT BÀN THÀNH CÔNG");
								new FormManHinhChinh(nhanVien);
							} else {
								JOptionPane.showMessageDialog(this, "SỐ ĐIỆN THOẠI ĐÃ ĐƯỢC ĐĂNG KÝ");
							}

						} else {
							JOptionPane.showMessageDialog(this, "VUI LÒNG CHỌN MỘT NGÀY!!!");
						}

					} else if (radioBtnKHVangLai.isSelected()) {
						// khách vãng lai không thể đặt bàn dùng sau được
						JOptionPane.showMessageDialog(null, "KHÁCH VÃNG LAI KHÔNG THỂ ĐẶT BÀN DÙNG SAU", "CẢNH BÁO",
								JOptionPane.WARNING_MESSAGE);
					} else {
						// Khách hàng cũ đặt bàn
						// Thêm phiếu đặt bàn
						if (kiemTraNgayDat(dateChooserNgayDen)) {
							int maPhieu =  themPhieuDatBan(comboBoxGio, comboBoxPhut, txtSDT.getText(),
									(int) comboBoxBan.getSelectedItem(), nhanVien, false);
							
							 for (int i = 0; i < modelTinhTien.getRowCount(); i++) {
								    int maMon = (int) modelTinhTien.getValueAt(i, 1); // Mã món
								    float donGia = (float) modelTinhTien.getValueAt(i, 3);
								    int soLuong = (int) modelTinhTien.getValueAt(i, 4); // Số lượng
								    float thanhTien = (float) modelTinhTien.getValueAt(i, 5); // Thành tiền
								    Float tienCoc = Float.parseFloat(txtTienCoc.getText());
								    
								    ChiTietPhieuDatBan_DAO chiTietPhieuDatBan_DAO = new ChiTietPhieuDatBan_DAO();
								    ChiTietPhieuDatBan chiTietPhieuDatBan = new ChiTietPhieuDatBan(donGia, soLuong, tienCoc, thanhTien, new MonAnDAO().getMonAnTheoMa(maMon), new PhieuDatBan_DAO().getPhieuDatBanTheoMa(maPhieu));
								    
								    chiTietPhieuDatBan_DAO.themChiTietPhieuDatBan(chiTietPhieuDatBan);  
							}
							
						} else {
							JOptionPane.showMessageDialog(this, "VUI LÒNG CHỌN MỘT NGÀY!!!");
						}
						
						

					}
				} else if (radioBtnSuDungNgay.isSelected()) {
					if (radioBtnKHMoi.isSelected()) {
						// Khách hàng mới đặt bàn:
						DAO_KhachHang dao_KhachHang = new DAO_KhachHang();
						KhachHang khachHangMoi = new KhachHang(0, txtTenKH.getText(), txtSDT.getText(),
								txtEmail.getText(), txtDiaChi.getText());
						dao_KhachHang.addKhachHang(khachHangMoi);
						// thêm phiếu, thêm chi tiết phiếu
						themPhieuDatBan(comboBoxGio, comboBoxPhut, txtSDT.getText(),
								(int) comboBoxBan.getSelectedItem(), nhanVien, true);
						// cập nhật trạng thái bàn
						capNhatTrangThaiBanBySelectedItem(comboBoxBan);
					} else if (radioBtnKHVangLai.isSelected()) {
						// Khách vãng lai đặt bàn,

						// thêm phiếu, thêm chi tiết phiếu
						themPhieuDatBan(comboBoxGio, comboBoxPhut, txtSDT.getText(),
								(int) comboBoxBan.getSelectedItem(), nhanVien, true);
						capNhatTrangThaiBanBySelectedItem(comboBoxBan);
					} else {
						// Khách hàng cũ đặt bàn
					

					}

				}

				// Cập nhật trạng thái bàn

			}
		});

		pnlButton.add(Box.createHorizontalStrut(10));
		pnlButton.add(btnBack);
		pnlButton.add(Box.createHorizontalStrut(10));
		pnlButton.add(btnLamMoi);
		pnlButton.add(Box.createHorizontalStrut(10));
		pnlButton.add(btnDatBan);
		pnlButton.add(Box.createHorizontalStrut(10));
		pnlButton.add(btnDatIn);

		pnlButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

		// Add vào ContentPane
		panelDatBan = new JPanel();
		panelDatBan.setLayout(new BorderLayout());
		panelDatBan.setBackground(whiteLight);
		panelDatBan.setBackground(backgroundColor);
		panelDatBan.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelDatBan.add(pnlHeader, BorderLayout.NORTH);
		panelDatBan.add(pnlInfor, BorderLayout.CENTER);
		panelDatBan.add(pnlButton, BorderLayout.SOUTH);

		getContentPane().add(panelDatBan);
		getContentPane().setBackground(backgroundColor);

	}

	private void getDataToComboBox(JComboBox<String> cbbKhuVuc, JComboBox<Integer> cbbBan,
			JComboBox<Integer> cbbSoKhach, String khuVuc, int maBan) {

		DAO_KhuVuc dao_KhuVuc = new DAO_KhuVuc();
		List<KhuVuc> listKhuVuc = new ArrayList<KhuVuc>();
		listKhuVuc = dao_KhuVuc.getKhuVuc();

		List<String> listTenKV = new ArrayList<String>();
		for (KhuVuc kVuc : listKhuVuc) {
			listTenKV.add(kVuc.getTenKhuVuc());
		}
		// System.out.println(listTenKV);
		for (String tenKV : listTenKV) {
			cbbKhuVuc.addItem(tenKV);
		}
		cbbKhuVuc.setSelectedItem(khuVuc);
		DAO_Ban daoBan = new DAO_Ban();
		List<Ban> bans = daoBan.getBansByKhuVuc((String) cbbKhuVuc.getSelectedItem());

		for (Ban ban : bans) {
			cbbBan.addItem(ban.getMaBan());
		}
		cbbBan.setSelectedItem(maBan);

		DAO_Ban dao_Ban = new DAO_Ban();
		int soGhe = dao_Ban.getSoGheByMaBan(maBan);
		for (int i = 1; i <= soGhe; i++) {
			cbbSoKhach.addItem(i);
		}

	}
//
//	private void handleCBBSoLuong(JComboBox<Integer> cbbBan, JComboBox<Integer> cbbSoKhach) {
//		if(cbbBan!= null) {
//			if(cbbSoKhach != null){
//				cbbSoKhach.removeAllItems();
//				DAO_Ban dao_Ban = new DAO_Ban();
//				int soGhe = dao_Ban.getSoGheByMaBan((Integer) cbbBan.getSelectedItem());
//				for (int i = 1; i <= soGhe; i++) {
//					cbbSoKhach.addItem(i);
//				}
//			}
//		}
//	}
//	

	private float getTienCoc(int maBan, int soLuongKhach) {
		float tienCoc = (float) 0.0;
		DAO_Ban dao_Ban = new DAO_Ban();
		int soGhe = dao_Ban.getSoGheByMaBan(maBan);

		if (soGhe <= 4) {
			tienCoc = (float) (soGhe * (50000.0) + soLuongKhach * (100000.0));
		} else if (soGhe <= 10) {
			tienCoc = (float) (soGhe * 50000.0 + soLuongKhach * 120000.0);
		} else if (soGhe > 10) {
			tienCoc = (float) (soGhe * 50000.0 + soLuongKhach * 140000.0);
		}
		return tienCoc;

	}

	private void updateTienCoc() {
		if (comboBoxBan.getSelectedItem() != null && comboBoxSLKhach.getSelectedItem() != null) {
			int maBan = (Integer) comboBoxBan.getSelectedItem();
			int soKhach = (Integer) comboBoxSLKhach.getSelectedItem();
			float tienCocTam = getTienCoc(maBan, soKhach);
			txtTienCoc.setText(String.valueOf(tienCocTam));
		}
	}

	public boolean isValidString(String input) {
		return input != null && !input.trim().isEmpty();
	}

	public boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		Pattern pattern = Pattern.compile(emailRegex);
		return pattern.matcher(email).matches();
	}

	public boolean isValidPhoneNumber(String phoneNumber) {
		String regex = "^\\d{10}$";
		return Pattern.matches(regex, phoneNumber);
	}

	public boolean isValidFullName(String fullName) {

		String regex = "^[\\p{L} .'-]+$";
		return Pattern.matches(regex, fullName);
	}

	public void capNhatTrangThaiBanBySelectedItem(JComboBox<Integer> comboBoxBan) {
		DAO_Ban dao_Ban = new DAO_Ban();
		if (dao_Ban.capNhatTrangThaiBanById((int) comboBoxBan.getSelectedItem(), true)) {
			dispose();
			FormManHinhChinh newFrManHinhChinh = new FormManHinhChinh(nhanVien);
			newFrManHinhChinh.setVisible(true);
		}
	}

	private boolean themKhachHang(String tenKH, String sDT, String email, String diaChi) {
		DAO_KhachHang dao_KhachHang = new DAO_KhachHang();
		KhachHang khachHangMoi = new KhachHang(0, tenKH, sDT, email, diaChi);
		if (dao_KhachHang.addKhachHang(khachHangMoi)) {
			return true;
		}
		return false;

	}

	private int themPhieuDatBan(JComboBox<Integer> comboBoxGio, JComboBox<Integer> comboBoxPhut, String sdtKhachHang,
			Integer maBanDat, NhanVien nhanVien, boolean dungNgay) {

		LocalDateTime hienTaiDateTime = LocalDateTime.now();

		// Lay thong tin thoi gian dat ban của khách hàng
		java.util.Date selectedDate = dateChooserNgayDen.getDate();
		LocalDateTime gioDat;
		if (!dungNgay) {
			gioDat = LocalDateTime.ofInstant(selectedDate.toInstant(), java.time.ZoneId.systemDefault());
			// Lấy giờ và phút từ JComboBox
			int selectedHour = (Integer) comboBoxGio.getSelectedItem();
			int selectedMinute = (Integer) comboBoxPhut.getSelectedItem();

			gioDat = gioDat.withHour(selectedHour).withMinute(selectedMinute);

		} else {
			gioDat = hienTaiDateTime;
		}

		// Lấy thông tin khách hàng đã đặt
		DAO_KhachHang dao_KhachHang = new DAO_KhachHang();
		KhachHang khachHangDat = new KhachHang();
		khachHangDat = dao_KhachHang.getKhachHangBySDT(sdtKhachHang);

		// Lấy thông tin bàn đã đặt
		DAO_Ban dao_Ban = new DAO_Ban();
		Ban banDat = dao_Ban.getBanById(maBanDat);

		// Thêm phiếu đặt bàn
		PhieuDatBan_DAO phieuDatBan_DAO = new PhieuDatBan_DAO();
		PhieuDatBan phieuDatBan = new PhieuDatBan(hienTaiDateTime, gioDat, khachHangDat, nhanVien, banDat);
		 return phieuDatBan_DAO.themPhieuDatBan(phieuDatBan);
//		JOptionPane.showMessageDialog(this, "ĐẶT BÀN THÀNH CÔNG");
	}

	private boolean kiemTraNgayDat(JDateChooser dateChooserNgayDen) {
		java.util.Date selectedDate = dateChooserNgayDen.getDate();
		if (selectedDate != null) {
			return true;
		}
		return false;
	}
	private void themChiTietPhieu(ChiTietPhieuDatBan chiTiet) {
	    ChiTietPhieuDatBan_DAO chiTietPhieuDatBan_DAO = new ChiTietPhieuDatBan_DAO();
	    
	    boolean result = chiTietPhieuDatBan_DAO.themChiTietPhieuDatBan(chiTiet);
	    if (result) {
	        JOptionPane.showMessageDialog(null, "Thêm chi tiết phiếu thành công!");
	    } else {
	        JOptionPane.showMessageDialog(null, "Thêm chi tiết phiếu không thành công!");
	    }
	    
	    
	   
	    
	}

}
