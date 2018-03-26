package dp.shop.Dao.Imp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dp.shop.Common.DBUtils;
import dp.shop.Dao.Shop_Dao_Interface;
import dp.shop.Entity.Category;
import dp.shop.Entity.PageModel;
import dp.shop.Entity.Product;

public class Shop_Dao_Imp implements Shop_Dao_Interface {
	private static  Shop_Dao_Interface daoDanLi=null;
	public Shop_Dao_Imp() {}
	public synchronized static Shop_Dao_Interface getShopDao() {
		if(daoDanLi==null) {
			return daoDanLi=new Shop_Dao_Imp();
		}
		return daoDanLi;
	}

	@Override
	public List<Category> findAllCategory() {
		//查看商品类别
		List<Category> list=new ArrayList<Category>();
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			
			pst=conn.prepareStatement("select * from category");

			rs=pst.executeQuery();
			
			while(rs.next()) {
	
				Category category=new Category(rs.getInt("id"),rs.getInt("parent_id"),rs.getString("name"),rs.getInt("status"),rs.getInt("sort_order"),rs.getDate("create_time"),rs.getDate("update_time"));
				list.add(category);
				
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
		return list;
	}

	@Override
	public int deleteCategoryById(Integer Id) {
		//根据商品类别编号删除商品类别
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DBUtils.getConnection();
			String sql="delete from category where id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1,Id);
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
	public List<Product> findAllProduct() {
		//查询所有商品
		List<Product> list=new ArrayList<Product>();
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			
			pst=conn.prepareStatement("select * from product");

			rs=pst.executeQuery();
			
			while(rs.next()) {
	
				Product product=new Product(rs.getInt("id"), rs.getInt("category_id"),rs.getString("name") , rs.getString("subtitle"), rs.getString("main_image"), rs.getString("sub_images") ,
						rs.getString("detail") , rs.getBigDecimal("price") , rs.getInt("stock") , rs.getInt("status") , rs.getDate("create_time") , rs.getDate("update_time") );
				list.add(product);
				
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
		return list;
	}

	@Override
	public int deleteProductById(Integer Id) {
		//根据商品编号删除商品类别
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DBUtils.getConnection();
			String sql="delete from product where id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1,Id);
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

	public int addCategory(Category category) {
		//添加商品类别
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DBUtils.getConnection();
			String sql=	"insert into category(parent_id,name,status,sort_order,create_time,update_time)\r\n" + 
								"values \r\n" + 
								"(?,?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			//System.out.println(id);
			pst.setInt(1,category.getParent_id());
			pst.setString(2, category.getName());
			pst.setInt(3, category.getStatus());
			pst.setInt(4, category.getSort_order());
			pst.setDate(5, new Date(category.getCreate_time().getTime()));
			pst.setDate(6, new Date(category.getUpdate_time().getTime())); 
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int addProduct(Product product) {
		//添加商品
		Connection conn=null;
		PreparedStatement pst=null;
		
		try {
			conn=DBUtils.getConnection();
			String sql="insert into product(category_id,name,subtitle,detail,price,stock,status,create_time,update_time)\r\n" + 
								"values \r\n" + 
								"(?,?,?,?,?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			//System.out.println(id);
			pst.setInt(1,product.getCategory_id());
			pst.setString(2, product.getName());
			pst.setString(3, product.getSubtitle());
			pst.setString(4, product.getDetail());
			pst.setBigDecimal(5, product.getPrice());
			pst.setInt(6, product.getStock());
			pst.setInt(7, product.getStatus());
			pst.setDate(8, new Date(product.getCreate_time().getTime()));
			pst.setDate(9, new Date(product.getUpdate_time().getTime()));
			 
			return pst.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Category findCategoryById(Integer id) {
		//根据id查询商品类别
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		Category category=null;
		try {
			conn=DBUtils.getConnection();
			String sql="select id,parent_id,name,status,sort_order,create_time,update_time from category where id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1,id);
			rs=pst.executeQuery();
			if(rs.next()) {
				category=new Category(rs.getInt("id"),rs.getInt("parent_id"),rs.getString("name"),rs.getInt("status"),rs.getInt("sort_order"),rs.getDate("create_time"),rs.getDate("update_time"));
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
		return category;
	}

	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		//修改商品类别
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DBUtils.getConnection();
			String sql="update category set parent_id=?,name=?,status=?,sort_order=?,update_time=? where id=?";
			pst=conn.prepareStatement(sql);
			int id=category.getId();
			//System.out.println(id);
			pst.setInt(1,category.getParent_id());
			pst.setString(2, category.getName());
			pst.setInt(3, category.getStatus());
			pst.setInt(4, category.getSort_order());
			pst.setDate(5, new Date(category.getUpdate_time().getTime())); 
			pst.setInt(6, id);
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Product findProductById(Integer id) {
		//根据id查询商品信息
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		Product product=null;
		try {
			conn=DBUtils.getConnection();
			String sql="select * from product where id=? ";
			pst=conn.prepareStatement(sql);
			pst.setInt(1,id);
			rs=pst.executeQuery();
			if(rs.next()) {
				product=new Product(rs.getInt("id"), rs.getInt("category_id"),rs.getString("name") , rs.getString("subtitle"), rs.getString("main_image"), rs.getString("sub_images") ,
						rs.getString("detail") , rs.getBigDecimal("price") , rs.getInt("stock") , rs.getInt("status") , rs.getDate("create_time") , rs.getDate("update_time") );	
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
		return product;
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		//修改商品
		Connection conn=null;
		PreparedStatement pst=null;
		
		try {
			conn=DBUtils.getConnection();
			String sql="update product set category_id=?,name=?,subtitle=?,detail=?,price=?,stock=?,status=?,update_time=now() where id=?";
			pst=conn.prepareStatement(sql);
			int id=product.getId();
			//System.out.println(id);
			pst.setInt(1,product.getCategory_id());
			pst.setString(2, product.getName());
			pst.setString(3, product.getSubtitle());
			pst.setString(4, product.getDetail());
			pst.setBigDecimal(5, product.getPrice());
			pst.setInt(6, product.getStock());
			pst.setInt(7, product.getStatus());
			pst.setInt(8,id);
			return pst.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("resource")
	@Override
	public PageModel<Product> findProductByPage(int pageNo, int pageSize) {
		// 分页获取数据 
		Connection conn=null;
		PreparedStatement  pst=null;
		ResultSet rs=null;
		PageModel<Product> pageModel=new PageModel<Product>();
		
		try {
			conn=DBUtils.getConnection();
			//查询总记录
			pst=conn.prepareStatement("select count(id) from product");
			rs= pst.executeQuery();
			if(rs.next()) {
				int totalCount=rs.getInt(1);
				//计算多少页
				int totalpage=totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize+1);
				pageModel.setTotalPage(totalpage);
			}
			String sql="select * from product limit ?,? ";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, (pageNo-1)*pageSize);
			pst.setInt(2, pageSize);
			rs=pst.executeQuery();
			List<Product> list= new ArrayList<Product>();
			while (rs.next()) {
				Product product=new Product(rs.getInt("id"), rs.getInt("category_id"),rs.getString("name") , rs.getString("subtitle"), rs.getString("main_image"), rs.getString("sub_images") ,
						rs.getString("detail") , rs.getBigDecimal("price") , rs.getInt("stock") , rs.getInt("status") , rs.getDate("create_time") , rs.getDate("update_time") );
				list.add(product);
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
	@SuppressWarnings("resource")
	@Override
	public PageModel<Category> findCategoryByPage(int pageNo, int pageSize) {
		// 分页获取数据 
		Connection conn=null;
		PreparedStatement  pst=null;
		ResultSet rs=null;
		PageModel<Category> pageModel=new PageModel<Category>();
		
		try {
			conn=DBUtils.getConnection();
			//查询总记录
			pst=conn.prepareStatement("select count(id) from category");
			rs= pst.executeQuery();
			if(rs.next()) {
				int totalCount=rs.getInt(1);
				//计算多少页
				int totalpage=totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize+1);
				pageModel.setTotalPage(totalpage);
			}
			String sql="select * from category limit ?,? ";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, (pageNo-1)*pageSize);
			pst.setInt(2, pageSize);
			rs=pst.executeQuery();
			List<Category> list= new ArrayList<Category>();
			while (rs.next()) {
				Category category=new Category(rs.getInt("id"),rs.getInt("parent_id"),rs.getString("name"),rs.getInt("status"),rs.getInt("sort_order"),rs.getDate("create_time"),rs.getDate("update_time"));
				list.add(category);
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
	@Override
	public Integer findProductQuantity(Integer product_id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		int stock=0;
		try {
			conn=DBUtils.getConnection();
			String sql="select stock from product where id=? ";
			pst=conn.prepareStatement(sql);
			pst.setInt(1,product_id);
			rs=pst.executeQuery();
			if(rs.next()) {
				stock=rs.getInt("stock");
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
		return stock;
	}

}
