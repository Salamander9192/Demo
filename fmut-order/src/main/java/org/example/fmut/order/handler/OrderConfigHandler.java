package org.example.fmut.order.handler;

import org.example.sds.bonds.BondsRepository;
import org.example.sds.bonds.domain.Bond;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @classname: OrderConfigHandler
 * @description:
 * @author: jiadongrui
 * @create: 2021-07-07 17:24
 **/
@RestController
public class OrderConfigHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConfigHandler.class);

    @Value("${order1.name}")
    private String orderName;

    @Autowired
    private BondsRepository sdsBondsRepository;

    @PostConstruct
    public void init(){
        LOGGER.info("test config : orderName=[{}]",orderName);
    }

    @GetMapping(value = "/findBond.action")
    public Bond findByCode(String bondCode){
        return sdsBondsRepository.findBondByCode(bondCode);
    }

}
