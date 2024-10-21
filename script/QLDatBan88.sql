CREATE DATABASE QLDatBan88

GO

USE QLDatBan88;
GO

CREATE TABLE NhanVien (
    maNV INT IDENTITY(1,1) PRIMARY KEY,
    tenNV NVARCHAR(50),
    gioiTinh NVARCHAR(10),
    ngaySinh DATE,
    soDT NVARCHAR(10),
    email NVARCHAR(20),
    diaChi NVARCHAR(50)
);
GO

CREATE TABLE TaiKhoan (
    tenDangNhap NVARCHAR(50) PRIMARY KEY,
    matKhau NVARCHAR(200),
    loaiTaiKhoan NVARCHAR(20),
    maNV INT FOREIGN KEY REFERENCES NhanVien(maNV) ON DELETE SET NULL
);
GO

CREATE TABLE KhachHang (
    maKH INT IDENTITY(1,1) PRIMARY KEY,
    tenKH NVARCHAR(50),
    soDT NVARCHAR(10),
    email NVARCHAR(40),
    diaChi NVARCHAR(60)
);
GO

CREATE TABLE KhuVuc (
    maKhuVuc INT IDENTITY(1,1) PRIMARY KEY,
    tenKhuVuc NVARCHAR(20),
    soBan INT,
    moTa NVARCHAR(50)
);
GO

CREATE TABLE Ban (
    maBan INT IDENTITY(1,1) PRIMARY KEY,
    loaiBan NVARCHAR(10),
    soGheNgoi INT,
    moTa NVARCHAR(50),
    trangThai BIT,
    maKhuVuc INT FOREIGN KEY REFERENCES KhuVuc(maKhuVuc) ON DELETE SET NULL
);
GO

CREATE TABLE MonAn (
    maMon INT IDENTITY(1,1) PRIMARY KEY,
    tenMon NVARCHAR(20),
    giaTien FLOAT,
    soLuong INT,
    moTa NVARCHAR(50)
);
GO

CREATE TABLE PhieuDatBan (
    maPhieuDatBan INT IDENTITY(1,1) PRIMARY KEY,
    ngayTaoPhieu DATE,
    thoiGianDatBan DATETIME,
    tongTien FLOAT,
    maKH INT FOREIGN KEY REFERENCES KhachHang(maKH) ON DELETE SET NULL,
    maNV INT FOREIGN KEY REFERENCES NhanVien(maNV) ON DELETE SET NULL,
    maBan INT FOREIGN KEY REFERENCES Ban(maBan) ON DELETE SET NULL
);
GO

CREATE TABLE ChiTietPhieuDatBan (
    maChiTietPhieuDatBan INT IDENTITY(1,1) PRIMARY KEY,
    donGia FLOAT,
    soLuong INT,
    thanhTien FLOAT,
    maMon INT FOREIGN KEY REFERENCES MonAn(maMon) ON DELETE SET NULL,
    maPhieuDatBan INT FOREIGN KEY REFERENCES PhieuDatBan(maPhieuDatBan) ON DELETE CASCADE
);
GO

CREATE TABLE KhuyenMai (
    maKM INT IDENTITY(1,1) PRIMARY KEY,
    tenKM NVARCHAR(30),
    donHangToiThieu FLOAT,
    giamGia FLOAT,
    moTa NVARCHAR(50)
);
GO

CREATE TABLE Thue (
    maThue INT IDENTITY(1,1) PRIMARY KEY,
    tenThue NVARCHAR(50),
    giaTriThue FLOAT
);
GO

CREATE TABLE HoaDon (
    maHoaDon INT IDENTITY(1,1) PRIMARY KEY,
    thoiGianThanhToan DATETIME,
    maKH INT FOREIGN KEY REFERENCES KhachHang(maKH) ON DELETE SET NULL,
    maNV INT FOREIGN KEY REFERENCES NhanVien(maNV) ON DELETE SET NULL,
    maPhieuDatBan INT FOREIGN KEY REFERENCES PhieuDatBan(maPhieuDatBan) ON DELETE NO ACTION,
    maKM INT FOREIGN KEY REFERENCES KhuyenMai(maKM) ON DELETE SET NULL,
    maThue INT FOREIGN KEY REFERENCES Thue(maThue) ON DELETE SET NULL,
    tongTienCuoi FLOAT
);
GO

CREATE TABLE ChiTietHoaDon (
    maChiTietHoaDon INT IDENTITY(1,1) PRIMARY KEY,
    maPhieuDatBan INT FOREIGN KEY REFERENCES PhieuDatBan(maPhieuDatBan) ON DELETE CASCADE,
    maHoaDon INT FOREIGN KEY REFERENCES HoaDon(maHoaDon) ON DELETE CASCADE
);
GO

