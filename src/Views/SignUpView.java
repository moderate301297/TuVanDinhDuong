package Views;

import Model.User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class SignUpView extends JFrame {
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JButton jButtonHome, jButtonContinue;
	private JLabel jLabelTitle, jLabelName, jLabelUser, jLabelPassword;
	private JPanel jPanel1, jPanel2, jPanel3;
	private JTextField textField_User, textField_Name, textField_Password;
	// End of variables declaration//GEN-END:variables

	public SignUpView() {
		initComponents();
	}

	private void initComponents() {

		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		jPanel3 = new JPanel();
		jLabelTitle = new JLabel();
		jLabelName = new JLabel();
		jLabelUser = new JLabel();
		jLabelPassword = new JLabel();
		jButtonHome = new JButton();
		jButtonContinue = new JButton();
		textField_Name = new JTextField();
		textField_Password = new JTextField();
		textField_User = new JTextField();
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
		jLabelTitle.setText("Đăng ký tài khoản");

		jLabelName.setFont(new Font("Times New Roman", 1, 12)); // NOI18N
		jLabelName.setText("Họ và tên");

		textField_Name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				textField_NameActionPerformed(evt);
			}
		});

		jPanel3.setBackground(new Color(0, 204, 204));

		jLabelUser.setFont(new Font("Tahoma", 1, 12)); // NOI18N
		jLabelUser.setText("Tên đăng nhập");

		textField_User.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				textField_UserActionPerformed(evt);
			}
		});

		jLabelPassword.setFont(new Font("Tahoma", 1, 12)); // NOI18N
		jLabelPassword.setText("Mật khẩu");

		textField_Password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				textField_PasswordActionPerformed(evt);
			}
		});

		GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addComponent(jLabelName, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(textField_Name, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addComponent(jLabelUser, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(textField_User, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addComponent(jLabelPassword, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(textField_Password,
								GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
								.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
										.addComponent(textField_Name, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
										.addComponent(jLabelName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)

										.addComponent(textField_User).addComponent(jLabelUser,
												GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(jLabelPassword, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
										.addComponent(textField_Password))
								.addGap(5, 5, 5)));

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jLabelTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10)
						.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
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

	private void textField_NameActionPerformed(ActionEvent evt) {// GEN-FIRST:event_textField_DoCaoActionPerformed
		// TODO add your handling code here:

	}

	private void textField_UserActionPerformed(ActionEvent evt) {// GEN-FIRST:event_textField_DoCaoActionPerformed
		// TODO add your handling code here:

	}

	private void textField_PasswordActionPerformed(ActionEvent evt) {// GEN-FIRST:event_textField_DoTuoiActionPerformed
		// TODO add your handling code here:
	}

	private void jButtonHomeActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
		HomeView homeView = new HomeView();
		homeView.setVisible(true);
		this.setVisible(false);
	}

	private void jButtonContinueActionPerformed(ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		// TODO add your handling code here:
		if (checkValidValue()) {
			HomeView homeView = new HomeView();
			homeView.setVisible(true);
			this.setVisible(false);
		}
	}

	public boolean checkValidValue() {
		if (textField_Name.getText().equals("") || textField_User.getText().equals("")
				|| textField_Password.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "chưa nhập đủ giá trị");
			return false;
		}
		String ten = textField_Name.getText();
		String tendangnhap = textField_User.getText();
		String matkhau = textField_Password.getText();
		try {
			User.InsertUser(ten, tendangnhap, matkhau);
		} catch (SQLException e) {
			System.err.println("error: " + e);
			return false;
		}
		return true;
	}
}
