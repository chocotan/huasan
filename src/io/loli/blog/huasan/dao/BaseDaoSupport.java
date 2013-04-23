package io.loli.blog.huasan.dao;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

public abstract class BaseDaoSupport extends NamedParameterJdbcDaoSupport{
	 @Resource
	 private DataSource dataSource;
	 @PostConstruct
	 private void init() {
	     setDataSource(dataSource);
	 }
}
