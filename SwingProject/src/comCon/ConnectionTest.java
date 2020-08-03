package comCon;

import static org.junit.Assert.assertEquals;			//������Ʈ�� properties(Atl+enter) Ŭ�� >  java build path Ŭ�� 
														//>add librily> junit> 4unit 
														

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import model.Friend;
import model.FriendDAOImpl;

public class ConnectionTest {
private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";			//����� �Է�
private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";		//�������� �Է� 
private static final String USER = "scott";										//����� �̸� �Է�
private static final String	PW = "1234";										//����� ��й�ȣ �Է�

@Test																//junit ����� ���� �ۼ� 				
public void TestConnection() throws ClassNotFoundException {		
	Class.forName(DRIVER);											//Ŭ���� :�����
	
	try (Connection con	=DriverManager.getConnection(URL,USER , PW)){//����ҿ� ����( ���,����,��й�ȣ)
		System.out.println(con);										//���
	} catch (Exception e) {										//���� ó�� (������ ���� ���
		// TODO: handle exception
		e.printStackTrace();
	}
	
}
@Test			
public void detailFriend() {						//�󼼳���
	FriendDAOImpl dao =new FriendDAOImpl();			//FriendDAOImpl ������ dao ����̸����� �����ͼ� ����
assertEquals("33",dao.friendDetail(4).getName());	//assertEquals:���� ������Ȯ���ϰ�   // FriendDAOImpl �ȿ� friendDetail�� 4��° �̸�
}
@Test 
public void insertFriend() {						//�߰�����
	FriendDAOImpl dao = new FriendDAOImpl();		//FriendDAOImpl ������ dao ����̸����� �����ͼ� ����
	Friend f = new Friend();
	f.setAddr("addrTest");							
	f.setBirth("20200706");
	f.setName("test");
	f.setPhone("010");
	dao.friendInsert(f);
	
	
	
}
@Test
public void deleteFriend() {
	FriendDAOImpl dao = new FriendDAOImpl();
	dao.friendDelete(2);
	
}



}