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
import com.ita.cpxd.bo.BusinessDetailBo;
import com.ita.cpxd.model.BusinessDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;


/**
 * Created by HS on 13/09/2016.
 */
@Named("cpxd_business_checknameservice")
@XPortalDataService(roles = {"cpxd.create"}, description = "Tạo hồ sơ")
@XPortalPageRequest(uri = "cpxd/homebusiness/checknamebusiness", result = WebConstant.ACTION_XSTREAM_JSON_RESULT)
public class BusinessCheckNameService extends DataServiceMarker {
    protected static final Logger logger = LoggerFactory.getLogger(BusinessCheckNameService.class);
    @Inject
    private BusinessDetailBo businessDetailBo;

    @Override
    protected WebDataService service(AbstractBaseAction action, Map<String, Object> params)
            throws WebOSBOException {
        //HomeBusiness arbmodel = action.getModel(HomeBusiness.class);
        String name = XParamUtils.getString("nameBusiness", params, "");
        // TODO check your required data
        logger.debug("nameBusiness {}", name);
        BusinessDetail detail = businessDetailBo.checkName(name);
        //datas.getItems();
        //String uuid= homeBusinessBo.add(arbmodel);
        //arbmodel.setUuid(uuid);

        return new ObjectWebDataservice<BusinessDetail>(detail);
    }

}
