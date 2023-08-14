package cn.yiqu.app.dynamic.service.impl;

import cn.ifloat.brick.basic.common.results.PageRequester;
import cn.ifloat.brick.basic.common.results.PageRequesterFormCondition;
import cn.ifloat.brick.basic.common.results.PageResult;
import cn.ifloat.brick.sprofile.mybatis.common.BasicServiceImpl;
import cn.ifloat.brick.sprofile.mybatis.tools.FormConditionKit;
import cn.yiqu.app.dynamic.domain.DynamicFormHistory;
import cn.yiqu.app.dynamic.domain.vo.DynamicFormHistoryVo;
import cn.yiqu.app.dynamic.mappers.DynamicFormHistoryMapper;
import cn.yiqu.app.dynamic.service.DynamicFormHistoryService;
import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DynamicFormHistoryServiceImpl extends BasicServiceImpl<DynamicFormHistoryMapper, DynamicFormHistory> implements DynamicFormHistoryService {

    @Override
    public Wrapper<DynamicFormHistoryVo> builderByVo(DynamicFormHistoryVo vo) {
        LambdaQueryWrapper<DynamicFormHistoryVo> wrapper = Wrappers.<DynamicFormHistoryVo>lambdaQuery();
        return wrapper;
    }

    @Override
    public Wrapper<DynamicFormHistory> builder(DynamicFormHistory bean) {
        LambdaQueryWrapper<DynamicFormHistory> wrapper = Wrappers.<DynamicFormHistory>lambdaQuery();
        return wrapper;
    }

    @Override
    public DynamicFormHistoryVo selById(Long id) {
        LambdaQueryWrapper<DynamicFormHistoryVo> wrapper = Wrappers.<DynamicFormHistoryVo>lambdaQuery().eq(DynamicFormHistoryVo::getId, id);
        List<DynamicFormHistoryVo> dynamicFormHistoryVoList = this.getBaseMapper().listVo(wrapper);
        if (CollectionUtils.isNotEmpty(dynamicFormHistoryVoList)) {
            DynamicFormHistoryVo dynamicFormHistoryVo = dynamicFormHistoryVoList.get(0);
            return dynamicFormHistoryVo;
        }
        return null;
    }

    @Override
    public List<DynamicFormHistoryVo> listVo(DynamicFormHistoryVo condition) {
        Wrapper<DynamicFormHistoryVo> wrapper = builderByVo(condition);
        return this.getBaseMapper().listVo(wrapper);
    }

    @Override
    public PageResult<DynamicFormHistoryVo> pagerVo(PageRequester<DynamicFormHistoryVo> requester) {
        Wrapper<DynamicFormHistoryVo> wrapper = builderByVo(requester.getCondition());
        IPage<DynamicFormHistoryVo> page = this.getBaseMapper().pagerVo(Page.of(requester.getCurrent(), requester.getSize()), wrapper);
        return new PageResult<DynamicFormHistoryVo>(page.getRecords(), page.getTotal(), page.getPages(), page.getCurrent(), page.getSize());
    }

    @Override
    public DynamicFormHistory saver(DynamicFormHistory bean) {
        bean.setId(this.sequenceId());
        this.save(bean);
        return bean;
    }

    @Override
    public boolean saverOrUpdater(DynamicFormHistory bean) {
        if (bean.getId() == null) {
            this.saver(bean);
        } else {
            return this.updateById(bean);
        }
        return true;
    }

    @Override
    public PageResult<DynamicFormHistoryVo> pagerVo(Class<DynamicFormHistory> bEmployeeVoClass, PageRequesterFormCondition<DynamicFormHistory> requester) {
        AbstractWrapper wrapper = FormConditionKit.<DynamicFormHistory>builderWrapper(bEmployeeVoClass, requester.getCondition());
        IPage<DynamicFormHistoryVo> page = this.getBaseMapper().pagerVo(Page.of(requester.getCurrent(), requester.getSize()), wrapper);
        return new PageResult<DynamicFormHistoryVo>(page.getRecords(), page.getTotal(), page.getPages(), page.getCurrent(), page.getSize());
    }

}
