package com.ita.cpxd.bo;

import javax.inject.Inject;
import javax.inject.Named;


import com.inet.xportal.nosql.web.bf.MagicContentBF;
import com.inet.xportal.nosql.web.bo.MagicContentBO;
import com.inet.xportal.web.context.ContentContext;
import com.inet.xportal.web.exception.WebOSBOException;
import com.ita.cpxd.model.PauseBusiness;


/**
 * Created by LamLe on 9/7/2016.
 */
@Named("cpxd_PauseBusinessBo")
public class PauseBusinessBo extends MagicContentBO<PauseBusiness> {

    /**
     * Create {@link AccountBo} instance
     *
     * @param contentBf the given {@link MagicContentBF}
     */
    @Inject
    protected PauseBusinessBo(@ContentContext(context = "cpxdNoSqlContext") MagicContentBF contentBf) {
        super(contentBf, "pauseBusiness");
    }
    public PauseBusiness addPauseBusiness(PauseBusiness objPauseBusiness) throws WebOSBOException
    {
        String uuid= super.add(objPauseBusiness);
        objPauseBusiness.setUuid(uuid);
        return objPauseBusiness;
    }
    public PauseBusiness loadByID(String pauseBusinessID) throws WebOSBOException
    {
        PauseBusiness objChange = super.load(pauseBusinessID);
        return objChange;
    }
    @Override
    protected Class<PauseBusiness> getClassConvetor() {
        return PauseBusiness.class;
    }
}
