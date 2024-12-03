### chapter04 <br>
Controller <br>
### * url 매핑 <br>
@GetMapping, @PostMapping, @RequestMapping <br>
 
### * 응답
문자열 리턴(포워딩) : /WEB-INF/views/???.jsp <br>
void : /WEB-INF/views/[접속url].jsp <br>
리다이렉트 : 리턴(redirect:경로) <br>
서블릿방식 <br>
ModelAndView <br>
JSON <br>

### * 파라미터 받는 방법 <br>
1. HttpServletRequest(request) <br>
2. @RequestParam - 하나의 리터럴값, Map을 바인딩할 때 <br>
3. @ModelAttribute - 객체(내가 만든 클래스)를 바인딩할때 <br>
4. @PathVariable - 경로에 변수 값 저장 <br>

* 값 저장하는 방법  <br>
값 저장 - view에서 쓸려고  <br>
request, Model, ModelAndView  <br>
Model : 값을 저장하는곳(request) <br>

### Controller <br>
- url 매핑 <br>
- 파라미터 받기 <br>
- 비즈니스 로직 실행(Service) <br>
- 저장 (request) <br>
- 응답 <br>

### 개발 시 적용이 안 된다 <br>
project > clean <br>
alt+f5 > force <br>
tomcat clean <br>
tomcat work 삭제 <br>

chapter06 <br>
DB연동 <br>
DAO <-> MyBatis  <-> DB <br>
<br>
```
<mapper namespace="매퍼이름"> <br>
조회 : <select> <br>
등록 : <insert> <br>
수정 : <update> <br> 
삭제 : <delete> <br> 
</mapper> <br>
```
<br>
속성 <br>
id <br>
parameterType : 파라미터 자료형 <br>
resultType : 결과 자료형 <br>

### SqlSessionTemplate <br>
insert, update, delete <br>
selectOne : 한건 조회 <br>
selectList : 목록 조회 <br>
오버로딩 <br>
(식별자) <br>
(식별자, 파라미터) <br>
식별자 : namespace.id <br>

prepareStatemt -> ? <br>
#변수명# <br> 
statement -> 그대로 <br>
$변수명$ <br>

### 동적SQL (Dynamic SQL) <br>
<where> : WHERE 절 <br>
<if test="조건"> : 조건이 true인 경우 SQL에 포함 <br>

### chapter08 <br>
mybatis 두번째 <br>
DB : MariaDB로 변경 <br>

<forEach> 다중 검색 <br>
<include> <br>
<resultMap> <br>

![스크린샷 2024-11-28 101959](https://github.com/user-attachments/assets/c93ba565-1a77-4639-a688-4583f2e153bb)
