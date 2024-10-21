package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.DAO_Ban;
import dao.DAO_KhachHang;
import dao.DAO_KhuVuc;
import entity.Ban;
import entity.KhachHang;
import entity.KhuVuc;

public class FormDatBan extends FormMenu {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FormDatBan(Integer maBan, String khuVuc) {

		Color whiteColor = new Color(255, 255, 255);
		Color whiteLight = new Color(250, 250, 250);
		Font txtFieldFont = new Font("Montserrat", Font.BOLD, 16);

		JPanel pnlHeader = new JPanel();
		JLabel lblHeader = new JLabel("THÊM MỚI ĐẶT BÀN");
		lblHeader.setFont(new Font("Montserrat", Font.BOLD, 40));
		pnlHeader.add(lblHeader);

		// Panel chứa thông tin thêm đặt bàn mới//
		JPanel pnlInfor = new JPanel();
		pnlInfor.setLayout(new BoxLayout(pnlInfor, BoxLayout.X_AXIS));

		/*
		 * Panel thông tin Khách hàng + Nhân viên : Boxlayout Y : << Box X>><<Box>>
		 */

		/*
		 * Panel thông tin khách hàng
		 */

		JPanel pnlTTKhachHang = new JPanel();
		pnlTTKhachHang.setLayout(new BoxLayout(pnlTTKhachHang, BoxLayout.Y_AXIS));
		pnlTTKhachHang.setPreferredSize(new Dimension(150, 300));

		// =====================TÌM SDT KHÁCH HÀNG==========================
		JPanel pnlSDT = new JPanel();
		pnlSDT.setLayout(new BoxLayout(pnlSDT, BoxLayout.X_AXIS));
		JLabel lblSDT = new JLabel("ĐIỆN THOẠI: ");
		lblSDT.setFont(txtFieldFont);
		JTextField txtSDT = new JTextField();
		txtSDT.setFont(txtFieldFont);
		JButton btnTimSDT = new JButton("TÌM");
		btnTimSDT.setPreferredSize(new Dimension(80, 10));
		btnTimSDT.setBackground(whiteColor);
		btnTimSDT.setFont(new Font("Montserrat", Font.BOLD, 20));

		pnlSDT.add(lblSDT);
		pnlSDT.add(Box.createHorizontalStrut(44));
		pnlSDT.add(txtSDT);
		pnlSDT.add(btnTimSDT);
		// =======================LOẠI KHÁCH HÀNG================================
		JPanel pnlLoaiKhachHang = new JPanel();
		pnlLoaiKhachHang.setLayout(new BoxLayout(pnlLoaiKhachHang, BoxLayout.X_AXIS));

		JLabel lblLoaiKH = new JLabel("KHÁCH HÀNG: ");
		lblLoaiKH.setFont(txtFieldFont);

		JRadioButton radioBtnKHMoi = new JRadioButton("MỚI");
		radioBtnKHMoi.setFont(txtFieldFont);
		radioBtnKHMoi.setSelected(true);

		JRadioButton radioBtnKHVangLai = new JRadioButton("VÃNG LAI");
		radioBtnKHVangLai.setFont(txtFieldFont);

		ButtonGroup groupRadioBtnLoaiKH = new ButtonGroup();
		groupRadioBtnLoaiKH.add(radioBtnKHMoi);
		groupRadioBtnLoaiKH.add(radioBtnKHVangLai);

		pnlLoaiKhachHang.add(lblLoaiKH);
		pnlLoaiKhachHang.add(Box.createHorizontalStrut(25));
		pnlLoaiKhachHang.add(radioBtnKHMoi);
		pnlLoaiKhachHang.add(Box.createHorizontalStrut(50));
		pnlLoaiKhachHang.add(radioBtnKHVangLai);
		pnlLoaiKhachHang.add(Box.createHorizontalStrut(135));

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

		JPanel pnlTenKH = new JPanel();
		pnlTenKH.setLayout(new BoxLayout(pnlTenKH, BoxLayout.X_AXIS));

