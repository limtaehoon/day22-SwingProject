package comCon;

import static org.junit.Assert.assertEquals;			//프로젝트에 properties(Atl+enter) 클릭 >  java build path 클릭 
														//>add librily> junit> 4unit 
														

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import model.Friend;
import model.FriendDAOImpl;

public class ConnectionTest {
private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";			//저장소 입력
private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";		//사용자장소 입력 
private static final String USER = "scott";										//사용자 이름 입력
private static final String	PW = "1234";										//사용자 비밀번호 입력

@Test																//junit 사용자 위에 작성 				
public void TestConnection() throws ClassNotFoundException {		
	Class.forName(DRIVER);											//클래스 :저장소
	
	try (Connection con	=DriverManager.getConnection(URL,USER , PW)){//저장소에 연결( 장소,유저,비밀번호)
		System.out.println(con);										//출력
	} catch (Exception e) {										//예외 처리 (오류시 오류 출력
		// TODO: handle exception
		e.printStackTrace();
	}
	
}
@Test			
public void detailFriend() {						//상세내용
	FriendDAOImpl dao =new FriendDAOImpl();			//FriendDAOImpl 내용을 dao 라는이름으로 가져와서 생성
assertEquals("33",dao.friendDetail(4).getName());	//assertEquals:내용 같은지확인하고   // FriendDAOImpl 안에 friendDetail의 4번째 이름
}
@Test 
public void insertFriend() {						//추가내용
	FriendDAOImpl dao = new FriendDAOImpl();		//FriendDAOImpl 내용을 dao 라는이름으로 가져와서 생성
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