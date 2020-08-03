package model;


import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public  class FriendDAOImpl implements FriendDAO {
	
	//생성자>디비연결
	String url, user, pwd;
	public FriendDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user="scott";
			pwd = "1234";
	   	} catch (ClassNotFoundException e) {
				e.printStackTrace();
	   	}
	
	}
	@Override
	//친구등록
	public void friendInsert(Friend f) {
		Connection con = null;
		PreparedStatement ps = null;
	try {
		con = DriverManager.getConnection(url, user,pwd);
		String sql ="insert into Friend values(friend_play.nextval,?,?,?,?)";
		ps=con.prepareStatement(sql);
	
		ps.setString(1, f.getName());
		ps.setString(2, f.getBirth());
		ps.setString(3, f.getPhone());
		ps.setString(4, f.getAddr());
		ps.executeUpdate();
	}catch (SQLException e) {
		e.printStackTrace();//~`
		
	}finally {
		closeConnection(con,ps);
	}
		
	}

	//전체보기
	@Override
	public ArrayList<Friend> friendView() {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement st =null;
		ResultSet rs = null;
		ArrayList<Friend> arr = new ArrayList<Friend>();
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from friend order by num desc";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Friend f = new Friend();
				f.setNum(rs.getInt("num"));
				f.setName(rs.getString("name"));
				f.setBirth(rs.getString("birth"));
				f.setPhone(rs.getString("phone"));
				f.setAddr(rs.getString("addr"));
				arr.add(f);
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,st,rs);
		}
		return arr;
		
		
	
	}

		
	
	//상세보기
	public Friend friendDetail(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Friend f =null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from Friend where num="+num;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				f = new Friend();
				f.setNum(rs.getInt("num"));
				f.setName(rs.getString("name"));
				f.setBirth(rs.getString("birth"));
				f.setPhone(rs.getString("phone"));
				f.setAddr(rs.getNString("addr"));
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}
		return f;
	}
	//수정
	@Override
	public void friendUpdate(Friend f) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "update Friend set name=?,"
					+ "birth=?, phone=?, addr=? where num=?";
			con = DriverManager.getConnection(url, user, pwd);
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1,f.getName());
			ps.setString(2,f.getBirth());
			ps.setString(3,f.getPhone());
			ps.setString(4,f.getAddr());
			ps.setInt(5, f.getNum());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection(con, ps);
		}
		
	}
	//삭제
	public void friendDelete(int num) {
		Connection con =null;
		Statement st = null;
		
	
	try {
		con = DriverManager.getConnection(url, user, pwd);
		String sql = "delete from Friend where num="+num;
		st = con.createStatement();
		st.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		closeConnection(con, st,null);
	}
		
	}
	//검색
	@Override
	public ArrayList<Friend> friendSeach(String key, String word){ 
		Connection con =null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Friend> arr = new ArrayList<Friend>();
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			st = con.createStatement();
			String sql ="select * from Friend "
					+ " where "+key +" like '%"+word+"%'";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Friend f = new Friend();
				f.setName(rs.getString("name"));
				f.setBirth(rs.getString("birth"));
				f.setPhone(rs.getString("phone"));
				f.setAddr(rs.getString("addr"));
				}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}return arr;
		
		
	
	}
	


	private void closeConnection(Connection con, 
			Statement st, ResultSet rs) {
		try {
			if(st!=null)st.close();
			if(con!=null)con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void closeConnection(Connection con, PreparedStatement ps) {
		try {
			if(ps!=null)ps.close();
			if(con!=null)con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		
	}
	

	
	}

		
	
