/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

/**
 *
 * @author nghiadv
 */
public class AddFood extends javax.swing.JFrame {

	/**
	 * Creates new form AddFood
	 */
	public AddFood() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jTextField5 = new javax.swing.JTextField();
		jTextField6 = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox<>();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jLabel1.setText("Add Food");

		jLabel2.setText("tên món");

		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		jLabel3.setText("Đơn vị");

		jLabel4.setText("Tổng calo");

		jLabel5.setText("Protein");

		jLabel6.setText("lipit");

		jLabel7.setText("Tinh Bột");

		jLabel8.setText("Bữa ăn");

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sáng", "Trưa", "Tối" }));

		jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Back.png"))); // NOI18N

		jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Next.png"))); // NOI18N

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
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(jLabel7).addComponent(jLabel8)).addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jTextField1).addComponent(jTextField2).addComponent(jTextField3)
										.addComponent(jTextField4).addComponent(jTextField5).addComponent(jTextField6)
										.addComponent(jComboBox1, 0, 103, Short.MAX_VALUE))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup().addComponent(jButton1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59,
										Short.MAX_VALUE)
								.addComponent(jButton2).addGap(26, 26, 26)))));
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
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel5)
						.addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel6)
						.addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel7)
						.addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel8)
						.addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton1).addGap(19, 19, 19))
						.addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addComponent(jButton2)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField1ActionPerformed

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(AddFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(AddFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(AddFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AddFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AddFood().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JComboBox<String> jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	// End of variables declaration//GEN-END:variables
}
