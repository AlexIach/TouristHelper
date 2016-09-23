package model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alex Iachimov on 5/6/2016.
 */
public class User implements Parcelable {


    private int id;
    private String password;
    private int age;
    private int height;
    private int weight;
    private String sex;
    private String name;
    private String lifeStyle;
    private String goal;
    public User(){}

    public User(int id,String password, int age, int height, int weight, String sex, String name, String lifeStyle, String goal) {
        this.id = id;
        this.password = password;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.name = name;
        this.lifeStyle = lifeStyle;
        this.goal = goal;
    }


    protected User(Parcel in) {
        password = in.readString();
        id = in.readInt();
        age = in.readInt();
        height = in.readInt();
        weight = in.readInt();
        sex = in.readString();
        name = in.readString();
        lifeStyle = in.readString();
        goal = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public int getId() {return id;}

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public String getLifeStyle() {
        return lifeStyle;
    }

    public String getGoal() {
        return goal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(password);
        dest.writeInt(id);
        dest.writeInt(age);
        dest.writeInt(height);
        dest.writeInt(weight);
        dest.writeString(sex);
        dest.writeString(name);
        dest.writeString(lifeStyle);
        dest.writeString(goal);
    }
}
