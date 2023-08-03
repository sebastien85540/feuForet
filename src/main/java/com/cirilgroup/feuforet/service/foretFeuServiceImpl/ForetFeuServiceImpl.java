package com.cirilgroup.feuforet.service.foretFeuServiceImpl;

import com.cirilgroup.feuforet.model.Foret;
import com.cirilgroup.feuforet.service.ForetFeuService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@Scope("prototype")
public class ForetFeuServiceImpl implements ForetFeuService {


    @Override
    public int simulationFeuForet(Foret foret) {
        return 0;
    }
}