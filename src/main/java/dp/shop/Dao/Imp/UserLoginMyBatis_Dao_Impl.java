package dp.shop.Dao.Imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dp.shop.Common.MybatisUtils;
import dp.shop.Dao.Userlogin_Dao_Interface;
import dp.shop.Entity.Cart;
import dp.shop.Entity.PageModel;
import dp.shop.Entity.User;

public class UserLoginMyBatis_Dao_Impl implements Userlogin_Dao_Interface {

	@Override
	public int checkUserName(String username) {
		// TODO Auto-generated method stub
		SqlSessionFactory  factory=MybatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(false);
		Integer num=null;
		num=session.selectOne("dp.shop.UserLogin.checkUserName",username);
		if(num==1) {
			return 1;
		}else {
			return 0;
		}

	}

	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub		
		
		SqlSessionFactory  factory=MybatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(false);
		
		Map<String,String> map=new HashMap<String,String>();
		map.put("username", username);
		map.put("password", password);
		User user=session.selectOne("dp.shop.UserLogin.findUserByUsernameAndPassword",map);
		
		MybatisUtils.close(session);
		return user;
	}

	@Override
	public int updateTokenByUserId(Integer userid, String token) {
		// TODO Auto-generated method stub
		SqlSessionFactory  factory=MybatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userid", userid);
		map.put("token", token);
		int num=session.update("dp.shop.UserLogin.updateTokenByUserId",map);
		
		MybatisUtils.close(session);

		return num;
	}

	@Override
	public User findUserByToken(String token) {
		// TODO Auto-generated method stub
		SqlSessionFactory  factory=MybatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(false);
		
		User user=session.selectOne("dp.shop.UserLogin.findUserByToken",token);
		
		MybatisUtils.close(session);
		return user;
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		SqlSessionFactory  factory=MybatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		
		int num=session.insert("dp.shop.UserLogin.addUser", user);
		return num;
	}
	@Override
	public int findAllUserCount() {
		SqlSessionFactory  factory=MybatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(false);
		int num=0;
		num=session.selectOne("dp.shop.UserLogin.findAllUserCount");	
		//session.selectOne("dp.shop.UserLogin.findAllUserCount");
		return num;	
	}
	@Override
	public PageModel<User> findAllUser(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		PageModel<User> pageModel=new PageModel<User>();
		SqlSessionFactory  factory=MybatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(false);
		int num=session.selectOne("dp.shop.UserLogin.findAllUserCount");
		if(num!=0) {
			int totalCount=num;
			//º∆À„∂‡…Ÿ“≥
			int totalpage=totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize+1);
			pageModel.setTotalPage(totalpage);
		}
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("pageNo", ((pageNo-1)*pageSize));
		map.put("pageSize", pageSize);
		
		List<User> list=session.selectList("dp.shop.UserLogin.findAllUser", map);
		
		pageModel.setData(list);
		
		session.commit();
		MybatisUtils.close(session);

		return pageModel;
	}

}
