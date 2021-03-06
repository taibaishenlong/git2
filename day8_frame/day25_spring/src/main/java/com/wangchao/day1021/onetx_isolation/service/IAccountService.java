package com.wangchao.day1021.onetx_isolation.service;

import com.wangchao.day1021.onetx_isolation.bean.Account;

//账户转账业务层接口
public interface IAccountService {
    //根据id查询账户信息
    Account findAccountById(Integer id);
    //转账操作
    void transfer(String sourceName,String targetName,Float money);
}
