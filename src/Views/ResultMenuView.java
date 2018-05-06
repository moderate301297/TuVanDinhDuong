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

	ArrayList<ArrayList<Food>> arrayListFoodSang = new ArrayList<>();
	MainController controller = new MainController();
	public float[] CaloSang = new float[3];
	public float[] CaloTrua = new float[3];
	public float[] CaloToi = new float[3];
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JLabel jLabel1;
	private JLabel jLabel2;
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
	String tablename;
	String idUsed;
	ArrayList<Food> resultFoodSang1, resultFoodSang2, resultFoodSang3;
	ArrayList<Food> resultFoodTrua1, resultFoodTrua2, resultFoodTrua3;
	ArrayList<Food> resultFoodToi1, resultFoodToi2, resultFoodToi3;
	Object[][] objectSang, objectTrua, objectToi;
	float calo;
	int sizeResultSang;
	int sizeResultTrua;
	int sizeResultToi;
	int clickedSang = 0, clickedTrua = 0, clickedToi = 0;

	// End of variables declaration//GEN-END:variables
	/** Creates new form ResultMenuView */
	public ResultMenuView(String id) {
		idUsed = id;
		processDB(idUsed);
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
		String select = arrayListMucTieu.get(0);
		int selectNew = Integer.parseInt(select);
		String index = arrayListMucTieu.get(1);
		int indexNew = Integer.parseInt(index);
		String TDEE = arrayListMucTieu.get(2);
		float TDEENew = Float.parseFloat(TDEE);
		arrayList = controller.getCaloNeed(selectNew, indexNew, TDEENew);
		tablename = controller.GetTableFavorite(idUsed);

		// bua sang
		calo = arrayList.get(0);
		arrayListFoodSang = controller.getFoodTungBua(calo, 0, tablename);
		resultFoodSang1 = arrayListFoodSang.get(0);
		resultFoodSang2 = arrayListFoodSang.get(1);
		resultFoodSang3 = arrayListFoodSang.get(2);
		sizeResultSang = resultFoodSang1.size() + resultFoodSang2.size() + resultFoodSang3.size();

		// bua trua
		calo = arrayList.get(1);
		arrayListFoodSang = controller.getFoodTungBua(calo, 1, tablename);
		resultFoodTrua1 = arrayListFoodSang.get(0);
		resultFoodTrua2 = arrayListFoodSang.get(1);
		resultFoodTrua3 = arrayListFoodSang.get(2);
		sizeResultTrua = resultFoodTrua1.size() + resultFoodTrua2.size() + resultFoodTrua3.size();

		// bua toi
		calo = arrayList.get(2);
		arrayListFoodSang = controller.getFoodTungBua(calo, 2, tablename);
		resultFoodToi1 = arrayListFoodSang.get(0);
		resultFoodToi2 = arrayListFoodSang.get(1);
		resultFoodToi3 = arrayListFoodSang.get(2);
		sizeResultToi = resultFoodToi1.size() + resultFoodToi2.size() + resultFoodToi3.size();

		try {
			arrayListClick = User.GetUserClick(idUsed);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (arrayListClick.size() == 0) {
			// bua sang
			Food result1 = resultFoodSang1.get(0);
			objectSang[0][0] = result1.getTenmon();
			objectSang[0][1] = result1.getSoluong();
			objectSang[0][2] = result1.getCalo();

			// bua trua
			Food result2 = resultFoodSang1.get(0);
			objectSang[0][0] = result2.getTenmon();
			objectSang[0][1] = result2.getSoluong();
			objectSang[0][2] = result2.getCalo();

			// bua toi
			Food result3 = resultFoodSang1.get(0);
			objectSang[0][0] = result3.getTenmon();
			objectSang[0][1] = result3.getSoluong();
			objectSang[0][2] = result3.getCalo();
		} else {
			DoiMonSang(arrayListClick.get(0));
			DoiMonTrua(arrayListClick.get(1));
			DoiMonToi(arrayListClick.get(2));
		}

	}

	private void initComponents(String idUsed) {

		jPanel1 = new JPanel();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
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

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(0, 204, 204));

		jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("Hệ tư vấn dinh dưỡng");

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
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addGroup(jPanel1Layout
														.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 113,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(jPanel1Layout.createSequentialGroup()
																.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 145,
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
								.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
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
		if (count == sizeResultSang) {
			clickedSang = 0;
			Food result1 = resultFoodSang1.get(clickedSang);
			objectSang[0][0] = result1.getTenmon();
			objectSang[0][1] = result1.getSoluong();
			objectSang[0][2] = result1.getCalo();
		}
		if (count < resultFoodSang1.size()) {
			Food result1 = resultFoodSang1.get(clickedSang);
			objectSang[0][0] = result1.getTenmon();
			objectSang[0][1] = result1.getSoluong();
			objectSang[0][2] = result1.getCalo();
		}
		if (count < resultFoodSang2.size() && count >= resultFoodSang1.size()) {
			Food result1 = resultFoodSang2.get(count);
			objectSang[0][0] = result1.getTenmon();
			objectSang[0][1] = result1.getSoluong();
			objectSang[0][2] = result1.getCalo();
			count = count + 1;
			Food result2 = resultFoodSang2.get(count);
			objectSang[1][0] = result2.getTenmon();
			objectSang[1][1] = result2.getSoluong();
			objectSang[1][2] = result2.getCalo();
		}
		if (count < resultFoodSang3.size() && count >= resultFoodSang2.size()) {
			Food result1 = resultFoodSang2.get(count);
			objectSang[0][0] = result1.getTenmon();
			objectSang[0][1] = result1.getSoluong();
			objectSang[0][2] = result1.getCalo();
			count = count + 1;
			Food result2 = resultFoodSang2.get(count);
			objectSang[1][0] = result2.getTenmon();
			objectSang[1][1] = result2.getSoluong();
			objectSang[1][2] = result2.getCalo();
			count = count + 1;
			Food result3 = resultFoodSang2.get(count);
			objectSang[2][0] = result3.getTenmon();
			objectSang[2][1] = result3.getSoluong();
			objectSang[2][2] = result3.getCalo();
		}
		// resetTable();
	}

	public void DoiMonTrua(int count) {
		// Xoá bảng
		ClearTable(2);
		if (count == sizeResultTrua) {
			clickedTrua = 0;
			Food result1 = resultFoodTrua1.get(clickedTrua);
			objectTrua[0][0] = result1.getTenmon();
			objectTrua[0][1] = result1.getSoluong();
			objectTrua[0][2] = result1.getCalo();
		}
		if (count < resultFoodTrua1.size()) {
			Food result1 = resultFoodTrua1.get(count);
			objectTrua[0][0] = result1.getTenmon();
			objectTrua[0][1] = result1.getSoluong();
			objectTrua[0][2] = result1.getCalo();
		}
		if (count < resultFoodTrua2.size() && count >= resultFoodTrua1.size()) {
			Food result1 = resultFoodTrua2.get(count);
			objectTrua[0][0] = result1.getTenmon();
			objectTrua[0][1] = result1.getSoluong();
			objectTrua[0][2] = result1.getCalo();
			count = count + 1;
			Food result2 = resultFoodTrua2.get(count);
			objectTrua[1][0] = result2.getTenmon();
			objectTrua[1][1] = result2.getSoluong();
			objectTrua[1][2] = result2.getCalo();
		}
		if (count < resultFoodTrua3.size() && count >= resultFoodTrua2.size()) {
			Food result1 = resultFoodTrua3.get(count);
			objectTrua[0][0] = result1.getTenmon();
			objectTrua[0][1] = result1.getSoluong();
			objectTrua[0][2] = result1.getCalo();
			count = count + 1;
			Food result2 = resultFoodTrua3.get(count);
			objectTrua[1][0] = result2.getTenmon();
			objectTrua[1][1] = result2.getSoluong();
			objectTrua[1][2] = result2.getCalo();
			count = count + 1;
			Food result3 = resultFoodTrua3.get(count);
			objectTrua[2][0] = result3.getTenmon();
			objectTrua[2][1] = result3.getSoluong();
			objectTrua[2][2] = result3.getCalo();
		}
	}

	public void DoiMonToi(int count) {
		// Xoá bảng
		ClearTable(3);
		if (count == sizeResultToi) {
			clickedToi = 0;
			Food result1 = resultFoodToi1.get(clickedToi);
			objectToi[0][0] = result1.getTenmon();
			objectToi[0][1] = result1.getSoluong();
			objectToi[0][2] = result1.getCalo();
		}
		if (count < resultFoodToi1.size()) {
			Food result1 = resultFoodToi1.get(count);
			objectToi[0][0] = result1.getTenmon();
			objectToi[0][1] = result1.getSoluong();
			objectToi[0][2] = result1.getCalo();
		}
		if (count < resultFoodToi2.size() && count >= resultFoodToi1.size()) {
			Food result1 = resultFoodToi2.get(count);
			objectToi[0][0] = result1.getTenmon();
			objectToi[0][1] = result1.getSoluong();
			objectToi[0][2] = result1.getCalo();
			count = count + 1;
			Food result2 = resultFoodToi2.get(count);
			objectToi[1][0] = result2.getTenmon();
			objectToi[1][1] = result2.getSoluong();
			objectToi[1][2] = result2.getCalo();
		}
		if (count < resultFoodToi3.size() && count >= resultFoodToi2.size()) {
			Food result1 = resultFoodToi3.get(count);
			objectToi[0][0] = result1.getTenmon();
			objectToi[0][1] = result1.getSoluong();
			objectToi[0][2] = result1.getCalo();
			count = count + 1;
			Food result2 = resultFoodToi3.get(count);
			objectToi[1][0] = result2.getTenmon();
			objectToi[1][1] = result2.getSoluong();
			objectToi[1][2] = result2.getCalo();
			count = count + 1;
			Food result3 = resultFoodToi3.get(count);
			objectToi[2][0] = result3.getTenmon();
			objectToi[2][1] = result3.getSoluong();
			objectToi[2][2] = result3.getCalo();
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
}
