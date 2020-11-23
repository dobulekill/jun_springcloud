package org.nr.tour.controller;

import org.nr.tour.common.controller.AbstractCRUDController;
import org.nr.tour.domain.Visa;
import org.nr.tour.repository.VisaRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wujun
 */
@RefreshScope
@Api
@RestController
public class VisaController extends AbstractCRUDController<Visa, String> {

    @Autowired
    VisaRepository visaRepository;

    @Override
    protected JpaRepository<Visa, String> getRepository() {
        return visaRepository;
    }
}
