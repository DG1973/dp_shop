package dp.shop.Common;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	
	private static SqlSessionFactory sqlSessionFactory=null;
	
	static {
		//1����ȡ�����ļ�
		String config= "MyBatisConfig.xml";
		Reader reader=null;
		try {
			reader=Resources.getResourceAsReader(config);
			
			//2������SqlSessionFactory    ΪSqlSession�Ĺ��������ڽ��������ݿ�ĻỰ��
			 sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ��ȡSqlSessionFactory
	 * */
	public static SqlSessionFactory getSqlSessionFactory() {
		
		return sqlSessionFactory;
	}
	
	/**
	*�ر�����
	**/
	
	//7���ر�SqlSession
	public static void  close(SqlSession sqlSession) {
		sqlSession.close();
		
	}
	
	
}
