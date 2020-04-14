# 스프링 게시판

### 사용한 기술

- DI로 의존 객체들을 주입
- Mybatis로 비즈니스 로직에서 중복 코드 제거와 효율적인 코드를 작성해서 데이터베이스에 접속
- MVC 구조를 따름
  1. 클라이언트 요청이 들어온 후 컨트롤러가 해당 요청 함수로 매핑
  2. 요청 함수에서 Service(비즈니스 로직) 함수를 호출
  3. ModelAndView 객체를 생성하여 뷰와 로직 데이터를 저장
  4. 해당 뷰로 렌더링
- 비즈니스 로직들은 인터페이스를 활용하여 유지보수와 효율성을 높임
- DAO와 DTO를 활용하여 DB관련 연동 작업 수행

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

### 기능
