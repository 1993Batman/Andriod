package swindroid.suntime.calc;

/**
 * Created by StevenE on 14/10/2016.
 */

public class Locations {
    String _name;
    float _long;
    float _lat;
    String _tzone;

    public Locations(String n, float lg, float lt, String tz){
        _name = n;
        _long = lg;
        _lat = lt;
        _tzone = tz;
    }

    public String get_name() {
        return _name;
    }

    public void set_long(float _long) {
        this._long = _long;
    }

    public float get_lat() {
        return _lat;
    }

    public String get_tzone() {
        return _tzone;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public float get_long() {
        return _long;
    }

    public void set_lat(float _lat) {
        this._lat = _lat;
    }

    public void set_tzone(String _tzone) {
        this._tzone = _tzone;
    }
}
