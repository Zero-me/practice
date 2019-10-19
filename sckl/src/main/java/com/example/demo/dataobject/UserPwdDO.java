package com.example.demo.dataobject;

import java.io.Serializable;

public class UserPwdDO implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_pwd.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_pwd.encrpt_pwd
     *
     * @mbg.generated
     */
    private String encrptPwd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_pwd.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_pwd
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_pwd.id
     *
     * @return the value of user_pwd.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_pwd.id
     *
     * @param id the value for user_pwd.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_pwd.encrpt_pwd
     *
     * @return the value of user_pwd.encrpt_pwd
     *
     * @mbg.generated
     */
    public String getEncrptPwd() {
        return encrptPwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_pwd.encrpt_pwd
     *
     * @param encrptPwd the value for user_pwd.encrpt_pwd
     *
     * @mbg.generated
     */
    public void setEncrptPwd(String encrptPwd) {
        this.encrptPwd = encrptPwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_pwd.user_id
     *
     * @return the value of user_pwd.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_pwd.user_id
     *
     * @param userId the value for user_pwd.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_pwd
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", encrptPwd=").append(encrptPwd);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}