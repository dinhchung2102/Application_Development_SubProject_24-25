package gui;

import dao.MonAnDAO;
import entity.MonAn;
import entity.NhanVien;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MonAnGUI extends JFrame {
    private static final long serialVersionUID = 1L;

    private JButton addButton, deleteButton, updateButton, searchButton;
    private JTextField searchField, nameField, priceField, descriptionField;
    private JTable dishTable;
    private DefaultTableModel tableModel;
    
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

	private NhanVien nhanVien;

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */


    public MonAnGUI(NhanVien nhanVien) {
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
		
		JMenuItem mniManHinhChinhItem = new JMenuItem("Màn hình chính");
		mnuDatBan.add(mniManHinhChinhItem);
		
		mniManHinhChinhItem.addActionListener(e->{
			this.dispose();
			FormManHinhChinh newFormManHinhChinh = new FormManHinhChinh(nhanVien);
			newFormManHinhChinh.setVisible(true);
		});

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
		mniDSKhuyenMai.addActionListener(e->{
			this.dispose();
			KhuyenMaiGUI newKhuyenMaiGUI = new KhuyenMaiGUI(nhanVien);
			newKhuyenMaiGUI.setVisible(true);
		});

//		mniDSKhuyenMai.addActionListener(this);
//		mniThemKhuyenMai.addActionListener(this);

		// Tạo menu khách hàng
		mnuKhachHang = new JMenu("   Khách hàng   ");
		mnuKhachHang.setFont(fontMenu);
		mniQuanLiKhachHang = new JMenuItem("Quản lí khách hàng");
		mniQuanLiKhachHang.setFont(fontMenuItem);
		mnuKhachHang.add(mniQuanLiKhachHang);

		mniQuanLiKhachHang.addActionListener(e -> {
			this.dispose();
			KhachHangGUI khachHangGUI = new KhachHangGUI(nhanVien);
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
		mnuMonAn.setBackground(Color.green);
		mnuMonAn.setOpaque(true);
		mniDSMonAn = new JMenuItem("Danh sách món ăn");
		mniDSMonAn.setFont(fontMenuItem);
		mniDSMonAn.addActionListener(e->{
			dispose();
			MonAnGUI newMonAnGUI = new MonAnGUI(nhanVien);
			newMonAnGUI.setVisible(true);
		});
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
        setTitle("Dish Management");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Full màn hình
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout()); // Sử dụng GridBagLayout để căn giữa
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Khoảng cách giữa các thành phần
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        Font labelFont = new Font("Arial", Font.BOLD, 16); // Chữ lớn hơn cho nhãn
        Font fieldFont = new Font("Arial", Font.PLAIN, 16); // Chữ lớn hơn cho ô nhập

        JLabel nameLabel = new JLabel("Tên món ăn:");
        nameLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(nameLabel, gbc);

        nameField = new JTextField(20);
        nameField.setFont(fieldFont);
        gbc.gridx = 1;
        inputPanel.add(nameField, gbc);

        JLabel priceLabel = new JLabel("Giá tiền:");
        priceLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(priceLabel, gbc);

        priceField = new JTextField(20);
        priceField.setFont(fieldFont);
        gbc.gridx = 1;
        inputPanel.add(priceField, gbc);


       

        JLabel descriptionLabel = new JLabel("Mô tả:");
        descriptionLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(descriptionLabel, gbc);

        descriptionField = new JTextField(20);
        descriptionField.setFont(fieldFont);
        gbc.gridx = 1;
        inputPanel.add(descriptionField, gbc);

        // Nút "Thêm mới", "Xóa" và "Thay đổi thông tin"
        addButton = new JButton("Thêm mới");
        addButton.setBackground(Color.GREEN);
        addButton.setForeground(Color.WHITE);

        deleteButton = new JButton("Xóa món ăn");
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE);

        updateButton = new JButton("Thay đổi thông tin");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addButton.setPreferredSize(new Dimension(150, 40));
        deleteButton.setPreferredSize(new Dimension(150, 40));
        updateButton.setPreferredSize(new Dimension(150, 40));

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);

        topPanel.add(inputPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        JPanel centerPanel = new JPanel(new BorderLayout());
        searchField = new JTextField(20);
        searchField.setFont(fieldFont); // Chữ lớn hơn cho ô tìm kiếm
        searchButton = new JButton("Tìm kiếm");
        searchButton.setFont(labelFont); // Chữ lớn hơn cho nút tìm kiếm

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.add(new JLabel("Tìm kiếm:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Thông tin món ăn", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setPreferredSize(new Dimension(400, 100));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);

        titlePanel.add(titleLabel, BorderLayout.CENTER);
        titlePanel.setPreferredSize(new Dimension(400, 100));

        // Tạo bảng với các cột
        String[] columnNames = {"Mã món ăn", "Tên món ăn", "Giá tiền", "Mô tả"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa trực tiếp
            }
        };

        dishTable = new JTable(tableModel);
        dishTable.setFont(new Font("Arial", Font.PLAIN, 18)); // Tăng kích thước chữ
        dishTable.setRowHeight(30); // Tăng chiều cao hàng
        dishTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(dishTable);

        centerPanel.add(searchPanel, BorderLayout.NORTH);
        centerPanel.add(titlePanel, BorderLayout.CENTER);
        centerPanel.add(scrollPane, BorderLayout.SOUTH);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        add(mainPanel);

        // Thêm sự kiện cho các nút
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String price = priceField.getText();

            String description = descriptionField.getText();

            if (!name.isEmpty() && !price.isEmpty()  && !description.isEmpty()) {
                MonAn monAn = new MonAn(0, name, Float.parseFloat(price), description);
                new MonAnDAO().addMonAn(monAn);
                loadData();
                nameField.setText("");
                priceField.setText("");
                descriptionField.setText("");
                JOptionPane.showMessageDialog(null, "Thêm món ăn thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
            }
        });

        deleteButton.addActionListener(e -> {
            int selectedRow = dishTable.getSelectedRow();
            if (selectedRow >= 0) {
                int maMon = (int) tableModel.getValueAt(selectedRow, 0);
                new MonAnDAO().deleteMonAn(maMon);
                loadData();
                JOptionPane.showMessageDialog(null, "Xóa món ăn thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn một món ăn để xóa!");
            }
        });

        updateButton.addActionListener(e -> {
            int selectedRow = dishTable.getSelectedRow();
            if (selectedRow >= 0) {
                String name = nameField.getText();
                String price = priceField.getText();
               
                String description = descriptionField.getText();

                if (!name.isEmpty() && !price.isEmpty() && !description.isEmpty()) {
                    int maMon = (int) tableModel.getValueAt(selectedRow, 0);
                    MonAn monAn = new MonAn(maMon, name, Float.parseFloat(price),description);
                    new MonAnDAO().updateMonAn(monAn);
                    loadData();
                    JOptionPane.showMessageDialog(null, "Cập nhật thông tin món ăn thành công!");
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn một món ăn để thay đổi thông tin!");
            }
        });

        searchButton.addActionListener(e -> {
            String keyword = searchField.getText().trim();
            if (!keyword.isEmpty()) {
                boolean found = false;
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    String dishId = String.valueOf(tableModel.getValueAt(i, 0));
                    String name = String.valueOf(tableModel.getValueAt(i, 1));

                    if (dishId.equalsIgnoreCase(keyword) || name.equalsIgnoreCase(keyword)) {
                        dishTable.setRowSelectionInterval(i, i);
                        dishTable.scrollRectToVisible(dishTable.getCellRect(i, 0, true));
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy món ăn với thông tin này!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin tìm kiếm!");
            }
        });

        dishTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = dishTable.getSelectedRow();
                if (selectedRow >= 0) {
                    nameField.setText((String) tableModel.getValueAt(selectedRow, 1));
                    priceField.setText(String.valueOf(tableModel.getValueAt(selectedRow, 2)));
                    
                    descriptionField.setText((String) tableModel.getValueAt(selectedRow, 3));
                }
            }
        });

        // Load data from database
        loadData();
    }

    // Method to load data from database
    private void loadData() {
        MonAnDAO monAnDAO = new MonAnDAO();
        List<MonAn> monAnList = monAnDAO.getAllMonAn();
        tableModel.setRowCount(0); // Clear existing data

        for (MonAn monAn : monAnList) {
            tableModel.addRow(new Object[]{
                monAn.getMaMon(),
                monAn.getTenMon(),
                monAn.getGiaTien(),
                
                monAn.getMoTa()
            });
        }
    }

}
