package cn.yiqu.app.dynamic.service;

import cn.ifloat.brick.basic.common.results.PageRequester;
import cn.ifloat.brick.basic.common.results.PageRequesterFormCondition;
import cn.ifloat.brick.basic.common.results.PageResult;
import cn.ifloat.brick.sprofile.mybatis.common.BasicService;
import cn.yiqu.app.dynamic.domain.DynamicFormHistory;
import cn.yiqu.app.dynamic.domain.vo.DynamicFormHistoryVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

import java.util.List;

/**
 * 动态表单历史表业务逻辑声明
 */
public interface DynamicFormHistoryService extends BasicService<DynamicFormHistory> {
    /**
     * vo条件包装器
     */
    Wrapper<DynamicFormHistoryVo> builderByVo(DynamicFormHistoryVo vo);

    /**
     * 条件包装器
     */
    Wrapper<DynamicFormHistory> builder(DynamicFormHistory bean);

    /**
     * 通过id查询vo对象
     */
    DynamicFormHistoryVo selById(Long id);

    /**
     * 查询vo集合
     */
    List<DynamicFormHistoryVo> listVo(DynamicFormHistoryVo condition);

    /**
     * 分页查询vo集合
     */
    PageResult<DynamicFormHistoryVo> pagerVo(PageRequester<DynamicFormHistoryVo> requester);

    /**
     * 保存
     */
    DynamicFormHistory saver(DynamicFormHistory vo);

    /**
     * 保存或修改
     */
    boolean saverOrUpdater(DynamicFormHistory project);

    /**
     * 分页查询vo集合
     */
    PageResult<DynamicFormHistoryVo> pagerVo(Class<DynamicFormHistory> bEmployeeVoClass, PageRequesterFormCondition<DynamicFormHistory> requester);
}
