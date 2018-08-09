package com.gpss.supplier.service.mybaits;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SupplierSqlSessionDaoSupport extends SqlSessionDaoSupport {
	   private SqlSession sqlSession;
	   
	    private boolean externalSqlSession;
	    private static final String s= "supplierSqlSessionFactory";
	 
	    @Autowired(required = false)
	    public final void setSqlSessionFactory(@Qualifier(s) SqlSessionFactory sqlSessionFactory) {
	        if (!this.externalSqlSession) {
	            this.sqlSession = new SqlSessionTemplate(sqlSessionFactory);
	        }
	    }
	 
	    @Autowired(required = false)
	    public final void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	        this.sqlSession = sqlSessionTemplate;
	        this.externalSqlSession = true;
	    }
	 
	    /**
	     * Users should use this method to get a SqlSession to call its statement methods
	     * This is SqlSession is managed by spring. Users should not commit/rollback/close it
	     * because it will be automatically done.
	     *
	     * @return Spring managed thread safe SqlSession
	     */
	    public final SqlSession getSqlSession() {
	        return this.sqlSession;
	    }
	 
	    /**
	     * {@inheritDoc}
	     */
	    protected void checkDaoConfig() {
	    	if(this.sqlSession == null ) {
	    		throw new NullPointerException("Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required");
	    	}
	    }
}
