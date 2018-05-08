package Views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

import Model.User;

public class HomeViewUser extends JFrame {

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JButton jButtonHobby, jButtonAdvisory, jButtonMenu, jButtonExit, jButtonLogOut;
	private JLabel jLabelTitle, jLabelTitleUser;
	private JPanel jPanelHome;
	public String idUsed;
	String name = null;
	// End of variables declaration//GEN-END:variables

	public HomeViewUser(String id) {
		idUsed = id;
		try {
			name = User.getUserName(idUsed);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		initComponents(name);
	}
	private void initComponents(String ten) {

		
		jPanelHome = new JPanel();
		jLabelTitle = new JLabel();
		jLabelTitleUser = new JLabel();
		jButtonLogOut = new JButton();
		jButtonHobby = new JButton();
		jButtonAdvisory = new JButton();
		jButtonMenu = new JButton();
		jButtonExit = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jPanelHome.setBackground(new Color(0, 204, 204));

		jLabelTitle.setFont(new Font("Times New Roman", 1, 24)); // NOI18N
		jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelTitle.setText("Hệ tư vấn dinh dưỡng");
		
		jLabelTitleUser.setFont(new Font("Times New Roman", 1, 10)); // NOI18N
		jLabelTitleUser.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelTitleUser.setText("Xin chào " + ten);

		jButtonLogOut.setFont(new Font("Times New Roman", 1, 10)); // NOI18N
		jButtonLogOut.setText("Đăng xuất");
		jButtonLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonLogOutpActionPerformed(evt);
			}
		});

		jButtonHobby.setFont(new Font("Times New Roman", 1, 18)); // NOI18N
		jButtonHobby.setIcon(new ImageIcon(getClass().getResource("/Resource/Modify.png"))); // NOI18N
		jButtonHobby.setText("Sở thích");
		jButtonHobby.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonHobbyActionPerformed(evt);
			}
		});

		jButtonAdvisory.setFont(new Font("Times New Roman", 1, 18)); // NOI18N
		jButtonAdvisory.setIcon(new ImageIcon(getClass().getResource("/Resource/home.png"))); // NOI18N
		jButtonAdvisory.setText("Tư vấn");
		jButtonAdvisory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonAdvisoryActionPerformed(evt);
			}
		});

		jButtonMenu.setFont(new Font("Times New Roman", 1, 18)); // NOI18N
		jButtonMenu.setIcon(new ImageIcon(getClass().getResource("/Resource/Line Chart.png"))); // NOI18N
		jButtonMenu.setText("Thực đơn");
		jButtonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonMenuActionPerformed(evt);
			}
		});

		jButtonExit.setFont(new Font("Times New Roman", 1, 18)); // NOI18N
		jButtonExit.setIcon(new ImageIcon(getClass().getResource("/Resource/Exit.png"))); // NOI18N
		jButtonExit.setText("Thoát");
		jButtonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonExitActionPerformed(evt);
			}
		});

		GroupLayout jPanel3Layout = new GroupLayout(jPanelHome);
		jPanelHome.setLayout(jPanel3Layout);

		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jLabelTitle, 0, 150, 400)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap(210, 210)
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(
								jLabelTitleUser, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap(300, 300)
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(
								jButtonLogOut, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
				.addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
						.addContainerGap(109, Short.MAX_VALUE)
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(jButtonExit, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButtonMenu, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButtonAdvisory, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButtonHobby, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
						.addGap(105, 105, 105)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addComponent(jButtonLogOut, GroupLayout.PREFERRED_SIZE,
						30, GroupLayout.PREFERRED_SIZE))
				.addGroup(jPanel3Layout.createSequentialGroup().addComponent(jLabelTitleUser, GroupLayout.PREFERRED_SIZE,
						30, GroupLayout.PREFERRED_SIZE))
				.addGroup(jPanel3Layout.createSequentialGroup().addGap(30, 30, 30)
						.addComponent(jLabelTitle, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addGap(50, 50, 50)
						.addComponent(jButtonAdvisory, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jButtonHobby, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jButtonMenu, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jButtonExit, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(61, Short.MAX_VALUE)));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(
				jPanelHome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(
				jPanelHome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}
	
	private void jButtonLogOutpActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
		HomeView homeView = new HomeView();
		homeView.setVisible(true);
		this.setVisible(false);
	}// GEN-LAST:event_jButton2ActionPerformed

	private void jButtonAdvisoryActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
		InputDataView inputDataView = new InputDataView(idUsed,name);
		inputDataView.setVisible(true);
		this.setVisible(false);
	}// GEN-LAST:event_jButton2ActionPerformed

	private void jButtonHobbyActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
		ListViewFavorite viewFavotite = new ListViewFavorite(idUsed);
		viewFavotite.setVisible(true);
		this.setVisible(false);
	}// GEN-LAST:event_jButton1ActionPerformed

	private void jButtonMenuActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
		ResultMenuView resultMenuView = new ResultMenuView(idUsed);
		resultMenuView.setVisible(true);
		this.setVisible(false);
	}

	private void jButtonExitActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
		this.setVisible(false);
	}// GEN-LAST:event_jButton4ActionPerformed

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
				new HomeView().setVisible(true);
			}
		});
	}
}
