package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import connect.ConnectDB;
import model.HoaDonChiTiet;

public class HoaDonChiTietDAO {
    public List<Map<Integer, Object>> layThongTinHoaDonChiTiet() {
        List<Map<Integer, Object>> list = new ArrayList<>();
    
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getCon();
            String sql = "SELECT * FROM HOA_DON_CHI_TIET hdct JOIN CHI_TIET_SAN_PHAM ctsp ON hdct.MaCTSP = ctsp.MaCTSP JOIN SAN_PHAM sp ON sp.MaSP = ctsp.MaSP";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            // MaHDCT MaCTSP MaHD MaTT SoLuong DonGia MaKM GhiChu
            while (rs.next()) {
                int MaHDCT = rs.getInt("MaHDCT");
                int MaCTSP = rs.getInt("MaCTSP");
                int MaHD = rs.getInt("MaHD");
                int MaTT = rs.getInt("MaTT");
                int SoLuong = rs.getInt("SoLuong");
                double DonGia = rs.getDouble("DonGia");
                int MaKM = rs.getInt("MaKM");
                String GhiChu = rs.getString("GhiChu");
    
                String tenSP = rs.getString("TenSP");
    
                Map<Integer, Object> map = new HashMap<>();
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(MaHDCT, MaCTSP, MaHD, MaTT, SoLuong, DonGia, MaKM, GhiChu);
                map.put(1, hoaDonChiTiet);
                map.put(2, tenSP);
    
                list.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return list;
    }
    

    public Map<Integer, Object> timKiemHoaDonBangMa(int maHD) {
        Map<Integer, Object> map = new HashMap<>();
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getCon();
            String sql = "SELECT * FROM HOA_DON_CHI_TIET hdct JOIN CHI_TIET_SAN_PHAM ctsp ON hdct.MaCTSP = ctsp.MaCTSP JOIN SAN_PHAM sp ON sp.MaSP = ctsp.MaSP WHERE MaHD = ?";
            PreparedStatement statement = null;
            statement = con.prepareStatement(sql);
            statement.setInt(1, maHD);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int MaHDCT = rs.getInt("MaHDCT");
                int MaCTSP = rs.getInt("MaCTSP");
                int MaHD = rs.getInt("MaHD");
                int MaTT = rs.getInt("MaTT");
                int SoLuong = rs.getInt("SoLuong");
                double DonGia = rs.getDouble("DonGia");
                int MaKM = rs.getInt("MaKM");
                String GhiChu = rs.getString("GhiChu");

                String tenSP = rs.getString("TenSP");

                HoaDonChiTiet HoaDonChiTiet = new HoaDonChiTiet(MaHDCT, MaCTSP, MaHD, MaTT, SoLuong, DonGia, MaKM,
                        GhiChu);
                map.put(1, HoaDonChiTiet);
                map.put(2, tenSP);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
}
