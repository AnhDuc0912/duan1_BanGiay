package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import connect.ConnectDB;
import model.HoaDon;
import model.HoaDon;

public class HoaDonDAO {
    public List<HashMap<Integer, Object>> layThongTinHoaDon() {
        List<HashMap<Integer, Object>> list = new ArrayList<>();
        HashMap<Integer, Object> hashMap = new HashMap<>();
        HoaDon HoaDon = null;
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getCon();
            String sql = "SELECT *  FROM HOA_DON hd JOIN NHAN_VIEN nv ON hd.MaNV = nv.MaNV JOIN THONG_TIN_KH ttk ON hd.MaTTKH = ttk.MaTTKH";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int MaHD = rs.getInt("MaHD");
                String NgayTao = rs.getString("NgayTao");
                double TongTien = rs.getDouble("TongTien");
                boolean TrangThai = rs.getBoolean("TrangThai");

                int MaTTKH = rs.getInt("MaTTKH");
                int MaNV = rs.getInt("MaNV");
                String hoTenNhanVien = rs.getString("HoTen");
                String tenKH = rs.getString("TenKH");

                HoaDon = new HoaDon(MaHD, NgayTao, TongTien, TrangThai, MaTTKH, MaNV);
                hashMap.put(1, HoaDon);
                hashMap.put(2, hoTenNhanVien);
                hashMap.put(3, tenKH);

                list.add(hashMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public HashMap<Integer, Object> timKiemHoaDonBangMa(int maHD) {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getCon();
            String sql = "SELECT *  FROM HOA_DON hd JOIN NHAN_VIEN nv ON hd.MaNV = nv.MaNV JOIN THONG_TIN_KH ttk ON hd.MaTTKH = ttk.MaTTKH WHERE MaHD = ?";
            PreparedStatement statement = null;
            statement = con.prepareStatement(sql);
            statement.setInt(1, maHD);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                int MaHD = rs.getInt("MaHD");
                String NgayTao = rs.getString("NgayTao");
                double TongTien = rs.getDouble("TongTien");
                boolean TrangThai = rs.getBoolean("TrangThai");

                int MaTTKH = rs.getInt("MaTTKH");
                int MaNV = rs.getInt("MaNV");
                String hoTenNhanVien = rs.getString("HoTen");
                String tenKH = rs.getString("TenKH");

                HoaDon HoaDon = new HoaDon(MaHD, NgayTao, TongTien, TrangThai, MaTTKH, MaNV);
                hashMap.put(1, HoaDon);
                hashMap.put(2, hoTenNhanVien);
                hashMap.put(3, tenKH);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hashMap;
    }
}
