package dp.shop.Entity;
import java.util.List;

/**
 * 分页模型
 * */
public class PageModel<T>{
	/**
	 * 
	 */
	//每一页数据集合
	private  List<T> data;
	//总共有多少页
	private  int  totalPage;
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}	
}
