INSERT INTO Khach_Hang VALUES (N'Nguyễn Văn AN', '0987654321', 'nguyenvanan@gmail.com', N'123 Trần Hưng Đạo, Quận 1, TP.HCM', 'KH001'),
(N'Trần Thị TUYẾT', '0912345678', 'tranb@gmail.com', N'456 Lê Lợi, Quận 3, TP.HCM', 'KH002'),
(N'Lê Văn NHẬT ÁNH', '0934567890', 'levanc@gmail.com', N'789 Nguyễn Trãi, Quận 5, TP.HCM', 'KH003'),
(N'Phạm Thị DƯƠNG', '0978912345', 'phamd@gmail.com', N'1011 Cách Mạng Tháng Tám, Quận 10, TP.HCM', 'KH004'),
(N'Hoàng Văn ÁNH', '0967123456', 'hoange@gmail.com', N'1213 Lý Thường Kiệt, Quận 11, TP.HCM', 'KH005'),
(N'Ngô Thị HỒNG ĐÀO', '0945678901', 'ngof@gmail.com', N'1415 Hùng Vương, Quận 6, TP.HCM', 'KH006'),
(N'Đặng Văn GIANG', '0923456789', 'dangg@gmail.com', N'1617 Phan Đình Phùng, Quận Phú Nhuận, TP.HCM', 'KH007'),
(N'Vũ Thị HOÀNG DUNG', '0998765432', 'vuh@gmail.com', N'1819 Nguyễn Kiệm, Quận Gò Vấp, TP.HCM', 'KH008'),
(N'Trương Văn LÝ', '0956789012', 'truongi@gmail.com', N'2021 Nguyễn Oanh, Quận Bình Thạnh, TP.HCM', 'KH009'),
(N'Lý Thị KIM ÁNH', '0989012345', 'lyk@gmail.com', N'2223 Nguyễn Văn Linh, Quận 7, TP.HCM', 'KH010');

  INSERT INTO Nhan_Vien VALUES ('NV001',N'Nguyễn Thị Lan',N'Nữ','1998-01-01',N'Quản lý','lannt@gmail.com','lan.jpg','123456'),
  ('NV002',N'Trần Văn Minh',N'Nam','1997-02-02',N'Nhân viên bán hàng','minhtv@gmail.com','minh.jpg','234567'),
  ('NV003',N'Lê Thị Hoa',N'Nữ','1999-03-03',N'Nhân viên bán hàng','hoalt@gmail.com','hoa.jpg','345678'),
  ('NV004',N'Phạm Văn Hùng',N'Nam','1996-04-04',N'Nhân viên kho','hungpv@gmail.com','hung.jpg','456789'),
  ('NV005',N'Hoàng Thị Mai',N'Nữ','2000-05-05',N'Nhân viên kho','maibt@gmail.com','mai.jpg','567890');

 INSERT INTO Lich_Lam_Viec VALUES (1,N'Nguyễn Thị Lan','2023-11-01',1,'8:00 - 12:00','NV001'), 
 (2,N'Trần Văn Minh','2023-11-01',1,'8:00 - 12:00','NV002'),
 (3,N'Lê Thị Hoa','2023-11-01',1,'8:00 - 12:00','NV003'), 
 (4,N'Phạm Văn Hùng','2023-11-01',2,'13:00 - 17:00','NV004'), 
 (5,N'Hoàng Thị Mai','2023-11-01',2,'13:00 - 17:00','NV005');
 

 INSERT INTO Loai_SanPham VALUES ('LSP001',N'Điện thoại'),
 ('LSP002',N'Máy tính'),
 ('LSP003',N'Máy ảnh'), 
 ('LSP004',N'Tivi'),
 ('LSP005',N'Tủ lạnh');

 INSERT INTO Kho VALUES ('K001',N'Kho trung tâm'),
						('K002',N'Kho phụ');

 INSERT INTO Phieu_Xuat VALUES ('PX001',N'Điện thoại Samsung Galaxy S21','2023-11-01','K001','NV002'),
 ('PX002',N'Máy tính Dell Inspiron 15','2023-11-01','K001','NV003'),
 ('PX003',N'Máy ảnh Canon EOS 200D II','2023-11-01','K002','NV004'),
 ('PX004',N'Tivi LG OLED55C1PTA 55 inch 4K Smart OLED TV','2023-11-02','K001','NV002'), 
 ('PX005',N'Tủ lạnh Panasonic  240 lít Inverter ','2023-11-02','K002','NV005');

 INSERT INTO Phieu_Nhap VALUES ('PN001',N'Điện thoại iPhone 13 Pro Max 256GB','2023-11-01','K001','NV001'),
 ('PN002',N'Máy tính Asus VivoBook S15 ','2023-11-01','K001','NV001'),
 ('PN003',N'Máy ảnh Sony Alpha A7 III','2023-11-01','K002','NV001'), 
 ('PN004',N'Tivi Samsung  55 inch QLED Smart TV ','2023-11-02','K001','NV001'),
 ('PN005',N'Tủ lạnh Toshiba GR-A28VPD(S) 263 lít Inverter','2023-11-02','K002','NV001');

