package market;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class ProductDAO {
	
	// 싱글턴 패턴으로
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	int result;
	
	// 제품 등록
	public void insertProduct (ProductDTO pDto) {
		sqlSession = sqlSessionFactory.openSession(true);
		
		try {
			result = sqlSession.insert("pdt.insert", pDto);
			if (result > 0) {
				System.out.println("MSG: 제품 신규 등록 완료");
			} else {
				System.out.println("ERROR: 제품 등록 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
}
