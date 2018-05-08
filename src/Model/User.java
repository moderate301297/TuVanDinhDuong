package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class User {
	private static ArrayList<Integer> arrayList;

	public static void InsertUser(String ten, String tendangnhap, String matkhau) throws SQLException {
		try (Connection conn = ConnectSQL.connectsql()) {
			String query = "INSERT INTO users(ten, ten_dang_nhap, mat_khau)" + " VALUES(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, ten);
			ps.setString(2, tendangnhap);
			ps.setString(3, matkhau);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.err.println("error: " + e);
		}
	}

	public static ArrayList<String> getUser(String tendangnhap, String matkhau) throws SQLException {
		ArrayList<String> arrayList = new ArrayList<>();
		try (Connection conn = ConnectSQL.connectsql()) {
			String query = "SELECT id, ten FROM users WHERE ten_dang_nhap = ? AND mat_khau = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, tendangnhap);
			ps.setString(2, matkhau);
			ResultSet rs;
			rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String ten = rs.getString("ten");
				arrayList.add(id);
				arrayList.add(ten);
			}
			conn.close();
		} catch (Exception e) {
			System.err.println("error: " + e);
		}
		return arrayList;
	}

	public static String getUserName(String id) throws SQLException {
		String name = null;
		try (Connection conn = ConnectSQL.connectsql()) {
			String query = "SELECT ten FROM users WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs;
			rs = ps.executeQuery();
			while (rs.next()) {
				name = rs.getString("ten");
			}
			conn.close();
		} catch (Exception e) {
			System.err.println("error: " + e);
		}
		return name;
	}

	public static void InsertUserIndex(String user_id, String docao, String cannang, String tuoi, String gioitinh,
			String mucdold) throws SQLException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String dateNow = dateFormat.format(date);
		System.out.println(dateNow);
		String created_at = dateNow;
		String updated_at = dateNow;
		String idNew = null;
		try (Connection conn = ConnectSQL.connectsql()) {
			String query = "SELECT id FROM user_index WHERE user_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user_id);
			ResultSet rs;
			rs = ps.executeQuery();
			while (rs.next()) {
				idNew = rs.getString("id");
			}
			System.out.println("idNew: " + idNew);
			if (idNew == null) {
				String query1 = "INSERT INTO user_index(user_id, do_cao, can_nang, tuoi, gioi_tinh, muc_do_lao_dong, created_at,updated_at)"
						+ " VALUES(?,?,?,?,?,?,?,?)";
				PreparedStatement ps1 = conn.prepareStatement(query1);
				ps1.setString(1, user_id);
				ps1.setString(2, docao);
				ps1.setString(3, cannang);
				ps1.setString(4, tuoi);
				ps1.setString(5, gioitinh);
				ps1.setString(6, mucdold);
				ps1.setString(7, created_at);
				ps1.setString(8, updated_at);
				ps1.executeUpdate();
			} else {
				String query2 = "UPDATE user_index SET do_cao = ?, can_nang = ?, tuoi = ?, gioi_tinh = ?, muc_do_lao_dong = ?, updated_at = ?"
						+ " WHERE user_id = ?";
				PreparedStatement ps2 = conn.prepareStatement(query2);
				ps2.setString(1, docao);
				ps2.setString(2, cannang);
				ps2.setString(3, tuoi);
				ps2.setString(4, gioitinh);
				ps2.setString(5, mucdold);
				ps2.setString(6, updated_at);
				ps2.setString(7, user_id);
				ps2.executeUpdate();
			}
			conn.close();
		} catch (Exception e) {
			System.err.println("error: " + e);
		}
	}

	public static void UpdateUserIndex(String user_id, int select, int index, float TDEE) throws SQLException {
		try (Connection conn = ConnectSQL.connectsql()) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			String dateNow = dateFormat.format(date);
			String updated_at = dateNow;
			String query = "UPDATE user_index SET select_value = ?, index_value = ?, TDEE = ?, updated_at = ?"
					+ " WHERE user_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, select);
			ps.setInt(2, index);
			ps.setFloat(3, TDEE);
			ps.setString(4, updated_at);
			ps.setString(5, user_id);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.err.println("error: " + e);
		}
	}

	public static void UpdateFavorite(String user_id, String sothich, String buaan) throws SQLException {
		try (Connection conn = ConnectSQL.connectsql()) {
			String query = "UPDATE user_favorite SET so_thich = ?, bua_an = ? WHERE user_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, sothich);
			ps.setString(2, buaan);
			ps.setString(3, user_id);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.err.println("error: " + e);
		}
	}

	public static boolean InsertFavorite(String sothich) throws SQLException {
		try (Connection conn = ConnectSQL.connectsql()) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			String dateNow = dateFormat.format(date);
			String created_at = dateNow;
			String id = null;
			String query1 = "SELECT id FROM favorite_user WHERE sothich = ?";
			PreparedStatement ps1 = conn.prepareStatement(query1);
			ps1.setString(1, sothich);
			ResultSet rs1;
			rs1 = ps1.executeQuery();
			while (rs1.next()) {
				id = rs1.getString("id");
			}
			if (id == null) {
				return false;
			} else {
				String query = "INSERT INTO favorite_user(so_thich,created_at) VALUE(?,?)";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, sothich);
				ps.setString(2, created_at);
				ps.executeUpdate();
				conn.close();
				return true;
			}
		} catch (Exception e) {
			System.err.println("error: " + e);
		}
		return false;
	}

	public static ArrayList<String> GetAllFavorite() throws SQLException {
		ArrayList<String> arrayList = new ArrayList<>();
		try (Connection conn = ConnectSQL.connectsql()) {
			String query = "SELECT so_thich FROM favorite_user";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs;
			rs = ps.executeQuery();
			while (rs.next()) {
				String so_thich = rs.getString("so_thich");
				arrayList.add(so_thich);
			}
			conn.close();
			return arrayList;
		} catch (Exception e) {
			System.err.println("error: " + e);
		}
		return null;
	}

	public static ArrayList<String> GetMucTieu(String user_id) throws SQLException {
		ArrayList<String> arrayList = new ArrayList<>();
		try (Connection conn = ConnectSQL.connectsql()) {
			String query = "SELECT select_value, index_value, TDEE FROM user_index WHERE user_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user_id);
			ResultSet rs;
			rs = ps.executeQuery();
			while (rs.next()) {
				String select = rs.getString("select_value");
				String index = rs.getString("index_value");
				String TDEE = rs.getString("TDEE");
				arrayList.add(select);
				arrayList.add(index);
				arrayList.add(TDEE);
			}
			conn.close();
			return arrayList;
		} catch (Exception e) {
			System.err.println("error: " + e);
		}
		return null;
	}

	public static String GetFavorite(String user_id, String buaan) throws SQLException {
		String so_thich = null;
		try (Connection conn = ConnectSQL.connectsql()) {
			String query = "SELECT so_thich FROM user_favorite WHERE user_id = ? AND bua_an = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user_id);
			ps.setString(2, buaan);
			ResultSet rs;
			rs = ps.executeQuery();
			while (rs.next()) {
				so_thich = rs.getString("so_thich");
			}
			conn.close();
		} catch (Exception e) {
			System.err.println("error: " + e);
		}
		return so_thich;
	}

	public static void UpdateMucTieu(String user_id, String muctieu) throws SQLException {
		try (Connection conn = ConnectSQL.connectsql()) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			String dateNow = dateFormat.format(date);
			String updated_at = dateNow;
			String query = "UPDATE user_index SET muc_tieu = ?, updated_at = ?" + " WHERE user_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, muctieu);
			ps.setString(2, updated_at);
			ps.setString(3, user_id);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.err.println("error: " + e);
		}
	}

	public static ArrayList<Integer> GetUserClick(String user_id) throws SQLException {
		ArrayList<Integer> arrayList = new ArrayList<>();
		try (Connection conn = ConnectSQL.connectsql()) {
			String query = "SELECT clicked_sang,clicked_trua,clicked_toi FROM hcstt.user_click WHERE user_id = ?;";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user_id);
			ResultSet rs;
			rs = ps.executeQuery();
			while (rs.next()) {
				int clickedSang = rs.getInt("clicked_sang");
				int clickedTrua = rs.getInt("clicked_trua");
				int clickedToi = rs.getInt("clicked_toi");
				arrayList.add(clickedSang);
				arrayList.add(clickedTrua);
				arrayList.add(clickedToi);
			}
			conn.close();
			return arrayList;
		} catch (Exception e) {
			System.err.println("error: " + e);
		}
		return arrayList;

	}

	public static void InsertUserClick(String user_id, int clickedSang, int clickedTrua, int clickedToi)
			throws SQLException {
		String idNew = null;
		try (Connection conn = ConnectSQL.connectsql()) {
			String query = "SELECT id FROM user_click WHERE user_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user_id);
			ResultSet rs;
			rs = ps.executeQuery();
			while (rs.next()) {
				idNew = rs.getString("id");
			}
			if (idNew == null) {
				String query1 = "INSERT INTO user_click(user_id, clicked_sang, clicked_trua, clicked_toi)"
						+ " VALUES(?,?,?,?)";
				PreparedStatement ps1 = conn.prepareStatement(query1);
				ps1.setString(1, user_id);
				ps1.setInt(2, clickedSang);
				ps1.setInt(3, clickedTrua);
				ps1.setInt(4, clickedToi);
				ps1.executeUpdate();
			} else {
				String query2 = "UPDATE user_click SET clicked_sang = ?, clicked_trua = ?, clicked_toi = ?"
						+ " WHERE user_id = ?";
				PreparedStatement ps2 = conn.prepareStatement(query2);
				ps2.setInt(1, clickedSang);
				ps2.setInt(2, clickedTrua);
				ps2.setInt(3, clickedToi);
				ps2.setString(4, user_id);
				ps2.executeUpdate();
			}
			conn.close();
		} catch (Exception e) {
			System.err.println("error: " + e);
		}
	}
}
