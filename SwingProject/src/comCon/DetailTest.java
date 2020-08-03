package comCon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Friend;
import model.FriendDAOImpl;

public class DetailTest {

	@Test
	public void detailFriend() {
		FriendDAOImpl dao =new FriendDAOImpl();
	assertEquals("33",dao.friendDetail(4).getName());
	}
}
