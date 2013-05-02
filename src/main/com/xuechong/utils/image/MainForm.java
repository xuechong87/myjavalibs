package com.xuechong.utils.image;


import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * @author  xuechong87
 */
public class MainForm extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private javax.swing.JMenuItem aboutMenuItem;
	private javax.swing.JButton chooseButton;
	private javax.swing.JMenuItem contentsMenuItem;
	private javax.swing.JTextField folderChoosed;
	private javax.swing.JMenu helpMenu;
	private javax.swing.JMenuBar menuBar;
	private JFileChooser fileChooser;
	private javax.swing.JButton startButton;

	//the processor is current running
	private volatile boolean isProcessing = Boolean.FALSE;
	
	public MainForm() {
		init();
	}

	
	private void init() {

		chooseButton = new javax.swing.JButton();
		folderChoosed = new javax.swing.JTextField();
		startButton = new javax.swing.JButton();
		menuBar = new javax.swing.JMenuBar();
		helpMenu = new javax.swing.JMenu();
		contentsMenuItem = new javax.swing.JMenuItem();
		aboutMenuItem = new javax.swing.JMenuItem();
		this.fileChooser = new JFileChooser(File.listRoots()[0]);

		this.setResizable(false);
		this.folderChoosed.setEditable(false);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		chooseButton.setText("choose");
		chooseButton.setActionCommand("folder");
		chooseButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chooseButtonActionPerformed(evt);
			}
		});

		startButton.setText("start");
		startButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				startButtonActionPerformed(evt);
			}
		});

		helpMenu.setText("Help");

		contentsMenuItem.setText("Contents");
		helpMenu.add(contentsMenuItem);

		aboutMenuItem.setText("About");
		helpMenu.add(aboutMenuItem);

		menuBar.add(helpMenu);

		setJMenuBar(menuBar);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addComponent(
						folderChoosed, javax.swing.GroupLayout.PREFERRED_SIZE,
						382, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18,
						18, 18).addComponent(chooseButton).addPreferredGap(
						javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(startButton).addContainerGap(79,
								Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addGroup(
						layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(folderChoosed,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										25,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(chooseButton).addComponent(
										startButton)).addContainerGap(34,
						Short.MAX_VALUE)));

		startButton.getAccessibleContext().setAccessibleName("startButton");

		pack();
	}

	private synchronized void startButtonActionPerformed(java.awt.event.ActionEvent evt) {
		
		if(this.folderChoosed.getText().length()<=0){
			JOptionPane.showMessageDialog(this, "pleas choose a folder first");
			return;
		}
		if(this.isProcessing){
			JOptionPane.showMessageDialog(this, "the last task is processing now ,please wait a moment");
			return;
		}
		//result is 0 when confirmed
		int result = JOptionPane.showConfirmDialog(this, "confirm run?");
		if(result==0){
			this.isProcessing=Boolean.TRUE;
			new Thread(new Processor(this)).start();
		}
		
	}

	private void chooseButtonActionPerformed(java.awt.event.ActionEvent evt) {
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setDialogTitle("打开文件夹");
		int ret = fileChooser.showOpenDialog(null);
		if (ret == JFileChooser.APPROVE_OPTION) {
			//文件夹路径
			this.folderChoosed.setText(fileChooser.getSelectedFile()
					.getAbsolutePath());
		}
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainForm().setVisible(true);
			}
		});
	}
	
	public synchronized void notifyProcessDone(){
		this.isProcessing=Boolean.FALSE;
	}
	
}