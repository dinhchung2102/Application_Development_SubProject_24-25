package gui;

import static org.junit.Assert.fail;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import dao.DAO_Ban;
import dao.DAO_KhachHang;
import dao.DAO_KhuVuc;
import dao.MonAnDAO;
import dao.NhanVien_DAO;
import dao.PhieuDatBan_DAO;
import entity.Ban;
import entity.KhachHang;
import entity.KhuVuc;
import entity.MonAn;
import entity.NhanVien;
import entity.PhieuDatBan;
import entity.TaiKhoan;

public class FormDatBan extends FormMenu {
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
	private JComboBox comboBoxSLKhach;
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

	public FormDatBan(Integer maBan, String khuVuc, NhanVien nhanVien) {
		this.nhanVien = nhanVien;
		
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
		
		
		radioBtnKHVangLai.addActionListener(e->{
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

		getDataToComboBox(comboBoxKhuVuc, comboBoxBan, maBan, khuVuc);
		comboBoxKhuVuc.setSelectedItem(khuVuc);
		comboBoxBan.setSelectedItem(maBan);

		pnlViTriBan.add(lblKhuVuc);
		pnlViTriBan.add(Box.createHorizontalStrut(25));
		pnlViTriBan.add(comboBoxKhuVuc);
		pnlViTriBan.add(lblBan);
		pnlViTriBan.add(comboBoxBan);

		lblSoKhach = new JLabel("SỐ LƯỢNG: ");
		lblSoKhach.setFont(txtFieldFont);
		comboBoxSLKhach = new JComboBox<>();
		comboBoxSLKhach.setPreferredSize(new Dimension(60, 30));
		comboBoxSLKhach.setBackground(backgroundColor);
		comboBoxSLKhach.setBackground(whiteColor);
		comboBoxSLKhach.setFont(txtFieldFont);
		handleCBBSoLuong(comboBoxBan, comboBoxSLKhach);

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

//		Timer timer = new Timer(1000, e -> {
//			LocalDateTime currentDateTime = LocalDateTime.now(); // Lấy ngày và giờ hiện tại
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Định dạng ngày giờ
//			String formattedDateTime = currentDateTime.format(formatter); // Định dạng thành chuỗi
//			txtGioDen.setText(formattedDateTime); // Cập nhật JTextField
//		});
//		timer.start(); // Bắt đầu Timer

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
		getTienCoc(maBan, (int) comboBoxSLKhach.getSelectedItem(), txtTienCoc);
		
		// ==============================ACTION LISTENER/[[[[]]]]PANEL TT DAT
		// BAN========================
		comboBoxBan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				handleCBBSoLuong(comboBoxBan, comboBoxSLKhach);
				getTienCoc((int) comboBoxBan.getSelectedItem(), (int) comboBoxSLKhach.getSelectedItem(), txtTienCoc);

			}
		});
		comboBoxSLKhach.addActionListener(e -> {
			getTienCoc((int) comboBoxBan.getSelectedItem(), (int) comboBoxSLKhach.getSelectedItem(), txtTienCoc);
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
		pnlSearchMonAn.setLayout(new BoxLayout(pnlSearchMonAn, BoxLayout.X_AXIS));
		pnlSearchMonAn.setPreferredSize(new Dimension(100, 10));
		
		txtTimMon = new JTextField();
		txtTimMon.setFont(txtFieldFont);
		btnTimMon = new JButton("TÌM MÓN");
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
		scrollPane.setPreferredSize(new Dimension(500, 300));
		
		pnlButtonDatMon = new JPanel();
		pnlButtonDatMon.setLayout(new BoxLayout(pnlButtonDatMon, BoxLayout.X_AXIS));
		
		btnThemMon = new JButton("THÊM");
		pnlButtonDatMon.add(btnThemMon);
		
		pnlGoiMon.add(Box.createVerticalStrut(10));
		pnlGoiMon.add(pnlSearchMonAn);
		pnlGoiMon.add(Box.createVerticalStrut(10));
		pnlGoiMon.add(scrollPane);
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
		String[] columnNamesTinhTien = { "STT", "Tên", "Đơn giá", "Số lượng", "Thành tiền" };
		Object[][] dataTinhTien = {
				
		};

		// Tạo model cho bảng
		modelTinhTien = new DefaultTableModel(dataTinhTien, columnNamesTinhTien);
		tableTinhTien = new JTable(modelTinhTien);

		tableTinhTien.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableTinhTien.getColumnModel().getColumn(3).setPreferredWidth(20);

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
			new FormManHinhChinh(nhanVien);
			dispose();
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
		                // thêm khách hàng
		                DAO_KhachHang dao_KhachHang = new DAO_KhachHang();
		                KhachHang khachHangMoi = new KhachHang(0, txtTenKH.getText(), txtSDT.getText(), txtEmail.getText(), txtDiaChi.getText());
		                dao_KhachHang.addKhachHang(khachHangMoi);
		                // thêm phiếu, thêm chi tiết phiếu	
		                
		                LocalDateTime hienTaiDateTime = LocalDateTime.now();
		                PhieuDatBan_DAO phieuDatBan_DAO = new PhieuDatBan_DAO();
		                
		                //Lay thong tin thoi gian dat ban của khách hàng
		                java.util.Date selectedDate = dateChooserNgayDen.getDate();
		                LocalDateTime gioDat = LocalDateTime.ofInstant(selectedDate.toInstant(), java.time.ZoneId.systemDefault());

		                // Lấy giờ và phút từ JComboBox
		                int selectedHour = Integer.parseInt((String) comboBoxGio.getSelectedItem());
		                int selectedMinute = Integer.parseInt((String) comboBoxPhut.getSelectedItem());

		                // Gán giờ và phút
		                gioDat = gioDat.withHour(selectedHour).withMinute(selectedMinute);
		                
		                //Lấy thông tin khách hàng đã đặt
		                KhachHang khachHangDat = dao_KhachHang.getKhachHangBySDT(txtSDT.getText()); 
		                dao_KhachHang.getKhachHangBySDT(khachHangMoi.getSoDT());
		                
		                //Lấy thông tin bàn đã đặt
		                DAO_Ban dao_Ban = new DAO_Ban();
		                Ban banDat = dao_Ban.getBanById((int) comboBoxBan.getSelectedItem());
		                
		                //Thêm phiếu đặt bàn
		                PhieuDatBan phieuDatBan = new PhieuDatBan(hienTaiDateTime, gioDat, khachHangDat, nhanVien, banDat  );
		                phieuDatBan_DAO.themPhieuDatBan(phieuDatBan);
		                
		                
		               
		            } else if (radioBtnKHVangLai.isSelected()) {
		                // Khách vãng lai đặt bàn, 
		                // thêm phiếu, thêm chi tiết phiếu
// thêm phiếu, thêm chi tiết phiếu	
		                
		                LocalDateTime hienTaiDateTime = LocalDateTime.now();
		                PhieuDatBan_DAO phieuDatBan_DAO = new PhieuDatBan_DAO();
		                
		                //Lay thong tin thoi gian dat ban của khách hàng
		                java.util.Date selectedDate = dateChooserNgayDen.getDate();
		                LocalDateTime gioDat = LocalDateTime.ofInstant(selectedDate.toInstant(), java.time.ZoneId.systemDefault());

		                // Lấy giờ và phút từ JComboBox
		                int selectedHour = (Integer) comboBoxGio.getSelectedItem();
		                int selectedMinute = (Integer) comboBoxPhut.getSelectedItem();

		                // Gán giờ và phút
		                gioDat = gioDat.withHour(selectedHour).withMinute(selectedMinute);
		                
		                //Lấy thông tin khách hàng đã đặt
		                DAO_KhachHang dao_KhachHang = new DAO_KhachHang();
		                KhachHang khachHangDat = dao_KhachHang.getKhachHangBySDT(txtSDT.getText());
		                
		    
		                
		                //Lấy thông tin bàn đã đặt
		                DAO_Ban dao_Ban = new DAO_Ban();
		                Ban banDat = dao_Ban.getBanById((int) comboBoxBan.getSelectedItem());
		                
		                //Thêm phiếu đặt bàn
		                PhieuDatBan phieuDatBan = new PhieuDatBan(hienTaiDateTime, gioDat, khachHangDat, nhanVien, banDat);
		                phieuDatBan_DAO.themPhieuDatBan(phieuDatBan);
		            	
		            } else {
		                // Khách hàng cũ đặt bàn
		            	PhieuDatBan_DAO phieuDatBan_DAO = new PhieuDatBan_DAO();
		            	
		                // thêm phiếu, thêm chi tiết phiếu, TT
		            }
		        } else if (radioBtnSuDungNgay.isSelected()) {
		            if (radioBtnKHMoi.isSelected()) {
		                // Khách hàng mới đặt bàn: 
		                DAO_KhachHang dao_KhachHang = new DAO_KhachHang();
		                KhachHang khachHangMoi = new KhachHang(0, txtTenKH.getText(), txtSDT.getText(), txtEmail.getText(), txtDiaChi.getText());
		                dao_KhachHang.addKhachHang(khachHangMoi);
		                // thêm phiếu, thêm chi tiết phiếu
		            } else if (radioBtnKHVangLai.isSelected()) {
		                // Khách vãng lai đặt bàn, 
		                // thêm phiếu, thêm chi tiết phiếu
		            } else {
		                // Khách hàng cũ đặt bàn

		                
//		                rivate int maPhieuDatBan;
//		            	private Date ngayTaoPhieu;
//		            	private LocalDateTime thoiGianDatBan;
//		            	private KhachHang khachHang;
//		            	private NhanVien nhanVien;
//		            	private Ban ban;
		            	//Thêm phiếu đặt bàn:
		            	
		                // thêm phiếu, thêm chi tiết phiếu, TT
		            }
		        }
		        
