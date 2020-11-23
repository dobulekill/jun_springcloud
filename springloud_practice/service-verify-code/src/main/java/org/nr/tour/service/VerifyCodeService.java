package org.nr.tour.service;

/**
 * @author Wujun
 */
public interface VerifyCodeService {

    String newOne(String owner, Integer type, Integer expireMills);

    Boolean verify(String owner, String code, Integer type);
}
