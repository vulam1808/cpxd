
package com.ita.cpxd.service.master;

import javax.inject.Inject;


import javax.inject.Named;
import java.util.Map;
import com.inet.xportal.web.WebConstant;
import com.inet.xportal.web.action.AbstractBaseAction;
import com.inet.xportal.web.annotation.XPortalDataService;
import com.inet.xportal.web.annotation.XPortalPageRequest;
import com.inet.xportal.web.exception.WebOSBOException;
import com.inet.xportal.web.interfaces.DataServiceMarker;
import com.inet.xportal.web.interfaces.ObjectWebDataservice;
import com.inet.xportal.web.interfaces.WebDataService;
import com.ita.cpxd.bo.AreaBusinessBo;
import com.ita.cpxd.model.AreaBusiness;


/**
 * Created by HS on 13/09/2016.
 */
@Named("cpxd_areabusiness_saveservice")

@XPortalDataService(roles = {"cpxd.master"}, description = "Danh Mục")
@XPortalPageRequest(uri = "cpxd/areabusiness/save", result = WebConstant.ACTION_XSTREAM_JSON_RESULT)
public class AreaBusinessSaveService extends DataServiceMarker{

    @Inject
    private AreaBusinessBo areabusinessBo;

    @Override
    protected WebDataService service(AbstractBaseAction action, Map<String, Object> params)
            throws WebOSBOException {
        AreaBusiness arbmodel = action.getModel(AreaBusiness.class);

        // TODO check your required data

        // save account
        //district.setUuid(districtBo.add(district));

        String uuid= areabusinessBo.add(arbmodel);
        arbmodel.setUuid(uuid);

        return new ObjectWebDataservice<AreaBusiness>(arbmodel);
    }

}
