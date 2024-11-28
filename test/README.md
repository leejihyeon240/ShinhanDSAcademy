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

Model : 값을 저장하는곳(request) <br>

![스크린샷 2024-11-28 101959](https://github.com/user-attachments/assets/c93ba565-1a77-4639-a688-4583f2e153bb)
