package com.briller.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "user_id", updatable = false, nullable = false)
    private UUID userId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNbr;
    private String token;
    private String status;
    private String createdBy;
    private String updatedBy;

    @Column(name = "created_dt")
    @CreationTimestamp
    private LocalDateTime createdDt;
    @Column(name = "updated_dt")
    @UpdateTimestamp
    private LocalDateTime updatedDt;
    private byte[] photo;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "role_id"), name = "role_id")
    private  Role role;

    public UUID getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNbr() {
        return this.phoneNbr;
    }

    public String getToken() {
        return this.token;
    }

    public String getStatus() {
        return this.status;
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

    public byte[] getPhoto() {
        return this.photo;
    }


    public Role getRole() {
        return this.role;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNbr(String phoneNbr) {
        this.phoneNbr = phoneNbr;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @PrePersist
    protected void onCreate() {
        this.status = "ACTIVE";
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

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Users)) return false;
        final Users other = (Users) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final Object this$userName = this.getUserName();
        final Object other$userName = other.getUserName();
        if (this$userName == null ? other$userName != null : !this$userName.equals(other$userName)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$firstName = this.getFirstName();
        final Object other$firstName = other.getFirstName();
        if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) return false;
        final Object this$lastName = this.getLastName();
        final Object other$lastName = other.getLastName();
        if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$phoneNbr = this.getPhoneNbr();
        final Object other$phoneNbr = other.getPhoneNbr();
        if (this$phoneNbr == null ? other$phoneNbr != null : !this$phoneNbr.equals(other$phoneNbr)) return false;
        final Object this$token = this.getToken();
        final Object other$token = other.getToken();
        if (this$token == null ? other$token != null : !this$token.equals(other$token)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
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
        if (!java.util.Arrays.equals(this.getPhoto(), other.getPhoto())) return false;
        final Object this$role = this.getRole();
        final Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Users;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final Object $userName = this.getUserName();
        result = result * PRIME + ($userName == null ? 43 : $userName.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $lastName = this.getLastName();
        result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $phoneNbr = this.getPhoneNbr();
        result = result * PRIME + ($phoneNbr == null ? 43 : $phoneNbr.hashCode());
        final Object $token = this.getToken();
        result = result * PRIME + ($token == null ? 43 : $token.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $createdBy = this.getCreatedBy();
        result = result * PRIME + ($createdBy == null ? 43 : $createdBy.hashCode());
        final Object $updatedBy = this.getUpdatedBy();
        result = result * PRIME + ($updatedBy == null ? 43 : $updatedBy.hashCode());
        final Object $createdDt = this.getCreatedDt();
        result = result * PRIME + ($createdDt == null ? 43 : $createdDt.hashCode());
        final Object $updatedDt = this.getUpdatedDt();
        result = result * PRIME + ($updatedDt == null ? 43 : $updatedDt.hashCode());
        result = result * PRIME + java.util.Arrays.hashCode(this.getPhoto());
        final Object $role = this.getRole();
        result = result * PRIME + ($role == null ? 43 : $role.hashCode());
        return result;
    }

    public String toString() {
        return "Users(userId=" + this.getUserId() + ", userName=" + this.getUserName() + ", password=" + this.getPassword() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", email=" + this.getEmail() + ", phoneNbr=" + this.getPhoneNbr() + ", token=" + this.getToken() + ", status=" + this.getStatus() + ", createdBy=" + this.getCreatedBy() + ", updatedBy=" + this.getUpdatedBy() + ", createdDt=" + this.getCreatedDt() + ", updatedDt=" + this.getUpdatedDt() + ", photo=" + java.util.Arrays.toString(this.getPhoto()) + ", role=" + this.getRole() + ")";
    }
}
