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
import com.ita.cpxd.bo.PersonRepresentBo;
import com.ita.cpxd.model.ChangeBusiness;
import com.ita.cpxd.model.HomeBusiness;
import com.ita.cpxd.model.PersonRepresent;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by HS on 13/09/2016.
 */
@Named("ita_changebusiness_saveservice")
@XPortalDataService(roles = {"cpxd.create"}, description = "Tạo hồ sơ")
@XPortalPageRequest(uri = "ita/changebusiness/save", result = WebConstant.ACTION_XSTREAM_JSON_RESULT)
public class ChangeBusinessNewService extends DataServiceMarker {
    @Inject
    private ChangeBusinessBo changeBusinessBo;

    @Override
    protected WebDataService service(AbstractBaseAction action, Map<String, Object> params)
            throws WebOSBOException {
        ChangeBusiness arbmodel = action.getModel(ChangeBusiness.class);
        String strInfoChange = XParamUtils.getString("infoChange", params, "");
        String[] parts = strInfoChange.split(",");
        List<String> lstInfoChange = new ArrayList<String>();
        for (int i = 0; i <= parts.length-1; i++){
            lstInfoChange.add(parts[i]);
        }
        arbmodel.setInfoChange(lstInfoChange);
        // TODO check your required data

        // save account
        //district.setUuid(districtBo.add(district));
        String uuid= changeBusinessBo.add(arbmodel);
        arbmodel.setUuid(uuid);

        return new ObjectWebDataservice<ChangeBusiness>(arbmodel);
    }

}