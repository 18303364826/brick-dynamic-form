package cn.yiqu.app.dynamic.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 版本
 */
public class DynamicVersion implements Serializable {
    /**
     * 主键ID
     */
    protected Long id;
    /**
     * 版本号
     */
    protected String versionNumber;
    /**
     * 版本名称
     */
    protected String versionName;
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

    public String getVersionNumber() {
        return this.versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
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
