package swindroid.suntime.ui;

import android.os.Parcel;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;

/**
 * Created by StevenE on 20/10/2016.
 */

public class Parcelable implements android.os.Parcelable {
    String name;
    String tzone;
    int lat;
    int _long;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this._long);
        dest.writeInt(this.lat);
        dest.writeString(this.tzone);
    }

    public Parcelable(String n, int lg,int lt, String tz) {
        name = n;
        _long = lg;
        lat = lt;
        tzone = tz;
    }

    protected Parcelable(Parcel in) {
        this.name = in.readString();
        this._long = in.readInt();
        this.lat = in.readInt();
        this.tzone = in.readString();
    }

    public static final android.os.Parcelable.Creator<Parcelable> CREATOR = new android.os.Parcelable.Creator<Parcelable>() {
        @Override
        public Parcelable createFromParcel(Parcel source) {
            return new Parcelable(source);
        }

        @Override
        public Parcelable[] newArray(int size) {
            return new Parcelable[size];
        }
    };
}
