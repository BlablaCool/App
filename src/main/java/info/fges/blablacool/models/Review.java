package info.fges.blablacool.models;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by Valentin on 06/04/15.
 */
@Entity
public class Review
{
    private int idReview;
    private Integer note;
    private String comment;
    private User reviewee;
    private User reviewer;
    private DateTime createdAt;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_review", nullable = false, insertable = false, updatable = false)
    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    @Basic
    @Column(name = "note", nullable = true, insertable = true, updatable = true)
    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    @Basic
    @Column(name = "comment", nullable = true, insertable = true, updatable = true, length = 255)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (idReview != review.idReview) return false;
        if (note != null ? !note.equals(review.note) : review.note != null) return false;
        if (comment != null ? !comment.equals(review.comment) : review.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idReview;
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "reviewee_id", referencedColumnName = "id_user", nullable = false)
    public User getReviewee() {
        return reviewee;
    }

    public void setReviewee(User reviewee) {
        this.reviewee = reviewee;
    }

    @OneToOne
    @JoinColumn(name = "reviewer_id", referencedColumnName = "id_user", nullable = false)
    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    @Basic
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "created_at", nullable = true, insertable = true, updatable = true)
    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }
}