-- Thêm khu vực
INSERT INTO KhuVuc (tenKhuVuc, soBan, moTa)
VALUES
    (N'Lầu 1', 10, N'Tiệc nhỏ, gia đình.'),
    (N'Lầu 2', 15, N'Có sân khấu tổ chức sự kiện'),
    (N'Lầu 3', 12, N'Sân thượng');
GO

-- Thêm bàn
INSERT INTO Ban (loaiBan, soGheNgoi, moTa, trangThai, maKhuVuc)
VALUES
    -- Bàn khu vực Lầu 1
    (N'Bàn tròn', 4, N'Bàn cho 4 người.', 0, 1),
    (N'Bàn vuông', 6, N'Bàn cho nhóm 6 người.', 0, 1),
    (N'Bàn dài', 10, N'Bàn dành cho tiệc.', 0, 1),
    (N'Bàn tròn', 2, N'Bàn nhỏ gần cửa sổ.', 0, 1),
    (N'Bàn vuông', 4, N'Bàn ở góc phòng.', 0, 1),
    (N'Bàn dài', 8, N'Bàn dành cho tiệc nhỏ.', 0, 1),
    
    -- Bàn khu vực Lầu 2
    (N'Bàn tròn', 4, N'Bàn nhỏ, gần sân khấu.', 0, 2),
    (N'Bàn vuông', 8, N'Bàn dành cho họp nhóm.', 0, 2),
    (N'Bàn dài', 12, N'Bàn tiệc lớn, gần sân khấu.', 0, 2),
    (N'Bàn tròn', 6, N'Bàn gần ban công.', 0, 2),
    (N'Bàn vuông', 10, N'Bàn tiệc nhóm ngoài sân khấu.', 0, 2),
    (N'Bàn dài', 14, N'Bàn dành cho tiệc lớn.', 0, 2),

    -- Bàn khu vực Lầu 3
    (N'Bàn tròn', 4, N'Bàn ngoài trời, thích hợp ngắm cảnh.', 0, 3),
    (N'Bàn vuông', 6, N'Bàn nhỏ cho gia đình.', 0, 3),
    (N'Bàn dài', 10, N'Bàn dành cho tiệc ngoài trời.', 0, 3),
    (N'Bàn tròn', 2, N'Bàn trên sân thượng, không gian thoáng.', 0, 3),
    (N'Bàn vuông', 4, N'Bàn nhỏ gần cầu thang.', 0, 3),
    (N'Bàn dài', 8, N'Bàn tổ chức tiệc nhỏ.', 0, 3);
GO

-- Thêm nhân viên
INSERT INTO NhanVien (tenNV, gioiTinh, ngaySinh, soDT, email, diaChi)
VALUES
    (N'Phạm Văn Khang', N'Nam', '2004-01-01', '0968686868', 'phvmkhvnq@gmail.com', N'123 Đường ABC, Quận 1'),
    (N'Võ Đình Chung', N'Nam', '2001-02-02', '0912345678', 'b.tran@gmail.com', N'456 Đường XYZ, Quận 3'),
    (N'Lê Trọng Thiên Phát', N'Nam', '2002-03-03', '0923456789', 'c.le@gmail.com', N'789 Đường DEF, Quận 2');
GO

-- Thêm tài khoản
INSERT INTO TaiKhoan (tenDangNhap, matKhau, loaiTaiKhoan, maNV)
VALUES 
    (N'phamvankhang', N'phamvankhang', N'quanli', 1),
    (N'c', N'c', N'quanli', 2),
    (N'letrongthienphat', N'letrongthienphat', N'nhanvien', 3);
GO

insert into KhachHang (tenKH, soDT, email, diaChi)
values
    (N'Nguyễn Văn A', '0901234567', 'nguyenvana@gmail.com', N'123 Phố ABC, Quận 1'),
    (N'Trần Thị B', '0912345678', 'tranthib@gmail.com', N'456 Phố DEF, Quận 2'),
    (N'Phạm Minh C', '0923456789', 'phamminhc@gmail.com', N'789 Phố GHI, Quận 3'),
    (N'Lê Văn D', '0934567890', 'levand@gmail.com', N'101 Phố JKL, Quận 1'),
    (N'Nguyễn Thị E', '0945678901', 'nguyenthiE@gmail.com', N'202 Phố MNO, Quận 2'),
    (N'Võ Văn F', '0956789012', 'vovanF@gmail.com', N'303 Phố PQR, Quận 3'),
    (N'Lê Thị G', '0967890123', 'lethig@gmail.com', N'404 Phố STU, Quận 1'),
    (N'Trần Văn H', '0978901234', 'tranvanH@gmail.com', N'505 Phố VWX, Quận 2'),
    (N'Nguyễn Minh I', '0989012345', 'nguyenminhI@gmail.com', N'606 Phố YZ, Quận 3'),
    (N'Phạm Văn J', '0990123456', 'phamvanJ@gmail.com', N'707 Phố ABC, Quận 1');
