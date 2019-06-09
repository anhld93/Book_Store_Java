package com.book.dao.impl;

import com.book.dao.RoleDao;
import com.book.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role> implements RoleDao {


}
