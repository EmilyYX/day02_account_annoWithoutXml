package com.yanxia.study.dao.impl;

import com.yanxia.study.dao.IAccountDao;
import com.yanxia.study.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner runner;
    @Override
    public List<Account> findAllAccount() throws SQLException {
        return runner.query("select * from account;", new BeanListHandler<Account>(Account.class));
    }

    @Override
    public Account findAccountById(String accountId) throws SQLException {
        return runner.query("select * from account where id = ?;", new BeanHandler<Account>(Account.class),accountId);
    }

    @Override
    public void updateAccount(Account account) throws SQLException {
        runner.update("update account set money = ? where id=?", account.getMoney(), account.getId());
    }

    @Override
    public void deleteAccountById() {

    }

    @Override
    public void saveAccount(Account account) {

    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }
}
