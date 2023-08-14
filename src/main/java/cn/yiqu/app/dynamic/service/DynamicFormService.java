package cn.yiqu.app.dynamic.service;

import cn.ifloat.brick.basic.common.results.PageRequester;
import cn.ifloat.brick.basic.common.results.PageRequesterFormCondition;
import cn.ifloat.brick.basic.common.results.PageResult;
import cn.ifloat.brick.sprofile.mybatis.common.BasicService;
import cn.yiqu.app.dynamic.domain.DynamicForm;
import cn.yiqu.app.dynamic.domain.vo.DynamicFormVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

import java.util.List;

/**
 * 动态表单表业务逻辑声明
 */
public interface DynamicFormService extends BasicService<DynamicForm> {
    /**
     * vo条件包装器
     */
    Wrapper<DynamicFormVo> builderByVo(DynamicFormVo vo);

    /**
     * 条件包装器
     */
    Wrapper<DynamicForm> builder(DynamicForm bean);

    /**
     * 通过id查询vo对象
     */
    DynamicFormVo selById(Long id);

    /**
     * 查询vo集合
     */
    List<DynamicFormVo> listVo(DynamicFormVo condition);

    /**
     * 分页查询vo集合
     */
    PageResult<DynamicFormVo> pagerVo(PageRequester<DynamicFormVo> requester);

    /**
     * 保存
     */
    DynamicForm saver(DynamicForm vo);

    /**
     * 保存或修改动态表单
     *
     * @param vo 表单Vo对象
     */
    boolean saverOrUpdater(DynamicFormVo vo);

    /**
     * 分页查询vo集合
     */
    PageResult<DynamicFormVo> pagerVo(Class<DynamicForm> bEmployeeVoClass, PageRequesterFormCondition<DynamicForm> requester);

    /**
     * 通过id查询关系vo对象
     */
    DynamicFormVo selRelationById(Long id);

    /**
     * 查询关系vo集合
     */
    List<DynamicFormVo> listRelationVo(DynamicFormVo condition);

    /**
     * 分页查询关系vo集合
     */
    PageResult<DynamicFormVo> pagerRelationVo(PageRequester<DynamicFormVo> requester);

    /**
     * 分页查询关系vo集合
     */
    PageResult<DynamicFormVo> pagerRelationVo(Class<DynamicForm> bEmployeeVoClass, PageRequesterFormCondition<DynamicForm> requester);
}
