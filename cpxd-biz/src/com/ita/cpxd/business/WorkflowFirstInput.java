package com.ita.cpxd.business;

import com.inet.workflow.web.model.TaskModel;
import com.inet.workflow.web.node.AbstractBusiness;
import com.inet.xportal.itask.bo.TaskHistoryBO;
import com.inet.xportal.itask.bo.TaskRequestBO;
import com.inet.xportal.itask.model.TaskRequest;
import com.ita.cpxd.bo.CareerBo;
import net.sf.json.JSON;
import net.sf.json.util.JSONUtils;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by ACER on 10/26/2016.
 */
@Named("cpxdWorkflowFirstInputBusiness")
public class WorkflowFirstInput extends AbstractBusiness {
@Inject
private TaskRequestBO requestBO;

    @Inject
    private TaskHistoryBO historyBO;

    @Inject
    private CareerBo careerBo;


    @Override
    public void beforeVariableUpdate(TaskModel taskModel, boolean backtract) {
      /*  historyBO. taskModel.getUuid()

        TaskRequest request = requestBO.load("id");
        request.getRequestData().get();
        JSONUtils
        careerBo.add()*/
    }

    @Override
    public void afterVariableUpdate(TaskModel taskModel, boolean backtract) {

    }
}
