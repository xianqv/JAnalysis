package com.audit.janalysis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

@TableName(value = "obo_File")
public class OBO_File implements Serializable {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    @TableField(value = "filename")
    private String filename;

    @TableField(value = "filepath")
    private String filepath;

    @TableField(value = "`size`")
    private Integer size;

    @TableField(value = "uploaded_at")
    private Date uploadedAt;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return filepath
     */
    public String getFilepath() {
        return filepath;
    }

    /**
     * @param filepath
     */
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    /**
     * @return size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * @param size
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * @return uploaded_at
     */
    public Date getUploadedAt() {
        return uploadedAt;
    }

    /**
     * @param uploadedAt
     */
    public void setUploadedAt(Date uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}