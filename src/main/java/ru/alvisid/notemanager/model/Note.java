package ru.alvisid.notemanager.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @Column(name = "id", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "note_name")
    private String noteName;

    @Column(name = "create_date" , insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "is_performed")
    private boolean isPerformed;

    public Note(){
        isPerformed = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isPerformed() {
        return isPerformed;
    }

    public void setPerformed(boolean isPerformed) {
        this.isPerformed = isPerformed;
    }


}
