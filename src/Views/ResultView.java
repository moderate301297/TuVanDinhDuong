/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controller.MainController;
import Model.User;
import Util.Common.LuaChon;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

public class ResultView extends JFrame {
	public float height, weight, age;
	public boolean isMale;
	public int level;
	public int select;
	public int indexSelectUp, indexSelectDown;
	public float TDEE;
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JRadioButton selectDownWeight, keepWeight, selectUpWeight;
	private JLabel jLabelDownWeight, jLabelUnitUpWeight, jLabelTitle, jLabelUpWeight, jLabelUnitDownWeight, textResult;
	private JComboBox numberDownWeight, numberUpWeight;
	private JButton jButtonContinue;
	private JPanel jPanel1;
	String idUsed;
	// End of variables declaration//GEN-END:variables

	public ResultView(String id) {
		idUsed = id;
		initComponents(idUsed);
		// showResult();
	}

	public void showResult() {
		MainController mainController = new MainController();
		String result = mainController.getResult(height, weight);
		System.out.println("ket qua la " + result);
		textResult.setText(result);
	}

	private void initComponents(String idUsed) {

		jPanel1 = new JPanel();
		jLabelTitle = new JLabel();
		textResult = new JLabel();
		selectUpWeight = new JRadioButton();
		jLabelUpWeight = new JLabel();
		numberUpWeight = new JComboBox();
		jLabelUnitUpWeight = new JLabel();
		jLabelUnitDownWeight = new JLabel();
		numberDownWeight = new JComboBox();
		jLabelDownWeight = new JLabel();
		selectDownWeight = new JRadioButton();
		keepWeight = new JRadioButton();
		jButtonContinue = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new Color(0, 204, 204));

		jLabelTitle.setFont(new Font("Times New Roman", 1, 24)); // NOI18N
		jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelTitle.setText("Hệ tư vấn dinh dưỡng");

		textResult.setFont(new Font("Times New Roman", 1, 12)); // NOI18N
		textResult.setHorizontalAlignment(SwingConstants.CENTER);
		textResult.setText("jLabel3");

		selectUpWeight.setText("Tăng cân");
		selectUpWeight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				tang1ActionPerformed(evt);
			}
		});

		jLabelUpWeight.setText("Số cân");

		numberUpWeight.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		numberUpWeight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				tang3ActionPerformed(evt);
			}
		});

		jLabelUnitUpWeight.setText("kg / tháng");

		selectDownWeight.setText("Giảm cân");
		selectDownWeight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				giam1ActionPerformed(evt);
			}
		});

		jLabelDownWeight.setText("Số cân");

		numberDownWeight.setModel(new DefaultComboBoxModel(new String[] { "0.5", "1", "1.5", "2" }));
		numberDownWeight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				giam3ActionPerformed(evt);
			}
		});
		
		jLabelUnitDownWeight.setText("kg / tháng");

		keepWeight.setSelected(true);
		keepWeight.setText("Giữ cân");
		keepWeight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				giucanActionPerformed(evt);
			}
		});

		jButtonContinue.setFont(new Font("Tahoma", 1, 12)); // NOI18N
		jButtonContinue.setIcon(new ImageIcon(getClass().getResource("/Resource/Next.png"))); // NOI18N
		jButtonContinue.setText("Tiếp tục");
		jButtonContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jLabelTitle, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
				.addComponent(textResult, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(selectDownWeight)
								.addComponent(selectUpWeight, GroupLayout.Alignment.TRAILING).addComponent(keepWeight))
						.addGap(12, 12, 12)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(jLabelUpWeight, GroupLayout.PREFERRED_SIZE, 46,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(numberUpWeight, GroupLayout.PREFERRED_SIZE, 53,
												GroupLayout.PREFERRED_SIZE)
										.addGap(41, 41, 41).addComponent(jLabelUnitDownWeight, GroupLayout.PREFERRED_SIZE, 64,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(jLabelDownWeight, GroupLayout.PREFERRED_SIZE, 46,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(numberDownWeight, GroupLayout.PREFERRED_SIZE, 53,
												GroupLayout.PREFERRED_SIZE)
										.addGap(41, 41, 41).addComponent(jLabelUnitUpWeight, GroupLayout.PREFERRED_SIZE,
												64, GroupLayout.PREFERRED_SIZE)))
						.addGap(54, 54, 54))
				.addGroup(GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(
								jButtonContinue, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jLabelTitle, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(textResult, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
										.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(numberUpWeight, GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabelUpWeight, GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabelUnitDownWeight, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
										.addComponent(selectUpWeight)).addGap(24, 24, 24)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(numberDownWeight, GroupLayout.PREFERRED_SIZE, 23,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabelUnitUpWeight, GroupLayout.PREFERRED_SIZE, 23,
														GroupLayout.PREFERRED_SIZE)))
								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(selectDownWeight).addComponent(jLabelDownWeight,
												GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
						.addGap(27, 27, 27).addComponent(keepWeight)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jButtonContinue, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jPanel1,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jPanel1,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}

	private void giam1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_giam1ActionPerformed
		// TODO add your handling code here:
		select = 1;
		keepWeight.setSelected(false);
		selectUpWeight.setSelected(false);
		selectDownWeight.setSelected(true);
	}// GEN-LAST:event_giam1ActionPerformed
	
	private void giam3ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_giam3ActionPerformed
		// TODO add your handling code here:
		indexSelectDown = numberDownWeight.getSelectedIndex();
	}// GEN-LAST:event_giam3ActionPerformed

	private void giucanActionPerformed(ActionEvent evt) {// GEN-FIRST:event_giucanActionPerformed
		// TODO add your handling code here:
		select = 2;
		keepWeight.setSelected(true);
		selectUpWeight.setSelected(false);
		selectDownWeight.setSelected(false);
	}// GEN-LAST:event_giucanActionPerformed

	private void tang1ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_tang1ActionPerformed
		// TODO add your handling code here:
		select = 0;
		keepWeight.setSelected(false);
		selectUpWeight.setSelected(true);
		selectDownWeight.setSelected(false);
	}// GEN-LAST:event_tang1ActionPerformed

	private void tang3ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_tang3ActionPerformed
		// TODO add your handling code here:
		indexSelectUp = numberUpWeight.getSelectedIndex();
	}// GEN-LAST:event_tang3ActionPerformed

	private void jButton1ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
		// thuc hien code cho button xac nhan.
		String muctieu = null;
		if (select == 0) {
			muctieu = "tang " + indexSelectUp + " can";
			try {
				User.UpdateUserIndex(idUsed, select, indexSelectUp, TDEE);
			} catch (SQLException e) {
				System.out.println("error: " + e);
			}
		} else if (select == 1) {
			muctieu = "giam " + indexSelectDown + " can";
			try {
				User.UpdateUserIndex(idUsed, select, indexSelectDown, TDEE);
			} catch (SQLException e) {
				System.out.println("error: " + e);
			}
		} else {
			muctieu = "giu can";
			try {
				User.UpdateUserIndex(idUsed, select, 0, TDEE);
			} catch (SQLException e) {
				System.out.println("error: " + e);
			}
		}
		try {
			User.UpdateMucTieu(idUsed, muctieu);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		}
		
		ResultMenuView listMenuView = new ResultMenuView(idUsed); //thuc don
		listMenuView.setVisible(true);
		this.setVisible(false);
	}
}
