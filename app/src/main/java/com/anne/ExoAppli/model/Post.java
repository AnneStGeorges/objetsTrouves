package com.anne.ExoAppli.model;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.anne.ExoAppli.util.ImageUtil;

import java.util.Date;

public class Post implements Parcelable {
    private String name;
    private String description;
    private String address;
    private CivilityEnum civility;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private Date createdDate;
    private String pictureBase64;

    public Post(String name, String description, String address, CivilityEnum civility, String firstname, String lastname, String email, String phoneNumber) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.civility = civility;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdDate = new Date();
    }

    public Bitmap getPictureBase64() {
        return pictureBase64 != null ? ImageUtil.convert(pictureBase64) : null;
    }

    public void setPictureBase64(Bitmap pictureBmp) {
        this.pictureBase64 = ImageUtil.convert(pictureBmp);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCivility(CivilityEnum civility) {
        this.civility = civility;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getAddress() {
        return address;
    }

    public CivilityEnum getCivility() {
        return civility;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    @NonNull
    @Override
    public String toString() {
        return "Post{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", civility=" + civility +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.address);
        dest.writeInt(this.civility == null ? -1 : this.civility.ordinal());
        dest.writeString(this.firstname);
        dest.writeString(this.lastname);
        dest.writeString(this.email);
        dest.writeString(this.phoneNumber);
        dest.writeLong(this.createdDate != null ? this.createdDate.getTime() : -1);
        dest.writeString(this.pictureBase64);
    }

    public void readFromParcel(Parcel source) {
        this.name = source.readString();
        this.description = source.readString();
        this.address = source.readString();
        int tmpCivility = source.readInt();
        this.civility = tmpCivility == -1 ? null : CivilityEnum.values()[tmpCivility];
        this.firstname = source.readString();
        this.lastname = source.readString();
        this.email = source.readString();
        this.phoneNumber = source.readString();
        long tmpCreatedDate = source.readLong();
        this.createdDate = tmpCreatedDate == -1 ? null : new Date(tmpCreatedDate);
        this.pictureBase64 = source.readString();
    }

    protected Post(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.address = in.readString();
        int tmpCivility = in.readInt();
        this.civility = tmpCivility == -1 ? null : CivilityEnum.values()[tmpCivility];
        this.firstname = in.readString();
        this.lastname = in.readString();
        this.email = in.readString();
        this.phoneNumber = in.readString();
        long tmpCreatedDate = in.readLong();
        this.createdDate = tmpCreatedDate == -1 ? null : new Date(tmpCreatedDate);
        this.pictureBase64 = in.readString();
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel source) {
            return new Post(source);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };
}
