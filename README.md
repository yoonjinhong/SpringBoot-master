# Spring Boot Sampling
Spring MVC 패턴 구조 파악 및 학습 용도
### 사용한 라이브러리
> 추후 필요한 라이브러리 추가 예정
+ Web Container
  + Spring boot 2.5
  + JDK 11
+ WAS(Web Application Server)
  + Embedded Tomcat
+ Build
  + Gradle 7
+ Database
  + DBMS: MySqL
  + DB Access: MyBatis
+ Validation
  + Spring Validation
### 디렉토리 구조(실제 실행 파일)
<pre>
└ domain
    ├ api
    |   ├ controller
    |   ├ service
    |   └ mapper
    ├ model
    |   ├ vo
    |   └ dto
    ├ config
    └ common
</pre>
+ api: 서비스 로직에 필요한 객체 생성
  + controller: 클라이언트의 요청을 받고 클라이언트에게 응답을 주는 계층
    + 요청/응답은 json 객체를 이용하여 교환
    + 응답은 항상 response 객체를 이용하여 통일
      + 성공 -> `SuccessResponse.java`
      + 실패 -> `ErrorResponse.java`
        + 보통 요청이 실패(Exception) 했을 시 Handler을 통한 통일된 객체 응답
    + 요청/응답에 Map 사용금지
      + Map을 사용하면 다른 개발자가 해당 Map이 어떤 데이터를 받고 어떤 데이터를 강제하는 지 알 수 없음
      + 잘못된 키값으로 인한 에러 검출이 힘듬. -> 객체 이용 시 컴파일 오류
  + service: controller와 DB간의 중간 계층(실제 서비스 로직을 담당)
    + 최대한 간결하게 달성하려는 목적만 명시적으로 표현
    + 데이터의 가공은 dto에서 해결
  + mapper: 컨테이너와 DB간 DAO(Data Access Object) 역할 담당
+ model: 서비스 로직에 종속되지 않는 객체 생성
  + dto: 클라이언트 <-> controller 간의 데이터 요청/응답 객체
    + 데이터의 가공 및 vo 객체에 데이터 바인딩 역할 담당
    + 무분별한 setter 사용 금지
    + 데이터 세팅이 필요할 때는 목적에 맞는 메소드명을 사용하여 set
    + naming prefix/postfix rule
      + 요청 시 req, 응답 시 res 를 prefix
      + `ex) reqMenuSearchDTO.java`
      + 검색 시 search, 저장 시 save, 수정 시 modify, 삭제 시 remove 를 postfix
      + `ex) reqMenuSaveDTO.java`
  + vo: 테이블과 매칭되는 객체
    + 해당 객체는 읽기전용으로 데이터를 바인딩하는 용도로 사용
    + getter를 사용한 데이터 조회만 가능, setter 금지
    + DAO 역할을 하는 Mapper
+ config: 라이브러리의 설정에 필요한 객체
+ common: 두 레이아웃 이외의 스프링 컨테이너에 필요한 객체
### 디렉토리 구조(resources 파일)
<pre>
├ resources
|   └ mybatis-mapper    
├ resources-local
└ resources-stg
</pre>
+ resources: 배포 환경과 상관없이 공통으로 적용되는 resources
  + mybatis-mapper: 각 Mapper 인터페이스와 매핑되는 실제 실행될 쿼리를 작성한 xml 파일
+ resources-local: 로컬 환경을 위한 JDBC 연결 정보 및 로그 설정 파일
+ resources-stg: 스테이징 환경을 위한 JDBC 연결 정보 및 로그 설정 파일
### API 작성 규칙
RESTFul API 작성을 위한 자체 컨벤션
- [API, REST API, RESTful API 개념정리](https://velog.io/@taeha7b/api-restapi-restfulapi)
- 목적에 맞는 메소드(get, post, put, fetch, delete) 사용
```java
@GetMapping     // 데이터를 조회하는 메소드
@PostMapping    // 데이터를 저장하는 메소드
@PutMapping     // 데이터의 모든 속성을 변경하는 메소드
@FetchMapping   // 데이터의 일부 속성을 변경하는 메소드
@DeleteMapping  // 데이터를 삭제하는 메소드
```
- 리소스는 최대한 간결하게 단수형으로 표현하고 prefix로 /api/v1 은 공통
  - uri 에 버전정보를 넣는 이유는 해당 API 가 외부통신용 API 일 때 고도화 작업으로 서비스 로직이 변경되었을 시 기존 api는 유지하고 버전정보로 새로운 버전의 api를 사용하여 기존 api 사용자의 서비스 장애를 예방
  - ```기존 사용자: /api/v1/sub/main, 이후 사용자: /api/v2/sub/main```
- uri 의 depth 는 최대 2depth 로 작성(sub -> main)
```java
@GetMapping("/api/v1/sub/main/{id}")
public SuccessResponse<ResMenuSearchDTO> getOneMenu(@PathVariable("id") String id) {
    MenuVO menu = menuService.getOneMenu(id);
    return new SuccessResponse<>(HttpStatus.OK, new ResMenuSearchDTO(menu));
}
```
- 응답 json 데이터에 요청 API 의 목적과 상관없는 속성을 반환하지 않는다.
  - 해당 API 사용 목적에 필요한 속성만 반환하는 DTO 를 별도로 만들어 사용한다.
- 로컬 API 테스트용 Swagger URL
  - [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)