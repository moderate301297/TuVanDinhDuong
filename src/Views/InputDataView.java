package Views;

import Model.User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import Controller.MainController;

public class InputDataView extends JFrame {
	public float height, weight, age;
	public int sex, level;
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JComboBox<String> comBoBox_level, comboBox_Sex;
	private JButton jButtonHome, jButtonContinue, jButtonLogout;
	private JLabel jLabelTitle, jLabelWelcome, jLabelHeight, jLabelCM, jLabelWeight, jLabeKG, jLabelAge, jLabelYear,
			jLabelSex, jLabelLevel;
	private JPanel jPanel1, jPanel2, jPanel3;
	private JTextField textField_Weight, textField_Height, textField_Age;
	public String idUsed, nameUsed;
	// End of variables declaration//GEN-END:variables

	public InputDataView(String id, String ten) {
		idUsed = id;
		nameUsed = ten;
		initComponents(nameUsed);
	}

	private void initComponents(String ten) {

		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		jPanel3 = new JPanel();
		jLabelTitle = new JLabel();
		jLabelHeight = new JLabel();
		jLabelWelcome = new JLabel();
		jLabelCM = new JLabel();
		jLabelWeight = new JLabel();
		jLabeKG = new JLabel();
		jLabelAge = new JLabel();
		jLabelYear = new JLabel();
		jLabelSex = new JLabel();
		jLabelLevel = new JLabel();
		jButtonHome = new JButton();
		jButtonLogout = new JButton();
		jButtonContinue = new JButton();
		textField_Height = new JTextField();
		textField_Age = new JTextField();
		textField_Weight = new JTextField();
		comboBox_Sex = new JComboBox<>();
		comBoBox_level = new JComboBox<>();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new Color(0, 204, 204));

