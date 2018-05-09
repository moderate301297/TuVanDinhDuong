/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Views;

import Controller.MainController;
import Data.Food;
import Model.User;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

public class ResultMenuView extends JFrame {

	ArrayList<ArrayList<Food>> arrayListFood = new ArrayList<>();
	MainController controller = new MainController();
	public float[] CaloSang = new float[3];
	public float[] CaloTrua = new float[3];
	public float[] CaloToi = new float[3];
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButtonViewAll;
	private JLabel jLabel1;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JScrollPane jScrollPane3;
	private JTable jTable1;
	private JTable jTable2;
	private JTable jTable3;
	private JLabel labelCalo;
	String idUsed;
	ArrayList<Food> resultFoodSang1, resultFoodSang2, resultFoodSang3;
	ArrayList<Food> resultFoodTrua1, resultFoodTrua2, resultFoodTrua3;
	ArrayList<Food> resultFoodToi1, resultFoodToi2, resultFoodToi3;
	String[][] objectSang = new String[100][3];
	String[][] objectTrua = new String[100][3];
	String[][] objectToi = new String[100][3];
	float calo;
	int sizeResultSang;
	int sizeResultTrua;
	int sizeResultToi;
	int clickedSang = 0, clickedTrua = 0, clickedToi = 0;

	// End of variables declaration//GEN-END:variables

	public ResultMenuView(String id) {
		idUsed = id;
		System.out.println("start------->");
		processDB(idUsed);
		System.out.println("stop process------->");
		initComponents(idUsed);
	}

