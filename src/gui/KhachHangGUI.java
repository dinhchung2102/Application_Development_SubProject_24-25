package gui;

import dao.DAO_KhachHang;
import entity.KhachHang;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class KhachHangGUI extends FormMenu {
    private static final long serialVersionUID = 1L;

    private JButton addButton, deleteButton, updateButton, searchButton;
    private JTextField searchField, nameField, phoneField, emailField, addressField;
    private JTable customerTable;
    private DefaultTableModel tableModel;
    private String currentCustomerId = "AAA000";

    public KhachHangGUI() {
        setTitle("Customer Management");
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

        JLabel nameLabel = new JLabel("Tên khách hàng:");
        nameLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(nameLabel, gbc);

        nameField = new JTextField(20);
        nameField.setFont(fieldFont);
        gbc.gridx = 1;
        inputPanel.add(nameField, gbc);

        JLabel phoneLabel = new JLabel("Số điện thoại:");
        phoneLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(phoneLabel, gbc);

        phoneField = new JTextField(20);
        phoneField.setFont(fieldFont);
        gbc.gridx = 1;
        inputPanel.add(phoneField, gbc);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(emailLabel, gbc);

        emailField = new JTextField(20);
        emailField.setFont(fieldFont);
        gbc.gridx = 1;
        inputPanel.add(emailField, gbc);

        JLabel addressLabel = new JLabel("Địa chỉ:");
        addressLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(addressLabel, gbc);

        addressField = new JTextField(20);
        addressField.setFont(fieldFont);
        gbc.gridx = 1;
        inputPanel.add(addressField, gbc);

        // Nút "Thêm mới", "Xóa" và "Thay đổi thông tin"
        addButton = new JButton("Thêm mới");
        addButton.setBackground(Color.GREEN);
        addButton.setForeground(Color.WHITE);

        deleteButton = new JButton("Xóa khách hàng");
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
        JLabel titleLabel = new JLabel("Thông tin khách hàng", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setPreferredSize(new Dimension(400, 100));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);

        titlePanel.add(titleLabel, BorderLayout.CENTER);
        titlePanel.setPreferredSize(new Dimension(400, 100));

        // Tạo bảng với các cột
        String[] columnNames = {"Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Email", "Địa chỉ"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa trực tiếp
            }
        };

        customerTable = new JTable(tableModel);
        customerTable.setFont(new Font("Arial", Font.PLAIN, 18)); // Tăng kích thước chữ
        customerTable.setRowHeight(30); // Tăng chiều cao hàng
        customerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(customerTable);

        centerPanel.add(searchPanel, BorderLayout.NORTH);
        centerPanel.add(titlePanel, BorderLayout.CENTER);
        centerPanel.add(scrollPane, BorderLayout.SOUTH);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Thêm JPanel chứa hình ảnh
        JPanel imagePanel = new JPanel();
        JLabel imageLabel = new JLabel(new ImageIcon("\\image\\KH.webp"));
        imagePanel.add(imageLabel);

        mainPanel.add(imagePanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Thêm sự kiện cho các nút
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String address = addressField.getText();

            if (!name.isEmpty() && isValidPhoneNumber(phone) && !email.isEmpty() && !address.isEmpty()) {
                KhachHang kh = new KhachHang(0, name, phone, email, address);
                new DAO_KhachHang().addKhachHang(kh);
                loadData();
                nameField.setText("");
                phoneField.setText("");
                emailField.setText("");
                addressField.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin và số điện thoại hợp lệ!");
            }
        });

        deleteButton.addActionListener(e -> {
            int selectedRow = customerTable.getSelectedRow();
            if (selectedRow >= 0) {
                int maKH = (int) tableModel.getValueAt(selectedRow, 0);
                new DAO_KhachHang().deleteKhachHang(maKH);
                loadData();
                JOptionPane.showMessageDialog(null, "Xóa khách hàng thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn một khách hàng để xóa!");
            }
        });

        updateButton.addActionListener(e -> {
            int selectedRow = customerTable.getSelectedRow();
            if (selectedRow >= 0) {
                String name = nameField.getText();
                String phone = phoneField.getText();
                String email = emailField.getText();
                String address = addressField.getText();

                if (!name.isEmpty() && isValidPhoneNumber(phone) && !email.isEmpty() && !address.isEmpty()) {
                    int maKH = (int) tableModel.getValueAt(selectedRow, 0);
                    KhachHang kh = new KhachHang(maKH, name, phone, email, address);
                    new DAO_KhachHang().updateKhachHang(kh);
                    loadData();
                    JOptionPane.showMessageDialog(null, "Cập nhật thông tin khách hàng thành công!");
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin và số điện thoại hợp lệ!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn một khách hàng để thay đổi thông tin!");
            }
        });

        searchButton.addActionListener(e -> {
            String keyword = searchField.getText().trim();
            if (!keyword.isEmpty()) {
                boolean found = false;
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    String customerId = String.valueOf(tableModel.getValueAt(i, 0));
                    String phone = String.valueOf(tableModel.getValueAt(i, 2));

                    if (customerId.equalsIgnoreCase(keyword) || phone.equals(keyword)) {
                        customerTable.setRowSelectionInterval(i, i);
                        customerTable.scrollRectToVisible(customerTable.getCellRect(i, 0, true));
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng với thông tin này!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin tìm kiếm!");
            }
        });

        customerTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = customerTable.getSelectedRow();
                if (selectedRow >= 0) {
                    nameField.setText((String) tableModel.getValueAt(selectedRow, 1));
                    phoneField.setText((String) tableModel.getValueAt(selectedRow, 2));
                    emailField.setText((String) tableModel.getValueAt(selectedRow, 3));
                    addressField.setText((String) tableModel.getValueAt(selectedRow, 4));
                }
            }
        });

        // Load data from database
        loadData();
    }

    // Method to load data from database
    private void loadData() {
        DAO_KhachHang khachHangDAO = new DAO_KhachHang();
        List<KhachHang> khachHangList = khachHangDAO.getAllKhachHang();
        tableModel.setRowCount(0); // Clear existing data

        for (KhachHang kh : khachHangList) {
            tableModel.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), kh.getSoDT(), kh.getEmail(), kh.getDiaChi()});
        }
    }

    // Method to validate phone number
    private boolean isValidPhoneNumber(String phone) {
        return phone.matches("\\d{10}"); // Số điện thoại phải có 10 chữ số
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            KhachHangGUI khachHang = new KhachHangGUI();
//            khachHang.setVisible(true);
//        });
//    }
}
