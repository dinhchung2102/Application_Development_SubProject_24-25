package gui;

import dao.KhuyenMaiDAO;
import entity.KhuyenMai;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class KhuyenMaiGUI extends FormMenu {
    private static final long serialVersionUID = 1L;

    private JButton addButton, deleteButton, updateButton, searchButton;
    private JTextField searchField, nameField, minValueField, discountValueField, descriptionField;
    private JTable promotionTable;
    private DefaultTableModel tableModel;

    public KhuyenMaiGUI() {
        setTitle("Khuyến Mãi Nhà Hàng");
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

        JLabel nameLabel = new JLabel("Tên Khuyến Mãi:");
        nameLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(nameLabel, gbc);

        nameField = new JTextField(20);
        nameField.setFont(fieldFont);
        gbc.gridx = 1;
        inputPanel.add(nameField, gbc);

        JLabel minValueLabel = new JLabel("Giá Trị Tối Thiểu Áp Dụng:");
        minValueLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(minValueLabel, gbc);

        minValueField = new JTextField(20);
        minValueField.setFont(fieldFont);
        gbc.gridx = 1;
        inputPanel.add(minValueField, gbc);

        JLabel discountValueLabel = new JLabel("Giá Trị Khuyến Mãi:");
        discountValueLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(discountValueLabel, gbc);

        discountValueField = new JTextField(20);
        discountValueField.setFont(fieldFont);
        gbc.gridx = 1;
        inputPanel.add(discountValueField, gbc);

        JLabel descriptionLabel = new JLabel("Mô Tả:");
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

        deleteButton = new JButton("Xóa Khuyến Mãi");
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE);

        updateButton = new JButton("Thay Đổi Thông Tin");

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

        JPanel         searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.add(new JLabel("Tìm kiếm:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Thông tin khuyến mãi", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setPreferredSize(new Dimension(400, 100));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);

        titlePanel.add(titleLabel, BorderLayout.CENTER);
        titlePanel.setPreferredSize(new Dimension(400, 100));

        // Tạo bảng với các cột
        String[] columnNames = {"Mã khuyến mãi", "Tên Khuyến Mãi", "Giá Trị Tối Thiểu", "Giá Trị Khuyến Mãi", "Mô Tả"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa trực tiếp
            }
        };

        promotionTable = new JTable(tableModel);
        promotionTable.setFont(new Font("Arial", Font.PLAIN, 18)); // Tăng kích thước chữ
        promotionTable.setRowHeight(30); // Tăng chiều cao hàng
        promotionTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(promotionTable);

        centerPanel.add(searchPanel, BorderLayout.NORTH);
        centerPanel.add(titlePanel, BorderLayout.CENTER);
        centerPanel.add(scrollPane, BorderLayout.SOUTH);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Thêm JPanel chứa hình ảnh
        JPanel imagePanel = new JPanel();
        JLabel imageLabel = new JLabel(new ImageIcon("D:\\LeTrongThienPhat\\Nhom14_QuanLyDatBan\\image\\KH.webp"));
        imagePanel.add(imageLabel);

        mainPanel.add(imagePanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Thêm sự kiện cho các nút
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String minValue = minValueField.getText();
            String discountValue = discountValueField.getText();
            String description = descriptionField.getText();

            if (!name.isEmpty() && !minValue.isEmpty() && !discountValue.isEmpty() && !description.isEmpty()) {
                KhuyenMai km = new KhuyenMai(0, name, Double.parseDouble(minValue), Double.parseDouble(discountValue), description);
                new KhuyenMaiDAO().addKhuyenMai(km);
                loadData();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
            }
        });

        deleteButton.addActionListener(e -> {
            int selectedRow = promotionTable.getSelectedRow();
            if (selectedRow >= 0) {
                int maKM = (int) tableModel.getValueAt(selectedRow, 0);
                new KhuyenMaiDAO().deleteKhuyenMai(maKM);
                loadData();
                JOptionPane.showMessageDialog(null, "Xóa khuyến mãi thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn một khuyến mãi để xóa!");
            }
        });

        updateButton.addActionListener(e -> {
            int selectedRow = promotionTable.getSelectedRow();
            if (selectedRow >= 0) {
                String name = nameField.getText();
                String minValue = minValueField.getText();
                String discountValue = discountValueField.getText();
                String description = descriptionField.getText();

                if (!name.isEmpty() && !minValue.isEmpty() && !discountValue.isEmpty() && !description.isEmpty()) {
                    int maKM = (int) tableModel.getValueAt(selectedRow, 0);
                    KhuyenMai km = new KhuyenMai(maKM, name, Double.parseDouble(minValue), Double.parseDouble(discountValue), description);
                    new KhuyenMaiDAO().updateKhuyenMai(km);
                    loadData();
                    JOptionPane.showMessageDialog(null, "Cập nhật thông tin khuyến mãi thành công!");
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn một khuyến mãi để thay đổi thông tin!");
            }
        });

        searchButton.addActionListener(e -> {
            String keyword = searchField.getText().trim();
            if (!keyword.isEmpty()) {
                boolean found = false;
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    String promotionId = String.valueOf(tableModel.getValueAt(i, 0));
                    String name = String.valueOf(tableModel.getValueAt(i, 1));

                    if (promotionId.equalsIgnoreCase(keyword) || name.equalsIgnoreCase(keyword)) {
                        promotionTable.setRowSelectionInterval(i, i);
                        promotionTable.scrollRectToVisible(promotionTable.getCellRect(i, 0, true));
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy khuyến mãi với thông tin này!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin tìm kiếm!");
            }
        });

        promotionTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = promotionTable.getSelectedRow();
                if (selectedRow >= 0) {
                    nameField.setText((String) tableModel.getValueAt(selectedRow, 1));
                    minValueField.setText((String) tableModel.getValueAt(selectedRow, 2));
                    discountValueField.setText((String) tableModel.getValueAt(selectedRow, 3));
                    descriptionField.setText((String) tableModel.getValueAt(selectedRow, 4));
                }
            }
        });

        // Load data from database
        loadData();
    }

    // Method to load data from database
    private void loadData() {
        KhuyenMaiDAO khuyenMaiDAO = new KhuyenMaiDAO();
        List<KhuyenMai> khuyenMaiList = khuyenMaiDAO.getAllKhuyenMai();
        tableModel.setRowCount(0); // Clear existing data

        for (KhuyenMai km : khuyenMaiList) {
            tableModel.addRow(new Object[]{km.getMaKM(), km.getTenKM(), km.getDonHangToiThieu(), km.getGiamGia(), km.getMoTa()});
        }
    }

    // Method to clear input fields
    private void clearFields() {
        nameField.setText("");
        minValueField.setText("");
        discountValueField.setText("");
        descriptionField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            KhuyenMaiGUI khuyenMai = new KhuyenMaiGUI();
            khuyenMai.setVisible(true);
        });
    }
}
