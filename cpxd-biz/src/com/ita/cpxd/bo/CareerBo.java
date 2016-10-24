package com.ita.cpxd.bo;

import com.inet.xportal.nosql.web.bf.MagicContentBF;
import com.inet.xportal.nosql.web.bo.MagicContentBO;
import com.inet.xportal.web.context.ContentContext;
import com.ita.cpxd.model.Career;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by HS on 13/09/2016.
 */
@Named("cpxd_CareerBo")
public class CareerBo extends MagicContentBO<Career> {
    /**
     * Create {@link AccountBo} instance
     *
     * @param contentBf the given {@link MagicContentBF}
     */
    @Inject
    protected CareerBo(@ContentContext(context = "cpxdNoSqlContext") MagicContentBF contentBf) {
        super(contentBf, "career");
    }

    @Override
    protected Class<Career> getClassConvetor() {
        return Career.class;
    }
}
