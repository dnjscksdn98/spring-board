# 스프링 게시판

### 데이터베이스

- 액세스 방법 : Mybatis

- 사용한 데이터베이스 : Oracle

- 테이블
  
  <pre>
  <code>
  create table board(
    board_id number not null primary key,
    title varchar2(200) not null,
    content varchar2(4000) not null,
    writer varchar2(50) not null,
    regdate date default sysdate,
    views number default 0
  );
  </code>
  </pre>

### 스프링 구조 : MVC 구조

### 기능
