package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Friend;
import model.FriendDAOImpl;

import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FriendView extends JFrame {
	JTextField[] tf =new JTextField[6];
	private JPanel contentPane;
	private JSplitPane splitPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField tfName;
	private JTextField tfBirth;
	private JTextField tfPhone;
	private JTextField tfaddr;
	private JButton btnview;
	private JButton btninsert;
	private JButton btnDelete;
	private JButton btnupdate;
	private JTextField tfnum;
	private JLabel tfNum;
	private JSplitPane splitPane_1;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JComboBox jcb;
	private JTextField tfSearch;
	private JButton btnSearch;
	FriendDAOImpl dao =new FriendDAOImpl();
	private JTextArea ta;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FriendView frame = new FriendView();
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
	public FriendView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setLeftComponent(getPanel());
			splitPane.setRightComponent(getSplitPane_1());
			splitPane.setDividerLocation(200);
		}
		return splitPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getLblNewLabel_1());
			panel.add(getLblNewLabel_2());
			panel.add(getLblNewLabel_3());
			panel.add(getTfNum());
			panel.add(getTfName());
			panel.add(getTfBirth());
			panel.add(getTfPhone());
			panel.add(getTfaddr());
			panel.add(getBtninsert());
			panel.add(getBtnview());
			panel.add(getBtnupdate());
			panel.add(getBtnDelete());
			panel.add(getTfnum());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC774\uB984");
			lblNewLabel.setBounds(12, 61, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC0DD\uC77C");
			lblNewLabel_1.setBounds(12, 107, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC804\uD654\uBC88\uD638");
			lblNewLabel_2.setBounds(12, 164, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC8FC\uC18C");
			lblNewLabel_3.setBounds(12, 216, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(60, 58, 116, 21);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfBirth() {
		if (tfBirth == null) {
			tfBirth = new JTextField();
			tfBirth.setBounds(60, 104, 116, 21);
			tfBirth.setColumns(10);
		}
		return tfBirth;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setBounds(60, 161, 116, 21);
			tfPhone.setText("");
			tfPhone.setColumns(10);
		}
		return tfPhone;
	}
	private JTextField getTfaddr() {
		if (tfaddr == null) {
			tfaddr = new JTextField();
			tfaddr.setBounds(60, 213, 116, 21);
			tfaddr.setText("");
			tfaddr.setColumns(10);
		}
		return tfaddr;
	}
	
	//친구등록
	private JButton getBtninsert() {
		if (btninsert == null) {
			btninsert = new JButton("\uCE5C\uAD6C\uB4F1\uB85D");
			btninsert.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					Friend f = new Friend();
					f.setName(tfName.getText());
					f.setBirth(tfBirth.getText());
					f.setPhone(tfPhone.getText());
					f.setAddr(tfaddr.getText());
					dao.friendInsert(f);
					btnview.doClick();
				}
			});
			btninsert.setBounds(0, 285, 97, 23);
		}
		return btninsert;
	}
	//보기
		private JButton getBtnview() {
			if (btnview == null) {
				btnview = new JButton("\uC804\uCCB4\uBCF4\uAE30");
				btnview.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
						ta.setText("");
					ArrayList<Friend>arr = dao.friendView();
					for(Friend f: arr) {
						ta.append("번호:" + f.getNum()+"\n");
						ta.append("이름:" + f.getName()+"\n");
						ta.append("생일:" + f.getBirth()+"\n");
						ta.append("전화번호:" + f.getName()+"\n");
						ta.append("주소:" + f.getName()+"\n\n");
						
					}
						
					}
				});
				btnview.setBounds(102, 285, 97, 23);
			}
			return btnview;
		}
	//수정
	private JButton getBtnupdate() {
		if (btnupdate == null) {
			btnupdate = new JButton("\uC218\uC815");
			btnupdate.setBounds(0, 389, 97, 23);
			btnupdate.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Friend f = new Friend();
					
					f.setName(tfName.getText());
					f.setBirth(tfBirth.getText());
					f.setPhone(tfPhone.getText());
					f.setAddr(tfaddr.getText());
					f.setNum(Integer.parseInt(tfnum.getText()));
					
					dao.friendUpdate(f);
					btnview.doClick();
					clearText();
					
				}
			});
		}
		return btnupdate;
		
	}
	//삭제
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("\uC0AD\uC81C\uD558\uAE30");
			btnDelete.setBounds(102, 389, 97, 23);
			btnDelete.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int num = Integer.parseInt(tfnum.getText());
					dao.friendDelete(num);
					btnview.doClick();
					clearText();
				}		
			});
		}
		return btnDelete;
	}
					
	private JTextField getTfnum() {
		if (tfnum == null) {
			tfnum = new JTextField();
			tfnum.setBounds(60, 336, 116, 21);
			tfnum.setColumns(10);
		}
		return tfnum;
	}
	private JLabel getTfNum() {
		if (tfNum == null) {
			tfNum = new JLabel("\uBC88\uD638");
			tfNum.setBounds(12, 339, 57, 15);
		}
		return tfNum;
	}
	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_1.setLeftComponent(getScrollPane());
			splitPane_1.setRightComponent(getPanel_1());
			splitPane_1.setDividerLocation(300);
		}
		return splitPane_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTa());
		}
		return scrollPane;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getJcb());
			panel_1.add(getTfSearch());
			panel_1.add(getBtnSearch());
		}
		return panel_1;
	}
	private JComboBox getJcb() {
		if (jcb == null) {
			jcb = new JComboBox();
			jcb.setModel(new DefaultComboBoxModel(new String[] {"\uC120\uD0DD...", "\uC774\uB984", "\uC8FC\uC18C"}));
			jcb.setBounds(49, 50, 73, 21);
		}
		return jcb;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(160, 49, 116, 21);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("\uAC80\uC0C9");
			btnSearch.setBounds(300, 48, 97, 23);
		}
		return btnSearch;
	}
	private JTextArea getTa() {
		if (ta == null) {
			ta = new JTextArea();
			ta.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				int num = Integer.parseInt(ta.getSelectedText().trim());
				Friend f = dao.friendDetail(num);
				
				tfName.setText(f.getName());
				tfBirth.setText(f.getBirth());
				tfPhone.setText(f.getPhone());
				tfaddr.setText(f.getAddr());
				tfnum.setText(num+"");
				}
			});
		}
		return ta;
	}	
	private void clearText() {
		
		}
	}


