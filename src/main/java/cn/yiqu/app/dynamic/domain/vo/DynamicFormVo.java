package cn.yiqu.app.dynamic.domain.vo;


import cn.yiqu.app.dynamic.domain.DynamicForm;
import cn.yiqu.app.dynamic.domain.DynamicVersion;

/**
 * 动态表单表Vo
 */
public class DynamicFormVo extends DynamicForm {
    /**
     * 版本
     */
    protected DynamicVersion dynamicVersion;

    public DynamicVersion getDynamicVersion() {
        return this.dynamicVersion;
    }

    public void setDynamicVersion(DynamicVersion dynamicVersion) {
        this.dynamicVersion = dynamicVersion;
    }
}
