package com.ita.cpxd.service.process;

import com.inet.xportal.web.WebConstant;
import com.inet.xportal.web.action.AbstractBaseAction;
import com.inet.xportal.web.annotation.XPortalDataService;
import com.inet.xportal.web.annotation.XPortalPageRequest;
import com.inet.xportal.web.exception.WebOSBOException;
import com.inet.xportal.web.interfaces.DataServiceMarker;
import com.inet.xportal.web.interfaces.ObjectWebDataservice;
import com.inet.xportal.web.interfaces.WebDataService;
import com.ita.cpxd.bo.EndBusinessBo;
import com.ita.cpxd.model.EndBusiness;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;


/**
 * Created by HS on 13/09/2016.
 */
@Named("cpxd_endbusiness_saveservice")
@XPortalDataService(roles = {"cpxd.create"}, description = "Tạo hồ sơ")
@XPortalPageRequest(uri = "cpxd/endbusiness/save", result = WebConstant.ACTION_XSTREAM_JSON_RESULT)
public class EndBusinessNewService extends DataServiceMarker {
    @Inject
    private EndBusinessBo endBusinessBo;

    @Override
    protected WebDataService service(AbstractBaseAction action, Map<String, Object> params)
            throws WebOSBOException {
        EndBusiness arbmodel = action.getModel(EndBusiness.class);

        // TODO check your required data

        // save account
        //district.setUuid(districtBo.add(district));
        String uuid= endBusinessBo.add(arbmodel);
        arbmodel.setUuid(uuid);

        return new ObjectWebDataservice<EndBusiness>(arbmodel);
    }

}