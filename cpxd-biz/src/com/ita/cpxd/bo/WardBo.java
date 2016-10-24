package com.ita.cpxd.bo;

import com.inet.xportal.nosql.web.bf.MagicContentBF;
import com.inet.xportal.nosql.web.bo.MagicContentBO;
import com.inet.xportal.web.context.ContentContext;

import com.ita.cpxd.model.Ward;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by ACER on 9/7/2016.
 */
@Named("cpxd_WardBo")
public class WardBo extends MagicContentBO<Ward> {

    /**
     * Create {@link AccountBo} instance
     *
     * @param contentBf the given {@link MagicContentBF}
     */
    @Inject
    protected WardBo(@ContentContext(context = "cpxdNoSqlContext") MagicContentBF contentBf) {
        super(contentBf, "ward");
    }

    @Override
    protected Class<Ward> getClassConvetor() {
        return Ward.class;
    }
}
