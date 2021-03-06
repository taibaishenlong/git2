package com.wangchao.day1020.onetx.service.impl;

import com.wangchao.day1020.onetx.bean.Account;
import com.wangchao.day1020.onetx.dao.IAccountDao;
import com.wangchao.day1020.onetx.service.IAccountService;

import java.util.List;

/**
 * 庄户的业务层实现类
 *
 * 事务控制应该都是在业务层
 */
public class AccountServiceImpl  implements IAccountService {
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }

    @Override
    public void transfer(String sourceName, String targetName, float money) {
        System.out.println("...业务层转账操作...");
        //1.根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //3.转出账户减钱
        source.setBalance(source.getBalance() - money);
        //4.转入账户加钱
        target.setBalance(target.getBalance() + money);
        //5.更新转出账户
        accountDao.updateAccount(source);
        //6.更新转入账户
        accountDao.updateAccount(target);
    }
}
