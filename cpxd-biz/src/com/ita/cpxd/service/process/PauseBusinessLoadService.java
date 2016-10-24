
package com.ita.cpxd.service.process;


import com.inet.xportal.nosql.web.data.SearchDTO;
import com.inet.xportal.web.WebConstant;
import com.inet.xportal.web.action.AbstractBaseAction;
import com.inet.xportal.web.annotation.XPortalDataService;
import com.inet.xportal.web.annotation.XPortalPageRequest;
import com.inet.xportal.web.exception.WebOSBOException;
import com.inet.xportal.web.interfaces.DataServiceMarker;
import com.inet.xportal.web.interfaces.ObjectWebDataservice;
import com.inet.xportal.web.interfaces.WebDataService;
import com.ita.cpxd.bo.PauseBusinessBo;
import com.ita.cpxd.model.PauseBusiness;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;


/**
 * Created by HS on 13/09/2016.
 */
@Named("cpxd_pausebusiness_loadservice")
@XPortalDataService(roles = {"cpxd.create"}, description = "Tạo hồ sơ")
@XPortalPageRequest(uri = "cpxd/pausebusiness/load",  result = WebConstant.ACTION_XSTREAM_JSON_RESULT)

public class PauseBusinessLoadService extends DataServiceMarker {
    @Inject
    private PauseBusinessBo pausebusinessBo;

    @Override
    protected WebDataService service(AbstractBaseAction action, Map<String, Object> params)
            throws WebOSBOException {
        //District district = action.getModel(District.class);

        // TODO check your required data

        // save account
        //district.setUuid(districtBo.add(district));
        SearchDTO<PauseBusiness> result= pausebusinessBo.query();


        return new ObjectWebDataservice<SearchDTO<PauseBusiness>>(result);
    }
}
