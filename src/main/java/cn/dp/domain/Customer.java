package cn.dp.domain;

import java.util.Date;

/*
use userinfo;
create table customers(
	id int primary key auto_increment,
	name varchar(100) not null,
	gender varchar(100) not null,
	birthday date not null,
	cellphone varchar(100) not null,
	email varchar(100) not null,
	hobby varchar(100) not null,#eat,sleep,study
	type varchar(100) not null,
	description varchar(255) not null
);
 */
public class Customer {
    private Integer ID;
    private String name;
    private String gender;
    private Date birthday;
    private String cellphone;
    private String email;
    private String type;
    private String  description;

    public String toString() {
        return "Customer{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", cellphone='" + cellphone + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", description=" + description +
                '}';
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