INSERT INTO San_Pham VALUES ('SP001', N'Điện thoại Samsung Galaxy S21', 10, 20990000, '2023-10-31', 'Còn hàng', 'LSPDT001', 'K001','IP13ProMax256.jpg'),
('SP002', N'Máy tính Dell Inspiron 15', 5, 15990000, '2023-10-30', N'Còn hàng', 'LSPDT002', 'K001','Dellinprison15.png'),
('SP003', N'Máy ảnh Canon EOS 200D II', 8, 14990000, '2023-10-29', N'Còn hàng', 'LSPDT003', 'K002','Canon200DII.png'),
('SP004', N'Tivi LG  55 inch 4K Smart OLED TV', 6, 33990000, '2023-10-28', N'Còn hàng','LSPDT004', 'K001','LGTV55inch4k.jpg'),
('SP005', N'Tủ lạnh Panasonic  240 lít Inverter ', 4, 6990000, '2023-10-27', N'Còn hàng', 'LSPDT005', 'K002','Panasonic243L.jpg'),
('SP006', N'Điện thoại iPhone 13 Pro Max 256GB', 20, 39990000, '2023-11-01', N'Còn hàng', 'LSPDT001', 'K001','IP13ProMax256.jpg'),
('SP007', N'Máy tính Asus VivoBook S15 ', 10, 17990000, '2023-11-01', N'Còn hàng', 'LSPDT002', 'K001','VivobookS15.png'),
('SP008', N'Máy ảnh Sony Alpha A7 III', 12, 42990000, '2023-11-01', N'Còn hàng', 'LSPDT003', 'K002','SonyAlPhaA7III.png'), 
('SP009', N'Bồn rửa chén', 12, 42990000, '2023-11-01', N'Còn hàng', 'LSPGD001', 'K002','sink.png'), 
('SP0010', N'Chảo rán', 12, 42990000, '2023-11-01', N'Còn hàng', 'LSPGD001', 'K002','fryingpan.png'), 
('SP0011', N'Nĩa', 12, 42990000, '2023-11-01', N'Còn hàng', 'LSPGD001', 'K002','fork.png'), 
('SP0012', N'Bếp gas mini', 12, 42990000, '2023-11-01', N'Còn hàng', 'LSPGD001', 'K002','stove.png'), 
('SP0013', N'Nước tăng lực Monster', 12, 42990000, '2023-11-01', N'Còn hàng', 'LSPTU001', 'K002','monster.png'), 
('SP0014', N'Sting dâu', 12, 42990000, '2023-11-01', N'Còn hàng', 'LSPTU001', 'K002','monster.png'), 
('SP0015', N'Táo', 12, 42990000, '2023-11-01', N'Còn hàng', 'LSPTC001', 'K002','apple.png'), 
('SP0016', N'Cam', 12, 42990000, '2023-11-01', N'Còn hàng', 'LSPTC001', 'K002','orange.png'), 
('SP0017', N'Bắp cải', 12, 42990000, '2023-11-01', N'Còn hàng', 'LSPRC001', 'K002','cabbage.png'), 
('SP0018', N'Dưa lưới', 8, 29990000, '2023-11-02', N'Còn hàng', 'LSPRC001', 'K001','melon.png');

 INSERT INTO Hoa_Don VALUES ('HD001',N'Nguyễn Văn AN','2023-11-01','0987654321',N'123 Trần Hưng Đạo, Quận 1, TP.HCM', 23090000, 'NV002', 'KH001'), 
 ('HD002',N'Trần Thị TUYẾT','2023-11-01','0912345678',N'456 Lê Lợi, Quận 3, TP.HCM', 15990000,'NV003', 'KH002'),
 ('HD003',N'Lê Văn NHẬT ÁNH','2023-11-02','0934567890',N'789 Nguyễn Trãi, Quận 5, TP.HCM', 14990000, 'NV002', 'KH003'),
 ('HD004',N'Phạm Thị DƯƠNG','2023-11-02','0978912345',N'1011 Cách Mạng Tháng Tám, Quận 10, TP.HCM', 33990000, 'NV003', 'KH004'),
 ('HD005',N'Hoàng Văn ÁNH','2023-11-03','0967123456',N'1213 Lý Thường Kiệt, Quận 11, TP.HCM', 6990000, 'NV002', 'KH005');
  INSERT INTO Hoa_Don VALUES ('HD006',N'Nguyễn','2023-1-01','0987654321',N'123 Trần Hưng Đạo, Quận 1, TP.HCM', 23090000, 'NV002', 'KH001'),
  ('HD007',N'Thanh','2023-2-01','0987654321',N'123 Trần Hưng Đạo, Quận 1, TP.HCM', 23090000, 'NV002', 'KH001'),
  ('HD008',N'Duong','2023-3-01','0987654321',N'123 Trần Hưng Đạo, Quận 1, TP.HCM', 23090000, 'NV002', 'KH001')
 INSERT INTO ChiTietHD VALUES (N'Điện thoại Samsung Galaxy S21',2 ,20990000 , 'HD001', 'SP001'),
