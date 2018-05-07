/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Data.AllFood;
import Data.Calo;
import Data.Food;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryFood {

	public static ArrayList<Calo> SearchDsFood(String tablemonan, String buaan, float calo) throws SQLException {
		try (Connection conn = ConnectSQL.connectsql()) {
			ArrayList<Calo> dsfood = new ArrayList<>();
			String query = "SELECT id,tong_calo FROM " + tablemonan + " WHERE bua_an = ? AND tong_calo < ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, buaan);
			ps.setFloat(2, calo + 30);
			ResultSet rs;
			rs = ps.executeQuery();
			while (rs.next()) {
				Calo dscalo = new Calo();
				String tongcalo = rs.getString("tong_calo");
				String id = rs.getString("id");
				dscalo.setId(id);
				dscalo.setCalo(tongcalo);
				dsfood.add(dscalo);
			}
			conn.close();
			return dsfood;
		} catch (Exception e) {
			System.out.println("error: " + e);
		}
		return null;
	}

	public static ArrayList<Food> SearchFood(ArrayList<String> id, String tablemonan, String buaan)
			throws SQLException {
		try (Connection conn = ConnectSQL.connectsql()) {
			ArrayList<Food> array = new ArrayList<>();
			for (int i = 0; i < id.size(); i++) {
				String query = "SELECT ten_mon_an, don_vi, tong_calo FROM " + tablemonan + " WHERE id = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, id.get(i));
				ResultSet rs;
				rs = ps.executeQuery();
				while (rs.next()) {
					Food food = new Food();
					String tenmon = rs.getString("ten_mon_an");
					String donvi = rs.getString("don_vi");
					String tongcalo = rs.getString("tong_calo");
					food.setTenmon(tenmon);
					food.setSoluong(donvi);
					food.setCalo(tongcalo);
					array.add(food);
				}
			}
			conn.close();
			return array;
		} catch (Exception e) {
			System.out.println("error: " + e);
		}
		return null;
	}

	/**
	 * hien thi danh sach cac mon an
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<String> ShowAll() throws SQLException {
		try (Connection conn = ConnectSQL.connectsql()) {
			String query = "SELECT * FROM tbl_monan";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs;
			ArrayList<String> food = new ArrayList<String>();
			rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String tenmon = rs.getString("tenmon");
				String soluong = rs.getString("soluong");
				String protein = rs.getString("protein");
				String tinhbot = rs.getString("tinhbot");
				String lipit = rs.getString("lipit");
				food.add(id);
				food.add(tenmon);
				food.add(soluong);
				food.add(protein);
				food.add(tinhbot);
				food.add(lipit);
			}
			conn.close();
			return food;
		} catch (Exception e) {
			System.out.println("error: " + e);
		}
		return null;
	}

	public static void InsertFood(String tenmon, String soluong, String protein, String tinhbot, String lipit,
			String nhom, String diem) throws SQLException {
		try (Connection conn = ConnectSQL.connectsql()) {
			String query = "INSERT INTO tbl_monan(tenmon, soluong, protein, tinhbot, lipit, nhom, diem)"
					+ " VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, tenmon);
			ps.setString(2, soluong);
			ps.setString(3, protein);
			ps.setString(4, tinhbot);
			ps.setString(5, lipit);
			ps.setString(6, nhom);
			ps.setString(7, diem);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.err.println("error: " + e);
			;
		}
	}

	/*
	 * get all name food
	 */
	public static ArrayList<AllFood> getAllFood() throws SQLException {
		ArrayList<AllFood> arrayList = new ArrayList<>();
		try (Connection conn = ConnectSQL.connectsql()) {
			String query = "SELECT id,ten_mon_an,don_vi,tong_calo,bua_an FROM hcstt.table_mon_an;";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs;
			rs = ps.executeQuery();
			while (rs.next()) {
				AllFood allFood = new AllFood();
				String id = rs.getString("id");
				String mon = rs.getString("ten_mon_an");
				String so_luong = rs.getString("don_vi");
				String tong_calo = rs.getString("tong_calo");
				String bua_an = rs.getString("bua_an");
				allFood.setId(id);
				allFood.setTenmon(mon);
				allFood.setSoluong(so_luong);
				allFood.setCalo(tong_calo);
				allFood.setBuaAn(bua_an);
				arrayList.add(allFood);
			}
			conn.close();
			return arrayList;
		} catch (Exception e) {

		}
		return null;
	}

	public static ArrayList<String> getInforFoodForName(String string) {
		ArrayList<String> infor = new ArrayList<>();
		try (Connection conn = ConnectSQL.connectsql()) {
			String query = "SELECT id,tenmon,diem,status FROM tbl_monan WHERE tenmon = '" + string + "'";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs;
			rs = ps.executeQuery();
			while (rs.next()) {
				String idMon = rs.getString("id");
				String tenMon = rs.getString("tenmon");
				String diem = rs.getString("diem");
				String status = rs.getString("status");
				infor.add(idMon);
				infor.add(tenMon);
				infor.add(diem);
				infor.add(status);
				System.out.println(status);
			}
			conn.close();
			return infor;
		} catch (Exception e) {

		}
		return infor;
	}

	public void upDateInforFoodLike(String id) {
		try (Connection conn = ConnectSQL.connectsql()) {
			int diem = 0;
			String query = "SELECT diem FROM tbl_monan WHERE id = " + id;
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs;
			rs = ps.executeQuery();
			while (rs.next()) {
				diem = rs.getInt("diem");
				// diem = Integer.parseInt(diemHienTai);
				System.out.println("diem la " + diem);
			}
			diem = diem + 5;
			String queryUpdate = "UPDATE tbl_monan SET diem = " + diem + ", status = 1 WHERE id = " + id;
			// String queryUpdate2 = "UPDATE tbl_monan SET status = 1 WHERE tenmon =
			// '"+name+"'";

			ps.executeUpdate(queryUpdate);
			// ps.executeUpdate(queryUpdate2);
			conn.close();
		} catch (Exception e) {

		}
	}

	public void upDateInforFoodDisLike(String id) {
		try (Connection conn = ConnectSQL.connectsql()) {
			int diem = 0;
			String query = "SELECT diem FROM tbl_monan WHERE id = " + id;
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs;
			rs = ps.executeQuery();
			while (rs.next()) {
				diem = rs.getInt("diem");
				System.out.println("diem la " + diem);
			}
			diem = diem - 5;
			String queryUpdate = "UPDATE tbl_monan SET diem = " + diem + ", status = -1 WHERE id = " + id;
			// String queryUpdate2 = "UPDATE tbl_monan SET status = -1 WHERE tenmon =
			// '"+name+"'";

			ps.executeUpdate(queryUpdate);
			// ps.executeUpdate(queryUpdate2);
			conn.close();
		} catch (Exception e) {

		}
	}

	public static ArrayList<Food> GetCaloFood(int nhom) {
		ArrayList<Food> array = new ArrayList<Food>();
		try (Connection conn = ConnectSQL.connectsql()) {
			String query = "SELECT * FROM tbl_monan WHERE nhom = " + nhom + " ORDER BY diem desc";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs;
			rs = ps.executeQuery();
			while (rs.next()) {
				Food food = new Food();
				String tenmon = rs.getString("tenmon");
				food.setTenmon(tenmon);
				array.add(food);
			}
			return array;
		} catch (Exception e) {

		}
		return null;
	}
           public static ArrayList<String> getFavoriteFood(){
        ArrayList<String > favorite = new ArrayList<String>();
        try (Connection conn = ConnectSQL.connectsql()){
            String querry = "SELECT so_thich FROM favorite_user";
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String a = rs.getString("so_thich");
                favorite.add(a);
            }
            return favorite;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