		        // Cập nhật trạng thái bàn
		        DAO_Ban dao_Ban = new DAO_Ban();
		        if (dao_Ban.capNhatTrangThaiBanById((int)comboBoxBan.getSelectedItem(), true)) {
		            JOptionPane.showMessageDialog(this, "Đã đặt bàn thành công");
		            this.dispose();
		            new FormManHinhChinh(nhanVien);
		        }
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

	private void getDataToComboBox(JComboBox<String> cbbKhuVuc, JComboBox<Integer> cbbBan, Integer maBan,
			String khuVuc) {

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
		cbbKhuVuc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cbbBan.removeAllItems();

				DAO_Ban daoBan = new DAO_Ban();
				List<Ban> bans = daoBan.getBansByKhuVuc(cbbKhuVuc.getSelectedItem().toString());

				for (Ban ban : bans) {
					cbbBan.addItem(ban.getMaBan());
				}

			}
		});

	}

	private void handleCBBSoLuong(JComboBox<Integer> cbbBan, JComboBox<Integer> cbbSoKhach) {
		cbbSoKhach.removeAllItems();
		DAO_Ban dao_Ban = new DAO_Ban();
		int soGhe = dao_Ban.getSoGheByMaBan((Integer) cbbBan.getSelectedItem());

		for (int i = 1; i <= soGhe; i++) {
			cbbSoKhach.addItem(i);
		}
	}

	private void getTienCoc(int maBan, int soLuongKhach, JTextField txtTienCoc) {
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
		txtTienCoc.setText(String.valueOf(tienCoc));

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

}
