package org.example.sds.bonds;

import org.example.sds.bonds.domain.Bond;

/**
 * @description:
 * @author: jiadongrui
 * @create: 2021-07-16 11:12
 **/
public interface BondsRepository {

    Bond findBondByCode(String bondCode);
}
