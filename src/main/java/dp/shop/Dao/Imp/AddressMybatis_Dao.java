package dp.shop.Dao.Imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import dp.shop.Common.MybatisUtils;
import dp.shop.Dao.AddressMyBatis_Dao_Interface;
import dp.shop.Entity.Address;
import dp.shop.Entity.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("AddressMyBatisDao")
public class AddressMybatis_Dao implements AddressMyBatis_Dao_Interface{
	@Autowired
	SqlSessionFactory factory;

	public void setFactory(SqlSessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public int addAddress(Integer userid, Address address) {
		// TODO Auto-generated method stub

		SqlSession session=factory.openSession(false);
		//??SqlSession ???????sql???
		Map<String,Object> map=new HashMap<String,Object>();
		
		map.put("id",address.getId());
		map.put("user_id",userid);
		map.put("receiver_name",address.getReceiver_name());
		map.put("receiver_phone",address.getReceiver_phone());
		map.put("receiver_mobile",address.getReceiver_mobile());
		map.put("receiver_province",address.getReceiver_province());
		map.put("receiver_district",address.getReceiver_district());
		map.put("receiver_address",address.getReceiver_address());
		map.put("receiver_zip",address.getReceiver_zip());
		
		//4??????MyBatis????api    //5?????MAP????
		int num=session.insert("dp.shop.Address.addAddress", map);
		
		//6????????
		session.commit();
		//7?????SqlSession
		session.close();

		return num;
	}

	@Override
	public int deletAddressByUserid(Integer userid, Integer id) {
		// TODO Auto-generated method stub

		SqlSession session=factory.openSession(false);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userid",userid);
		map.put("id", id);
		System.out.println(map.get("userid"));
		System.out.println(map.get("id"));
		int num= session.delete("dp.shop.Address.deletAddressByUserid", map);
		
		session.commit();
		MybatisUtils.close(session);
		
		return num;
	}

	@Override
	public int updataUserAddressByUserid(Integer id,Integer userid, Address address) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(false);
		
		address.setId(id);
		address.setUser_id(userid);
		System.out.println(address);
		
		int num =session.update("dp.shop.Address.updataUserAddressByUserid", address);
		
		session.commit();
		MybatisUtils.close(session);
		return num;
	}

	@Override
	public PageModel<Address> findUserAddress(Integer pageNo, Integer pageSize, Integer userid) {
		// TODO Auto-generated method stub
		PageModel<Address> pageModel=new PageModel<Address>();
		SqlSession session=factory.openSession(false);
		
		int num=session.selectOne("dp.shop.Address.findAddress", userid);
		if(num!=0) {
			int totalCount=num;
			//????????
			int totalpage=totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize+1);
			pageModel.setTotalPage(totalpage);
		}
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("user_id", userid);
		map.put("pageNo", ((pageNo-1)*pageSize));
		map.put("pageSize", pageSize);
		
		List<Address> list=session.selectList("dp.shop.Address.finduserAddress", map);
		
		pageModel.setData(list);
		
		session.commit();
		MybatisUtils.close(session);

		return pageModel;

	}
	//?????????	
	public int findAddress(Integer userid) {

		SqlSession session=factory.openSession(false);
		
		int num=session.selectOne("dp.shop.Address.findAddress", userid);
		return num;
	}
	
	
	@Override
	public Address findAddressByIdAndUser_id(Integer id, Integer user_id) {
		// TODO Auto-generated method stub
		Map<String,Integer> map=new HashMap<String,Integer>();
		SqlSession session=factory.openSession(false);
		
		
		map.put("id", id);
		map.put("user_id", user_id);
		Address address=session.selectOne("dp.shop.Address.findAddressByIdAndUser_id", map);
		return address;
	}
}
