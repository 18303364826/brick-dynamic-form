package cn.yiqu.app.dynamic.service.impl;

import cn.ifloat.brick.basic.common.results.PageRequester;
import cn.ifloat.brick.basic.common.results.PageRequesterFormCondition;
import cn.ifloat.brick.basic.common.results.PageResult;
import cn.ifloat.brick.basic.common.toolkit.StringUtils;
import cn.ifloat.brick.basic.common.toolkit.beans.BeanUtils;
import cn.ifloat.brick.chinses.py.PinYinKit;
import cn.ifloat.brick.sprofile.mybatis.common.BasicServiceImpl;
import cn.ifloat.brick.sprofile.mybatis.tools.FormConditionKit;
import cn.yiqu.app.dynamic.domain.DynamicForm;
import cn.yiqu.app.dynamic.domain.DynamicVersion;
import cn.yiqu.app.dynamic.domain.vo.DynamicFormVo;
import cn.yiqu.app.dynamic.mappers.DynamicFormMapper;
import cn.yiqu.app.dynamic.service.DynamicFormService;
import cn.yiqu.app.dynamic.service.DynamicVersionService;
import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class DynamicFormServiceImpl extends BasicServiceImpl<DynamicFormMapper, DynamicForm> implements DynamicFormService {
    @Autowired
    private DynamicVersionService dynamicVersionService;

    @Override
    public Wrapper<DynamicFormVo> builderByVo(DynamicFormVo vo) {
        LambdaQueryWrapper<DynamicFormVo> wrapper = Wrappers.<DynamicFormVo>lambdaQuery();
        return wrapper;
    }

    @Override
    public Wrapper<DynamicForm> builder(DynamicForm bean) {
        LambdaQueryWrapper<DynamicForm> wrapper = Wrappers.<DynamicForm>lambdaQuery();
        return wrapper;
    }

    @Override
    public DynamicFormVo selById(Long id) {
        LambdaQueryWrapper<DynamicFormVo> wrapper = Wrappers.<DynamicFormVo>lambdaQuery().eq(DynamicFormVo::getId, id);
        List<DynamicFormVo> dynamicFormVoList = this.getBaseMapper().listVo(wrapper);
        if (CollectionUtils.isNotEmpty(dynamicFormVoList)) {
            DynamicFormVo dynamicFormVo = dynamicFormVoList.get(0);
            return dynamicFormVo;
        }
        return null;
    }

    @Override
    public List<DynamicFormVo> listVo(DynamicFormVo condition) {
        Wrapper<DynamicFormVo> wrapper = builderByVo(condition);
        return this.getBaseMapper().listVo(wrapper);
    }

    @Override
    public PageResult<DynamicFormVo> pagerVo(PageRequester<DynamicFormVo> requester) {
        Wrapper<DynamicFormVo> wrapper = builderByVo(requester.getCondition());
        IPage<DynamicFormVo> page = this.getBaseMapper().pagerVo(Page.of(requester.getCurrent(), requester.getSize()), wrapper);
        return new PageResult<DynamicFormVo>(page.getRecords(), page.getTotal(), page.getPages(), page.getCurrent(), page.getSize());
    }

    @Override
    public DynamicForm saver(DynamicForm bean) {
        bean.setId(this.sequenceId());
        bean.setCreateBy(4826L);
        bean.setCreateTime(new Date());
        this.save(bean);
        return bean;
    }

    /**
     * 保存或修改动态表单
     *
     * @param vo 表单Vo对象
     */
    @Override
    public boolean saverOrUpdater(DynamicFormVo vo) {
        String name = vo.getName();
        if (StringUtils.isNotEmpty(name)) {
            String code = PinYinKit.full(name, "_");
            vo.setCode(code);
        }
        if (vo.getId() == null) {
            this.saver(vo);
        } else {
            vo.setUpdateBy(4826L);
            vo.setUpdateTime(new Date());
            return this.updateById(vo);
        }
        return true;
    }

    @Override
    public PageResult<DynamicFormVo> pagerVo(Class<DynamicForm> bEmployeeVoClass, PageRequesterFormCondition<DynamicForm> requester) {
        AbstractWrapper wrapper = FormConditionKit.<DynamicForm>builderWrapper(bEmployeeVoClass, requester.getCondition());
        IPage<DynamicFormVo> page = this.getBaseMapper().pagerVo(Page.of(requester.getCurrent(), requester.getSize()), wrapper);
        return new PageResult<DynamicFormVo>(page.getRecords(), page.getTotal(), page.getPages(), page.getCurrent(), page.getSize());
    }

    @Override
    public DynamicFormVo selRelationById(Long id) {
        LambdaQueryWrapper<DynamicFormVo> wrapper = Wrappers.<DynamicFormVo>lambdaQuery().eq(DynamicFormVo::getId, id);
        List<DynamicFormVo> dynamicFormVoList = this.getBaseMapper().listVo(wrapper);
        if (CollectionUtils.isNotEmpty(dynamicFormVoList)) {
            DynamicFormVo dynamicFormVo = dynamicFormVoList.get(0);
            //获取版本对象
            dynamicFormVo.setDynamicVersion(dynamicVersionService.getById(dynamicFormVo.getVersionId()));
            return dynamicFormVo;
        }
        return null;
    }

    @Override
    public List<DynamicFormVo> listRelationVo(DynamicFormVo condition) {
        Wrapper<DynamicFormVo> wrapper = builderByVo(condition);
        List<DynamicFormVo> dynamicFormVoList = this.getBaseMapper().listVo(wrapper);
        return this.relationList(dynamicFormVoList);
    }

    @Override
    public PageResult<DynamicFormVo> pagerRelationVo(PageRequester<DynamicFormVo> requester) {
        Wrapper<DynamicFormVo> wrapper = builderByVo(requester.getCondition());
        IPage<DynamicFormVo> page = this.getBaseMapper().pagerVo(Page.of(requester.getCurrent(), requester.getSize()), wrapper);
        List<DynamicFormVo> dynamicFormVoList = page.getRecords();
        return new PageResult<DynamicFormVo>(this.relationList(dynamicFormVoList), page.getTotal(), page.getPages(), page.getCurrent(), page.getSize());
    }

    @Override
    public PageResult<DynamicFormVo> pagerRelationVo(Class<DynamicForm> bEmployeeVoClass, PageRequesterFormCondition<DynamicForm> requester) {
        AbstractWrapper wrapper = FormConditionKit.<DynamicForm>builderWrapper(bEmployeeVoClass, requester.getCondition());
        IPage<DynamicFormVo> page = this.getBaseMapper().pagerVo(Page.of(requester.getCurrent(), requester.getSize()), wrapper);
        List<DynamicFormVo> dynamicFormVoList = page.getRecords();
        return new PageResult<DynamicFormVo>(this.relationList(dynamicFormVoList), page.getTotal(), page.getPages(), page.getCurrent(), page.getSize());
    }

    public List<DynamicFormVo> relationList(List<DynamicFormVo> dynamicFormVoList) {
        if (CollectionUtils.isNotEmpty(dynamicFormVoList)) {
            //获取versionId集合
            Set<Long> versionIds = BeanUtils.extractFieldByList(dynamicFormVoList, DynamicFormVo::getVersionId);
            LambdaQueryWrapper<DynamicVersion> dynamicVersionWra = Wrappers.<DynamicVersion>lambdaQuery().in(DynamicVersion::getId, versionIds);
            //获取dynamicVersion对象集合
            List<DynamicVersion> dynamicVersionList = dynamicVersionService.list(dynamicVersionWra);
            Map<Long, DynamicVersion> dynamicVersionMap = BeanUtils.listToMap(dynamicVersionList, DynamicVersion::getId);
            for (DynamicFormVo dynamicFormVo : dynamicFormVoList) {
                if (null != dynamicVersionMap.get(dynamicFormVo.getVersionId())) {
                    dynamicFormVo.setDynamicVersion(dynamicVersionMap.get(dynamicFormVo.getVersionId()));
                }
            }
        }
        return dynamicFormVoList;
    }
}
