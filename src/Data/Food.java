/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author DoThanh
 */
public class Food {
    private int id;
    private String tenmon;
    private int soluong;
    private int protein;
    private int tinhbot;
    private int lipit;
    private int nhom;
    private long diem;
    private String status;
    private float calo;

    public float getCalo() {
        return calo;
    }

    public void setCalo(float calo) {
        this.calo = calo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
    public int getProtein(int protein) {
    	return protein;
    }
    
    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getTinhbot() {
        return tinhbot;
    }

    public void setTinhbot(int tinhbot) {
        this.tinhbot = tinhbot;
    }

    public int getLipit() {
        return lipit;
    }

    public void setLipit(int lipit) {
        this.lipit = lipit;
    }

    public int getNhom() {
        return nhom;
    }

    public void setNhom(int nhom) {
        this.nhom = nhom;
    }

    public long getDiem() {
        return diem;
    }

    public void setDiem(long diem) {
        this.diem = diem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void getProtein(int protein) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
