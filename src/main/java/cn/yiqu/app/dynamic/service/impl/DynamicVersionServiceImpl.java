package cn.yiqu.app.dynamic.service.impl;

import cn.ifloat.brick.basic.common.results.PageRequester;
import cn.ifloat.brick.basic.common.results.PageRequesterFormCondition;
import cn.ifloat.brick.basic.common.results.PageResult;
import cn.ifloat.brick.sprofile.mybatis.common.BasicServiceImpl;
import cn.ifloat.brick.sprofile.mybatis.tools.FormConditionKit;
import cn.yiqu.app.dynamic.domain.DynamicVersion;
import cn.yiqu.app.dynamic.domain.vo.DynamicVersionVo;
import cn.yiqu.app.dynamic.mappers.DynamicVersionMapper;
import cn.yiqu.app.dynamic.service.DynamicVersionService;
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
public class DynamicVersionServiceImpl extends BasicServiceImpl<DynamicVersionMapper, DynamicVersion> implements DynamicVersionService {

    @Override
    public Wrapper<DynamicVersionVo> builderByVo(DynamicVersionVo vo) {
        LambdaQueryWrapper<DynamicVersionVo> wrapper = Wrappers.<DynamicVersionVo>lambdaQuery();
        return wrapper;
    }

    @Override
    public Wrapper<DynamicVersion> builder(DynamicVersion bean) {
        LambdaQueryWrapper<DynamicVersion> wrapper = Wrappers.<DynamicVersion>lambdaQuery();
        if (null != bean) {
            wrapper.eq(DynamicVersion::getId, bean.getId());
        }
        return wrapper;
    }

    @Override
    public DynamicVersionVo selById(Long id) {
        LambdaQueryWrapper<DynamicVersionVo> wrapper = Wrappers.<DynamicVersionVo>lambdaQuery().eq(DynamicVersionVo::getId, id);
        List<DynamicVersionVo> dynamicVersionVoList = this.getBaseMapper().listVo(wrapper);
        if (CollectionUtils.isNotEmpty(dynamicVersionVoList)) {
            DynamicVersionVo dynamicVersionVo = dynamicVersionVoList.get(0);
            return dynamicVersionVo;
        }
        return null;
    }

    @Override
    public List<DynamicVersionVo> listVo(DynamicVersionVo condition) {
        Wrapper<DynamicVersionVo> wrapper = builderByVo(condition);
        return this.getBaseMapper().listVo(wrapper);
    }

    @Override
    public PageResult<DynamicVersionVo> pagerVo(PageRequester<DynamicVersionVo> requester) {
        Wrapper<DynamicVersionVo> wrapper = builderByVo(requester.getCondition());
        IPage<DynamicVersionVo> page = this.getBaseMapper().pagerVo(Page.of(requester.getCurrent(), requester.getSize()), wrapper);
        return new PageResult<DynamicVersionVo>(page.getRecords(), page.getTotal(), page.getPages(), page.getCurrent(), page.getSize());
    }

    @Override
    public DynamicVersion saver(DynamicVersion bean) {
        bean.setId(this.sequenceId());
        this.save(bean);
        return bean;
    }

    @Override
    public boolean saverOrUpdater(DynamicVersion bean) {
        if (bean.getId() == null) {
            this.saver(bean);
        } else {
            return this.updateById(bean);
        }
        return true;
    }

    @Override
    public PageResult<DynamicVersionVo> pagerVo(Class<DynamicVersion> bEmployeeVoClass, PageRequesterFormCondition<DynamicVersion> requester) {
        AbstractWrapper wrapper = FormConditionKit.<DynamicVersion>builderWrapper(bEmployeeVoClass, requester.getCondition());
        IPage<DynamicVersionVo> page = this.getBaseMapper().pagerVo(Page.of(requester.getCurrent(), requester.getSize()), wrapper);
        return new PageResult<DynamicVersionVo>(page.getRecords(), page.getTotal(), page.getPages(), page.getCurrent(), page.getSize());
    }

}
