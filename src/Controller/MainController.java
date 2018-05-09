package Controller;

import Model.User;
import Model.QueryFood;
import Util.Common;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import Data.AllFood;
import Data.Calo;
import Data.Food;

public class MainController {
	public float[] CaloSang = new float[3];
	public float[] CaloTrua = new float[3];
	public float[] CaloToi = new float[3];
	float pro, lipit, glu;
	final int delta = 10;

	public MainController() {
	}

	// tra ve gia tri MBI khi co chieu cao va can nang.
	public float getBMI(float chieucao, float cannang) {
		float BMI = 0;
		BMI = (cannang / chieucao) / chieucao * 10000;// tinh chieu cao theo m
		return BMI;
	}

	public float getlaodong(int index) {
		float iLaodong = 0;
		if (index == 0)
			iLaodong = (float) 1.2;
		if (index == 1)
			iLaodong = (float) 1.375;
		if (index == 2)
			iLaodong = (float) 1.55;
		if (index == 3)
			iLaodong = (float) 1.725;
		if (index == 4)
			iLaodong = (float) 1.9;
		return iLaodong;
	}

	public float getgioitinh(int index) {
		float x = 0;
		int gioitinh = index;
		if (gioitinh == 0)
			x = 5;// nam
		if (gioitinh == 1)
			x = -161;// nu
		return x;
	}