	public void processDB(String idUsed) {
		ArrayList<Float> arrayList = new ArrayList<>();
		ArrayList<Integer> arrayListClick = new ArrayList<>();
		ArrayList<String> arrayListMucTieu = new ArrayList<>();
		try {
			arrayListMucTieu = User.GetMucTieu(idUsed);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (arrayListMucTieu.size() == 0) {
		} else {
			String select = arrayListMucTieu.get(0);
			int selectNew = Integer.parseInt(select);
			String index = arrayListMucTieu.get(1);
			int indexNew = Integer.parseInt(index);
			String TDEE = arrayListMucTieu.get(2);
			float TDEENew = Float.parseFloat(TDEE);
			arrayList = controller.getCaloNeed(selectNew, indexNew, TDEENew);

			// bua sang
			calo = arrayList.get(0);
			System.out.println("caloSang: " + calo);
			arrayListFood = controller.getFoodTungBua(calo, 0, idUsed);
			if (arrayListFood.size() == 0) {
				sizeResultSang = 0;
			} else if (arrayListFood.size() == 1) {
				resultFoodSang1 = arrayListFood.get(0);
				sizeResultSang = resultFoodSang1.size();
			} else if (arrayListFood.size() == 2) {
				resultFoodSang1 = arrayListFood.get(0);
				resultFoodSang2 = arrayListFood.get(1);
				sizeResultSang = resultFoodSang1.size() + resultFoodSang2.size();
			} else if (arrayListFood.size() == 3) {
				resultFoodSang1 = arrayListFood.get(0);
				resultFoodSang2 = arrayListFood.get(1);
				resultFoodSang3 = arrayListFood.get(2);
				sizeResultSang = resultFoodSang1.size() + resultFoodSang2.size() + resultFoodSang3.size();
			}
			System.out.println("sizeResultSang: " + sizeResultSang);

			// bua trua
			calo = arrayList.get(1);
			System.out.println("caloTrua: " + calo);
			arrayListFood = controller.getFoodTungBua(calo, 1, idUsed);
			if (arrayListFood.size() == 0) {
				sizeResultTrua = 0;
			} else if (arrayListFood.size() == 1) {
				resultFoodTrua1 = arrayListFood.get(0);
				sizeResultTrua = resultFoodTrua1.size();
			} else if (arrayListFood.size() == 2) {
				resultFoodTrua1 = arrayListFood.get(0);
				resultFoodTrua2 = arrayListFood.get(1);
				sizeResultTrua = resultFoodTrua1.size() + resultFoodTrua2.size();
			} else if (arrayListFood.size() == 3) {
				resultFoodTrua1 = arrayListFood.get(0);
				resultFoodTrua2 = arrayListFood.get(1);
				resultFoodTrua3 = arrayListFood.get(2);
				sizeResultTrua = resultFoodTrua1.size() + resultFoodTrua2.size() + resultFoodTrua3.size();
			}

			// bua toi
			calo = arrayList.get(2);
			System.out.println("caloToi: " + calo);
			arrayListFood = controller.getFoodTungBua(calo, 2, idUsed);
			if (arrayListFood.size() == 0) {
				sizeResultToi = 0;
			} else if (arrayListFood.size() == 1) {
				resultFoodToi1 = arrayListFood.get(0);
				sizeResultToi = resultFoodToi1.size();
			} else if (arrayListFood.size() == 2) {
				resultFoodToi1 = arrayListFood.get(0);
				resultFoodToi2 = arrayListFood.get(1);
				sizeResultToi = resultFoodToi1.size() + resultFoodToi2.size();
			} else if (arrayListFood.size() == 3) {
				resultFoodToi1 = arrayListFood.get(0);
				resultFoodToi2 = arrayListFood.get(1);
				resultFoodToi3 = arrayListFood.get(2);
				sizeResultToi = resultFoodToi1.size() + resultFoodToi2.size() + resultFoodToi3.size();
			}
			System.out.println("sizeResultToi: " + sizeResultToi);

			try {
				arrayListClick = User.GetUserClick(idUsed);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			if (arrayListClick == null) {
				// bua sang
				if (resultFoodSang1.size() != 0) {
					Food result1 = resultFoodSang1.get(0);
					objectSang[0][0] = result1.getTenmon();
					objectSang[0][1] = result1.getSoluong();
					objectSang[0][2] = result1.getCalo();
				} else if (resultFoodSang2.size() != 0) {
					Food result1 = resultFoodSang2.get(0);
					Food result11 = resultFoodSang2.get(1);
					objectSang[0][0] = result1.getTenmon();
					objectSang[0][1] = result1.getSoluong();
					objectSang[0][2] = result1.getCalo();
					objectSang[1][0] = result11.getTenmon();
					objectSang[1][1] = result11.getSoluong();
					objectSang[1][2] = result11.getCalo();
				} else if (resultFoodSang3.size() != 0) {
					Food result1 = resultFoodSang3.get(0);
					Food result11 = resultFoodSang3.get(1);
					Food result111 = resultFoodSang3.get(2);
					objectSang[0][0] = result1.getTenmon();
					objectSang[0][1] = result1.getSoluong();
					objectSang[0][2] = result1.getCalo();
					objectSang[1][0] = result11.getTenmon();
					objectSang[1][1] = result11.getSoluong();
					objectSang[1][2] = result11.getCalo();
					objectSang[2][0] = result111.getTenmon();
					objectSang[2][1] = result111.getSoluong();
					objectSang[2][2] = result111.getCalo();
				}

				// bua trua
				if (resultFoodTrua1.size() != 0) {
					Food result1 = resultFoodTrua1.get(0);
					objectTrua[0][0] = result1.getTenmon();
					objectTrua[0][1] = result1.getSoluong();
					objectTrua[0][2] = result1.getCalo();
				} else if (resultFoodTrua2.size() != 0) {
					Food result1 = resultFoodTrua2.get(0);
					Food result11 = resultFoodTrua2.get(1);
					objectTrua[0][0] = result1.getTenmon();
					objectTrua[0][1] = result1.getSoluong();
					objectTrua[0][2] = result1.getCalo();
					objectTrua[1][0] = result11.getTenmon();
					objectTrua[1][1] = result11.getSoluong();
					objectTrua[1][2] = result11.getCalo();
				} else if (resultFoodTrua3.size() != 0) {
					Food result1 = resultFoodTrua3.get(0);
					Food result11 = resultFoodTrua3.get(1);
					Food result111 = resultFoodTrua3.get(2);
					objectTrua[0][0] = result1.getTenmon();
					objectTrua[0][1] = result1.getSoluong();
					objectTrua[0][2] = result1.getCalo();
					objectTrua[1][0] = result11.getTenmon();
					objectTrua[1][1] = result11.getSoluong();
					objectTrua[1][2] = result11.getCalo();
					objectTrua[2][0] = result111.getTenmon();
					objectTrua[2][1] = result111.getSoluong();
					objectTrua[2][2] = result111.getCalo();
				}

				// bua toi
				if (resultFoodToi1.size() != 0) {
					Food result1 = resultFoodToi1.get(0);
					objectToi[0][0] = result1.getTenmon();
					objectToi[0][1] = result1.getSoluong();
					objectToi[0][2] = result1.getCalo();
				} else if (resultFoodToi2.size() != 0) {
					Food result1 = resultFoodToi2.get(0);
					Food result11 = resultFoodToi2.get(1);
					objectToi[0][0] = result1.getTenmon();
					objectToi[0][1] = result1.getSoluong();
					objectToi[0][2] = result1.getCalo();
					objectToi[1][0] = result11.getTenmon();
					objectToi[1][1] = result11.getSoluong();
					objectToi[1][2] = result11.getCalo();
				} else if (resultFoodToi3.size() != 0) {
					Food result1 = resultFoodToi3.get(0);
					Food result11 = resultFoodToi3.get(1);
					Food result111 = resultFoodToi3.get(2);
					objectToi[0][0] = result1.getTenmon();
					objectToi[0][1] = result1.getSoluong();
					objectToi[0][2] = result1.getCalo();
					objectToi[1][0] = result11.getTenmon();
					objectToi[1][1] = result11.getSoluong();
					objectToi[1][2] = result11.getCalo();
					objectToi[2][0] = result111.getTenmon();
					objectToi[2][1] = result111.getSoluong();
					objectToi[2][2] = result111.getCalo();
				}
			} else {
				if (arrayListClick.get(0) == 0) {
					// bua sang
					if (resultFoodSang1.size() != 0) {
						Food result1 = resultFoodSang1.get(0);
						objectSang[0][0] = result1.getTenmon();
						objectSang[0][1] = result1.getSoluong();
						objectSang[0][2] = result1.getCalo();
					} else if (resultFoodSang2.size() != 0) {
						Food result1 = resultFoodSang2.get(0);
						Food result11 = resultFoodSang2.get(1);
						objectSang[0][0] = result1.getTenmon();
						objectSang[0][1] = result1.getSoluong();
						objectSang[0][2] = result1.getCalo();
						objectSang[1][0] = result11.getTenmon();
						objectSang[1][1] = result11.getSoluong();
						objectSang[1][2] = result11.getCalo();
					} else if (resultFoodSang3.size() != 0) {
						Food result1 = resultFoodSang3.get(0);
						Food result11 = resultFoodSang3.get(1);
						Food result111 = resultFoodSang3.get(2);
						objectSang[0][0] = result1.getTenmon();
						objectSang[0][1] = result1.getSoluong();
						objectSang[0][2] = result1.getCalo();
						objectSang[1][0] = result11.getTenmon();
						objectSang[1][1] = result11.getSoluong();
						objectSang[1][2] = result11.getCalo();
						objectSang[2][0] = result111.getTenmon();
						objectSang[2][1] = result111.getSoluong();
						objectSang[2][2] = result111.getCalo();
					}
				} else {
					// bua sang
					if (resultFoodSang1.size() != 0 && arrayListClick.get(0) <= resultFoodSang1.size()) {
						Food result1 = resultFoodSang1.get(arrayListClick.get(0));
						objectSang[0][0] = result1.getTenmon();
						objectSang[0][1] = result1.getSoluong();
						objectSang[0][2] = result1.getCalo();
					} else if (resultFoodSang2.size() != 0 && arrayListClick.get(0) <= resultFoodSang2.size()) {
						Food result1 = resultFoodSang2.get(arrayListClick.get(0) - 1);
						Food result11 = resultFoodSang2.get(arrayListClick.get(0));/////////
						objectSang[0][0] = result1.getTenmon();
						objectSang[0][1] = result1.getSoluong();
						objectSang[0][2] = result1.getCalo();
						objectSang[1][0] = result11.getTenmon();
						objectSang[1][1] = result11.getSoluong();
						objectSang[1][2] = result11.getCalo();
					} else if (resultFoodSang3.size() != 0 && arrayListClick.get(0) <= resultFoodSang3.size()) {
						Food result1 = resultFoodSang3.get(arrayListClick.get(0) - 2);
						Food result11 = resultFoodSang3.get(arrayListClick.get(0) - 1);
						Food result111 = resultFoodSang3.get(arrayListClick.get(0));
						objectSang[0][0] = result1.getTenmon();
						objectSang[0][1] = result1.getSoluong();
						objectSang[0][2] = result1.getCalo();
						objectSang[1][0] = result11.getTenmon();
						objectSang[1][1] = result11.getSoluong();
						objectSang[1][2] = result11.getCalo();
						objectSang[2][0] = result111.getTenmon();
						objectSang[2][1] = result111.getSoluong();
						objectSang[2][2] = result111.getCalo();
					}
				}
				if (arrayListClick.get(1) == 0) {
					// bua trua
					if (resultFoodTrua1.size() != 0) {
						Food result1 = resultFoodTrua1.get(0);
						objectTrua[0][0] = result1.getTenmon();
						objectTrua[0][1] = result1.getSoluong();
						objectTrua[0][2] = result1.getCalo();
					} else if (resultFoodTrua2.size() != 0) {
						Food result1 = resultFoodTrua2.get(0);
						Food result11 = resultFoodTrua2.get(1);
						objectTrua[0][0] = result1.getTenmon();
						objectTrua[0][1] = result1.getSoluong();
						objectTrua[0][2] = result1.getCalo();
						objectTrua[1][0] = result11.getTenmon();
						objectTrua[1][1] = result11.getSoluong();
						objectTrua[1][2] = result11.getCalo();
					} else if (resultFoodTrua3.size() != 0) {
						Food result1 = resultFoodTrua3.get(0);
						Food result11 = resultFoodTrua3.get(1);
						Food result111 = resultFoodTrua3.get(2);
						objectTrua[0][0] = result1.getTenmon();
						objectTrua[0][1] = result1.getSoluong();
						objectTrua[0][2] = result1.getCalo();
						objectTrua[1][0] = result11.getTenmon();
						objectTrua[1][1] = result11.getSoluong();
						objectTrua[1][2] = result11.getCalo();
						objectTrua[2][0] = result111.getTenmon();
						objectTrua[2][1] = result111.getSoluong();
						objectTrua[2][2] = result111.getCalo();
					}
				} else {
					if (resultFoodTrua1.size() != 0 && arrayListClick.get(1) <= resultFoodTrua1.size()) {
						Food result1 = resultFoodTrua1.get(arrayListClick.get(1));
						objectTrua[0][0] = result1.getTenmon();
						objectTrua[0][1] = result1.getSoluong();
						objectTrua[0][2] = result1.getCalo();
					} else if (resultFoodTrua2.size() != 0 && arrayListClick.get(1) <= resultFoodTrua2.size()) {
						Food result1 = resultFoodTrua2.get(arrayListClick.get(1) - 1);
						Food result11 = resultFoodTrua2.get(arrayListClick.get(1));
						objectTrua[0][0] = result1.getTenmon();
						objectTrua[0][1] = result1.getSoluong();
						objectTrua[0][2] = result1.getCalo();
						objectTrua[1][0] = result11.getTenmon();
						objectTrua[1][1] = result11.getSoluong();
						objectTrua[1][2] = result11.getCalo();
					} else if (resultFoodTrua3.size() != 0 && arrayListClick.get(1) <= resultFoodTrua3.size()) {
						Food result1 = resultFoodTrua3.get(arrayListClick.get(1) - 2);
						Food result11 = resultFoodTrua3.get(arrayListClick.get(1) - 1);
						Food result111 = resultFoodTrua3.get(arrayListClick.get(1));
						objectTrua[0][0] = result1.getTenmon();
						objectTrua[0][1] = result1.getSoluong();
						objectTrua[0][2] = result1.getCalo();
						objectTrua[1][0] = result11.getTenmon();
						objectTrua[1][1] = result11.getSoluong();
						objectTrua[1][2] = result11.getCalo();
						objectTrua[2][0] = result111.getTenmon();
						objectTrua[2][1] = result111.getSoluong();
						objectTrua[2][2] = result111.getCalo();
					}
				}

				if (arrayListClick.get(2) == 0) {
					// bua toi
					if (resultFoodToi1.size() != 0) {
						Food result1 = resultFoodToi1.get(0);
						objectToi[0][0] = result1.getTenmon();
						objectToi[0][1] = result1.getSoluong();
						objectToi[0][2] = result1.getCalo();
					} else if (resultFoodToi2.size() != 0) {
						Food result1 = resultFoodToi2.get(0);
						Food result11 = resultFoodToi2.get(1);
						objectToi[0][0] = result1.getTenmon();
						objectToi[0][1] = result1.getSoluong();
						objectToi[0][2] = result1.getCalo();
						objectToi[1][0] = result11.getTenmon();
						objectToi[1][1] = result11.getSoluong();
						objectToi[1][2] = result11.getCalo();
					} else if (resultFoodToi3.size() != 0) {
						Food result1 = resultFoodToi3.get(0);
						Food result11 = resultFoodToi3.get(1);
						Food result111 = resultFoodToi3.get(2);
						objectToi[0][0] = result1.getTenmon();
						objectToi[0][1] = result1.getSoluong();
						objectToi[0][2] = result1.getCalo();
						objectToi[1][0] = result11.getTenmon();
						objectToi[1][1] = result11.getSoluong();
						objectToi[1][2] = result11.getCalo();
						objectToi[2][0] = result111.getTenmon();
						objectToi[2][1] = result111.getSoluong();
						objectToi[2][2] = result111.getCalo();
					}
				} else {
					// bua toi
					if (resultFoodToi1.size() != 0 && arrayListClick.get(2) <= resultFoodToi1.size()) {
						Food result1 = resultFoodToi1.get(arrayListClick.get(2));
						objectToi[0][0] = result1.getTenmon();
						objectToi[0][1] = result1.getSoluong();
						objectToi[0][2] = result1.getCalo();
					} else if (resultFoodToi2.size() != 0 && arrayListClick.get(2) <= resultFoodToi2.size()) {
						Food result1 = resultFoodToi2.get(arrayListClick.get(2) - 1);
						Food result11 = resultFoodToi2.get(arrayListClick.get(2));
						objectToi[0][0] = result1.getTenmon();
						objectToi[0][1] = result1.getSoluong();
						objectToi[0][2] = result1.getCalo();
						objectToi[1][0] = result11.getTenmon();
						objectToi[1][1] = result11.getSoluong();
						objectToi[1][2] = result11.getCalo();
					} else if (resultFoodToi3.size() != 0 && arrayListClick.get(2) <= resultFoodToi3.size()) {
						Food result1 = resultFoodToi3.get(arrayListClick.get(2) - 2);
						Food result11 = resultFoodToi3.get(arrayListClick.get(2) - 1);
						Food result111 = resultFoodToi3.get(arrayListClick.get(2));
						objectToi[0][0] = result1.getTenmon();
						objectToi[0][1] = result1.getSoluong();
						objectToi[0][2] = result1.getCalo();
						objectToi[1][0] = result11.getTenmon();
						objectToi[1][1] = result11.getSoluong();
						objectToi[1][2] = result11.getCalo();
						objectToi[2][0] = result111.getTenmon();
						objectToi[2][1] = result111.getSoluong();
						objectToi[2][2] = result111.getCalo();
					}
				}
			}
		}
	}

	private void initComponents(String idUsed) {

		jPanel1 = new JPanel();
		jLabel1 = new JLabel();
		labelCalo = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jScrollPane1 = new JScrollPane();
		jTable1 = new JTable();
		jButton1 = new JButton();
		jLabel6 = new JLabel();
		jScrollPane2 = new JScrollPane();
		jTable2 = new JTable();
		jButton2 = new JButton();
		jLabel7 = new JLabel();
		jScrollPane3 = new JScrollPane();
		jTable3 = new JTable();
		jButton3 = new JButton();
		jButton4 = new JButton();
		jButtonViewAll = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(0, 204, 204));

		jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("Hệ tư vấn dinh dưỡng");

		jButtonViewAll.setFont(new Font("Times New Roman", 1, 12)); // NOI18N
		jButtonViewAll.setText("Xem danh sách tất cả món ăn");
		jButtonViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonViewAllActionPerformed(evt);
			}
		});

		jLabel5.setText("Bữa sáng");

		jTable1.setModel(new DefaultTableModel(objectSang, new String[] { "Tên món", "Số lượng", "Calo" }));
		jScrollPane1.setViewportView(jTable1);

		jButton1.setFont(new Font("Times New Roman", 1, 12)); // NOI18N
		jButton1.setText("Đổi món");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jLabel6.setText("Bữa trưa");

		jTable2.setModel(new DefaultTableModel(objectTrua, new String[] { "Id", "Tên món", "Số lượng" }));
		jScrollPane2.setViewportView(jTable2);

		jButton2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
		jButton2.setText("Đổi món");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jLabel7.setText("Bữa tối");

		jTable3.setModel(new DefaultTableModel(objectToi, new String[] { "Id", "Tên món", "Số lượng" }));
		jScrollPane3.setViewportView(jTable3);

		jButton3.setFont(new Font("Times New Roman", 1, 12)); // NOI18N
		jButton3.setText("Đổi món");
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton4.setFont(new Font("Times New Roman", 1, 12)); // NOI18N
		jButton4.setText("Xác nhận");
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(
								jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
										.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout
												.createSequentialGroup().addComponent(jScrollPane1,
														GroupLayout.PREFERRED_SIZE, 493, GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18).addComponent(jButton1, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(jPanel1Layout
												.createSequentialGroup().addComponent(jScrollPane2,
														GroupLayout.PREFERRED_SIZE, 493, GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18).addComponent(jButton2, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(
												jPanel1Layout.createSequentialGroup()
														.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 493,
																GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18).addComponent(
																jButton3, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
												.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 113,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addComponent(jButtonViewAll, GroupLayout.PREFERRED_SIZE, 250,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(labelCalo, GroupLayout.PREFERRED_SIZE, 85,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 79,
																GroupLayout.PREFERRED_SIZE))
												.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 113,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 113,
														GroupLayout.PREFERRED_SIZE))
												.addGap(0, 317, Short.MAX_VALUE)))
										.addContainerGap())
						.addGroup(GroupLayout.Alignment.TRAILING,
								jPanel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(
										jButton4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(jButtonViewAll, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
								.addComponent(labelCalo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
						.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jPanel1,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jPanel1,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	public void DoiMonSang(int count) {
		// Xoá bảng
		ClearTable(1);
		DefaultTableModel model = null;
		model = (DefaultTableModel) jTable1.getModel();
		String[] row = new String[3];
		if (count == sizeResultSang || (resultFoodSang1.size() == 1 && sizeResultSang == 1)
				|| (resultFoodSang2.size() == 2 && sizeResultSang == 2)
				|| (resultFoodSang3.size() == 3 && sizeResultSang == 3)) {
			clickedSang = 0;
			if (resultFoodSang1.size() != 0) {
				Food result1 = resultFoodSang1.get(0);
				row[0] = result1.getTenmon();
				row[1] = result1.getSoluong();
				row[2] = result1.getCalo();
				model.addRow(row);
			} else if (resultFoodSang2.size() != 0) {
				Food result1 = resultFoodSang2.get(0);
				Food result11 = resultFoodSang2.get(1);
				row[0] = result1.getTenmon();
				row[1] = result1.getSoluong();
				row[2] = result1.getCalo();
				model.addRow(row);
				row[0] = result11.getTenmon();
				row[1] = result11.getSoluong();
				row[2] = result11.getCalo();
				model.addRow(row);
			} else {
				Food result1 = resultFoodSang3.get(0);
				Food result11 = resultFoodSang3.get(1);
				Food result111 = resultFoodSang3.get(2);
				row[0] = result1.getTenmon();
				row[1] = result1.getSoluong();
				row[2] = result1.getCalo();
				model.addRow(row);
				row[0] = result11.getTenmon();
				row[1] = result11.getSoluong();
				row[2] = result11.getCalo();
				model.addRow(row);
				row[0] = result111.getTenmon();
				row[1] = result111.getSoluong();
				row[2] = result111.getCalo();
				model.addRow(row);
			}
		} else if (count < resultFoodSang1.size()) {
			Food result1 = resultFoodSang1.get(count);
			row[0] = result1.getTenmon();
			row[1] = result1.getSoluong();
			row[2] = result1.getCalo();
			model.addRow(row);
		} else if (count < (resultFoodSang2.size() + resultFoodSang1.size()) && count >= resultFoodSang1.size()) {
			if (resultFoodSang1.size() == 0 && count == 1) {
				count = count + 1;
			}
			Food result1 = resultFoodSang2.get(count);
			row[0] = result1.getTenmon();
			row[1] = result1.getSoluong();
			row[2] = result1.getCalo();
			model.addRow(row);
			count = count + 1;
			Food result2 = resultFoodSang2.get(count);
			row[0] = result2.getTenmon();
			row[1] = result2.getSoluong();
			row[2] = result2.getCalo();
			model.addRow(row);
			clickedSang = count;
		} else if (count < sizeResultSang && count >= (resultFoodSang2.size() + resultFoodSang1.size())) {
			if (resultFoodSang2.size() == 0 && count == 1) {
				count = count + 2;
			}
			Food result1 = resultFoodSang2.get(count);
			row[0] = result1.getTenmon();
			row[1] = result1.getSoluong();
			row[2] = result1.getCalo();
			model.addRow(row);
			count = count + 1;
			Food result2 = resultFoodSang2.get(count);
			row[0] = result2.getTenmon();
			row[1] = result2.getSoluong();
			row[2] = result2.getCalo();
			model.addRow(row);
			count = count + 1;
			Food result3 = resultFoodSang2.get(count);
			row[0] = result3.getTenmon();
			row[1] = result3.getSoluong();
			row[2] = result3.getCalo();
			model.addRow(row);
			clickedSang = count;
		}
	}

	public void DoiMonTrua(int count) {
		// Xoá bảng
		ClearTable(2);
		DefaultTableModel model = null;
		model = (DefaultTableModel) jTable2.getModel();
		String[] row = new String[3];
		if (count == sizeResultTrua || (resultFoodTrua1.size() == 1 && sizeResultTrua == 1)
				|| (resultFoodTrua2.size() == 2 && sizeResultTrua == 2)
				|| (resultFoodTrua3.size() == 3 && sizeResultTrua == 3)) {
			clickedTrua = 0;
			if (resultFoodTrua1.size() != 0) {
				Food result1 = resultFoodTrua1.get(0);
				row[0] = result1.getTenmon();
				row[1] = result1.getSoluong();
				row[2] = result1.getCalo();
				model.addRow(row);
			} else if (resultFoodTrua2.size() != 0) {
				Food result1 = resultFoodTrua2.get(0);
				Food result11 = resultFoodTrua2.get(1);
				row[0] = result1.getTenmon();
				row[1] = result1.getSoluong();
				row[2] = result1.getCalo();
				model.addRow(row);
				row[0] = result11.getTenmon();
				row[1] = result11.getSoluong();
				row[2] = result11.getCalo();
				model.addRow(row);
			} else {
				Food result1 = resultFoodTrua3.get(0);
				Food result11 = resultFoodTrua3.get(1);
				Food result111 = resultFoodTrua3.get(2);
				row[0] = result1.getTenmon();
				row[1] = result1.getSoluong();
				row[2] = result1.getCalo();
				model.addRow(row);
				row[0] = result11.getTenmon();
				row[1] = result11.getSoluong();
				row[2] = result11.getCalo();
				model.addRow(row);
				row[0] = result111.getTenmon();
				row[1] = result111.getSoluong();
				row[2] = result111.getCalo();
				model.addRow(row);
			}
		} else if (count < resultFoodTrua1.size()) {
			Food result1 = resultFoodTrua1.get(count);
			row[0] = result1.getTenmon();
			row[1] = result1.getSoluong();
			row[2] = result1.getCalo();
			model.addRow(row);
		} else if (count < (resultFoodTrua2.size() + resultFoodTrua1.size()) && count >= resultFoodTrua1.size()) {
			if (resultFoodTrua1.size() == 0 && count == 1) {
				count = count + 1;
			}
			Food result1 = resultFoodTrua2.get(count);
			row[0] = result1.getTenmon();
			row[1] = result1.getSoluong();
			row[2] = result1.getCalo();
			model.addRow(row);
			count = count + 1;
			Food result2 = resultFoodTrua2.get(count);
			row[0] = result2.getTenmon();
			row[1] = result2.getSoluong();
			row[2] = result2.getCalo();
			model.addRow(row);
			clickedTrua = count;
		} else if (count < sizeResultTrua && count >= (resultFoodTrua2.size() + resultFoodTrua1.size())) {
			if (resultFoodTrua2.size() == 0 && count == 1) {
				count = count + 2;
			}
			Food result1 = resultFoodTrua3.get(count);
			row[0] = result1.getTenmon();
			row[1] = result1.getSoluong();
			row[2] = result1.getCalo();
			model.addRow(row);
			count = count + 1;
			Food result2 = resultFoodTrua3.get(count);
			row[0] = result2.getTenmon();
			row[1] = result2.getSoluong();
			row[2] = result2.getCalo();
			model.addRow(row);
			count = count + 1;
			Food result3 = resultFoodTrua3.get(count);
			row[0] = result3.getTenmon();
			row[1] = result3.getSoluong();
			row[2] = result3.getCalo();
			model.addRow(row);
			clickedTrua = count;
		}
	}

	public void DoiMonToi(int count) {
		// Xoá bảng
		ClearTable(3);
		DefaultTableModel model = null;
		model = (DefaultTableModel) jTable3.getModel();
		String[] row = new String[3];
		if (count == sizeResultToi || (resultFoodToi1.size() == 1 && sizeResultToi == 1)
				|| (resultFoodToi2.size() == 2 && sizeResultToi == 1)
				|| (resultFoodToi3.size() == 3 && sizeResultToi == 3)) {
			clickedToi = 0;
			if (resultFoodToi1.size() != 0) {
				Food result1 = resultFoodToi1.get(0);
				row[0] = result1.getTenmon();
				row[1] = result1.getSoluong();
				row[2] = result1.getCalo();
				model.addRow(row);
			} else if (resultFoodToi2.size() != 0) {
				Food result1 = resultFoodToi2.get(0);
				Food result11 = resultFoodToi2.get(1);
				row[0] = result1.getTenmon();
				row[1] = result1.getSoluong();
				row[2] = result1.getCalo();
				model.addRow(row);
				row[0] = result11.getTenmon();
				row[1] = result11.getSoluong();
				row[2] = result11.getCalo();
				model.addRow(row);
			} else {
				Food result1 = resultFoodToi3.get(0);
				Food result11 = resultFoodToi3.get(1);
				Food result111 = resultFoodToi3.get(2);
				row[0] = result1.getTenmon();
				row[1] = result1.getSoluong();
				row[2] = result1.getCalo();
				model.addRow(row);
				row[0] = result11.getTenmon();
				row[1] = result11.getSoluong();
				row[2] = result11.getCalo();
				model.addRow(row);
				row[0] = result111.getTenmon();
				row[1] = result111.getSoluong();
				row[2] = result111.getCalo();
				model.addRow(row);
			}
		} else if (count < resultFoodToi1.size()) {
			Food result1 = resultFoodToi1.get(count);
			row[0] = result1.getTenmon();
			row[1] = result1.getSoluong();
			row[2] = result1.getCalo();
			model.addRow(row);
		} else if (count < (resultFoodToi2.size() + resultFoodToi1.size()) && count >= resultFoodToi1.size()) {
			if (resultFoodToi1.size() == 0 && count == 1) {
				count = count + 1;
			}
			Food result1 = resultFoodToi2.get(count);
			row[0] = result1.getTenmon();
			row[1] = result1.getSoluong();
			row[2] = result1.getCalo();
			model.addRow(row);
			count = count + 1;
			Food result2 = resultFoodToi2.get(count);
			row[0] = result2.getTenmon();
			row[1] = result2.getSoluong();
			row[2] = result2.getCalo();
			model.addRow(row);
			clickedToi = count;
		} else if (count < sizeResultToi && count >= (resultFoodToi2.size() + resultFoodToi1.size())) {
			if (resultFoodToi2.size() == 0 && count == 1) {
				count = count + 2;
			}
			Food result1 = resultFoodToi3.get(count);
			row[0] = result1.getTenmon();
			row[1] = result1.getSoluong();
			row[2] = result1.getCalo();
			model.addRow(row);
			count = count + 1;
			Food result2 = resultFoodToi3.get(count);
			row[0] = result2.getTenmon();
			row[1] = result2.getSoluong();
			row[2] = result2.getCalo();
			model.addRow(row);
			count = count + 1;
			Food result3 = resultFoodToi3.get(count);
			row[0] = result3.getTenmon();
			row[1] = result3.getSoluong();
			row[2] = result3.getCalo();
			model.addRow(row);
			clickedToi = count;
		}
	}

	public void ClearTable(int iTable) {
		int iRow = 0;
		DefaultTableModel model = null;
		switch (iTable) {
		case 1:
			iRow = jTable1.getRowCount();
			model = (DefaultTableModel) jTable1.getModel();
			for (int i = 0; i < iRow; i++)
				model.removeRow(0);
			break;
		case 2:
			iRow = jTable2.getRowCount();
			model = (DefaultTableModel) jTable2.getModel();
			for (int i = 0; i < iRow; i++)
				model.removeRow(0);
			break;
		case 3:
			iRow = jTable3.getRowCount();
			model = (DefaultTableModel) jTable3.getModel();
			for (int i = 0; i < iRow; i++)
				model.removeRow(0);
			break;
		}
	}

	private void jButton1ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		clickedSang++;
		System.out.println("clickedSang" + clickedSang);
		DoiMonSang(clickedSang);

	}

	private void jButton2ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		clickedTrua++;
		DoiMonTrua(clickedTrua);
	}

	private void jButton3ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		clickedToi++;
		DoiMonToi(clickedToi);
	}

	private void jButton4ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
		try {
			User.InsertUserClick(idUsed, clickedSang, clickedTrua, clickedToi);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		HomeViewUser homeViewUser = new HomeViewUser(idUsed);
		homeViewUser.setVisible(true);
		this.setVisible(false);
	}

	private void jButtonViewAllActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
		ListMenuView listMenuView = new ListMenuView(idUsed);
		listMenuView.setVisible(true);
		this.setVisible(false);
	}
}
