/*****************************************************************
 Copyright 2015 by Duyen Tang (tttduyen@inetcloud.vn)

 Licensed under the iNet Solutions Corp.,;
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.inetcloud.vn/licenses

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 *****************************************************************/
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
import com.ita.cpxd.bo.ListCareerBo;
import com.ita.cpxd.enums.EnumStatus;
import com.ita.cpxd.model.ListCareer;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

/**
 * SaveService.
 *
 * @author Duyen Tang
 * @version $Id: SaveService.java 2015-04-20 11:09:38z tttduyen $
 *
 * @since 1.0
 */
@Named("ita_listcareer_saveservice")
@XPortalDataService(roles = {"cpxd.master"}, description = "Danh Mục")

@XPortalPageRequest(uri = "ita/listcareer/save", result = WebConstant.ACTION_XSTREAM_JSON_RESULT)

public class ListCareerSaveService extends DataServiceMarker {
    @Inject
    private ListCareerBo listCareerBo;

    @Override
    protected WebDataService service(AbstractBaseAction action, Map<String, Object> params)
            throws WebOSBOException {
        ListCareer arbmodel = action.getModel(ListCareer.class);

        // TODO check your required data

        // save account
        //district.setUuid(districtBo.add(district));


        //String idHomeBusiness = XParamUtils.getString("idHomeBusiness", params, "");
        String statusType = XParamUtils.getString("statusType", params, "");

        // TODO check your required data
        if (statusType.equals(EnumStatus.CAP_DOI.toString()))
        {
            //arbmodel.setChangeBusiness_ID(idHomeBusiness);
            // save account
            //district.setUuid(districtBo.add(district));
            String uuid = listCareerBo.add(arbmodel);
            arbmodel.setUuid(uuid);
        }
        else
        {
            //arbmodel.setHomeBusiness_ID(idHomeBusiness);
            // save account
            //district.setUuid(districtBo.add(district));
            String uuid = listCareerBo.add(arbmodel);
            arbmodel.setUuid(uuid);
        }

        return new ObjectWebDataservice<ListCareer>(arbmodel);
    }

}
