package dp.shop.Dao.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dp.shop.Common.DBUtils;
import dp.shop.Dao.Userlogin_Dao_Interface;
import dp.shop.Entity.PageModel;
import dp.shop.Entity.User;

public class Login_Dao_Imp implements Userlogin_Dao_Interface {

	@Override
	public int checkUserName(String username) {
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		 try {
			 
			conn=DBUtils.getConnection();
			
			String sql="select username from user where username=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1,username);
			rs=pst.executeQuery();
			
			if (rs.next()) {
				return 1;
			}else{
				return 0;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null){
					conn.close();
					}
					if(pst!=null){
					pst.close();
					}
					if(rs!=null){
					rs.close();
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		User user=null;
		 try {
			 
			conn=DBUtils.getConnection();
			
			String sql="select id,username,password,email,phone,question,answer,role,create_time,update_time from user where username=? and password=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1,username);
			pst.setString(2,password);
			rs=pst.executeQuery();
			
			if (rs.next()) {
				user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setQuestion(rs.getString("question"));
				user.setAnswer(rs.getString("answer"));
				user.setRole(rs.getInt("role"));
				user.setCreate_time(rs.getDate("create_time"));
				user.setUpdate_time(rs.getDate("update_time"));
				return user;
			}else{
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null){
					conn.close();
					}
					if(pst!=null){
					pst.close();
					}
					if(rs!=null){
					rs.close();
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int updateTokenByUserId(Integer userid, String token) {
		// TODO Auto-generated method stub
		//更新用户信息
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DBUtils.getConnection();
			String sql="update user set token=? where id=?";
			pst=conn.prepareStatement(sql);

			pst.setString(1,token);
			pst.setInt(2, userid);

			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}


	@Override
	public User findUserByToken(String token) {
		//根据id查询商品类别
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		User user=new User();
		try {
			conn=DBUtils.getConnection();
			String sql="select id,username,password,email,phone,question,answer,role,create_time,update_time from user where token=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1,token);
			rs=pst.executeQuery();
			if(rs.next()) {
				
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setQuestion(rs.getString("question"));
				user.setAnswer(rs.getString("answer"));
				user.setRole(rs.getInt("role"));
				user.setCreate_time(rs.getDate("create_time"));
				user.setUpdate_time(rs.getDate("update_time"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DBUtils.Close(conn, pst, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageModel<User> findAllUser(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findAllUserCount() {
		// TODO Auto-generated method stub
		return 0;
	}
    

}
