package com.reapal.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.reapal.model.PageParam;
import com.reapal.model.PageResult;
import com.reapal.model.Response;
import com.reapal.service.impl.LsServiceFormServiceImpl;
import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.util.CollectionUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.reapal.service.ILsServiceFormService;
import com.reapal.domain.LsServiceForm;

import java.io.IOException;
import java.util.*;
import lombok.Data;


/**
 * <p>
 * 服务单 前端控制器
 * </p>
 *
 * @author Auto-generator
 * @since 2021-10-14
 */

@RestController
@RequestMapping("/ls-service-form")
public class LsServiceFormController {

    
    @Autowired
    private ILsServiceFormService iLsServiceFormService;

    @Autowired
    private  LsServiceFormServiceImpl lsServiceFormService;

    
    /**
    * 通过id查询
    */
    @GetMapping("/get-by-id/{id}")
    public Response getById(@PathVariable(value = "id") Integer id){
        return Response.success(iLsServiceFormService.getById(id));
    }

    /**
    * 新增
    */
    @PostMapping("/save")
    public Response save(@RequestBody LsServiceForm lsServiceForm){
        iLsServiceFormService.save(lsServiceForm);
        return Response.success();
    }

    /**
    * 通过id删除
    */
    @DeleteMapping("/delete-by-id/{id}")
    public Response delete(@PathVariable(value = "id") String ids){
        String[] idsStrs = ids.split(",");
        for (String id:idsStrs){
            iLsServiceFormService.removeById(Integer.parseInt(id));
        }
        return Response.success();
    }

    /**
    * 修改
    */
    @PutMapping("/update")
    public Response updateById(@RequestBody LsServiceForm lsServiceForm){
        iLsServiceFormService.updateById(lsServiceForm);
        return Response.success();
    }


    /**
    * 查询列表
    */
    @PostMapping("/list")
    public Response list(@RequestBody LsServiceFormReqVo lsServiceForm ){
    final LambdaQueryWrapper<LsServiceForm> lambda = new QueryWrapper<LsServiceForm>().lambda();
        this.buildCondition(lambda,lsServiceForm);
        return Response.success(iLsServiceFormService.list(lambda));
    }

    /**
    * 分页查询
    */
    @PostMapping("/page")
    public Response page(@RequestBody PageParam<LsServiceFormReqVo> pageParam){
        final LsServiceFormReqVo param = pageParam.getParam();
        final LambdaQueryWrapper<LsServiceForm> lambda = new QueryWrapper<LsServiceForm>().lambda();
        this.buildCondition(lambda,param);
        //final IPage<LsServiceForm> page = iLsServiceFormService.page(new Page<LsServiceForm>(pageParam.getPageNo(), pageParam.getPageSize()), lambda);
        IPage<LsServiceForm> page = new Page<LsServiceForm>(pageParam.getPageNo(), pageParam.getPageSize());
        PageResult<LsServiceForm> pr = lsServiceFormService.getToPage(page,lambda);

      /*  PageResult<LsServiceForm> pr = new PageResult();
        pr.setPageCount(page.getPages());
        pr.setTotalCount(page.getTotal());
        pr.setPageNo(new Long(page.getCurrent()).intValue());
        pr.setPageSize((int) page.getSize());
        pr.setResults(page.getRecords());*/
        return Response.success(pr);
    }


