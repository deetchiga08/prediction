package com.briller.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    private String type;
    private String description;
    private String createdBy;
    private String updatedBy;
    @Basic
    @Column(name = "created_dt")
    @CreationTimestamp
    private LocalDateTime createdDt;
    @Basic
    @Column(name = "updated_dt")
    @UpdateTimestamp
    private LocalDateTime updatedDt;

    public int getRoleId() {
        return this.roleId;
    }

    public String getType() {
        return this.type;
    }

    public String getDescription() {
        return this.description;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public LocalDateTime getCreatedDt() {
        return this.createdDt;
    }

    public LocalDateTime getUpdatedDt() {
        return this.updatedDt;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setCreatedDt(LocalDateTime createdDt) {
        this.createdDt = createdDt;
    }

    public void setUpdatedDt(LocalDateTime updatedDt) {
        this.updatedDt = updatedDt;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Role)) return false;
        final Role other = (Role) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getRoleId() != other.getRoleId()) return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$createdBy = this.getCreatedBy();
        final Object other$createdBy = other.getCreatedBy();
        if (this$createdBy == null ? other$createdBy != null : !this$createdBy.equals(other$createdBy)) return false;
        final Object this$updatedBy = this.getUpdatedBy();
        final Object other$updatedBy = other.getUpdatedBy();
        if (this$updatedBy == null ? other$updatedBy != null : !this$updatedBy.equals(other$updatedBy)) return false;
        final Object this$createdDt = this.getCreatedDt();
        final Object other$createdDt = other.getCreatedDt();
        if (this$createdDt == null ? other$createdDt != null : !this$createdDt.equals(other$createdDt)) return false;
        final Object this$updatedDt = this.getUpdatedDt();
        final Object other$updatedDt = other.getUpdatedDt();
        if (this$updatedDt == null ? other$updatedDt != null : !this$updatedDt.equals(other$updatedDt)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Role;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getRoleId();
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $createdBy = this.getCreatedBy();
        result = result * PRIME + ($createdBy == null ? 43 : $createdBy.hashCode());
        final Object $updatedBy = this.getUpdatedBy();
        result = result * PRIME + ($updatedBy == null ? 43 : $updatedBy.hashCode());
        final Object $createdDt = this.getCreatedDt();
        result = result * PRIME + ($createdDt == null ? 43 : $createdDt.hashCode());
        final Object $updatedDt = this.getUpdatedDt();
        result = result * PRIME + ($updatedDt == null ? 43 : $updatedDt.hashCode());
        return result;
    }

    public String toString() {
        return "Role(roleId=" + this.getRoleId() + ", type=" + this.getType() + ", description=" + this.getDescription() + ", createdBy=" + this.getCreatedBy() + ", updatedBy=" + this.getUpdatedBy() + ", createdDt=" + this.getCreatedDt() + ", updatedDt=" + this.getUpdatedDt() + ")";
    }
}