		jButtonHome.setFont(new Font("Times New Roman", 0, 11)); // NOI18N
		jButtonHome.setIcon(new ImageIcon(getClass().getResource("/Resource/Back.png"))); // NOI18N
		jButtonHome.setText("Trang chủ");
		jButtonHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonHomeActionPerformed(evt);
			}
		});

		jButtonContinue.setFont(new Font("Times New Roman", 0, 11)); // NOI18N
		jButtonContinue.setIcon(new ImageIcon(getClass().getResource("/Resource/Next.png"))); // NOI18N
		jButtonContinue.setText("Tiếp tục");
		jButtonContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonContinueActionPerformed(evt);
			}
		});

		jButtonLogout.setFont(new Font("Times New Roman", 0, 11)); // NOI18N
		jButtonLogout.setText("Đăng xuất");
		jButtonLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonLogoutActionPerformed(evt);
			}
		});

		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(
						jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup().addComponent(jButtonHome)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jButtonContinue)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jButtonHome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jButtonContinue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		jLabelTitle.setFont(new Font("Times New Roman", 1, 24)); // NOI18N
		jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelTitle.setText("Hệ tư vấn dinh dưỡng");

		jLabelWelcome.setFont(new Font("Times New Roman", 1, 10)); // NOI18N
		jLabelWelcome.setText("Xin chào " + ten);

		jPanel3.setBackground(new Color(0, 204, 204));

		jLabelHeight.setFont(new Font("Tahoma", 1, 12)); // NOI18N
		jLabelHeight.setText("Độ cao");

		textField_Height.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				textField_DoCaoActionPerformed(evt);
			}
		});

		jLabelCM.setFont(new Font("Tahoma", 1, 12)); // NOI18N
		jLabelCM.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelCM.setText("cm");

		jLabelWeight.setFont(new Font("Tahoma", 1, 12)); // NOI18N
		jLabelWeight.setText("Cân nặng");

		jLabeKG.setFont(new Font("Tahoma", 1, 12)); // NOI18N
		jLabeKG.setHorizontalAlignment(SwingConstants.CENTER);
		jLabeKG.setText("kg");

		jLabelAge.setFont(new Font("Tahoma", 1, 12)); // NOI18N
		jLabelAge.setText("Tuổi");

		textField_Age.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				textField_DoTuoiActionPerformed(evt);
			}
		});

		jLabelYear.setFont(new Font("Tahoma", 1, 12)); // NOI18N
		jLabelYear.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelYear.setText("năm");

		jLabelSex.setFont(new Font("Tahoma", 1, 12)); // NOI18N
		jLabelSex.setText("Giới tính");

		comboBox_Sex.setModel(new DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
		comboBox_Sex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				comboBox_GioiTinhActionPerformed(evt);
			}
		});

		jLabelLevel.setFont(new Font("Tahoma", 1, 12)); // NOI18N
		jLabelLevel.setText("Mức độ lao động");

		comBoBox_level
				.setModel(new DefaultComboBoxModel<>(new String[] { "Nhẹ", "Vừa", "Trung bình", "Nặng", "Rất nặng" }));
		comBoBox_level.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				comBoBox_MucDoLaoDongActionPerformed(evt);
			}
		});

		GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addComponent(jLabelHeight, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(textField_Height, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabelCM, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addComponent(jLabelWeight, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(textField_Weight, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabeKG, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
				.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
						.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
						.addGroup(GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
								.addComponent(jLabelSex, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(comboBox_Sex, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
								.addComponent(jLabelAge, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(textField_Age,
										GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabelYear, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
				.addGroup(
						jPanel3Layout.createSequentialGroup()
								.addComponent(jLabelLevel, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(comBoBox_level,
										GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
						.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
						.addComponent(jLabelCM, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textField_Height, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE).addComponent(
								jLabelHeight, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
								.addComponent(jLabeKG, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(textField_Weight)
								.addComponent(jLabelWeight, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
								.addComponent(jLabelYear, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(textField_Age)
								.addComponent(jLabelAge, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(jLabelSex, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
								.addComponent(comboBox_Sex))
						.addGap(18, 18, 18)
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(jLabelLevel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(comBoBox_level, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
						.addContainerGap(65, Short.MAX_VALUE)));

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jLabelWelcome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jLabelTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(25, 25, 25)
						.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(300, 300)
						.addComponent(jButtonLogout, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jButtonLogout, GroupLayout.PREFERRED_SIZE,
						20, GroupLayout.PREFERRED_SIZE))
				.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabelWelcome, GroupLayout.DEFAULT_SIZE,
						20, GroupLayout.PREFERRED_SIZE))
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jLabelTitle, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
						.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jPanel1,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jPanel1,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}

	private void textField_DoCaoActionPerformed(ActionEvent evt) {// GEN-FIRST:event_textField_DoCaoActionPerformed
		// TODO add your handling code here:

	}

	private void textField_DoTuoiActionPerformed(ActionEvent evt) {// GEN-FIRST:event_textField_DoTuoiActionPerformed
		// TODO add your handling code here:
	}

	private void jButtonHomeActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
		HomeViewUser homeView = new HomeViewUser(idUsed);
		homeView.setVisible(true);
		this.setVisible(false);
	}

	private void jButtonLogoutActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
		HomeView homeView = new HomeView();
		homeView.setVisible(true);
		this.setVisible(false);
	}

	private void jButtonContinueActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		// TODO add your handling code here:
		if (checkValidValue()) {
			// chuyen man hinh
			float height = Float.parseFloat(textField_Height.getText());
			float weight = Float.parseFloat(textField_Weight.getText());
			ResultView resultView = new ResultView(idUsed);
			resultView.height = height;
			resultView.weight = weight;
			resultView.setVisible(true);
			resultView.TDEE = new MainController().getTDEE(level, sex, height, weight, age);
			this.setVisible(false);
			resultView.showResult();
		}
	}

	private void comboBox_GioiTinhActionPerformed(ActionEvent evt) {// GEN-FIRST:event_comboBox_GioiTinhActionPerformed
		// TODO add your handling code here:
		sex = comboBox_Sex.getSelectedIndex();
	}

	private void comBoBox_MucDoLaoDongActionPerformed(ActionEvent evt) {// GEN-FIRST:event_comBoBox_MucDoLaoDongActionPerformed
		// TODO add your handling code here:
		level = comBoBox_level.getSelectedIndex();
	}

	public boolean checkValidValue() {
		if (textField_Weight.getText().equals("") || textField_Height.getText().equals("")
				|| textField_Age.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "chưa nhập đủ giá trị");
			return false;
		}
		String docao = textField_Height.getText();
		String cannang = textField_Weight.getText();
		String tuoi = textField_Age.getText();
		String gioitinh = comboBox_Sex.getSelectedItem().toString();
		String mucdold = comBoBox_level.getSelectedItem().toString();
		
		try {
			System.out.println("idUsed: " + idUsed);
			User.InsertUserIndex(idUsed, docao, cannang, tuoi, gioitinh, mucdold);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "nhập sai kiểu giá trị");
			return false;
		}
		
		return true;
	}

	public boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
