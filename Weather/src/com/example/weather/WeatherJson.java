/**
 * 
 */

package com.example.weather;

import java.util.ArrayList;

/**
 * JSONICパース用のJSONクラス
 */
public class WeatherJson {
    private static final String TAG = WeatherJson.class.getSimpleName();

    private ArrayList<PinpointLocation> pinpointLocations;
    private Location location;
    private Description description;
    private String link;
    private String title;

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ArrayList<PinpointLocation> getPinpointLocations() {
        return pinpointLocations;
    }

    public void setPinpointLocations(ArrayList<PinpointLocation> pinpointLocations) {
        this.pinpointLocations = pinpointLocations;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public class PinpointLocation {
        private String link;
        private String name;

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class Location {
        private String city;
        private String area;
        private String Prefecture;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getPrefecture() {
            return Prefecture;
        }

        public void setPrefecture(String prefecture) {
            Prefecture = prefecture;
        }
    }

    public class Description {
        private String text;
        private String publicTime;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getPublicTime() {
            return publicTime;
        }

        public void setPublicTime(String publicTime) {
            this.publicTime = publicTime;
        }
    }
}
