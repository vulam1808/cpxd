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
import com.ita.cpxd.bo.*;
import com.ita.cpxd.bo.BusinessDetailBo;
import com.ita.cpxd.enums.EnumProcess;
import com.ita.cpxd.model.*;
import com.ita.cpxd.model.BusinessDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;


/**
 * Created by HS on 13/09/2016.
 */
@Named("cpxd_business_updatestatusprocessservice")
@XPortalDataService(roles = {"cpxd.process"}, description = "Xử lý hồ sơ")
@XPortalPageRequest(uri = "cpxd/businessprocess/updatestatus", result = WebConstant.ACTION_XSTREAM_JSON_RESULT)
public class BusinessUpdateStatusProcessService extends DataServiceMarker {
    protected static final Logger logger = LoggerFactory.getLogger(EnumStatusLoadService.class);

    @Inject
    private BusinessDetailBo businessDetailBo;

    @Override
    protected WebDataService service(AbstractBaseAction action, Map<String, Object> params)
            throws WebOSBOException {

        String idHomeBusiness = XParamUtils.getString("idHomeBusiness", params, "");
        String parent_ID = XParamUtils.getString("parent_ID", params, "");
        String status = XParamUtils.getString("statusProcess", params, "");
        String statusType = XParamUtils.getString("statusType", params, "");
        if(idHomeBusiness.equals(parent_ID))
        {
            parent_ID="";
        }
        if(status.equals(EnumProcess.PROCESS.toString()))
        {
            status = EnumProcess.PROCESS_TAX.toString();
        }
        else if(status.equals(EnumProcess.PROCESS_TAX.toString()))
        {
            status = EnumProcess.PROCESS_ID.toString();
        }
        else if(status.equals(EnumProcess.PROCESS_TAX.toString()))
        {
            status = EnumProcess.DONE.toString();
        }
        BusinessDetail obj =businessDetailBo.updateStatusProcess(statusType,status, idHomeBusiness, parent_ID);

        return new ObjectWebDataservice<BusinessDetail>(obj);
    }

}
