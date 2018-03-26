package dp.shop.Service.Imp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dp.shop.Dao.Userlogin_Dao_Interface;
import dp.shop.Dao.Imp.UserLoginMyBatis_Dao_Impl;
import dp.shop.Entity.PageModel;
import dp.shop.Entity.User;
import dp.shop.Entity.VO.UserManageVO;
import dp.shop.Service.User_Service_Interface;

public class User_Service_Impl implements User_Service_Interface {

	Userlogin_Dao_Interface user_dao=new UserLoginMyBatis_Dao_Impl();
	@Override
	public PageModel<UserManageVO> findAllUser(HttpServletRequest request) {
		String _pageNo=request.getParameter("pageNo");
		//String _pageSize=request.getParameter("pageSize");
		
		Integer pageNo=0;
		//Integer pageSize=0;
		
		try {
		pageNo= Integer.parseInt(_pageNo);
		//pageSize=Integer.parseInt(_pageSize);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		PageModel<User> pageModel=user_dao.findAllUser(pageNo, 2);
		PageModel<UserManageVO> pageModelVO=new 	PageModel<UserManageVO>();
		
		pageModelVO.setTotalPage(pageModel.getTotalPage());
		if(pageModel.getData()!=null) {
			pageModelVO.setData(this.UserIntoUserManage(pageModel.getData()));
		}
		return pageModelVO;
		
	}
	
	public List<UserManageVO> UserIntoUserManage(List<User> user){
		List<UserManageVO> list=new ArrayList<UserManageVO>();
		for(User u:user) {
			UserManageVO vo=new UserManageVO();
			vo.UserIntoUserManageVO(u);
			list.add(vo);
		}	
		return list;

	}

}
