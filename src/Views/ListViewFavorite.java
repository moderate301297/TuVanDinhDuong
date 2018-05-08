/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import static Model.QueryFood.getFavoriteFood;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Model.User;

public class ListViewFavorite extends javax.swing.JFrame {

	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JComboBox<String> jComboBoxListFavorite;
	private javax.swing.JComboBox<String> jComboBoxListBuaan;
	private javax.swing.JLabel jLabel1, jLabel2;
	// End of variables declaration
	String idUsed;
	public String indexSelectBuaAn, indexSelectFavorite;
	ArrayList<String> favorite;

	public ListViewFavorite(String id) {
		idUsed = id;
		initComponents();
		favorite = getFavoriteFood();
		for (int i = 0; i < favorite.size(); i++) {
			String s = favorite.get(i);
			jComboBoxListFavorite.addItem(s);
		}

	}

	private void initComponents() {

		jComboBoxListFavorite = new javax.swing.JComboBox<>();
		jComboBoxListBuaan = new javax.swing.JComboBox<>();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(255, 204, 204));
		setForeground(java.awt.Color.orange);

		jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
		jLabel1.setText("Chọn sở thích của bạn ");

		jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
		jLabel2.setText("Chọn bữa ăn");

		jComboBoxListFavorite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				chooseFavoriteActionPerformed(evt);
			}
		});

		jComboBoxListBuaan.setModel(new DefaultComboBoxModel(new String[] { "Bữa Sáng", "Bữa Trưa", "Bữa Tối" }));
		jComboBoxListBuaan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				chooseBuaAnActionPerformed(evt);
			}
		});

		jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Next.png"))); // NOI18N
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setFont(new Font("Times New Roman", 1, 12)); // NOI18N
		jButton2.setText("Cập nhật danh sách  sở thích");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(45, 45, 45).addComponent(jLabel1))
				.addGroup(layout.createSequentialGroup().addGap(45, 45, 45).addComponent(jComboBoxListFavorite,
						javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup().addGap(45, 45, 45).addComponent(jLabel2))
				.addGroup(layout.createSequentialGroup().addGap(45, 45, 45).addComponent(jComboBoxListBuaan,
						javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup().addComponent(jButton2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jButton1)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(28, 28, 28).addComponent(jLabel1).addComponent(
						jComboBoxListFavorite, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
						javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup().addGap(158, 158, 158).addComponent(jLabel2).addComponent(
						jComboBoxListBuaan, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
						javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup().addGap(258, 258, 258)
						.addComponent(jButton2, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
						.addComponent(jButton1,
						javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)));
		pack();

	}// </editor-fold>

	private void chooseFavoriteActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		indexSelectFavorite = (String) jComboBoxListFavorite.getSelectedItem();
	}

	private void chooseBuaAnActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		indexSelectBuaAn = (String) jComboBoxListBuaan.getSelectedItem();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			User.UpdateFavorite(idUsed, indexSelectFavorite, indexSelectBuaAn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		HomeViewUser h = new HomeViewUser(idUsed);
		h.setVisible(true);
		this.setVisible(false);
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		if (idUsed == "1" ) {
			AddFavorite h = new AddFavorite(idUsed);
			h.setVisible(true);
			this.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(this, "Tính năng này chỉ sử dụng cho người quản trị");
		}
	}

	public static void main(String args[]) {

		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(HomeView.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(HomeView.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(HomeView.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(HomeView.class.getName()).log(Level.SEVERE, null, ex);
		}

		/* Create and display the form */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ListViewFavorite("1").setVisible(true);
			}
		});
	}
}
