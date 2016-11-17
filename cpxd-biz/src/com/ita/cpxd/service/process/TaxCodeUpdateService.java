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
import com.ita.cpxd.bo.ChangeBusinessBo;
import com.ita.cpxd.bo.HomeBusinessBo;
import com.ita.cpxd.bo.PersonRepresentBo;
import com.ita.cpxd.enums.EnumStatus;
import com.ita.cpxd.model.BusinessDetail;
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
@Named("ita_taxcodbusiness_updateservice")
@XPortalDataService(roles = {"cpxd.process"}, description = "Tạo hồ sơ")
@XPortalPageRequest(uri = "ita/business/updatetaxcode", result = WebConstant.ACTION_XSTREAM_JSON_RESULT)
public class TaxCodeUpdateService extends DataServiceMarker {
    @Inject
    private BusinessDetailBo businessDetailBo;
    @Inject
    private HomeBusinessBo homeBusinessBo;

    @Override
    protected WebDataService service(AbstractBaseAction action, Map<String, Object> params)
            throws WebOSBOException {
        String taxCode = XParamUtils.getString("taxCode", params, "");
        String ID = XParamUtils.getString("idHomeBusiness", params, "");

        BusinessDetail detail = businessDetailBo.loadBusinessDetailByHomeBusinessID(ID);
        detail.setTaxCode(taxCode);
        businessDetailBo.update(detail.getUuid(), detail);

        HomeBusiness home = homeBusinessBo.load(ID);
        home.setTaxCode(taxCode);
        homeBusinessBo.update(ID,home);

        return new ObjectWebDataservice<HomeBusiness>(home);




    }

}