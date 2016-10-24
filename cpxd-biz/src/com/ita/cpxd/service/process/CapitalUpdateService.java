package com.ita.cpxd.service.process;

import com.inet.xportal.web.WebConstant;
import com.inet.xportal.web.action.AbstractBaseAction;
import com.inet.xportal.web.annotation.XPortalDataService;
import com.inet.xportal.web.annotation.XPortalPageRequest;
import com.inet.xportal.web.exception.WebOSBOException;
import com.inet.xportal.web.interfaces.DataServiceMarker;
import com.inet.xportal.web.interfaces.ObjectWebDataservice;
import com.inet.xportal.web.interfaces.WebDataService;
import com.inet.xportal.web.util.XParamUtils;
import com.ita.cpxd.bo.ChangeBusinessBo;
import com.ita.cpxd.bo.HomeBusinessBo;
import com.ita.cpxd.enums.EnumStatus;
import com.ita.cpxd.model.ChangeBusiness;
import com.ita.cpxd.model.HomeBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;


/**
 * Created by HS on 13/09/2016.
 */
@Named("cpxd_capital_updateservice")
@XPortalDataService(roles = {"cpxd.process"}, description = "Xử lý hồ sơ")
@XPortalPageRequest(uri = "cpxd/capital/update", result = WebConstant.ACTION_XSTREAM_JSON_RESULT)
public class CapitalUpdateService extends DataServiceMarker {
    protected static final Logger logger = LoggerFactory.getLogger(EnumStatusLoadService.class);
    @Inject
    private HomeBusinessBo homeBusinessBo;
    @Inject
    private ChangeBusinessBo changeBusinessBo;
    @Override
    protected WebDataService service(AbstractBaseAction action, Map<String, Object> params)
            throws WebOSBOException {

        //logger.debug("HomeBusiness status {}: ", arbmodel);
        String id = XParamUtils.getString("idHomeBusiness", params, "");
        String statusType = XParamUtils.getString("statusType", params, "");

        if(statusType.equals(EnumStatus.CAP_DOI))
        {
            ChangeBusiness arbmodel = action.getModel(ChangeBusiness.class);
            changeBusinessBo.update(id,arbmodel);
            arbmodel.setUuid(id);
            return new ObjectWebDataservice<ChangeBusiness>(arbmodel);
        }
        else
        {
            HomeBusiness arbmodel = action.getModel(HomeBusiness.class);

            homeBusinessBo.update(id,arbmodel);
            arbmodel.setUuid(id);
            return new ObjectWebDataservice<HomeBusiness>(arbmodel);
        }


    }

}
