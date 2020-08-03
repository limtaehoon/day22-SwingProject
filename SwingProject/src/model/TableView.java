package model;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Friend;
import model.FriendDAOImpl;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TableView extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel tab1;
	private JPanel tab2;
	private JPanel tab3;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnNewButton;
	private JTextField tf;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableView frame = new TableView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TableView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getTabbedPane(), BorderLayout.CENTER);
	}

	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addTab("회원정보", null, getTab1(), null);
			tabbedPane.addTab("회원가입", null, getTab2(), null);
			tabbedPane.addTab("세번째 tab", null, getTab3(), null);
		}
		return tabbedPane;
	}
	private JPanel getTab1() {
		if (tab1 == null) {
			tab1 = new JPanel();
			tab1.setLayout(new BorderLayout(0, 0));
			tab1.add(getScrollPane(), BorderLayout.CENTER);
		}
		return tab1;
	}
	private JPanel getTab2() {
		if (tab2 == null) {
			tab2 = new JPanel();
			tab2.setLayout(null);
			tab2.add(getBtnNewButton());
		}
		return tab2;
	}
	private JPanel getTab3() {
		if (tab3 == null) {
			tab3 = new JPanel();
			tab3.setLayout(null);
			tab3.add(getTf());
			tab3.add(getComboBox());
		}
		return tab3;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			FriendDAOImpl dao =new  FriendDAOImpl();
			ArrayList<Friend> arr = dao.friendView();
			String[] cols = {"번호","이름","생일","전화번호","주소"};
			DefaultTableModel dt 
			          = new DefaultTableModel(cols,arr.size());
			table.setModel(dt);
			for(int i=0; i<arr.size();i++) {
				dt.setValueAt(arr.get(i).getNum(), i, 0);
				dt.setValueAt(arr.get(i).getName(), i, 1);
				dt.setValueAt(arr.get(i).getBirth(), i, 2);
				dt.setValueAt(arr.get(i).getPhone(), i, 3);
				dt.setValueAt(arr.get(i).getAddr(), i, 4);
			}
		}
		return table;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
				tf.setText("탭이동");
				}
			});
			btnNewButton.setBounds(150, 147, 97, 36);
		}
		return btnNewButton;
	}
	private JTextField getTf() {
		if (tf == null) {
			tf = new JTextField();
			tf.setBounds(97, 122, 131, 40);
			tf.setColumns(10);
		}
		return tf;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(113, 75, 30, 21);
		}
		return comboBox;
	}
}
