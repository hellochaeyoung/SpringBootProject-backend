package com.boot.backend.dto;

public class CommentDto {

    private int seq;

    private int bbs;

    private String id;

    private String content;

    private String wdate;

    public CommentDto() {

    }

    public CommentDto(int seq, int bbs, String id, String content, String wdate) {
        this.seq = seq;
        this.bbs = bbs;
        this.id = id;
        this.content = content;
        this.wdate = wdate;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getBbs() {
        return bbs;
    }

    public void setBbs(int bbs) {
        this.bbs = bbs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWdate() {
        return wdate;
    }

    public void setWdate(String wdate) {
        this.wdate = wdate;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
            "seq=" + seq +
            ", bbs=" + bbs +
            ", id='" + id + '\'' +
            ", content='" + content + '\'' +
            ", wdate='" + wdate + '\'' +
            '}';
    }
}