(N'Máy tính Dell Inspiron 15',3 , 15990000, 'HD002', 'SP002'),
(N'Máy ảnh Canon EOS 200D II',2 , 14990000, 'HD003', 'SP003'),
(N'Tivi LG  55 inch 4K Smart OLED TV',1 , 33990000, 'HD004', 'SP004'), 
(N'Tủ lạnh Panasonic  240 lít Inverter ',1 , 6990000, 'HD005', 'SP005');
select TenSP, SoLuongDC, Gia from ChiTietHD where MaDH = 'HD001'

  INSERT INTO ChiTiet_Nhap VALUES (39990000, N'Đã nhập', 'PN001', 'SP006'),
(17990000, N'Đã nhập', 'PN002', 'SP007'),
(42990000, N'Đã nhập', 'PN003', 'SP008'), 
(29990000, N'Đã nhập', 'PN004', 'SP009');


 INSERT INTO ChiTiet_Xuat VALUES (20990000, N'Đã xuất', 'PX001', 'SP001'), 
(15990000, N'Đã xuất', 'PX002', 'SP002'), 
(14990000, N'Đã xuất', 'PX003', 'SP003'), 
(33990000, N'Đã xuất', 'PX004', 'SP004'), 
(6990000, N'Đã xuất', 'PX005', 'SP005');

CREATE PROC sp_ThongKeDoanhThu(@month int)
AS BEGIN
SELECT MaDH, TenKH, ThanhTien FROM Hoa_Don
WHERE Month(NgayDatHang) = @month
END

