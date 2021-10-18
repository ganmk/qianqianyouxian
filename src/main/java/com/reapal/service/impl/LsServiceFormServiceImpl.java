package com.reapal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.reapal.domain.LsServiceForm;
import com.reapal.mapper.LsServiceFormMapper;
import com.reapal.model.PageResult;
import com.reapal.service.ILsServiceFormService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务单 服务实现类
 * </p>
 *
 * @author Auto-generator
 * @since 2021-10-14
 */
@Service
public class LsServiceFormServiceImpl extends ServiceImpl<LsServiceFormMapper, LsServiceForm> implements ILsServiceFormService {
    @Autowired
    LsServiceFormMapper _ServiceFormMapper;

  public PageResult<LsServiceForm> getToPage(IPage<LsServiceForm> page, LambdaQueryWrapper<LsServiceForm> lambda )
  {
      //page.setCurrent(1);
      //page.setSize(5);
      _ServiceFormMapper.selectPage(page,null);
      PageResult<LsServiceForm> pr = new PageResult();
      pr.setPageCount(page.getPages());
      pr.setTotalCount(page.getTotal());
      pr.setPageNo(new Long(page.getCurrent()).intValue());
      pr.setPageSize((int) page.getSize());
      pr.setResults(page.getRecords());
      return pr;

  }
}
