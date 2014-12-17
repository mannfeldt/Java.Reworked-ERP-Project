package controllers;

import mapper.MyBatisConnectionFactory;
import mapper.db_Mapper;

public class ConsultTimeReportController {
	db_Mapper db_mapper = new db_Mapper(MyBatisConnectionFactory.getSqlSessionFactory());



}
