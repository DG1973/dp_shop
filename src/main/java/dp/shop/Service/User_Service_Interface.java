package dp.shop.Service;

import javax.servlet.http.HttpServletRequest;
import dp.shop.Entity.PageModel;
import dp.shop.Entity.User;
import dp.shop.Entity.VO.UserManageVO;

public interface User_Service_Interface {
	
	
	public PageModel<UserManageVO> findAllUser(HttpServletRequest request);
	
	
}
