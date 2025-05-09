package com.klef.ep.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messages_table")
public class Messages implements Serializable {
    @Id
    @Column(name = "messageid")
    private int messageid;

    @Column(name = "sender", nullable = false, length = 500)
    private String sender;

    @Column(name = "receiver", nullable = false,length=500)
    private String receiver;
    
    @Column(name = "date", nullable = false,length=30)
    private String date;

    @Column(name = "subject", nullable = false, length = 1000)
    private String subject;

    @Column(name = "message", nullable = false, length = 10000)
    private String message;

    public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getMessageid() {
        return messageid;
    }

    public void setMessageid(int messageid) {
        this.messageid = messageid;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
