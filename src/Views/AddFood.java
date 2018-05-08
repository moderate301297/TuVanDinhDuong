/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Controller.MainController;
import Model.QueryFood;
import Model.User;

public class AddFood extends javax.swing.JFrame {

	String[] object = new String[10];
	String idUsed, indexNhom, indexBuaAn;

	/**
	 * Creates new form AddFood
	 */
	public AddFood(String id) {
		idUsed = id;
		queryNhom();
		initComponents();
	}

	private void queryNhom() {
		ArrayList<String> arrayList = null;
		try {
			arrayList = User.GetAllFavorite();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < arrayList.size(); i++) {
			object[i] = arrayList.get(i);
		}
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated

	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox<>();
		jLabel9 = new javax.swing.JLabel();
		jComboBox2 = new javax.swing.JComboBox<>();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jLabel1.setText("Thêm món ăn ");

		jLabel2.setText("Tên món");

		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		jTextField2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField2ActionPerformed(evt);
			}
		});

		jTextField3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField3ActionPerformed(evt);
			}
		});

		jLabel3.setText("Đơn vị");

		jLabel4.setText("Tổng calo");

		jLabel8.setText("Bữa ăn");

		jLabel9.setText("Nhóm");

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "bua sang", "bua trua", "bua toi" }));
		jComboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				chooseBuaAnActionPerformed(evt);
			}
		});

		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(object));
		jComboBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				chooseNhomActionPerformed(evt);
			}
		});

		jButton1.setFont(new Font("Times New Roman", 0, 11)); // NOI18N
		jButton1.setIcon(new ImageIcon(getClass().getResource("/Resource/Back.png"))); // NOI18N
		jButton1.setText("Trang chủ");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setFont(new Font("Times New Roman", 0, 11)); // NOI18N
		jButton2.setIcon(new ImageIcon(getClass().getResource("/Resource/Next.png"))); // NOI18N
		jButton2.setText("Thêm");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(37, 37, 37))
				.addGroup(layout.createSequentialGroup().addGap(29, 29, 29).addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(jButton1).addGap(40, 40, 40)
								.addComponent(jButton2))
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel4).addComponent(jLabel8).addComponent(jLabel9))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 103,
														Short.MAX_VALUE)
												.addComponent(jTextField2).addComponent(jTextField3)))))
						.addContainerGap(45, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(43, 43, 43)
				.addComponent(
						jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2)
						.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel3)
						.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel4)
						.addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(24, 24, 24)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel8)
						.addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(66, 66, 66)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel9)
						.addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(86, 86, 86).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jButton2).addComponent(jButton1))
				.addContainerGap(29, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField1ActionPerformed

	private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
		// TODO add your handling code here:
	}

	private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
		// TODO add your handling code here:
	}

	private void chooseNhomActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		indexNhom = (String) jComboBox2.getSelectedItem();
	}

	private void chooseBuaAnActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		indexBuaAn = (String) jComboBox1.getSelectedItem();
	}

	private void jButton1ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
		HomeViewUser homeViewUser = new HomeViewUser(idUsed);
		homeViewUser.setVisible(true);
		this.setVisible(false);
	}

	private void jButton2ActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		// TODO add your handling code here:
		if (checkValidValue()) {
			AddFood a = new AddFood(idUsed);
			a.setVisible(true);
			this.setVisible(false);
		}
	}

	public boolean checkValidValue() {
		if (jTextField1.getText().equals("") || jTextField2.getText().equals("") || jTextField3.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "chưa nhập đủ giá trị");
			return false;
		}
		String tenmonan = jTextField1.getText();
		String donvi = jTextField2.getText();
		String tongcalo = jTextField3.getText();
		boolean bool = false;
		try {
			bool = QueryFood.InsertFood(tenmonan, donvi, tongcalo, indexBuaAn, indexNhom);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (bool == false) {
			JOptionPane.showMessageDialog(this, "Giá trị nhập vào không hợp lệ");
			return false;
		}
		return true;
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JComboBox<String> jComboBox1, jComboBox2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	// End of variables declaration//GEN-END:variables

}
