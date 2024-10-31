package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import entity.NhanVien;
import entity.TaiKhoan;

public class FormMenu extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	

	
	protected TaiKhoan taiKhoan;
	
	
	
	
	public FormMenu() {
		setTitle("Quản lý đặt bàn");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Full màn hình
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
		
		//tạo font cho JMenu
		fontMenu = new Font(Font.SERIF, Font.BOLD, 25);
		//tạo font cho JMenuItem
		fontMenuItem = new Font(Font.SERIF, Font.PLAIN, 25);
		
		//Tạo menubar
		mnuMenuBar = new JMenuBar();
		mnuMenuBar.setBackground(Color.white);
		this.setJMenuBar(mnuMenuBar);
		
		//Tạo menu đặt bàn
		mnuDatBan = new JMenu("     Đặt bàn     ");
		mnuDatBan.setFont(fontMenu);
		mnuDatBan.setOpaque(true);
		mnuDatBan.setBackground(Color.lightGray);
		mnuDatBan.setBorder(new LineBorder(Color.BLACK, 1));
		
		mnuDatBan.addActionListener(this);
		
		//Tạo menu phiếu đặt bàn
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
		
		//Tạo menu hóa đơn
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
		
		//Tạo menu khuyến mãi
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
		
		//Tạo menu khách hàng
		mnuKhachHang = new JMenu("   Khách hàng   ");
		mnuKhachHang.setFont(fontMenu);
		mniQuanLiKhachHang = new JMenuItem("Quản lí khách hàng");
		mniQuanLiKhachHang.setFont(fontMenuItem);
		mnuKhachHang.add(mniQuanLiKhachHang);
		
		mniQuanLiKhachHang.addActionListener(this);
		
		//Tạo menu bàn
		mnuBan = new JMenu("   Bàn   ");
		mnuBan.setFont(fontMenu);
		mniQuanLiBan = new JMenuItem("Quản lí bàn");
		mniQuanLiBan.setFont(fontMenuItem);
		mnuBan.add(mniQuanLiBan);
		
		mniQuanLiBan.addActionListener(this);
		
		//Tạo menu món ăn
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
		
		//Tạo menu tài khoản
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
		
		
		setVisible(true);
	}
	public FormMenu(TaiKhoan tk) {
		this();
		this.taiKhoan = tk;
		mnuTaiKhoan.setText("Nhân viên: " + taiKhoan.getNhanVien().getTenNV());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(mnuDatBan)) {
//			dispose();
//			
//			FormManHinhChinh newFrmManHinhChinh = new FormManHinhChinh();
//			newFrmManHinhChinh.setVisible(true);
			
		}
		else if (o.equals(mniDSPhieuDatBan)) {
			
		}
		else if (o.equals(mniTimKiemPhieuDatBan)) {
			
		}
		else if (o.equals(mniXuatHoaDon)) {
			
		}
		else if (o.equals(mniDSHoaDon)) {
			
		}
		else if (o.equals(mniXuatHoaDon)) {
			
		}
		else if (o.equals(mniDSHoaDon)) {
			
		}
		else if (o.equals(mniDSKhuyenMai)) {
			
//			KhuyenMaiGUI khuyenMaiGUI = new KhuyenMaiGUI();
//			khuyenMaiGUI.setVisible(true);
		}
		else if (o.equals(mniThemKhuyenMai)) {
			
		}
		else if (o.equals(mnuKhachHang)) {
			
		}
		else if (o.equals(mnuBan)) {
			
		}
		else if (o.equals(mniDSMonAn)) {
			
			
		}
		else if (o.equals(mniThemMonAn)) {
			
		}
		else if (o.equals(mniQuanLiKhachHang)) {
			
	           // KhachHangGUI khachHang = new KhachHangGUI();
	            //khachHang.setVisible(true);
		}
		else if (o.equals(mniThongKeDoanhThu)) {
			
		}
		else if (o.equals(mniThongTinTaiKhoan)) {
			ThongTinTaiKhoan_GUI thongTinTaiKhoan_GUI = new ThongTinTaiKhoan_GUI(taiKhoan);
			thongTinTaiKhoan_GUI.setVisible(true);
		}
		else if (o.equals(mniDangXuat)) {
			this.dispose();
			DangNhap_GUI dangNhap_GUI = new DangNhap_GUI();
			dangNhap_GUI.setVisible(true);
		}
	}
}
