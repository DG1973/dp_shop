package dp.shop.Dao.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dp.shop.Common.DBUtils;
import dp.shop.Dao.Address_Dao_Interface;
import dp.shop.Entity.Address;
import dp.shop.Entity.PageModel;


public class Address_Dao_imp implements Address_Dao_Interface {
	private static  Address_Dao_Interface daoDanLi=null;
	private Address_Dao_imp() {}
	public synchronized static Address_Dao_Interface getAddressDao() {
		if(daoDanLi==null) {
			return daoDanLi=new Address_Dao_imp();
		}
		return daoDanLi;
	}
	
	@Override
	public int addAddress(Integer userid, Address address) {
		// TODO Auto-generated method stub
		//添加用户收货地址
		Connection conn=null;
		PreparedStatement pst=null;
		
		try {
			conn=DBUtils.getConnection();
			String sql=	"insert into address(user_id , receiver_name  ,  receiver_phone  ,  receiver_mobile  ,  receiver_province  ,\r\n" + 
								"receiver_city  ,  receiver_district , receiver_address , receiver_zip , create_time , update_time)\r\n" + 
								"values \r\n" + 
								"(?,?,?,?,?,?,?,?,?,now(),now())";
			pst=conn.prepareStatement(sql);
			//System.out.println(id);
			pst.setInt(1,userid);
			pst.setString(2, address.getReceiver_name());
			pst.setString(3, address.getReceiver_phone());
			pst.setString(4, address.getReceiver_mobile());
			pst.setString(5, address.getReceiver_province());
			pst.setString(6, address.getReceiver_city());
			pst.setString(7, address.getReceiver_district());
			pst.setString(8, address.getReceiver_address());
			pst.setString(9, address.getReceiver_zip());		 
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deletAddressByUserid(Integer userid, Integer id) {
		// TODO Auto-generated method stub
		//删除用户地址
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DBUtils.getConnection();
			String sql="delete from address where user_id=? and di=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1,userid);
			pst.setInt(2,id);
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DBUtils.Close(conn, pst);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	@Override
	public int updataUserAddressByUserid(Integer userid, Address address) {
		// TODO Auto-generated method stub
		//用户修改收货地址
		Connection conn=null;
		PreparedStatement pst=null;
		
		try {
			conn=DBUtils.getConnection();
			String sql="update  address set  receiver_name=?  ,  receiver_phone=?  ,  receiver_mobile=?  ,  receiver_province=?,\r\n" + 
								"receiver_city=?  ,  receiver_district=? , receiver_address=? , receiver_zip=?,update_time=now()\r\n" + 
								"where user_id=? ";
			pst=conn.prepareStatement(sql);

			//System.out.println(id);
			
			pst.setString(1, address.getReceiver_name());
			pst.setString(2, address.getReceiver_phone());
			pst.setString(3, address.getReceiver_mobile());
			pst.setString(4, address.getReceiver_province());
			pst.setString(5, address.getReceiver_city());
			pst.setString(6, address.getReceiver_district());
			pst.setString(7, address.getReceiver_address());
			pst.setString(8, address.getReceiver_zip());	
			pst.setInt(8,address.getUser_id());
			return pst.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@SuppressWarnings("resource")
	@Override
	public PageModel<Address> findUserAddress(Integer pageNo, Integer pageSize, Integer userid) {
		// 分页获取数据 
		Connection conn=null;
		PreparedStatement  pst=null;
		ResultSet rs=null;
		PageModel<Address> pageModel=new PageModel<Address>();
		
		try {
			conn=DBUtils.getConnection();
			//查询总记录
			pst=conn.prepareStatement("select count(id) from address");
			rs= pst.executeQuery();
			if(rs.next()) {
				int totalCount=rs.getInt(1);
				//计算多少页
				int totalpage=totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize+1);
				pageModel.setTotalPage(totalpage);
			}
			String sql="select  user_id , receiver_name  ,  receiver_phone  ,  receiver_mobile  ,  receiver_province  ,\r\n" + 
					"receiver_city  ,  receiver_district , receiver_address , receiver_zip , create_time , update_time from address where user_id=? limit ?,?  ";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, userid);
			pst.setInt(2, (pageNo-1)*pageSize);
			pst.setInt(3, pageSize);
			rs=pst.executeQuery();
			List<Address> list= new ArrayList<Address>();
			while (rs.next()) {
				Address address=new Address(rs.getInt("id"), rs.getInt("user_id"),rs.getString("receiver_name"),rs.getString("receiver_phone"),rs.getString("receiver_mobile"),rs.getString("receiver_province"),rs.getString("receiver_city"),rs.getString("receiver_district"),rs.getString("receiver_address"),rs.getString("receiver_zip"),rs.getDate("create_time"),rs.getDate("update_time"));
				list.add(address);
			}
			pageModel.setData(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DBUtils.Close(conn, pst, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pageModel;
	}
}


