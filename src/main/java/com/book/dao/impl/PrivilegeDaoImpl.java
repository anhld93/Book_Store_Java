package com.book.dao.impl;

import com.book.dao.GenericDao;
import com.book.dao.PrivilegeDao;
import com.book.model.Privilege;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PrivilegeDaoImpl extends GenericDaoImpl<Privilege> implements PrivilegeDao {

}
