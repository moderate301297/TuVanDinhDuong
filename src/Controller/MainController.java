/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.Food;
import Model.ConnectSQL;
import Model.QueryFood;
import Util.Common;
import Util.Common.LuaChon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainController {
    public float[] CaloSang = new float[3];
    public float[] CaloTrua = new float[3];
    public float[] CaloToi = new float[3];
    float pro, lipit, glu;
    final int delta = 10;

    public MainController() {
    }
    
    // tra ve gia tri MBI khi co chieu cao va can nang.
    public float getBMI(float chieucao, float cannang){
        float BMI = 0;
        BMI = (cannang/chieucao)/chieucao*10000;
        return BMI;
    }

    public float getlaodong(int index){
        float iLaodong = 0;
        if(index == 0) iLaodong = (float) 1.2;
        if(index == 1) iLaodong = (float) 1.375;
        if(index == 2) iLaodong = (float) 1.55;
        if(index == 3) iLaodong = (float) 1.725;
        if(index == 4) iLaodong = (float) 1.9;
        return iLaodong;
    }
    
    public float getgioitinh(int index){
        float x = 0;
        int gioitinh = index;
        if(gioitinh == 0) x = 5;
        if(gioitinh == 1) x = -161;
        return x;
    }
    
    public String getResult(float chieucao, float cannang){
        float BMI = getBMI(chieucao, cannang);
        if (BMI < Common.CHI_SO_GAY) {
            return Common.GAY;
        }
        if (BMI >= Common.CHI_SO_GAY && BMI < Common.CHI_BINH_THUONG) {
            return Common.BINH_THUONG;
        }
        if (BMI >= Common.CHI_BINH_THUONG && BMI < Common.CHI_SO_THUA_CAN) {
            return Common.THUA_CAN;
        }
        if (BMI >= Common.CHI_SO_THUA_CAN) {
            return Common.BEO_PHI;
        }
        return Common.BINH_THUONG;
    }
    
    public float getcan(int select, int tangcan, int giamcan){
        float ican = 0;
        if(select == 0){
            int gioitinh = tangcan;
            if(gioitinh == 0) return 1;
            if(gioitinh == 1) return 2;
            if(gioitinh == 2) return 3;
            if(gioitinh == 3) return 4;
            if(gioitinh == 4) return 5;
        }
        else if(select == 1){
            int gioitinh = giamcan;
            if(gioitinh == 0) return (float) -0.5;
            if(gioitinh == 1) return -1;
            if(gioitinh == 2) return (float) -1.5;
            if(gioitinh == 3) return -2;
        }
        else if(select == 2) return 0;
            return 0;
    }
    
    public float getTDEE(int laodong, int gioitinh, float chieucao, float cannang, float tuoi){
        float x = 0;
        float BMR = 0;
        float iLaodong = getlaodong(laodong);
        x = getgioitinh(gioitinh);
        BMR = (float) (10*cannang + 6.25*chieucao - 5*tuoi + x);
        float TDEE = BMR*iLaodong;
        return TDEE;
    }
    
    public float getCaloNeed (int select, int tangcan, int giamcan, float TDEE){
        float calo = 0;
        float a = getcan(select, tangcan, giamcan);
        if(a > 0){
            pro = (float) (0.5*(TDEE + 250*a));
            lipit = (float) (0.2*(TDEE + 250*a));
            glu = (float) (0.3*(TDEE + 250*a));
        }else {
            if(a < 0){
                pro = (float) (0.6*(TDEE + 250*a));
                lipit = (float) (0.25*(TDEE + 250*a));
                glu = (float) (0.15*(TDEE + 250*a));
            }else{
                pro = (float) (0.5*TDEE);
                lipit = (float) (0.2*TDEE);
                glu = (float) (0.3*TDEE);
            }
        }
        CaloSang = new float[3];
        CaloSang[0] = pro*2/11;
        CaloSang[1] = glu*2/11;
        CaloSang[2] = lipit*2/11;
        CaloTrua[0] = pro*5/11;
        CaloTrua[1] = glu*5/11;
        CaloTrua[2] = lipit*5/11;
        CaloToi[0] = pro*4/11;
        CaloToi[1] = glu*4/11;
        CaloToi[2] = lipit*4/11;    
        calo = pro + glu + lipit;
        return calo;
    }
    
    private int GetCaloFood(int protein, int tinhbot, int lipit) {
        return (protein + tinhbot + lipit);
    }
    
    public String ChangeFoods(String tenmon, int nhom, float sumcalo) {
        ArrayList<Food> array = new QueryFood().GetCaloFood(nhom);
        float min = sumcalo - 20;
        float max = sumcalo + 20;
        for (int i = 0; i < array.size(); i++) {
            Food food = array.get(i);
            int protein = food.getProtein();
            int tinhbot = food.getTinhbot();
            int lipit = food.getLipit();
            float calo = GetCaloFood(protein, tinhbot, lipit);
            food.setCalo(calo);
            if(min < calo && calo < max) {
                if(!tenmon.equals(food.getTenmon()))
                    return food.getTenmon();
            }
        }
        
        return null;
    }
    
    public void Insert2Table(int iNhom, float [] Calo, Vector vUnlike, JTable table1, JTable table2, JTable table3){

        float ProteinClone = 0;
        float TinhbotClone = 0;
        float LipitClone = 0;

        float ProteinClone1 = 0;
        float TinhbotClone1 = 0;
        float LipitClone1 = 0;

        float prt;
        float tb;
        float lip;

        ConnectSQL connection = new ConnectSQL();
        Connection con = connection.connectsql();
        ResultSet rs = null;
        String sqlCommand = null;
        sqlCommand = "SELECT * FROM cstt.tbl_monan WHERE nhom = '" + iNhom + "' OR nhom = '4' ORDER BY nhom, diem DESC";
        Statement st;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sqlCommand);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        try {
            ProteinClone = Calo[0];
            TinhbotClone = Calo[1];
            LipitClone   = Calo[2];
            while(rs.next())
            {
                prt = rs.getInt(4);
                tb = rs.getInt(5);
                lip = rs.getInt(6);
                Object[] row = new Object[3];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2); //Tên món ăn
                row[2] = rs.getString(3); //Khối lượng
                
                //Nếu gặp món ăn cần đổi thì continue;
                int iSize = vUnlike.size();
                boolean iCheck = false;
                for(int i = 0; i < iSize; i++)
                {
                    if(row[0].equals(vUnlike.get(i)))
                        iCheck = true;
                }
                if(iCheck)
                    continue;
                DefaultTableModel model = null;
                switch(iNhom)
                {
                    case 1: 
                        model = (DefaultTableModel) table1.getModel();
                        break;
                    case 2: 
                        model = (DefaultTableModel) table2.getModel();
                        break;
                    case 3: 
                        model = (DefaultTableModel) table3.getModel();
                        break;
                }
//                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                               
                ProteinClone = ProteinClone - prt;
                TinhbotClone = (TinhbotClone - tb);
                LipitClone   = LipitClone   - lip;
                if(ProteinClone > 0 && TinhbotClone > 0 && LipitClone > 0)
                {
                    model.addRow(row);
                }
                else{
                    ProteinClone = ProteinClone + prt;
                    TinhbotClone = TinhbotClone + tb;
                    LipitClone   = LipitClone   + lip;
                    if((Math.abs(ProteinClone) < delta) &&
                            (Math.abs(TinhbotClone) < delta) &&
                            (Math.abs(LipitClone) < delta))
                    {
                       // model.addRow(row);
                        break;
                    }
                }
            }
        } catch (SQLException ex) {
            
        }
    }
    
    public ArrayList<String>getInforFood (String name){
        return new QueryFood().getInforFoodForName(name);
    }
    
    public void upDateFood (String id, boolean isLike){
        if (isLike) {
            new QueryFood().upDateInforFoodLike(id);
        }else{
            new QueryFood().upDateInforFoodDisLike(id);
        }
    }
    
    public static void main(String[] args) {
        String st = new MainController().ChangeFoods("Thịt chân giò luộc", 2, 300);
        System.out.println(st);
    }
}