	public String getResult(float chieucao, float cannang) {
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

	public float getcan(int select, int index) {
		if (select == 0) {
			if (index == 0)
				return 1;
			if (index == 1)
				return 2;
			if (index == 2)
				return 3;
			if (index == 3)
				return 4;
			if (index == 4)
				return 5;
		} else if (select == 1) {
			if (index == 0)
				return (float) -0.5;
			if (index == 1)
				return -1;
			if (index == 2)
				return (float) -1.5;
			if (index == 3)
				return -2;
		} else if (select == 2)
			return 0;
		return 0;
	}

	public float getTDEE(int laodong, int gioitinh, float chieucao, float cannang, float tuoi) {
		float x = 0;
		float BMR = 0;
		float iLaodong = getlaodong(laodong);
		x = getgioitinh(gioitinh);
		BMR = (float) (10 * cannang + 6.25 * chieucao - 5 * tuoi + x);
		float TDEE = BMR * iLaodong;
		TDEE = (float) (Math.round(TDEE * 100) / 100.0d);
		return TDEE;// luong calo can cho hoat dong co the
	}

	public ArrayList<Float> getCaloNeed(int select, int index, float TDEE) {
		ArrayList<Float> arrayList = new ArrayList<>();
		float a = getcan(select, index);
		if (a > 0) {
			pro = (float) (0.5 * (TDEE + 250 * a));
			lipit = (float) (0.2 * (TDEE + 250 * a));
			glu = (float) (0.3 * (TDEE + 250 * a));
		} else {
			if (a < 0) {
				pro = (float) (0.6 * (TDEE + 250 * a));
				lipit = (float) (0.25 * (TDEE + 250 * a));
				glu = (float) (0.15 * (TDEE + 250 * a));
			} else {
				pro = (float) (0.5 * TDEE);
				lipit = (float) (0.2 * TDEE);
				glu = (float) (0.3 * TDEE);
			}
		}
		CaloSang[0] = pro * 2 / 11;
		CaloSang[0] = (float) (Math.round(CaloSang[0] * 100) / 100.0d);
		CaloSang[1] = glu * 2 / 11;
		CaloSang[1] = (float) (Math.round(CaloSang[1] * 100) / 100.0d);
		CaloSang[2] = lipit * 2 / 11;
		CaloSang[2] = (float) (Math.round(CaloSang[2] * 100) / 100.0d);
		float tongCaloSang = CaloSang[0] + CaloSang[1] + CaloSang[2];
		arrayList.add(tongCaloSang);
		CaloTrua[0] = pro * 5 / 11;
		CaloTrua[0] = (float) (Math.round(CaloTrua[0] * 100) / 100.0d);
		CaloTrua[1] = glu * 5 / 11;
		CaloTrua[1] = (float) (Math.round(CaloTrua[1] * 100) / 100.0d);
		CaloTrua[2] = lipit * 5 / 11;
		CaloTrua[2] = (float) (Math.round(CaloTrua[2] * 100) / 100.0d);
		float tongCaloTrua = CaloTrua[0] + CaloTrua[1] + CaloTrua[2];
		arrayList.add(tongCaloTrua);
		CaloToi[0] = pro * 4 / 11;
		CaloToi[0] = (float) (Math.round(CaloToi[0] * 100) / 100.0d);
		CaloToi[1] = glu * 4 / 11;
		CaloToi[1] = (float) (Math.round(CaloToi[1] * 100) / 100.0d);
		CaloToi[2] = lipit * 4 / 11;
		CaloToi[2] = (float) (Math.round(CaloToi[2] * 100) / 100.0d);
		float tongCaloToi = CaloToi[0] + CaloToi[1] + CaloToi[2];
		arrayList.add(tongCaloToi);
		return arrayList;
	}

	public ArrayList<ArrayList<Food>> getFoodTungBua(float calo, int i, String idUsed) {
		ArrayList<ArrayList<Food>> arrayList = new ArrayList<>();
		if (i == 0) {
			String so_thich = GetTableFavorite(idUsed, "bua sang");
			arrayList = GetFood(calo, "table_mon_an", "bua sang",so_thich);
		} else if (i == 1) {
			String so_thich = GetTableFavorite(idUsed, "bua trua");
			arrayList = GetFood(calo, "table_mon_an", "bua trua",so_thich);
		} else {
			String so_thich = GetTableFavorite(idUsed, "bua toi");
			arrayList = GetFood(calo, "table_mon_an", "bua toi",so_thich);
		}
		return arrayList;
	}

	public String GetTableFavorite(String user_id, String buaan) {
		String so_thich = null;
		try {
			so_thich = User.GetFavorite(user_id, buaan);
			System.out.println("So thich" + so_thich);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		}
		return so_thich;
	}

	private ArrayList<ArrayList<Food>> GetFood(float calo, String tablemonan, String buaan, String so_thich) {
		ArrayList<Calo> dsfood = new ArrayList<>();
		ArrayList<String> dsfoodnew1 = new ArrayList<>();
		ArrayList<String> dsfoodnew2 = new ArrayList<>();
		ArrayList<String> dsfoodnew3 = new ArrayList<>();
		ArrayList<Food> result1 = new ArrayList<>();
		ArrayList<Food> result2 = new ArrayList<>();
		ArrayList<Food> result3 = new ArrayList<>();
		ArrayList<ArrayList<Food>> result = new ArrayList<>();
		if (so_thich == "Không" || so_thich == null) {
			try {
				dsfood = QueryFood.SearchDsFood(tablemonan, buaan, calo);// all food
				System.out.println("dsfood: " + dsfood.size());
			} catch (SQLException e) {
				System.out.println("error: " + e);
			}
		} else {
			try {
				dsfood = QueryFood.SearchDsFoodToFavorite(tablemonan, buaan, calo,so_thich);// all food
				System.out.println("dsfood: " + dsfood.size());
			} catch (SQLException e) {
				System.out.println("error: " + e);
			}
		}
		// thuc don 1 mon
		for (int i = 0; i < dsfood.size(); i++) {
			float a = Float.parseFloat(dsfood.get(i).getCalo()) - calo;
			a = Math.abs(a);
			if (a < 200) {
				dsfoodnew1.add(dsfood.get(i).getId());
			}
		}
		try {
			result1 = QueryFood.SearchFood(dsfoodnew1, tablemonan, buaan);
			result.add(result1);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		}

			// thuc don 2 mon
			for (int i = 0; i < dsfood.size(); i++) {
				for (int j = i + 1; j < dsfood.size(); j++) {
					float a = Float.parseFloat(dsfood.get(i).getCalo()) + Float.parseFloat(dsfood.get(j).getCalo())
							- calo;
					a = Math.abs(a);
					if (a < 30) {
						dsfoodnew2.add(dsfood.get(i).getId());
						dsfoodnew2.add(dsfood.get(j).getId());
					}
				}
			}
			try {
				result2 = QueryFood.SearchFood(dsfoodnew2, tablemonan, buaan);
				result.add(result2);
			} catch (SQLException e) {
				System.out.println("error: " + e);
			}

			// thuc don 3 mon
			for (int i = 0; i < dsfood.size(); i++) {
				for (int j = i + 1; j < dsfood.size(); j++) {
					for (int k = j + 1; k < dsfood.size(); k++) {
						float a = Float.parseFloat(dsfood.get(i).getCalo()) + Float.parseFloat(dsfood.get(j).getCalo())
								+ Float.parseFloat(dsfood.get(k).getCalo()) - calo;
						a = Math.abs(a);
						if (a < 30) {
							dsfoodnew3.add(dsfood.get(i).getId());
							dsfoodnew3.add(dsfood.get(j).getId());
							dsfoodnew3.add(dsfood.get(k).getId());
						}
					}
				}
			}
			System.out.println("dsfoodnew3: " + dsfoodnew3.size());
			try {
				result3 = QueryFood.SearchFood(dsfoodnew3, tablemonan, buaan);
				System.out.println("result3: " + result3.size());
				result.add(result3);
			} catch (SQLException e) {
				System.out.println("error: " + e);
			}
		return result;
	}

	public static ArrayList<String> getUser(String ten, String matkhau) {
		ArrayList<String> arrayList = null;
		try {
			arrayList = User.getUser(ten, matkhau);
		} catch (Exception e) {
			System.err.println("error: " + e);
		}
		return arrayList;
	}

	public static ArrayList<AllFood> GetAllFood() {
		ArrayList<AllFood> arrayList = null;
		try {
			arrayList = QueryFood.getAllFood();
		} catch (Exception e) {
			System.err.println("error: " + e);
		}
		return arrayList;
	}
}