		JLabel lblTenKH = new JLabel("HỌ TÊN: ");
		lblTenKH.setFont(txtFieldFont);
		JTextField txtTenKH = new JTextField();
		txtTenKH.setFont(txtFieldFont);
		txtTenKH.setBackground(whiteColor);

		pnlTenKH.add(lblTenKH);
		pnlTenKH.add(Box.createHorizontalStrut(73));
		pnlTenKH.add(txtTenKH);
		// =======================EMAIL========================================

		JPanel pnlEmail = new JPanel();
		pnlEmail.setLayout(new BoxLayout(pnlEmail, BoxLayout.X_AXIS));

		JLabel lblEmail = new JLabel("EMAIL: ");
		lblEmail.setFont(txtFieldFont);
		JTextField txtEmail = new JTextField();
		txtEmail.setFont(txtFieldFont);
		pnlEmail.add(lblEmail);
		pnlEmail.add(Box.createHorizontalStrut(84));
		pnlEmail.add(txtEmail);

		// =======================ĐỊA CHỈ KHÁCH HÀNG==========================

		JPanel pnlDiaChi = new JPanel();
		pnlDiaChi.setLayout(new BoxLayout(pnlDiaChi, BoxLayout.X_AXIS));
		JLabel lblDiaChi = new JLabel("ĐỊA CHỈ: ");
		lblDiaChi.setFont(txtFieldFont);
		JTextField txtDiaChi = new JTextField();
		txtDiaChi.setFont(txtFieldFont);
		pnlDiaChi.add(lblDiaChi);
		pnlDiaChi.add(Box.createHorizontalStrut(76));
		pnlDiaChi.add(txtDiaChi);
		// =====================ACTION PANEL THÔNG TIN KHÁCH HÀNG============
		btnTimSDT.addActionListener(e -> {

			DAO_KhachHang dao_KhachHang = new DAO_KhachHang();
			KhachHang khachHang = dao_KhachHang.getKhachHangBySDT(txtSDT.getText());

			if (khachHang == null) {
				JOptionPane.showMessageDialog(null, "Số điện thoại không tồn tại!!!");
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
		JPanel pnlTTDatBan = new JPanel();
		pnlTTDatBan.setLayout(new BoxLayout(pnlTTDatBan, BoxLayout.Y_AXIS));
		pnlTTDatBan.setPreferredSize(new Dimension(150, 300));
		// ======================THÔNG TIN NHÂN VIÊN===========================
		JPanel pnlNhanVien = new JPanel();
		pnlNhanVien.setLayout(new BoxLayout(pnlNhanVien, BoxLayout.X_AXIS));
		JLabel lblNhanVien = new JLabel("NHÂN VIÊN: ");
		lblNhanVien.setFont(txtFieldFont);
		JTextField txtNhanVien = new JTextField();
		txtNhanVien.setFont(txtFieldFont);
		txtNhanVien.setBackground(whiteLight);
		txtNhanVien.setEditable(false);
		txtNhanVien.setBackground(new Color(255, 255, 255));
		pnlNhanVien.add(lblNhanVien);
		pnlNhanVien.add(Box.createHorizontalStrut(14));
		pnlNhanVien.add(txtNhanVien);
		// ===========================SỬ DỤNG ĐẶT BÀN===============================
		JPanel pnlSDDatBan = new JPanel();
		pnlSDDatBan.setLayout(new BoxLayout(pnlSDDatBan, BoxLayout.X_AXIS));
		JRadioButton radioBtnSuDungNgay = new JRadioButton("SỬ DỤNG NGAY");
		radioBtnSuDungNgay.setFont(txtFieldFont);
		radioBtnSuDungNgay.setSelected(true);

		JRadioButton radioBtnDungSau = new JRadioButton("DÙNG SAU");
		radioBtnDungSau.setFont(txtFieldFont);

		ButtonGroup groupRadioBtnSuDung = new ButtonGroup();
		groupRadioBtnSuDung.add(radioBtnSuDungNgay);
		groupRadioBtnSuDung.add(radioBtnDungSau);

		pnlSDDatBan.add(Box.createHorizontalStrut(70));
		pnlSDDatBan.add(radioBtnSuDungNgay);
		pnlSDDatBan.add(Box.createHorizontalStrut(70));
		pnlSDDatBan.add(radioBtnDungSau);

		// ========================MÃ ĐẶT BÀN======================================
		JPanel pnlMaDatBan = new JPanel();
		pnlMaDatBan.setLayout(new BoxLayout(pnlMaDatBan, BoxLayout.X_AXIS));
		JLabel lblMaDatBan = new JLabel("MÃ ĐẶT BÀN: ");
		lblMaDatBan.setFont(txtFieldFont);
		JTextField txtMaDatBan = new JTextField();
		txtMaDatBan.setFont(txtFieldFont);
		txtMaDatBan.setEditable(false);
		txtMaDatBan.setBackground(whiteColor);
		pnlMaDatBan.add(lblMaDatBan);
		pnlMaDatBan.add(txtMaDatBan);
		// ==============================VỊ TRÍ BÀN ĐẶT ============================
		JPanel pnlViTriBan = new JPanel();
		pnlViTriBan.setLayout(new BoxLayout(pnlViTriBan, BoxLayout.X_AXIS));
		JLabel lblKhuVuc = new JLabel("KHU VỰC: ");
		lblKhuVuc.setFont(txtFieldFont);
		JComboBox<String> comboBoxKhuVuc = new JComboBox<String>();
		comboBoxKhuVuc.setBackground(whiteColor);
		comboBoxKhuVuc.setFont(txtFieldFont);

		JLabel lblBan = new JLabel("BÀN: ");
		lblBan.setFont(txtFieldFont);
		JComboBox<Integer> comboBoxBan = new JComboBox<Integer>();
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

		JLabel lblSoKhach = new JLabel("SỐ LƯỢNG: ");
		lblSoKhach.setFont(txtFieldFont);
		JComboBox<Integer> comboBoxSLKhach = new JComboBox<>();
		comboBoxSLKhach.setPreferredSize(new Dimension(60, 30));
		comboBoxSLKhach.setBackground(whiteColor);
		comboBoxSLKhach.setFont(txtFieldFont);
		handleCBBSoLuong(comboBoxBan, comboBoxSLKhach);

		pnlViTriBan.add(lblSoKhach);
		pnlViTriBan.add(comboBoxSLKhach);

		// =======================GIỜ ĐẾN ===============================

		JPanel pnlGioDen = new JPanel();
		pnlGioDen.setLayout(new BoxLayout(pnlGioDen, BoxLayout.X_AXIS));
		JLabel lblGioDen = new JLabel("GIỜ ĐẾN: ");
		lblGioDen.setFont(txtFieldFont);
		JTextField txtGioDen = new JTextField();
		txtGioDen.setFont(txtFieldFont);
		pnlGioDen.add(lblGioDen);
		pnlGioDen.add(Box.createHorizontalStrut(30));
		pnlGioDen.add(txtGioDen);

		Timer timer = new Timer(1000, e -> {
			LocalDateTime currentDateTime = LocalDateTime.now(); // Lấy ngày và giờ hiện tại
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Định dạng ngày giờ
			String formattedDateTime = currentDateTime.format(formatter); // Định dạng thành chuỗi
			txtGioDen.setText(formattedDateTime); // Cập nhật JTextField
		});
		timer.start(); // Bắt đầu Timer

		// ======================SỐ LƯỢNG KHÁCH===================
		// =================================TIỀN CỌC
		// ====================================
		JPanel pnlTienCoc = new JPanel();
		pnlTienCoc.setLayout(new BoxLayout(pnlTienCoc, BoxLayout.X_AXIS));
		JLabel lblTienCoc = new JLabel("TIỀN CỌC: ");
		lblTienCoc.setFont(txtFieldFont);
		JTextField txtTienCoc = new JTextField();
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
		JPanel pnlGoiMon = new JPanel();
		pnlGoiMon.setLayout(new BoxLayout(pnlGoiMon, BoxLayout.Y_AXIS));
		pnlGoiMon.setPreferredSize(new Dimension(500, 500));

		String[] columnNames = { "STT", "Tên", "Đơn giá", "Số lượng", "Thành tiền" };
		Object[][] data = {

		};

		// Tạo model cho bảng
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		JTable table = new JTable(model);

		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);

		// Thêm bảng vào cuộn
		JScrollPane scrollPane = new JScrollPane(table);
		pnlGoiMon.add(Box.createVerticalStrut(10));
		pnlGoiMon.add(scrollPane);
		pnlGoiMon.add(Box.createVerticalStrut(20));

		/*
		 * PANEL MÓN ĂN: LIST CÁC MÓN ĂN KHÁCH HÀNG ORDER KHI ĐẶT BÀN
		 * //=======================
		 * 
		 **/
		JPanel pnlListMon = new JPanel();
		pnlListMon.setLayout(new BorderLayout());
		// JButton btnThemMon = new JButton("THÊM");
		pnlListMon.setPreferredSize(new Dimension(500, 800));
		// pnlListMon.add(btnThemMon);
		pnlListMon.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		// ===============Table để load dữ liệu món ăn đã đặt của khách hàng
		// =======================
		String[] columnNamesTinhTien = { "STT", "Tên", "Đơn giá", "Số lượng", "Thành tiền" };
		Object[][] dataTinhTien = {

		};

		// Tạo model cho bảng
		DefaultTableModel modelTinhTien = new DefaultTableModel(dataTinhTien, columnNamesTinhTien);
		JTable tableTinhTien = new JTable(modelTinhTien);

		tableTinhTien.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableTinhTien.getColumnModel().getColumn(3).setPreferredWidth(20);

		// Thêm bảng vào cuộn
		JScrollPane scrollPaneTinhTien = new JScrollPane(tableTinhTien);
		pnlListMon.add(scrollPaneTinhTien, BorderLayout.CENTER);

		// ============================ADD 2 PANEL TT KHÁCH HÀNG + TT ĐẶT BÀN VÀO PANEL
		// CENTER=======================
		JPanel pnlThongTinPhieu = new JPanel();
		pnlThongTinPhieu.setLayout(new BoxLayout(pnlThongTinPhieu, BoxLayout.X_AXIS));
		pnlThongTinPhieu.add(pnlTTKhachHang);
		pnlThongTinPhieu.add(Box.createHorizontalStrut(20));
		pnlThongTinPhieu.add(pnlTTDatBan);
		JPanel pnlYYY = new JPanel();
		pnlYYY.setLayout(new BoxLayout(pnlYYY, BoxLayout.Y_AXIS));

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
		JPanel pnlButton = new JPanel();
		pnlButton.setLayout(new BoxLayout(pnlButton, BoxLayout.X_AXIS));
		JButton btnDatBan = new JButton("ĐẶT BÀN");
		btnDatBan.setBackground(new Color(0, 255, 0));
		btnDatBan.setMaximumSize(new Dimension(200, 100));

		JButton btnDatIn = new JButton("ĐẶT & IN PHIẾU");
		btnDatIn.setBackground(new Color(0, 255, 0));
		btnDatIn.setMaximumSize(new Dimension(200, 100));

		JButton btnBack = new JButton("TRỞ LẠI");
		btnBack.setMaximumSize(new Dimension(200, 100));
		btnBack.setBackground(new Color(255, 0, 0));

		JButton btnLamMoi = new JButton("LÀM MỚI");
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
			new FormManHinhChinh();
			dispose();
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
		JPanel panelDatBan = new JPanel();
		panelDatBan.setLayout(new BorderLayout());
		panelDatBan.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelDatBan.add(pnlHeader, BorderLayout.NORTH);
		panelDatBan.add(pnlInfor, BorderLayout.CENTER);
		panelDatBan.add(pnlButton, BorderLayout.SOUTH);

		getContentPane().add(panelDatBan);

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

}
