package org.example.sds.bonds.impl;

import org.example.sds.bonds.BondsRepository;
import org.example.sds.bonds.domain.Bond;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @classname: BondsRepositoryImpl
 * @description:
 * @author: jiadongrui
 * @create: 2021-07-16 11:13
 **/
public class BondsRepositoryImpl implements BondsRepository, InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(BondsRepositoryImpl.class);

    private final Set<Bond> bondSet = new HashSet<>();

    @Override
    public Bond findBondByCode(String bondCode) {
        Iterator<Bond> iterator = bondSet.iterator();
        Bond result = null;
        while(iterator.hasNext()){
            Bond next = iterator.next();
            if(next.getBondCode().equals(bondCode)){
                result = next;
                break;
            }
        }
        LOGGER.info("请求查询债券代码为[{}]的债券，返回结果:[{}]",bondCode,result);
        return result;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        bondSet.add(new Bond("10000","bond-10000"));
        bondSet.add(new Bond("10001","bond-10001"));
        bondSet.add(new Bond("10002","bond-10002"));
        LOGGER.info("初始化Bondset，添加[{}]条债券",bondSet.size());
    }
}
