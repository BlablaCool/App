package info.fges.blablacool.models;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Valentin on 27/03/15.
 */
@Entity
@Table(name = "user_preference", schema = "", catalog = "blablacool")
public class UserPreference
{
    private int idUserPreference;
    private boolean likeAnimals;
    private boolean likeSmoking;
    private String musicStyle;
    private String temperament;
    private String talkingLevel;
    private String drivingStyle;
    private String others;
    private User user;

    public UserPreference()
    {

    }

    public UserPreference(User user)
    {
        this.user = user;
    }

    public static ArrayList<String> getMusicStyles()
    {
        ArrayList<String> musicStyles = new ArrayList<String>();
        musicStyles.add("Pop/rock");
        musicStyles.add("RnB");
        musicStyles.add("Rap");
        musicStyles.add("Variétés");
        musicStyles.add("Classique");

        return musicStyles;
    }

    public static ArrayList<String> getTemperaments()
    {
        ArrayList<String> temperaments = new ArrayList<String>();
        temperaments.add("Calme");
        temperaments.add("Avenant");
        temperaments.add("Décontracté");
        temperaments.add("Sur les nerfs");

        return temperaments;
    }

    public static ArrayList<String> getTalkingLevels()
    {
        ArrayList<String> talkingLevels = new ArrayList<String>();
        talkingLevels.add("Pas du tout");
        talkingLevels.add("Un peu");
        talkingLevels.add("Ça dépend avec qui !");
        talkingLevels.add("Je ne sais pas m'arrêter");

        return talkingLevels;
    }

    public static ArrayList<String> getDrivingStyles()
    {
        ArrayList<String> drivingStyles = new ArrayList<String>();
        drivingStyles.add("Calme");
        drivingStyles.add("Sportive");
        drivingStyles.add("Prudente");

        return drivingStyles;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_user_preference", nullable = false, insertable = false, updatable = false)
    public int getIdUserPreference() {
        return idUserPreference;
    }

    public void setIdUserPreference(int idUserPreference) {
        this.idUserPreference = idUserPreference;
    }

    @Basic
    @Column(name = "like_animals", nullable = true, insertable = true, updatable = true)
    public boolean getLikeAnimals() {
        return likeAnimals;
    }

    public void setLikeAnimals(boolean likeAnimals) {
        this.likeAnimals = likeAnimals;
    }

    @Basic
    @Column(name = "music_style", nullable = true, insertable = true, updatable = true, length = 100)
    public String getMusicStyle() {
        return musicStyle;
    }

    public void setMusicStyle(String musicStyle) {
        this.musicStyle = musicStyle;
    }

    @Basic
    @Column(name = "like_smoking", nullable = true, insertable = true, updatable = true)
    public boolean getLikeSmoking() {
        return likeSmoking;
    }

    public void setLikeSmoking(boolean likeSmoking) {
        this.likeSmoking = likeSmoking;
    }

    @Basic
    @Column(name = "temperament", nullable = true, insertable = true, updatable = true, length = 100)
    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    @Basic
    @Column(name = "talking_level", nullable = true, insertable = true, updatable = true, length = 150)
    public String getTalkingLevel() {
        return talkingLevel;
    }

    public void setTalkingLevel(String talkingLevel) {
        this.talkingLevel = talkingLevel;
    }

    @Basic
    @Column(name = "driving_style", nullable = true, insertable = true, updatable = true, length = 150)
    public String getDrivingStyle() {
        return drivingStyle;
    }

    public void setDrivingStyle(String drivingStyle) {
        this.drivingStyle = drivingStyle;
    }

    @Basic
    @Column(name = "others", nullable = true, insertable = true, updatable = true, length = 16777215)
    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPreference that = (UserPreference) o;

        if (idUserPreference != that.idUserPreference) return false;
        if (musicStyle != null ? !musicStyle.equals(that.musicStyle) : that.musicStyle != null) return false;
        if (temperament != null ? !temperament.equals(that.temperament) : that.temperament != null) return false;
        if (talkingLevel != null ? !talkingLevel.equals(that.talkingLevel) : that.talkingLevel != null) return false;
        if (drivingStyle != null ? !drivingStyle.equals(that.drivingStyle) : that.drivingStyle != null) return false;
        if (others != null ? !others.equals(that.others) : that.others != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUserPreference;
        result = 31 * result + (musicStyle != null ? musicStyle.hashCode() : 0);
        result = 31 * result + (temperament != null ? temperament.hashCode() : 0);
        result = 31 * result + (talkingLevel != null ? talkingLevel.hashCode() : 0);
        result = 31 * result + (drivingStyle != null ? drivingStyle.hashCode() : 0);
        result = 31 * result + (others != null ? others.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id_user", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