        /**
        * 构造查询条件
        * @param lambda
        * @param param
        */
        private void buildCondition(LambdaQueryWrapper<LsServiceForm> lambda, LsServiceFormReqVo param){
            if(!StringUtils.isEmpty(param.getId())){
                lambda.eq(LsServiceForm::getId, param.getId());
            }
            if(!StringUtils.isEmpty(param.getUserId())){
                lambda.eq(LsServiceForm::getUserId, param.getUserId());
            }
            if(!StringUtils.isEmpty(param.getServiceOrderId())){
                lambda.eq(LsServiceForm::getServiceOrderId, param.getServiceOrderId());
            }
            if(!StringUtils.isEmpty(param.getCompanyName())){
                lambda.eq(LsServiceForm::getCompanyName, param.getCompanyName());
            }
            if(!StringUtils.isEmpty(param.getCompanyPhone())){
                lambda.eq(LsServiceForm::getCompanyPhone, param.getCompanyPhone());
            }
            if(!CollectionUtils.isEmpty(param.getHandleDateList())){
                lambda.ge(LsServiceForm::getHandleDate, param.getHandleDateList().get(0));
                lambda.le(LsServiceForm::getHandleDate, param.getHandleDateList().get(1));
            }
            if(!StringUtils.isEmpty(param.getEngineer())){
                lambda.eq(LsServiceForm::getEngineer, param.getEngineer());
            }
            if(!StringUtils.isEmpty(param.getCustomerName())){
                lambda.eq(LsServiceForm::getCustomerName, param.getCustomerName());
            }
            if(!StringUtils.isEmpty(param.getLinkman())){
                lambda.eq(LsServiceForm::getLinkman, param.getLinkman());
            }
            if(!StringUtils.isEmpty(param.getServiceType())){
                lambda.eq(LsServiceForm::getServiceType, param.getServiceType());
            }
            if(!StringUtils.isEmpty(param.getServiceMode())){
                lambda.eq(LsServiceForm::getServiceMode, param.getServiceMode());
            }
            if(!StringUtils.isEmpty(param.getBrandSpecs())){
                lambda.eq(LsServiceForm::getBrandSpecs, param.getBrandSpecs());
            }
            if(!StringUtils.isEmpty(param.getSerialNumber())){
                lambda.eq(LsServiceForm::getSerialNumber, param.getSerialNumber());
            }
            if(!StringUtils.isEmpty(param.getCount())){
                lambda.eq(LsServiceForm::getCount, param.getCount());
            }
            if(!StringUtils.isEmpty(param.getFaultDescribe())){
                lambda.eq(LsServiceForm::getFaultDescribe, param.getFaultDescribe());
            }
            if(!CollectionUtils.isEmpty(param.getVistDateList())){
                lambda.ge(LsServiceForm::getVistDate, param.getVistDateList().get(0));
                lambda.le(LsServiceForm::getVistDate, param.getVistDateList().get(1));
            }
            if(!CollectionUtils.isEmpty(param.getCompletDateList())){
                lambda.ge(LsServiceForm::getCompletDate, param.getCompletDateList().get(0));
                lambda.le(LsServiceForm::getCompletDate, param.getCompletDateList().get(1));
            }
            if(!StringUtils.isEmpty(param.getRepairResult())){
                lambda.eq(LsServiceForm::getRepairResult, param.getRepairResult());
            }
            if(!StringUtils.isEmpty(param.getServiceQuality())){
                lambda.eq(LsServiceForm::getServiceQuality, param.getServiceQuality());
            }
            if(!StringUtils.isEmpty(param.getCustomerAdvise())){
                lambda.eq(LsServiceForm::getCustomerAdvise, param.getCustomerAdvise());
            }
            if(!StringUtils.isEmpty(param.getCustomerSignImage())){
                lambda.eq(LsServiceForm::getCustomerSignImage, param.getCustomerSignImage());
            }
            if(!StringUtils.isEmpty(param.getCreaterId())){
                lambda.eq(LsServiceForm::getCreaterId, param.getCreaterId());
            }
            if(!StringUtils.isEmpty(param.getCreaterName())){
                lambda.eq(LsServiceForm::getCreaterName, param.getCreaterName());
            }
            if(!CollectionUtils.isEmpty(param.getCreateDateList())){
                lambda.ge(LsServiceForm::getCreateDate, param.getCreateDateList().get(0));
                lambda.le(LsServiceForm::getCreateDate, param.getCreateDateList().get(1));
            }
            if(!StringUtils.isEmpty(param.getUpdaterId())){
                lambda.eq(LsServiceForm::getUpdaterId, param.getUpdaterId());
            }
            if(!StringUtils.isEmpty(param.getUpdaterName())){
                lambda.eq(LsServiceForm::getUpdaterName, param.getUpdaterName());
            }
            if(!CollectionUtils.isEmpty(param.getUpdateDateList())){
                lambda.ge(LsServiceForm::getUpdateDate, param.getUpdateDateList().get(0));
                lambda.le(LsServiceForm::getUpdateDate, param.getUpdateDateList().get(1));
            }
            if(!StringUtils.isEmpty(param.getIsDeleted())){
                lambda.eq(LsServiceForm::getIsDeleted, param.getIsDeleted());
            }
            lambda.orderBy(true,false, LsServiceForm::getId);
        }


        /**
         * 请求model
         */
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        private static class LsServiceFormReqVo extends LsServiceForm {
            private List<String> handleDateList; // 受理时间起止
            private List<String> vistDateList; // 上门时间起止
            private List<String> completDateList; // 完成时间起止
            private List<String> createDateList; // 创建时间起止
            private List<String> updateDateList; // 更新时间起止
        }


}
