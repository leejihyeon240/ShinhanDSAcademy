### 선택자 <br>
- 전체선택자 : * <br>
- 태그 선택자  <br>
- 아이디 선택자 : # <br>
- 클래스 선택자 : . <br>
- 속성 선택자 : 선택자[속성명=속성값] <br>
- 다중 선택자 : 선택자, 선택자 ... <br>
- 자식 선택자 : 선택자 > 선택자 <br>
- 자손 선택자 :  <br>

### position <br>
- static : 기본값, 코딩한 순서(배치한 순서)대로 출력, top/left... 미적용 <br>
- relative : 상대적 위치, 고정되지않고, 상대위치에 따라 위치가 바뀜 <br>
- absolute : 절대값(부모태그:relative 기준) <br>
- fixed : 절대값(브라우저 기준) <br>

* 자식요소가 absolute이면, 부모요소는 relative(+height) <br>

* 자식요소 정가운데 배치 <br>
left : 부모넓이/2 - 자식넓이/2 <br>
top : 부모높이/2 - 자식높이/2 <br>

* 부모영역 넘치는 경우 숨김 <br>
overflow :hidden; <br>
- y축만 스크롤 <br>
overflow-y:scroll; <br>
