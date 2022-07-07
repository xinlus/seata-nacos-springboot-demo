package com.xinlus.init;

import com.xinlus.entity.Account;
import com.xinlus.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Objects;

@Component
public class DataInit {
    @Autowired
    private AccountMapper accountMapper;
    @PostConstruct
    public void init(){
        Account account = accountMapper.selectById(1);
        if (Objects.isNull(account)){
            account = new Account();
            account.setId(1);
            account.setAccountAmount(new BigDecimal(100000));
            accountMapper.insert(account);
        }
    }
}
