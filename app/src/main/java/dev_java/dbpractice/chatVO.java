package dev_java.dbpractice;

import java.util.ArrayList;

public class chatVO {
  private int protocol;
  private String chat_date;
  private String comments;

  public int getProtocol() {
    return this.protocol;
  }

  public void setProtocol(int protocol) {
    this.protocol = protocol;
  }

  public String getChat_date() {
    return this.chat_date;
  }

  public void setChat_date(String chat_date) {
    this.chat_date = chat_date;
  }

  public String getComments() {
    return this.comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }
  public static void main(String[] args) {
    ArrayList<ChatListVO> list= new ArrayList<>();
  }
  
}
