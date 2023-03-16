package com.yanxia.study.service.impl;

import com.yanxia.study.dao.IAccountDao;
import com.yanxia.study.domain.Account;
import com.yanxia.study.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;
    @Override
    public List<Account> findAllAccount() {
        List<Account> accountList = null;
        try{
            accountList = accountDao.findAllAccount();}catch (SQLException e){
            e.printStackTrace();
        }
        return accountList;
    }

    @Override
    public Account findAccountById(String accountId) throws SQLException {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void updateAccount(Account account) throws SQLException {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccountById() {
        accountDao.deleteAccountById();
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
