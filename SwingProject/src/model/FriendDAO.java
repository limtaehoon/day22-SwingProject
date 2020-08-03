package model;

import java.util.ArrayList;

public interface FriendDAO {
//�߰�
public void friendInsert(Friend f) ;

//��ü����
public ArrayList<Friend>friendView(); 
		
//�󼼺��� 
public Friend friendDetail(int num) ;
	
//�����ϱ�
public void friendUpdate(Friend f); 
	
//�����ϱ�
public void friendDelete(int num);

//�˻��ϱ�
public ArrayList<Friend> friendSeach(String key, String word);
}







