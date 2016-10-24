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
import com.ita.cpxd.bo.HomeBusinessBo;
import com.ita.cpxd.model.HomeBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;


/**
 * Created by HS on 13/09/2016.
 */
@Named("cpxd_homebusiness_updateservice")
@XPortalDataService(roles = {"cpxd.create"}, description = "Tạo hồ sơ")
@XPortalPageRequest(uri = "cpxd/homebusiness/update", result = WebConstant.ACTION_XSTREAM_JSON_RESULT)
public class HomeBusinessUpdateService extends DataServiceMarker {
    protected static final Logger logger = LoggerFactory.getLogger(EnumStatusLoadService.class);
    @Inject
    private HomeBusinessBo homeBusinessBo;

    @Override
    protected WebDataService service(AbstractBaseAction action, Map<String, Object> params)
            throws WebOSBOException {
        HomeBusiness arbmodel = action.getModel(HomeBusiness.class);
        //logger.debug("HomeBusiness status {}: ", arbmodel);
        String id = XParamUtils.getString("idHomeBusiness", params, "");
        String taskID = XParamUtils.getString("taskID", params, "");
        if(!taskID.equals(""))
        {
            HomeBusiness objHome = homeBusinessBo.updateHomeBusiness(id,arbmodel);
            id = objHome.getUuid();
        }
        // TODO check your required data

        // save account
        //district.setUuid(districtBo.add(district));
        homeBusinessBo.update(id,arbmodel);
        arbmodel.setUuid(id);

        return new ObjectWebDataservice<HomeBusiness>(arbmodel);
    }

}
