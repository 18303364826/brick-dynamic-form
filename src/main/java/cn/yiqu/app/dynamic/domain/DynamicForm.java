package cn.yiqu.app.dynamic.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 动态表单表
 */
public class DynamicForm implements Serializable {
    /**
     * 主键ID
     */
    protected Long id;
    /**
     * code标识
     */
    protected String code;
    /**
     * 表单名称
     */
    protected String name;
    /**
     * 表单Key
     */
    protected String formKey;
    /**
     * 表单json数据
     */
    protected String data;
    /**
     * 表单状态
     */
    protected String status;
    /**
     * 表单类型 PC,MOBILE
     */
    protected String formType;
    /**
     * 版本号
     */
    protected Long versionId;
    /**
     * 岗位ID
     */
    protected String jobId;
    /**
     * 组织ID
     */
    protected String orgId;
    /**
     * 创建时间
     */
    protected Date createTime;
    /**
     * 创建人
     */
    protected Long createBy;
    /**
     * 修改时间
     */
    protected Date updateTime;
    /**
     * 修改人
     */
    protected Long updateBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormKey() {
        return formKey;
    }

    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFormType() {
        return this.formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public Long getVersionId() {
        return this.versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public String getJobId() {
        return this.jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateBy() {
        return this.updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }
}
