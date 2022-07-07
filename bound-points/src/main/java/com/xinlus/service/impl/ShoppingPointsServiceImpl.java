package com.xinlus.service.impl;

import com.xinlus.dto.OrderInfoDTO;
import com.xinlus.entity.ShoppingPoints;
import com.xinlus.mapper.AccountMapper;
import com.xinlus.mapper.ShoppingPointsMapper;
import com.xinlus.service.ShoppingPointsService;
import com.xinlus.vo.Result;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xinlus@126.com
 * @since 2022-07-06
 */
@Service
public class ShoppingPointsServiceImpl implements ShoppingPointsService {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private ShoppingPointsMapper shoppingPointsMapper;

    @GlobalTransactional
    @Override
    public Result<Integer> boundPoints(OrderInfoDTO orderInfoDTO) {
        accountMapper.updateAccountAmountById(orderInfoDTO.getAmount(),1);
        ShoppingPoints shoppingPoints = new ShoppingPoints();
        shoppingPoints.setBonusPoints(orderInfoDTO.getAmount().intValue()*10);
        shoppingPoints.setOrderNo(orderInfoDTO.getOrderNo());
        int result = shoppingPointsMapper.insertSelective(shoppingPoints);
        if (orderInfoDTO.getEnableError()){
            int error = 1/0;
        }
        return Result.success(result);
    }
}
