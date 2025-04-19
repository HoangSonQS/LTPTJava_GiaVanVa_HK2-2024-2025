HƯỚNG DẪN KẾT NỐI RMI TỪ MÁY KHÁC
===============================

1. CHUẨN BỊ MÁY CHỦ (SERVER)
----------------------------

1.1. Xác định địa chỉ IP của máy chủ:
   - Mở Command Prompt và gõ: ipconfig
   - Ghi lại địa chỉ IPv4 (ví dụ: 192.168.1.100)

1.2. Cấu hình tường lửa:
   - Mở Windows Defender Firewall
   - Chọn "Advanced settings"
   - Chọn "Inbound Rules" > "New Rule"
   - Chọn "Port" > "TCP" > Nhập "9090" > "Allow the connection"
   - Đặt tên (ví dụ: "RMI Server") và hoàn tất

1.3. Cập nhật RMIServer.java:
   - Thay đổi hostname từ "LAPTOP-O8OOBHDK" thành địa chỉ IP thực của máy chủ
   - Ví dụ: System.setProperty("java.rmi.server.hostname", "192.168.1.100");
   - Cập nhật tất cả các URL binding tương tự

1.4. Chạy RMI Server:
   - Mở Command Prompt tại thư mục dự án
   - Chạy lệnh: java -Djava.security.policy=rmi.policy -cp build/libs/LTPTJava_GiaVanVa_HK2-2024-2025-1.0-SNAPSHOT.jar iuh.fit.rmi.RMIServer


2. CHUẨN BỊ MÁY KHÁCH (CLIENT)
-----------------------------

2.1. Sao chép các tệp cần thiết:
   - Sao chép thư mục client-jar từ máy chủ sang máy khách
   - Đảm bảo có các tệp: JAR file, rmi.policy

2.2. Cập nhật RemoteRMIClientMenu.java:
   - Mở tệp RemoteRMIClientMenu.java
   - Thay đổi SERVER_IP thành địa chỉ IP thực của máy chủ
   - Ví dụ: private static final String SERVER_IP = "192.168.1.100";

2.3. Biên dịch RemoteRMIClientMenu.java:
   - Mở Command Prompt tại thư mục dự án
   - Chạy lệnh: javac -cp build/libs/LTPTJava_GiaVanVa_HK2-2024-2025-1.0-SNAPSHOT.jar src/main/java/iuh/fit/rmi/RemoteRMIClientMenu.java

2.4. Chạy RMI Client:
   - Chạy lệnh: java -Djava.security.policy=rmi.policy -cp build/libs/LTPTJava_GiaVanVa_HK2-2024-2025-1.0-SNAPSHOT.jar;src/main/java iuh.fit.rmi.RemoteRMIClientMenu


3. XỬ LÝ SỰ CỐ
-------------

3.1. Không thể kết nối:
   - Kiểm tra kết nối mạng giữa hai máy bằng lệnh ping
   - Đảm bảo tường lửa cho phép kết nối đến cổng 9090
   - Kiểm tra xem cổng 9090 có đang được sử dụng bởi ứng dụng khác không

3.2. Lỗi serialVersionUID:
   - Đảm bảo cả máy chủ và máy khách đều sử dụng cùng phiên bản JAR
   - Kiểm tra xem tất cả các lớp entity đều có serialVersionUID giống nhau

3.3. Lỗi ClassNotFoundException:
   - Đảm bảo classpath chứa tất cả các lớp cần thiết
   - Kiểm tra xem JAR file có chứa tất cả các lớp cần thiết không

3.4. Lỗi AccessControlException:
   - Đảm bảo đã cung cấp tệp rmi.policy và đường dẫn đúng
   - Kiểm tra nội dung của tệp rmi.policy có đúng không
