package cn.yiqu.app.dynamic.service;

import cn.ifloat.brick.basic.common.results.PageRequester;
import cn.ifloat.brick.basic.common.results.PageRequesterFormCondition;
import cn.ifloat.brick.basic.common.results.PageResult;
import cn.ifloat.brick.sprofile.mybatis.common.BasicService;
import cn.yiqu.app.dynamic.domain.DynamicVersion;
import cn.yiqu.app.dynamic.domain.vo.DynamicVersionVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

import java.util.List;

/**
 * 版本业务逻辑声明
 */
public interface DynamicVersionService extends BasicService<DynamicVersion> {
    /**
     * vo条件包装器
     */
    Wrapper<DynamicVersionVo> builderByVo(DynamicVersionVo vo);

    /**
     * 条件包装器
     */
    Wrapper<DynamicVersion> builder(DynamicVersion bean);

    /**
     * 通过id查询vo对象
     */
    DynamicVersionVo selById(Long id);

    /**
     * 查询vo集合
     */
    List<DynamicVersionVo> listVo(DynamicVersionVo condition);

    /**
     * 分页查询vo集合
     */
    PageResult<DynamicVersionVo> pagerVo(PageRequester<DynamicVersionVo> requester);

    /**
     * 保存
     */
    DynamicVersion saver(DynamicVersion vo);

    /**
     * 保存或修改
     */
    boolean saverOrUpdater(DynamicVersion project);

    /**
     * 分页查询vo集合
     */
    PageResult<DynamicVersionVo> pagerVo(Class<DynamicVersion> bEmployeeVoClass, PageRequesterFormCondition<DynamicVersion> requester);
}
